/**
 * 
 */

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
};
