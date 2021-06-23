package team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;

import teamDAO.OrderDAO;
import teamDAO.ProductDAO;
import teamDTO.Order;
import teamDTO.Product;

public class OrderManager {
	ProductManager p;
	ProductDAO pdao;
	OrderDAO odao = new OrderDAO();
	ArrayList<Product> pro;
	Scanner sc;
	ArrayList<Order> arr;
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "tiger";
	
	public OrderManager() {
		 p = new ProductManager();
		 pdao = new ProductDAO();
		 
		 arr = new ArrayList<Order>();
		 sc = new Scanner(System.in);
	}

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
		Order order = new Order();
		try {		
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			arr = odao.getOrderList(conn, order);
			
			System.out.println("회원번호를 입력해주세요");
			int tmp = sc.nextInt();
			int cnt = 0;
			
			for (int i = 0; i < arr.size(); i++) {
				if(tmp == arr.get(i).getIdx()) {
					System.out.println("----------------------------영수증--------------------------------");
					System.out.println("----------------------------------------------------------------");
					System.out.println("주문번호 : " + arr.get(i).getOidx());
					System.out.println("주문코드 : " + arr.get(i).getOrdercode());
					System.out.println("상품번호 : " + arr.get(i).getIcode());
					System.out.println("회원번호 : " + arr.get(i).getIdx());
					System.out.println("주문날짜 : " + arr.get(i).getOrderdate());
					System.out.println("구매갯수 : " + arr.get(i).getCount());
					System.out.println("구매가격 : " + arr.get(i).getPrice());
					System.out.println("----------------------------------------------------------------");
					cnt++;
//					break;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	void delOrder() {
//
//		Connection conn = null;
//
//		try {
//			conn = DriverManager.getConnection(jdbcUrl, user, pw);
//
//			orderList();
//			System.out.println("삭제 원하시는 메뉴번호를 선택해주세요.");
//			int order = Integer.parseInt(sc.nextLine());
//
//			int result = odao.deleteProduct(conn, order);
//
//			if (result > 0) {
//				System.out.println("삭제되었습니다.");
//			} else {
//				System.out.println("삭제실패!");
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

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
//				delOrder();
				break;
			case 0:
				continue;
			}
		}
	}

}
