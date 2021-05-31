package ch11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FootballOne {

	public static void main(String[] args) {
		
//		FootballPlayer f1 = new FootballPlayer("손흥민", 10, "토트넘", 30);
//		FootballPlayer f2 = new FootballPlayer("박지성", 30, "맨유", 36);
//		arr.add(f1);
//		arr.add(f2);
//		arr.add(new FootballPlayer("드록바", 20, "첼시", 40));
//		arr.add(new FootballPlayer("루니", 40, "맨유", 35));
//		
//		for(int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i).toString());
//		}
//		
		List<FootballPlayer> arr = new ArrayList<FootballPlayer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("선수이름을 입력하세요 >> ");
		String name = sc.next();
		System.out.println("선수 번호를 입력하세요 >> ");
		int number = sc.nextInt();
		System.out.println("선수 팀이름을 입력하세요 >> ");
		String team = sc.next();
		System.out.println("선수 나이를 입력하세요 >> ");
		int age = sc.nextInt();
		
		arr.add(new FootballPlayer(name, number, team, age));
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).toString());
		}
	}
}
