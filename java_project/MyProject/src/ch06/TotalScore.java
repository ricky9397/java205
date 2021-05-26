package ch06;

public class TotalScore {
	String name;
	int kor, en , math;
	int total;
	float avg;
	
	TotalScore(String name, int kor, int en, int math){
		this.name = name;
		this.kor = kor;
		this.en = en;
		this.math = math;
	}
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
		return total = kor+en+math;
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
	
	public void showInfor() {
		System.out.println("이름 : " + name + " 국어점수 : " + kor + " 영어점수 : " + en + " 수학점수 : " + math);
		System.out.println("총점 : " + getTotal() + " 평균 : " + getAvg());
	}
	
	public static void main(String[] args) {
		
		TotalScore[] ts = new TotalScore[10];
		ts[0] = new TotalScore("홍길동", 100, 80, 70);
		ts[1] = new TotalScore("고길동", 80, 50, 20);
		ts[2] = new TotalScore("이순신", 70, 60, 50);
		ts[3] = new TotalScore("유관순", 40, 40, 60);
		ts[4] = new TotalScore("강호동", 50, 50, 40);
		ts[5] = new TotalScore("김희철", 60, 70, 20);
		ts[6] = new TotalScore("서장훈", 80, 80, 30);
		ts[7] = new TotalScore("이수근", 90, 90, 40);
		ts[8] = new TotalScore("탁재훈", 80, 90, 70);
		ts[9] = new TotalScore("김희선", 80, 90, 80);
		
		for(TotalScore s : ts) {
			s.showInfor();
		}
	}
}
