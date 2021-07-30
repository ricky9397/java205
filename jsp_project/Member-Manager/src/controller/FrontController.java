package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pageService.Command;
import pageService.InvalidService;

public class FrontController extends HttpServlet {
	private Map<String, Command> commands = new HashMap<String, Command>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter("config");

		Properties prop = new Properties();

		FileInputStream fis = null;
		String configPath = config.getServletContext().getRealPath(configFile);

		try {
			fis = new FileInputStream(configPath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Iterator<Object> itr = prop.keySet().iterator();
		while (itr.hasNext()) {
			String command = (String) itr.next();
			String commandClassName = (String) prop.getProperty(command);
			try {
				Class commandClass = Class.forName(commandClassName);
				Command commandObj = (Command) commandClass.newInstance();
				commands.put(command, commandObj);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("프론트 컨트롤러 시작");

		String uri = request.getRequestURI();
		if (uri.indexOf(request.getContextPath()) == 0) {
			uri = uri.substring(request.getContextPath().length());
		}

		String viewPage = "/WEB-INF/views/index.jsp";
		Command command = null;

		command = commands.get(uri);
		if (command == null) {
			command = new InvalidService();
		}

		viewPage = command.getPage(request);

//		if (uri.equals("/index.do")) {
//			command = new MainServie();
//		} else if (uri.equals("/regForm.do")) {
//			command = new JoinService();
//		} else if (uri.equals("/memberReg.do")) {
//			command = new MemberService();
//		} else if (uri.equals("/loginForm.do")) {
//			command = new LoginFormService();
//		} else if (uri.equals("/login.do")) {
//			command = new LoginService();
//		} else if (uri.equals("/mypage.do")) {
//			command = new MyPageService();
//		} else if (uri.equals("/member_list.do")) {
//			command = new MemberListService();
//		} else if (uri.equals("idcheck.do")) {
//			command = new IdCheckService();
//		} else if (uri.equals("logOut.do")) {
//			command = new LogOutService();
//		}
//		viewPage = command.getPage(request);

		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);

	}

}
