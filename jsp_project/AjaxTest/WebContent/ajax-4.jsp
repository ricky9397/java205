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
	
		$.getJSON('data.json', function(data){
			$.each(data, function(index, value){
				var html = '<h3>이름:'+ value.name +' , 가격:'+ value.price +'<h3>'
				$('body').append(html);
			});
		});
	});

</script>
</head>
<body>
	
	
</body>
</html>