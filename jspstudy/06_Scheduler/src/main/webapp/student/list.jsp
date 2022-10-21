<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생관리</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
			
		$('#btn_add').click(function(event){
			location.href= '${contextPath}/student/write.do';
		});
		
		$('#btn_find').click(function(event){
			var begin = $('#begin').val();
			var end = $('#end').val();
			if(begin == '' || isNaN(begin) || begin < 0 || begin > 100){
				alert('begin값을 확인하세요.');
				return;
			}
			else if(end == '' || isNaN(end) || end < 0 || end > 100){
				alert('end값을 확인하세요.');
				return;
			}
			
			location.href= '${contextPath}/student/find.do?begin=' + begin + '&end=' + end;
		});
		
		$('#btn_list').click(function(event){
			location.href ='${contextPath}/student/list.do';
		});
		
		
		
		
		
	});
	
</script>
<link rel="stylesheet" href="../assets/css/student.css">
</head>
<body>
	
	<div class="wrap">
		<h1 class="title">학생관리</h1>
		<div class="btn_area">
			<input type="button" value="신규학생등록" class="btn_primary btn_add" id="btn_add">
		</div>
		<div class="find_area">
			<span>평균</span>
			<input type="text" name="begin" id="begin" size="4" placeholder="begin">
			~
			<input type="text" name="end" id="end" size="4" placeholder="end">
			<input type="button" value="조회" class="btn_primary" id="btn_find">
			<input type="button" value="전체조회" class="btn_primary" id="btn_list">
		</div>
		<div class="main_area">
			<table>
				<caption>전체 학생 ${count}명</caption>
				<thead>
					<tr>
						<td>학번</td>
						<td>성명</td>
						<td>국어</td>
						<td>영어</td>
						<td>수학</td>
						<td>평균</td>
						<td>학점</td>
						<td>버튼</td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${count eq 0}">
						<tr>
							<td colspan="8">등록된 학생이 없습니다.
						</tr>
					</c:if>
					<c:if test="${count ne 0}"> <!--  -->
						<c:forEach items="${students}" var="s">
							<tr>
								<td>${s.stuNo}</td>
								<td>${s.name}</td>
								<td>${s.kor}</td>
								<td>${s.eng}</td>
								<td>${s.math}</td>
								<td><fmt:formatNumber value="${s.ave}" pattern="0.00" /></td>
								<td>${s.grade}</td>
								
								<td>
									<input type="button" value="상세" class="btn_primary" onclick="fn_detail(${s.stuNo})">
									<input type="button" value="삭제" class="btn_primary btn_remove" onclick="fn_remove(${s.stuNo})">
									<script>
										function fn_detail(stuNo){
											location.href = '${contextPath}/student/detail.do?stuNo=' + stuNo;
										}
												
										function fn_remove(stuNo){
											if(confirm('학생 정보를 삭제할까요?')){
												location.href='${contextPath}/student/remove.do?stuNo=' + stuNo;
											}
										}					
									</script>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">전체평균</td>
						<td><fmt:formatNumber value="${average}" pattern="0.00"/></td>
						<td></td>
						<td></td>
					</tr>
				</tfoot>
				
				
			</table>
		</div>
	</div>
	

</body>
</html>