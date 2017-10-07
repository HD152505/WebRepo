<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap ì¤ìµ</title>
    <!-- Bootstrap CSS -->
   <link rel="stylesheet" href = "../css/footer.css"> 
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
  <script>
  function menu_over(e){
	  e.setAttribute("class","nav-item active"); // <li class="nav-item">
  }
  function menu_out(e){
	  e.setAttribute("class","nav-item");
  }
  </script>
  <style>
  div.container{
  padding-top : 30px;
  
  }
  </style>
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <%@ include file="menu.jsp" %>
    <form class="form-inline my-2 my-lg-0" id = "loginForm">
      <input class="form-control mr-sm-2" type="text" placeholder="ID" aria-label="ID" id = "id" required>
      <input class="form-control mr-sm-2" type="password" placeholder="pwd" aria-label="pwd" id = "pwd" required>
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
    </form>
  </div>
</nav>

     <%@include file = "modal.jsp %>
     <%@include file = "footer.jsp" %>
  </script>
  </body>
</html>