function Member(id, pw, name){
    this.id = id;
    this.pw = pw;
    this.name = name;
}

Member.prototype.makeHtml = function(){
    return '[id: ' + this.id + ', pw: ' + this.pw + ', name: ' + this.name + ']'
}

var members = [];

window.onload = function(){
    var id = document.querySelector('#ID');
    var pw = document.querySelector('#PW');
    var pw2 = document.querySelector('#PW2');
    var name = document.querySelector('#NAME');

    var form = document.getElementById('join_form');

    form.onsubmit = function() {
        if(id.value.tirm().length < 1){
            alert('이름 입력해')
            return false;
        }
        if(pw.value.tirm().length < 1){
            alert('이름 입력해')
            return false;
        }
        if(pw2.value.tirm().length < 1){
            alert('이름 입력해')
            return false;
        }
        if(name.value.tirm().length < 1){
            alert('이름 입력해')
            return false;
        }
    }
    
    
    console.log(id.value);
    console.log(pw.value);
    console.log(pw2.value);
    console.log(name.value);



}