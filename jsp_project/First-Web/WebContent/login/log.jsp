<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	
	<form action="logAction.jsp">
		<table>
			<tr>
				<td>
					아이디 : <input type="text" name="id">
				</td>
			</tr>
			
			<tr>
				<td>
					비밀번호 : <input type="password" name="pw">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="로그인"> 
				</td>
			</tr>
			<tr>
				<td>
					<a href="join.jsp">회원가입</a>
				</td>
			</tr>
		</table>
	</form>
		
		
		
	
	
</body>
</html>