function checkSpacebar(){
		var nospace = event.keyCode;
		if(nospace ==32) event.returnValue = false;
};
	
function writeSave(){
		var idchk = $("#cnt").val();
		if(idchk == "" || idchk>0){
			alert("ID중복확인을 해주세요");
			return false;
		}
};

function duplicateM(){
	var noempty = $("#mid").val();
	if(noempty == ""){
		alert("ID를 입력해주세요");
		return false;
	}
	$("#myform").attr("action","Midcheck.mem");
};

function duplicateS(){
	var noempty = $("#mid").val();
	if(noempty == ""){
		alert("ID를 입력해주세요");
		return false;
	}
	$("#myform").attr("action","Sidcheck.mem");
};

function serve(){
	var answer = prompt("관리자key를 입력하세요(문의는 인사과로 해주세요)","");
	if(answer == "1234"){
		location.href="register_S.mem";
	}else{
		alert("올바르지 않은 key입니다");
		location.href="#";
	}
};

function customer(){
	location.href="register_M.mem";
};