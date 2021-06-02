package ch12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MemoBufferedRead {

	public static void main(String[] args) {
		
		// 메모장 파일을 읽어옴.
		try {
			BufferedReader in = new BufferedReader(new FileReader("MEMO.txt"));

			String str = null;

			while(true) {
				str = in.readLine();

				if(str == null) {
					break;
				}
			}

			System.out.println(str);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
