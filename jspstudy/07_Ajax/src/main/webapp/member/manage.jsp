<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String contextPath = request.getContextPath();
	pageContext.setAttribute("contextPath", contextPath); // <- <c:set var = "contextPath" value="<%=req... 과 같다
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/member.css"> 
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
/* ajax는 요청과 응답이 동일한 곳에서 진행된다. */
	$(document).ready(function(){
		fn_init();
		fn_getAllMembers();
		fn_getMember();
		fn_registration();
		fn_modify();
		fn_remove();
	});
	
	
	function fn_init(){
		$('#id').val('').prop('readonly', false);
		$('#name').val('');
		$(':radio[name=gender]').prop('checked', false);
		$('#grade').val('');
		$('#address').val('');
	}
	
	function fn_getAllMembers(){
		$.ajax({
			/* 요청 */
			type : 'get',
			url : '${contextPath}/member/list.do',
			/* 응답 */
			dataType : 'json', 
			data : 'memberNo=' + $(this).next().val(),
			success : function(resData){
				// 1. redData.count, resData['count']
				$('#count').text(resData.count);
				console.log(resData);
				// 2. member_list 영역 초기화
				$('#member_list').empty();
				// 3. resData.members : [{}, {}, {}]
				//	  $.each(배열, function(인덱스, 배열요소){})
			
				$.each(resData.members, function(i, member){
					var tr= '<tr>';
					tr += '<td>' + member.memberNo + '</td>'; // domain의 필드 이름과 같다
					tr += '<td>' + member.id + '</td>';
					tr += '<td>' + member.name + '</td>';
					tr += '<td>' + (member.gender == 'M' ? '남자' : '여자') + '</td>';
					tr += '<td>' + member.grade + '</td>';
					tr += '<td>' + member.address + '</td>';
					tr += '<td><input type="hidden" value="'+ member.memberNo + '"><input type="button" value="조회" class="btn_detail">   <input type="button" value="삭제" class="btn_primary btn_remove" onclick="fn_remove()"></td>';  // btn_detail을 id로 하게되면 each문으로 의하여 같은 id가 생기므로 class로 해준다.
					tr += '</tr>';
					$('#member_list').append(tr); 
				});
			}
		});
	}
	function fn_getMember(){
		// "조회" 버튼은 동적 요소이기 때문에 다음 이벤트 방식을 사용해야 한다.
		// $(부모요소).on(이벤트타입, 이벤트대상, 이벤트리스너) - > 부모요소는 그냥 상위요소면됨
		
		$('body').on('click', '.btn_detail', function(){	
			$.ajax({
				/* 요청 */
				type : 'get',
				url : '${contextPath}/member/detail.do',
				data : 'memberNo=' + $(this).prev().val(),  // data는 parameter 부분
				/* 응답 */
				dataType : 'json',
				success : function(resData){ // resData : ["exists" : true, "member" : {"id" : "user3", ....}]
					if(resData.exists){
						alert('회원 정보를 조회했습니다.');
						$('#id').val(resData.member.id).prop('readonly', true);
						$('#name').val(resData.member.name);
						$(':radio[name=gender][value=' + resData.member.gender  + ']').prop('checked', true)
						$('#grade').val(resData.member.grade);
						$('#address').val(resData.member.address);
						$('#memberNo').val(resData.member.memberNo);
					} else{
						alert('조회된 회원 정보가 없습니다.');
					}
				}
			});
		});
		
	}
	
	function fn_registration(){
		$('#btn_add').click(function(){
			$.ajax({
				/* 요청 */
				type : 'post',				// insert와 update는 post로
				url: '${contextPath}/member/add.do',
				data : $('#frm_member').serialize(),		// .serialize() : 폼의 모든 입력 요소를 파라미터로 변환
				/* 응답 */
				dataType : 'json',
				// 정상 응답 SUCCESS
				success : function(resData){	// resData : {"isSuccess" : true}
					if(resData.isSuccess){
						alert('신규 회원이 등록되었습니다.');
						fn_getAllMembers(); // 등록하고 전체 목록을 새로 가져옴
						fn_init(); 	// 입력된 데이터를 초기화
					}else{
						alert('신규 회원이 등록이 실패했습니다.');
					}
				},
				// 예외 응답
				error : function(jqXHR){ // 예외 처리 응답 데이터(일반 텍스트는) jqXHR객체dml responseText 속성에 저장됨
					alert(jqXHR.responseText);
				}
			}); // ajax
		}); // click
		
	} // function 
	
	function fn_modify(){
		$('#btn_modify').click(function(){
			
			$.ajax({
				type : 'post',
				url : '${contextPath}/member/modify.do',
				data : $('#frm_member').serialize(),
				
				/* 응답 */
				dataType: 'json',
				// 정상 응답 SUCCESS
				success : function(resData){ // resData : {"isSuccess" : true}
					if(resData.isSuccess){
						alert('회원 정보 수정이 완료되었습니다.');
						fn_getAllMembers(); // 수정된 내용이 반영되도록 회원목록을 새로 고침
						fn_init();
					} else{
						alert('회원 정보 수정이 실패했습니다.');
					}
					
				},
				
				error : function(jqXHR){
					alert(jqXHR.responseText);
				}
			}); // ajax
		}); // click
	}// function 
	
	function fn_remove(){
		$('body').on('click', '.btn_remove',function(){
			
			if(confirm('삭제할까요?') == false){
				return;
			}

			$.ajax({
				/* 요청 */
				type : 'get',
				url : '${contextPath}/member/remove.do',
				data : 'memberNo=' + $(this).next().val(),    // 삭제 버튼의 다음태그의 value
				
				/* 응답 */
				dataType : 'json',
				success : function(resData){
					if(resData.isSuccess){
						alert('회원 정보가 삭제되었습니다.');
						fn_getAllMembers();
						fn_init();
					} else {
						alert('회원 정보 삭제가 실패했습니다.')
					}
				},
				error : function(jqXHR){
					alert(jqXHR.responseText);
				}
			}); // ajax
				
		}); // click
			
		
	} // function
</script>
</head>
<body>

	<div class="wrap">
		<h1 class="title">회원관리</h1>
		<form id="frm_member">
			<label for="id">아이디</label>
			<div class="ipt_area">
				<input type="text" id="id" name="id" class="frm_member_ipt">
			</div>
			<label for="name">이름</label>
			<div class="ipt_area">
				<input type="text" id="name" name="name" class="frm_member_ipt">
			</div>
			<label>성별</label>
			<div class="gender_area">
				<label for="male">
					남자
					<input type="radio" id="male" name="gender" value="M">
				</label>
				<label for="female">
					여자
					<input type="radio" id="female" name="gender" value="F">
				</label>
			</div>
			<label for="grade">회원등급</label>
			<div class="ipt_area">
				<select id="grade" name="grade"  class="frm_member_ipt">
					<option value="">등급선택</option>
					<option value="gold">골드</option>
					<option value="silver">실버</option>
					<option value="bronze">브론즈</option>
				</select>
			</div>
			<label for="address">주소</label>
			<div class="ipt_area">
				<input type="text" id="address" name="address"  class="frm_member_ipt">
			</div>
			<div class="btn_area">
				<input type="button" value="초기화" id="btn_init" class="btn_primary">
				<input type="button" value="신규등록" id="btn_add" class="btn_primary">
				<input type="button" value="변경내용저장" id="btn_modify" class="btn_primary">
				<input type="button" value="회원삭제" id="btn_remove" class="btn_primary btn_remove">
				<input type="hidden" id="memberNo">	
			</div>
		</form>
		<hr>
		<table class="member_table">
			<caption>전체 회원수 : <span id="count"></span>명</caption>
			<thead>
				<tr>
					<td>회원번호</td>
					<td>아이디</td>
					<td>이름</td>
					<td>성별</td>
					<td>등급</td>
					<td>주소</td>
					<td></td>
				</tr>
			</thead>
			<tbody id="member_list"></tbody>
		</table>
	</div>

</body>
</html>