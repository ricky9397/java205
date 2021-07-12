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

    window.onload = function () {

        if (localStorage.getItem('members') == null) {
            localStorage.setItem('members', JSON.stringify(members));
        } else {
            members = JSON.parse(localStorage.getItem('members')); // JSON 문자열 -> 객체로 변환
            console.log(members);
            setList();
        }
        var userID = document.querySelector('#userID');
        var pw = document.querySelector('#pw');
        var repw = document.querySelector('#repw');
        var userName = document.querySelector('#userName');

        var regForm = document.getElementById('regForm');

        regForm.onsubmit = function () {

            if (userID.value.trim().length < 1) {
                $('#userID+div.msg').html('필수항목입니다.');
                $('#userID+div.msg').css('display', 'block');
                return false;
            }

            if (pw.value.trim().length < 1) {
                $('#pw+div.msg').html('필수항목입니다.');
                $('#pw+div.msg').css('display', 'block');
                return false;
            }

            if (repw.value.trim().length < 1) {
                $('#repw+div.msg').html('필수항목입니다.');
                $('#repw+div.msg').css('display', 'block');
                return false;
            }

            // 비밀번호 비밀번호 확인 일치 여부 체크
            if (pw.value.trim() != repw.value.trim()) {
                $('#repw+div.msg').html('비밀번호가 일치하지않습니다.');
                $('#repw+div.msg').css('display', 'block');
                return false;
            }

            // 사용자 이름 정보 
            if (userName.value.trim() < 1) {
                $('#userName+div.msg').html('필수항목입니다.');
                $('#userName+div.msg').css('display', 'block');
                return false;
            }

            console.log(userID.value);
            console.log(pw.value);
            console.log(repw.value);
            console.log(userName.value);


            members.push(new Member(userID.value, pw.value, userName.value));

            localStorage.setItem('members', JSON.stringify(members));

            alert('등록되었습니다.');
            console.log('회원 리스트', members);

            this.reset();

            setList();

            return false;
        }

        $('#userID').on('focus', function () {
            $('#userID+div.msg').css('display', 'none');
            $('#userID+div.msg').html('');
            userID.value = '';
        });

        $('#pw').on('focus', function () {
            $('#pw+div.msg').css('display', 'none');
            $('#pw+div.msg').html('');
            pw.value = '';
        });

        $('#repw').on('focus', function () {
            $('#repw+div.msg').css('display', 'none');
            $('#repw+div.msg').html('');
            repw.value = '';
        });

        $('#userName').on('focus', function () {
            $('#userName+div.msg').css('display', 'none');
            $('#userName+div.msg').html('');
            userName.value = '';
        });

    }
});

function setList() {

    console.log(members);


    var list = document.querySelector('#list');

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
            tbody += '  <td>' + item.username + '</td>';
            tbody += '  <td> <a href="javascript:editMember(' + index + ')">수정</a> | <a href="javascript:deleteMember(' + index + ')">삭제</a></td>';
            tbody += '</tr>';
        });

    }


    list.innerHTML = tbody;



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

    var editUserId = document.querySelector('#editId');
    var editPw = document.querySelector('#editPw');
    var editRePw = document.querySelector('#editRePw');
    var editName = document.querySelector('#editName');
    var editIndex = document.querySelector('#index');

    editUserId.value = members[index].userID;
    editPw.value = members[index].pw;
    editRePw.value = members[index].pw;
    editName.value = members[index].userName;
    editIndex.value = index;

    $('#editForm').on('submit', function () {
        if (editPw.value != editRePw.value) {
            alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
            return false;
        }

        if (!confirm('수정하시겠습니까?')) {
            return false;
        }

        members[editIndex.value].pw = editPw.value;
        members[editIndex.value].userName = editName.value;

        localStorage.setItem('members', JSON.stringify(members));

        alert('수정되었습니다.');

        setList();

        $('#editFormArea').css('display', 'none');

        return false;
    });
}

