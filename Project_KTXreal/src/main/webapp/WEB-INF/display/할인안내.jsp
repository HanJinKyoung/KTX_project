<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp" %>
<style>
.lost {
    padding: 10;
    text-align: left;
    /* display: table-cell; */
} 
h4.l_tit{
    padding-left: 18px;
    margin: 30px 0 15px 0;
    font-family: "나눔고딕", "NG", "돋움", "dotum";
    font-size: 18px;
    letter-spacing: -2px;
    color: #000;
    background: url(resources/imgs/bu_c_tit.gif) no-repeat left 4px;
}
.l_tit ul{padding-center:21px}

.lost ul li{
	background:url(resources/imgs/bu1.gif) no-repeat left 8px; 
	font-family: "나눔고딕", "NG", "돋움", "dotum";
	font-size: 12px;
	line-height:21px; 
	padding-left:8px;
}
h3 {
    font-size: 1.5em;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
}
.l_tit li{
text-align: center;
color:blue;
font-size: 8px;
}
h1 {
text-align: center;
font-family: "나눔고딕", "NG", "돋움", "dotum";
}
table {
width : 100%;
border: 1px solid #444444;
border-collapse: collapse;
text-align: center;
}
}

body {
	text-align: center;
}

</style>


	
	
<h1><b>할인 안내</b></h1><br>
<hr></hr>
<center>
<br>
<div class="lost">
	<h4 class="l_tit">인터넷 특가</h4><br>
	<ul>
	<li><font color="red"><b>(할인대상)</b></font>모든 KTX이용객</li>
	<li><font color="red"><b>(할인율)</b></font>KTX열차별 승차율에 따라<font color="red"><b>10~30%까지 할인</b></font></li>
	<li>최저운임 이하로 할인하지 않음</li>
	<li>특별 요금은 할인하지 않음</li><br>
	<li><font color="red"><b>이용방법</b></font></li>
	<li>출발 2일전까지<font color="red"><b>레츠코레일,코레일톡</b></font>으로 할인대상 열차 구매시 할인 가능</li>
	<li>할인이 적용된 승차권을 역 창구(고객센터)에서 변경시 할인 취소</li>
	</ul>
</div>



<div class="lost">
	<h4 class="l_tit">정기 승차권</h4>
	<ul>
		<li><font color="red"><b>(상품 정의)</b></font>지정한 승차구간을 유효기간 동안 1일 2회(왕복)이용 가능하며 45%~60%까지 운임을 할인하여 드립니다.</li>
	<li><font color="red"><b>(상품종류 할인율)</b></font></li>
	<img src="./resources/imgs/정기승차권할인율.png" width="700" height="300"/><br>
	</ul>
</div>

<div class="lost">
	<h4 class="l_tit">공공 할인</h4>
	<ul>
		<li><b>장애인(장애의 정도가 심한 장애인은 보호자 1명 포함)</b></li><br>
		<img src="./resources/imgs/장애인할인제도.png" width="700" height="130"/><br><br>
		<li><b>유공자(독립유공자와 상이등급 1~2등급은 동반 보호자 1명 포함):6회까지 무임으로 이용할 수 있으며,6회 초과시부터는 50%를 할인</b></li><br>
		<li><b>경로</b></li><br>
		<img src="./resources/imgs/노인할인제도.png" width="700" height="90"/><br>
	</ul>
</div>
</center>
<br><br>
<%@ include file="../../bottom.jsp" %> 
