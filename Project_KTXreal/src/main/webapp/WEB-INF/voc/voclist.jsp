<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
<c:if test="${m_id == 'admin'}">
<%@ include file="../../admintop.jsp" %>
</c:if>
<c:if test="${m_id ne 'admin'}">
<%@ include file="../../top.jsp" %>
</c:if>
<div class="mlist">
	<div style="padding-bottom: 80; font-size: 30; font-weight: bold;">
	고객의 소리<font size="5px">(총 갯수: ${pageInfo.totalCount} )</font>
	</div>
	<div class="search" style="margin: 0 auto;">
	<form action="voclist.vd" method="get">
		<div class="columnchk" style="float: right;">
		<select name="whatColumn">
			<option value="all" selected>전체검색</option>
			<c:if test="${m_id == 'admin'}">
			<option value="q_writer">작성자</option>
			</c:if>
			<option value="q_subject">제목</option>
			<option value="q_state">답변여부</option>
		</select>&nbsp;
		<input type="text" name="keyword" value="" class="keyword">&nbsp;
		<input type="submit" value="검색" class="searchbtn">
		</div>
	</form>
	</div>
	<table class="table table-hover" style="width: 700">
		<thead>
		<c:if test="${m_id ne 'admin'}">
		<tr>
			<td colspan="7" align="right">
				<a href="vocwriteForm.vd">글쓰기</a>
			</td>
		</tr>
		</c:if>
		<tr  align="center">
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>받는사람</td>
			<td>작성일</td>
			<td>답변여부</td>
		</tr>
		</thead>
		<c:set var="totalCount" value="${pageInfo.totalCount}"></c:set>
		<c:forEach var="voc" items="${lists}" varStatus="status">
		<c:set var="totalCount" value="${totalCount-1 }"></c:set>
		<tr>
			<td>
				${pageInfo.totalCount - ((pageInfo.pageNumber-1)*pageInfo.pageSize+status.index)}
			</td>
			<td>
			<c:if test="${voc.q_writer != 'admin'}">
				${voc.q_writer}
			</c:if>
			</td>
			<td>
				<c:if test="${voc.q_re_level>0}">
					<c:set var="wid" value="${voc.q_re_level * 20}"/>
					<img src = "resources/imgs/level.gif" width="${wid }" height="16">
					<img src = "resources/imgs/re.gif">
				</c:if>
				<a href="voccontent.vd?q_num=${voc.q_num }&pageNumber=${pageInfo.pageNumber}">${voc.q_subject }</a>
			</td>
			<td>
			<c:if test="${voc.q_receiver == 'admin'}">
				코레일
			</c:if>
			<c:if test="${voc.q_receiver != 'admin'}">
				${voc.q_receiver}
			</c:if>
			</td>
			<td>
				<fmt:parseDate value="${voc.q_reg_date}" var="date" pattern="yyyy-MM-dd HH:mm"/>
				<fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm"/>
			</td>
			<td>
			<c:if test="${voc.q_writer != 'admin'}">
				${voc.q_state}
			</c:if>			
			</td>
		</tr>
		</c:forEach>
	</table><br><br>
	${pageInfo.pagingHtml }
</div>
<c:if test="${m_id == 'admin'}">
<%@ include file="../../adminbottom.jsp" %>
</c:if>
<c:if test="${m_id ne 'admin'}">
<%@ include file="../../bottom.jsp" %>
</c:if>