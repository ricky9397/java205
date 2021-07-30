package pageService;

import javax.servlet.http.HttpServletRequest;

public class IdCheckService implements Command{

	@Override
	public String getPage(HttpServletRequest request) {
		String memberId = request.getParameter("mid");
		request.setAttribute("result", IdCheck.getInstance().idCheck(memberId));
		return "/WEB-INF/view/idcheck.jsp";
	}
}
