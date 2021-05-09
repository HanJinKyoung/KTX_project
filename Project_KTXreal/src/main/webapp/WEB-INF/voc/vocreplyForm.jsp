<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
<%@ include file="../../admintop.jsp" %>
<script src='<c:url value="/resources/js/voc/reply.js"/>'></script>

<div class="textcenter">
	<div class="jsptitle">
	VOC 답변
	</div>
<form name="vocreplyForm" method="post" action="vocreplyForm.vd">
	<input type="hidden" name="q_ref" value="${vbean.q_ref}">
	<input type="hidden" name="q_re_step" value="${vbean.q_re_step}">
	<input type="hidden" name="q_re_level" value="${vbean.q_re_level}">
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
				<input type="text" name="q_subject" id="qsubject" maxlength="18" value="[답변]안녕하세요 고객님">
			</td>
		</tr>
		<tr>
			<th colspan="2">
			'${vbean.q_subject}'에 대한 답변입니다.
			</th>
		</tr>
		<tr>
			<td colspan="2" class="td">
				<textarea name="q_content" id="qcontent" cols="80" rows="15"></textarea>
			</td>
		</tr>
		<tr>
			<th>받는 사람</th> 
			<td>
				${vbean.q_writer}
				<input type="hidden" name="q_receiver" value="${vbean.q_writer}">
			</td>
		</tr>
	</table><br>
			<input type="button" class="btn2" value="접수 내역 보기" onClick="location.href='voclist.vd'">
			<input type="button" class="btn2" value="취소하기" onclick="history.go(-1)">
			<input type="submit" class="btn3" value="접수 하기" onClick="return writeSave()">
</form>
</div>
<%@ include file="../../adminbottom.jsp" %>