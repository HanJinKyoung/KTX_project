/**
 * 
 */
function tcheck(){
		var ttnum = $('#ttnum').val();
		var select_way1 = $('input[name="t_way1"]').val();
		if(ttnum == ""){
			alert("열차번호를 입력하세요");
			return false;
		}
		if (select_way1 == "") {
			alert("열차노선을 입력하세요");
			return false;
		}
		 
		
		if($("input[name=t_way2]:radio:checked").length <1){
			alert("열차방향을 선택해주세요");
			return false;
			} 
	};
	
	function rcheck(){
		
		var rtnum = $('#rtnum').val();
		var start = $('select[name="r_start"] option:selected').val();
		var end = $('select[name="r_end"] option:selected').val();
		var r_starth = $('select[name="r_starth"] option:selected').val();
		var r_endh = $('select[name="r_endh"] option:selected').val();
		var r_startm = $('select[name="r_startm"] option:selected').val();
		var r_endm = $('select[name="r_endm"] option:selected').val();
		
		if(rtnum == ""){
			alert('열차번호를 입력하세요');
			return false;
		}
		if (start == end) {
			alert('출발역과 도착역이 동일합니다');
			return false;
		}
		if ((r_starth == r_endh) && (r_startm == r_endm)) {
			alert('출발시간과 도착시간이 동일합니다');
			return false;
		}
		var select_type = $('input[name="t_type"]').val();
		if (select_type == "") {
			alert("열차번호를 입력하세요");
			return false;
		}
	};