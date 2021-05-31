package project01;

import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Contact p = new Contact(null, null, null, null, null, null);
		while(true) {
			System.out.println("[1]회원가입 [2]회원정보 변경 [3]회원정보출력 [4]프로그램종료");
			int input = sc.nextInt();
			switch(input) {
			case 1:
				p.joinMembership();
				break;
			case 2:
				p.modified();
				break;
			case 3:
				p.showInfo();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				System.exit(3);
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}
}
