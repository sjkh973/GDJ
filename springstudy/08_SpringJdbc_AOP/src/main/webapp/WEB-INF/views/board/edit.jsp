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
      
      // 목록
      $('#btn_list').click(function(){
    	 location.href= '${contextPath}/brd/list'; 
      });
      
      // 서브밋
      $('#frm_board').submit(function(event){
    	  if($('#title').val() == ''){
    		  alert('제목과 필수입니다.');
    		  event.preventDefault(); // 서브밋 취소
    		  return; // 더 이상 코드 실행할 필요 없음
    	  }
      });
      
   });
      
</script>
</head>
<body>

      <div>
      	<h1>수정 화면</h1>
      	<form id="frm_board" action="${contextPath}/brd/modify" method="post">
      		<input type="hidden" name="board_no" value="${board.board_no}">
      		<div>
      			<label for="title">제목</label>
      			<input type="text" name="title" id="title" value="${board.title}">
      		</div>
      		<div>
      			<label for="writer">작성자</label>
      			<input type="text" name="writer" id="writer" value="${board.writer}" readonly>
      		</div>
      		<div>
      			<label for="content">내용</label>
      			<textarea name="content" id="content">${board.content}</textarea>
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

