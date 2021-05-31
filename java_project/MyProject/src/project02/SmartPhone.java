package project02;

import java.util.Scanner;

public class SmartPhone {
	Scanner sc = new Scanner(System.in);
	Contact[] contact;
	int cnt; 
	
	public SmartPhone(int num) {
		this.contact = new Contact[num];
		this.cnt = 0;
	}
	
	public void addJoinMembership() {

		
		System.out.println("이름 입력 >> ");
		String name = sc.next();
		System.out.println("전화번호를 입력해주세요.");
		String phon = sc.next();
		System.out.println("이메일을 입력해주세요.");
		String email = sc.next();
		System.out.println("주소를 입력해주세요.");
		String address = sc.next();
		System.out.println("생일을 입력해주세요.");
		String birth = sc.next();
		System.out.println("그룹을 입력하세요.");
		String group = sc.next();
		
		Contact con = new Contact(name, phon, email, address, birth, group);
		contact[cnt++] = con;
	}
	
	public void allShowData() {
		System.out.println("모든 정보를 출력합니다.");
		System.out.println("=========================");
		if(cnt > 0) {
			for(int i = 0; i < contact.length; i++) {
				contact[i].showInfo();
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println("=========================");
	}
	
	public void showData() {
		System.out.println("회원이름을 검색하세요.");
		String tmp = sc.next();
		if(cnt > 0) {
			for(int i = 0; i < contact.length; i++) {
				if(tmp.equals(contact[i])) {
					contact[i].showInfo();
				} else {
					System.out.println("존재하지 않는 이름입니다.");
				}
			}
		}
	}
	
}
