package team;

import java.util.Scanner;

import teamDAO.MemberDAO;

public class StartMenu {
	
//	static int  idx;
	
	
	
	void FirstMenu() {
		OrderManager o = new OrderManager();
		MemberManager m = new MemberManager(MemberDAO.getInstance());
		ProductManager p = new ProductManager();
		Scanner sc = new Scanner(System.in);
		//		      AdminMenu am = new AdminMenu();	// 관리자
		int choice;
		
		while(true) {
			System.out.println();
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println();
			System.out.println("- - - - - - - - - - 나자바의 아이스크림 가게- - - - - - - - - ");
			System.out.println();
			System.out.println(" ------------------------------------------------------");
			System.out.println("  1. 로그인   |   2. 회원가입    |  3. 관리자 페이지  | 4. 종료 ");
			System.out.println("-------------------------------------------------------");
			System.out.println();
			System.out.println("■■■■■■■■■■■■■■■ 원하시는 번호를 선택해 주세요. ■■■■■■■■■■■■■■■■■");

			try {
				choice= Integer.parseInt(sc.nextLine());
				if(choice<1 || choice>4) {
					throw new Exception("잘못입력하셨습니다. 1,2,3,4번 중 하나를 선택해주세요. ");
				}

				switch(choice) {
				case 1 : 
					System.out.println("로그인");
					 m.Login();
					 m.munus();
					 m.memberUpdate();
					break;
				case 2 : 
					System.out.println("회원가입");
					m.memberInsert();
					break;
				case 3 :
					//		               am.AdminMenu();   관리자
					break;
				case 4 : 
					System.out.println("시스템을 종료합니다.");
					System.out.println("감사합니다. ");
					return;


				}
			} catch (Exception e) {
				System.out.println("잘못입력하셨습니다. 숫자 1,2,3,4번 중 하나를 선택해주세요. ");
			}
		}
	}


}
