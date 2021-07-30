package pageService;

import javax.servlet.http.HttpServletRequest;

public class LoginService implements Command{

	@Override
	public String getPage(HttpServletRequest request) {
		return "/WEB-INF/views/login.jsp";
		
	}

}
