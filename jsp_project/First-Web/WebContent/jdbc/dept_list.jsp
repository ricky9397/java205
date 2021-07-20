<%@page import="dept.domain.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 1. 드라이버로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	// 2. bd연결
	Connection conn = null; 
	Statement stmt = null;
	ResultSet rs = null;
	
	// jdbcUrl
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user = "bit";
	String pw = "bit";
	
	conn = DriverManager.getConnection(jdbcUrl, user, pw);
	
	// 3. Statement
	stmt = conn.createStatement();
	
	// sql 
	String sql = "select * from dept";
	
	// 4. ResultSet
	rs = stmt.executeQuery(sql);
	
	// 5. List<Dept> <- 결과
	ArrayList<Dept> list = new ArrayList<Dept>();
	while(rs.next()){
		list.add(new Dept(
					rs.getInt("deptno"), 
					rs.getString("dname"), 
					rs.getString("loc")));
	}
	// 6. 결과 데이터 request 의 속성에 저장 -> 데이터 공유(전달)
	request.setAttribute("result", list);
	
%>

<jsp:forward page="list_view.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>