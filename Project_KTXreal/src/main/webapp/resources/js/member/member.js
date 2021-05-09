function login(){
	location.href="login.mem";
};

function back(){
	location.href="main.jsp";
};

function find(){
	location.href="find.mem";
};

function register(){
	location.href="register.mem";
};

function del(m_num){
	var answer = confirm("정말로 회원 탈퇴 하시겠습니까?")
	if(answer){
		location.href="mydelete.mem?m_num="+m_num;
		alert('성공적으로 탈퇴 되었습니다.');
	}else{
		alert('탈퇴를 취소하셨습니다.');
		return false;
		}
};