package ch06;

public class Student2Main {

	public static void main(String[] args) {
//		main()메소드에 아래 내용을 정의해봅시다. 
//		① Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
		Student2[] students = new Student2[10];
		int korTotal = 0; // 국어총점을 담은 변수
		int engTotal = 0; // 영어총점을 담은 변수
		int mathTotal = 0; // 수학총점을 담은 변수
		int max = 0; // 국어최고점수
		int min = 100; // 수학최하점수
//		② Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
		students[0] = new Student2("홍길동1", 100, 65, 54);
		students[1] = new Student2("홍길동2", 70, 40, 76);
		students[2] = new Student2("홍길동3", 80, 56, 56);
		students[3] = new Student2("홍길동4", 60, 40, 89);
		students[5] = new Student2("홍길동6", 88, 88, 66);
		students[6] = new Student2("홍길동7", 77, 40, 55);
		students[7] = new Student2("홍길동8", 86, 55, 43);
		students[8] = new Student2("홍길동9", 55, 46, 74);
		students[9] = new Student2("홍길동10", 66, 40, 90);
		
//		③ 배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
		System.out.println("이름\t\t 국어\t 영어\t 수학 \t 총점\t 평균");
		for(int i = 0; i < students.length; i++) {
			System.out.print(students[i].getName() + "\t\t" + students[i].getKor()+"\t"  + students[i].getEng() + "\t" + students[i].getMath() + "\t");
			System.out.println(students[i].getSum() + "\t" + students[i].getavg());
			korTotal += students[i].getKor();
			engTotal += students[i].getEng();
			mathTotal += students[i].getMath();
		}
		System.out.println("--------------------------------------------------------------");
		System.out.println("과목별총점: \t" + korTotal + "\t" + engTotal + "\t" + mathTotal);
		for(int j = 0; j < students.length; j++) {
			if(students[j].getKor() > max) {	// max보다 국어점수가 높으면 true를 실행하여
				max = students[j].getKor();		// max안에 최고점수를 담는다. 
			} 
			if (students[j].getMath() < min) {	// min보다 수학점수가 낮으면 true를 실행하여
				min = students[j].getMath();	// min안에 수학최하점수를 담는다.
			}
		}
		System.out.println("우리반 국어최고점수:" + max +"\t"+ "우리반 수학최하점수:" + min);
	}

}
