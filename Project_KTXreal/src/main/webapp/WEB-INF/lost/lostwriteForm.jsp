<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../admintop.jsp" %>
<%@include file="../common/common.jsp"%>
<script src='<c:url value="/resources/js/lost/lost.js"/>'></script>
<div class="textcenter">
	<div class="jsptitle">
	유실물 등록
	</div>
<form method="post" action="lostwrite.lt" enctype="multipart/form-data">
	<table class="boardcontent">
		<tr>
			<th style="width: 130;">유실물 품목명</th> 
			<td class="td" style="text-align: left; padding: 0;">
				<input type="text" name="l_name" maxlength="10" id="l_name">
			</td>
		</tr>
		<tr>
			<th>습득장소</th> 
			<td class="td" style="text-align: left; padding: 0;">
				<input type="text" name="l_content" maxlength="15" id="lcontent">
			</td>
		</tr>
		<tr>
			<th>첨부이미지</th>
			<td class="td" style="text-align: left; padding: 0;">
  		  		<input type="file" name="upload" id="l_image" style="width: 300;">
			</td>
		</tr>
		<tr>
			<th>처리상태</th>
			<td>
				대기
				<input type="hidden" name="l_state" value="대기">
			</td>
		</tr>
	</table><br><br>
				<input type="button" class="btn2" value="전체 목록 " onClick="location.href='lostlist.lt?pageNumber=${pageNumber}'">
				<input type="reset" class="btn2" value="다시 작성">
				<input type="submit" class="btn3" value="등록" onClick="return writeSave()">
</form>
</div>
<%@ include file="../../adminbottom.jsp" %>