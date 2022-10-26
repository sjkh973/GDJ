<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	pageContext.setAttribute("contextPath", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>

$(document).ready(function(){
	$('#btn_refresh').click(function(){
		$.ajax({
			/* 요청 */
			type: 'get',
			url: '${contextPath}/member/refreshCaptcha.do',
			/* 응답 */
			dataType: 'json',
			success: function(resData){  // resData : {"dirname": "", "filename": "" "key" : ""}
				$('#ncaptcha').prop('src', '../' + resData.dirname + '/' + resData.filename);
				$('#key').val(resData.key);
			}
		});
	});
});
	
</script>
</head>
<body>
	
	<div class="wrap">
		
		<h1>로그인</h1>
		<form action="${contextPath}/member/validateCaptcha.do" method="post">
			<div>
				<input type="text" name="id" id="id" placeholder="아이디">
			</div>
			<div>
				<input type="password" name="pwd" id="pwd" placeholder="●●●●">
			</div>
			<div>
				<p>아래 이미지를 보이는 대로 입력해주세요.</p>
				<div style="display: flex;">
					<div>
						<img src="../${dirname}/${filename}" id="ncaptcha">
					</div>
					<div>
						<input type="button" value="새로고침" id="btn_refresh">
					</div>
				</div>
			</div>
			<div>
				<input type="text" name="value" placeholder="자동입력 방지문자">
				<input type="text" name="key" id="key" value="${key}"> 
			</div>
			<div>
				<button>로그인</button>
			</div>
		</form>
		
	</div>
</body>
</html>