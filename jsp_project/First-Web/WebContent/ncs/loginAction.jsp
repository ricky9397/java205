<%@page import="java.io.PrintWriter"%>
<%@page import="ncs.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	MemberDao dao = MemberDao.getInstance();
	
	String id = null;
	String pw = null;
	if(request.getParameter("id") != null){
		id = request.getParameter("id");
	}
	if(request.getParameter("pw") != null){
		pw = request.getParameter("pw");
	}
	if(id == null || pw == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안된 사항이 있습니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}
	
	int result = dao.login(id, pw);
	
	if(result == 1){
		session.setAttribute("id", id);
		%>
		<script>
			alert('로그인 되셨습니다.');
			location.href = 'memberListAction.jsp';
		</script>
		<%
	} else if(result == 0){
		%>
		<script>
			alert('비밀번호 틀리셨습니다.');
			location.href = 'login.jsp';
		</script>
		<%
	} else if(result == -1){
		%>
		<script>
			alert('존재하지 않는 아이디입니다.');
			location.href = 'login.jsp';
		</script>
		<%
	}
%>
