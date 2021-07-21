<%@page import="ncs.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ncs.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	request.setCharacterEncoding("UTF-8");

	MemberDao dao = MemberDao.getInstance();
	
	ArrayList<MemberDto> list = dao.getMemberList();
	
	request.setAttribute("members", list);

%>

<jsp:forward page="memberList.jsp" />