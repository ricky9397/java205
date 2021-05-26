package ch07;

public class PersonTest {
	public static void main(String[] args) {
		Male male = new Male("홍길동", "950804-1019111", "남자", 180.0f);
		male.introduction();
		
		Female female = new Female("홍길순", "011204", "여자", 163.5f);
		female.introduction();
	}
}
