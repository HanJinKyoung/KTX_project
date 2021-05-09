<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp" %>
<%@ include file="./../common/common.jsp" %>
<script src='<c:url value="/resources/js/train/book.js"/>'></script>
<script src='<c:url value="/resources/js/date.js"/>'></script>
<%
	String[] station={
			"서울","광명","천안아산","오송","대전","김천구미","동대구","신경주","울산","부산",
			"목포","나주","광주송정","서대전","정읍","익산","논산","계룡","공주","용산",
			"동해","묵호","정동진","강릉","진부","평창","둔내","횡성","만종","서원주","양평","상봉","청량리"
			};
%>
<div class="textcenter" style="width: 1000px">
<div class="bookleft">
	<form action="trainbook.tr" method="post" onsubmit="return choice()">
	<table class="listtable">
	<tr>
		<th>출발역</th>
		<td>
		<select name="r_start">
		<c:forEach var="start" items="<%=station%>">
			<option value="${start}">${start}
		</c:forEach>
		</select>역
		</td>
	</tr>
	<tr>
		<th>도착역</th>
		<td>
		<select name="r_end" class="end">
			<option value="">선택하세요
		<c:forEach var="end" items="<%=station%>">
			<option value="${end}">${end}
		</c:forEach>
		</select>역
		</td>
	</tr>
	<tr>
		<th>출발일</th>
		<td>
		<input type="date" name="tk_date" id="startday">
		</td>
	</tr>
	<tr>
		<th>출발시각</th>
		<td>
		<select name="r_starth">
		<c:forEach var="h" begin="0" end="23">
			<option value="${h}">${h}
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<th>인원</th>
		<td>
		<select name="tk_partner">
		<c:forEach var="i" begin="1" end="4">
			<option value="${i}">${i}
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="열차 조회하기" class="btn3" style="width: 110px;">
		</td>
	</tr>
	</table>
	</form>
</div>
<div class="booklist">
	<form method="get" action="reserveform.tk">
	<table class="listtable" style="text-align: center;">
		<tr>
			<td colspan="7"align="left">
			<input type="hidden" name="tk_date" value="${tk_date}">
			<input type="hidden" name="tk_partner" value="${tk_partner}">
			출발일 : ${tk_date}&nbsp;&nbsp;[인원 : ${tk_partner}]
			</td>
		</tr>
		<tr>
			<td>열차번호</td>
			<td>열차종류</td>
			<td>출발</td>
			<td>도착</td>
			<td>출발시간</td>
			<td>도착시간</td>
			<td>선택</td>
		</tr>
		<c:if test="${trainlist != null}">
		<c:forEach var="tlist" items="${trainlist}">
		<tr>
			<td>
				${tlist.t_num}
			</td>
			<td>KTX</td>
			<td>
				${tlist.r_start}
			</td>
			<td>
				${tlist.r_end}
			</td>
			<td>
				<c:if test="${tlist.r_starth < 10}">0</c:if>${tlist.r_starth}:
				<c:if test="${tlist.r_startm < 10}">0</c:if>${tlist.r_startm}
			</td>
			<td>
				<c:if test="${tlist.r_endh < 10}">0</c:if>${tlist.r_endh}:
				<c:if test="${tlist.r_endm < 10}">0</c:if>${tlist.r_endm}
			</td>
			<td><input type="radio" name="r_num" value="${tlist.r_num}"></td>
		</tr>
		</c:forEach>
		</c:if>
		<tr>
			<td colspan="7" style="border-bottom: none;" align="right">
				<input type="submit" value="좌석선택" class="btn3" style="width: 100" onclick="return empty()">
			</td>
		</tr>
	</table>
	</form>
</div>
</div>
<%@ include file="../../bottom.jsp" %>
