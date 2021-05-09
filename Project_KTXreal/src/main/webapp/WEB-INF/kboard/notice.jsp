<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %> 
<div class="mlist">
	<table class="table table-hover" style="width: 500px">
		<thead>
		<tr>
			<td style="border-right: none;" colspan="2">공지사항</td>
			<td align="right">
			<a href="klist.kbd">+더보기</a>
			</td>
		</tr>
		</thead>
		<c:set var="num" value="0"></c:set>
		<c:forEach var="kboard" items="${klists}" varStatus="status">
		<c:set var="num" value="${num+1}"></c:set>
		<tr>
			<td>${num}</td>
			<td width="60%" align="left">
				<a href="content.kbd?k_num=${kboard.k_num }&pageNumber=1">${kboard.k_subject }</a>
			</td>
			<td>
				<fmt:parseDate value="${kboard.k_reg_date}" var="date" pattern="yyyy-MM-dd HH:mm"/>
				<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm"/>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>