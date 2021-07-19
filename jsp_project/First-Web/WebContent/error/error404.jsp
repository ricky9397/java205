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

	<h1>요청하신 경로의 파일이 존재하지 않습니다.
		다시확인하시고 요청해주세요.
	</h1>
	<h3>
		에러 메세지 : <%= exception.getMessage() %> <br>
		에러 타입 : <%= exception.getClass().getName() %>
	</h3>
	
</body>
</html>