package ch12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemoBufferedWriter {

	public static void main(String[] args) {
		
		// 메모장 파일을 저장
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("MEMO.txt"));
			
			System.out.println("=======메모장======");
			out.write("2021.06.02");
			out.newLine();
			out.write("비트캠프205기");
			out.newLine();
			out.write("오늘 자바 IO스트림을 배웠다");
			out.newLine();
			
			out.close();
			
			System.out.println("작성완료");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
