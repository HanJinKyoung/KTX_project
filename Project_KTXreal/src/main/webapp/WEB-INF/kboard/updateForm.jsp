<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %> 
<%@ include file="../../admintop.jsp" %>
<script src='<c:url value="/resources/js/jquery.js"/>' type="text/javascript" ></script>
<script src='<c:url value="/resources/js/kboard.js"/>' type="text/javascript" ></script>

<div class="textcenter">
	<div style="padding-bottom: 80; font-size: 30; font-weight: bold;">
	코레일 공지 수정하기
	</div>
<form method="post" name="writeForm" action="update.kbd">
<input type="hidden" name="pageNumber" value="${pageNumber}">
<input type="hidden" name="k_num" value="${kboard.k_num }">
	<table class="boardcontent">
		<tr>
			<th>작성자</th>
			<td>
			${kboard.k_writer}
			<input type="hidden" name="k_writer" id="kwriter"value="${kboard.k_writer }">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td class="td" style="text-align: left;padding: 0;">
				<input type="text" name="k_subject" id="ksubject" maxlength="100" value="${kboard.k_subject }">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td class="td">
				<textarea name="k_content" id="ct" rows="15" cols="70">${kboard.k_content }</textarea>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td class="td" style="text-align: left;padding: 0;">
				<input type="password" name="k_passwd" id="kpasswd" maxlength="10" style="width: 150;">
			</td>
		</tr>
	</table><br>
				<input type="button" class="btn2" value="전체 목록" onClick="location.href='klist.kbd?pageNumber=${pageNumber}'">
				<input type="reset" class="btn2" value="다시작성">
				<input type="submit" class="btn3" value="수정" onClick="return kupdate()">

</form>
</div>
<%@ include file="../../adminbottom.jsp" %>