<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
<c:if test="${m_id == 'admin'}">
<%@ include file="../../admintop.jsp" %>
</c:if>
<c:if test="${m_id ne 'admin'}">
<%@ include file="../../top.jsp" %>
</c:if>

<div class="textcenter">
	<div style="padding-bottom: 80; font-size: 30; font-weight: bold;">
	<c:if test="${voc.q_writer=='admin'}">
	VOC 답변
	</c:if>
	<c:if test="${voc.q_writer!='admin'}">
	VOC [ No.${voc.q_num} ]
	</c:if>
	</div>
<form>
<table class="boardcontent">
	<tr height="30">
		<th>작성자</th>
		<c:if test="${voc.q_writer=='admin'}">
		<td align="center">관리자</td>
		</c:if>
		<c:if test="${voc.q_writer!='admin'}">
		<td align="center">${voc.q_writer}</td>
		</c:if>
		<th>작성일</th>
		<td align="center">
			<fmt:parseDate value="${voc.q_reg_date}" var="date" pattern="yyyy-MM-dd HH:mm"/>
			<fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm"/>
		</td>
	</tr>
	<tr height="30">
		<th>제목</th>
		<td colspan="3">${voc.q_subject }</td> 
	</tr>
	<tr height="30">
		<th colspan="4">문의 내용</th>
	</tr>
	<tr>
		<td colspan="4" style="padding: 30 30;">${voc.q_content}</td>
	</tr>
     <tr height="30">
		<th>받는 사람</th>
		<c:if test="${voc.q_receiver=='admin'}">
		<td colspan="5">관리자</td>
		</c:if>
		<c:if test="${voc.q_receiver!='admin'}">
		<td colspan="5">${voc.q_receiver}</td>
		</c:if>
	</tr>
</table><br>
			<c:if test="${m_id == voc.q_writer}">
			<input type="button" class="btn2" value="수정" onClick="location.href='vocupdate.vd?q_num=${voc.q_num}&pageNumber=${pageNumber}'">   
			<input type="button" class="btn2" value="삭제" onClick="location.href='vocdeleteForm.vd?q_num=${voc.q_num}&pageNumber=${pageNumber}'">
			</c:if>
			<c:if test="${m_id == 'admin'}">
			<input type="button" class="btn2" value="답글쓰기" onClick="location.href='vocreplyForm.vd?q_num=${voc.q_num}&pageNumber=${pageNumber}'">
			</c:if>
			<input type="button" class="btn3" value="목록" onClick="location.href='voclist.vd?pageNumber=${pageNumber}'">		
</form>
</div>

<c:if test="${m_id == 'admin'}">
<%@ include file="../../adminbottom.jsp" %>
</c:if>
<c:if test="${m_id ne 'admin'}">
<%@ include file="../../bottom.jsp" %>
</c:if>