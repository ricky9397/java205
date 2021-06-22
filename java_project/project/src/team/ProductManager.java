package team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import teamDAO.ProductDAO;
import teamDTO.Order;
import teamDTO.Product;

public class ProductManager {
	private ProductDAO dao;
	private Scanner sc;
	ArrayList<Order> arr = new ArrayList<Order>();
	public ProductManager(ProductDAO dao) {
		this.dao = dao;
		sc = new Scanner(System.in);
	}

	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "tiger";


	public void productList() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			List<Product> list = dao.getProductList(conn);

			System.out.println("-----------메뉴입니다-----------");
			System.out.println("-----------------------------");
			System.out.println("상품번호 \t 상품이름 \t 상품가격");
			System.out.println("-----------------------------");

			for (Product pro : list) {
				System.out.printf("%d \t %s \t %s \n", pro.getIcode(), pro.getIname(), pro.getIprice());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
