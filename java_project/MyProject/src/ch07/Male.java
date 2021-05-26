package ch07;

public class Male extends Person {
	String gender;
	float height;
	
	public Male(String name, String number, String gender, float height) {
		super(name, number);
		this.gender = gender;
		this.height = height;
	}
	
	@Override
	void introduction() {
		super.introduction();
		System.out.println( gender + "입니다. " + height + "cm입니다.");
	}
}
