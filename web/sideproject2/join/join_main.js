$(document).ready(function () {

    var id = $('#userId');
    var pw = $('#userPw');
    var pw2 = $('#userPw2');
    var name = $('#userName');
    var address = $('.userAdd');
    var phone = $('.userPhone');
    var email = $('#userEmail');

    //아이디 정규식
    var idck = /^[a-z0-9]{4,16}$/;
    // 비밀번호 정규식
    var pwck = /^[A-Za-z0-9]{4,16}$/;
    // 이름 정규식
    var nameck = /^[가-힣]{2,6}$/;
    // 이메일 검사 정규식
    var mailck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    // 휴대폰 번호 정규식
    var phoneck = /^([0-9]{3,4})?([0-9]{4})$/;

    $(id).on('mouseover', function(){
        if ($(id).val().trim().length < 1) {
            $('#userId+div.msg').html('필수항목입니다.');
            $('#userId+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userId').css('border', '1px solid red');
            return false;
        } else if (!(idck.test($(id).val()))) {
            $('#userId+div.msg').html('4~16자 입력하세요.');
            $('#userId+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userId').css('border', '1px solid red');
            return false;
        } else {
            $('#userId+div.msg').html('멋진아이디네요');
            $('#userId+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userId').css('border', '1px solid green');
        }
    }).on('mouseout', function(){
        if ($(id).val().trim().length < 1) {
            $('#userId+div.msg').html('필수항목입니다.');
            $('#userId+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userId').css('border', '1px solid red');
            return false;
        } else if (!(idck.test($(id).val()))) {
            $('#userId+div.msg').html('4~16자 입력하세요.');
            $('#userId+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userId').css('border', '1px solid red');
            return false;
        } else {
            $('#userId+div.msg').html('멋진아이디네요');
            $('#userId+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userId').css('border', '1px solid green');
        }
    });

    $(pw).on('mouseover', function(){
        if ($(pw).val().trim().length < 1) {
            $('#userPw+div.msg').html('필수항목입니다.');
            $('#userPw+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userPw').css('border', '1px solid red');
            return false;
        } else if (!(pwck.test($(pw).val()))) {
            $('#userPw+div.msg').html('4~12자 입력하세요.');
            $('#userPw+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userPw').css('border', '1px solid red');
            return false;
        } else {
            $('#userPw+div.msg').html('');
            $('#userPw+div.msg').css('display', 'block');
            $('#userPw').css('border', '1px solid green');
        }
    }).on('mouseout', function(){
        if ($(pw).val().trim().length < 1) {
            $('#userPw+div.msg').html('필수항목입니다.');
            $('#userPw+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userPw').css('border', '1px solid red');
            return false;
        } else if (!(pwck.test($(pw).val()))) {
            $('#userPw+div.msg').html('4~12자 입력하세요.');
            $('#userPw+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userPw').css('border', '1px solid red');
            return false;
        } else {
            $('#userPw+div.msg').html('');
            $('#userPw+div.msg').css('display', 'block');
            $('#userPw').css('border', '1px solid green');
        }
    });

    $(pw2).on('mouseover', function(){
        if ($(pw2).val().trim().length < 1) {
            $('#userPw2+div.msg').html('필수항목입니다.');
            $('#userPw2+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userPw2').css('border', '1px solid red');
            return false;
        } else {
            $('#userPw2+div.msg').html('');
            $('#userPw2+div.msg').css('display', 'block');
            $('#userPw2').css('border', '1px solid green');
        }
    }).on('mouseout', function(){
        if ($(pw2).val().trim().length < 1) {
            $('#userPw2+div.msg').html('필수항목입니다.');
            $('#userPw2+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userPw2').css('border', '1px solid red');
            return false;
        } else {
            $('#userPw2+div.msg').html('');
            $('#userPw2+div.msg').css('display', 'block');
            $('#userPw2').css('border', '1px solid green');
        }
    });

    $(name).on('mouseover', function(){
        if ($(name).val().trim().length < 1) {
            $('#userName+div.msg').html('필수항목입니다.');
            $('#userName+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userName').css('border', '1px solid red');
            return false;
        } else if (!(nameck.test($(name).val()))) {
            $('#userName+div.msg').html('잘못입력하셨습니다.');
            $('#userName+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userName').css('border', '1px solid red');
            return false;
        } else {
            $('#userName+div.msg').html('');
            $('#userName+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userName').css('border', '1px solid green');
        }
    }).on('mouseout', function(){
        if ($(name).val().trim().length < 1) {
            $('#userName+div.msg').html('필수항목입니다.');
            $('#userName+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userName').css('border', '1px solid red');
            return false;
        } else if (!(nameck.test($(name).val()))) {
            $('#userName+div.msg').html('잘못입력하셨습니다.');
            $('#userName+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userName').css('border', '1px solid red');
            return false;
        } else {
            $('#userName+div.msg').html('');
            $('#userName+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userName').css('border', '1px solid green');
        }
    });

    $(phone).on('mouseover', function(){
        if ($(phone).val().trim().length < 1) {
            $('.userPhone+div.msg').html('필수항목입니다.');
            $('.userPhone+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('.userPhone').css('border', '1px solid red');
            return false;
        } else if (!(phoneck.test($(phone).val()))) {
            $('.userPhone+div.msg').html('잘못입력하셨습니다.');
            $('.userPhone+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('.userPhone').css('border', '1px solid red');
            return false;
        } else {
            $('.userPhone+div.msg').html('');
            $('.userPhone+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('.userPhone').css('border', '1px solid green');
        }
    }).on('mouseout', function(){
        if ($(phone).val().trim().length < 1) {
            $('.userPhone+div.msg').html('필수항목입니다.');
            $('.userPhone+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('.userPhone').css('border', '1px solid red');
            return false;
        } else if (!(phoneck.test($(phone).val()))) {
            $('.userPhone+div.msg').html('잘못입력하셨습니다.');
            $('.userPhone+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('.userPhone').css('border', '1px solid red');
            return false;
        } else {
            $('.userPhone+div.msg').html('');
            $('.userPhone+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('.userPhone').css('border', '1px solid green');
        }
    });

    $(email).on('mouseover', function(){
        if ($(email).val().trim().length < 1) {
            $('#userEmail+div.msg').html('필수항목입니다.');
            $('#userEmail+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userEmail').css('border', '1px solid red');
            return false;
        } else if (!(mailck.test($(email).val()))) {
            $('#userEmail+div.msg').html('잘못입력하셨습니다.');
            $('#userEmail+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userEmail').css('border', '1px solid red');
            return false;
        } else {
            $('#userEmail+div.msg').html('');
            $('#userEmail+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userEmail').css('border', '1px solid green');
        }
    }).on('mouseout', function(){
        if ($(email).val().trim().length < 1) {
            $('#userEmail+div.msg').html('필수항목입니다.');
            $('#userEmail+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userEmail').css('border', '1px solid red');
            return false;
        } else if (!(mailck.test($(email).val()))) {
            $('#userEmail+div.msg').html('잘못입력하셨습니다.');
            $('#userEmail+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userEmail').css('border', '1px solid red');
            return false;
        } else {
            $('#userEmail+div.msg').html('');
            $('#userEmail+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userEmail').css('border', '1px solid green');
        }
    });



    $('#join_form').submit(function () {
        if ($(id).val().trim().length < 1) {
            $('#userId+div.msg').html('필수항목입니다.');
            $('#userId+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userId').css('border', '1px solid red');
            return false;
        } else if (!(idck.test($(id).val()))) {
            $('#userId+div.msg').html('4~16자 입력하세요.');
            $('#userId+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userId').css('border', '1px solid red');
            return false;
        } else {
            $('#userId+div.msg').html('멋진아이디네요');
            $('#userId+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userId').css('border', '1px solid green');
        }

        if ($(pw).val().trim().length < 1) {
            $('#userPw+div.msg').html('필수항목입니다.');
            $('#userPw+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userPw').css('border', '1px solid red');
            return false;
        } else if (!(pwck.test($(pw).val()))) {
            $('#userPw+div.msg').html('4~12자 입력하세요.');
            $('#userPw+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userPw').css('border', '1px solid red');
            return false;
        } else {
            $('#userPw+div.msg').html('');
            $('#userPw+div.msg').css('display', 'block');
            $('#userPw').css('border', '1px solid green');
        }

        if ($(pw2).val().trim().length < 1) {
            $('#userPw2+div.msg').html('필수항목입니다.');
            $('#userPw2+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userPw2').css('border', '1px solid red');
            return false;
        } else {
            $('#userPw2+div.msg').html('');
            $('#userPw2+div.msg').css('display', 'block');
            $('#userPw2').css('border', '1px solid green');
        }

        if ($(pw).val().trim() != $(pw2).val().trim()) {
            $('#userPw2+div.msg').html('비밀번호 확인!');
            $('#userPw2+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userPw2').css('border', '1px solid red');
            return false;
        }

        if ($(name).val().trim().length < 1) {
            $('#userName+div.msg').html('필수항목입니다.');
            $('#userName+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#nauserNameme').css('border', '1px solid red');
            return false;
        } else if (!(nameck.test($(name).val()))) {
            $('#userName+div.msg').html('잘못입력하셨습니다.');
            $('#userName+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#userName').css('border', '1px solid red');
            return false;
        } else {
            $('#userName+div.msg').html('');
            $('#userName+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#userName').css('border', '1px solid green');
        }

        if ($(address).val().trim().length < 1) {
            $('.userAdd+div.msg').html('필수항목입니다.');
            $('.userAdd+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('.userAdd').css('border', '1px solid red');
            return false;
        } else if (!(phoneck.test($(phone).val()))) {
            $('.userAdd+div.msg').html('잘못입력하셨습니다.');
            $('.userAdd+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('.userAdd').css('border', '1px solid red');
            return false;
        } else {
            $('.userAdd+div.msg').html('');
            $('.userAdd+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('.userAdd').css('border', '1px solid green');
        }

        if ($(phone).val().trim().length < 1) {
            $('.userPhone+div.msg').html('필수항목입니다.');
            $('.userPhone+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('.userPhone').css('border', '1px solid red');
            return false;
        } else if (!(phoneck.test($(phone).val()))) {
            $('.userPhone+div.msg').html('잘못입력하셨습니다.');
            $('.userPhone+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('.userPhone').css('border', '1px solid red');
            return false;
        } else {
            $('.userPhone+div.msg').html('');
            $('.userPhone+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('.userPhone').css('border', '1px solid green');
        }

        if ($(email).val().trim().length < 1) {
            $('#email+div.msg').html('필수항목입니다.');
            $('#email+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#email').css('border', '1px solid red');
            return false;
        } else if (!(mailck.test($(email).val()))) {
            $('#email+div.msg').html('잘못입력하셨습니다.');
            $('#email+div.msg').css({ 'display': 'block', 'color': 'red' });
            $('#email').css('border', '1px solid red');
            return false;
        } else {
            $('#email+div.msg').html('');
            $('#email+div.msg').css({ 'display': 'block', 'color': 'green' });
            $('#email').css('border', '1px solid green');
        }

        alert('환영합니다! 가입되었습니다.');

    });

    $(id).focus(function () {
        $('#userId+div.msg').css('display', 'none');
        $('#userId+div.msg').html('');
        id.val('');
    });

    $(pw).focus(function () {
        $('#userPw+div.msg').css('display', 'none');
        $('#userPw+div.msg').html('');
        pw.val('');
    });

    $(pw2).focus(function () {
        $('#userPw2+div.msg').css('display', 'none');
        $('#userPw2+div.msg').html('');
        pw2.val('');
    });

    $(name).focus(function () {
        $('#userName+div.msg').css('display', 'none');
        $('#userName+div.msg').html('');
        name.val('');
    });

    $(address).focus(function () {
        $('.userAdd+div.msg').css('display', 'none');
        $('.userAdd+div.msg').html('');
        email.val('');
    });

    $(phone).focus(function () {
        $('.userPhone+div.msg').css('display', 'none');
        $('.userPhone+div.msg').html('');
    });

    $(email).focus(function () {
        $('#userEmail+div.msg').css('display', 'none');
        $('#userEmail+div.msg').html('');
        email.val('');
    });

    $('#btnAdd').on('click',function(){
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분. 
                // 각 주소의 노출 규칙에 따라 주소를 조합한다. 
                // 내려오는 변수가 값이 없는 경우엔 공백(”)값을 가지므로, 이를 참고하여 분기 한다. 
                var fullAddr = ''; // 최종 주소 변수 
                var extraAddr = ''; // 조합형 주소 변수 
                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다. 
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우 
                    fullAddr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J) 
                    fullAddr = data.jibunAddress;
                }
                // 사용자가 선택한 주소가 도로명 타입일때 조합한다. 
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다. 
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다. 
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다. 
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다. 
                document.getElementById('zip').value = data.zonecode; //5자리 새우편번호 사용 
                document.getElementById('addr1').value = fullAddr; // 커서를 상세주소 필드로 이동한다. 
                document.getElementById('addr2').focus();
            }
        }).open();
    });

    $("#userId").blur(function(){
        var userId = $('#userId').val();
        $.ajax({
            type : "post",
            url : join
            
        });
    });

});