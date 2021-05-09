<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp" %>
<%@ include file="./../common/common.jsp" %>
<script src='<c:url value="/resources/js/member/register.js"/>'></script>
<div class="register_SM">
	<h2>회원가입(직원용)</h2>
	<p align="right"><font size="2em" color="red">*표가 있는 곳은 필수입력 칸입니다</font></p>
	<hr color="gray"><br>
	<form:form commandName="memberBean" action="register_S.mem" method="post" id="myform">
	<input type="hidden" name="cnt" id="cnt" value="${cnt }">
	<table>
		<tr>
			<td colspan="2" align="center">
				<font size="3" color="000000"><b>기본 정보 </b></font>
			</td>
		</tr>
		<tr>
			<td> * 회원 아이디 </td>
			<td>
				<input type="hidden" name="m_grade" value="S"><!-- 회원등급 : S -->
				<input type="text" name="m_id" id="mid" value="${member.m_id}" onkeydown="checkSpacebar();">                         
				<input type="submit" class="searchbtn" id="idcheck" style="vertical-align: baseline;" value="중복체크" onClick="return duplicateS()"/>
				<div id="check" >${check }</div>
				<form:errors cssClass="err" path="m_id"/>  
			</td>
		</tr>
		<tr>
			<td> * 비밀 번호</td>
			<td>
				<input type="password" name="m_pw" value="${member.m_pw }">
				<br><form:errors cssClass="err" path="m_pw"/>
			</td>
		</tr>
		<tr>
			<td> * 비밀 번호 확인</td>
			<td>
				<input type="password" name="repassword" id="repassword" value="${repassword }">
				<span id="pwmessage" style="display:none;"></span>
			</td>
		</tr>
		<tr>
			<td> * E-Mail </td>
			<td>
				<input type="text" name="m_email" style="width: 250" placeholder="ex)korail99@korail.com" value="${member.m_email }"> 
				<br><form:errors cssClass="err" path="m_email"/>
			</td>
		</tr>
	</table><br><br>
	<table>
		<tr>
			<td colspan="2" align="center">
				<font size="3" color="000000"><b>개인 신상 정보</b></font>
			</td>
		</tr>
		<tr>
			<td>* 이름</td>
			<td>
			<input type="text" name="m_name" value="${member.m_name }" >
			<br><form:errors cssClass="err" path="m_name"/>
			</td>
		</tr>
		<tr>
			<td>* 나이</td>
			<td>
			<input type="text" name="m_age" placeholder="ex)35" value="${member.m_age}" maxlength="3">
			<br><form:errors cssClass="err" path="m_age"/>
			</td>
		</tr>	
		<tr>
			<td>* 주소</td>
			<td>
			<input type="text" name="m_addr" style="width: 300" placeholder="ex)대전광역시 동구 중앙로 240,9동 10호" value="${member.m_addr}">
			<br><form:errors cssClass="err" path="m_addr"/>
			</td>
		</tr>
		<tr>
			<td>* 휴대폰 번호</td>
			<td>
				<input type="text" name="m_phone_1" size="3" maxlength="3" style="width:50;height: 25;" value="${member.m_phone_1 }">
				- 
				<input type="text" name="m_phone_2" size="4" maxlength="4" style="width:50;height: 25;" value="${member.m_phone_2 }"> 
				- 
				<input type="text" name="m_phone_3" size="4" maxlength="4" style="width:50;height: 25;"value="${member.m_phone_3 }">
				<br>
				<form:errors cssClass="err" path="m_phone_1"/>
				<form:errors cssClass="err" path="m_phone_2"/>
				<form:errors cssClass="err" path="m_phone_3"/>
			</td>
		</tr>
	</table><br>
	<hr color="gray">
	<div class="registetbtn">
	<input type="button" value="취소" class="btn2" onClick="location.href='register.mem'">
	<input type="reset" value="작성 취소" class="btn2" id="sub">
	<input type="submit" value="가입 하기" class="btn3" id="sub" onClick="return writeSave()">
	</div>
	</form:form> 
</div>
<%@ include file="../../bottom.jsp" %>