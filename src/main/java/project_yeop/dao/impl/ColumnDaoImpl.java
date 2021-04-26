package project_yeop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_yeop.dao.ColumnDao;
import project_yeop.db.JdbcConn;
import project_yeop.dto.Column;

public class ColumnDaoImpl implements ColumnDao {
	private static ColumnDaoImpl instance = new ColumnDaoImpl();

	public static ColumnDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Column> selectCtTableColumns() {
		String sql = "SELECT  COLUMN_NAME FROM INFORMATION_SCHEMA.columns WHERE TABLE_NAME = 'ctTable'";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Column> list = new ArrayList<>();
				do {
					list.add(getColumn(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Column getColumn(ResultSet rs) throws SQLException {
		String column_name = rs.getString("COLUMN_NAME");
		return new Column(column_name);
	}

	@Override
	public List<Column> selectOdTableColumns() {
		String sql = "SELECT  COLUMN_NAME FROM INFORMATION_SCHEMA.columns WHERE TABLE_NAME = 'odTable'";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Column> list = new ArrayList<>();
				do {
					list.add(getColumn(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
