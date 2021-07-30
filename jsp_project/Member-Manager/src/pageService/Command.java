package pageService;

import javax.servlet.http.HttpServletRequest;

public interface Command {
	
	String getPage(HttpServletRequest request);
	
}
