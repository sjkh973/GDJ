<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/board/list.do'
		});
	});
</script>
</head>
<body>
	<form id="frm_insert" method="POST" action="${contextPath}/board/insert.do">
		<table border="1">
			<tbody>
				<tr>
					<td>작성자</td>
					<td><input type="text" id="writer" name="writer" placeholder="관리자"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td> <input type="text" id="title" name="title" placeholder="공지사항"> </td>
				</tr>
				<tr>
					<td>내용</td>
					<td> <textarea id="content" name="content" rows="5" cols="30"></textarea> </td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><button>등록</button><input type="button" value="목록" id="btn_list"></td>
				</tr>
			</tfoot>
		</table>
	</form>
	
</body>
</html>