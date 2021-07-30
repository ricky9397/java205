package pageService;

import javax.servlet.http.HttpServletRequest;

public class MainServie implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		return "/WEB-INF/views/index.jsp";
	}

}
