package ch11;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class FootballThree {

	public static void main(String[] args) {
		TreeSet<FootballPlayer> arr = new TreeSet<FootballPlayer>();
		
		arr.add(new FootballPlayer("이동국", 1, "전북", 43));
		arr.add(new FootballPlayer("이동국", 2, "전북", 43));
		arr.add(new FootballPlayer("박지성", 3, "전북", 40));
		arr.add(new FootballPlayer("손흥민", 4, "서울", 30));
		arr.add(new FootballPlayer("이청용", 5, "울산", 34));
		arr.add(new FootballPlayer("이청용", 6, "울산", 34));
		arr.add(new FootballPlayer("기성용", 7, "서울", 33));
		
		Iterator<FootballPlayer> itr = arr.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
