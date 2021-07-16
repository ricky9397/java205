$(document).ready(function () {
    $('#login_form').submit(function () {
        if ($('#userId').val().trim().length < 1) {
            $('#userId+div.msg').html('아이디를 입력하세요.');
            $('#userId+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userId').css('border', '1px solid red');
            return false;
        } else {
            $('#userId+div.msg').html('');
            $('#userId+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userId').css('border', '1px solid green');
        }

        if ($('#userPw').val().trim().length < 1) {
            $('#userPw+div.msg').html('비밀번호를 입력하세요.');
            $('#userPw+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userPw').css('border', '1px solid red');
            return false;
        } else {
            $('#userPw+div.msg').html('');
            $('#userPw+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userPw').css('border', '1px solid green');
        }
        
    });

    $('#userId').focus(function () {
        $('#userId+div.msg').css('display', 'none');
        $('#userId+div.msg').html('');
        $('#userId').val('');
    });

    $('#userPw').focus(function () {
        $('#userPw+div.msg').css('display', 'none');
        $('#userPw+div.msg').html('');
        $('#userPw').val('');
    });
});