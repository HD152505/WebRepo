<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="ko">
<head>
<meta charset="utf-8">
<style>
.short {
	margin-right: 600px;
}
.center
</style>


<title>로그인</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" href="${contextPath}/css/signin.css">
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
						<%@ include file="menu.jsp" %>
						
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" role="button" id="dropdown5"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">로그인/회원가입</a>
							<div class="dropdown-menu" aria-labelledby="dropdown5">
								<a class="dropdown-item" href="login.jsp">로그인</a> <a
									class="dropdown-item" href="signup.jsp">회원가입</a>
							</div>
				</div>
				</li>
				</ul>
	</div>
	</nav>
	</h26eader>

	<div class="container center">

		<form class="form-signin short" action="${contextPath}/login.do"
			method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label> <input
				type="email" name="id" id="inputEmail" value="${param.id}"
				class="form-control" placeholder="Email address" autofocus>
			<label for="inputPassword" class="sr-only">Password</label> <input
				type="password" name="pwd" id="inputPassword" class="form-control"
				placeholder="Password">

			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>

		</form>
		
		<form action="${contextPath}/jsp/signup.jsp" class="form-signin short">
			<a> 회원이 아니신가요?</a>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				up</button>
		</form>

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
	<script>
		
	<%if ("error".equals(request.getAttribute("msg"))) {%>
		var myModal = $('#myModal');
		myModal.find('.modal-title').text('Login Error');
		//myModal.find('.modal-body').text('Invalid username or password');
		myModal.find('.modal-body').text('${error}');
		myModal.modal();
	<%}%>
		
	</script>


</body>
</html>