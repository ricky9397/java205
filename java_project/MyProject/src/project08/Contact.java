package project08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Contact implements Serializable {
	Scanner sc = new Scanner(System.in);
	private String name;
	private String number;
	ArrayList<Contact> co = new ArrayList<Contact>();

	public Contact(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Contact [name=" + name + ", number=" + number + "]";
	}

	public void inputContact() {
		while(true) {
			Contact cont = new Contact(name, number);

			while(true) {
				System.out.println("이름을 입력해주세요>>");
				String name = sc.next();
				int cnt = 0;
				for (int i = 0; i < co.size(); i++) {
					if(name.equals(co.get(i).getName())) {
						cnt++;
						System.out.println("이름이 중복입니다.다시입력해주세요.");
						break;
					}
				}
				if(cnt == 0) {
					cont.setName(name);
					break;
				}
			}

			System.out.println("연락처를 입력해주세요 >> ");
			cont.setNumber(sc.next());

			System.out.println("이 름 : " + cont.getName());
			System.out.println("연락처 : " + cont.getNumber());

			System.out.println("입력사항이 맞습니까?[y],[n]");
			String input = sc.next();
			if(input.equalsIgnoreCase("y")) {
				co.add(cont);
				System.out.println("입력완료");
				break;
			} else if(input.equalsIgnoreCase("n")) {
				System.out.println("이름을 다시입력하세요.");
			} else {
				System.out.println("잘못입력하셧습니다. 초기화면으로 이동합니다.");
				break;
			}
		}

	}

	public void searchContact() {
		System.out.println("이름 검색하세요 >> ");
		String tmp = sc.next();
		int cnt = 0;
		for (int i = 0; i < co.size(); i++) {
			if(tmp.equals(co.get(i).getName())) {
				System.out.println("-------------------------------");
				System.out.println("이름 : " + co.get(i).getName());
				System.out.println("연락처 : " + co.get(i).getNumber());
				System.out.println("-------------------------------");
				cnt++;
				break;
			}
		} 
		if(cnt == 0) {
			System.out.println("입력된 정보가 없습니다.");
		}
	}

	public void modifyContact() {
		System.out.println("수정할 이름을 입력해주세요 >> ");
		String name = sc.next();
		int cnt = 0;
		for (int i = 0; i < co.size(); i++) {
			if(name.equals(co.get(i).getName())) {
				System.out.println("수정할 전화번호를 입력하세요 >> ");
				co.get(i).setNumber(sc.next());
				cnt++;
				System.out.println("수정완료");
				break;
			}
		} if(cnt == 0) {
			System.out.println("해당이름이 존재하지 않습니다.");
		} 
	}

	public void deleteContact() {
		System.out.println("삭제할 이름을 입력하세요 >> ");
		String name = sc.next();
		int cnt = 0;
		for (int i = 0; i < co.size(); i++) {
			if(name.equals(co.get(i).getName())) {
				co.remove(i);
				cnt++;
				System.out.println("삭제 되었습니다.");
				break;
			}
		} if (cnt == 0) {
			System.out.println("해당이름이 존재하지 않습니다.");
		}
	}

	public void allContact() {
		System.out.println("==========연락처 전체 리스트==========");
		for (int i = 0; i < co.size(); i++) {
			System.out.println("-------------------------------");
			System.out.println("이름 : " + co.get(i).getName());
			System.out.println("연락처 : " + co.get(i).getNumber());
			System.out.println("-------------------------------");
		}
	}

	public void fileSave() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contact.ser"));
			ArrayList<Contact> co1 = new ArrayList<Contact>();
			out.writeObject(co1);
			out.close();
			System.out.println("파일 저장 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFile() {
		
		try {
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("contact.ser"));
			ArrayList<Contact> co2 = (ArrayList<Contact>) in.readObject();
			co = co2;
			for(Contact c : co) {
				System.out.println(c);
			}
			System.out.println("복원된 파일 데이터 출력");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
