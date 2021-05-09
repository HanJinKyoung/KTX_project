<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp" %>
<%@ include file="./../common/common.jsp" %>
<script src='<c:url value="/resources/js/ticket/list.js"/>'></script>

<div>
	<div class="tklist">
	<h2 style="width: 900; margin: 0 auto;">예약 내역</h2><br>
	<form method="post" action="allpay.tk" name="myform">
	<table class="listtable">
		<tr>
			<th>티켓번호</th>
			<th>출발일</th>
			<th>출발역</th>
			<th>도착역</th>
			<th>열차번호</th>
			<th>좌석번호</th>
			<th>금액</th>
			<th>예약상태</th>
			<th>예약일</th>
			<th>취소</th>
			<th><input type="checkbox" name="allcheck" onClick="allDelete1(this)"></th>
		</tr>
		<c:forEach var="tkre" items="${reservelist}">
		<tr>
			<td>${tkre.tk_num}</td>
			<td>${tkre.tk_date}</td>
			<td>${tkre.r_start}</td>
			<td>${tkre.r_end}</td>
			<td>${tkre.t_num}</td>
			<td>${tkre.s_code}</td>
			<td><fmt:formatNumber value="${tkre.r_price}" type="number"/>원</td>
			<td>${tkre.tk_reserve}</td>
			<td>${tkre.tk_bookday}</td>
			<td>
				<input type="button" value="예매취소" class="btn2" onclick="return cancel('${tkre.tk_num}')">
			</td>
			<td>
				<input type="checkbox" name="rowcheck1" value="${tkre.tk_num }">
				<input type="hidden" name="rowprice1" value="${tkre.r_price }">
			</td>
		</tr>
		</c:forEach>
	</table>
	<div class="listbtn">
		<input type="submit" value="결제하기" class="btn" onclick="return selectPay()">
	</div>
	</form>
	</div><br><br>
	<div class="tklist">
	<h2 style="width: 900; margin: 0 auto;">결제 내역</h2><br>
	<form method="post" action="alldelete.tk">
	<table class="listtable">
		<tr>
			<th>티켓번호</th>
			<th>출발일</th>
			<th>출발역</th>
			<th>도착역</th>
			<th>열차번호</th>
			<th>좌석번호</th>
			<th>금액</th>
			<th>예약상태</th>
			<th>예약일</th>
			<th><input type="checkbox" name="allcheck" onClick="allDelete2(this)"></th>
		</tr>
		<c:forEach var="tkpay" items="${paylist}">
		<tr>
			<td>${tkpay.tk_num}</td>
			<td>${tkpay.tk_date}</td>
			<td>${tkpay.r_start}</td>
			<td>${tkpay.r_end}</td>
			<td>${tkpay.t_num}</td>
			<td>${tkpay.s_code}</td>
			<td><fmt:formatNumber value="${tkpay.r_price}" type="number"/>원</td>
			<td>${tkpay.tk_reserve}</td>
			<td>${tkpay.tk_bookday}</td>
			<td>
				<input type="checkbox" name="rowcheck2" value="${tkpay.tk_num }">
				<input type="hidden" name="rowprice2" value="${tkpay.r_price }">
			</td>
		</tr>
		</c:forEach>
	</table>
	<div class="listbtn">
		<input type="submit" value="결제취소" class="btn2" onclick="return selectDelete()">
	</div>
	</form>
	</div>
</div>
<%@ include file="../../bottom.jsp" %>