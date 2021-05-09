<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<link rel="stylesheet" type="text/css" href="resources/css/flexslider.css"/> 
<script src="resources/js/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="resources/js/slide.js"></script>
<script type="text/javascript" src="resources/js/date.js"></script>
<c:choose>
	<c:when test="${m_grade eq 'M'}">
	<script type="text/javascript" src="resources/js/member.js"></script>
	</c:when>
	<c:when test="${m_id eq null}">
	<script type="text/javascript" src="resources/js/blank.js"></script>
	</c:when>
	<c:when test="${m_grade eq 'A' || m_grade eq 'S'}">
	<script type="text/javascript" src="resources/js/adcheck.js"></script>
	</c:when>
</c:choose>
<%
	String[] station={
			"서울","광명","천안아산","오송","대전","김천구미","동대구","신경주","울산","부산",
			"목포","나주","광주송정","서대전","장성","정읍","김제","익산","논산","계룡","공주","용산",
			"동해","묵호","정동진","강릉","진부","평창","둔내","횡성","만종","서원주","양평","상봉","청량리"
			};
%>
<div class="mainwarp" style="margin-top: -130;">
<%session.setAttribute("destination",null);%>
	<div class="m_main">
		<div class="flexslider">
		  <ul class="slides">
		    <li>
              <img src="./resources/imgs/korail_img/ProdDisplay_06.png">
		    </li>
		    <li>
		      <img src="./resources/imgs/korail_img/ProdDisplay_04.jpg">
		    </li>
		    <li>
		      <img src="./resources/imgs/korail_img/ProdDisplay_03.jpg">
		    </li>
		    <li>
		      <a href="https://www.youtube.com/watch?v=OXHCPl_YZhg" target="_blank"><img src="./resources/imgs/korail_img/ProdDisplay_02.jpg"></a>
		    </li>
		  </ul>
		</div>
		<div class="mainleft">
		<font color="blue" style="font-weight: bold; font-size: large;">빠른예매</font><br>
		<hr color="gray">
			<form action="trainbook.tr" method="post" onSubmit="return choice()">
			<table class="listtable">
			<tr>
				<th align="left">출발역</th>
				<td>
				<select name="r_start">
				<c:forEach var="start" items="<%=station%>">
					<option value="${start}">${start}
				</c:forEach>
				</select>역
				</td>
			</tr>
			<tr>
				<th align="left">도착역</th>
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
				<th align="left">출발일</th>
				<td>
				<input type="date" name="tk_date" id="startday" style="background: white;">
				</td>
			</tr>
			<tr>
				<th align="left">출발시각</th>
				<td>
				<select name="r_starth">
				<c:forEach var="h" begin="0" end="23">
					<option value="${h}">${h}
				</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<th align="left">인원</th>
				<td>
				<select name="tk_partner">
				<c:forEach var="i" begin="1" end="4">
					<option value="${i}">${i}
				</c:forEach>
				</select>
				</td>
			</tr>
			</table>
			<hr color="gray">
			<input type="submit" value="열차 조회하기" class="btn3" style="width: 110px;margin-top: 10;">
			</form>
		</div>
		<div id="notice">
		</div>
		<div class = "mainad">
			<a href="content.kbd?k_num=1&pageNumber=1">
			<img src="./resources/imgs/korail_img/BnrDisplay_01.png" width="250" height="250">
			</a>
		</div>
	</div>
</div>
<%@ include file="bottom.jsp" %>
<!-- <script type="text/javascript">
//최소예매일(오늘)


</script> -->