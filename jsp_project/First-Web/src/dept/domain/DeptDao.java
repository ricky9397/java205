package dept.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.util.ConnectionProvider;
import jdbc.util.jdbcUtil;

public class DeptDao {
	
	private DeptDao() {}
	static private DeptDao dao = new DeptDao();
	public static DeptDao getInstance() { return dao; }
	
	
	public ArrayList<Dept> getDeptList(Connection conn){
		Statement stmt =null;
		ResultSet rs = null;
		ArrayList<Dept> list = null;
		
		
		try {
			String sql = "select * from dept";
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<Dept>();
			while(rs.next()) {
				list.add(new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn);
			jdbcUtil.close(rs);
			jdbcUtil.close(stmt);
		}
		return list;
	}
	
}
