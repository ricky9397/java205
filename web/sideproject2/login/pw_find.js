$(document).ready(function(){

    $('#pwFind').submit(function () {
        if ($('#userid').val().trim().length < 1) {
            $('#userid+div.msg').html('아이디를 입력하세요.');
            $('#userid+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userid').css('border', '1px solid red');
            return false;
        } else {
            $('#userid+div.msg').html('');
            $('#userid+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userid').css('border', '1px solid green');
        }

        if ($('#userName').val().trim().length < 1) {
            $('#userName+div.msg').html('이름을 입력하세요.');
            $('#userName+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userName').css('border', '1px solid red');
            return false;
        } else {
            $('#userName+div.msg').html('');
            $('#userName+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userName').css('border', '1px solid green');
        }
    
        if ($('#userEmail').val().trim().length < 1) {
            $('#userEmail+div.msg').html('이메일을 입력하세요.');
            $('#userEmail+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userEmail').css('border', '1px solid red');
            return false;
        } else {
            $('#userEmail+div.msg').html('');
            $('#userEmail+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userEmail').css('border', '1px solid green');
        }
    
        alert('이메일 전송 하였습니다.')
    });
    
    $('#userid').focus(function () {
        $('#userid+div.msg').css('display', 'none');
        $('#userid+div.msg').html('');
        $('#userid').val('');
    });

    $('#userName').focus(function () {
        $('#userName+div.msg').css('display', 'none');
        $('#userName+div.msg').html('');
        $('#userName').val('');
    });
    
    $('#userEmail').focus(function () {
        $('#userEmail+div.msg').css('display', 'none');
        $('#userEmail+div.msg').html('');
        $('#userEmail').val('');
    });

});