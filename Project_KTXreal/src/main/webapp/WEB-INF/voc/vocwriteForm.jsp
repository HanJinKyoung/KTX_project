<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<c:if test="${m_id == 'admin'}">
<%@ include file="../../admintop.jsp" %>
</c:if>
<c:if test="${m_id ne 'admin'}">
<%@ include file="../../top.jsp" %>
</c:if>
<link href='<c:url value="/resources/css/newstyle.css"/>' rel="stylesheet"	type="text/css" />
<script src='<c:url value="/resources/js/voc/wirte.js"/>'></script>
<div class="textcenter">
	<div class="jsptitle">
	VOC 등록
	</div>
	<font size="2em" color="red">*VOC는 자신이 작성한 글만 볼 수 있습니다.</font>
<form name="vocwriteForm" method="post" action="vocwriteForm.vd">
	<table class="boardcontent">
		<tr>
			<th>작성자</th> 
			<td>
				${m_id}
				<input type="hidden" name="q_writer" value="${m_id}">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td class="td" style="text-align: left;padding: 0;">
				<input type="text" name="q_subject" id="qsubject" maxlength="15">
			</td>
		</tr>
		<tr>
			<th colspan="2">문의 내용</th>
		</tr>
		<tr> 
			<td colspan="2" class="td">
				<textarea name="q_content" id="qcontent" cols="80" rows="15"></textarea>
			</td>
		</tr>
		<tr>
			<th>받는 사람</th> 
			<td>
				관리자
				<input type="hidden" name="q_receiver" value="admin">
			</td>
		</tr>
	</table><br>
			<input type="button" class="btn2" value="접수 내역 보기" onClick="location.href='voclist.vd'">
			<input type="button" class="btn2" value="취소하기" onclick="history.go(-1)">
			<input type="submit" class="btn3" value="접수 하기" onclick="return writeSave()">
</form>
</div>
<c:if test="${m_id == 'admin'}">
<%@ include file="../../adminbottom.jsp" %>
</c:if>
<c:if test="${m_id ne 'admin'}">
<%@ include file="../../bottom.jsp" %>
</c:if>