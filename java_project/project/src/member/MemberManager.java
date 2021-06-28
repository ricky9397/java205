package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import admin.DBconn;
import orders.OrderDao;
import orders.OrderManager;
import product.ProductDao;
import run.StartMenu;

public class MemberManager {
	public static int idx;
	private static Connection conn = DBconn.getConnection();

	private MemberDao dao;
	ArrayList<Member> mList;
	Member member;	
	OrderManager oManager;
	MemberMenu mMenu;
	Scanner sc = new Scanner(System.in);

	public MemberManager(MemberDao mem) {
		this.dao = mem;
		this.mList = new ArrayList<Member>();
		this.member = new Member();
		this.oManager = new OrderManager(OrderDao.getInstance(), ProductDao.getInstance());
		mMenu = new MemberMenu();
	}


	// 회원가입
	public void memberInsert() {

		try {
			mList = dao.getMemberList(conn);
			while(true) {

				String id = getStrInput("ID : ");
				if(idCheck(id)) {
					System.out.println("※ 중복된 id입니다.\n");
					continue;
				}
				String pw = getStrInput("PW : ");
				String pw2 = getStrInput("PW CONFIRM : ");
				if(!(pw.equals(pw2))) {
					System.out.println("※ 비밀번호를 잘못입력하셨습니다. 다시입력하세요.\n");
					continue;
				}
				String name = getStrInput("NAEM : ");
				String phone = getStrInput("PHONE : ");
				String email = getStrInput("EMAIL : ");

				if (pw.equals(pw2)) {
					Member mem = new Member(id, pw, name, phone, email);
					dao.insertMember(conn, mem);
					System.out.println(id + "님 가입을 축하드립니다.\n");
					break;
				} else {
					System.out.println("※ 비밀번호를 확인해주세요.\n");
				}
			}
		} catch (Exception e) {
			System.out.println("※ 잘못입력하셨습니다. ");
		}
	}


	// 로그인 구현 기능
	public void Login() {
		try {
			String id = getStrInput("id : ");
			String password = getStrInput("pw : ");

			mList = dao.getMemberList(conn);

			Member member = FindByID(id);

			if(member == null) {
				System.out.println("※ 등록되지 않은 ID입니다.");

			} else if(member.getPassword().equals(password)) {
				System.out.println("☞ [" + member.getId() + "]님께서 로그인 하셨습니다.\n");
				idx = member.getIdx();
				mMenu.memberMenu();

			} else {
				System.out.println("※ 비밀번호가 틀렸습니다.");
			}

		} catch (Exception e) {
			System.out.println("※ 잘못입력하셨습니다. ");

		}
	}


	// 로그인한 회원의 회원정보 수정
	void memberUpdate() {

		try {
			while(true) {
				System.out.println(" ▶ ▶ 회원정보를 수정합니다.\n");

				String pw = getStrInput("수정하실 패스워드 : ");
				String name = getStrInput("수정하실 이름 : ");
				String phone = getStrInput("수정하실 핸드폰번호 : ");
				String email = getStrInput("수정하실 메일 : ");


				System.out.println(" ▶ ▶ 입력한 사항이 모두 맞습니까? 예(1) 아니오(2)\n");
				int input = Integer.parseInt(sc.nextLine());
				System.out.println();
				if(input == 1) {
					System.out.println("☞ 수정이 완료되었습니다.\n");
					Member member = new Member(idx, pw, name, phone, email);
					int result = dao.updateMember(conn, member);
					break;
				} else if(input == 2) {
					System.out.println("※ 메인으로 이동\n");
					break;
				} else {
					System.out.println("※ 잘못 누르셨습니다. 초기 메뉴로 이동합니다.\n");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("※ 잘못입력하셨습니다. ");

		}
	}


	//로그인 회원 정보리스트 
	void MemberList() {

		try {

			mList = dao.getMemberList(conn);

			System.out.println("----------------------- 나의 정보 보기 ------------------------");
			System.out.println("------------------------------------------------------------");
			for (int i = 0; i < mList.size(); i++) {
				if(idx==mList.get(i).getIdx()) {
					System.out.println("나의 ID : " + mList.get(i).getId());
					System.out.println("나의 PW : " + mList.get(i).getPassword());
					System.out.println("나의 이름 : " + mList.get(i).getName());
					System.out.println("나의 핸드폰 : " + mList.get(i).getPhonenum());
					System.out.println("나의 이메일 : " + mList.get(i).getEmail());
					System.out.println("------------------------------------------------------------\n");
				}
			}

		} catch (Exception e) {
			System.out.println("※ 잘못입력하셨습니다. ");
		}
	}

	// 회원아이디/비번찾기 
	public void MemberFind() {

		try {

			mList = dao.getMemberList(conn);
			String name = getStrInput("회원 이름 : ");
			String email = getStrInput("회원 이메일 : ");

			int cnt = 0;
			for (int i = 0; i < mList.size(); i++) {
				if(name.equals(mList.get(i).getName()) && email.equals(mList.get(i).getEmail())) {
					cnt++;
					System.out.println("------------------------------------------------------------");
					System.out.println("☞ [" + name + "]님의 ID : " + mList.get(i).getId());
					System.out.println("☞ [" + name + "]님의 PW : " + mList.get(i).getPassword());
					System.out.println("------------------------------------------------------------");
					break;
				} 
			} if(cnt == 0) {
				System.out.println("회원정보가 틀렸습니다.");
			}

		} catch (Exception e) {
			System.out.println("※ 잘못입력하셨습니다. ");
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

	// 해당 아이디를 전체회원리스트에서 비교,확인 하는 메소드 
	private Member FindByID(String id) {
		for(Member memberDTO : mList) { 
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
	// 입력값 메소드
	private int getNumInput(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}

}

