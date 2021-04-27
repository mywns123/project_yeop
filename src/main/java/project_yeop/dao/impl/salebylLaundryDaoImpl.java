package project_yeop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_yeop.dao.salebylLaundryDao;
import project_yeop.db.JdbcConn;
import project_yeop.dto.Laundry;
import project_yeop.dto.salebylLaundry;

public class salebylLaundryDaoImpl implements salebylLaundryDao {

	private static salebylLaundryDaoImpl instance =new salebylLaundryDaoImpl();
	
	
	public static salebylLaundryDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<salebylLaundry> selectSaleByAll() {
		String sql = "select lLaundryCode, totalCount, totalPrice from salebylLaundry";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<salebylLaundry> list = new ArrayList<>();
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

	private salebylLaundry getSale(ResultSet rs) throws SQLException {		
		Laundry lLaundryCode = new Laundry(rs.getString("lLaundryCode"));
		int totalCount = rs.getInt("totalCount");
		int totalPrice = rs.getInt("totalPrice");
		return new salebylLaundry(lLaundryCode, totalCount, totalPrice);
	}

	@Override
	public salebylLaundry selectSaleByNo(salebylLaundry sale) {
		String sql = "select lLaundryCode, totalCount, totalPrice from salebylLaundry where lLaundryCode=?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, sale.getlLaundryCode().getlLaundryCode());
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


}
