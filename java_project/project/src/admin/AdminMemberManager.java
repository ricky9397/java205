package admin;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import member.Member;

public class AdminMemberManager {
	private AdminMemberDao dao;
	private Scanner sc;
	private static Connection conn = DBconn.getConnection();
	
	public AdminMemberManager(AdminMemberDao dao) {
		this.dao = dao;
		sc = new Scanner(System.in);
	}

	// 모든 회원 정보 리스트
	void AdminMemberList() {

		try {

			List<Member> list = dao.getMemberList(conn);
			System.out.println("======================================================================");
			System.out.println("회원 정보 리스트");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("회원번호 \t 아이디 \t 비밀번호 \t  이름 \t 연락처 \t 이메일");
			System.out.println("----------------------------------------------------------------------");

			for (Member Member : list) {
				System.out.printf("%d\t %s\t  %s \t %s\t %s\t  %s\t \n", Member.getIdx(), Member.getId(), Member.getPassword(), Member.getName(), Member.getPhonenum(), Member.getEmail());
			}

			System.out.println("----------------------------------------------------------------------");
	

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	// 휴면계정으로 변경할 데이터의 회원번호 입력 
	// 해당 회원번호의 데이터 수정
	   void AdminMemberChange() {

		   try {
	         
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