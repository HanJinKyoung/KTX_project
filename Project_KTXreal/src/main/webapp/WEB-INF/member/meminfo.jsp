<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<%@ include file="../../admintop.jsp" %>
<div class="register_SM textcenter" style="width: 400;">
	<h2>회원 정보</h2>
	<hr color="gray"><br>
	<form action="meminfo.mem" method="post">
	<input type="hidden" name="m_num" value="${member.m_num }">
	<table style="border-spacing: 3px;">
		<tr>
			<td> 회원 아이디 </td>
			<td>
				${member.m_id }
			</td>
		</tr>
		<tr>
			<td> E-Mail </td>
			<td>
				${member.m_email}
			</td>
		</tr>
		<tr>
			<td> 이름 </td>
			<td>
			<c:if test = "${m_grade == 'A'}">
			<input type="text" name="m_name" value="${member.m_name }">
			</c:if>
			<c:if test = "${m_grade == 'S'}">
			${member.m_name }
			</c:if>
			</td>
		</tr>
		<tr>
			<td> 나이 </td>
			<td>${member.m_age }</td>
		</tr>
		<tr>
			<td> 주소 </td>
			<td>${member.m_addr }</td>
		</tr>
		<tr>
			<td> 전화 번호 </td>
			<td>${member.m_phone_1 } - ${member.m_phone_2 }	- ${member.m_phone_3 }</td>
		</tr>
	</table><br>
	<c:if test = "${m_grade == 'A'}">
	<input type="submit" value="수정 하기" class="btn3" id="sub">&nbsp;&nbsp;
	</c:if>
	<input type="button" value="확인" class="btn2" onClick="javascript:history.go(-1)">
</form>
</div>
<%@ include file="../../adminbottom.jsp" %>