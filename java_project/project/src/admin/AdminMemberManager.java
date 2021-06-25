package admin;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import teamDAO.AdminMemberDao;
import teamDTO.Member;

public class AdminMemberManager {
	private AdminMemberDao dao;
	private Scanner sc;
	private static Connection conn = DBconn.getConnection();

	public AdminMemberManager(AdminMemberDao dao) {
		this.dao = dao;
		sc = new Scanner(System.in);
	}

	// 회원 정보 리스트
	// 전체 리스트 출력 메소드
	// AdminMember 에서 데이터 리스트를 받고 출력 처리
	void AdminMemberList() {

		//		// Connection 객체 생성 -> 트렌젝션 처리
		//		Connection conn = null;

		//		// 2. 연결
		//		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		//		String user = "hr";
		//		String pw = "tiger";
		try {
			//			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			List<Member> list = dao.getMemberList(conn);
			System.out.println("==============================");
			System.out.println("회원 정보 리스트");
			System.out.println("-----------------------------");
			System.out.println("회원번호 \t 아이디 \t 비밀번호 \t  이름 \t 연락처 \t 이메일");
			System.out.println("-----------------------------");

			for (Member Member : list) {
				System.out.printf("%d\t %s\t  %s \t %s\t %s\t  %s\t \n", Member.getIdx(), Member.getId(), Member.getPassword(), Member.getName(), Member.getPhonenum(), Member.getEmail());
			}

			System.out.println("-----------------------------");


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	// 휴면계정으로 변경할 데이터의 회원번호 입력 
	// 해당 회원번호의 데이터 수정
	void AdminMemberChange() {
		// Connection 객체 생성 -> 트렌젝션 처리
		//	      Connection conn = null;

		//	      Member member = new Member();


		try {
			//	         conn = DriverManager.getConnection(jdbcUrl, user, pw);

			AdminMemberList();
			System.out.println("휴면계정 설정을 원하시는 회원의 회원번호를 입력해주세요.");
			int idx = sc.nextInt();


			Member member = new Member(idx);

			int result = dao.dormancyMember(conn, member);
			System.out.println("해당 회원이 휴면계정으로 전환됩니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
