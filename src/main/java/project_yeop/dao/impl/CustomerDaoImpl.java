package project_yeop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project_yeop.dao.CustomerDao;
import project_yeop.db.JdbcConn;
import project_yeop.dto.Customer;
import project_yeop.dto.Grade;

public class CustomerDaoImpl implements CustomerDao {

	private static CustomerDaoImpl instance = new CustomerDaoImpl();	
	
	public static CustomerDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<Customer> selectCustomerByAll() {
		String sql = "select cNo, cName, gender, ponNumber, address, joinDate, unDelivered, count, cGrade from customer";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Customer> list = new ArrayList<>();
				do {
					list.add(getCustomer(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Customer getCustomer(ResultSet rs) throws SQLException {
		int cNo = rs.getInt("cNo");
		String cName = rs.getString("cName");		
		boolean gender = rs.getBoolean("gender");
		String ponNumber = rs.getString("ponNumber");	
		String address = rs.getString("address");	
		Date joinDate = rs.getDate("joinDate");
		int unDelivered = rs.getInt("unDelivered");;
		int count = rs.getInt("count");;
		Grade cGrade = new Grade(rs.getString("gGrade"));

		return new Customer(cNo, cName, gender, ponNumber, address, joinDate, unDelivered, count, cGrade);
	}

	@Override
	public Customer selectCustomerByNo(Customer customer) {
		String sql = "select cNo, cName, gender, ponNumber, address, joinDate, unDelivered, count, cGrade from customer where cNo=?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, customer.getcNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getCustomer(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertCustomer(Customer customer) {
		String sql = "insert into customer values(?,?,?,?,?,?,?,?)";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, customer.getcNo());
				pstmt.setString(2, customer.getcName());
				pstmt.setBoolean(3, customer.isGender());
				pstmt.setString(4, customer.getPonNumber());
				pstmt.setString(5, customer.getAddress());
				pstmt.setInt(6, customer.getUnDelivered());
				pstmt.setInt(7, customer.getCount());
				pstmt.setString(8,customer.getcGrade().getgGrade());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateCustomer(Customer customer) {
		String sql = "update customer set cName = ?, gender = ?, ponNumber = ?, address = ?, unDelivered = ?, count = ?, cGrade = ?"
				+ " where cNo =?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, customer.getcName());
				pstmt.setBoolean(2, customer.isGender());
				pstmt.setString(3, customer.getPonNumber());
				pstmt.setString(4, customer.getAddress());
				pstmt.setInt(5, customer.getUnDelivered());
				pstmt.setInt(6, customer.getCount());
				pstmt.setString(7,customer.getcGrade().getgGrade());
				pstmt.setInt(8, customer.getcNo());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteCustomer(Customer customer) {
		String sql = "delete from customer where cNo = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, customer.getcNo());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
