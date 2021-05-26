package ch05;

// 5번문제 선생님풀이
public class Member1 {
	
	// 생성자 -> 초기화 메소드, 인스턴스를 생성할 때 단 한번, 인스턴스 변수를 초기화 한다.
	// 데이터를 저장 -> 변수를 이용해서 메모리에 저장

	private String name; // 클래스의 영역에서 정의 -> 인스턴스변수, 인스턴스가 생성될때 변수의 메모리공간이 생성된다. 초기화를 생략 가능
	private final String phoneNo; // 참조형 변수의 기본 값 ->
	private String major;
	private int grade;
	private String email;
	private String birthday;
	private String address;
	// 접근제어 지시자 private을 쓰는 이유
	// 클래스 내부의 멤버들만 참조가 가능 : 정보 은닉, 변수의 데이터를 보호
	
	
	// 생성자 요구사항 -> 생성자 오버로딩
	// 오버로딩 -> 이름이 같은 메소드의 정의
	// 생성자의 이름 (매개변수) { 초기화 코드... }
	// 생성자의 이름 -> 클래스 이름
	// 생성자는 반드시 하나이상이 있어야 한다!!
	Member1(String name, String phoneNo, String major, 
			int grade, String email, String birthday, String address){
		this.name = name;
		this.phoneNo = phoneNo;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
	}
	
	// 오버로딩의 조건 :
	// 1. 메소드의 이름은 같다.
	// 2. 매개변수의 개수가 틀리거나, 매개변수의 타입이 달라야 오버로딩이 성립
	Member1(String name, String phoneNo, String major, 
			int grade, String email){
//		this.name = name;
//		this.phoneNo = phoneNo;
//		this.major = major;
//		this.grade = grade;
//		this.email = email;
		this(name, phoneNo, major, grade, email, null, null);
	}
	
	Member1(String name, String phoneNo, String major){
		this(name, phoneNo, major, 0, null, null, null);
	}
	
	// 기능 -> 메소드
	void showInfo() {
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
	
	Member1(){
		this.phoneNo = "000-0000-0000";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static void main(String[] args) {
		Member1 member1 = new Member1("철수", "010-0000-0000", "음악", 4, "ch@gmail.com", "2000-10-01", "서울");
		member1.name = "영희";
		member1.showInfo();
		
		System.out.println("===============================");
		
		Member1 member2 = new Member1("손흥민", "010-9999-9999", "축구", 1, "son@naver.com");
		member2.showInfo();
	}
}
