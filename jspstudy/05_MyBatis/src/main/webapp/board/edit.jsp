<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardNo}번 게시글 편집 화면</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>

$(document).ready(function(){
	
	$('#frm_edit').submit(function(event){
		if($('#title').val() == ''){
			alert('제목은 필수입니다.');
			$('#title').focus();
			event.preventDefault();
			return;
		}
	});
	
	$('#btn_list').click(function(event){
		location.href = '${contextPath}/board/list.do';
	});
	
});

</script>
</head>
<body>

	<h1>게시글 편집 화면</h1>
	<div>
		<form id="frm_edit" method="POST" action="${contextPath}/board/modify.do">
			<div>
				<label for="title">제목</label>
				<input type="text" id="title" name="title" value="${board.title}">
			</div>
			<div>
				<label for="content">내용</label><br>
				<textarea id="content" name="content" rows="5" cols="30">${board.content}</textarea>
			</div>
			<input type="hidden" name="boardNo" value="${board.boardNo}">
			<div>
				<input type="submit" value="수정완료">
				<input type="reset" value="작성취소">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>
	
</body>
</html>