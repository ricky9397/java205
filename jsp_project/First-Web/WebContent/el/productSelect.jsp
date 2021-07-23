<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>
		1. 선택한 상품 : ${param.select} <br>
		2. 상품 설명 : ${product.display} <br>
		<!-- display 변수는 없다!!! -> EL 은 메소드를 호출하는 것이다!!! -->
		3. 첫번째 상품 ${product.productList[0]}
	</h3>
	
	
	
	
</body>
</html>