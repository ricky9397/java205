package project08;

import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {
		Contact c = new Contact();
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("[1]연락처 입력 [2]연락처 검색 [3]연락처 수정 [4]연락처 삭제 [5]연락처 전체 리스트보기 [6]파일 저장 [7]파일로드 [8]종료");
			int input = sc.nextInt();
			switch(input) {
			case 1:
				c.inputContact();
				break;
			case 2:
				c.searchContact();
				break;
			case 3:
				c.modifyContact();
				break;
			case 4:
				c.deleteContact();
				break;
			case 5:
				c.allContact();
				break;
			case 6:
				c.fileSave();
				break;
			case 7:
				c.loadFile();
				break;
			case 8:
				sc.close();
				System.exit(8);
			default:
				System.out.println("잘못입력하셨습니다. 다시입력하세요.");
				break;
			}
		}
		
	}

}
