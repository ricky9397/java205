<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>NullPointerException에러가 발생했습니다.
		메인페이지로 이동해주세요.
	</h1>
	<h3>
		에러 메세지 : <%= exception.getMessage() %> <br>
		에러 타입 : <%= exception.getClass().getName() %>
	</h3>
	
</body>
</html>