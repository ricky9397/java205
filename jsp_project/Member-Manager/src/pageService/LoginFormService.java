package pageService;

import javax.servlet.http.HttpServletRequest;

import pageService.Command;

public class LoginFormService implements Command {

	@Override
	public String getPage(HttpServletRequest request) {
		return "/WEB-INF/views/loginForm.jsp";
	}

}
