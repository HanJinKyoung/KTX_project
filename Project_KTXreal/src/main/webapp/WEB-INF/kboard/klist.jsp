<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %> 
<c:if test="${m_grade eq'A' || m_grade eq'S'}">
<%@ include file="../../admintop.jsp" %>
</c:if>
<c:if test="${m_grade ne 'A' && m_grade ne 'S'}">
<%@ include file="../../top.jsp" %>
</c:if>
<div class="mlist">
	<div class="jsptitle">
	Korail 공지
	</div>
	<div class="search" style="width: 700px">
	<form action="klist.kbd" method="get">
		<div class="columnchk" style="float: right;">
		<select name="whatColumn">
			<option value="k_subject">제목</option>
		</select>&nbsp;
		<input type="text" name="keyword" value="" class="keyword"/>&nbsp;&nbsp;
		<input type="submit" value="검색" class="searchbtn"/>
		</div>
	</form>
	</div>
	<table class="table table-hover" style="min-width: 700">
		<thead>
		<c:if test="${m_grade eq'A'}">
		<tr>
			<td align="right" colspan="3">
				<a href="write.kbd">공지 등록</a>
			</td>
		</tr>
		</c:if>
		<tr align="center">
			<td>번호</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
		</thead>
		<c:if test="${fn:length(klists)<1}">
         <tr>
            <td colspan="3" align="center"> 찾는 글이 없습니다 </td>
         </tr>
      	</c:if>
		<c:set var="totalCount" value="${pageInfo.totalCount}"></c:set>
		<c:forEach var="kboard" items="${klists}" varStatus="status">
		<c:set var="totalCount" value="${totalCount-1 }"></c:set>
		<tr>
			<td width="20%" align="center">
				${pageInfo.totalCount - ((pageInfo.pageNumber-1)*pageInfo.pageSize+status.index)}
			</td>
			<td width="60%" align="left">
				<a href="content.kbd?k_num=${kboard.k_num }&pageNumber=${pageInfo.pageNumber}">${kboard.k_subject }</a>
			</td>
			<td width="20%" align="center">
				<fmt:parseDate value="${kboard.k_reg_date}" var="date" pattern="yyyy-MM-dd HH:mm"/>
				<fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm"/>
			</td>
		</tr>
		</c:forEach>
	</table><br><br>
	${pageInfo.pagingHtml }
</div>
<c:if test="${m_grade eq'A' || m_grade eq'S'}">
<%@ include file="../../adminbottom.jsp" %>
</c:if>
<c:if test="${m_grade ne 'A' && m_grade ne 'S'}">
<%@ include file="../../bottom.jsp" %>
</c:if>