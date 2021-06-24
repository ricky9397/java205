package teamDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import teamDTO.Order;
import teamDTO.Product;

public class OrderDao {

	public ArrayList<Order> getOrderList(Connection conn, Order order) {

		ArrayList<Order> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from iorder order by oidx";

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
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

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
			pstmt.setInt(5, order.getPrice());
			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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

	public int deleteProduct(Connection conn, int order) {

		int result = 0;

		PreparedStatement pstmt = null;

		try {
			String sql = "delete from order where oidx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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
