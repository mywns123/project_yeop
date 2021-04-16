package project_yeop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_yeop.dao.LaundryDao;
import project_yeop.db.JdbcConn;
import project_yeop.dto.Laundry;

public class LaundryDaoImpl implements LaundryDao {

	private static LaundryDaoImpl instance =new LaundryDaoImpl();
	
	public static LaundryDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Laundry> selectLaundryByAll() {
		String sql = "select lLaundryCode, product, unitPrice from laundry";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Laundry> list = new ArrayList<>();
				do {
					list.add(getLaundry(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Laundry getLaundry(ResultSet rs) throws SQLException {
		String lLaundryCode = rs.getString("lLaundryCode");
		String product = rs.getString("product");
		int unitPrice = rs.getInt("unitPrice");
		return new Laundry(lLaundryCode, product, unitPrice);
	}

	@Override
	public Laundry selectLaundryByNo(Laundry laundry) {
		String sql = "select lLaundryCode, product, unitPrice from laundry where lLaundryCode=?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, laundry.getlLaundryCode());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getLaundry(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertLaundry(Laundry laundry) {		
			String sql = "insert into Laundry values(?,?,?)";
			try (Connection con = JdbcConn.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {					
					pstmt.setString(1, laundry.getlLaundryCode());
					pstmt.setString(2, laundry.getProduct());
					pstmt.setInt(3, laundry.getUnitPrice());					
					return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
	}

	@Override
	public int updateLaundry(Laundry laundry) {
		String sql = "update Laundry set product =?, unitPrice = ? where lLaundryCode =?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {			
				pstmt.setString(1, laundry.getProduct());
				pstmt.setInt(2, laundry.getUnitPrice());
				pstmt.setString(3, laundry.getlLaundryCode());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteLaundry(Laundry laundry) {
		String sql = "delete from Laundry where lLaundryCode = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, laundry.getlLaundryCode());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
