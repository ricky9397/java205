<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Requset Data</h1>
	<hr>
	<table>
		<tr>
			<td>아이디</td>
			<td>${id}, ${uid}, ${joinRequest.memberid} </td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${pw}, ${upw}, ${joinRequest.password} </td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${name}, ${uname}, ${joinRequest.membername} </td>
		</tr>	

	</table>
	
</body>
</html>