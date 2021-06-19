package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dept.DeptDao;

public class EmpDao {
	
	// 싱글톤
	// 1. 외부 클래스 또는 인스턴스에서 해당 클래스로 인스턴스를 생성하지 못하도록 처리
	private EmpDao() {
	}

	// 2. 클래스 내부에서 인스턴스를 만들고 메소드를 통해서 반환 하도록 처리
	static private EmpDao dao = new EmpDao();

	// 3. 메소드를 통해서 반환 하도록 처리
	public static EmpDao getInstance() {
		return dao;
	}

	
	// 1. 전체 데이터 검색기능
	// Connection 클래스 => 연결객체
	ArrayList<Emp> getdeptList(Connection con) {
		
		ArrayList<Emp> list = null;
		
		// sql을 실행 할 메소드 제공
		Statement stmt = null;
		// executeQuery() 반환타입 -> select의 결과(표)를 담는 객체
		ResultSet rs = null;
		
		
		try {
			stmt = con.createStatement();
			String sql = "select * from emp";
			
			// 결과 받아오기
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<>();
			
			// 데이터를 Dept 객체로 생성 -> list에 저장
			while(rs.next()) {
				list.add(new Emp(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4), 
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
		}
		return list;
	}
	
	// 2. EMP 테이블에 데이터 자장하는 메소드
	int insertEmp(Connection con, Emp emp)	{
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) " 
								+"values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// 3. EMP 테이블의 데이터 수정 메소드
	int updateEmp(Connection con, Emp emp) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "update emp set sal=? where ename=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emp.getEname());
			pstmt.setInt(2, emp.getSal());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// 4. EMP 테이블의 데이터를 삭제
	int deleteEmp(Connection con, int empno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "delete from emp where empno=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
