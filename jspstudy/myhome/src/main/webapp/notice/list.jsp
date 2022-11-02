<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jquery 파일없이 jquery사용 가능 -->
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>공지번호</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${notices}" var="notice">
				<tr>
					<td>${notice.noticeNo}</td>
					<td>${notice.title}</td>
					<td>${notice.createDate}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3">
					
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>