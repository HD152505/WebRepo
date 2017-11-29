<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<li class="nav-item"><a class="nav-link"
	href="${contextPath }/jsp/home.jsp">Home</a></li>
<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
	id="dropdown1" data-toggle="dropdown" aria-haspopup="true"
	aria-expanded="false">도서관 이용안내</a>
	<div class="dropdown-menu" aria-labelledby="dropdown1">
		<a class="dropdown-item" href="${contextPath}/info.do">공지사항</a>
	</div></li>
<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
	id="dropdown2" data-toggle="dropdown" aria-haspopup="true"
	aria-expanded="false">도서</a>
	<div class="dropdown-menu" aria-labelledby="dropdown2">
		<a class="dropdown-item" href="${contextPath}/searchbook.do">도서
			목록</a> <a class="dropdown-item" href="${contextPath}/recoBook.do">도서
			추천</a>
	</div></li>
<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
	id="dropdown3" data-toggle="dropdown" aria-haspopup="true"
	aria-expanded="false">자유게시판</a>
	<div class="dropdown-menu" aria-labelledby="dropdown3">
		<a class="dropdown-item" href="${contextPath }/writeList.do">글 목록</a> <a
			class="dropdown-item" href="${contextPath}/write.do">글 작성하기</a>
	</div></li>
<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
	id="dropdown4" data-toggle="dropdown" aria-haspopup="true"
	aria-expanded="false">My Page</a>
	<div class="dropdown-menu" aria-labelledby="dropdown4">
		<a class="dropdown-item" href="status.do">도서 대출 현황</a> <a
			class="dropdown-item" href="${contextPath}/interest.do">관심 도서 목록</a>
	</div></li>