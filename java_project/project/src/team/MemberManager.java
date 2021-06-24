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
	public MemberManager(int idx) {
		this.idx = idx;
	}
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
									md.getPhonenum());
									md.getEmail();
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
	
	// 로그인 후 접속 진행방향
	public void munus() {
		System.out.println("[1]회원정보수정 [2]주문 [3]돌아가기 ");
		int num = Integer.parseInt(sc.nextLine());
		switch(num) {
		case 1:
			return;
		case 2:
			o.menu();
			break;
		}
	}
	
	public void member() {
		
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
		Connection con = null;

		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw);
			String id = getStrInput("id : ");
			if(idCheck(id)) {
				System.out.println("중복된 id입니다.");
			}
			String pw = getStrInput("pw : ");
			String pw2 = getStrInput("pw confirm : ");
			String name = getStrInput("name : ");
			String phone = getStrInput("phone : ");
			String email = getStrInput("email : ");
			
			
			if (pw.equals(pw2)) {
				Member mem = new Member(id, pw, name, phone, email);
				m.add(mem);
				
				int result = dao.inserMemberDTO(con, mem);
				System.out.println(id + "님 가입을 축하드립니다.");
			} else {
				System.out.println("비밀번호를 확인해주세요.");
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
			
			String pw = getStrInput("수정하실 패스워드 : ");
			String name = getStrInput("수정하실 이름 : ");
			String phone = getStrInput("수정하실 핸드폰번호 : ");
			String email = getStrInput("수정하실 메일 : ");
			
			Member member = new Member(idx, pw, name, phone, email);
			
			
			int result = dao.updateMember(conn, member);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 첫시작 로그인
	private int menu() {
		return getNumInput("[1]회원가입 [2]로그인 [3]테스트용회원보기 [0]종료");
				
	}
	
	// 메인 돌려보는 메소드
	public void run() {

		int key = 0;
		while((key = menu()) != 0) {
			switch(key) {
			case 1:
				memberInsert();
				break;
			case 2:
				Login();
				break;
			case 3:
				SelectMember();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못입력했다. 제대로입력해라");
			}
		}
	}
	
}
