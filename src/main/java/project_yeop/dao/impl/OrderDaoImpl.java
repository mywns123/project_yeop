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

	private static OrderDaoImpl instance = new OrderDaoImpl();

	public static OrderDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<OdTable> selectOdTableByAll() {
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
			order = new Order(rs.getInt("no"));
			ctTable = new CtTable(new Customer(rs.getInt("cNo")));
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
			order.setEtc(rs.getString("etc"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			ctTable.setCustomer(new Customer(rs.getInt("cNo"), rs.getString("cName")));
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

		return new OdTable(order, ctTable, grade, laundry, price, releaseDate);
	}

	@Override
	public OdTable selectOdTableByNo(OdTable odTable) {
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
			pstmt.setInt(1, order.getCtNo().getcNo());
			pstmt.setString(2, order.getLaundryCode().getlLaundryCode());
			pstmt.setString(3, order.getColor());
			pstmt.setInt(4, order.getLaundryCount());
			pstmt.setString(5, order.getEtc());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateOrder(Order order) {
		String sql = "update `order` set ctNo =? , LaundryCode =? , color =? , laundryCount =?,etc =? where `no` =?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, order.getCtNo().getcNo());
			pstmt.setString(2, order.getLaundryCode().getlLaundryCode());
			pstmt.setString(3, order.getColor());
			pstmt.setInt(4, order.getLaundryCount());
			pstmt.setString(5, order.getEtc());
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

	@Override
	public int relOrder(Order order) {
		String sql = "update `order` set complete = true where  `no`=?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, order.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<OdTable> selectOdTableByNo(int no) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where `no` = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, no);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableBycNo(int cno) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where cNo = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, cno);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableBycName(String cName) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where cName = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, cName);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableByCode(String code) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where lLaundryCode = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, code);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableByProduct(String product) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where product = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, product);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<OdTable> selectOdTableUnComplete() {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where complete = false";
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
	@Override
	public List<OdTable> selectOdTableUnCompleteByNo(int no) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where complete = false and `no` = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, no);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableUnCompleteBycNo(int cno) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where complete = false and cNo = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, cno);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableUnCompleteBycName(String cName) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where complete = false and cName = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, cName);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableUnCompleteByCode(String code) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where complete = false and lLaundryCode = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, code);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableUnCompleteByProduct(String product) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where complete = false and product = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, product);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableReleaseDate() {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where complete = false and releaseDate < now()";
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
	
	@Override
	public List<OdTable> selectOdTableReleaseDateByNo(int no) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where complete = false and releaseDate < now() and `no` = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, no);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableReleaseDateBycNo(int cno) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where complete = false and releaseDate < now() and cNo = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, cno);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableReleaseDateBycName(String cName) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where complete = false and releaseDate < now() and cName = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, cName);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableReleaseDateByCode(String code) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where complete = false and releaseDate < now() and lLaundryCode = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, code);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OdTable> selectOdTableReleaseDateByProduct(String product) {
		String sql = "select complete, `no`, cNo, cName, gGrade, discountRate, color, lLaundryCode, product, unitPrice, laundryCount, price, receiveDate, releaseDate, etc from odTable"
				+ "  where complete = false and releaseDate < now() and product = ? ";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, product);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<OdTable> list = new ArrayList<>();
					do {
						list.add(getOdTable(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	

}
