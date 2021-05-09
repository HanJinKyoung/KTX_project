<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp" %>
<script src='<c:url value="/resources/js/member/member.js"/>'></script>
<div class="register_SM textcenter">
	<h2>회원 정보</h2>
	<hr color="gray"><br>
	<form:form commandName="memberBean" action="mypage.mem" method="post">
	<input type="hidden" name="m_num" value="${member.m_num }">
	<input type="hidden" name="m_grade" value="${member.m_grade }">
	<table style="border-spacing: 3px;">
		<tr>
			<td colspan="2" align="center">
				<font size="3" color="000000"><b>기본 정보 </b></font>
			</td>
		</tr>
		<tr>
			<td> 회원 아이디 </td>
			<td>
				${member.m_id }
				<input type="hidden" name="m_id" value="${member.m_id }">                         
			</td>
		</tr>
		<tr>
			<td>비밀 번호</td>
			<td>
			<input type="password" name="m_pw" value="${member.m_pw}">  
			<form:errors cssClass="err" path="m_pw"></form:errors></td>
		</tr>
		<tr>
			<td> 비밀 번호 확인</td>
			<td><input type="password" name="repassword" id="repassword">
				<span id="pwmessage" style="display:none;"></span></td>
		</tr>
		<tr>
			<td> E-Mail </td>
			<td>
				<input type="text" name="m_email" style="width: 250" value="${member.m_email}">  
				<br><form:errors cssClass="err" path="m_email"/>
			</td>
		</tr>
		<tr>
			<td> 이름 </td>
			<td> ${member.m_name }</td>
		</tr>
		<tr>
			<td> 나이 </td>
			<td>${member.m_age }</td>
		</tr>
		<tr>
			<td> 주소 </td>
			<td>
			<input type="text" name="m_addr" style="width: 300" value="${member.m_addr }">
			<br><form:errors cssClass="err" path="m_addr"/>
			</td>
		</tr>
		<tr>
			<td> 전화 번호 </td>
			<td>
				<input type="text" name="m_phone_1" size="3" style="width:50;height: 20;" value="${member.m_phone_1 }">
				- 
				<input type="text" name="m_phone_2" size="4" maxlength="4" style="width:50;height: 20;" value="${member.m_phone_2 }">
				- 
				<input type="text" name="m_phone_3" size="4" maxlength="4" style="width:50;height: 20;" value="${member.m_phone_3 }">
				<br>
				<form:errors cssClass="err" path="m_phone_1"/>
				<form:errors cssClass="err" path="m_phone_2"/>
				<form:errors cssClass="err" path="m_phone_3"/>
			</td>
		</tr>
	</table><br>
	<c:if test="${m_grade ne 'A'}">
	<input type="button" value="회원탈퇴" class="btn2" onclick="return del('${member.m_num}')">&nbsp;&nbsp;
	</c:if>
	<input type="button" value="취소" class="btn" onClick="javascript:history.go(-1)">&nbsp;&nbsp;
	<input type="submit" value="수정 하기" class="btn" id="sub">
	</form:form> 
</div>
<%@ include file="../../bottom.jsp" %>