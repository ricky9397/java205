<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project : 회원가입</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>



</head>
<body>

	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>



	<div id="content">
		<h2>회원가입</h2>
		<hr>
		
		<%-- ${memberRegRequest} --%>
		${regRequest}
		
		
		<c:if test="${result eq 1}">
			<h3>회원 가입 성공</h3>
		</c:if>
		<c:if test="${result eq 0}">
			<h3>회원 가입 실패</h3>
		</c:if>


			<table>
				<tr>
					<td>아이디</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td></td>
				</tr>
				<tr>
					<td>이름</td>
					<td></td>
				</tr>
				<tr>
					<td>사진</td>
					<td></td>
				</tr>				
			</table>





	</div>












</body>
</html>