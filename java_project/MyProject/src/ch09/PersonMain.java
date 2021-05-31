package ch09;

public class PersonMain {

	public static void main(String[] args) {
		Person p1 = new Person("홍길동", "900630-1015124");
		Person p2 = new Person("고길동", "900630-1015124");
		
		if(p1.equals(p2)) {
			System.out.println("주민번호가 같습니다.");
		} else {
			System.out.println("주민번호가 같지 않습니다.");
		}
	}

}
