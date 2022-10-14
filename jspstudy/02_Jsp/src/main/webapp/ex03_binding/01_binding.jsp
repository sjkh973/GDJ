<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		1. JSP의 Binding 영역 4개
			1) application : ServletContext와 같은 영역
			2) session     : Httplsession과 같은 영역
			3) request     : HttpServletRequest와 같은 영역
			4) pageContext : 하나의 Jsp 페이지에서 접근 가능한 영역
	 --%>
	
	<%
		application.setAttribute("a", 1);  // a라는 이름으로 1 저장
		session.setAttribute("b", 2);
		request.setAttribute("c", 3);
		pageContext.setAttribute("d", 4);
	%>
	
	<!-- 표현식으로 속성 접근 -->
	<div>a : <%=application.getAttribute("a") %> </div>
	<div>b : <%=session.getAttribute("b") %> </div>
	<div>c : <%=request.getAttribute("c") %> </div>
	<div>d : <%=pageContext.getAttribute("d") %> </div>

	<!-- 표현언어(EL)를 이용해 속성 접근 -->
	<div>a : ${a}</div>
	<div>b : ${b}</div>
	<div>c : ${c}</div>
	<div>d : ${d}</div>
	
	<%-- 
		2. 우선 순위
			1) 같은 이름의 속성이 서로 다른 영역에 저장된 경우 먼저 사용되는 우선 순위가 존재함
			2) pageContext > request > session > application 순으로 우선순위가 적용됨
			3) 각 영역을 지정하는 표현 언어(EL)의 내장 객체가 존재함
				(1) pageScope
				(2) sessionScope
				(3) requestScope
				(4) pageContextScope
	--%>
	
	<%
		application.setAttribute("movie", "기생충");
		session.setAttribute("movie","터미네이터");
		request.setAttribute("movie","아바타");
		pageContext.setAttribute("movie","미나리");
	%>
	
	<div>application's movie : ${applicationScope.movie}</div>
	<div>session's movie : ${sessionScope.movie}</div>
	<div>request's movie : ${requestScope.movie}</div>
	<div>pageContext's movie : ${movie}</div>
		
				
	
	
	
	
</body>
</html>