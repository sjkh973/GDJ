<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>

   $(document).ready(function(){
      
     	
	   
	   
   });
      
</script>
</head>
<body>

	<div>
		<a href="${contextPath}/brd/write">새글작성</a>
	</div>

      <div>
   		<table border="1">
   			<thead>
   				<tr>
   					<td>글번호</td>
   					<td>제목</td>
   					<td>작성자</td>
   					<td>작성일</td>
   				</tr>
   			</thead>
   			<tbody>
   				<c:forEach items="${boards}" var="board">
   					<tr>
   						<td>${board.boardNo}</td>
   						<td><a href="${contextPath}/brd/detail?boardNo=${board.boardNo}">${board.title}</a></td>
   						<td>${board.writer}</td>
   						<td>${board.createDate}</td>
   					</tr>
   				</c:forEach>
   			</tbody>
   		</table>
      </div>

</body>
</html>

