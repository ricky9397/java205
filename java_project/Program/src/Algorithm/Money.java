package Algorithm;

import java.util.Scanner;

public class Money {

	public static void main(String[] args) {
		int[] arr = {50000,10000,1000,500,100,50};
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "원" + money/arr[i]);
			money %= arr[i];
		}
	}

}
