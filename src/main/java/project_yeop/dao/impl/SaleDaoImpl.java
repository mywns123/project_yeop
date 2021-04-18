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
		String sql = "select sNo, lLaundryCode, totalCount, totalSales from sales";
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
		int sNo = rs.getInt("sNo");;
		Laundry lLaundryCode = new Laundry(rs.getString("lLaundryCode"));
		int totalCount = rs.getInt("totalCount");;
		int totalSales = rs.getInt("totalSales");;
		return new Sale(sNo, lLaundryCode, totalCount, totalSales);
	}

	@Override
	public Sale selectSaleByNo(Sale sale) {
		String sql = "select sNo, lLaundryCode, totalCount, totalSales from sales where sNo=?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, sale.getsNo());
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

	@Override
	public int insertSale(Sale sale) {		
			String sql = "insert into sales values(?,?,?,?)";
			try (Connection con = JdbcConn.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
					pstmt.setInt(1, sale.getsNo());
					pstmt.setString(2, sale.getlLaundryCode().getlLaundryCode());				
					pstmt.setInt(3, sale.getTotalCount());
					pstmt.setInt(4, sale.getTotalSales());					
					return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
	}

	@Override
	public int updateSale(Sale sale) {
		String sql = "update sales set lLaundryCode, totalCount, totalSales where sNo =?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {			
				pstmt.setString(1, sale.getlLaundryCode().getlLaundryCode());				
				pstmt.setInt(2, sale.getTotalCount());
				pstmt.setInt(3, sale.getTotalSales());	
				pstmt.setInt(4, sale.getsNo());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteSale(Sale sale) {
		String sql = "delete from sales where sNo = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, sale.getsNo());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
