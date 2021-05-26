package ch05;

public class Member {
	String name;
	String phoneNo;
	String major;
	int grade;
	String email;
	String birthday;
	String address;
	
	public Member(String name, String phoneNo, String major, int grade,
			String email, String birthday, String address) {
		
		this.name = name;
		this.phoneNo = phoneNo;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
	}
	
	public Member(String name, String phoneNo, String major, int grade,
			String email) {
		this(name, phoneNo, major, grade, email, null, null);
		
	}
	
	public void showInfo() {
		System.out.println("이름 : " + this.name);
		System.out.println("전화번호 : " + phoneNo);
		System.out.println("전공 : " + major);
		System.out.println("학년 : " +grade);
		System.out.println("이메일 : " + email);
		
		if(this.birthday == null) {
			System.out.println("생일 : 입력된 데이터가 없습니다.");
		} else {
			System.out.println("생일 : " + birthday);
		}
		
		if(this.address != null) {
			System.out.println("주소 : " + address);
		} else {
			System.out.println("주소 : 입력된 데이터가 없습니다.");
		}
	}
	
	public static void main(String[] args) {

		Member m1 = new Member("홍길동", "010-1234-1234", "컴공", 1, "asdadsad@asdasd.net", "88-06-30", "서대문구");
		m1.showInfo();
		
		System.out.println("============================================");
		
		Member m2 = new Member("이순신", "123-1234-1234", "문과", 2, "asd@asd.com");
		m2.showInfo();
		
	}
}
