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
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>전화</td>
				<td>주소</td>
				<td>이메일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="c">
					<tr>
						<td>${c.no}</td>
						<td>${c.name}</td>
						<td>${c.tel}</td>
						<td>${c.addr}</td>
						<td>${c.email}</td>
					</tr>
				</c:forEach>		
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<a href="${contextPath}/contact/write">신규연락처 등록하기</a>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>