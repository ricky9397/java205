package teamDAO;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminMemberDao {
	// 싱글톤 패턴 : 여러개의 인스턴스를 생성하지 못하도록 하는 코딩 스타일
	// 1. 외부 클래스 또는 인스턴스에서 해당 클래스로 인스턴스를 생성하지 못하도록 처리
	private AdminMemberDao() {

	}

	// 2. 클래스 내부에서 인스턴스를 만들고
	static AdminMemberDao dao = new AdminMemberDao(); 

	// 3. 메소드를 통해서 반환하도록 처리
	public static AdminMemberDao getInstance() {
		return dao;
	}




	// 모든 회원데이터 검색 리스트
	ArrayList<Member> getMemberList(Connection conn) {

		ArrayList<Member> list = null;

		// 데이터 베이스의 Member테이블 이용 select 결과를 -> list 저장
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from member order by idx";

			// 결과 받아오기
			rs = stmt.executeQuery(sql);

			list = new ArrayList<>();

			// 데이터를 Member 객체로 생성 -> list에 저장
			while (rs.next()) {

				Member d = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(d);
			}

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

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return list;
	}


	// 사용자로부터 idx 받아서 해당 회원 휴면계정으로 전환
	// 휴면계정 : 회원번호(idx)제외하고 모든 값을 0000으로 변경
	int dormancyMember(Connection conn, Member member) {

		int result = 0;
		// 데이터 베이스 처리 sql
		PreparedStatement pstmt = null;

		//			// 2. 연결
		//			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		//			String user = "hr";
		//			String pw = "tiger";

		try {
			String Sql = "UPDATE MEMBER SET ID = '0000', PW = '0000', NAME = '휴면', PHONENUM = '0000',  EMAIL = '0000' WHERE idx = ?";

			pstmt = conn.prepareStatement(Sql);
			pstmt.setInt(1, member.getIdx());

			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( pstmt != null) {
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
}
