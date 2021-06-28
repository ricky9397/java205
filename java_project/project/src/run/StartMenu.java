package run;
import java.util.Scanner;

import admin.AdminMenu;
import member.MemberDao;
import member.MemberManager;
import orders.OrderDao;
import orders.OrderManager;
import product.ProductDao;
import product.ProductManager;

public class StartMenu {
	public void FirstMenu() {

		Scanner sc = new Scanner(System.in);
		MemberManager mManager = new MemberManager(MemberDao.getInstance());
		AdminMenu admMenu = new AdminMenu();

		int choice;

		while(true) {
			System.out.println();
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println();
			System.out.println("- - - - - - - - - - - - - 나자바의 아이스크림 가게- - - - - - - - - - - - ");
			System.out.println();
			System.out.println(" -------------------------------------------------------------------");
			System.out.println("  1. 로그인    |    2. 회원가입    |    3. ID/PW찾기    |    4. 관리자 페이지    |    5. 종료    ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println();
			System.out.println("■■■■■■■■■■■■■■■■■■■■■ 원하시는 번호를 선택해 주세요. ■■■■■■■■■■■■■■■■■■■■■");

			try {
				choice= Integer.parseInt(sc.next());
				if(choice<1 || choice>5 ) {
					throw new Exception();
				}

				switch(choice) {
				case 1 : 
					System.out.println();
					System.out.println(" ▶ ▶ 로그인을 시작합니다.\n ");

					mManager.Login();
					break;
				case 2 : 
					System.out.println();
					System.out.println(" ▶ ▶ 회원가입을 시작합니다.\n");
					mManager.memberInsert();
					break;
				case 3 :
					System.out.println(" ▶ ▶ ID/PW찾기를 시작합니다.\n");
					mManager.MemberFind();
					break;
				case 4 :
					admMenu.AdminMenu();				
					break;
				case 5 : 
					System.out.println(" ▶ ▶ 시스템을 종료합니다.");
					System.out.println("감사합니다. ");
					System.exit(4);


				}
			} catch (Exception e) {
				System.out.println("※ 잘못입력하셨습니다. 1,2,3,4,5번 중 하나를 선택해주세요. \n");
			}
		}
	}
}
