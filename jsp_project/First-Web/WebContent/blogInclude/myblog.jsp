<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Blog</title>
<link rel="stylesheet" href="myblog.css">
</head>
<body>
	<div id="main_wrap">

		<%@ include file="/blogInclude/header.jsp"%>

		<%@ include file="/blogInclude/nav.jsp"%>
		
		<%@ include file="/blogInclude/content.jsp"%>
		
		<%@ include file="/blogInclude/footer.jsp"%>
	</div>
</body>
</html>