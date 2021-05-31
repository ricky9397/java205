package ch08;

public class CalulatorMain {

	public static void main(String[] args) {
		CalulatorTwo cal = new CalulatorTwo();
		Calulator calulator = cal;
		
		System.out.println(calulator.add(10, 20));
		System.out.println(calulator.substract(20, 10));
		System.out.println(calulator.multiply(10, 20));
		System.out.println(calulator.divide(10, 5));
	}

}
