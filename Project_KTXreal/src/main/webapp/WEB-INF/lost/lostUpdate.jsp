<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>  
<%@ include file="../../admintop.jsp" %>
<script src='<c:url value="/resources/js/lost/lost.js"/>'></script>
<div class="textcenter">
	<div class="jsptitle">
	유실물 수정
	</div>
<form method="post" action="lostupdate.lt" enctype="multipart/form-data">
<input type="hidden" name="pageNumber" value="${pageNumber}">
<input type="hidden" name="l_num" value="${lbean.l_num }">
<table class="boardcontent">
	<tr>
		<th style="width: 130;">유실물 품목명</th> 
		<td class="td" style="text-align: left; padding: 0;">
			<input type="text" name="l_name" id="lname" maxlength="10" value="${lbean.l_name }">
		</td>
	</tr>
	<tr>
		<th>습득장소</th> 
		<td class="td" style="text-align: left; padding: 0;">
			<input type="text" name="l_content" id="lcontent" maxlength="15" value="${lbean.l_content }">
		</td>
	</tr>
	<tr>
		<th rowspan="2">첨부이미지</th>
		<td>
			<img src="<%=request.getContextPath() %>/resources/uploadlost/${lbean.l_image }" width="150px" style="padding: 10;">
			[현재이미지 : ${lbean.l_image}]
		</td>
	</tr>
	<tr>
		<td class="td" style="text-align: left; padding: 0;">
			<input type="file" name="upload"> <!-- upload = bread.jpg -->
			<input type="hidden" name="upload2" value="${lbean.l_image}">
		</td>
	</tr>
	<tr>
		<th>처리상태</th>
		<td class="td" style="text-align: left; padding: 0;">
			<input type="text" name="l_state" id="lstate" maxlength="10" value="${lbean.l_state }" style="width: 150">
		</td>
	</tr>
</table><br>
	<input type="button" class="btn2" value="전체 목록 " onClick="location.href='lostlist.lt?pageNumber=${pageNumber}'">
	<input type="reset" class="btn2" value="다시 작성">
	<input type="submit" class="btn3" value="수정" onClick="return writeSave()">
</form>
</div>
<%@ include file="../../adminbottom.jsp" %>