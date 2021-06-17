package project03;

import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {
		SmartPhone smart = new SmartPhone();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("[1]회원가입 [2]회사 [3]고객 [4]모든회원정보출력 [5]회원정보검색 [6]회원삭제 [7]회원정보수정 [8]프로그램종료");
			int input = sc.nextInt();
			switch(input) {
			case 1:
			case 2:
			case 3:
				smart.addJoinMembership(input);
				break;
			case 4:
				smart.allShowData();
				break;
			case 5:
				smart.showData();
				break;
			case 6:
				smart.delete();
				break;
			case 7:
				smart.modify();
				break;
			case 8:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				System.exit(6);
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}
}
