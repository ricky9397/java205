package test;

public class Calculator {
	
	static int add(int a, int b) {
		return a + b;
	}
	static int subtract(int a, int b) {
		return a - b;
	}
	static int multiply(int a, int b) {
		return a * b;
	}
	static int divide(int a, int b) {
		return a / b;
	}
	public static void main(String[] args) {
		System.out.println(add(10, 5));
		System.out.println(subtract(10, 5));
		System.out.println(multiply(10, 5));
		System.out.println(divide(10, 5));
	}
}
