<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
<head>

<meta charset="utf-8">


<title>한국디지털미디어고등학교도서관</title>
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
									<a class="dropdown-item" href="jsp/signup.jsp">회원가입</a>
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
								</div></li>
						</c:if>
					</ul>
				</div>
			</nav>
		</header>
		<div class="container">
			<div id="carouselExampleControls" class="carousel slide"
				data-ride="carousel">
				<hr>


				<div class="container">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<div class="jumbotron jumbotron-fluid">
								<div class="container">
									<h1 class="display-3">한국디지털미디어 고등학교</h1>
									<p class="lead">디미고 도서관에 오신 것을 환영합니다. 다양한 책들을 빌리고 읽어서 훌륭히
										자라주세요.</p>
								</div>
							</div>
						</div>
						<div class="carousel-item">
							<img width="1000" height="300" src="../image/map.png"
								alt="First slide">

						</div>

					</div>
					<a class="carousel-control-prev" href="#carouselExampleControls"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="false"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleControls"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="false"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
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