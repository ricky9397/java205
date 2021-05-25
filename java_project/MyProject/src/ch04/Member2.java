package ch04;

import java.util.Calendar;
import java.util.Scanner;

// 4번문제 선생님 풀이
public class Member2 {
	void vaccinCheck(int birthYear) {
		
		int age = ageCal(birthYear); // 나이연산
		
		boolean check1 = age<15 && age>=65;
		boolean chech2 = !(age>=15 && age<65);
		
		System.out.println(check1);
		System.out.println(chech2);
		
		if(check1) {
			System.out.println("무료예방접종이 가능합니다.");
		} else {
			System.out.println("무료 접종 대상자가 아닙니다.");
		}
	}
	
	// 태어난 년도를 입력하면 나이를 반환하는 메소드
	int ageCal(int year) {
		
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		// Calendar.getInstance().get(Calendar.YEAR); 싱글톤패턴 캘린더 년도를 알려준다.
		return currentYear - year-1;
	}
	
	void checkup(int birthYear) {
		int age = ageCal(birthYear);
		
		boolean check1 = birthYear%2==0 && 2021%2==0 || birthYear%2==1 && 2021%2==1;
		boolean check2 = birthYear%2 == 2021%2;
		
		if(age>=20 && check2) {
			System.out.println("검진 대상");
			if(age>=40) {
				System.out.println("암검진 대상자");
			} 
		} else {
			System.out.println("검진대상이 아닙니다.");
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("태어난 년도를 입력해주세요.");
		int birthYear = sc.nextInt();
		
		Member2 member = new Member2();
		member.vaccinCheck(birthYear);
		member.checkup(birthYear);
	}
	
}
