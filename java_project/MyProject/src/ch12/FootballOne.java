package ch12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FootballOne {

	public static void main(String[] args) {
		File newDir = new File("C:\\Users\\kimzz\\Documents\\GitHub\\java205\\java_project\\MyProject\\축구선수명단");

		if(!newDir.exists()) {
			// 폴더생성
			newDir.mkdir();
		}
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(newDir, "Football.ser")));
			
			List<FootballPlayer> arr1 = new ArrayList<FootballPlayer>();

			arr1.add(new FootballPlayer("이동국", 1, "전북", 43));
			arr1.add(new FootballPlayer("이동국", 2, "전북", 43));
			arr1.add(new FootballPlayer("박지성", 3, "전북", 40));
			arr1.add(new FootballPlayer("손흥민", 4, "서울", 30));
			arr1.add(new FootballPlayer("이청용", 5, "울산", 34));
			arr1.add(new FootballPlayer("이청용", 6, "울산", 34));
			arr1.add(new FootballPlayer("기성용", 7, "서울", 33));
			
			out.writeObject(arr1);
			out.close();
			System.out.println("인스턴스 저장 완료");
			
			// 인스턴스 복원
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(newDir, "Football.ser")));
			List<FootballPlayer> arr2 = (List<FootballPlayer>) in.readObject();
			
			for(FootballPlayer foot : arr2) {
				System.out.println(foot.toString());
			}
			System.out.println("복원된 인스턴스의 데이터 출력");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
