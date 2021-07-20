<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	// 1. 사용자가 입력한 데이터를 받고 
	
	// 입력데이터의 한글 처리 !!!!
	request.setCharacterEncoding("UTF-8");
	
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	int result = 0;
	
	
	// 2. DB 처리 : insert
	// 데이터베이스 드라이버 로드
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	// 연결
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user = "bit";
	String pw = "bit";
	
	conn = DriverManager.getConnection(jdbcUrl, user, pw);
	
		
	
	// PreparedStatement
	String sql = "insert into dept values(?, ?, ?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, Integer.parseInt(deptno));
	pstmt.setString(2, dname);
	pstmt.setString(3, loc);
	
	result = pstmt.executeUpdate();
	// insert -> int
	
	// 3. dept_list.jsp 이동
	} catch (Exception e){
		
	}
	
	if(result > 0){
		%>
		<script>
			alret('등록되었습니다.');
			location.href = 'dept_list.jsp';
		</script>
		<%
	} else {
		%>
		<script>
			alret('오류발생으로 등록되지 않았습니다.\n입력페이지로 다시 이동합니다.');
			//location.href = 'dept_regForm.jsp';
			window.history.go(-1);
		</script>
		<%
	}
	
	response.sendRedirect("dept_regForm.jsp");
	// 4. 
	
%>