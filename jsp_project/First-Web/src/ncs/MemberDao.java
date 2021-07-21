package ncs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDao {
	
	private MemberDao() {}
	static private MemberDao dao = new MemberDao();
	public static MemberDao getInstance() { return dao; }
	
	// 가입
	public int join(MemberDto dto) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into members values(?, ?, ?, sysdate)";
		
		try {
			conn = Driver.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close.close(conn);
			Close.close(pstmt);
		}
		return result;
	}
	
	// 로그인
	public int login(String id, String pw) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pw from members where id=?";
		
		try {
			conn = Driver.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(pw)) {
					return 1; // 로그인
				} else {
					return 0; // 비번틀림
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close.close(conn);
			Close.close(pstmt);
			Close.close(rs);
		}
		return -1;
	}
	
	public ArrayList<MemberDto> getMemberList(){
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from members";
		try {
			conn = Driver.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String times = rs.getString("times");
				
				MemberDto dto = new MemberDto(id, pw, name, times);
				list.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close.close(conn);
			Close.close(stmt);
			Close.close(rs);
		}
		return list;
	}
	
	
}
