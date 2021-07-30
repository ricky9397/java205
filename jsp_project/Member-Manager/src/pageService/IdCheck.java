package pageService;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import util.ConnectionProvider;

public class IdCheck {
	private IdCheck(){}
    private static IdCheck service = new IdCheck();
    public static IdCheck getInstance(){
        return service;
    }
    public String idCheck(String memberId){
        int cnt = 0;
        Connection connection = null;
        MemberDao memberDao = null;

        try {
            connection = ConnectionProvider.getConnection();
            memberDao = MemberDao.getInstance();

            cnt = memberDao.selectById(connection, memberId);
            // result = cnt > 0 ? "N" : "Y";
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cnt > 0 ? "N" : "Y";
    }
}
