package member;

import java.util.Scanner;
import orders.OrderMenu;
import run.StartMenu;

public class MemberMenu {
	
	public void memberMenu() {
		
		Scanner sc = new Scanner(System.in);
		int choice;
		MemberManager mManager = new MemberManager(MemberDao.getInstance());
		OrderMenu oMenu = new OrderMenu();
		StartMenu startMenu = new StartMenu();
		
		
		while(true) {
			System.out.println("[1]회원정보수정 [2]회원정보보기 [3]주문 [4]로그아웃");
			try {
				choice= Integer.parseInt(sc.nextLine());
				if(choice<1 || choice>4) {
					throw new Exception("잘못입력하셨습니다. 1,2,3번 중 하나를 선택해주세요. ");
				}
				switch(choice) {
				case 1:
					mManager.memberUpdate();
					break;
				case 2:
					mManager.MemberList();
					break;
				case 3:
					oMenu.oderMenu();
					break;
				case 4:
					startMenu.FirstMenu();
					break;
				}
			} catch(Exception e) {
				System.out.println("잘못입력하셨습니다. 숫자 1~3번 만 입력하세요.\n");
			}
		}
	}
}
