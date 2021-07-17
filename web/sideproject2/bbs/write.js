$(document).ready(function(){
    $('textarea').keyup(function(){

        var cnt = $(this).val().length;
        var remain = 150 - cnt;

        console.log(cnt, remain);

        if(remain < 0){
            /* 150자 이상되면 뒤에 글자를 짤라줘서 더이상 들어가지 않게 해준다. */
            alert('소개서는 150자까지 작성이 가능합니다.');
            var str = $(this).val().substr(0, 150);
            $(this).val(str);
            $('#count').text('10000');
            return false;
        }
        $('#count').text(cnt);
    });
});