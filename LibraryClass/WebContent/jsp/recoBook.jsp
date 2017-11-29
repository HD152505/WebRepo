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


						<c:if test="${user==null }">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" role="button" id="dropdown5"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">로그인/회원가입</a>
								<div class="dropdown-menu" aria-labelledby="dropdown5">
									<a class="dropdown-item" href="${contextPath}/jsp/login.jsp">로그인</a>
									<a class="dropdown-item" href="signup.jsp">회원가입</a>
								</div></li>
						</c:if>
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
		<h4>도서 추천</h4>
		<br> <br>
		<table style="text-align: center" class="table" style="width: 100%"
			border="1">
			<thead style="text-align: center">
				<tr>
					<th colspan="4">도서 추천</th>
				</tr>
				<tr>
					<th style="text-align: center; width: 50px;">#</th>
					<th style="text-align: center;">제목</th>
					<th style="text-align: center; width: 200px;">지은이</th>
					<th style="width: 150px;">관심도서 추가하기</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty list2}">
					<div>
						<form action="${contextPath}/bookregister.do" method="post">
							<input type="hidden" name="num" id="num" value="">

							<c:forEach var="item" items="${list2}" varStatus="status">
								<tr>
									<th>${status.count}</th>
									<td>${item.title}</td>
									<td>${item.writer}</td>
									<td style="text-align: center"><button
											class="btn btn-outline-success"
											type="submit"
											onclick="document.getElementById('num').value=${status.count};">등록</button></td>
								</tr>
							</c:forEach>
						</form>
					</div>
				</c:if>
				<%--<c:if test="${list == null || list.size() == 0}">--%>
				<c:if test="${empty list2}">
					<tr>
						<td colspan="4" align="center">데이터가 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>


	<%@ include file="modal.jsp"%>


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