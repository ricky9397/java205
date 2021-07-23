<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>
	
		<c:url value="/index.jsp" var="urlIndex" />
		${urlIndex}
		<br>
		<c:url value="/index.jsp"/> <br>
		
		<a href="<c:url value="/index.jsp"/>">홈으로 가기</a>
		
		<br>
		
		<c:url value="/index.jsp" var="homeUrl">
			<c:param name="type" value="main" />
			<c:param name="index">1</c:param>
		</c:url>
		
		<a href="${homeUrl}">${homeUrl}</a>
	</h3>
	

</body>
</html>