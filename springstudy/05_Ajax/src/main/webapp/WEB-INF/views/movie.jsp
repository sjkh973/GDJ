<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${contextPath}/resources/css/jquery-ui.min.css">
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script> <!-- 제이쿼리가 먼저 -->
<script src="${contextPath}/resources/js/jquery-ui.min.js"></script>
<script>
	
$(document).ready(function(){
    
    $('#targetDt').datepicker({
       dateFormat : 'yymmdd' // 실제로는 yyyymmdd로 적용
    });
    
    $('#btn').click(function(){
       $.ajax({
          type : 'get',
          url : '${contextPath}/movie/boxOfficeList', 
          data : 'targetDt=' + $('#targetDt').val(),
          dataType : 'json',
          success : function(resData){
             // 기존 목록 초기화 
             $('#boxOfficeList').empty();
             // 가져온 목록 나타내기
             $.each(resData.boxOfficeResult.dailyBoxOfficeList, function(i, movie){
                $('<tr>')
                .append( $('<td>').text(movie.rank))
                .append( $('<td>').text(movie.movieNm))
                .append( $('<td>').text(movie.openDt))
                .append( $('<td>').text(movie.audiCnt))
                .append( $('<td>').text(movie.audiAcc))
                .appendTo('#boxOfficeList');
                 
             });
          }
       });
    });
    
 });
	
</script>
</head>
<body>

	<div>
		<label for="targetDt">조회날짜</label>
		<input type="text" id="targetDt">
		<input type="button" value="조회" id="btn">
	</div>

	<hr>
	
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>순위</td>
					<td>영화제목</td>
					<td>개봉일</td>
					<td>일일관객수</td>
					<td>누적관객수</td>
				</tr>
			</thead>
			<tbody id="boxOfficeList"></tbody>
		</table>
	</div>
	
</body>
</html>