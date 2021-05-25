package ch03;

import java.util.Scanner;

// java.lang.* 

public class Calculator {
	
	long plus(int num1, int num2) {
//		long result = num1 + num2;
//		return result;
		return (long)num1 + num2;
	}
	
	long minus(int num1, int num2) {
		return (long)num1 - num2;
	}
	
	long multi(int num1, int num2) {
		return (long)num1 * num2;
	}
	
	float div(int num1, int num2) {
		return (float)num1 / num2; // (float)int / int -> int 
	}
	
	// 클래스 이름 -> 대문자 시작 케멀 케이스
	// 변수 이름 -> 소문자 시작 케멀 케이스
	// 상수 -> 모두 대문자
	
	double pi = 3.14;
	float pi1 = 3.14f;
	final float PI = 3.14f; // 상수
	
	float circum(float r) {
		return 2 * PI * r; // int * float * float
	}
	
	float cirArea(float r) {
		return PI * r * r;
	}
	
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		System.out.println(cal.PI);
		
		System.out.println("1 + 2 = " + cal.plus(1, 2));
		
		// Scanner : 자원을 프로그램으로 받아오는 역할
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("덧셈을 합니다.\n숫자1을 입력해주세요.");
		int num1 = scanner.nextInt();
		System.out.println("숫자2를 입력해주세요.");
		int num2 = scanner.nextInt();
		System.out.println(num1 + " + " +num2 + " = " + cal.plus(num1, num2));
		
		System.out.println("-------------------------------");
		
		System.out.println("반지름을 입력해주세요.");
		float r = scanner.nextFloat();
		
		System.out.println("입력 받은 반지름의 길이 : " + r);
		System.out.println("원의 둘레 : " + cal.circum(r));
		System.out.println("원의 넓이 : " + cal.cirArea(r));
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("[1]계산기 [2]원의둘레 [3] 원의넓이");
//		String input = sc.nextLine();
//		switch(input) {
//		case "1":
//			System.out.println("연산자를 선택하세요.(+,-,*,/)");
//			input = sc.next();
//			if(input.equals("+")) {
//				System.out.println("첫번째 숫자를 입력하세요.");
//				int num1 = sc.nextInt();
//				System.out.println("두번째 숫자를 입력하세요.");
//				int num2 = sc.nextInt();
//				System.out.println("합 : " + cal.plus(num1, num2));
//			}
//			if(input.equals("-")) {
//				System.out.println("첫번째 숫자를 입력하세요.");
//				int num1 = sc.nextInt();
//				System.out.println("두번째 숫자를 입력하세요.");
//				int num2 = sc.nextInt();
//				System.out.println("합 : " + cal.minus(num1, num2));
//			}
//			if(input.equals("*")) {
//				System.out.println("첫번째 숫자를 입력하세요.");
//				int num1 = sc.nextInt();
//				System.out.println("두번째 숫자를 입력하세요.");
//				int num2 = sc.nextInt();
//				System.out.println("합 : " + cal.multi(num1, num2));
//			}
//			if(input.equals("/")) {
//				System.out.println("첫번째 숫자를 입력하세요.");
//				int num1 = sc.nextInt();
//				System.out.println("두번째 숫자를 입력하세요.");
//				int num2 = sc.nextInt();
//				System.out.println("합 : " + cal.div(num1, num2));
//			}
//			System.out.println();
//			break;
//		case "2":
//			System.out.println("반지름을 입력해주세요.");
//			float num3 = .nextFloat();
//			System.out.println("원의 둘레 : " + cal.circum(num3));
//			break;
//		case "3":
//			System.out.println("반지름을 입력해주세요.");
//			float num4 = .nextFloat();
//			System.out.println("원의 넓이 : " + cal.cirArea(num4));
//			break;
//		}
	}
}
