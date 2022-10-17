<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath}" /> <!-- contextPath(/03_MVC)를 contextPath로 부르겠다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1><a href="${contextPath}/input.do">도형의 크기 구하기</a></h1>

</body>
</html>