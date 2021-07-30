package pageService;

import javax.servlet.http.HttpServletRequest;

public class JoinService implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		// 회원가입 이동
		return "/WEB-INF/views/regForm.jsp";
	}

}
