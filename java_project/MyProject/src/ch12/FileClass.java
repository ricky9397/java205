package ch12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class FileClass {

	public static void main(String[] args) {
		// 현재 날짜와 시간 으로 설정 된다.
		Calendar today = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		File newDir = new File("C:\\Users\\kimzz\\Documents\\GitHub\\java205\\java_project\\MyProject\\메모장");
		
		if(!newDir.exists()) {
			// 폴더생성
			newDir.mkdir();
		}
		String input = null;// 파일 이름 저장
		try {
			System.out.println("파일 이름 입력 >> ");
			input = sc.next(); 
			BufferedWriter out = new BufferedWriter(new FileWriter(input + ".txt"));
			System.out.println("쓰기 시작");
			out.write(today.get(Calendar.YEAR)+"년 "+ today.get(Calendar.MONTH) + "월 " + today.get(Calendar.DATE) +"일");
			out.newLine();
			out.write("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ제목ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("제목입력 >> ");
			out.newLine();
			out.write(sc.next());
			out.newLine();
			out.write("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ메모ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			out.newLine();
			System.out.println("메모입력 >> ");
			out.write(sc.next());
			out.newLine();
			
			out.close();
			System.out.println("작성 완료");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(input + ".txt"));

			// 임시 변수
			String str = null;
			
			while(true) {
				str = in.readLine();
				if(str == null) {
					break;
				}
				System.out.println(str);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
