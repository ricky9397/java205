package project03;

import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {
		SmartPhone smart = new SmartPhone();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("[1]로그인 [2]회사 [3]거래처 [4]종료");
			int input1 = sc.nextInt();
			switch(input1) {
			case 1:
				System.out.println("[1]회원가입 [2]모든회원정보출력 [3]회원정보검색 [4]회원삭제 [5]회원정보수정 [6]프로그램종료");
				int input2 = sc.nextInt();
				switch(input2) {
				case 1:
					smart.addJoinMembership();
					break;
				case 2:
					smart.allShowData();
					break;
				case 3:
					smart.showData();
					break;
				case 4:
					smart.delete();
					break;
				case 5:
					smart.modify();
					break;
				case 6:
					System.out.println("프로그램을 종료합니다.");
					sc.close();
					System.exit(6);
				default:
					System.out.println("잘못입력하셨습니다.");
					break;
				}
				break;
			case 2:
				break;
			}
		}
	}
}
