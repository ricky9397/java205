<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
        <h1>로그인</h1>
    </div>
    <form action="loginAction.jsp" method="post">
        <table>
            <tr>
                <th>아이디</th>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="pw"></td>
            </tr>
            <tr>
                <td><input type="submit" value="로그인"></td>
                <td><a href="join.jsp">회원가입</a>
            </tr>
        </table>
    </form>
</body>
</html>