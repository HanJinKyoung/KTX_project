<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp" %>
<%@ include file="./../common/common.jsp" %>
<script src='<c:url value="/resources/js/ticket/reserve.js"/>'></script>
<script type="text/javascript">
function countCk(obj){
	var s_code = document.getElementsByName("s_code");
	var tk_partner = "${tk_partner}";
	var s_codeCnt = 0;

	for(var i=0;i<s_code.length; i++){
		if(s_code[i].checked){
			s_codeCnt++;
		}
	}
	if(s_codeCnt>tk_partner){
		alert("탑승하시는 인원보다 많은 좌석을 선택했습니다.");
		obj.checked = false;
		return false;
	}
}
</script>
<div class="textcenter" style="width: 800px">
<div class="lookup">
<h2>예매확인 및 좌석선택</h2><br>
<hr color="gray" width="800px"><br>
	<table class="listtable">
		<tr>
			<td>열차번호</td>
			<td>${race.t_num}</td>
		</tr> 	
		<tr>
			<td>열차종류</td>
			<td>KTX</td>
		</tr>	
		<tr>
			<td>출발역</td>
			<td>${race.r_start}</td>
		</tr>	
		<tr>
			<td>도착역</td>
			<td>${race.r_end}</td>
		</tr>	
		<tr>
			<td>출발일</td>
			<td>${tk_date}</td>
		</tr>	
		<tr>
			<td>출발시간</td>
			<td>
			<c:if test="${race.r_starth < 10}">0</c:if>${race.r_starth}  :
			<c:if test="${race.r_startm < 10}">0</c:if>${race.r_startm}
			</td>
		</tr>	
		<tr>
			<td>도착시간</td>
			<td>
			<c:if test="${race.r_endh < 10}">0</c:if>${race.r_endh} :
			<c:if test="${race.r_endm < 10}">0</c:if>${race.r_endm}
			</td>
		</tr>
	</table>
</div>
<div class="sitchoice">
<form name=myform action="reserveform.tk" method="post" onsubmit="return nochk()">
	<input type="hidden" name= "tk_date" value="${tk_date}">
	<input type="hidden" name = "r_num" value = "${race.r_num}">
	<input type="hidden" name = "t_num" value = "${race.t_num}">
	<input type="hidden" name = "r_start" value = "${race.r_start}">
	<input type="hidden" name = "r_end" value = "${race.r_end}">
	<table class="register_SM">
		<tr>
			<td>인원</td>
			<td>
			<input type="hidden" name="tk_partner" value="${tk_partner}">${tk_partner}
			</td>
		</tr>
		<tr>
			<td rowspan="2">좌석선택</td>
			<td rowspan="2" align="left">
			<c:forEach var="i" begin="1" end="10">
				<input type="checkbox" name="s_code" value="A${i}" id="a${i}" onClick="return countCk(s_code)">
				<label for="a${i}">A${i}</label>
				<input type="checkbox" name="s_code" value="B${i}" id="b${i}" onClick="return countCk(s_code)">
				<label for="b${i}">B${i}</label>
				∧&nbsp;&nbsp;
				<input type="checkbox" name="s_code" value="C${i}" id="c${i}" onClick="return countCk(s_code)">
				<label for="c${i}">C${i}</label>
				<input type="checkbox" name="s_code" value="D${i}" id="d${i}" onClick="return countCk(s_code)">
				<label for="d${i}">D${i}</label>
				<br>
			</c:forEach>
			</td>
		</tr>
		<tr></tr>
		<tr>
			<td>금액/인원</td>
			<td>
			<fmt:formatNumber value="${race.r_price}" type="number"/>원&nbsp;/&nbsp; 
			${tk_partner}명
			</td>
		</tr>
		<tr>
			<td>총액</td>
			<td><b><fmt:formatNumber value="${race.r_price*tk_partner}" type="number"/></b>원</td>
		</tr>
		<tr></tr>
		<tr>
			<td colspan="2" rowspan="2" valign="middle" style="background: none; text-align: center;">
			<input type="submit" value="예매하기" class="btn3" style="width: 150;">
			</td>
		</tr>
	</table>
</form>
</div>   
</div>
<%@ include file="../../bottom.jsp" %>