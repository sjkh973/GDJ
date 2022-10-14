<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>${param.a + param.b}</div>
	<div>${param.a - param.b}</div>
	<div>${param.a * param.b}</div>
	<div>${param.a / param.b}, ${param.a div param.b}</div>
	<div>${param.a % param.b}, ${param.a mod param.b}</div>
	
	<div>${param.a  - param.b < 0},${param.a lt param.b lt 0}</div>
	<div>${param.a <= param.b},${param.a - param.b le 0}</div>
	<div>${param.a  > param.b},${param.a gt param.b}</div>
	<div>${param.a >= param.b},${param.a ge param.b}</div>
	<div>${param.a == param.b},${param.a eq param.b}</div>
	<div>${param.a != param.b},${param.a ne param.b}</div>
	
	<div>${param.a==7 && param.b==2}, ${param.a eq 7 and param.7b eq 2}</div>
	<div>${param.a==7 || param.b==2}, ${param.a eq 7 or param.b eq 2}</div>
	<div>${!(param.a==7)}, ${not (param.a==7)}</div>
	
	<div>${param.a==8 ? "a는 7이다" : 'a는 7이 아니다'}</div>
	
</body>
</html>