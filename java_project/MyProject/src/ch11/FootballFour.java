package ch11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FootballFour {

	public static void main(String[] args) {
		HashMap<Integer, FootballPlayer> arr = new HashMap<Integer, FootballPlayer>();
		
		arr.put(1, new FootballPlayer("이동국", 1, "전북", 43));
		arr.put(3,new FootballPlayer("박지성", 3, "성남", 40));
		arr.put(5,new FootballPlayer("손흥민", 4, "안양", 30));
		arr.put(6,new FootballPlayer("이청용", 5, "울산", 34));
		arr.put(2,new FootballPlayer("기성용", 6, "서울", 33));
		
		Set<Integer> set = arr.keySet();
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(arr.get(itr.next()));
		}
	}
}
