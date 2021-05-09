<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../admintop.jsp" %>
<div class="mlist">
	<div class="jsptitle">
	회원/임직원 조회
	</div>
	<div class="search">
	<form action="list.mem" method="get">
		<div class="columnchk">
			<input type="radio" name= m_grade value="all" checked>전체
			<input type="radio" name= m_grade value="S">직원
			<input type="radio" name= m_grade value="M">일반회원 
			<select name="whatColumn">
			<option value="all">전체 검색
			<option value="m_name">이름
			<option value="m_phone_3">전화번호(뒷자리)
			</select>
		</div>
		<div class="wordchk">
			<input type="text" class="keyword" name="keyword" value="">&nbsp;&nbsp;
			<input type="submit" value="검색" class="searchbtn">
		</div>
	</form>
	</div>
	<table class="table table-hover" style="min-width: 700;">
		<thead>
		<tr>
			<th><span>회원번호</span></th>
			<th><span>ID</span></th>
			<th><span>회원 등급</span></th>
			<th><span>이름</span></th>
			<th><span>email</span></th>
			<th><span>전화번호</span></th>
			<th><span>입사일/가입일</span></th>
			<c:if test="${m_grade == 'A' }">
			<th><span>삭제</span></th>
			</c:if>
		</tr>
		</thead>
		<c:if test="${fn:length(memberLists)<1}">
         <tr>
            <td colspan="8" align="center"> 찾는 회원이 없습니다 </td>
         </tr>
      	</c:if>
		<c:forEach items="${memberLists }" var="member"> 
			<tr>
				<td align="center">
					${member.m_num }
				</td>
				<td>
					${member.m_id }
				</td>
				<td align="center">
					${member.m_grade }
				</td>
				<td>
					<a href="memdetail.mem?m_num=${member.m_num }">
					${member.m_name }
					</a> 
				</td>
				<td>
					${member.m_email }
				</td>
				<td>
					${member.m_phone_1 }-${member.m_phone_2 }-${member.m_phone_3 }
				</td>
				<td align="center">
					<fmt:parseDate value="${member.m_date }" var="date" pattern="yyyy-MM-dd"/>
					<fmt:formatDate value="${date }" pattern="yyyy-MM-dd"/>
				</td>
				<c:if test="${m_grade == 'A' }">
				<td>
					<c:if test="${member.m_grade != 'A' }">
					<a href="delete.mem?m_num=${member.m_num }&pageNumber=${pageInfo.pageNumber}">삭제</a>
					</c:if>
				</td>
				</c:if>
			</tr>		
		</c:forEach>
		</table><br><br>
		${pageInfo.pagingHtml }
</div>
<%@ include file="../../adminbottom.jsp" %>