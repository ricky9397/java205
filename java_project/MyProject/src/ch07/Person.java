package ch07;

import java.util.Scanner;

public class Person {
	String name;
	String number;
	
	
	void person(int year) {
		int age = 2021 - year+1;
		System.out.println("안녕하세요. 저는 " + name +"입니다. "
				+ age +"살 입니다.");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String name = sc.next();
		System.out.println("주민번호를 입력해주세요.");
		String n1 = sc.next();
		String n2 = n1.substring(0,2);
		String n3 = n1.substring(2);
		Person p = new Person();
		
	}
}

class Male extends Person {
	
}

class Female extends Person {
	
}
