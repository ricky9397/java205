package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pageService.Command;
import pageService.IdCheckService;
import pageService.JoinService;
import pageService.LogOutService;
import pageService.LoginFormService;
import pageService.LoginService;
import pageService.MainServie;
import pageService.MemberListService;
import pageService.MemberService;
import pageService.MyPageService;

public class FrontController extends HttpServlet {
       

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("프론트 컨트롤러 시작");
		
		String uri = request.getRequestURI();
		if(uri.indexOf(request.getContextPath()) == 0) {
			uri = uri.substring(request.getContextPath().length());
		}
		
		String viewPage = "/WEB-INF/views/index.jsp";
		Command command = null;
		if(uri.equals("/index.do")){
			command = new MainServie();
		} else if(uri.equals("/regForm.do")) {
			command = new JoinService();
		} else if(uri.equals("/memberReg.do")) {
			command = new MemberService();
		} else if(uri.equals("/loginForm.do")) {
			command = new LoginFormService();
		} else if(uri.equals("/login.do")) {
			command = new LoginService();
		} else if(uri.equals("/mypage.do")) {
			command = new MyPageService();
		} else if(uri.equals("/member_list.do")) {
			command = new MemberListService();
		} else if(uri.equals("idcheck.do")) {
			command = new IdCheckService();
		} else if(uri.equals("logOut.do")) {
			command = new LogOutService();	
		}
		viewPage = command.getPage(request);
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
	}
	
}
