package jdbc;

public class Main {

	public static void main(String[] args) {
		MemberManager m = new MemberManager(MemberDAO.getInstance());
			
			m.run();

	}
}
