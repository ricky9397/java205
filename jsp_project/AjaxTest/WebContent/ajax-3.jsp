<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"
	integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
	crossorigin="anonymous"></script>
	
<script type="text/javascript">

	$(document).ready(function(){
	
		$('#btn').click(function(){
			$.ajax({
				url : 'parameter.jsp',
				type : 'get', // http method get, post, put, delete
				data : {
					pname : $('#pname').val(),
					price : $('#price').val()
				},// 문자열 형식 ?name=test&price=1000, 객체 형식으로{}
				success : function(data){
					$('#menu').append(data);
				}
			});
		});
	});

</script>
</head>
<body>
	<h1>제품 등록</h1>
	<hr>
	제품 이름 : <input type="text" id="pname"> <br>
	제품 가격  : <input type="number" id="price">
	<input id="btn" type="submit">
	<hr>
	<div id="menu">
		<h3>메뉴표</h3>
		<hr>
	</div>
	
	
	
</body>
</html>