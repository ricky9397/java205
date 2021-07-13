const toogleBtn = document.querySelector('.navbar_toogleBtn');
const menu = document.querySelector('.navbar_menu');
const icons = document.querySelector('.navbar_icons');

toogleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
    icons.classList.toggle('active');
});


$(document).ready(function () {

    $('#login_form').submit(function () {
        if ($('#id').val().trim().length < 1) {
            $('#id+div.msg').html('아이디를 입력하세요.');
            $('#id+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#id').css('border', '1px solid red');
            return false;
        } else {
            $('#id+div.msg').html('');
            $('#id+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#id').css('border', '1px solid green');
        }

        if ($('#pw').val().trim().length < 1) {
            $('#pw+div.msg').html('비밀번호를 입력하세요.');
            $('#pw+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#pw').css('border', '1px solid red');
            return false;
        } else {
            $('#pw+div.msg').html('');
            $('#pw+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#pw').css('border', '1px solid green');
        }

        alert('어서오세요. OHMYGOT입니다.');
    });

    $('#id').focus(function () {
        $('#id+div.msg').css('display', 'none');
        $('#id+div.msg').html('');
        $('#id').val('');
    });

    $('#pw').focus(function () {
        $('#pw+div.msg').css('display', 'none');
        $('#pw+div.msg').html('');
        $('#pw').val('');
    });
});