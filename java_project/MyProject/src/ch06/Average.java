package ch06;

import java.util.*;

public class Average {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor = 0, en = 0, math = 0;
		int total;
		float age;
		int sum = 0;
		int max = 0;
		int min = 0;
		System.out.println("학생수를 입력하세요.");
		int input = sc.nextInt();
		String[] name = new String[input];
		int[][] score = new int[input][3];
		for(int i = 0; i < score.length; i++) {
			System.out.println("이름을 입력하세요.");
			name[i] = sc.next();
			System.out.println("국어점수를 입력하세요.");
			score[i][0] = sc.nextInt();
			System.out.println("영어점수를 입력하세요.");
			score[i][1] = sc.nextInt();
			System.out.println("수학점수를 입력하세요.");
			score[i][2] = sc.nextInt();
			
			kor += score[i][0];
			en += score[i][1];
			math += score[i][2];
			sum = kor + en + math;
		}
		System.out.println("================");
		System.out.println("[이름] [국어] [영어] [수학]");
		for(int i = 0;i < score.length; i++) {
			System.out.print(name[i]+"     ");
            for(int j = 0;j < score[i].length; j++){
                System.out.print(+score[i][j] + "    ");
            }
            System.out.println();
        }
		for(int k = 0; k < score.length; k++) {
			for(int e = 0; e < score[k].length; e++) {
				if(score[k][0] > max) {
					max = score[k][0];
				} else if(score[k][2] < max) {
					min = score[k][2];
				}
			}
		}
	}

}
