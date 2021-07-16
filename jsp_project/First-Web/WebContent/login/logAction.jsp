<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
	request.setCharacterEncoding("utf-8");

	String id = null;
	String pw = null;
	
	if(request.getParameter("id") != null){
		id = request.getParameter("id");
	}
	
	if(request.getParameter("pw") != null){
		pw = request.getParameter("pw");
	}
	
	request.setAttribute("id", id);
	request.setAttribute("pw", pw);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>환영합니다</h1>
</body>
</html>