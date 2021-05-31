package ch11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FootballOne {

	public static void main(String[] args) {
		
		List<FootballPlayer> arr = new ArrayList<FootballPlayer>();
		
		arr.add(new FootballPlayer("호날두", 7, "유벤투스", 37));
		arr.add(new FootballPlayer("메시", 10, "바르셀로나", 35));
		arr.add(new FootballPlayer("네이마르", 10, "파리 생제르맹", 30));
		arr.add(new FootballPlayer("음바페", 7, "파리 생제르맹", 24));
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).toString());
		}
	}
}
