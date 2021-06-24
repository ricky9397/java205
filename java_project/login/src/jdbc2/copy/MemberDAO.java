package jdbc2.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	//싱글톤
	MemberDAO() {
	}
	static private MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	
	ArrayList<MemberDTO> list = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	ArrayList<MemberDTO> getMemberList(Connection con){
		
		ArrayList<MemberDTO> list = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
		}
		
		if(stmt != null) {

			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	int inserMemberDTO(Connection con, MemberDTO mem) {
	    
		int result = 0;
		
		PreparedStatement pstmt = null;
		
	    try {
	    	String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPw());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getPhone());
			pstmt.setString(5, mem.getEmail());
			
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
	
	public MemberDTO login (String id, String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select pw from member where id=?";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(pw)) {
					System.out.println("로그인성공");
					return null  ; //로그인성공
				} else {
					System.out.println("비밀번호 틀리셨습니다.");
					return null; // 비밀번호틀림
				}
			}
			System.out.println("아이디가없습니다.");
			return null; // 아이디없음
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("데이터베이스오류");
		return null ; // 오류
		
	}
	
}
