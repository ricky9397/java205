package ch02;

// ch02.Member
public class Member {
	
	
	
	public static void main(String[] args) {
		
		// 변수 선언
		// 데이터의 타입 식별 이름
		// 데이터 타입 -> 내가 다루어야 하는 데이터의 특징에의해서 결정
		// 기본형 타입 8가지 -> 정수형, 실수형, bool, 문자
		
		String name = "손흥민";	// 이름
		int age = 27;			// 나이
		double height = 185.3;	// 키
		float weight = 45.8f;	// 몸무게
		boolean hasBook = false;
		
		System.out.println("저의 이름은 " + name); // String + String
		System.out.println("키는 " + height + "cm 입니다.");  
		// String + double + String -> (String + String) + String -> String + String
		// String + any Type -> String + String
		System.out.println("제 나이는 " + age + "살 입니다."); // String + int + String
		System.out.println("책의 보유 여부 :" + hasBook); // String + boolean
		
		if(hasBook) {
			System.out.println("책 있어요!!!");
		} else {
			System.out.println("책 없어요!!!");
		}
	}

}
