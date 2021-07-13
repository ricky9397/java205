const toogleBtn = document.querySelector('.navbar_toogleBtn');
const menu = document.querySelector('.navbar_menu');
const icons = document.querySelector('.navbar_icons');

toogleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
    icons.classList.toggle('active');
});

$(document).ready(function () {

    var id = $('#id');
    var pw = $('#pw');
    var pw2 = $('#pw2');
    var name = $('#name');
    var email = $('#email');
    var phone = $('#phone');

    //아이디 정규식
    var idck = /^[a-z0-9]{4,12}$/;
    // 비밀번호 정규식
    var pwck = /^[A-Za-z0-9]{4,12}$/;
    // 이름 정규식
    var nameck = /^[가-힣]{2,6}$/;
    // 이메일 검사 정규식
    var mailck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    // 휴대폰 번호 정규식
    var phoneck = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;


    $('#join_form').submit(function () {

        if ($(id).val().trim().length < 1) {
            $('#id+div.msg').html('필수항목입니다.');
            $('#id+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#id').css('border', '1px solid red');
            return false;
        } else if (!(idck.test($(id).val()))) {
            $('#id+div.msg').html('4~12자 입력하세요.');
            $('#id+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#id').css('border', '1px solid red');
            return false;
        } else {
            $('#id+div.msg').html('멋진아이디네요');
            $('#id+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#id').css('border', '1px solid green');
        }

        if ($(pw).val().trim().length < 1) {
            $('#pw+div.msg').html('필수항목입니다.');
            $('#pw+div.msg').css('display', 'block');
            $('#pw').css('border', '1px solid red');
            return false;
        } else if(!(pwck.test($(pw).val()))){
            $('#pw+div.msg').html('4~12자 입력하세요.');
            $('#pw+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#pw').css('border', '1px solid red');
            return false; 
        } else {
            $('#pw+div.msg').html('');
            $('#pw+div.msg').css('display', 'block');
            $('#pw').css('border', '1px solid green');
        }

        if ($(pw2).val().trim().length < 1) {
            $('#pw2+div.msg').html('필수항목입니다.');
            $('#pw2+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#pw2').css('border', '1px solid red');
            return false;
        } else {
            $('#pw2+div.msg').html('');
            $('#pw2+div.msg').css('display', 'block');
            $('#pw2').css('border', '1px solid green');
        }

        if ($(pw).val().trim() != $(pw2).val().trim()) {
            $('#pw2+div.msg').html('비밀번호 확인!');
            $('#pw2+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#pw2').css('border', '1px solid red');
            return false;
        }

        if ($(name).val().trim().length < 1) {
            $('#name+div.msg').html('필수항목입니다.');
            $('#name+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#name').css('border', '1px solid red');
            return false;
        } else if(!(nameck.test($(name).val()))){
            $('#name+div.msg').html('잘못입력하셨습니다.');
            $('#name+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#name').css('border', '1px solid red');
            return false;
        } else {
            $('#name+div.msg').html('');
            $('#name+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#name').css('border', '1px solid green');
        }

        if ($(email).val().trim().length < 1) {
            $('#email+div.msg').html('필수항목입니다.');
            $('#email+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#email').css('border', '1px solid red');
            return false;
        } else if(!(mailck.test($(email).val()))){
            $('#email+div.msg').html('잘못입력하셨습니다.');
            $('#email+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#email').css('border', '1px solid red');
            return false;
        } else {
            $('#email+div.msg').html('');
            $('#email+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#email').css('border', '1px solid green');
        }

        if ($(phone).val().trim().length < 1) {
            $('#phone+div.msg').html('필수항목입니다.');
            $('#phone+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#phone').css('border', '1px solid red');
            return false;
        } else if(!(phoneck.test($(phone).val()))){
            $('#phone+div.msg').html('잘못입력하셨습니다.');
            $('#phone+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#phone').css('border', '1px solid red');
            return false;
        } else {
            $('#phone+div.msg').html('');
            $('#phone+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#phone').css('border', '1px solid green');
        }

        alert('등록되었습니다.');

    });

    $(id).focus(function () {
        $('#id+div.msg').css('display', 'none');
        $('#id+div.msg').html('');
        id.val('');
    });

    $(pw).focus(function () {
        $('#pw+div.msg').css('display', 'none');
        $('#pw+div.msg').html('');
        pw.val('');
    });

    $(pw2).focus(function () {
        $('#pw2+div.msg').css('display', 'none');
        $('#pw2+div.msg').html('');
        pw2.val('');
    });

    $(name).focus(function () {
        $('#name+div.msg').css('display', 'none');
        $('#name+div.msg').html('');
        name.val('');
    });

    $(email).focus(function () {
        $('#email+div.msg').css('display', 'none');
        $('#email+div.msg').html('');
        email.val('');
    });

    $(phone).focus(function () {
        $('#phone+div.msg').css('display', 'none');
        $('#iphoned+div.msg').html('');
        phone.val('');
    });
});
