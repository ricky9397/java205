package ch06;

import java.util.Arrays;
import java.util.Scanner;

public class Student {
	private String name;
	private int kor, en, math;
	int total;
	float avg;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEn() {
		return en;
	}
	public void setEn(int en) {
		this.en = en;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public void totalScore() {
		total = kor + en + math;
	}
	public void average() {
		avg = total / 3.0f;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생수를 입력하세요.");
		int input = sc.nextInt();
		Student[] st = new Student[input];
		for(int i = 0; i < st.length; i++) {
			System.out.println("학생의 이름을 입력해주세요.");
			String name = sc.next();
			System.out.println("국어점수를 입력해주세요.");
			int kor = sc.nextInt();
			System.out.println("영어점수를 입력해주세요.");
			int en = sc.nextInt();
			System.out.println("수학점수를 입력해주세요.");
			int math = sc.nextInt();
			
			st[i] = new Student();
			st[i].setName(name);
			st[i].setKor(kor);
			st[i].setEn(en);
			st[i].setMath(math);
			st[i].totalScore();
			st[i].average();
			
		}
		
		for(Student s : st) {
			System.out.println("학생인원:" + input);
			System.out.println(" 학생이름:" + s.getName() + " 국어점수:" + s.getKor() + 
					" 영어점수:" + s.getEn() + " 수학점수" + s.getMath());
			System.out.println("총점수 : " + s.total + "평균 : " + s.avg + "\n");
		}
	}
}
