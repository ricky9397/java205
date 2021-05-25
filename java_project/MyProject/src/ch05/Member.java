package ch05;

import java.util.Scanner;

public class Member {
	String studentName;
	String phonNumber;
	String major;
	int grade;
	String email;
	int birthday;
	String address;
	
	public Member(String studentName, String phonNumber, String major, int grade,
			String email, int birthday, String address) {
		
		this(studentName, phonNumber, major, grade, email);
		this.birthday = birthday;
		this.address = address;
	}
	
	public Member(String studentName, String phonNumber, String major, int grade,
			String email) {
		
		this.studentName = studentName;
		this.phonNumber = phonNumber;
		this.major = major;
		this.grade = grade;
		this.email = email;
	}
	
	public String toString() {
		return "이름:"+studentName + " 전화번호:" + phonNumber + " 전공:" + 
				major + " 학년:" + grade + " 메일:" + email + " 생일:" + birthday
				+ " 주소:" + address;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력해주세요.");
		String name = sc.next();
		System.out.println("전화번호를 입력해주세요.");
		String phonNumber = sc.next();
		System.out.println("전공을 입력해주세요.");
		String major = sc.next();
		System.out.println("학년을 입력해주세요.");
		int grade = sc.nextInt();
		System.out.println("이메일을 입력해주세요.");
		String email = sc.next();
		System.out.println("생일을 입력해주세요.");
		int birthday = sc.nextInt();
		System.out.println("주소를 입력해주세요.");
		String address = sc.next();
		
		Member m1 = new Member(name, phonNumber, major, grade, email, birthday, address);
		
		
		System.out.println("이름을 입력해주세요.");
		String name1 = sc.next();
		System.out.println("전화번호를 입력해주세요.");
		String phonNumber1 = sc.next();
		System.out.println("전공을 입력해주세요.");
		String major1 = sc.next();
		System.out.println("학년을 입력해주세요.");
		int grade1 = sc.nextInt();
		System.out.println("이메일을 입력해주세요.");
		String email1 = sc.next();
		
		Member m2 = new Member(name1, phonNumber1, major1, grade1, email1);
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		
	}
}
