<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/common.jsp"%>
<%@ include file="../../top.jsp" %>
<div class="textcenter">
	<div class="jsptitle">
	유실물 상세보기
	</div>
<form>
<table class="boardcontent">
	<tr height="30">
		<th>유실물 품목</th>
		<td>${lbean.l_name }</td>
		<th>접수일자</th>
		<td align="center" width="150">
			<fmt:parseDate value="${lbean.l_date}" var="date" pattern="yyyy-MM-dd HH:mm"/>
			<fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm"/>
		</td>
	</tr>
	<tr>
		<th>습득장소</th>
		<td id="content" colspan="3">${lbean.l_content}</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
		<img src="<%=request.getContextPath() %>/resources/uploadlost/${lbean.l_image }" width="400px" style="padding: 10;" onError="this.style.visibility='hidden'">
		</td>
	</tr>
</table><br><br>
		<c:if test="${m_grade ne 'M'}">
			<input type="button" class="btn2" value="수정" onClick="location.href='lostupdate.lt?l_num=${lbean.l_num}&pageNumber=${pageNumber}'">   
			<input type="button" class="btn2" value="삭제" onClick="location.href='lostdelete.lt?l_num=${lbean.l_num}&pageNumber=${pageNumber}'">
		</c:if>
			<input type="button" class="btn3" value="전체 목록" onClick="location.href='lostlist.lt?pageNumber=${pageNumber}'">	
</form>
</body>
</div>
<%@ include file="../../bottom.jsp" %>


