package project_yeop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_yeop.dao.CustomerDao;
import project_yeop.db.JdbcConn;
import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private static CustomerDaoImpl instance = new CustomerDaoImpl();	
	
	public static CustomerDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<CtTable> selectCustomerByAll() {
		String sql = "select cNo, cName, gender, ponNumber, address, joinDate, unDelivered, count, cGrade from ctTable";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<CtTable> list = new ArrayList<>();
				do {
					list.add(getCtTable(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private CtTable getCtTable(ResultSet rs) throws SQLException {
		Customer customer = null;		
		int unDelivered = rs.getInt("unDelivered");
		int count = rs.getInt("count");
		String cGrade =rs.getString("cGrade");		
		
		try {
			customer = new Customer(rs.getInt("cNo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			customer.setcName(rs.getString("cName"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			customer.setGender(rs.getBoolean("gender"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			customer.setPonNumber(rs.getString("ponNumber"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			customer.setAddress(rs.getString("address"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			customer.setJoinDate(rs.getDate("joinDate"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new CtTable(customer, unDelivered, count, cGrade);
	}

	@Override
	public CtTable selectCustomerByNo(CtTable ctTable) {
		String sql = "select cNo, cName, gender, ponNumber, address, joinDate, unDelivered, count, cGrade from ctTable"
				   + " where cNo = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, ctTable.getCustomer().getcNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getCtTable(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertCustomer(Customer customer) {
		String sql = "insert into customer(cName, gender, ponNumber, address) values(?,?,?,?)";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {				
				pstmt.setString(1, customer.getcName());
				pstmt.setBoolean(2, customer.isGender());
				pstmt.setString(3, customer.getPonNumber());
				pstmt.setString(4, customer.getAddress());				
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateCustomer(Customer customer) {
		String sql = "update customer set cName = ?, gender = ?, ponNumber = ?, address = ?  where cNo = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, customer.getcName());
				pstmt.setBoolean(2, customer.isGender());
				pstmt.setString(3, customer.getPonNumber());
				pstmt.setString(4, customer.getAddress());				
				pstmt.setInt(5, customer.getcNo());
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
