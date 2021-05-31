package ch09;

public class Person {
	String name;
	String personNumber;
	
	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", personNumber=" + personNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) {
			return false;
		}
		Person p = (Person)obj;
		return personNumber == p.personNumber;
	}
}
