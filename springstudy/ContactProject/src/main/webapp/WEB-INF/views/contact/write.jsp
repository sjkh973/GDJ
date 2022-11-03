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
<script>

	var frm = $('#frm_btn');

	$(document).ready(function(){
		
		$('#frm_btn').submit(function(){
			alert('연락처가 등록되었습니다.');
			frm.submit();
		});
		
		$('#btn_list').click(function(){
			location.href='${contextPath}/list';
		});
		
	    
	    
	   
	});
</script>
</head>
<body>
<h1> 연락처 등록</h1>

<form id="frm_btn" action="${contextPath}/contact/insert" method="post">

	<div>
		<label for="name">이름</label>
		<input type="text" id="name" name="name">
	</div>
	<div>
		<label for="tel">전화</label>
		<input type="text" id="tel" name="tel">
	</div>
	<div>
		<label for="addr">주소</label>
		<input type="text" id="addr" name="addr">
	</div>
	<div>
		<label for="email">이메일</label>
		<input type="text" id="email" name="email">
	</div>
	<div>
		<label for="note">비고</label>
		<input type="text" id="note" name="note">
	</div>
	
	<div>
		<button>연락처 저장하기</button>
		<input type="button" value="전체연락처" id="btn_list">
	</div>
	
</form>
</body>
</html>