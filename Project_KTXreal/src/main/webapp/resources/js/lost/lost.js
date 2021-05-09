function writeSave(){
		
		var lname = $('#lname').val();
		var lcontent = $('#lcontent').val();
		var lstate = $('#lstate').val();
		var limage = $('#l_image').val();
		
		if(lname == ""){
			alert('품목명을 입력해 주세요');
			return false;
		}
		
		if(lcontent == ""){
			alert('습득장소를 입력해 주세요');
			return false;
		}
		
		if(limage == ""){
			alert('이미지를 등록하세요');
			return false;
		}
		
		if(lstate == ""){
			alert('처리상태를 입력해 주세요');
			return false;
		}
	};