package ch07;

public class Person {
	String name;
	String number;
	
	public Person(String name, String number) {
		this.name = name;
		this.number = number;
	}

	void introduction() {
		int age = Integer.parseInt(number.substring(0,2));
		if(age > 23) {
			age = 2021-Integer.parseInt(number.substring(0,2))-1900+1;
		}else{
			age = 2021-Integer.parseInt(number.substring(0,2))-2000+1;
		}
		
		System.out.println("안녕하세요. 저는 " + name +"입니다. "
				+ age +"살 입니다.");
	}
	
}



