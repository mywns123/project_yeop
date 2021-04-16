package project_yeop.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import project_yeop.dao.OrderDao;
import project_yeop.db.JdbcConn;
import project_yeop.dto.Customer;
import project_yeop.dto.Laundry;
import project_yeop.dto.Order;

public class OrderDaoImpl implements OrderDao {

	private static OrderDaoImpl instance =new OrderDaoImpl();
	
	public static OrderDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Order> selectOrderByAll() {
		String sql = "select complete, `no`, ctNo, LaundryCode, color, laundryCount, totalPrice, receiveDate, releaseDate, etc from `order`;";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Order> list = new ArrayList<>();
				do {
					list.add(getOrder(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Order getOrder(ResultSet rs) throws SQLException {
		boolean complete = rs.getBoolean("complete");
		int no = rs.getInt("no");
		Customer cNo = new Customer(rs.getInt("cNo"));
		Laundry LaundryCode = new Laundry(rs.getString("lLaundryCode"));
		String color= rs.getString("color");
		int laundryCount= rs.getInt("laundryCount");
		int totalPrice= rs.getInt("totalPrice");
		Date receiveDate= rs.getDate("receiveDate");
		Date releaseDate= rs.getDate("releaseDate");
		String ect = rs.getString("ect");
		return new Order(complete, no, cNo, LaundryCode, color, laundryCount, totalPrice, receiveDate, releaseDate, ect);
	}

	@Override
	public Order selectOrderByNo(Order order) {
		String sql = "select complete, `no`, ctNo, LaundryCode, color, laundryCount, totalPrice, receiveDate, releaseDate, etc from `order` where `no`=?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, order.getNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getOrder(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertOrder(Order order) {		
			String sql = "insert into `order` values(?,?,?,?,?,?,?,?,?)";
			try (Connection con = JdbcConn.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
					pstmt.setBoolean(1, order.isComplete());
					pstmt.setInt(2, order.getNo());
					pstmt.setInt(3, order.getcNo().getcNo());					
					pstmt.setString(4, order.getLaundryCode().getlLaundryCode());
					pstmt.setString(5, order.getColor());
					pstmt.setInt(6, order.getLaundryCount());
					pstmt.setInt(7, order.getTotalPrice());					
					pstmt.setDate(8, order.getReleaseDate());
					pstmt.setString(9, order.getEct());
					return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
	}

	@Override
	public int updateOrder(Order order) {
		String sql = "update `order` set complete, ctNo, LaundryCode, color, laundryCount, totalPrice, receiveDate, releaseDate, etc where `no` =?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setBoolean(1, order.isComplete());				
				pstmt.setInt(2, order.getcNo().getcNo());					
				pstmt.setString(3, order.getLaundryCode().getlLaundryCode());
				pstmt.setString(4, order.getColor());
				pstmt.setInt(5, order.getLaundryCount());
				pstmt.setInt(6, order.getTotalPrice());					
				pstmt.setDate(7, order.getReleaseDate());
				pstmt.setString(8, order.getEct());	
				pstmt.setInt(9, order.getNo());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteOrder(Order order) {
		String sql = "delete from `order` where `no` = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, order.getNo());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
