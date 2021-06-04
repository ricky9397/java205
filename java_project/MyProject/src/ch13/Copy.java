package ch13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {

	public static void main(String[] args) {
		ShowCopy copy = new ShowCopy();
		copy.start();
		
		File myFile = new File("C:\\Users\\bitcamp\\Documents\\GitHub\\java205\\java_project\\MyProject\\originCopy.pdf");
		System.out.println(myFile);

		if(!myFile.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		} 
		
		File newDir = new File("C:\\Users\\bitcamp\\Documents\\GitHub\\java205\\java_project\\MyProject\\CopyFile");

		if(!newDir.exists()) {
			// 폴더생성
			newDir.mkdir();
		}
		
		File newFile = new File(newDir, "originCopy.pdf");
		
		myFile.renameTo(newFile);
		
		if(newFile.exists()) {
			System.out.println("복사파일 이동 성공");
		} else {
			System.out.println("복사파일 이동 실패");
		}
	}
}

class ShowCopy extends Thread {
	public void run() {

		try {
			// 1. 파일을 바이너리 데이터를 읽어올 스트림 생성 : FIleInputStream
			InputStream in = new FileInputStream("origin.pdf");

			// 2. 파일을 쓰기위한 스트림 생성 : FileOutputStream
			OutputStream out = new FileOutputStream("originCopy.pdf");

			// 카피한 데이터의 크기
			int copyByte = 0;
			// 파일에서 읽어올 바이트 데이터 배열
			byte[] buf = new byte[1024]; // 1kb 사이즈의 배열
			// 읽어온 데이터 배열의 개수
			int readLen =0;

			while(true) {
				readLen = in.read(buf); // 완료시점 -> -1 반환

				// 탈출의 조건 : 파일의 모든 데이터를 읽은 경우
				if(readLen == -1) {
					break;
				}

				// 출력 : 파일에 데이터를 쓴다
				out.write(buf, 0, readLen);
				copyByte += readLen;
			}

			// 스트림 닫기
			in.close();
			out.close();

			System.out.println("복사완료!!! 복사된 바이트 사이즈 : " + copyByte + "byte");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


