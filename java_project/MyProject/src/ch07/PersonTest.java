package ch07;

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Male("홍길동", "950804-1019111", "남자", 180.0f);
		p1.introduction();
		
		Person p2 = new Female("홍길순", "011204", "여자", 163.5f);
		p2.introduction();
	}
}
