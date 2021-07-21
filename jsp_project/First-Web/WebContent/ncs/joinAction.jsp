<%@page import="ncs.MemberDto"%>
<%@page import="ncs.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("UTF-8");
	MemberDao dao = MemberDao.getInstance();
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String times = request.getParameter("times");
	
	
	int result = dao.join(new MemberDto(id, pw, name, times));	
	
	if(result == 1){
		%>
		<script>
			alert('회원가입되었습니다.');
			location.href = 'login.jsp';
		</script>
		<%
		} else if (result == 0){
		%>
		<script>
			alert("잘못입력하셨습니다.");
			location.href = 'join.jsp';
		</script>
		<%
		}
%>