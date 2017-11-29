<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "/WebClass/scope" method = "post">

<input type = "text" name = "id">
<input type = "hidden" name = "pwd" value = "test">
<button type = "submit">전송</button>
</form>
</body>

<h1>id : <%= request.getParameter("id") %></h1>
<h1>pwd : <%= request.getParameter("pwd") %></h1>
<h1>request scope : <%= request.getAttribute("key") %></h1>
<h1>session scope : <%= session.getAttribute("key") %></h1>
<h1>application scope : <%= application.getAttribute("key") %></h1>

<h1>id : ${ param.id }</h1>
<h1>pwd : ${ param.pwd }</h1>
<h1>request scope : ${requestScope.key}</h1>
<h1></h1>





<!--  ELㄹ 수정하기 -->
<h1>request scope : ${ key }</h1>
<h1>id : ${ param.id} }</h1>
<h1>pwd : ${ param.pwd} }</h1>

</html>