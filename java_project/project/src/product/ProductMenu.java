package product;

import java.util.Scanner;

public class ProductMenu {
	public static void ProductMenu() {
		Scanner sc = new Scanner(System.in);

		ProductManager pm = new ProductManager(ProductDao.getInstance());

		while(true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■ 상품 수정 메뉴입니다 ■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("   1번 : 상품 추가    |     2번 : 상품 수정    \n");
			int choice = Integer.parseInt(sc.nextLine());

			switch(choice) {
			case 1 : 
				pm.productList();
				pm.productInsert();
				break;
			case 2 : 
				pm.productList();
				pm.productUpdate();
				pm.productList();
				break; 
				
			default : 
				System.out.println("※ 잘못입력하셨습니다.");
				continue;
			}
			break;
		}
	}

}
