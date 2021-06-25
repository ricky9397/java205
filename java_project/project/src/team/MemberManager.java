package team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import teamDAO.MemberDAO;
import teamDTO.Member;


public class MemberManager {
	Scanner sc = new Scanner(System.in);
	List<Member> m ;
	private MemberDAO dao;
	Member member;
	OrderManager o;
	static int idx;

	public MemberManager(MemberDAO mem) {
		m = new ArrayList<>();
		o = new OrderManager();
		this.dao = mem;
		member = new Member();
	}

	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "tiger";

	// 회원 정보리스트 수정 필요 
	void MemberList() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			m = dao.getMemberList(conn);

			System.out.println("회원 정보 리스트");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("id\t pw\t 이름\t 번호\t 메일");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

			for(Member md : m) {
				System.out.printf("%s\t %s\t %s\t %s\t %s \n",
						md.getIdx(),
						md.getId(), 
						md.getPassword(),
						md.getName(),
						md.getPhonenum(),
						md.getEmail());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void inputData() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 테스트 출력용 
	private void SelectMember() {
		Iterator<Member> ite = m.iterator();

		while(ite.hasNext()) {
			System.out.println(ite.next() + " ");
		}
	}

	// 회원가입
	public void memberInsert() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			while(true) {
				Member mem = new Member();
				while(true) {
					System.out.println("ID : ");
					String id = sc.nextLine();
					int cnt = 0;
					for (int i = 0; i < m.size(); i++) {
						/*aaa*/ if(id.equals(m.get(i).getId())) {
							cnt++;
							System.out.println("아이디가 중복입니다. 다시입력해주세요.");
							break;
						}
					}
					if(cnt == 0) {
						mem.setId(id);
					}
					String pw = getStrInput("PW : ");
					String pw2 = getStrInput("PW CONFIRM : ");
					String name = getStrInput("NAEM : ");
					String phone = getStrInput("PHONE : ");
					String email = getStrInput("EMAIL : ");
					m.add(mem);
					int result  = dao.inserMemberDTO(conn, mem);
					
					if(result > 0) {
						System.out.println("입력되었습니다.");
					} else {
						System.out.println("입력 실패!!!!");
					}
			}	
//				if(idCheck(id)) {
//					System.out.println("중복된 id입니다.");
//				} 
//				
//				else if (pw.equals(pw2)) {
//					Member mem = new Member(id, pw, name, phone, email);
//					int result = dao.inserMemberDTO(con, mem);
//					
//					if(result > 0) {
//						System.out.println("입력되었습니다.");
//					} else {
//						System.out.println("입력 실패");
//					}
//					System.out.println(id + "님 가입을 축하드립니다.");
//				} else {
//					System.out.println("비밀번호를 확인해주세요.");
//				}
//			}
			
//			String id = getStrInput("ID : ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 가입할때 아이디 중복 체크
	private boolean idCheck(String id) {
		boolean check = true;
		Member member = FindByID(id);
		if(member == null) {
			check = false;
			return check;
		}
		return check;
	}

	// 로그인 구현 기능 수정 필요
	public int Login() {
		Connection conn = null;
		int result = 0;
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			String id = getStrInput("id : ");
			String password = getStrInput("pw : ");

			m = dao.getMemberList(conn);

			Member member = FindByID(id);

			if(member == null) {
				System.out.println("등록되지 않은 ID입니다.");
			} else if(member.getPassword().equals(password)) {
				System.out.println("[" + member.getId() + "]님께서 로그인 하셨습니다.");
				idx = member.getIdx();
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
// aaa = ?? select id from member ==> result 
	// 아이디 비교 하는 메소드 
	private Member FindByID(String id) {
		for(Member memberDTO : m) { 
			if(memberDTO.getId().equals(id)) {
				return memberDTO;
			}
		}
		return null;
	}

	// 입력값 메소드
	private String getStrInput(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	private int getNumInput(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}

	void memberUpdate() {
		Connection conn = null;
		//		this.idx = idx;

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			while(true) {
				System.out.println("회원정보를 수정합니다.");

				String pw = getStrInput("수정하실 패스워드 : ");
				String name = getStrInput("수정하실 이름 : ");
				String phone = getStrInput("수정하실 핸드폰번호 : ");
				String email = getStrInput("수정하실 메일 : ");

				int result = dao.updateMember(conn, member);

				System.out.println("입력한 사항이 모두 맞습니까? 예(1) 아니오(2)");
				int input = Integer.parseInt(sc.nextLine());

				if(input == 1) {
					System.out.println("수정이 완료되었습니다.");
					Member member = new Member(idx, pw, name, phone, email);
					break;
				} else if(input == 2) {
					System.out.println("메인으로 이동");
					break;
				} else {
					System.out.println("잘못 누르셨습니다. 초기 메뉴로 이동합니다.");
					break;
				}
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 메인 돌려보는 메소드
	public void memberEdit() {
		int choice;
		while(true) {
			System.out.println("[1]회원정보수정 [2]주문 [3]돌아가기");
			try {
				choice= Integer.parseInt(sc.nextLine());
				if(choice<1 || choice>3) {
					throw new Exception("잘못입력하셨습니다. 1,2,3번 중 하나를 선택해주세요. ");
				}
				switch(choice) {
				case 1:
					memberUpdate();
					break;
				case 2:
					o.menu();
					break;
				case 3:
					continue;
				}
			} catch(Exception e) {
				System.out.println("잘못입력하셨습니다. 숫자 1~3번 만 입력하세요.");
			}
		}

	}
}
