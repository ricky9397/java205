<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	request.setCharacterEncoding("utf-8");

	String id = null;
	String pw = null;
	String name = null;
	
	if(request.getParameter("id") != null){
		id = request.getParameter("id");
	}
	
	if(request.getParameter("pw") != null){
		pw = request.getParameter("pw");
	}
	
	if(request.getParameter("name") != null){
		name = request.getParameter("name");
	}
	
	request.setAttribute("id", id);
	request.setAttribute("pw", pw);
	request.setAttribute("name", name);
	
	
%>

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
    <form action="log.jsp" method="post">
	    <div id="regFormArea">
	        <h2 class="title_font">회원 정보 등록</h2>
	            <table>
	                <tr>
	                    <td>
	                        <label for="userID">아이디 : <%= id %></label>
	                    </td>
	                    <td>
	                        <label for="pw">비밀번호 : <%= pw %></label>
	                    </td>
	                    <td>
	                        <label for="userName">이름 : <%= name %></label>
	                    </td>
	                    <td>
	                        <input type="submit" value="로그인하러가기">
	                    </td>
	                </tr>
	            </table>
	    </div>
	</form>
    <!-- 회원 등록 form 끝 -->