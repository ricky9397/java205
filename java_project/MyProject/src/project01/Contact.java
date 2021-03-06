package project01;

import java.util.Scanner;

public class Contact {
	Scanner sc = new Scanner(System.in);
	private String name;
	private String phon;
	private String email;
	private String address;
	private String birth;
	private String group;

	public Contact(String name, String phon, String email, String address, String birth, String group) {
		this.name = name;
		this.phon = phon;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhon() {
		return phon;
	}
	public void setPhon(String phon) {
		this.phon = phon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	void joinMembership() {
		System.out.println("이름을 입력해주세요.");
		setName(sc.next());
		System.out.println("전화번호를 입력해주세요.");
		setPhon(sc.next());
		System.out.println("이메일을 입력해주세요.");
		setEmail(sc.next());
		System.out.println("주소를 입력해주세요.");
		setAddress(sc.next());
		System.out.println("생일을 입력해주세요.");
		setBirth(sc.next());
		System.out.println("그룹을 입력하세요.");
		setGroup(sc.next());
	}
	
	void modified() {
		System.out.println("수정할 번호 입력");
		setPhon(sc.next());
		System.out.println("수정할 이메일 입력");
		setEmail(sc.next());
		System.out.println("수정할 주소 입력");
		setAddress(sc.next());
		System.out.println("수정이 완료되었습니다.");
	}
	
	void showInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("전화번호 : " + getPhon());
		System.out.println("이메일 : " + getEmail());
		System.out.println("주소 : " + getAddress());
		System.out.println("생일 : " + getBirth());
		System.out.println("그룹 : " + getGroup());
	}
	
}
