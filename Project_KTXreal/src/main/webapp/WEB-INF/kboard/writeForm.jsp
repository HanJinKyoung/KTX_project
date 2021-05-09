<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %> 
<%@ include file="../../admintop.jsp" %>
<script src='<c:url value="/resources/js/kboard.js"/>' type="text/javascript" ></script>

<div class="textcenter">
	<div class="jsptitle">
	Korail 공지 등록
	</div>
<form name="writeform" method="post" action="write.kbd">
	<table class="boardcontent">
		<tr>
			<th>작성자</th> 
			<td>
				관리자
				<input type="hidden" name="k_writer" value="관리자">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td class="td" style="text-align: left;padding: 0;">
				<input type="text" name="k_subject" maxlength="100" id="ksubject">
			</td>
		</tr>
		<tr>
			<th colspan="2">내용</th> 
		</tr>
		<tr>
			<td class="td" colspan="2">
				<textarea name="k_content" cols="80" rows="15" id="kcontent"></textarea>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th> 
			<td class="td" style="text-align: left;padding: 0;">
				<input type="password" name="k_passwd"  maxlength="10" id="kpasswd" style="width: 150;">
			</td>
		</tr>
	</table><br>
				<input type="button" class="btn2" value="전체 목록 " onClick="location.href='klist.kbd?pageNumber=${pageNumber}'">
				<input type="reset" class="btn2" value="다시 작성">
				<input type="submit" class="btn3" value="새 공지 등록" onClick="return kwriteSave()">
</form>
</div>
<%@ include file="../../adminbottom.jsp" %>