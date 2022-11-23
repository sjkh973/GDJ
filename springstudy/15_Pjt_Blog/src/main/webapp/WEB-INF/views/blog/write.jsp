<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<jsp:include page="../layout/header.jsp">
	<jsp:param value="블로그작성" name="title"/>
</jsp:include>

<script>

	// contextPath를 반환하는 자바스크립트 함수
	function getContextPath(){
		console.log(location);
		var begin = location.href.indexOf(location.origin) + location.origin.length;
		var end = location.href.indexOf("/", begin + 1);
		return location.href.substring(begin, end);
	}

   $(document).ready(function(){
      
	   console.log(getContextPath());
	   
      $('#content').summernote({  // id content가 서머노트로 바뀜
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
 			    ['height', ['height']],
 			    ['insert', ['link', 'picture', 'video']]
 			  ]
      });
      
      // 목록
      $('#btn_list').click(function(){
    	 location.href= getContextPath() + '/blog/list'; 
      });
      
      // 서브밋
      $('#frm_write').submit(function(event){
    	  if($('#title').val() == ''){
    		  alert('제목은 필수입니다.');
    		  event.preventDefault(); // 서브밋 취소
    		  return; // 더 이상 코드 실행할 필요 없음
    	  }
      });
      
   });
      
</script>
</head>
<body>

      <div>
      	<h1>작성 화면</h1>
      	<form id="frm_write" action="${contextPath}/blog/add" method="post">
      	
      		<div>
      			<label for="title">제목</label>
      			<input type="text" name="title" id="title">
      		</div>      		
      		
      		<div>
      			<label for="content">내용</label>
      			<textarea name="content" id="content"></textarea>
      		</div>
      		
      		<div>
      			<button>작성완료</button>
      			<input type="reset" value="입력초기화">
      			<input type="button" value="목록" id="btn_list">
      		</div>
      	</form>
      </div>

</body>
</html>

