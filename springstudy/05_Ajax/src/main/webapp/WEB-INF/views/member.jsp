<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script> 
<script>
	$(document).ready(function(){
		
		$('#btn1').click(function(){
			fn_ajax1();
		});
		$('#btn2').click(function(){
			fn_ajax2();
		});
		$('#btn3').click(function(){
			fn_ajax3();
		});
		$('#btn4').click(function(){
			fn_ajax4();
		});
		
	});
	
	function fn_ajax1() {
		
		$('#result').empty();
		
		$.ajax({
			/* 요청 */
			type : 'get',
			url : '${contextPath}/member/detail1',
			data : 'id=' + $('#id').val() + '&pw=' + $('#pw').val(),
			/* 응답 */
			dataType : 'text',
			success  : function(resData){
				$('#result').text(resData);
			},
			error : function(jqXHR) {
				$('#result').text(jqXHR.responseText);
			}
		}); // ajax
		
	} // function
	function fn_ajax2() {
		$('#result').empty();
		
		$.ajax({
			/* 요청 */
			type : 'get',
			url : '${contextPath}/member/detail2',
			data : $('#frm_member').serialize(),  // .serialize() <- form의 입력요소를 보내줌
			/* 응답 */
			dataType : 'json',
			success  : function(resData){
				var ul = '<ul>';
				ul += '<li>' + resData.id + '</li>';
				ul += '<li>' + resData.pw + '</li>';
				ul += '</ul>';
				$('#result').html(ul);
			},
			error : function(jqXHR) {
				$('#result').text(jqXHR.responseText);
			}
		}); // ajax
		
	} // function
	function fn_ajax3() {
	
		$('#result').empty();
		
		$.ajax({
			/* 요청 */
			type : 'get',
			url : '${contextPath}/member/detail3',
			data : $('#frm_member').serialize(),
			/* 응답 */
			dataType : 'json',
			success : function(resData){
				var ul = '<ul>';
				ul += '<li>' + resData.id + '</li>';
				ul += '<li>' + resData.pw + '</li>';
				ul += '</ul>';
				$('#result').html(ul);
			}
		});
		
	} // function
	
	function fn_ajax4(){
		
		$('#result').empty();
		
		$.ajax({
			/* 요청 */
			url : '${contextPath}/member/detail4',
			// JSON 데이터를 서버로 보낼 때는 반드시 POST방식을 사용해야 함
			type : 'post',
			// data에 파라미터가 없을을 주의!
			// 파라미터로 전달되지 않기 때문에 주소창을 이용한 get방식이 불가능함
			data : JSON.stringify({
				"id" : $('#id').val(),
				"pw" : $('#pw').val(),
			}),
			// 서버로 보내는 JSON 데이터의 MIME-TYPE을 작성해 줌
			contentType : 'application/json',
			/* 응답 */
			dataType : 'json',
			success : function(resData){
				var ul = '<ul>';
				ul += '<li>' + resData.id + '</li>';
				ul += '<li>' + resData.pw + '</li>';
				ul += '</ul>';
				$('#result').html(ul);
			}
			
			}); // ajax
	} // function
	
</script>
<style>
	#frm_member{
		width : 480px;
		margin : 0 auto;
	}
	label {
		display: inline-block;
		width : 80px;
	}
</style>
</head>
<body>
	<form id="frm_member">
		<div>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id">
		</div>
		<div>
			<label for="pw">패스워드</label>
			<input type="password" name="pw" id="pw">
		</div>
		
		<div>
			<input type="button" value="전송1" id="btn1">
			<input type="button" value="전송2" id="btn2">
			<input type="button" value="전송3" id="btn3">
			<input type="button" value="전송4" id="btn4">
		</div>
	</form>
	
	<hr>
	
	<div id="result"></div>
	
</body>
</html>