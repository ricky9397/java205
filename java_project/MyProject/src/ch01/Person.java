package ch01;

public class Person {

	String name;
	String number;
	long rsdntRgnmb; 
	
	public static void main(String[] args) {
		
		Person p = new Person();
		p.name = "이순신";
		p.number = "010-5151-5151";
		p.rsdntRgnmb = 8806308485618L;
		
		System.out.println(p.name);
		System.out.println(p.number);
		System.out.println(p.rsdntRgnmb);
	}
}
