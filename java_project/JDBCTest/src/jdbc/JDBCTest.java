package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		
		// 바깥에 객체 변수들을 만들어준다.
		// 연결 객체 : 연결정보를 가진다.
		Connection conn = null;
		// sql을 실행 할 메소드 제공
		Statement stmt = null;
		// executeQuery() 반환타입 -> select의 결과(표)를 담는 객체
		ResultSet rs = null;
		// Statement -> PreparedStatement : 성능개선
		PreparedStatement pstmt = null;
		
		
		// 1. 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공!");
			
			// 2. 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe"; 
			String user = "hr";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl, user, pw); 
			System.out.println("데이터베이스 연결 성공");
			
			// 3. SQL 처리
			stmt = conn.createStatement();
			
			String sqlSelect = "select * from dept order by deptno";
			
			
			rs = stmt.executeQuery(sqlSelect);
			
			// rs.next() -> 다음행의 존재 유무 확인
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				System.out.print(deptno+"\t");
				String dname = rs.getString("dname");
				System.out.print(dname+"\t");
				String loc = rs.getString("loc");
				System.out.println(loc+"\t");
			}
			
			//////////////////////////////////////////////////////////////
			// PreparedStatement -> SQL 먼저 등록 -> 매개변수처럼 ?를 이용해서 나중에 변수를 바인딩
			
			System.out.println("===============================================");
			System.out.println("PrepareStatement 사용");
			
			String sqlSelect2 = "select * from dept where deptno = ? ";
			pstmt = conn.prepareStatement(sqlSelect2);	// Connection의 메서드를 불러와 사용
			// ? 변수의 데이터 바인딩
			pstmt.setInt(1, 10);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				System.out.print(deptno+"\t");
				String dname = rs.getString("dname");
				System.out.print(dname+"\t");
				String loc = rs.getString("loc");
				System.out.println(loc+"\t");
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾지못함!!!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패!!!");
			e.printStackTrace();
		} finally {
			
			
			// 4. close
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			if(conn != null) {
				try {
					conn.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
