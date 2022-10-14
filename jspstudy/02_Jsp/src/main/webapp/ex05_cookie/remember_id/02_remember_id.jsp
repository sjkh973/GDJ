<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 요청 파라미터
	request.setCharacterEncoding("UTF-8");

	// 아이디를 입력 안하면 빈 문자열("")
	String id = request.getParameter("id");
	
	// 체크박스를 체크 안하면 null
	String chkRememberId = request.getParameter("chk_remember_id");
	
	// 아이디 기억하기
	// 1. 아이디 기억하기를 체크했다면 아이디를 쿠키에 저장한다.(30일간 아이디 보관)
	// 2. 아이디 기억하기를 체크하지 않았다면 아이디를 쿠키에서 제거한다.
	boolean isRemember = false;
	Cookie cookie = null;
	if(chkRememberId != null) {
		isRemember = true;
		cookie = new Cookie("rememberId", id);
		cookie.setMaxAge(60 * 60 * 24 * 30);
	} else {
		cookie = new Cookie("rememberId", id);
		cookie.setMaxAge(0);
	}
	response.addCookie(cookie);
%>
<script>
	if(<%=isRemember%>){
		alert('아이디가 기억되었습니다.');
	} else {
		alert('아이디가 기억되지 않았습니다.');
	}
	location.href = '01_form.jsp';
	
</script>