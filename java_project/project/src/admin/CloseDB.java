package admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseDB {
 
	 public static void dbClose(Statement statement){
	        if (statement != null){
	            try {
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 
	    public static void dbClose(PreparedStatement preparedStatement){
	        if (preparedStatement != null){
	            try {
	                preparedStatement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public static void dbClose(ResultSet resultSet){
	        if (resultSet != null){
	            try {
	                resultSet.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	
	}