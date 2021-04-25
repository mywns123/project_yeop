package project_yeop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_yeop.dao.SaleDao;
import project_yeop.db.JdbcConn;
import project_yeop.dto.Laundry;
import project_yeop.dto.Sale;

public class SaleDaoImpl implements SaleDao {

	private static SaleDaoImpl instance =new SaleDaoImpl();
	
	
	public static SaleDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Sale> selectSaleByAll() {
		String sql = "select lLaundryCode, totalCount, totalPrice from sale";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Sale> list = new ArrayList<>();
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

	private Sale getSale(ResultSet rs) throws SQLException {		
		Laundry lLaundryCode = new Laundry(rs.getString("lLaundryCode"));
		int totalCount = rs.getInt("totalCount");
		int totalPrice = rs.getInt("totalPrice");
		return new Sale(lLaundryCode, totalCount, totalPrice);
	}

	@Override
	public Sale selectSaleByNo(Sale sale) {
		String sql = "select lLaundryCode, totalCount, totalPrice from sale where lLaundryCode=?";
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
