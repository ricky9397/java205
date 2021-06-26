package orders;

import java.util.Scanner;

import product.ProductDao;

public class OrderMenu {
	
	public void oderMenu() {
		Scanner sc= new Scanner(System.in);
		OrderManager oManager = new OrderManager(OrderDao.getInstance(), ProductDao.getInstance());
	
		
		System.out.println("▶ ▶ 주문을 시작합니다.\n ");
		while (true) {
			System.out.println(" [1]주문하기   [0]돌아가기 ");
			int input = sc.nextInt();
			System.out.println();
			switch (input) {
			case 1:
				oManager.orderinsert();
				break;
			case 0:
				return;
			default : 
				System.out.println("※ 잘못입력하셨습니다.");
				continue;
			}
		}
	}
}
