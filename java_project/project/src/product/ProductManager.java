package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import admin.DBconn;
import orders.Order;


public class ProductManager {
	private ProductDao dao;
	Scanner sc;
	ArrayList<Order> arr;
	ArrayList<Product> pro;
	private static Connection conn = DBconn.getConnection();


	public ProductManager(ProductDao dao) {
		sc = new Scanner(System.in);
		this.dao = dao;
		arr = new ArrayList<Order>();
		pro = new ArrayList<Product>();
	}

	//상품 테이블에서 상품의 메뉴와 재고확인
	public void productList() {

		try {

			pro = dao.getProductList(conn);

			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ MENU ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("----------------------------------------------------------------");
			System.out.println("상품번호 \t 상품이름 \t\t 상품가격 \t 상품 갯수");
			System.out.println("----------------------------------------------------------------");


			for (Product p : pro) {
				System.out.printf("%d \t %s \t %d \t %d \n", p.getIcode(), p.getIname(),  p.getIprice(), p.getCount());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//상품테이블에 신메뉴 추가하기
	void productInsert() {

		try {

			while(true) {
				Product p = new Product();
				while(true) {
					System.out.println("아이스크림 메뉴번호를 입력해주세요.");
					int icode = Integer.parseInt(sc.nextLine());
					int cnt = 0;
					for (int i = 0; i < pro.size(); i++) {
						if(icode == pro.get(i).getIcode()) {
							cnt++;
							System.out.println("메뉴번호가 중복입니다. 다시입력하세요.");
							break;
						}
					}
					if(cnt != 1) {
						p.setIcode(icode);
						break;
					}
				}
				System.out.println("▶ ▶ 아이스크림 상품명을 입력해주세요. ");
				p.setIname(sc.nextLine());
				System.out.println("▶ ▶ 아이스크림 가격을 입력해주세요.");
				p.setIprice(Integer.parseInt(sc.nextLine()));
				System.out.println("▶ ▶ 아이스크림 수량을 입력해주세요.");
				p.setCount(Integer.parseInt(sc.nextLine()));


				System.out.println("입력하시겠습니까?[1] 예 ,[2] 아니오");
				int input = Integer.parseInt(sc.nextLine());
				if(input==1) {
					pro.add(p);
					int result = dao.insertProduct(conn, p);
					System.out.println("☞ 입력되셨습니다. \n");
					break;
				} else if(input==2) {
					System.out.println("※ 다시입력해주세요.");
				} else {
					System.out.println("※ 잘못입력하셨습니다. 초기화면으로 이동합니다.");
					break;
				}

			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//상품테이블에 기존의 상품 수정 
	void productUpdate() {

		try {

			while(true) {

				System.out.println("▶ ▶ 수정할 아이스크림 정보를 입력해주세요.");
				System.out.println("▶ 상품번호, 상품이름, 상품가격, 상품 갯수 순으로 입력해주세요.");  
				System.out.println("예 ) 1, 바닐라 아이스크림, 2000, 5 ( 쉼표 포함 )");

				String editData = sc.nextLine().trim();

				String[] eData = editData.split(",");
				Product p;
				for(int i =0; i<eData.length;i++) {
					eData[i] = eData[i].trim();
				}
				if(eData.length == 4) {

					for (int i = 0; i < pro.size(); i++) {
						if((Integer.parseInt(eData[0])) == pro.get(i).getIcode()) {
							p = new Product(Integer.parseInt(eData[0]), eData[1], Integer.parseInt(eData[2]), Integer.parseInt(eData[3]));
							int result = dao.updateProduct(conn, p);
							System.out.println("   ☞ 해당 상품 정보가 변경 되었습니다.\n");
							return;

						}
					}

					System.out.println("※ 해당 하는 상품이 없습니다.");
					return;

				} else {
					System.out.println("※ 입력 형식을 올바르게 입력해주세요. ");
					continue;
				}
			}
		} catch (Exception e) {
			System.out.println(" ※ 잘못입력하셨습니다. 이전페이지로 돌아갑니다. ");
		}
	}
}