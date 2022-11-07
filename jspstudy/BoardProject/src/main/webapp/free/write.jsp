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
			location.href= '${contextPath}/list.do';
		});
		
	});
</script>
</head>
<body>
	
	<h1>자유게시판 게시글 작성화면</h1>
	
	<form id="frm_write" method="POST" action="${contextPath}/free/insert.do">
		<div>
			<input type="text" id="writer" name="writer" placeholder="작성자">
		</div>	
		<div>
			<input type="text" id="title" name="title" placeholder="제목">
		</div>
		<div>
		<textarea id="content" name="content" rows="5" cols="30" placeholder="내용" ></textarea>
		</div>
		<div>
			<button>작성완료</button>
			<input type="reset" value="다시작성">
			<input type="button" value="목록" id="btn_list">
		</div>
	</form>
</body>
</html>