package ch11;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class FootballThree {

	public static void main(String[] args) {
		TreeSet<FootballPlayer> arr = new TreeSet<FootballPlayer>();
		
		arr.add(new FootballPlayer("호날두", 7, "유벤투스", 37));
		arr.add(new FootballPlayer("메시", 10, "바르셀로나", 35));
		arr.add(new FootballPlayer("가레스베일", 9, "토트넘", 21));
		arr.add(new FootballPlayer("네이마르", 10, "파리 생제르맹", 30));
		arr.add(new FootballPlayer("음바페", 7, "파리 생제르맹", 24));
		arr.add(new FootballPlayer("피에르에밀호이비에르", 5, "토트넘", 28));
		arr.add(new FootballPlayer("다빈손산체스", 6, "토트넘", 31));
		arr.add(new FootballPlayer("손흥민", 7, "토트넘", 30));
		arr.add(new FootballPlayer("해리윙크스", 8, "토트넘", 27));
		arr.add(new FootballPlayer("가레스베일", 9, "토트넘", 26));
		arr.add(new FootballPlayer("해리케인", 10, "토트넘", 29));
		arr.add(new FootballPlayer("에릭라멜라", 11, "토트넘", 23));
		
		Iterator<FootballPlayer> itr = arr.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
