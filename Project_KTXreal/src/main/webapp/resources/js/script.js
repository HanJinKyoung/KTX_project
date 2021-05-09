function choice(){
	var start = $('select[name="r_start"] option:selected').val();
	var end = $('select[name="r_end"] option:selected').val();
	if(end==""){
		alert('도착역을 선택하세요');
		return false;
	}
	if(start == end){
		alert('출발일과 도착역이 동일합니다');
		return false;
	}
	var selectday = $('input[name="tk_date"]').val();
	if(selectday == ""){
		alert("출발날짜를 선택하세요");
		return false;
	}
}
function writeSave(){
	
	var iwriter = $('#iwriter').val();
	var isubject = $('#isubject').val();
	var icontent = $('#icontent').val();
	var ipasswd = $('#ipasswd').val();
	
	if(iwriter == ""){
		alert('작성자를 입력해 주세요');
		return false;
	}
	if(isubject == ""){
		alert('제목을 입력해 주세요');
		return false;
	}
	if(icontent == ""){
		alert('내용을 입력해 주세요');
		return false;
	}
	if(ipasswd == ""){
		alert('비밀번호를 입력해 주세요');
		return false;
	}	
}

