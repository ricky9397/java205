package team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import teamDAO.OrderDAO;
import teamDAO.ProductDAO;
import teamDTO.Order;
import teamDTO.Product;

public class OrderManager {
	ProductManager p = new ProductManager();
	ProductDAO pdao = new ProductDAO();
	OrderDAO odao = new OrderDAO();
	ArrayList<Product> pro ;
	Scanner sc = new Scanner(System.in);
	ArrayList<Order> arr = new ArrayList<Order>();
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "tiger";

	void orderinsert() {
		Connection conn = null;

		try {
			Order or = new Order();

			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			
			conn.setAutoCommit(false);
			pro = pdao.getProductList(conn);
			
			
			while (true) {
				System.out.println("주문하실 메뉴를 선택해주세요.");
				int a = sc.nextInt();
				or.setIcode(a);
				System.out.println("주문하실 갯수를 선택해주세요.");
				int b = sc.nextInt();
				or.setCount(b);
				
				for (int i = 0; i < pro.size(); i++) {
					if(pro.get(i).getIcode() == a) {
						or.setPrice(pro.get(i).getIprice()*b);
						break;
					}
				}
				
				System.out.println("주문하시 겠습니까?[y],[n]");
				String input = sc.next();
				if (input.equalsIgnoreCase("y")) {
					arr.add(or);
					System.out.println("주문되셨습니다.감사합니다.");
					break;
				} else if (input.equalsIgnoreCase("n")) {
					System.out.println("다시입력해주세요.");
				} else {
					System.out.println("잘못입력하셨습니다. 초기화면으로 이동합니다.");
					break;
				}
			}
			
			long ordercode = System.nanoTime();
			
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	void orderList() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			List<Order> list = odao.getOrderList(conn);

			System.out.println("------------주문내역-------------");
			System.out.println("------------------------------");
			System.out.println("상품번호 \t 상품갯수 \t 상품가격");
			System.out.println("-----------------------------");

			for (Order pro : list) {
				System.out.printf("%d \t %d \t %d \n", pro.getIcode(), pro.getCount(), pro.getPrice());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void delOrder() {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			orderList();
			System.out.println("삭제 원하시는 메뉴번호를 선택해주세요.");
			int order = Integer.parseInt(sc.nextLine());

			int result = odao.deleteProduct(conn, order);

			if (result > 0) {
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("삭제실패!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void menu() {
		while (true) {
			System.out.println("[1]주문하기 [2]주문내역확인 [3]주문취소 [0]돌아가기");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				p.productList();
				orderinsert();
				break;
			case 2:
				orderList();
				break;
			case 3:
				delOrder();
				break;
			case 0:
				continue;
			}
		}
	}

}
