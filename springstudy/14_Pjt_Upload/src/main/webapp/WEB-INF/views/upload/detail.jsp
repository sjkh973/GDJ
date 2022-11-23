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
<script>

	$(function(){
		
		// 게시글 수정화면으로 이동
		$('#btn_upload_edit').click(function(event){
			$('#frm_upload').attr('action', '${contextPath}/upload/edit');
			$('#frm_upload').submit();
		});
		
		// 게시글 삭제
		$('#btn_upload_remove').click(function(event){
			if(confirm('첨부된 모든 파일이 함께 삭제됩니다. 삭제할까요?')){
				$('#frm_upload').attr('action', '${contextPath}/upload/remove');
				$('#frm_upload').submit();
			}
		});
		
		// 게시글 목록
		$('#btn_upload_list').click(function(event){
			location.href = '${contextPath}/upload/list';
		});
		
	});

</script>
</head>
<body>

	<div>
		<h1>업로드 게시글 정보</h1>
		<ul>
			<li>제목 : ${upload.title}</li>
			<li>내용 : ${upload.content}</li>
			<li>작성일 : ${upload.createDate}</li>
			<li>수정일 : ${upload.modifyDate}</li>
		</ul>
		<div>
			<form id="frm_upload" method="post">
				<input type="hidden" name="uploadNo" value="${upload.uploadNo}">
				<input type="button" value="게시글편집" id="btn_upload_edit"> 			
				<input type="button" value="게시글삭제" id="btn_upload_remove"> 			
				<input type="button" value="게시글목록" id="btn_upload_list"> 			
			</form>
		</div>
	</div>
	
	<hr>
	
	<div>
		<h3>첨부 다운로드</h3>	
		<c:forEach items="${attachList}" var="attach">
			<div>
				<a href="${contextPath}/upload/download?attachNo=${attach.attachNo}">${attach.origin}</a>
			</div>
		</c:forEach>
		<br>
		<div>
			<a href="${contextPath}/upload/downloadAll?uploadNo=${upload.uploadNo}">모두 다운로드</a>
		</div>
	</div>
	
</body>
</html>