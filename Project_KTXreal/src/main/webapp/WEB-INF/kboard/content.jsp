<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %> 
<c:if test="${m_grade eq'A' || m_grade eq'S'}">
<%@ include file="../../admintop.jsp" %>
</c:if>
<c:if test="${m_grade ne 'A' && m_grade ne 'S'}">
<%@ include file="../../top.jsp" %>
</c:if>
<div class="textcenter">
	<div class="jsptitle">
	Korail 공지
	</div>
<form:form commandName="KBoardBean" method="post" action="content.kbd">
<table class="boardcontent">
	<tr height="30">
		<th>공지 제목</th>
		<td colspan="5">${kboard.k_subject }</td>
	</tr>
	
	<tr height="30">
		<th>작성자</th>
		<td width="100px">관리자</td>
		<th>작성일</th>
		<td align="center">
			<fmt:parseDate value="${kboard.k_reg_date}" var="date" pattern="yyyy-MM-dd HH:mm"/>
			<fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm"/>
		</td>
		<th>조회수</th>
		<td align="center" width="90px">${kboard.k_readcount}</td>
	</tr>
	<tr>
		<td id="content" align="left" colspan="6" style="padding: 30 30;">${kboard.k_content}</td>
	</tr>
</table><br>
	<c:if test="${m_grade eq'A'}">
		<input type="button" value="수정" class="searchbtn" onClick="location.href='update.kbd?k_num=${kboard.k_num}&pageNumber=${pageNumber}'">   
		<input type="button" value="삭제" class="searchbtn" onClick="location.href='kdeleteForm.kbd?k_num=${kboard.k_num}&pageNumber=${pageNumber}'">
	</c:if>
		<input type="button" value="전체 목록" class="btn3" onClick="location.href='klist.kbd?pageNumber=${pageNumber}'">		
</form:form>
</div>
<c:if test="${m_grade eq'A' || m_grade eq'S'}">
<%@ include file="../../adminbottom.jsp" %>
</c:if>
<c:if test="${m_grade ne 'A' && m_grade ne 'S'}">
<%@ include file="../../bottom.jsp" %>
</c:if>