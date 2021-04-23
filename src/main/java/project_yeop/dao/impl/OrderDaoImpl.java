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
import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;
import project_yeop.dto.Grade;
import project_yeop.dto.Laundry;
import project_yeop.dto.OdTable;
import project_yeop.dto.Order;

public class OrderDaoImpl implements OrderDao {

	private static OrderDaoImpl instance =new OrderDaoImpl();
	
	public static OrderDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<OdTable> selectOrderByAll() {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<OdTable> list = new ArrayList<>();
				do {
					list.add(getOdTable(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private OdTable getOdTable(ResultSet rs) throws SQLException {
		Order order = null;
		CtTable ctTable = null;	
		Grade grade = null;
		Laundry laundry = null;	
		int price = rs.getInt("price");
		Date releaseDate = rs.getDate("releaseDate");
		
		try {
			order = new Order(rs.getInt("cNo"));
			ctTable = new CtTable((new Customer(rs.getInt("cNo"))));
			grade = new Grade(rs.getString("gGrade"));	
			laundry = new Laundry(rs.getString("lLaundryCode"));					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {	
			order.setComplete(rs.getBoolean("complete"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		try {	
			order.setColor(rs.getString("color"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {	
			order.setLaundryCount(rs.getInt("laundryCount"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {	
			order.setReceiveDate(rs.getDate("receiveDate"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {	
			order.setEct(rs.getString("ect"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {	
			ctTable.setCustomer(new Customer(rs.getInt("cName")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {	
			grade.setDiscountRate(rs.getInt("discountRate"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {	
			laundry.setProduct(rs.getString("product"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {	
			laundry.setUnitPrice(rs.getInt("unitPrice"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return new OdTable(order, ctTable, grade, laundry, price,releaseDate);
	}

	@Override
	public OdTable selectOrderByNo(OdTable odTable) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable where `no`=?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, odTable.getOrder().getNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getOdTable(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertOrder(Order order) {		
			String sql = "insert into `order`(ctNo, LaundryCode, color, laundryCount,etc) values(?,?,?,?,?)";
			try (Connection con = JdbcConn.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {					
					pstmt.setInt(2, order.getNo());									
					pstmt.setString(4, order.getLaundryCode().getlLaundryCode());
					pstmt.setString(5, order.getColor());
					pstmt.setInt(6, order.getLaundryCount());				
					pstmt.setString(9, order.getEct());
					return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
	}

	@Override
	public int updateOrder(Order order) {
		String sql = "update `order` set ctNo =? , LaundryCode =? , color =? , laundryCount =?,etc =? where `no` =?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, order.getCtNo().getcNo());					
				pstmt.setString(2, order.getLaundryCode().getlLaundryCode());
				pstmt.setString(3, order.getColor());
				pstmt.setInt(4, order.getLaundryCount());				
				pstmt.setString(5, order.getEct());	
				pstmt.setInt(6, order.getNo());
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
