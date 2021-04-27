package project_yeop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_yeop.dao.salebyDateDao;
import project_yeop.db.JdbcConn;
import project_yeop.dto.Laundry;
import project_yeop.dto.salebyDate;

public class salebyDateDaoImpl implements salebyDateDao {

	private static salebyDateDaoImpl instance =new salebyDateDaoImpl();
	
	
	public static salebyDateDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<salebyDate> selectSaleByYear() {
		String sql = "select `month`, totalCount, totalPrice from salebyDate group by `month`";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<salebyDate> list = new ArrayList<>();
				do {
					list.add(getSale(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<salebyDate> selectSaleByMonth() {
		String sql = "select `month`, lLaundryCode, totalCount, totalPrice from salebyDate";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<salebyDate> list = new ArrayList<>();
				do {
					list.add(getSale1(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public salebyDate selectSaleByNo(salebyDate sale) {
		String sql = "select `month`, lLaundryCode, totalCount, totalPrice from salebyDate where `month`=?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, sale.getMonth());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getSale(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private salebyDate getSale(ResultSet rs) throws SQLException {	
		int month = rs.getInt("month");		
		int totalCount = rs.getInt("totalCount");
		int totalPrice = rs.getInt("totalPrice");
		return new salebyDate(month, totalCount, totalPrice);
	}
	
	private salebyDate getSale1(ResultSet rs) throws SQLException {	
		int month = rs.getInt("month");
		Laundry lLaundryCode = new Laundry(rs.getString("lLaundryCode"));
		int totalCount = rs.getInt("totalCount");
		int totalPrice = rs.getInt("totalPrice");
		return new salebyDate(month, lLaundryCode, totalCount, totalPrice);
	}

}
