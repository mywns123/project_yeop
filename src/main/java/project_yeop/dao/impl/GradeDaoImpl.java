package project_yeop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project_yeop.dao.GradeDao;
import project_yeop.db.JdbcConn;
import project_yeop.dto.Grade;

public class GradeDaoImpl implements GradeDao {

	private static GradeDaoImpl instance = new GradeDaoImpl();

	public static GradeDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Grade> selectGradeByAll() {
		String sql = "select gGrade, losal, hiosal, discountRate from grade order by field(gGrade,'S','A','B','C')";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Grade> list = new ArrayList<>();
				do {
					list.add(getGrade(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Grade getGrade(ResultSet rs) throws SQLException {
		String gGrade = rs.getString("gGrade");
		int losal = rs.getInt("losal");
		int hiosal = rs.getInt("hiosal");
		int discountRate = rs.getInt("discountRate");
		return new Grade(gGrade,losal, hiosal,discountRate);
	}

	@Override
	public Grade selectGradeByNo(Grade grade) {
		String sql = "select gGrade, losal, hiosal, discountRate from grade where gGrade=?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, grade.getgGrade());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getGrade(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertGrade(Grade grade) {
		String sql = "insert into grade values(?,?,?,?)";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, grade.getgGrade());
				pstmt.setInt(2, grade.getLosal());
				pstmt.setInt(3, grade.getHiosal());
				pstmt.setInt(4, grade.getDiscountRate());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateGrade(Grade grade) {
		String sql = "update grade set losal =?, hiosal =?, discountRate = ? where gGrade =?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, grade.getLosal());
				pstmt.setInt(2, grade.getHiosal());
				pstmt.setInt(3, grade.getDiscountRate());
				pstmt.setString(4, grade.getgGrade());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteGrade(Grade grade) {
		String sql = "delete from grade where gGrade = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, grade.getgGrade());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	

}
