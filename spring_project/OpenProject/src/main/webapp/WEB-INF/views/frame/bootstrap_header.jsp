<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
	<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg_red">
		<!-- LOGO -->
		<a class="navbar-brand mr-auto mr-lg-0" href="#">Offcanvas navbar</a>
		
		<!-- 햄버거 토글 버튼 : offcanvas -->
		<button class="navbar-toggler p-0 border-0" type="button"
			data-toggle="offcanvas">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="navbar-collapse offcanvas-collapse"
			id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item "> <a class="nav-link" href="#">회원가입</a> </li>
				<li class="nav-item"><a class="nav-link" href="#">로그인</a> </li>
				<li class="nav-item"><a class="nav-link" href="#">로그아웃</a></li>
				<li class="nav-item"><a class="nav-link" href="#">회원리스트</a></li>
				<li class="nav-item"><a class="nav-link" href="#">방명록</a></li>
				
			</ul>
			
		</div>
	</nav>
