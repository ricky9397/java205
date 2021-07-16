<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 프로그램</title>
    <link rel="stylesheet" href="default.css">
    <script src="manager.js"></script>
</head>
<body>
    <!-- header 시작 -->
    <header>
        <h1 class="title_font">Member Manager</h1>
    </header>
    <!-- header 끝 -->
    <!-- <hr> -->

    <!-- 회원등록 form 시작 -->
    <div id="regFormArea">
        <h2 class="title_font">회원 정보 등록</h2>
        <form id="regForm" action="joinAction.jsp" method="post">
            <table>
                <tr>
                    <td>
                        <label for="userID">아이디</label>
                        <input type="text" id="userID" placeholder="아이디를 입력해주세요" name="id">
                        <div class="msg"></div>
                    </td>
                    <td>
                        <label for="pw">비밀번호</label>
                        <input type="password" id="pw" placeholder="비밀번호를 입력해주세요" name="pw">
                        <div class="msg"></div>
                    </td>
                    <td>
                        <label for="repw">비밀번호 확인</label>
                        <input type="password" id="repw" placeholder="비밀번호를 입력해주세요">
                        <div class="msg"></div>
                    </td>
                    <td>
                        <label for="userName">이름</label>
                        <input type="text" id="userName" placeholder="이름을 입력해주세요" name="name">
                        <div class="msg"></div>
                    </td>
                    <td><input type="submit" value="등록">
                        <input type="reset">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!-- 회원 등록 form 끝 -->

</body>
</html>