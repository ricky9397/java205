package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import util.ConnectionProvider;

public class IdCheckService {
	public String idCheck(String memberId) {
		String result = "n";
		
		Connection conn = null;
		MemberDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			int cnt = dao.selectById(conn, memberId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
	}
}
