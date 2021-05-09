<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="../common/common.jsp" %>
<c:if test="${m_id == 'admin'}">
<%@ include file="../../admintop.jsp" %>
</c:if>
<c:if test="${m_id ne 'admin'}">
<%@ include file="../../top.jsp" %>
</c:if>
<script src='<c:url value="/resources/js/voc/update.js"/>'></script>

<div class="textcenter">
	<div style="padding-bottom: 80; font-size: 30; font-weight: bold;">
	VOC 수정하기
	</div>
<form method="post" name="vocwriteForm" action="vocupdate.vd">
<input type="hidden" name="pageNumber" value="${pageNumber}">
<input type="hidden" name="q_num" value="${voc.q_num }">
	<table class="boardcontent">
		<tr>
			<th>작성자</th>
			<td align="center" width="120">${voc.q_writer}</td>
			<th>접수 번호</th>
			<td align="center" width="60">${voc.q_num}</td>
			<th>작성일</th>
			<td align="center">
				<fmt:parseDate value="${voc.q_reg_date}" var="date" pattern="yyyy-MM-dd HH:mm"/>
				<fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm"/>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td class="td" colspan="5" style="text-align: left;padding: 0;">
			<input type="text" name="q_subject" id="qsubject" maxlength="30" value="${voc.q_subject }"/>
			</td> 
		</tr>
		<tr>
			<th>문의 내용</th>
			<td class="td" colspan="5">
			<textarea name="q_content" id="qcontent" cols="70" rows="15">${voc.q_content}</textarea>
			</td>
		</tr>
	     <tr>
			<th>받는 사람</th>
			<td colspan="5">${voc.q_receiver}</td>
		</tr>
	</table><br>
				<input type="button" class="btn2" value="취소" onclick="history.go(-1)">		
				<input type="submit" class="btn3" value="수정" onclick="return goUpdate()">
</form>
</div>
<c:if test="${m_id == 'admin'}">
<%@ include file="../../adminbottom.jsp" %>
</c:if>
<c:if test="${m_id ne 'admin'}">
<%@ include file="../../bottom.jsp" %>
</c:if>