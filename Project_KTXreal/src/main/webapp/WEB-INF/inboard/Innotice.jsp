<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %> 
<div class="mlist">
	<table class="table table-hover" style="width: 500px">
		<thead>
		<tr>
			<td style="border-right: none;" colspan="2">사내공지사항</td>
			<td align="right">
			<a href="inlist.ib">+더보기</a>
			</td>
		</tr>
		</thead>
		<c:set var="num" value="0"></c:set>
		<c:forEach var="iboard" items="${inlists}" varStatus="status">
		<c:set var="num" value="${num+1}"></c:set>
		<tr>
			<td>${num}</td>
			<td width="60%" align="left">
				<a href="incontent.ib?i_num=${iboard.i_num }&pageNumber=${pageInfo.pageNumber}">${iboard.i_subject }</a>
			</td>
			<td>
				<fmt:parseDate value="${iboard.i_reg_date}" var="date" pattern="yyyy-MM-dd HH:mm"/>
				<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm"/>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>