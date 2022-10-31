<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	
	<h1>회원 상세 보기</h1>
	
	<div>제목 ${title}</div>	<%-- ${board.title}는 board.getTitle()를 호출한다. --%>
	<div>조회수 ${hit}</div> <%-- ${board.hit}는board.getHit()를 호출한다. --%>
</body>
</html>