package teamDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import team.MemberManager;
import team.StartMenu;
import teamDTO.Member;

public class MemberDAO {
	
	
	// 싱글톤
	private MemberDAO() {
	}
	static private MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public ArrayList<Member> getMemberList(Connection con){
		
		ArrayList<Member> list = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}                                         // id -> 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(stmt != null) {

			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int inserMemberDTO(Connection con, Member mem) {
	    
		int result = 0;
		
		PreparedStatement pstmt = null;
		
	    try {
	    	String sql = "INSERT INTO MEMBER VALUES (member_idx_seq.nextval, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPassword());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getPhonenum());
			pstmt.setString(5, mem.getEmail());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// 내일 팀원들이랑 같이 수정
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			
			String sql = "update member set pw=?, name=?, phonenum=?, email=? where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPhonenum());
			pstmt.setString(4, member.getEmail());
			pstmt.setInt(5, member.getIdx());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// 회원삭제 가능한지 팀원상의후 결정
	public int deleteMember(Connection conn, int order) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from member where oidx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
}
