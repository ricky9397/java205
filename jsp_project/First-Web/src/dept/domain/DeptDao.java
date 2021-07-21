package dept.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.util.ConnectionProvider;
import jdbc.util.jdbcUtil;

public class DeptDao {

	// 싱글톤패턴
	// 1. 인스턴스 생성을 막는다.
	private DeptDao() {
	}

	// 2. 클래스 내부에서 인스턴스를 생성!
	static private DeptDao dao = new DeptDao();

	// 3. 외부에서 참조값을 반환 받을수 있는 메소드
	public static DeptDao getInstance() {
		return dao;
	}

	public ArrayList<Dept> getDeptList(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Dept> list = null;

		try {
			String sql = "select * from dept";
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			list = new ArrayList<Dept>();
			while (rs.next()) {
				list.add(new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(stmt);
		}
		return list;
	}

	public int insertDept(Connection conn, Dept dept) {

		int resultCnt = 0;

		PreparedStatement pstmt = null;

		String sql = "insert into dept values(?, ?, ?)";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

	public int deleteDept(Connection conn, int deptno) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from dept where deptno = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

	// dept 번호 가져옴
	public Dept selectByDeptno(Connection conn, int deptno) {

		Dept dept = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dept where deptno=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(pstmt);
			jdbcUtil.close(rs);
		}

		return dept;
	}

	// 수정
	public int updateDept(Connection conn, Dept dept) {

		int resultCnt = 0;

		PreparedStatement pstmt = null;

		String sql = "update dept set dname=?, loc=? where deptno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(pstmt);
		}

		return resultCnt;

	}

	// 따로 메소드 만들어서 중복 코드량을 줄일 수 있다. (위에 사용아직안함)
	private Dept makeDept(ResultSet rs) throws SQLException {

		Dept dept = new Dept();
		dept.setDeptno(rs.getInt("deptno"));
		dept.setDname(rs.getString("dname"));
		dept.setLoc(rs.getString("loc"));
		return dept;
	}

}
