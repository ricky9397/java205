package project03;

import java.util.Scanner;

public class SmartPhone {
	Scanner sc = new Scanner(System.in);
	Contact[] co = new Contact[10];
	Contact[] co1 = new CompanyContact1[10];
	
	int cnt; 
	
	public void addJoinMembership() {
		Contact cont = new Contact();
		System.out.println("이름 입력 입력해주세요. ");
		cont.setName(sc.next());
		System.out.println("전화번호를 입력해주세요.");
		cont.setPhon(sc.next());
		System.out.println("이메일을 입력해주세요.");
		cont.setEmail(sc.next());
		System.out.println("주소를 입력해주세요.");
		cont.setAddress(sc.next());
		System.out.println("생일을 입력해주세요.");
		cont.setBirth(sc.next());
		System.out.println("그룹을 입력하세요.");
		cont.setGroup(sc.next());
		
		co[cnt] = cont;
		cnt++;
		System.out.println("회원가입 되셨습니다.");
		
	}
	
	public void allShowData() {
		System.out.println("모든 정보를 출력합니다.");
		System.out.println("=========================");
		if(cnt > 0) {
			for(int i = 0; i < cnt; i++) {
				co[i].showInfo();
				System.out.println("============================");
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
			for(int i = 0; i <= cnt; i++) {
				if(tmp.equals(co[i].getName())) {
					co[i].showInfo();
//				System.out.println("이      름 : " + co[i].getName());
//				System.out.println("전화번호 : " + co[i].getPhon());
//				System.out.println("이 메 일  : " + co[i].getEmail());
//				System.out.println("주      소 : " + co[i].getAddress());
//				System.out.println("생      일 : " + co[i].getBirth());
//				System.out.println("그      룹 : " + co[i].getGroup());
				break;
				} 
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
		}
	}
	
	public void delete() {
		System.out.println("삭제할 이름을 입력하시오.");
		String name = sc.next();
		if(cnt > 0) {
			for(int i = 0; i < cnt; i++) {
				if(name.equals(co[i].getName())) {
					for(int j = i; j <= cnt-1; j++) {
						co[j] = co[j+1];
						cnt--;
					}
				}
			}
		} else {
			System.out.println("입력정보가 없습니다.");
		}
	}

	public void modify() {
		System.out.println("회원이름을 입력하세요.");
		String name = sc.next();
		if(cnt > 0) {
			for (int i = 0; i < cnt; i++) {
				if(name.equals(co[i].getName())) {
					System.out.println("수정할 전화번호를 입력하세요.");
					co[i].setPhon(sc.next());
					System.out.println("수정할 이메일을 입력하세요.");
					co[i].setEmail(sc.next());
					System.out.println("수정할 주소를 입력하세요.");
					co[i].setAddress(sc.next());
					System.out.println("수정할 생일을 입력하세요.");
					co[i].setBirth(sc.next());
					System.out.println("수정할 그룹을 입력하세요.");
					co[i].setGroup(sc.next());
					System.out.println("수정이 완료 되었습니다.");
					break;
				}
			}
		} else {
			System.out.println("입력 정보가 없습니다.");
		}
	}
	
}
