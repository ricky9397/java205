
package team;

<<<<<<< HEAD
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		OrderManager or = new OrderManager();
		or.menu();
		
		ProductManager p = new ProductManager();
		p.allMenu();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("테스트용");
		int sum = sc.nextInt();
		switch(sum) {
		case 1:
			or.menu();
			break;
		case 2:
			p.allMenu();
			break;
		}
		
	}
=======
public class test {
	public static void main(String[] args) {
		//주문용
//		OrderManager or = new OrderManager(); 
//		or.menu();
		// 메뉴
//		ProductManager p = new ProductManager();
//		p.allMenu();
//		
		
	   }
	
>>>>>>> f0c6da08948f1ac19acc185c11cba5aa8d4aa089
	
}
