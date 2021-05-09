<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../common/common.jsp"%>
<%@ include file="../../admintop.jsp" %>
<div class="textcenter">
	<div class="jsptitle">
	사내 공지
	</div>
<form:form commandName="InBoardBean" method="post" action="incontent.ib">
<table class="boardcontent">
	<tr>
		<th>공지 제목</th>
		<td colspan="5">${inboard.i_subject }</td>
	</tr>
	
	<tr>
		<th>작성자</th>
		<td width="100px">${inboard.i_writer }</td>
		<th>작성일</th>
		<td align="center">
			<fmt:parseDate value="${inboard.i_reg_date}" var="date" pattern="yyyy-MM-dd HH:mm"/>
			<fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm"/>
		</td>
		<th>조회수</th>
		<td align="center" width="90px">${inboard.i_readcount}</td>
	</tr>
	<tr>
		<td id="content" align="left" colspan="6" style="padding: 30 30;">
		${inboard.i_content}
		<c:if test="${inboard.i_filename != null}">
		<c:set var="filename" value="${inboard.i_filename }"/>
		<c:if test="${!fn:contains(filename,'txt')}">
    	<img src="<%=request.getContextPath() %>/resources/upload/${inboard.i_filename }" width="700px" height="700px">
		</c:if>
		</c:if>
		</td>
	</tr>
	<c:if test="${inboard.i_filename != null}">
	<tr height="30">
		<td id="content" align="left" colspan="6">
		첨부파일 :
		<a type="button" href="resources/upload/${inboard.i_filename }" download>${inboard.i_filename }</a>
		</td>
	</tr>
	</c:if>
</table><br>
		<c:if test="${m_grade eq'A'}">
			<input type="button" value="수정" class="searchbtn" onClick="location.href='inupdate.ib?i_num=${inboard.i_num}&pageNumber=${pageNumber}'">   
			<input type="button" value="삭제" class="searchbtn" onClick="location.href='indeleteForm.ib?i_num=${inboard.i_num}&pageNumber=${pageNumber}'">
		</c:if>
			<input type="button" value="전체 목록" class="btn3" onClick="location.href='inlist.ib?pageNumber=${pageNumber}'">
</form:form>
</div>
<%@ include file="../../adminbottom.jsp" %>


