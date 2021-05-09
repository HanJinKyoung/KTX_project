<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>  
<%@ include file="../../admintop.jsp" %>
<script src='<c:url value="/resources/js/inboard.js"/>' type="text/javascript" ></script>
<div class="textcenter">
	<div class="jsptitle">
	사내공지 수정
	</div>
<form method="post" name="updateForm" action="inupdate.ib" enctype="multipart/form-data">
<input type="hidden" name="pageNumber" value="${pageNumber}">
<input type="hidden" name="i_num" value="${inboard.i_num }">
	<table class="boardcontent">
		<tr>
			<th>작성부서</th> 
			<td class="td" style="text-align: left; padding: 0;">
				<input type="text" name="i_writer" id="iwriter" maxlength="20" value="${inboard.i_writer }" style="width: 150;">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td class="td" style="text-align: left; padding: 0;">
				<input type="text" name="i_subject" id="isubject" maxlength="100" value="${inboard.i_subject }">
			</td>
		</tr>
		<tr>
			<th colspan="2">내용</th>
		</tr>
		<tr>
			<td class="td" colspan="2">
				<textarea name="i_content" id="icontent" rows="15" cols="80">${inboard.i_content }</textarea>
			</td>
		</tr>
		<tr>
			<th rowspan="2">첨부이미지</th>
			<td>
				<img src="<%=request.getContextPath() %>/resources/upload/${inboard.i_filename}" width="150px" style="padding: 10;" onError="this.style.visibility='hidden'">
				[현재이미지 : ${inboard.i_filename}]
			</td>
		</tr>
		<tr>
			<td class="td" style="text-align: left; padding: 0;">
				<input type="file" name="uploadFile">
				<input type="hidden" name="i_preuploadFile" value="${inboard.i_filename}">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th> 
			<td class="td" style="text-align: left; padding: 0;">
				<input type="password" name="i_passwd" id="ipasswd" maxlength="10" style="width: 150;">
			</td>
		</tr>
	</table><br>
	<input type="button" class="btn2" value="전체 목록" onClick="location.href='inlist.ib?pageNumber=${pageNumber}'">
	<input type="reset" class="btn2" value="다시작성">
	<input type="submit" class="btn3" value="수정" onClick="return inUpdate()">
</form>
</div>
<%@ include file="../../adminbottom.jsp" %>
