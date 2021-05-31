package ch11;

import java.util.*;

public class FootballTwo {

	public static void main(String[] args) {

		Set<FootballPlayer> arr = new HashSet<FootballPlayer>();
		
		arr.add(new FootballPlayer("이동국", 19, "전북", 43));
		arr.add(new FootballPlayer("이동국", 19, "전북", 43));
		arr.add(new FootballPlayer("이청용", 72, "울산", 34));
		arr.add(new FootballPlayer("기성용", 8, "서울", 33));

		Iterator<FootballPlayer> itr = arr.iterator();
		while(itr.hasNext()) {
			FootballPlayer currentStr = itr.next();
			System.out.println(currentStr);
		}

	}
}
