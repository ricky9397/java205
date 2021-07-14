$(document).ready(function(){
    $('#allCheck').change(function(){
        
        if(this.checked){
            $('.checkItem').prop('checked', true);
        } else {
            $('.checkItem').prop('checked', false);
        }
    });
});