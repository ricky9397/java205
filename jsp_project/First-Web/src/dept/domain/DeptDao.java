package dept.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.util.ConnectionProvider;

public class DeptDao {
	
	private DeptDao() {}
	static private DeptDao dao = new DeptDao();
	public static DeptDao getInstance() { return dao; }
	
	
	public ArrayList<Dept> getList(){
		ArrayList<Dept> list = new ArrayList<Dept>();
		Connection conn = null;
		Statement stmt =null;
		ResultSet rs = null;
		
		
		try {
			String sql = "select * from dept";
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			System.out.println("연결");
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc =rs.getString("loc");
				
				list.add(new Dept(deptno, dname, loc));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
}
