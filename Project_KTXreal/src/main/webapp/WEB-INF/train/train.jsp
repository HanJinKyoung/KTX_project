<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admintop.jsp"%>
<%@ include file="./../common/common.jsp"%>
<script src='<c:url value="/resources/js/train/train.js"/>'></script>

<%
	String[] station = { "서울", "광명", "천안아산", "오송", "대전", "김천구미", "동대구", "신경주", "울산", "부산", "목포", "나주", "광주송정", "서대전",
		"정읍","익산", "논산", "계룡", "공주", "용산", "동해", "묵호", "정동진", "강릉", "진부", "평창", "둔내", "횡성", "만종", "서원주", "양평",
		"상봉", "청량리" };
%>
<div class="textcenter" style="width: 900;">
	<div class="trainadd">
	<h2>열차등록</h2>
	<br>
	<hr color=gray style="width: 400; display: inline-block;">
	<form action="insertTrain.tr" method="post" id="trainform">
		<table class="listtable">
			<tr>
				<th>열차번호</th>
				<td width="300px">
		    	<input type="number" name="t_num" max="1000" min="1" style="height: 25px; width: 70" id="ttnum">호차
				</td>
			</tr>
			<tr>
				<th>열차종류</th>
				<td>
				<input type="radio" name="t_type" value="KTX" checked>KTX
				<input type="radio" name="t_type" value="KTX-산천">KTX-산천
				</td>
			</tr>
			<tr>
				<th>열차방향</th>
				<td>
				<input type="text" name="t_way1" id="tway1" placeholder="ex)경부선" maxlength="7" style="height: 25px; width: 130"> 
				<input type="radio" name="t_way2" value="(상행)">상행 
				<input type="radio"	name="t_way2" value="(하행)">하행
				</td>
			</tr>
			<tr>
				<th>좌석수</th>
				<td>
				<input type="number" name="t_count" value="40" style="height: 25px; width: 70" min="30" max="100">석
				</td>
			</tr>
		</table><br>
		<hr color=gray style="width: 400; display: inline-block;">
		<div>
		<input type="submit" value="열차등록하기" class="btn" style="width: 100" id="trainform" onclick="return tcheck()">&nbsp;&nbsp;
		<input type="reset" value="취소" class="btn" style="width: 50">
		</div>
		</form>
	</div>
	<div class="raceadd">
	<h2>운행정보등록</h2><br>
	<hr color=gray style="width: 400; display: inline-block;">
		<form action="insertRace.tr" method="post" id="raceform">
		<table class="listtable">
			<tr>
				<th>열차번호</th>
				<td width="300px">
					<input type="number" name="t_num" max="1000" min="1" style="height: 25px; width: 70" id="rtnum">호차
				</td>
			</tr>
			<tr>
				<th>출발역</th>
				<td width="300px">
				<select name="r_start">
						<c:forEach var="start" items="<%=station%>">
							<option value="${start}">${start}
						</c:forEach>
				</select>역
				</td>
			</tr>
			<tr>
				<th>도착역</th>
				<td><select name="r_end">
						<c:forEach var="end" items="<%=station%>">
							<option value="${end}">${end}
						</c:forEach>
				</select>역</td>
			</tr>
			<tr>
				<th>출발시간</th>
				<td>
				<select name="r_starth">
						<c:forEach var="h" begin="5" end="24">
							<option value="${h}">${h}
						</c:forEach>
				</select>시&nbsp;&nbsp;
				<select name="r_startm">
						<c:forEach var="m" begin="0" end="59">
							<option value="${m}">${m}
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>도착시간</th>
				<td>
				<select name="r_endh">
						<c:forEach var="h" begin="5" end="25">
							<option value="${h}">${h}
						</c:forEach>
				</select>시&nbsp;&nbsp; 
				<select name="r_endm">
						<c:forEach var="m" begin="0" end="60">
							<option value="${m}">${m}
						</c:forEach>
				</select>분</td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="number" name="r_price" value="8400" max="1000000" min="8000">원</td>
			</tr>
		</table><br>
		<hr color=gray style="width: 400; display: inline-block;">
		<div>
		<input type="submit" value="열차등록하기" class="btn" style="width: 100" onclick="return rcheck()" id="raceform">&nbsp;&nbsp;
		<input type="reset" value="취소" class="btn" style="width: 50">
		</div>
	</form>
	</div>
</div>
<%@ include file="../../adminbottom.jsp"%>