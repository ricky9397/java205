package ch09;

public class Person {
	private String name;
	private String personNumber;
	
	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonNumber() {
		return personNumber;
	}
	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", personNumber=" + personNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj != null && obj instanceof Person) {
			Person p = (Person) obj;
			result = this.personNumber.equals(p.getPersonNumber());
		}
		return result;
	}
	
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
