<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.css">
<script src="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script>
<script>
	$(document).ready(function(){
    
    $('#content').summernote({
  	  width : 800,
  	  height : 400,
  	  lang : 'ko-KR',
  	  toolbar: [
			    // [groupName, [list of button]]
			    ['style', ['bold', 'italic', 'underline', 'clear']],
			    ['font', ['strikethrough', 'superscript', 'subscript']],
			    ['fontsize', ['fontsize']],
			    ['color', ['color']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']]
			  ]
    });
</script>
</head>
<body>

	<div>
      	<h1>수정 화면</h1>
      	<form id="frm_edit" action="${contextPath}/blog/modify" method="post">
      		<input type="hidden" name="blogNo" value="${blog.blogNo}">
      		<div>
      			<label for="title">제목</label>
      			<input type="text" name="title" id="title" value="${blog.title}">
      		</div>
      		<div>
      			<label for="content">내용</label>
      			<textarea name="content" id="content">${blog.content}</textarea>
      		</div>
      		<div>
      			<button>수정완료</button>
      			<input type="reset" value="입력초기화">
      			<input type="button" value="목록" id="btn_list">
      		</div>
      	</form>
      </div>
	
</body>
</html>