package ch04;

import java.util.Scanner;

public class Member {
	final int year = 2021;
	int age;
	
	void influenza(int age) {
		this.age = year - age+1;
//		System.out.println("태어난 년도는 : " + age +"년");
//		System.out.println("나이는 : " + this.age +"세");
		if(this.age >= 15 && this.age <= 65) {
			System.out.println("무료예방접종이 가능합니다.");
		} else {
			System.out.println("무료접종 대상이 아닙니다.");
		}
	}
	
	void checkup(int age) {
		this.age = year - age+1;
//		System.out.println("태어난 년도는 : " + age +"년");
//		System.out.println("나이는 : " + this.age +"세");
			if(this.age >= 20 && this.age %2 == 0) {
				System.out.println("올해 무료 검강검진 대상자 입니다.");
				if(this.age >= 40) {
					System.out.println("암검사도 무료입니다.");
				}
			} else {
				System.out.println("올해 검사 대상자가 아닙니다.");
			}

	}
	
	public static void main(String[] args) {
		Member m = new Member();
//		m.influenza(2008);
//		System.out.println();
//		m.checkup(1988);
//		
		Scanner sc = new Scanner(System.in);
		System.out.println("1)독감예방접종 2)건강검진");
		int y = sc.nextInt();
		switch(y) {
		case 1:
			System.out.println("태어난 년도를 입력해주세요.");
			m.influenza(sc.nextInt());
			break;
		case 2:
			System.out.println("대한민국 성인(20세)의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.");
			System.out.println("태어난 년도를 입력해주세요.");
			m.checkup(sc.nextInt());
		}
	}
}
