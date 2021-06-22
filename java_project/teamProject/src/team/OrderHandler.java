package team;

import java.util.ArrayList;

import teamDAO.OrderDAO;
import teamDTO.Order;

public class OrderHandler {
	ArrayList<Order> arr = new ArrayList<Order>();
	OrderDAO dao = new OrderDAO();
	
	
	public void orderMenu() {
		while(true) {
			System.out.println("어서오세요 아이스크림가게입니다.");
			System.out.println("[1]모든메뉴보기");
		}
	}
}
