package member.service;

import member.dao.Dao;
import member.domain.Member;

public class ChangePasswordService {
	
	Dao dao;
	
	public ChangePasswordService(Dao dao) {
		this.dao = dao;
		System.out.println("ChangePasswordService 인스턴스 생성");
	}
	
	public void changePassword(String email, String oldPw, String newPw) throws Exception {
		
		System.out.println("change : " + email);
		
		Member member = dao.selectByEmail(email);
		
		if(member == null) {
			throw new Exception("존재하지않는 회원!");
		}
		
		member.changePassword(oldPw, newPw);
			
		dao.update(member);
		
	}
	

}
