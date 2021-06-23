package teamDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import teamDTO.Order;
import teamDTO.Product;

public class ProductDAO {
	
	// 아이스크림 메뉴 출력
	public ArrayList<Product> getProductList(Connection conn) {

		ArrayList<Product> list = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from product";

			rs = stmt.executeQuery(sql);

			list = new ArrayList<>();

			while (rs.next()) {
				Product d = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
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
	
	// 아이스크림 등록
	public int insertProduct(Connection conn, Product product) {

		int result = 0;
		PreparedStatement pstmt = null;
		try {

			String sql = "insert into product (icode, iname, iprice, count) values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getIcode());
			pstmt.setString(2, product.getIname());
			pstmt.setInt(3, product.getIprice());
			pstmt.setInt(4, product.getCount());

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
	
	// 아이스크림 수정
	int updateProduct(Connection conn, Product product) {

		int result = 0;
		PreparedStatement pstmt = null;

		try {

			String sql = "update product set iname=?, iprice=?, count=? where icode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getIname());
			pstmt.setInt(2, product.getIprice());
			pstmt.setInt(3, product.getCount());
			pstmt.setInt(4, product.getIcode());
			
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
	
	// 아이스크림 삭제
	int deleteProduct(Connection conn, int product) {

		int result = 0;

		PreparedStatement pstmt = null;

		try {
			String sql = "delete from product where icode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product);

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


