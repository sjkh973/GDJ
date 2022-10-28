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
		
		$('#btn_remove').click(function(event){
			if(confirm('정말 삭제하시겠습니까?')){
				location.href = '${contextPath}/board/remove.do?boardNo=${board.boardNo}';
			} else{
				alert('취소되었습니다.');
			}
			
		});
	});
</script>
</head>
<body>
	<form id="frm_insert" method="POST" action="${contextPath}/board/modify.do?boardNo=${board.boardNo}">
		<table border="1">
			<tbody>
				<tr>
					<td>순번</td>
					<td><input type="text" id="writer" name="writer" value="${board.boardNo}" readonly></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${board.writer}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" id="title" name="title" value="${board.title}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea id="content" name="content" rows="5" cols="30" >${board.content}</textarea> </td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><button>수정</button> <input type="button" value="목록" id="btn_list"> <input type="button" value="삭제" id="btn_remove"></td>
					
				</tr>
			</tfoot>
		</table>
	</form>
	
</body>
</html>