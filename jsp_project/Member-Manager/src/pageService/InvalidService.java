package pageService;

import javax.servlet.http.HttpServletRequest;

public class InvalidService implements Command{

	@Override
	public String getPage(HttpServletRequest request) {
		return "/WEB-INF/views/index.jsp";
	}

}
