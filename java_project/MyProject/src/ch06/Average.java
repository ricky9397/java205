package ch06;

import java.util.*;

public class Average {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int kor = 0, en = 0, math = 0; // 국어, 영어, 수학변수
		int max = 0, min = 0; // 최고점수, 최하점수
		int[][] score;	// 점수 입력값 변수
		String[] name;	// 이름 입력값 변수
		float avg = 0.0f;	// 평균값을 담을 변수
		int sum = 0; // 총점을 담을 변수
		while(true) {
			System.out.println("=====메뉴====");
			System.out.println("1.학생추가");
			System.out.println("2.전체학생 총점");
			System.out.println("3.전체학생 총점 평균");
			System.out.println("4.국어 최고점수");
			System.out.println("5.수학 최하점수");
			System.out.println("6.학생 데이터를 모두 출력");
			System.out.println("0.프로그램을 종료합니다.");
			System.out.print("메뉴를 선택하세요>>>");
			int input = sc.nextInt(); // 화면에 입력받은 숫자를 input에 저장
			switch(input) {
			case 1:
				System.out.print("학생 수를 입력해주세요>>");
				input = sc.nextInt();
				
				name = new String[input];
				score = new int[input][3];
				System.out.println("[1]학생이름 [2]국어 [3]영어 [4]수학 순으로 입력하세요.");
				for (int i = 0; i < score.length; i++) {
						System.out.print("[1]학생이름 : ");
						name[i] = sc.next();
						System.out.print("[2]국어점수 : ");
						score[i][0] = sc.nextInt();
						System.out.print("[3]영어점수 : ");
						score[i][1] = sc.nextInt();
						System.out.print("[4]수학점수 : ");
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
						} else if(score[k][2] > min) {
							min = score[k][2];
						}
					}
				}
				break;
			case 2: 
				System.out.println("전체학생수의 총점은?");
				System.out.println("총점 " + sum +"점 입니다.");
				break;
			case 3:
				avg = sum/3;
				System.out.println("총평균점수 =" + avg);
				break;
			case 4:
				System.out.println("국어 최고점수는 [" + max + "]점 입니다.");
				break;
			case 5:
				System.out.println("수학 최하점수는 [" + min + "]점 입니다.");
			case 6:
				break;
			default:
				sc.close();
				System.exit(0);
			}
		}
	}
}
