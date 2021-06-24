package team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import teamDAO.OrderDao;
import teamDAO.ProductDao;
import teamDTO.Order;
import teamDTO.Product;

public class OrderManager {
	ProductManager p;
	ProductDao pdao;
	Scanner sc;
	OrderDao odao ;
	ArrayList<Product> pro;
	ArrayList<Order> arr;
	long ordercode;

	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "tiger";


	public OrderManager() {
		odao = new OrderDao();
		p = new ProductManager();
		pdao = new ProductDao();
		arr = new ArrayList<Order>();
		sc = new Scanner(System.in);
	}

	void orderinsert() {
		Connection conn = null;
		arr.clear();

		try {
			Order or =null;

			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			conn.setAutoCommit(false);
			pro = pdao.getProductList(conn);


			while (true) {
				or = new Order();
				p.productList();
				System.out.println("주문하실 메뉴 번호를 선택해주세요.");
				int a = sc.nextInt();
				or.setIcode(a);
				System.out.println("주문 수량을 선택해주세요.");
				int b = sc.nextInt();
				or.setCount(b);
				
				for (int i = 0; i < pro.size(); i++) {
					if(pro.get(i).getIcode() == a) {
						or.setPrice(pro.get(i).getIprice()*b);
						break;
					}
				}

				arr.add(or);
				
				System.out.println(" [1]  계속 주문하기 ,  [2] 결제하기  , [3] 돌아가기 ");
				String input = sc.next();
				

				if (input.equalsIgnoreCase(	"1")) {
					
					System.out.println();
					continue;

				} else if (input.equalsIgnoreCase("2")) {
					System.out.println("감사합니다. ");
					break;
				}else if (input.equalsIgnoreCase("3")) {
					arr.clear();
					System.out.println("이전으로 돌아갑니다.");
					return;
				
				} else {
					System.out.println("잘못입력하셨습니다. .");
					return;
				}
			}			
			
			ordercode = System.nanoTime();

			for (int i = 0; i < arr.size(); i++) {

				arr.get(i).setOrdercode(ordercode);
				int result = odao.orderInsert(conn, arr.get(i));
			}
			for (int i = 0; i < arr.size(); i++) {

				int result = odao.updateProduct(conn, arr.get(i));
			}

			conn.commit();

		} catch (SQLException e) { 
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}


		orderList(ordercode);

	}

	void orderList(long ordercode) {
		Connection conn = null;
		Order order = new Order();
		try {		
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			arr = odao.getOrderList(conn, order);

			int sum =0;
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■영수증■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("-----------------------------------------------------------------");
			for (int i = 0; i < arr.size(); i++) {
				if(ordercode ==arr.get(i).getOrdercode()) {

					System.out.printf(" 상품번호 : %d번 | 구매 수량 : %d개 | 구매가격 : %d원 |주문날짜 :%s \n" ,arr.get(i).getIcode(),arr.get(i).getCount(),arr.get(i).getPrice(),arr.get(i).getOrderdate());
					sum += arr.get(i).getPrice();

				}

			}
			System.out.println("-----------------------------------------------------------------");
			System.out.println("      총 구매 내역 :  \t\t "+sum +"원");
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void menu() {
		System.out.println("주문을 시작합니다. ");
		while (true) {
			System.out.println("[1]주문하기   [0]돌아가기");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				orderinsert();
				break;
			case 0:
				return;
			default : 
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
		}
	}
}