package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.CloseDB;

public class MemberDao {


	// 싱글톤처리
	private MemberDao() {}
	static private MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}

	
	
	//모든 회원의 정보 읽기
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
			}                                        

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseDB.dbClose(rs);
			CloseDB.dbClose(stmt);
		}

		return list;
	}

	
	//회원테이블에 새로운 회원 추가하기 (회원가입)
	public int insertMember(Connection con, Member mem) {

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
			CloseDB.dbClose(pstmt);
		}
		return result;
	}

	
	// 로그인한 회원의 정보 수정
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
			CloseDB.dbClose(pstmt);
		}
		return result;
	}

}

