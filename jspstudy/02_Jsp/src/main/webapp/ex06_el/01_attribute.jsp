<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		/*  1. EL 사용이 가능한 4개 영역
			1) pageContext
			2) request
			3) session
			4) application */

		/*  
			2. EL 연산자
				1) 산술 연산자 : + - * /(div) %(mod)
				2) 관계 연산자 : <(lt) <=(le) >(gt) ==(eq) !=(ne)
				3) 논리 연산자 : &&(and)  ||(or)  !(not)
				4) 조건 연산자 : (조건식) ? 값1 : 값2
		*/
		
		pageContext.setAttribute("a", 7);
		pageContext.setAttribute("b", 2);
	%>
	
	<div>${a + b}</div>
	<div>${a - b}</div>
	<div>${a * b}</div>
	<div>${a / b}, ${a div b}</div>
	<div>${a % b}, ${a mod b}</div>
	
	<div>${a  < b},${a lt b}</div>
	<div>${a <= b},${a le b}</div>
	<div>${a  > b},${a gt b}</div>
	<div>${a >= b},${a ge b}</div>
	<div>${a == b},${a eq b}</div>
	<div>${a != b},${a ne b}</div>
	
	<div>${a==7 && b==2}, ${a eq 7 and b eq 2}</div>
	<div>${a==7 || b==2}, ${a eq 7 or b eq 2}</div>
	<div>${!(a==7)}, ${not (a==7)}</div>
	
	<div>${a==8 ? "a는 7이다" : 'a는 7이 아니다'}</div>
	
</body>
</html>