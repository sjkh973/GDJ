<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="${contextPath}/member">회원관리</a>
	</div>
	
	<hr>
	
	<div>
		<a href="${contextPath}/board">게시판관리</a>
	</div>
	
	<hr>
	
	<div>
		<a href="${contextPath}/movie">박스오피스</a>
	</div>
	
</body>
</html>