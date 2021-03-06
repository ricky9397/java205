package ch13;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		CountDownThread ct = new CountDownThread();
		InputThread it = new InputThread();
		it.start();
		ct.start();
	}
}

class InputThread extends Thread {
	public void run() {
		Scanner sc = new Scanner(System.in);
		int input = 0; // 입력값
		int random = 0; // 랜덤값
		random = (int)(Math.random()*100)+1;
		do {
			System.out.println("1~100 사이의 숫자를 입력해주세요.");
			input = sc.nextInt();
			if(input > random) {
				System.out.println("하이 입니다."); 
			} else if (input < random) {
				System.out.println("로우 입니다.");
			}
		} while (input != random);
		System.out.println("정답입니다.");
	}
}

class CountDownThread extends Thread {
	
	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {

			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("10초 시간이 지나 프로그램을 종료합니다.");
		System.exit(0);
	}
}
