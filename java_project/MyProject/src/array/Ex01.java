package array;

import java.util.Scanner;

public class Ex01 {
	
	public static int minValue(int[] arr) {
		int min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	public static int maxValue(int[] arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(i+1 +"번 점수입력");
			arr[i] = sc.nextInt();
		}
		System.out.println("최하점수:" + minValue(arr));
		System.out.println("최고점수:" + maxValue(arr));
	}

}
