package ex.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ObjectSerializable {

	public static void main(String[] args) {
		
		// 인스턴스를 저장
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
			
			out.writeObject(new Circle(1, 1, 2.4));
			out.writeObject(new Circle(3, 5, 7.9));
			out.writeObject("Hello");
			
			ArrayList<Circle> list = new ArrayList<>();
			list.add(new Circle(1, 4, 3.4));
			list.add(new Circle(5, 2, 7.8));
			list.add(new Circle(7, 6, 13.4));
			list.add(new Circle(8, 7, 24.4));
			list.add(new Circle(21, 20, 33.4));
			out.writeObject(list);
			
			out.close();
			
			System.out.println("인스턴스 저장 완료");
			
			// 인스턴스 복원
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
			
			// 복원 순서는 저장순서에 맞게 복원
			Circle c1 = (Circle) in.readObject();
			Circle c2 = (Circle) in.readObject();
			String str = (String) in.readObject();
			
			ArrayList<Circle> list2 = (ArrayList<Circle>) in.readObject();
			
			for (Circle circle : list2) {
				circle.showData();
			}
			
			System.out.println("복원된 인스턴스의 데이터를 출력");
			
			c1.showData();
			c2.showData();
			System.out.println(str);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class Circle implements Serializable {
	
	// implements Serializable : 직렬화 대상임을 의미
	
	int x;
	int y;
	double r;
	
	public Circle(int x, int y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public void showData() {
		System.out.println("원점 ["+ x +"," + y + "]");
		System.out.println("반지름 : " + r);
	}
	
}
