<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	// 현재 세션 객체를 소멸시킨다. -> 세션에 저장된 속성들도 함께 소멸!!!! 회원정보도 소멸
	session.invalidate();
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그아웃 되었습니다.</h1>
	<h3><a href="sessionView.jsp">세션 정보 확인하기</a></h3>
	
</body>
</html>