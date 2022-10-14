<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 요청 파라미터
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	// 로그인 처리
	// id와 pwd가 동일하면 로그인 성공으로 처리
	if(id.equals(pwd)){
		session.setAttribute("id", id);   // 세션에 id라는 이름으로 id 저장
		session.setAttribute("pwd", pwd);
	}
	
	// 로그인 폼으로 가기
	response.sendRedirect("01_form.jsp");
	
%>