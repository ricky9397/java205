$(document).ready(function(){
    $('#allCheck').change(function(){
        
        if(this.checked){
            $('.checkItem').prop('checked', true);
        } else {
            $('.checkItem').prop('checked', false);
        }
    });

    $('#form_check').submit(function(){
        if($('.check1').is(':checked') == false){
            alert('모든 약관에 동의 하셔야 합니다.');
            return;
        } else if($('.check2').is(':checked') == false){
            alert('모든 약관에 동의 하셔야 합니다.');
            return;
        } else {
            alert('회원가입 페이지이동')
        }
    });
});