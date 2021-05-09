/**
 * 
 */
	
function nochk(){
	var s_code = document.getElementsByName("s_code");
	flag=false;
	for(i=0;i<s_code.length;i++){
		if(myform.s_code[i].checked){
			flag=true;
		}
	}if(flag==false){
		alert("선택된 좌석이 없습니다")
		return false;
	}
};