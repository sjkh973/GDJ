<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


.paginate {
    padding: 10px 0;
    position: relative;
    min-height: 22px;
    margin-top: 17px;
    text-align: center;
}
.paginate a:hover, .paginate strong.page {
    border: 1px solid #e0e0e0;
    color: #00c73c;
}

.paginate a, .paginate strong.page, .low_btn {

    position: relative;
    min-width: 20px;
    height: 20px;
    margin: -1px 1px;
    padding: 2px 2px 0;
    border: 1px solid #fff;
    font-family: tahoma,helvetica,sans-serif;
    color: #999;
    line-height: normal;
    text-decoration: none;
    vertical-align: top;
    letter-spacing: -1px;
}




.blind {
   border: 1px solid #e0e0e0 !important;
    color: #00c73c !important;
}
</style>

<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function(){
	// area1, area2 표시
	// 초기 상태 : area1, area2 둘 다 숨김
	$('#area1, #area2').css('display', 'none');
	// column 선택에 따른 area1, area2 표시
	$('#column').change(function(){
		let combo = $(this);
		if(combo.val() == ''){
			$('#area1, #area2').css('display', 'none');
		} else if(combo.val() == 'HIRE_DATE' || combo.val() == 'SALARY'){
			$('#area1').css('display', 'none');
			$('#area2').css('display', 'inline');
		} else {
			$('#area1').css('display', 'inline');
			$('#area2').css('display', 'none');
		}
	});
	
	// 자동 완성
	$('#param').keyup(function(){
		$('#auto_complete').empty();
		if($(this).val() == ''){
			return;
		}
		$.ajax({
			/* 요청 */
			type : 'get',
			url : '${contextPath}/emp/autoComplete',
			data: 'target=' + $('#target').val() + '&param=' + $(this).val(),
			/* 응답 */
			dataType : 'json',
			success : function(resData){
				if(resData.status == 200){
					$.each(resData.list, function(i, emp){
						$('#auto_complete')
						.append($('<option>').val(emp[resData.target]));
					});
				}
			}
		});
	});
	
});
</script>
</head>
<body>

	<div>
		<form id="frm_search" action="${contextPath}/emp/search">
			<select id="column" name="column">
				<option value="">:::선택:::</option>
				<option value="EMPLOYEE_ID">사원번호</option>
				<option value="E.DEPARTMENT_ID">부서번호</option>
				<option value="LAST_NAME">성</option>
				<option value="FIRST_NAME">이름</option>
				<option value="PHONE_NUMBER">연락처</option>
				<option value="HIRE_DATE">입사일</option>
				<option value="SALARY">연봉</option>
			</select>
			<span id="area1">
				<input type="text" id="query" name="query">
			</span>
			<span id="area2">
				<input type="text" id="start" name="start">
				~
				<input type="text" id="stop" name="stop">
			</span>
			<span>
				<input type="submit" value="검색">
				<input type="button" value="전체사원조회" id="btn_all">	
			</span>
		</form>
	</div>
	
	<div>
		<select name="target" id="target">
			<option value="FIRST_NAME">이름</option>
			<option value="LAST_NAME">성</option>
			<option value="EMAIL">이메일</option>
		</select>
		<input type="text" id="param" name="param" list="auto_complete">
		<datalist id="auto_complete"></datalist>
	</div>
	
	<hr>

   <div style="width:1000px; margin:0 auto;">
      <table border="1">
         <thead>
            <tr>
               <td>순번</td>
               <td>사원번호</td>
               <td>사원명</td>
               <td>이메일</td>
               <td>전화번호</td>
               <td>입사일자</td>
               <td>연봉</td>
               <td>커미션</td>
               <td>부서번호</td>
               <td>부서명</td>
            </tr>
         </thead>
         <tbody>
            <c:forEach items="${employees}" var="emp" varStatus="vs">
               <tr>
                  <td>${beginNo - vs.index}</td>
                  <td>${emp.employeeId}</td>
                  <td>${emp.firstName} ${emp.lastName}</td>
                  <td>${emp.email}</td>
                  <td>${emp.phoneNumber}</td>
                  <td>${emp.hireDate}</td>
                  <td>${emp.salary}</td>
                  <td>${emp.commissionPct}</td>
                  <td>${emp.deptDTO.departmentId}</td>
                  <td>${emp.deptDTO.departmentName}</td>
               </tr>
            </c:forEach>
         </tbody>
         <tfoot>
            <tr>
               <td colspan="10" class="paginate">            
                  ${paging}
               </td>
            </tr>
         </tfoot>
      </table>
   </div>

</body>
</html>