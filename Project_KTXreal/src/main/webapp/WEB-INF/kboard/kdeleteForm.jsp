<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<%@ include file="../../admintop.jsp" %>
<script src='<c:url value="/resources/js/jquery.js"/>' type="text/javascript" ></script>
<script src='<c:url value="/resources/js/kboard.js"/>' type="text/javascript" ></script>

<div class="delete">
	<div class="jsptitle">
	코레일 공지 삭제
	</div>
<form name="kdelForm" action="kdeleteForm.kbd" method="post" >
<table>
	<tr>
		<td colspan="2">비밀번호를 입력해 주세요</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="k_passwd" maxlength="10" value="">
			<input type="hidden" name="k_num" value="${kboard.k_num }">
			<input type="hidden" name="pageNumber" value="${pageNumber}">
		</td>
	</tr>
</table><br><br>
	<input type="submit" class="btn3" value="삭제" onClick="return passwdCheck()">&nbsp;&nbsp;
	<input type="button" class="btn2" value="목록" onClick="location.href='klist.kbd?pageNumber=${pageNumber}'">
</form>
</div>
<%@ include file="../../adminbottom.jsp" %>