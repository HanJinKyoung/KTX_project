<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp" %>
<script src='<c:url value="/resources/js/member/member.js?ver=1"/>'></script>
<div class = "textcenter" style="width: 700px">
<div class="find">
	<div class="findid">
		<form:form commandName="memberBean" method="post" action="findId.mem" id="findid">
			<h4><b>아이디 찾기</b></h4><Br>
			<hr width="300" color="gray"><Br>
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" size="10" name="m_name"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" size="20" name="m_email"></td>
				</tr>
				<tr>
					<td colspan="2">
					</td>
				</tr>				
			</table><br>
			<input type="submit" value="아이디찾기" class="btn" style="width: 100px;">
		</form:form>
	</div>
	<div class="findpw">
		<form:form commandName="memberBean" method="post" action="findPw.mem" id="findpw">
			<h4><b>비밀번호 찾기</b></h4><Br>
			<hr width="300" color="gray"><Br>
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" size="10" name="m_name"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" size="15" name="m_id"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" size="20" name="m_email"></td>
				</tr>					
			</table><br>
			<input type="submit" value="비밀번호찾기" class="btn" style="width: 100px;">
		</form:form>
	</div>
</div>
<div class="findbtn">
	<input type="button" class="btn3" style="height: 50;width: 150; float: left;" value="Login" onclick="login()">
	<input type="button" class="btn3" style="height: 50;width: 150; float: right;" value="홈페이지로 돌아가기" onclick="back()">
</div>
</div>
<%@ include file="../../bottom.jsp" %>