package orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import admin.DBconn;
import member.MemberManager;
import product.Product;
import product.ProductDao;
import product.ProductManager;


public class OrderManager {
	ProductManager p;
	ProductDao pdao;
	Scanner sc;
	OrderDao odao ;
	ArrayList<Product> pro;
	ArrayList<Order> arr;
	long ordercode;
	private static Connection conn = DBconn.getConnection();


	public OrderManager(OrderDao order, ProductDao product) {
		this.pdao = product;
		this.odao = order;
		p = new ProductManager(pdao);
		arr = new ArrayList<Order>();
		sc = new Scanner(System.in);
	}

	
	// 주문 테이블에 주문항목 추가하기
	void orderinsert() {
		
		arr.clear(); //새로운 주문시에 ArrayList에 담긴 내역 초기화 (장바구니초기화)
		
		try {
			Order or =null;

			conn.setAutoCommit(false); //트랜잭션 시작
			pro = pdao.getProductList(conn);


			while (true) {
				or = new Order(MemberManager.idx);  //로그인한 회원의 회원코드를 주문테이블에 넣기위해 사용.
				p.productList();
				System.out.println();
				System.out.println("▶ ▶ 주문하실 메뉴 번호를 선택해주세요.");
				int a = sc.nextInt();
				or.setIcode(a);
				System.out.println("▶ ▶주문 수량을 선택해주세요.");
				int b = sc.nextInt();
				or.setCount(b);
				
				for (int i = 0; i < pro.size(); i++) {
					if(pro.get(i).getIcode() == a) {
						or.setOprice(pro.get(i).getIprice()*b);
						break;
					}
				}

				arr.add(or); // 주문한 내역을 ArrayList에 담기
				
				System.out.println("  ☞ 장바구니 담기 완료 ! \n");
				
				System.out.println(" [1]  계속 주문하기 ,  [2] 결제하기  , [3] 돌아가기 ");
				String input = sc.next();
				

				if (input.equals("1")) { 
					System.out.println();
					continue;

				} else if (input.equals("2")) {
					System.out.println();
					break;
				}else if (input.equals("3")) { 
					arr.clear(); //돌아갈때 담았던 ArrayList 초기화
					System.out.println("이전으로 돌아갑니다.");
					return;
				
				} else {
					System.out.println("※ 잘못입력하셨습니다.");
					return;
				}
			}			
			
			ordercode = System.nanoTime(); //동일회원이 여러번 주문할때 한번의 주문으로 처리하기 위한 주문테이블의 임의의 키값.//구동중인 JVM에서 임의로 고정된 구간으로부터 현재 나노세컨즈nanoseconds 값을 반환

			for (int i = 0; i < arr.size(); i++) { //장바구니의 길이만큼 같은 키값을 부여한다.

				arr.get(i).setOrdercode(ordercode);
				int result = odao.orderInsert(conn, arr.get(i));
			}
			
			for (int i = 0; i < arr.size(); i++) { //장바구니의 길이만큼 주문할때마다 상품의 재고 감소시키기

				int result = odao.updateProduct(conn, arr.get(i));
			}

			conn.commit(); //트랜잭션 완료

		} catch (SQLException e) { 
			try {
				conn.rollback(); // 트랜잭션 수행중 에러시 이전 단계로 롤백
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}


		orderList(ordercode);

	}

	//주문한 내역의 영수증  
	void orderList(long ordercode) {
		
		Order order = new Order();
		try {		

			arr = odao.getOrderList(conn, order);

			int sum =0;
			System.out.println("  ▶ 결제 완료 \n");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■영수증■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("------------------------------------------------------------------------------");
			for (int i = 0; i < arr.size(); i++) {
				if(ordercode ==arr.get(i).getOrdercode()) {

					System.out.printf(" 상품번호 : %d번 | 구매 수량 : %d개 | 구매가격 : %d원 | 주문날짜 :%s \n" ,arr.get(i).getIcode(),arr.get(i).getCount(),arr.get(i).getOprice(),arr.get(i).getOrderdate());
					sum += arr.get(i).getOprice();

				}

			}
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("      ☞ 총 구매 내역 :  \t\t   "+sum +" 원");
			System.out.println("------------------------------------------------------------------------------");
			System.out.println();
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

