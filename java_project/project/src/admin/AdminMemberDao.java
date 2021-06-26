package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import member.Member;

public class AdminMemberDao {

	//싱글톤 처리
	private AdminMemberDao() {}
	static AdminMemberDao dao = new AdminMemberDao(); 
	public static AdminMemberDao getInstance() {
		return dao;
	}



	// 모든 회원데이터 검색 리스트
	ArrayList<Member> getMemberList(Connection conn) {

		ArrayList<Member> list = null;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from member order by idx";

			rs = stmt.executeQuery(sql);

			list = new ArrayList<>();

			while (rs.next()) {
				Member d = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			CloseDB.dbClose(rs);
			CloseDB.dbClose(stmt);

		}

		return list;
	}


	// 관리자로부터 회원번호(idx) 입력 받아서 해당 회원 휴면계정으로 전환
	// 휴면계정 : 회원번호(idx)제외하고 모든 값을 0000으로 변경 ( 주문내역 삭제하지 않기위해)
	int dormancyMember(Connection conn, Member member) {

		int result = 0;

		PreparedStatement pstmt = null;


		try {
			String Sql = "UPDATE MEMBER SET ID = '0000', PW = '0000', NAME = '휴면', PHONENUM = '0000',  EMAIL = '0000' WHERE idx = ?";

			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, member.getIdx());

			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseDB.dbClose(pstmt);
		}

		return result;
	}


}