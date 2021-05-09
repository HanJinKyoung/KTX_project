<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
<%@ include file="../../admintop.jsp" %>
<script src='<c:url value="/resources/js/inboard.js"/>' type="text/javascript" ></script>
<div class="textcenter">
	<div class="jsptitle">
	사내 공지 등록
	</div>
<form name="writeform" method="post" action="inwrite.ib" enctype="multipart/form-data">
	<table class="boardcontent">
		<tr>
			<th>작성부서</th> 
			<td class="td" style="text-align: left; padding: 0;">
				<input type="text" name="i_writer" id="iwriter" maxlength="20" value="인사관리팀" style="width: 150;">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td class="td" style="text-align: left; padding: 0;">
				<input type="text" name="i_subject" id="isubject" maxlength="100">
			</td>
		</tr>
		<tr>
			<th colspan="2">내용</th> 
		</tr>
		<tr>
			<td class="td" colspan="2">
				<textarea name="i_content" cols="80" rows="15" id="icontent" rows="15"></textarea>
			</td>
		</tr>
		<tr>
			<td width="100" align="center">첨부파일</td>
			<td class="td" style="text-align: left; padding: 0;">
				<input type="file" name="uploadFile" style="width: 300;">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th> 
			<td class="td" style="text-align: left; padding: 0;">
				<input type="password" name="i_passwd" id="ipasswd" maxlength="10" style="width: 150;">
			</td>
		</tr>
	</table><br>
				<input type="button" class="btn2" value="전체 목록 " onClick="location.href='inlist.ib?pageNumber=${pageNumber}'">
				<input type="reset" class="btn2" value="다시 작성">
				<input type="submit" class="btn3" value="새 공지 등록" onClick="return inwriteSave()">
</form>
</div>
<%@ include file="../../adminbottom.jsp" %>
