<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<%--@ include file="WEB-INF/header.jsp" --%>
<hr>
	<%@ include file="include/nav.jsp" %>
<div id="wrap">
	<%@ include file="include/news.jsp" %>
	<%@ include file="include/shopping.jsp" %>
</div>

	<%-- <jsp:include page="footer.jsp"/> --%>

	<!-- 실행된 jsp -> html(text) 결과를 가져온다. --> 
	<jsp:include page="footer.jsp">
		<jsp:param name="email" value="test@gmail.com"/>
		<jsp:param name="tel" value="01"/>
	</jsp:include>












</body>
</html>