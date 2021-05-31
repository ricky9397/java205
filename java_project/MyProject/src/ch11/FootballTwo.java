package ch11;

import java.util.*;

public class FootballTwo {

	public static void main(String[] args) {

		Set<FootballPlayer> arr = new HashSet<FootballPlayer>();
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("선수이름을 입력하세요 >> ");
			String name = sc.next();
			System.out.println("선수 번호를 입력하세요 >> ");
			int number = sc.nextInt();
			System.out.println("선수 팀이름을 입력하세요 >> ");
			String team = sc.next();
			System.out.println("선수 나이를 입력하세요 >> ");
			int age = sc.nextInt();
			
			FootballPlayer f1 = new FootballPlayer(name, age, team, age);
			arr.add(f1);
			FootballPlayer f2 = new FootballPlayer(name, age, team, age);
			arr.add(f2);
//			arr.add(new FootballPlayer(name, age, team, age));

			Iterator<FootballPlayer> itr = arr.iterator();
			while(itr.hasNext()) {
				FootballPlayer currentStr = itr.next();
				System.out.println(currentStr);
			}
			if(f1.equals(f2)) {
				System.out.println("이름이 같습니다.");
				break;
			}
		}

	}
}
