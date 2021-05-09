<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%@ include file="../../top.jsp" %>
<div class="mlist">
	<div class="jsptitle">
	유실물 목록
	</div>
	<div class="search" style="width: 800px">
		<form action="lostlist.lt" method="get">
			<div class="columnchk" style="float: right;">
			<select name="whatColumn">
				<option value="all">전체 검색
				<option value="l_name">품목
				<option value="l_content">습득장소
			</select>&nbsp;
			<input type="text" name="keyword" value="" class="keyword"/>&nbsp;&nbsp;
			<input type="submit" value="검색" class="searchbtn"/>
			</div>
		</form>
	</div>
	<table class="table table-hover" style="width: 800px">
		<thead>
	    <c:if test="${m_grade eq 'A' || m_grade eq 'S'}">
		<tr>
				<td colspan="7" align="right">
					<input type="button" class="btn3" value="유실물 등록" onclick="location.href='lostwrite.lt'">
	         	</td>
		</tr>
		</c:if>
		<tr align="center">
			<th width="50">번호</th>
			<th>유실물품목</th>
			<th>습득장소</th>
			<th>접수일</th>
			<th>처리상태</th>
			<c:if test="${m_grade eq 'A' || m_grade eq 'S'}">
			<th><span>삭제</span></th>
			<th><span>수정</span></th>
			</c:if>
		</tr>		
		</thead>
		<c:if test="${fn:length(lostLists)<1}">
         <tr>
         	<c:if test="${m_grade eq 'A' || m_grade eq 'S'}">
            <td colspan="7" align="center"> 찾는 품목이 없습니다 </td>
            </c:if>
            <c:if test="${m_grade != 'A' && m_grade != 'S'}">
            <td colspan="5" align="center"> 찾는 품목이 없습니다 </td>
            </c:if>
         </tr>
      	</c:if>	
		<c:set var="totalCount" value="${pageInfo.totalCount}"></c:set>
		<c:forEach items="${lostLists}" var="lost">
		<c:set var="totalCount" value="${totalCount-1 }"></c:set>
	
			<tr>
				<td align="center">
					${lost.l_num}
				</td>
				<td align="center">
					<a href="lostcontent.lt?l_num=${lost.l_num}&pageNumber=${pageInfo.pageNumber}">${lost.l_name}</a>
				</td>
				<td align="center">
					${lost.l_content}
				</td>
				<td align="center"  width="130">
					<fmt:parseDate value="${lost.l_date}" var="date" pattern="yyyy-MM-dd HH:mm"/>
					<fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm"/>
				</td>
				<td align="center"  width="50">
					${lost.l_state}
				</td>
			<c:if test="${m_grade eq 'A' || m_grade eq 'S'}">
				<td align="center">
					<a href="lostdelete.lt?l_num=${lost.l_num}&pageNumber=${pageInfo.pageNumber}">삭제</a>				
				</td>
				<td align="center">
					<input type="button" class="btn2" value="수정" onClick="location.href='lostupdate.lt?l_num=${lost.l_num }&pageNumber=${pageInfo.pageNumber}'">
				</td>
			</c:if>
		</tr>
	</c:forEach>
	</table><br><br>
	${pageInfo.pagingHtml }
</div>
<%@ include file="../../bottom.jsp" %>