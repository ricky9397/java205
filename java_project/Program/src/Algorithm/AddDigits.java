package Algorithm;

import java.util.Scanner;

public class AddDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int[] arr = new int[100];
		
		arr[1] = 1;
		arr[2] = 1;
		for(int i=3; i<100; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		for(int i=1; i<=s; i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
	
		int num1, num2, sum;
		num1=0;  // 첫번째와 두번째 값이 1이어야 하므로 초기값을 0 과
	    num2=1;  // 1로 준다.
	    sum=1;   // 첫번째 1은 그냥 초기값으로 설정
		
		for(int i=0; i<10; i++) {
			System.out.print(sum+" ");
			sum=num1+num2;  // 두 값을 더한 후
			num1=num2;
			num2=sum; // 두번째 연산자에 더한 값을 넣어준다.
		}
	}

}
