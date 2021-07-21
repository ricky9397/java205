<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

</head>
<body>
	<div>
        <h1>회원가입</h1>
    </div>
    <form action="joinAction.jsp" method="post">
    	<input type="hidden" name="times">
        <table>
            <tr>
                <th>아이디</th>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="pw" id="pw1"></td>
            </tr>
            <tr>
                <th>비밀번호확인</th>
                <td><input type="password" id="pw2"></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td><input type="submit" value="회원가입" onclick="clicks()"></td>
                <td><input type="button" value="취소" onclick="history.back(-1)"></td>
            </tr>
        </table>    
    </form>
    
    <script>
    function clicks(){
        var pw1 = document.getElementById('pw1').value;
        var pw2 = document.getElementById('pw2').value;
        if (pw1 != pw2) {
            alert('비밀번호 확인이 다릅니다.');
            return false;
        }
    }
</script>
</body>
</html>