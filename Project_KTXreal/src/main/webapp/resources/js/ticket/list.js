/**
 * 
 */
 function cancel(tk_num){
	var answer = confirm("예매번호["+tk_num+"]를 취소하시겠습니까?")
	if(answer){
		location.href="cancel.tk?tk_num="+tk_num;
	}else{return false;}
};

function chkpay(tk_num,r_price){
	var answer = confirm("예매번호["+tk_num+"]를 결제하시겠습니까?\n결제금액 : "+r_price+"원")
	if(answer){
		location.href="pay.tk?tk_num="+tk_num;
	}else{return false;}
};

function allDelete1(a){
	var chka = document.getElementsByName("rowcheck1");
	var check = a.checked;
	
	if(check){
		for(var i=0; i<chka.length; i++){
			chka[i].checked = true;				
		}
	} else {
		for(var i=0; i<chka.length; i++){
			chka[i].checked = false;
		}
	}
};

function allDelete2(b){
	var chka = document.getElementsByName("rowcheck2");
	var check = b.checked;
	
	if(check){
		for(var i=0; i<chka.length; i++){
			chka[i].checked = true;				
		}
	} else {
		for(var i=0; i<chka.length; i++){
			chka[i].checked = false;
		}
	}
};

function selectPay(){
	var chk = document.getElementsByName("rowcheck1");
	var chkpay = document.getElementsByName("rowprice1");
	var st = "";
	var pay = 0;
	var flag = false;
	for(var i=0; i<chk.length; i++){
		if(chk[i].checked){
			st += chk[i].value+",";
			pay += parseInt(chkpay[i].value);
			flag = true;
		}
	}
	
	if(flag == false){
		alert("선택된 내역이 없습니다.");
		return false;
	}
	st = st.substr(0,st.length-1);
	var answer = confirm("티켓번호["+st+"]\n총금액["+pay+"]원을 결제하시겠습니까?\n")
	if(answer){
		
	}else {
		return false;
	}	
};

function selectDelete(){
	var chk = document.getElementsByName("rowcheck2");
	var chkpay = document.getElementsByName("rowprice2");
	var st = "";
	var pay = 0;
	var flag = false;
	for(var i=0; i<chk.length; i++){
		if(chk[i].checked){
			st += chk[i].value+",";
			pay += parseInt(chkpay[i].value);
			flag = true;
		}
	}	
	if(flag == false){
		alert("선택된 내역이 없습니다.");
		return false;
	}
	st = st.substr(0,st.length-1);
	var answer = confirm("티켓번호["+st+"]\n총금액["+pay+"]원을 취소하시겠습니까?\n")
	if(answer){
		
	}else {
		return false;
	}
};