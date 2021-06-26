package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.CloseDB;
import orders.Order;
import product.Product;

public class ProductDao {

	//싱글톤 처리
	private ProductDao() {}
	static private ProductDao dao = new ProductDao();
	public static ProductDao getInstance() {
		return dao;
	}
	
	
	// 아이스크림 메뉴 출력
	   public ArrayList<Product> getProductList(Connection conn) {

	      ArrayList<Product> list = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         stmt = conn.createStatement();
	         String sql = "select * from product order by icode";

	         rs = stmt.executeQuery(sql);

	         list = new ArrayList<>();

	         while (rs.next()) {
	            Product d = new Product(rs.getInt(1),  rs.getString(2), rs.getInt(3), rs.getInt(4));
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
	   
	   
	   // 아이스크림 신메뉴 등록
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
	         e.printStackTrace();
	      } finally {
	    	  CloseDB.dbClose(pstmt);
	      }
	      return result;
	   }
	   
	   
	   // 아이스크림 메뉴 수정
	   int updateProduct(Connection conn, Product product) {

	      int result = 0;
	      PreparedStatement pstmt = null;

	      try {

	         String sql = "update product set icode=?,iname=?, iprice=?, count=? where icode ='" + product.getIcode() + "'" ;
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, product.getIcode());
	         pstmt.setString(2, product.getIname());
	         pstmt.setInt(3, product.getIprice());
	         pstmt.setInt(4, product.getCount());
	        
	         
	         result = pstmt.executeUpdate();

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	    	  CloseDB.dbClose(pstmt);
	      }
	      return result;
	   }
	   
	}