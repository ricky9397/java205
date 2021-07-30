package pageService;

import javax.servlet.http.HttpServletRequest;

public class MyPageService implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		return "/WEB-INF/views/mypage.jsp";
	}

}
