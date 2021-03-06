package pageService;

import javax.servlet.http.HttpServletRequest;

public class LogOutService implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		request.getSession().invalidate();
		return "/WEB-INF/views/logout.jsp";
	}
}
