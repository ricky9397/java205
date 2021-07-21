<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dept.domain.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 사용자가 입력한 데이터를 받고
	// 입력데이터의 한글 처리!!!
	request.setCharacterEncoding("utf-8");	
	
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	
	int resultCnt = 0;
	
	Connection conn = null;
	DeptDao dao = null;
	
	try{
		conn = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
		resultCnt = dao.updateDept(conn, new Dept(Integer.parseInt(deptno), dname, loc));
		
	} catch(Exception e){
		e.printStackTrace();
	}
	
	
	
	if(resultCnt>0){
		%>
		<script>
			alert('수정되었습니다.');
			location.href = 'dept_list.jsp';
		</script>
		<%
	} else {
		%>
		<script>
			alert("해당 데이터를 찾지 못했습니다.");
			location.href = 'dept_list.jsp';
		</script>
		<%
	}
	
%>
