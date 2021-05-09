<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../admintop.jsp" %>
<div class="mlist">
	<div class="jsptitle">
	출퇴근내역
	</div>
	<div class="search" style="width: 600;">
	<form action="checklist.ad" method="post">
		<div class="columnchk" style="float: right;">
			<select name="whatColumn" >
				<option value="all">전체 출퇴근 검색</option>
				<option value="c_date">검색년월</option>
			</select>
				<select name="keyword1" class="keyword">
				<c:forEach var="i" step="1" begin="2020" end="2021">
					<option value="${i }">${i }</option>
				</c:forEach>
				</select>
				<select name="keyword2" class="keyword">
				<c:forEach var="i" step="1" begin="1" end="12">
				<c:if test="${i<10 }">
					<option value="0${i }">0${i }</option>
				</c:if>
				<c:if test="${i >= 10}">
	            	<option value="${i}">${i }</option> 
	            </c:if>	
				</c:forEach>
			</select> 
			<input type="submit" value="검색" class="btn3">
		</div>
	</form>
	</div>
	<table class="listtable" style="width: 600">
		<tr>
			<th><span>사원번호</span></th>
			<th><span>이름</span></th>
			<th><span>출근일</span></th>
			<th><span>출근시간</span></th>
			<th><span>퇴근시간</span></th>
			<th><span>정상 근무</span></th>
		</tr>
		<c:forEach items="${clist }" var="list">

			<tr>
				<td>${list.m_num }</td>
				<td>${list.c_name }</td>
				<td>
					<fmt:parseDate value="${list.c_date }" var="date" pattern="yyyy-MM-dd"/>
					<fmt:formatDate value="${date }" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<fmt:parseDate value="${list.c_intime }" var="intime" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${intime }" pattern="HH:mm:ss"/>
				</td>
				<td>
					<fmt:parseDate value="${list.c_outtime }" var="outtime" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${outtime }" pattern="HH:mm:ss"/>
				</td>
				<td align="center">
					<c:choose>
						<c:when test="${list.c_count >=1 }">
							<img src="resources/imgs/check.jpg" width="25px" height="25px">
						</c:when>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="6">총 근무 일 수 : 
				${cnt }
				</td>
			</tr>
	</table><br>
	${pageInfo.pagingHtml }
</div>

<%@ include file="../../adminbottom.jsp" %>