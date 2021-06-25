package teamDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import teamDTO.Order;
import teamDTO.Product;

public class AdminDao {

	// 1. 외부 클래스 또는 인스턴스에서 해당 클래스로 인스턴스를 생성하지 못하도록 처리.
	private  AdminDao(){   //생성자에 프라이빗 붙인다. 외부에서 생성자 호출 불가능.외부에서 인스턴스 호출이 불가능해진다.

	}
	// 2. 클래스 내부에서 인스턴스를 만들고 
	static private  AdminDao dao= new  AdminDao() ;  //스테틱붙여줌. 생성자호출이 가능하다. 수정하지못하도록 private 사용// 스테틱은 프로그램 시작할때 메모리에 올라가기때문에 바로 인스턴스생성됨.


	// 3. 메소드를 통해서 반환하도록 처리 
	public static  AdminDao getInstance() { // 요것도 스테틱. // 클래스 내부에서 만든 인스턴스를 반환함. //외부에서 DeptDao 인스턴스를 쓰고 싶으면 이 메소드를 통해서만 사용가능하다. 새로 만들진 못한다. 하나만 생성
		return dao;
	}



	//주문 테이블의 모든 주문내역 보기
	ArrayList<Order> getOrderList(Connection conn){
		ArrayList<Order> list= null;

		//데이터 베이스의 테이블 이용 select결과를 -> list에 저장 
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from iorder order by ordercode";

			//결과 받아오기
			rs = stmt.executeQuery(sql);

			list = new ArrayList<>();

			//데이터를 Order 객체로 생성 -> list에 저장
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getLong(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7) ));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


		}
		return list;
	}


	//총 매출보기
	//반영 횟수 반환 
	//사용자로부터 데이터 받기 -> order 객체 
	int getSales (Connection conn) {


		int result =0;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select sum(oprice) from product join iorder using (icode)";

			//결과 받아오기
			rs = stmt.executeQuery(sql);



			while (rs.next()) {  //첫번째 , 두번쨰, 컬럼의 위치로 찾을수 있따
				result =rs.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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



			//결과 받아오기
			rs = stmt.executeQuery(sql);



			while (rs.next()) {  //첫번째 , 두번쨰, 컬럼의 위치로 찾을수 있따
				result =rs.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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


			//결과 받아오기
			rs = stmt.executeQuery(sql);



			while (rs.next()) {  //첫번째 , 두번쨰, 컬럼의 위치로 찾을수 있따
				result =rs.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}



		return result;
	}

	//재고 보기
	ArrayList<Product> getInventory(Connection conn){
		ArrayList<Product> list= null;

		//데이터 베이스의 테이블 이용 select결과를 -> list에 저장 
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from product order by icode";

			//결과 받아오기
			rs = stmt.executeQuery(sql);

			list = new ArrayList<>();

			//데이터를 product 객체로 생성 -> list에 저장
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4) ));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}



		return list;
	}


	//	//재고 넣기
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
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}


		return result;

	}

}
