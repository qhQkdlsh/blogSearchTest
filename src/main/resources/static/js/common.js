$(function(){
    var scriptTag2 = /[~^&()|<>?]/;

    $("#blogForm").submit(function(event){
        var keyVal = $("#keyword").val();
        var checkText = "";
        if(keyVal.replace(/(\s*)/g,'').length == 0){
            checkText = "검색어를 입력해주세요.";
        }else if(scriptTag2.test(keyVal) == true){
            checkText = "스크립트 태그는 들어갈 수 없습니다.";
        }else if (keyVal.length > 100){
            checkText = "100글자 이내로 입력해주세요.";
        }
        if(checkText != ""){
            alert(checkText);
            return false;
        }
    });
});