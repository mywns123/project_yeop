package project_yeop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_yeop.dao.SalesDao;
import project_yeop.db.JdbcConn;
import project_yeop.dto.Laundry;
import project_yeop.dto.Sales;

public class SalesDaoImpl implements SalesDao {

	private static SalesDaoImpl instance =new SalesDaoImpl();
	
	
	public static SalesDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Sales> selectSalesByAll() {
		String sql = "select sNo, lLaundryCode, totalCount, totalSales from sales";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Sales> list = new ArrayList<>();
				do {
					list.add(getSales(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Sales getSales(ResultSet rs) throws SQLException {
		int sNo = rs.getInt("sNo");;
		Laundry lLaundryCode = new Laundry(rs.getString("lLaundryCode"));
		int totalCount = rs.getInt("totalCount");;
		int totalSales = rs.getInt("totalSales");;
		return new Sales(sNo, lLaundryCode, totalCount, totalSales);
	}

	@Override
	public Sales selectSalesByNo(Sales sales) {
		String sql = "select sNo, lLaundryCode, totalCount, totalSales from sales where sNo=?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, sales.getsNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getSales(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertSales(Sales sales) {		
			String sql = "insert into sales values(?,?,?,?)";
			try (Connection con = JdbcConn.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
					pstmt.setInt(1, sales.getsNo());
					pstmt.setString(2, sales.getlLaundryCode().getlLaundryCode());				
					pstmt.setInt(3, sales.getTotalCount());
					pstmt.setInt(4, sales.getTotalSales());					
					return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
	}

	@Override
	public int updateSales(Sales sales) {
		String sql = "update sales set lLaundryCode, totalCount, totalSales where sNo =?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {			
				pstmt.setString(1, sales.getlLaundryCode().getlLaundryCode());				
				pstmt.setInt(2, sales.getTotalCount());
				pstmt.setInt(3, sales.getTotalSales());	
				pstmt.setInt(4, sales.getsNo());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteSales(Sales sales) {
		String sql = "delete from sales where sNo = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, sales.getsNo());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
