<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 정보 등록</h1>
	<hr>
	<form action="regDept.jsp" method="post">
		<table>
			<tr>
				<td>부서번호</td>
				<td><input type="number" name="deptno" required></td>
			</tr>
			<tr>
				<td>부서이름</td>
				<td><input type="text" name="dname" required></td>
			</tr>
			<tr>
				<td>부서위치</td>
				<td><input type="text" name="loc" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="등록"> <input type="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>