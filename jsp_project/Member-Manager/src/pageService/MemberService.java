package pageService;

import javax.servlet.http.HttpServletRequest;

public class MemberService implements Command{


	@Override
	public String getPage(HttpServletRequest request) {
			return "/WEB-INF/views/memberReg.jsp";
	}
	
}
