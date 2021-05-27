package Algorithm;

import java.util.Random;
import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		/*Baseball
		 * random(1~10) ->3개
		 * r1 != r2 != r3 =>같은 숫자가 나오면 안된다.
		 * 10번 기회
		 * machine >> 2 4 5 
		 * input >> 2 4 2 -> 2 strike 1 ball
		 * 끝나면 다시 문제푸시겠습니까?
		 * */
		System.out.println("####strike 3번 맞추기 게임####");
		System.out.println("게임은 총 10번 기회를 드립니다.");
		System.out.print("computer : " );
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int[] arr = new int[3];
		arr[0] = rd.nextInt(10)+1;
		arr[1] = rd.nextInt(10)+1;
		arr[2] = rd.nextInt(10)+1;
		while (arr[0] == arr[1]) {
			arr[1] = rd.nextInt(10)+1;
		}
		while (arr[0] == arr[2] || arr[1] == arr[2]) {
			arr[2] = rd.nextInt(10)+1;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		int flag=10;
		int strike = 0;
		int ball = 0;
		
		while (flag>0) {
			for(int i =0; i<3; i++) {
				arr[i]  = sc.nextInt();
			}
			for(int i=0; i<3; i++){
				for(int j=0; j<3; j++){
					if(arr[i] == arr[j]){
						if(i == j)  {
							strike++;
						}else  
							ball++;
					}
				}
			}
			
			if(strike==3) {
				System.out.println("홈런"); 
				break; 
				}
			flag--;
			if(flag==0) {
				System.out.println("you lose");
			break;
			}
			else { //아닌경우 스트라이크, 볼 횟수, 도전 기회 출력
				System.out.println("strike: " + strike + "\t ball : "+ ball);
				System.out.println(flag+"번 남았음");
			}
		} // whlie end
	}
			
}
