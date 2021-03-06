package project03;

import java.util.Scanner;

public class SmartPhone {
	Scanner sc = new Scanner(System.in);
	Contact[] co;
	int cnt; 
	
	public SmartPhone() {
		this.co = new Contact[10];
		this.cnt = 0;
	}
	
	public void addJoinMembership(int choice) {
		System.out.println("이름 입력 입력해주세요. ");
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
		addArray(new Contact(name, phon, email, address, birth, group));
		
		
		System.out.println("회원가입 되셨습니다.");
		
		if(choice == 2) {
			System.out.println("회사 이름을 입력하세요.");
			String cpName = sc.next();
			System.out.println("부서 이름을 입력하세요.");
			String dmName = sc.next();
			System.out.println("직급을 입력하세요.");
			String position = sc.next();
			
			addArray(new CompanyContact1(name, phon, email, address, birth, group, cpName, dmName, position));
		} else if(choice == 3){
			System.out.println("");
		}
	}
	
	public void addArray(Contact c) {
		co[cnt] = c;
		System.out.println("저장된 정보가 없습니다.");
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
