<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<form action="${contextPath}/member/register.me" method="post">
			<div>
				<input type="text" name="id" placeholder="아이디">
			</div>
			<div>
				<input type="password" name="pw" placeholder="패스워드">
			</div>
			<div>
				<input type="text" name="name" placeholder="이름">
			</div>
			<div>
				<input type="text" name="email" placeholder="이메일">
			</div>
			<div>
				<button>회원가입</button>
				<input type="reset" value="입력초기화">
			</div>
		</form>
	</div>

</body>
</html>