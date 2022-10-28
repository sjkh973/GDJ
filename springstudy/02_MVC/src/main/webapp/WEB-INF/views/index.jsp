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

	<a href="${contextPath}/animal">동물보러가기</a>

	<hr>
	
	<a href="${contextPath}/flower">꽃보러가기</a>
	
	<hr>
	
	<a href="${contextPath}/animal/flower">동물보러갔다가 꽃보러가기</a>
	
	<hr>
	
	<a href="${contextPath}/want/animal?filename=animal5.jpg">animal5 보러가기</a>
	
	<hr>
	
	<a href="${contextPath}/response">응답 만들어 받기</a>
</body>
</html>