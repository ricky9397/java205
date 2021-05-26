package ch05;

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
	
	public void showInfo() {
		System.out.println("이름:"+studentName + " 전화번호:" + phonNumber + " 전공:" + 
				major + " 학년:" + grade + " 메일:" + email + " 생일:" + birthday
				+ " 주소:" + address);
	}
	
	public static void main(String[] args) {

		Member m1 = new Member("홍길동", "010-1234-1234", "컴공", 1, "asdadsad@asdasd.net", 880630, "서대문구");
		Member m2 = new Member("이순신", "123-1234-1234", "문과", 2, "asd@asd.com");
		
		m1.showInfo();
		m2.showInfo();
		
	}
}
