<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../../top.jsp" %>
<script src='<c:url value="/resources/js/member/member.js"/>'></script>
<center>
<div class="login">
<form:form commandName="memberBean" method="post" action="login.mem">
<h3 align="left"><b>Login</b></h3><Br>
<hr width="300" color="gray"><Br>
<table>
	<tr>
		<td>ID</td>
		<td><input type="text" name="m_id"></td>
	</tr>
	<tr>
		<td>PW</td>
		<td><input type="password" name="m_pw"></td>
	</tr>
	<tr align="center">
		<td colspan="2" >
		<br>
		<input type="submit" value="로그인" class="btn" style="width: 70px;">&nbsp;
		<input type="button" value="회원가입" onClick="register()" class="btn" style="width: 70px;">&nbsp;
		<input type="button" value="ID/PW찾기" onClick="find()" class="btn"style="width: 90px;">
		</td>
	</tr>
</table>
</form:form>
</div>
</center>

<%@ include file="../../bottom.jsp" %>
