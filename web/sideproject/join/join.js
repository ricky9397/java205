const toogleBtn = document.querySelector('.navbar_toogleBtn');
const menu = document.querySelector('.navbar_menu');
const icons = document.querySelector('.navbar_icons');

toogleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
    icons.classList.toggle('active');
});

$(document).ready(function(){
    
    var id = $('#id');

    $('#join_form').submit(function(){
        if($(id).val().trim().length < 1){
            $('#id+div.msg').html('필수항목입니다.');
            $('#id+div.msg').css('display', 'block');
            return false;
        } else if($(id).val().trim().length > 1){
            $('#id+div.msg').html('멋진아이디네요');
            $('#id+div.msg').css({'display': 'block', 'color': 'green'});
            return false;
        }

        if($('#pw').val().trim().length < 1){
            $('#pw+div.msg').html('필수항목입니다.');
            $('#pw+div.msg').css('display', 'block');
        } 

    });

});