package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import orders.Order;
import product.Product;


public class AdminDao {

	//싱글톤처리
	private  AdminDao(){}
	static private  AdminDao dao= new  AdminDao() ; 
	public static  AdminDao getInstance() { 
		return dao;
	}



	//주문 테이블의 모든 주문내역 보기
	ArrayList<Order> getOrderList(Connection conn){
		ArrayList<Order> list= null;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from iorder order by ordercode";

			rs = stmt.executeQuery(sql);

			list = new ArrayList<>();

			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getLong(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7) ));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			CloseDB.dbClose(stmt);

		}
		return list;
	}


	// 총 매출보기
	int getSales (Connection conn) {

		int result =0;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select sum(oprice) from product join iorder using (icode)";

			rs = stmt.executeQuery(sql);

			while (rs.next()) { 
				result =rs.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			CloseDB.dbClose(stmt);
		}

		return result;
	}


	//달별 매출 보기
	int getSalesMonth(Connection conn, String dno) {

		int result =0;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			String sql = "select sum(oprice) from product  join iorder using (icode) where substr(orderdate,1,5) = '"+dno+"'";

			rs = stmt.executeQuery(sql); 

			while (rs.next()) {  
				result =rs.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			CloseDB.dbClose(stmt);
		}

		return result;
	}

	
	//일별 매출 보기
	int getSalesDay(Connection conn, String dday) {

		int result =0;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			String sql = "select sum(oprice) from product join iorder using (icode) where substr(orderdate,4,5) = '" +dday+"'";

			
			rs = stmt.executeQuery(sql);


			while (rs.next()) {  
				result =rs.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			CloseDB.dbClose(stmt);

		}

		return result;
	}
	

	//상품테이블에서 상품과 재고 보기
	ArrayList<Product> getInventory(Connection conn){
		ArrayList<Product> list= null;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from product order by icode";

			rs = stmt.executeQuery(sql);

			list = new ArrayList<>();

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4) ));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			CloseDB.dbClose(stmt);
		}

		return list;
	}


	//상품의 재고 수량 더하기
	int putInstance(Connection conn, Product product){
		int result = 0;

		PreparedStatement pstmt = null;


		try {
			String sql = "update product set count=count+? where icode = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getCount());
			pstmt.setInt(2, product.getIcode());


			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			CloseDB.dbClose(pstmt);

		}

		return result;

	}


}


