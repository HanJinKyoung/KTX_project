<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp" %>
<script src='<c:url value="/resources/js/member/register.js"/>'></script>
<center>
<div class="register">
	<div style="width: 606px;margin: 0 auto;">
		<h1 align="center">회원가입</h1>
		<img src="./resources/imgs/mark1.jpg" width="30px" height="30px">
		<font color="#6799FF" style="font-style: italic;">KTX의 회원이 되시면 보다 다양한 서비스를 제공 받으실 수 있습니다.</font>
		<img src="./resources/imgs/mark2.jpg" width="30px" height="30px">
		<br><br>
		<hr color="gray">
	</div>
	<div>
	 <table style="margin: 0 auto;">
			<tr height="350">
				<td><img src="./resources/imgs/직원가입2.jpg" width="300" height="300"/></td> 
				<td><img src="./resources/imgs/일반회원가입.PNG" width="300" height="300"/></td>
			</tr>
			
			<tr height="150">
				<td>
					<input type="button" class="btn" value="회원가입(임직원용)" style="background: #F2CB61;" onclick="serve()">
				</td>
				<td>
					<input type="button" class="btn" value="회원가입(고객용)" style="background: #86E57F;" onclick="customer()">
				</td>
			</tr>
	 </table>
	</div>
</div>
</center>
<%@ include file="../../bottom.jsp" %>