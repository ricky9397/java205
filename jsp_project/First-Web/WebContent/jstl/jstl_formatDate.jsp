<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setAttribute("now", new java.util.Date());
%>

	${now} <br>
	<!-- 홍콩시간으로 바까주는법 ㅋㅋ -->
	<%-- <fmt:timeZone value="HongKong"> --%>
		<h3>날짜</h3>
		<fmt:formatDate value="${now}"/> <br>
		<fmt:formatDate value="${now}" type="date"/> <br>
		<fmt:formatDate value="${now}" type="date" dateStyle="full"/> <br> 
		<fmt:formatDate value="${now}" type="date" dateStyle="short"/> <br> 
		
		<h3>시간</h3>
		<fmt:formatDate value="${now}" type="time"/> <br>
		<fmt:formatDate value="${now}" type="time" timeStyle="full"/> <br>
		<fmt:formatDate value="${now}" type="time" timeStyle="short"/> <br>
		
		<h3>both</h3>
		<fmt:formatDate value="${now}" type="both"/> <br>
		<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/> <br>
		
		<h3>패턴</h3>
		<fmt:formatDate value="${now}" pattern="z a h:mm"/><br>
		<fmt:formatDate value="${now}" pattern="hh:mm:ss"/><br>
		<fmt:formatDate value="${now}" pattern="yyy-MM-dd"/><br>
		<fmt:formatDate value="${now}" pattern="yyy-MM-dd. a h:mm"/><br>
		<fmt:formatDate value="${now}" pattern="yyy-MM-dd. a h:mm" timeZone="HongKong"/><br>
	<%-- </fmt:timeZone>	 --%>
	
</body>
</html>