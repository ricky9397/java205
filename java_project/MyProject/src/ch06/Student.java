package ch06;

import java.util.Arrays;
import java.util.Scanner;

public class Student {
	private String name;
	private int kor, en, math;
	private int total;
	private float avg;
	
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
	
	public int getTotal() {
		return total = kor + en + math;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getAvg() {
		return avg = total / 3.0f;
	}
	public void setAvg(float avg) {
		this.avg = avg;
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

		}

		System.out.println("학생인원:" + input + "명");
		for(Student s : st) {
			System.out.println(" 학생이름:" + s.getName() + " 국어점수:" + s.getKor() + 
					" 영어점수:" + s.getEn() + " 수학점수" + s.getMath());
			System.out.println("총점수 :" + s.getTotal() + " 평균 : "+ s.getAvg());
		}
	}
}
