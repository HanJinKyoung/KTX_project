<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<%@ include file="../../admintop.jsp" %>

<div class="mlist">
	<div class="jsptitle">
	사내 공지
	</div>
	<div class="search" style="width: 700px">
	<form action="inlist.ib" method="get">
		<div class="columnchk" style="float: right;">
		<select name="whatColumn">
			<option value="i_subject">제목</option>
		</select>&nbsp;
		<input type="text" name="keyword" value="" class="keyword"/>&nbsp;&nbsp;
		<input type="submit" value="검색" class="searchbtn"/>
		</div>
	</form>
	</div>
	<table class="table table-hover">
		<thead>
				<c:if test="${m_grade eq'A'}">
		<tr>
			<td align="right" colspan="3">
				<a href="inwrite.ib">공지 등록</a>
			</td>
		</tr>
		</c:if>
		<tr align="center">
			<td>번호</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
		</thead>
		<c:set var="totalCount" value="${pageInfo.totalCount}"></c:set>
		<c:forEach var="iboard" items="${inlists}" varStatus="status">
		<c:set var="totalCount" value="${totalCount-1 }"></c:set>
		<tr>
			<td width="20%" align="center">
				${pageInfo.totalCount - ((pageInfo.pageNumber-1)*pageInfo.pageSize+status.index)}
			</td>
			<td width="60%" align="left">
				<a href="incontent.ib?i_num=${iboard.i_num }&pageNumber=${pageInfo.pageNumber}">${iboard.i_subject }</a>
			</td>
			<td width="20%" align="center">
				<fmt:parseDate value="${iboard.i_reg_date}" var="date" pattern="yyyy-MM-dd HH:mm"/>
				<fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm"/>
			</td>
		</tr>
		</c:forEach>
	</table><br><br>
	${pageInfo.pagingHtml }
</div>
<%@ include file="../../adminbottom.jsp" %>
