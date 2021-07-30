<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object loginObj = session.getAttribute("loginInfo");
	
%>
    
	<nav>
		<ul>
			<% if(loginObj == null) { %>
			<li><a href="<%= request.getContextPath() %>/regForm.do">회원가입</a></li>
			<li><a href="<%= request.getContextPath() %>/loginForm.do">로그인</a></li>
			<%}  else {%>
			<li><a href="<%= request.getContextPath() %>/logout.do">로그아웃</a></li>
			<li><a href="<%= request.getContextPath()%>/member_list.do">회원리스트</a></li>
			<%} %>
			<li><a href="<%= request.getContextPath()%>/mypage.do">MyPage</a></li>
			<li><a href="<%= request.getContextPath()%>/mypage/mypage.jsp">MyPage</a></li>
		</ul>
	</nav>
	
	
	
	
	