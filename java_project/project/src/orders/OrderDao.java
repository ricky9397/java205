package orders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.CloseDB;
import product.Product;


public class OrderDao {

	//싱글톤 처리
	private OrderDao() {};
	static private OrderDao dao = new OrderDao();
	public static OrderDao getInstance() {
		return dao;
	}

	//주문테이블에서 주문내역 읽어오기
	public ArrayList<Order> getOrderList(Connection conn, Order order) {

		ArrayList<Order> list = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from iorder";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			list = new ArrayList<>();

			while (rs.next()) {
				Order d = new Order(rs.getInt(1), rs.getLong(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
				list.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseDB.dbClose(rs);
			CloseDB.dbClose(stmt);
		}
		return list;
	}

	
	//주문테이블에 주문 내역 추가하기
	public int orderInsert(Connection conn, Order order) {
		Product p = new Product();
		int result = 0;
		PreparedStatement pstmt = null;
		try {

			String sql = "insert into iorder values (iorder_oidx_seq.nextval, ?, ?, ?, sysdate, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, order.getOrdercode());
			pstmt.setInt(2, order.getIcode());
			pstmt.setInt(3, order.getIdx());
			pstmt.setInt(4, order.getCount());
			pstmt.setInt(5, order.getOprice());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("※ 잘못된 입력입니다. ");
			
		} finally {
			CloseDB.dbClose(pstmt);
			
		}
		return result;
	}


	//상품테이블의 재고수량을 구매수량만큼 차감하기
	public int updateProduct(Connection conn, Order order) {

		int result = 0;
		PreparedStatement pstmt = null;

		try {

			String sql = "update product set count = count-? where icode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getCount());
			pstmt.setInt(2, order.getIcode());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseDB.dbClose(pstmt);
		}
		return result;
	}
}