package ch09;

import java.util.Scanner;

public class StringValidation {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("영문이름을 입력해주세요 >>");
		String name = scanner.nextLine();

		if(name != null && !name.trim().isEmpty()) {

			if(checkName(name)) {
				System.out.println("입력하신 이름은 : " + name);
			} else {
				System.out.println("이름을 표현할 수 없는 문자가 포함되어 있습니다.");
			}

		} else {
			System.out.println("공백문자열이 입력되었습니다.");
		}
	}

	public static boolean checkName(String name) {

		boolean result = true;

		for(int i=0; i<name.length(); i++) {
			char c = name.charAt(i);			
			if(!(c>='a'&&c<='z' || c>='A'&&c<='Z')) {
				result = false;
				break;
			}
		}

		return result;

	}
}
