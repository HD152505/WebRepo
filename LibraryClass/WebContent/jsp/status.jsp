<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
<head>
<meta charset="utf-8">


<title>추천도서</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

</head>

<body>

	<div class="container">

		<header class="masthead">
			<br>
			<h5 class="text-muted">한국 디지털 미디어 고등학교 도서관</h5>
			<br>



			<nav
				class="navbar navbar-expand-md navbar-light bg-light rounded mb-3">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarCollapse" aria-controls="navbarCollapse"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<ul class="navbar-nav text-md-center nav-justified w-100">
						<%@ include file="menu.jsp"%>

						<c:if test="${empty user }">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" role="button" id="dropdown5"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">로그인/회원가입</a>
								<div class="dropdown-menu" aria-labelledby="dropdown5">
									<a class="dropdown-item" href="${contextPath}/jsp/login.jsp">로그인</a>
									<a class="dropdown-item" href="signup.jsp">회원가입</a>
								</div></li>
						</c:if>
						<%-- 로그인 로그아웃 메뉴바 바뀌게 --%>
						<%-- 세션이 있는 경우 --%>
						<c:if test="${user!=null }">

							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" role="button" id="dropdown5"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> ${user.name }님 </a>
								<div class="dropdown-menu" aria-labelledby="dropdown5">
									<a class="dropdown-item" href="${contextPath}/logout.do">로그아웃</a>
								</div>
						</c:if>
					</ul>
				</div>
			</nav>
		</header>
	</div>

	<br>
	<div class="container">
		<h4>자유게시판</h4>
		<br> <br>
		<table class="table">
			<thead>
				<tr>
					<th colspan="5">자유게시판</th>
				</tr>
				<tr>
					<th>#</th>
					<th>제목</th>
					<th style="width:200px;">지은이</th>
					<th>반납</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty lendlist}">
					<div>
						<form action="${contextPath}/delete.do" method="post">
							<input type="hidden" name="num" id="num" value="">
							<c:forEach var="lend" items="${lendlist}" varStatus="status">
								<tr>
									<th>${status.count}</th>
									<td>${lend.title}</td>
									<td>${lend.writer}</td>
									<td><button type="submit" style="border: 1; outline: 0;"
											onclick="document.getElementById('num').value=${status.count};">반납</button></td>
								</tr>
							</c:forEach>
						</form>
					</div>
				</c:if>
				<%--<c:if test="${list == null || list.size() == 0}">--%>
				<c:if test="${empty lendlist}">
					<tr>
						<td colspan="4" align="center">데이터가 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>




	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
		integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
		crossorigin="anonymous"></script>


</body>
</html>