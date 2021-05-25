package ch06;

import java.util.*;

public class Average {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor, en, math;
		int total;
		float age;
		String[] name = new String[10];
		
		System.out.println("학생수를 입력하세요.");
		int input = sc.nextInt();
		int[][] arr = new int[input][3];
		for(int i = 0; i < input; i++) {
			System.out.println("이름을 입력하세요.");
			name[i] = sc.next();
			for(int j = 0; j < input; j++)
				System.out.println("국어점수를 입력하세요.");
				kor = sc.nextInt();
				System.out.println("영어점수를 입력하세요.");
				en = sc.nextInt();
				System.out.println("수학점술르 입력하세요.");
				math = sc.nextInt();
			
			
		}
	}

}
