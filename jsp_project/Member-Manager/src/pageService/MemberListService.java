package pageService;

import javax.servlet.http.HttpServletRequest;

public class MemberListService implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		return "/WEB-INF/views/member_list.jsp";
	}

}
