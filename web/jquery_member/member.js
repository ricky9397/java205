function Member(id, pw, name) {
    this.userID = id;
    this.pw = pw;
    this.userName = name;
}
Member.prototype.makeHtml = function () {
    return '[id:' + this.userID + ' , pw: ' + this.pw + ' , name: ' + this.userName + ' ]'
};

var members = []; // new Array()

$(document).ready(function () {

        if (localStorage.getItem('members') == null) {
            localStorage.setItem('members', JSON.stringify(members));
        } else {
            members = JSON.parse(localStorage.getItem('members')); // JSON 문자열 -> 객체로 변환
            console.log(members);
            setList();
        }


        var userID = $('#userID');
        var pw = $('#pw');
        var repw = $('#repw');
        var userName = $('#userName');

        $('#regForm').submit(function(){
            if ($(userID).val().trim().length < 1) {
                $('#userID+div.msg').html('필수항목입니다.');
                $('#userID+div.msg').css('display', 'block');
                return false;
            }

            if ($(pw).val().trim().length < 1) {
                $('#pw+div.msg').html('필수항목입니다.');
                $('#pw+div.msg').css('display', 'block');
                return false;
            }

            if ($(repw).val().trim().length < 1) {
                $('#repw+div.msg').html('필수항목입니다.');
                $('#repw+div.msg').css('display', 'block');
                return false;
            }

            // 비밀번호 비밀번호 확인 일치 여부 체크
            if ($(pw).val().trim() != repw.val().trim()) {
                $('#repw+div.msg').html('비밀번호가 일치하지않습니다.');
                $('#repw+div.msg').css('display', 'block');
                return false;
            }

            // 사용자 이름 정보 
            if ($(userName).val().trim() < 1) {
                $('#userName+div.msg').html('필수항목입니다.');
                $('#userName+div.msg').css('display', 'block');
                return false;
            }
            
            members.push(new Member(userID.val(), pw.val(), userName.val()));

            localStorage.setItem('members', JSON.stringify(members));
    
            alert('등록되었습니다.');
            console.log('회원 리스트', members);
    
            this.reset();
    
            setList();
    
            return false;
            
        });
        
        $(userID).focus(function () {
            $('#userID+div.msg').css('display', 'none');
            $('#userID+div.msg').html('');
            userID.val('');
        });

        $(pw).focus(function () {
            $('#pw+div.msg').css('display', 'none');
            $('#pw+div.msg').html('');
            pw.val('');
        });

        $(repw).focus(function () {
            $('#repw+div.msg').css('display', 'none');
            $('#repw+div.msg').html('');
            repw.val('');
        });

        $(userName).focus('focus', function () {
            $('#userName+div.msg').css('display', 'none');
            $('#userName+div.msg').html('');
            userName.val('');
        });
});

function setList() {

    var list = $('#list');

    var tbody = '<tr>';
    tbody += '  <th>순번(index)</th>';
    tbody += '  <th>아이디</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
    tbody += '</tr>';

    if (members.length < 1) {

        tbody += '<tr>';
        tbody += '<td colspan="5">데이터가 존재하지않습니다.</td>';
        tbody += '</tr>';


    } else {

        var tbody = '';
        $.each(members, function (index, item) {
            console.log(index, item.userID);
            tbody += '<tr>';
            tbody += '  <td>' + index + '</td>';
            tbody += '  <td>' + item.userID + '</td>';
            tbody += '  <td>' + item.pw + '</td>';
            tbody += '  <td>' + item.userName + '</td>';
            tbody += '  <td> <a href="javascript:editMember(' + index + ')">수정</a> | <a href="javascript:deleteMember(' + index + ')">삭제</a></td>';
            tbody += '</tr>';
        });

    }

    $(list).html(tbody);
}

function deleteMember(index) {
    if (confirm('삭제하시겠습니까?')) {
        members.splice(index, 1);
        alert('삭제되었습니다.');

        localStorage.setItem('members', JSON.stringify(members));

        setList();
    }

}

function editMember(index) {

    $('#editFormArea').css('display', 'block');

    console.log(index, members[index]);

    var editUserId = $('#editId');
    var editPw = $('#editPw');
    var editRePw = $('#editRePw');
    var editName = $('#editName');
    var editIndex = $('#index');

    editUserId.val(members[index].userID);
    editPw.val(members[index].pw);
    editRePw.val(members[index].pw);
    editName.val(members[index].userName);
    editIndex.val(index);

    $('#editForm').on('submit', function () {
        if (editPw.val() != editRePw.val()) {
            alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
            return false;
        }

        if (!confirm('수정하시겠습니까?')) {
            return false;
        }

        members[editIndex.val()].pw = editPw.val();
        members[editIndex.val()].userName = editName.val();

        localStorage.setItem('members', JSON.stringify(members));

        alert('수정되었습니다.');

        setList();

        $('#editFormArea').css('display', 'none');

        return false;
    });
}

