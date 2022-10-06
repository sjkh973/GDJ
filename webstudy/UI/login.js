document.getElementById('btn_signin').onclick = function(event){
    var pw = document.getElementById('pw');
    if(pw.value== ''){ /* pw.value <- 비밀번호 입력값*/
        alert('비밀번호를 입력하세요.');
        /* 이벤트의 동작 방지 메소드로 동작을 막는다 submit을 막을때 주로씀 */
        event.preventDefault(); 
    }  
}
/* 버튼 이벤트 리스너에 아이디를 변수추가하여 이벤트 동작 방지 메소드하면될듯????? */
document.getElementById('id').onkeyup = function(event){
    var id = document.getElementById('id');
    var id_msg = document.getElementById('id_msg');
    if(id.value.length == 0){
        id_msg.textContent = '';       
    } else if(id.value.length <4){
        id_msg.textContent = '아이디는 4자 이상입니다.';
    } else if(id.value.length >= 4){
        id_msg.textContent = '정상적인 아이디입니다.';
    }
}