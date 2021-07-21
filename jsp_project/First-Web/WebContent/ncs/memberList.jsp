<%@page import="ncs.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ArrayList<MemberDto> list = (ArrayList<MemberDto>) request.getAttribute("members");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
        <h1>회원 정보 리스트</h1>
    </div>
    <form action="logOut.jsp">
        <table border="1">
            <tr>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>이름</th>
                <th>가입일자</th>
                <th>관리</th>
            </tr>
            <%
            if(list != null){
            	for(int i=0; i<list.size(); i++){
            %>
            <tr>
                <td><%= list.get(i).getId() %></td>
                <td><%= list.get(i).getPw() %></td>
                <td><%= list.get(i).getName() %></td>
                <td><%= list.get(i).getTimes() %></td>
            </tr>
            <%
            		}
            	}
            %>
            <tr>
            	<th><input type="submit" value="로그아웃">
            </tr>
        </table>
    </form>
</body>
</html>