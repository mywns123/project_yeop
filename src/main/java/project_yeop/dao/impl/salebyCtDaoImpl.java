package project_yeop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_yeop.dao.salebyCtDao;
import project_yeop.db.JdbcConn;
import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;
import project_yeop.dto.salebyCt;

public class salebyCtDaoImpl implements salebyCtDao {

	private static salebyCtDaoImpl instance =new salebyCtDaoImpl();
	
	
	public static salebyCtDaoImpl getInstance() {
		return instance;
	}


	@Override
	public List<salebyCt> selectSaleByCt() {
		String sql = "select cNo, cName, totalCount, totalPrice from salebyCt";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<salebyCt> list = new ArrayList<>();
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
	public salebyCt selectSaleByNo(salebyCt sale) {
		String sql = "select cNo, cName, totalCount, totalPrice from salebyCt where cNo=?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, sale.getCtTable().getCustomer().getcNo());
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

	private salebyCt getSale(ResultSet rs) throws SQLException {		
		CtTable ctTable = new CtTable(new Customer(rs.getInt("cNo")));		
		int totalCount = rs.getInt("totalCount");
		int totalPrice = rs.getInt("totalPrice");
		
		try {	
			ctTable.setCustomer(new Customer(rs.getInt("cNo"),rs.getString("cName")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new salebyCt(ctTable, totalCount, totalPrice);
	}	

}
