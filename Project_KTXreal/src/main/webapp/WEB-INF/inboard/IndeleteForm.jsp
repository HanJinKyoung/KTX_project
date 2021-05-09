<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<%@ include file="../../admintop.jsp" %>
<link href='<c:url value="/resources/css/newstyle.css"/>' rel="stylesheet" type="text/css"/>
<script src='<c:url value="/resources/js/inboard.js"/>' type="text/javascript" ></script>

<div class="delete">
	<div class="jsptitle">
	사내공지 삭제
	</div>
<form name="idelForm" action="indeleteForm.ib" method="post" >
<table>
	<tr>
		<td colspan="2">비밀번호를 입력해 주세요</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="i_passwd" maxlength="10" value="">
			<input type="hidden" name="i_num" value="${inboard.i_num }">
			<input type="hidden" name="pageNumber" value="${pageNumber}">
			<input type="hidden" name="i_filename" value="${inboard.i_filename}">
		</td>
	</tr>
</table><br><br>
	<input type="submit" class="btn3" value="삭제" onClick="return passwdCheck()">&nbsp;&nbsp;
	<input type="button" class="btn2" value="목록" onClick="location.href='inlist.ib?pageNumber=${pageNumber}'">
</form>
</div>
<%@ include file="../../adminbottom.jsp" %>