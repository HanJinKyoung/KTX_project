<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %> 
<c:if test="${m_grade eq'A' || m_grade eq'S'}">
<%@ include file="../../admintop.jsp" %>
</c:if>
<c:if test="${m_grade ne 'A' && m_grade ne 'S'}">
<%@ include file="../../top.jsp" %>
</c:if>
<div class="mlist" style="width: 700">
	<div class="jsptitle">
	열차운임 및 시간표
	</div>
	<div class="search" style="width: 700px">
	<form action="trainlist.tr" method="get">
		<div class="columnchk" style="float: right;">
		<select name="whatColumn">
			<option value="all">전체 검색
			<option value="t_num">열차번호
			<option value="r_start">출발역
			<option value="r_end">도착역
		</select>&nbsp;
		<input type="text" name="keyword" value="" class="keyword">&nbsp;&nbsp;
		<input type="submit" value="검색" class="searchbtn">
		</div>
	</form>
	</div>
	<table class="table table-hover" style="width: 700; padding: 10;">
		<thead>
		<tr>
			<th><span>열차번호</span></th>
			<th><span>열차종류</span></th>
			<th><span>출발역</span></th>
			<th><span>도착역</span></th>
			<th><span>출발시간</span></th>
			<th><span>도착시간</span></th>
			<th><span>운임요금</span></th>
		</tr>
		</thead>
		<c:if test="${fn:length(trainLists)<1}">
         <tr>
            <td colspan="8" align="center"> 찾는 열차가 없습니다 </td>
         </tr>
      	</c:if>
		<c:forEach items="${trainLists }" var="train"> 
			<tr>
				<td align="center">
					${train.t_num }
				</td>
	 			<td>
					KTX
				</td>
				<td>
					${train.r_start }
				</td>
				<td>
					${train.r_end }
				</td>
				<td align="center">
					${train.r_starth }시 ${train.r_startm}분
				</td>
				<td align="center">
					${train.r_endh}시 ${train.r_endm }분
				</td>
				<td align="right">
					<fmt:formatNumber value="${train.r_price}" type="number"/>원
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