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
		
		// 첨부 삭제
		$('.btn_attach_remove').click(function(){
			if(confirm('해당 첨부파일을 삭제 할까요?')){
				location.href= '${contextPath}/upload/attach/remove?uploadNo=' + $(this).data('upload_no') + '&attachNo=' + $(this).data('attach_no'); //btn_attach_remove의 데이터 속성 꺼내와서 파라미터로 넘김
			}
		});
	});

</script>
</head>
<body>

	<div>
		<h1>업로드 게시판 정보</h1>
		<ul>
			<li>제목 : ${upload.title}</li>
			<li>내용 : ${upload.content}</li>
			<li>작성일 : ${upload.createDate}</li>
			<li>수정일 : ${upload.modifyDate}</li>
		</ul>
	
	</div>
	
	<hr>
	
	<div>
		<h3>첨부목록</h3>
		<c:forEach items="${attachList}" var="attach">
			<div>
				<a href="${contextPath}//upload/download?attachNo=${attach.attachNo}">${attach.origin}</a>
				<input type="button" value="삭제" class="btn_attach_remove" data-upload_no="${upload.uploadNo}" data-attach_no= "${attach.attachNo}">
			</div>
		</c:forEach>
	</div>
	

	
</body>
</html>