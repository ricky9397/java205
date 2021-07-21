  
<%@page import="jdbc.util.jdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dept.domain.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String deptno = request.getParameter("deptno");
	
	int resultCnt = 0;
	Connection conn = null;
	
	
	DeptDao dao = DeptDao.getInstance();

	try{
		conn = ConnectionProvider.getConnection();
		
		resultCnt = dao.deleteDept(conn, Integer.parseInt(deptno));
	
	} catch (Exception e){
		e.printStackTrace();
	} finally{
		jdbcUtil.close(conn);
	}
	
	
	if(resultCnt>0){
		%>
		<script>
			alert('삭제되었습니다.');
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