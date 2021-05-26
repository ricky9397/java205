package ch05;
// 5번문제 선생님풀이
public class Member1 {
	
	// 생성자 -> 초기화 메소드, 인스턴스를 생성할 때 단 한번, 인스턴스 변수를 초기화 한다.
	// 데이터를 저장 -> 변수를 이용해서 메모리에 저장
	// 기능 -> 메소드
	// 생성자 요구사항 -> 생성자 오버로딩
	// 오버로딩 -> 이름이 같은 메소드의 정의
	String name; // 클래스의 영역에서 정의 -> 인스턴스변수, 인스턴스가 생성될때 변수의 메모리공간이 생성된다. 초기화를 생략 가능
	String phoneNo; // 참조형 변수의 기본 값 ->
	String major;
	int grade;
	String email;
	String birthday;
	String address;
	
	void showInfo() {
		System.out.println("이름: " );
	}
}
