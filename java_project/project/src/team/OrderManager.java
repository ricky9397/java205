package team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import teamDAO.OrderDAO;
import teamDTO.Order;

public class OrderManager {
	
	OrderDAO dao = new OrderDAO();
	Scanner sc = new Scanner(System.in);
	ArrayList<Order> arr = new ArrayList<Order>();
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "tiger";

	void Orderinsert() {

		Connection conn = null;

		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			System.out.println("주문하실 메뉴를 선택해주세요.");
			int menu = sc.nextInt();
			System.out.println("주문하실 갯수를 선택해주세요.");
			int sum = sc.nextInt();
			
			Order or = new Order(0, 0, menu, 0, null, 0, sum);
			
			System.out.println("주문하시 겠습니까?[y],[n]");
			String input = sc.next();
			if(input.equalsIgnoreCase("y")) {
				arr.add(or);
				System.out.println("주문되셨습니다.감사합니다.");
			} else if(input.equalsIgnoreCase("n")) {
				System.out.println("다시입력해주세요.");
			} else {
				System.out.println("잘못입력하셨습니다. 초기화면으로 이동합니다.");
			}


			int result = dao.orderInsert(conn, or);

			if(result > 0) {
				System.out.println("입력되었습니다.");
			} else {
				System.out.println("입력 실패!!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void orderList() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			List<Order> list = dao.getOrderList(conn);

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

		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			orderList();
			System.out.println("삭제 원하시는 메뉴번호를 선택해주세요.");
			int order = Integer.parseInt(sc.nextLine());

			int result = dao.deleteProduct(conn, order);

			if(result > 0) {
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("삭제실패!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void menu() {
		while(true) {
			System.out.println("[1]주문하기 [2]주문내역확인 [3]주문삭제 [0]돌아가기");
			int input = sc.nextInt();
			switch(input) {
			case 1:
				// 여기에 카트 만들면 메뉴 넣기 
				Orderinsert();
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
