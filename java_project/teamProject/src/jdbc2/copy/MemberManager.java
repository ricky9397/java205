package jdbc2.copy;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class MemberManager {

	private MemberDAO dao;

	public MemberManager(MemberDAO mem) {
		this.dao = mem;
	}

	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "tiger";

	void MemberList() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw);

			List<MemberDTO> list = dao.getMemberList(con);

			System.out.println("회원 정보 리스트");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("id\t pw\t 이름\t 번호\t 메일");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

			for(MemberDTO md : list) {
				System.out.printf("%s\t %s\t %s\t %s\t %s \n",
						md.getId(),
						md.getPw(),
						md.getName(),
						md.getPhone(),
						md.getEmail());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void inputData() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	Scanner sc = new Scanner(System.in);
	List<MemberDTO> m = new ArrayList<>();

	public void munus() {
		System.out.println("관리자 전용 입니다.");
		System.out.println("[1]회원전체리스트");
		int num = sc.nextInt();
		switch(num) {
		case 1:
			MemberList();
			break;
		}

	}
	public void run() {

		int key = 0;
		while((key = menu()) != 0) {
			switch(key) {
			case 1:
				Login();
				break;
			case 2:
				MemberJoin();
				break;
			case 3:
				SelectMember();
				break;
			case 4:
				munus();
				break;
			}
		}
	}

	private void SelectMember() {
		Iterator<MemberDTO> ite = m.iterator();

		while(ite.hasNext()) {
			System.out.println(ite.next() + " ");

		}
	}

	private void MemberJoin() {

		Connection con = null;

		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("회원가입합니다.");
			sc.nextLine();
			String id = getStrInput("id : ");
			String pw = getStrInput("pw : ");
			String pw2 = getStrInput("pw confirm : ");
			String name = getStrInput("name : ");
			String phone = getStrInput("phone : ");
			String email = getStrInput("email : ");

			if(idCheck(id)) {
				System.out.println("중복된 id입니다.");
			} else if (pw.equals(pw2)) {
				MemberDTO mem = new MemberDTO(id, pw, name, phone, email);
				m.add(mem);
				int result = dao.inserMemberDTO(con, mem);

				if(result > 0) {
					System.out.println("입력되었습니다.");
				} else {
					System.out.println("입력 실패");
				}
				System.out.println(id + "님 가입을 축하드립니다.");
			} else {
				System.out.println("비밀번호를 확인해주세요.");
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean idCheck(String id) {
		boolean check = true;
		MemberDTO member = FindByID(id);
		if(member == null) {
			check = false;
			return check;
		}
		return check;
	}

	private void Login() {
		sc.nextLine();
		String id = getStrInput("id : ");
		String pw = getStrInput("pw : ");

		MemberDTO member = FindByID(id);
		if(member == null) {
			System.out.println("등록되지 않은 ID입니다.");
		} else if(member.getPw().equals(pw)) {
			System.out.println("[" + member.getId() + "]님께서 로그인 하셨습니다.");
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}

	private MemberDTO FindByID(String id) {
		for(MemberDTO memberDTO : m) {
			if(memberDTO.getId().equals(id)) {
				return memberDTO;
			}
		}
		return null;
	}

	private String getStrInput(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	private int getNumInput(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}

	private int menu() {
		System.out.println("어서오세용");
		return getNumInput("[1]로그인 [2]회원가입 [3]전체 회원 보기 [4]관리자 로그인 [0]종료");

	}
	
	// login 구현 선생님에게 물어보기
//	}
//	
//	public void logins() {
//		MemberDAO md = new MemberDAO();
//		MemberDTO dt = new MemberDTO(null, null, null, null, null);
//		int result = md.login(dt.getId(), dt.getPw());
//		if(result == 1) {
//			System.out.println("로그인성공");
//		}else if(result == 0){
//			System.out.println("비밀번호 틀립니다.");
//		}else if(result == -1){
//			System.out.println("존재하지 않는 아이디입니다.");
//		}else if(result == -2){
//			System.out.println("데이터베이스 오류입니다.");
//			
//		}
//	}
	
	
}


