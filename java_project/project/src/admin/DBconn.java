package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String id = "hr";
	private static String pw = "tiger";
	private static DBconn db = new DBconn();

	private DBconn() {}

	public static DBconn getInstance() {
		return db;
	}

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
