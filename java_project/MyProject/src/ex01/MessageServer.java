package ex01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class MessageServer {

	public static void main(String[] args) {
		
		DataInputStream din = null;
		DataOutputStream dout = null;
		ServerSocket ss = null;
		Socket s = null;
		
		try {
			
			ss = new ServerSocket(8888);
			System.out.println("서버 실행");
			System.out.println("------------------------------------");
			s = ss.accept();
			System.out.println("client 접속");
			System.out.println("------------------------------------");
			
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			Scanner sc = new Scanner(System.in);
			
			String str1 = null; // 받는 메세지
			String str2 = ""; // 보내는 메세지
			
			while(!str2.equals("exit")) {
				
				str1 = din.readUTF();
				System.out.println("Client Massage" + str1);
				
				str2 = sc.nextLine();
				dout.writeUTF(str2);
				dout.flush();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			Utill.close(din);
			Utill.close(dout);
			Utill.close(s);
			Utill.close(ss);
			
//			if(din != null) {
//				try {
//					din.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			if(dout != null) {
//				try {
//					dout.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			if(s != null) {
//				try {
//					s.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			if(ss != null) {
//				try {
//					ss.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
	}
}
