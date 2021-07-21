<%@page import="jdbc.util.jdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dept.domain.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	Connection conn = null;
	
	DeptDao dao = DeptDao.getInstance();
	
	try{		
		
	conn = ConnectionProvider.getConnection();
	
	request.setAttribute("result", dao.getDeptList(conn));
	
	} catch (Exception e){
		e.printStackTrace();
	} finally {
		jdbcUtil.close(conn);
	}
	
%>

<jsp:forward page="list_view.jsp" />
<!--  list_view.js : view 의 역할만!!!! -->


