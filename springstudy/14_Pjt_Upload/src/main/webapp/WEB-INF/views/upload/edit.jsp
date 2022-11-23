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
		fn_fileCheck();
		fn_removeAttach();
	});
		
	function fn_fileCheck(){
		
		$('#files').change(function(){
			
			// 첨부 가능한 파일의 최대 크기
			let maxSize = 1024 * 1024 * 10;  // 10MB
			
			// 첨부된 파일 목록
			let files = this.files;
			
			// 첨부된 파일 순회
			for(let i = 0; i < files.length; i++){
				
				// 크기 체크
				if(files[i].size > maxSize){
					alert('10MB 이하의 파일만 첨부할 수 있습니다.');
					$(this).val('');  // 첨부된 파일을 모두 없애줌
					return;
				}
				
			}
			
		});
		
	}
	
	function fn_removeAttach(){
		// 첨부 삭제
		$('.btn_attach_remove').click(function(){
			if(confirm('해당 첨부파일을 삭제할까요?')){
				location.href = '${contextPath}/upload/attach/remove?uploadNo=' + $(this).data('upload_no') + '&attachNo=' + $(this).data('attach_no');
			}
		});
	}
	
</script>
</head>
<body>

	<div>
	
		<h1>수정화면</h1>
		
		<form action="${contextPath}/upload/modify" method="post" enctype="multipart/form-data">
		
			<input type="hidden" name="uploadNo" value="${upload.uploadNo}">
		
			<div>
				<label for="title">제목</label>
				<input type="text" id="title" name="title" value="${upload.title}" required="required">
			</div>
			<div>
				<label for="content">내용</label>
				<input type="text" id="content" name="content" value="${upload.content}">
			</div>
			<div>
				<label for="files">첨부 추가</label>
				<input type="file" id="files" name="files" multiple="multiple">
			</div>
			<div>
				<button>수정완료</button>
				<input type="button" value="목록" onclick="location.href='${contextPath}/upload/list'">
			</div>
		
		</form>
		
		<div>
			<h3>첨부삭제</h3>	
			<c:forEach items="${attachList}" var="attach">
				<div>
					${attach.origin}<input type="button" value="삭제" class="btn_attach_remove" data-upload_no="${upload.uploadNo}" data-attach_no="${attach.attachNo}">
				</div>
			</c:forEach>
		</div>
	
	</div>
	
</body>
</html>