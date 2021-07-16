<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 include</title>

</head>
<body>
	
	<!-- 실행된 jsp -> html(text) 결과를 가져온다. -->
	<jsp:include page="includeFooter.jsp">
	
		<!-- 사용자의 입력값을 name을 주고 보낸다. -->
		<jsp:param name="email" value="test@gmail.com"/>
		<jsp:param name="tel" value="010-0000-0000"/>
		
	</jsp:include>
	<!-- 마감을 처리하면 param을 작성 해줘야 한다. -->
</body>
</html>

