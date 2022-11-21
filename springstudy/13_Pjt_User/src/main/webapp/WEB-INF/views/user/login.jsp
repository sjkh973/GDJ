<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="requestURL" value="${pageContext.request.requestURL}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	
	$(function(){
		
		fn_login();
		fn_displayRememberId();
		
	});
	
	function fn_login(){
		
		$('#frm_login').submit(function(event){
			
			
			if($('#id').val() == '' || $('#pw').val() == ''){
				alert('아이디와 패스워드를 모두 입력하세요.');
				event.preventDefault();
				return;
			}
			
			if($('#rememberId').is(':checked')){
				$.cookie('rememberId', $('#id').val());   // id에 쓴값을 rememberId라는 이름으로 쿠키에 저장
			} else{
				$.cookie('rememberId', '');
			}
		});
		
	}
	
	function fn_displayRememberId(){
		
		// 세션의 id는 브라우저의 id라 볼수 있다. 브라우저가 닫히고 다시 실행하면 id가 바뀜
		
		
		
		let rememberId = $.cookie('rememberId');     // 쿠키안의 정보를 rememberId 변수에 저장
		if(rememberId == ''){
			$('#id').val('');
			$('#rememberId').prop('checked', false);  // 체크 속성 해제 //저장된 아이디가 없으면 , id 입력창을 공란으로 만들고 아이디저장의 체크를 푼다
		} else{
			$('#id').val(rememberId);
			$('#rememberId').prop('checked', true);  
		}
	}
	
</script>
</head>
<body>

	<div>
	
		<h1>로그인</h1>
		
		<form id="frm_login" action="${contextPath}/user/login" method="post">
			
			<input type="hidden" name="url" value="${url}">
			
			<div>
				<label for="id">아이디</label>
				<input type="text" name="id" id="id">
			</div>
			
			<div>
				<label for="pw">비밀번호</label>
				<input type="password" name="pw" id="pw">
			</div>
			
			<div>			
				<button>로그인</button>
			</div>
			
			<div>			
				<label for="rememberId">
					<input type="checkbox" id="rememberId">
					아이디 저장
				</label>
				<label for="keepLogin">
					<input type="checkbox" name="keepLogin" id="keepLogin">
					로그인 유지
				</label>
			</div>
		
		</form>
			
		<div>
			<a href="${contextPath}/user/findId">아이디 찾기</a> | 
			<a href="${contextPath}/user/findPw">비밀번호 찾기</a>
		</div>
		
		<hr>
		
		<div>
			<a href="${apiURL}"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
		</div>
	
	</div>
	
</body>
</html>