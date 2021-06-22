package teamDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import teamDTO.Order;

public class OrderDAO {
	public ArrayList<Order> getOrderList(Connection conn) {

		ArrayList<Order> list = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from iorder where icode=1, count=?, price=?";

			rs = stmt.executeQuery(sql);

			list = new ArrayList<>();

			while (rs.next()) {
				Order d = new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
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

		int result = 0;
		PreparedStatement pstmt = null;
		try {

			String sql = "insert into iorder values (1, 1, ?, 1, 1, sysdate, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, order.getIcode());
			pstmt.setInt(2, order.getCount());

			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
}
