package admin;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import orders.Order;
import product.Product;

public class AdminManager {

	private AdminDao dao;  //의존성을 낮추기위해 여기서 바로 인스턴스를 생성하면 안된다. 선언만 
	private Scanner sc;
	private static Connection conn = DBconn.getConnection();
	

	public AdminManager(AdminDao dao) { //생성자
		this.dao = dao;
		sc= new Scanner(System.in);
	}


	// 전체 주문 리스트 출력 메소드
	void orderList() {
		
		try {
			List<Order> list = dao.getOrderList(conn);

			System.out.println("주문 정보 리스트 ");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("주문번호 \t 회원번호  \t 상품번호 \t\t 주문날짜 \t\t 상품수량 \t 주문금액 ");
			System.out.println("-----------------------------------------------------------------------");

			for(Order order : list) {
				System.out.printf("%d \t %d \t\t %d \t %s \t %d \t %d \n", order.getOidx(), order.getIdx(),order.getIcode(),order.getOrderdate(),order.getCount(),order.getOprice());

			}
			System.out.println("------------------------------------------------------------------------");


	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	//총 매출 출력
	public void salseManagement() {
		
		try {

			int sum = dao.getSales(conn);

			System.out.println("총 매출은 "+ sum +"원 입니다. ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//달별 매출 출력
	public void salseManagementMonth() {

		try {

			System.out.println("검색하실 월을 입력해주세요.");
			System.out.println("2021년 5월 매출을 보시려면 21/05 형식으로 입력해주세요. ");
			String dno = sc.nextLine();

			 boolean check = Pattern.matches("\\d{2}/\\d{2}", dno);
	         if(check == true) {
	            int sum = dao.getSalesMonth(conn, dno);
	            System.out.println("총 매출은 "+ sum + "원 입니다. ");
	         } else {
	            System.out.println("입력 값이 올바르지 않습니다.");
	            return;
	         }


		} catch (Exception e) {
			System.out.println("잘못입력하셨습니다.");
			e.printStackTrace();
		}
	}

	
	//일별 매출 출력
	public void salseManagementDaily() {

		try {

			System.out.println("검색하실 월과 일자를 입력해주세요. ");
			System.out.println("6월 1일이면 06/01 형식으로 입력해주세요. ");
			String dday = sc.nextLine();

			boolean check = Pattern.matches("\\d{2}/\\d{2}", dday);
	         
	         if(check == true) {
	            int sum = dao.getSalesDay(conn, dday);

	            System.out.println("총 매출은 "+ sum+"원 입니다. ");
	         } else { 
	            System.out.println("입력 값이 올바르지 않습니다.");
	            return;
	         }


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("잘못입력하셨습니다.");
		}
	}

	
	// 재고보기
	public void inventory() {

		try {
			List<Product> list = dao.getInventory(conn);

			System.out.println("상품 재고 리스트 ");
			System.out.println("------------------------------------------------");
			System.out.println("상품번호 \t 상품명 \t\t 상품가격 \t 상품수량");
			System.out.println("-----------------------------------------------");

			for(Product product : list) {
				System.out.printf("%d \t %s \t %d \t\t %d \n", product.getIcode(),product.getIname(),product.getIprice(),product.getCount());

			}
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			e.printStackTrace();
		}
	}

	
	//재고 넣기
	void putIndentory() {

		inventory();
		
		try {
			
			System.out.println("재고 수량을 입력합니다. 상품 번호를 입력해주세요.");
			int icode = sc.nextInt();
			System.out.println("추가하실 재고 수량을 입력해주세요.");
			int count = sc.nextInt();
			
			Product product = new Product (icode , count);
			
			int result = dao.putInstance(conn,product);
			
			if(result >0) {
				System.out.println(" 수정되었습니다.");
				System.out.println();
				inventory();
			}else {
				System.out.println("수정실패 ");
			}
			
		 }catch (NumberFormatException e){
         	System.out.println("숫자로만 입력해주세요.");
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}
		
		
	}

}
