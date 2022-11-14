/**
 * 
 */
 
 	$(function(){
		
		fn_checkAll();
		fn_checkOne();
		fn_toggleCheck();
		
		$('#frm_agree').submit(function(event){
			if($('#service').is(':checked') == false || $('#privacy').is(':checked') == false){
				alert('필수 약관에 동의하세요.');
				event.preventDefault();
				return;
			}
		});
	});
 
	// 모두동의 (모두 동의의 체크 상태를 개별 선택들의 체크 상태)
	function fn_checkAll(){
		$('#check_all').click(function(){
			// 체크 상태 변경
			$('.check_one').prop('checked', $(this).prop('checked'));    // id #check_all의 .prop()의 값에따라서 클래스 .check_one들의 체크(prop)가 결정됨
			// 체크 이미지 변경
			if($(this).is(':checked')){ // 모두 동의가 체크되었다면
				$('.lbl_one').addClass('lbl_checked');
			} else{
				$('.lbl_one').removeClass('lbl_checked');
			}
		});
	}
	
	// 개별 선택 (항상 개별 선택 4개를 모두 순회하면서 어떤 상태인지 체크해야 함)
	function fn_checkOne(){
		$('.check_one').click(function(){
			// 체크 상태 변경
			let checkCount = 0;
			for(let i = 0; i < $('.check_one').length; i++){
				//  $($(this)[i]).prop('checked')의 값은 true false // true이면 checkCount에 1을 더해줌
				checkCount += $($('.check_one')[i]).prop('checked');   // $(this)[i] 는 일반변수이므로 제이쿼리 랩퍼로 한번 싸줌 
			}
			// 체크박스개수 vs 체크된박스 개수
			$('#check_all').prop('checked', $('.check_one').length == checkCount)  // checkCount(체크된 체크박스)의 갯수가 class .check_one의 길이와 같다면 id check_all checked해준다 
			// 체크 이미지 변경
			if($('#check_all').is(':checked')){
				$('.lbl_all').addClass('lbl_checked');
			} else{
				$('.lbl_all').removeClass('lbl_checked');
			}
			
		});
	}

	// 체크할때마다 lbl_checked 클래스를 줫다 뺐었다 하기
	function fn_toggleCheck(){
		$('.lbl_all, .lbl_one').click(function(){
			$(this).toggleClass('lbl_checked');
		});
	}