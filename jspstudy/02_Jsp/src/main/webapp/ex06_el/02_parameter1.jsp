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
		EL의 파라미터 처리
		1. EL 내장객체 param을 사용(param, paramValues)
		2. 모든 파라미터 String이므로 크기 비교가 정상이 아님
			예시) 
			"10", "5" 중 누가 큰가? "5"가 크다(문자열의 크기는 사전 편찬 순)
		3. 파라미터의 크기 비교
			두 파라미터의 차이를 구한 뒤 0보다 큰지 여부를 판단
			두 파라미터의 차이 결과는 숫자가 반환됨
			"10" - "5" == 5
	 --%>
	
	<div>
		<form method="GET" action="02_parameter2.jsp">
			<div>
				<input type="text" name="a">
			</div>
			<div>
				<input type="text" name="b">
			</div>
			<div>
				<input type="submit" value="전송">
			</div>
		</form>
	</div>
</body>
</html>