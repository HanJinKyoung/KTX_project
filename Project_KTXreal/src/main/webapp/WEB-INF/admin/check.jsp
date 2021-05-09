<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../admintop.jsp" %>
<script src='<c:url value="/resources/js/check/checkad.js"/>' type="text/javascript" ></script>
	<body onLoad="showClock()">
		<div class="textcenter" style="padding-bottom: 150;">
			<form action="intimecheck.ad" method="post" id="check">
				<div class="span9">
					
					<div class="hero-unit">
						<div id="liveClock"></div>
						<br/><br/>
						<input type="image" src="./resources/imgs/출근.png" style="border:none; background:none; padding:0;"  value="출근" class="btn4 btn-primary btn-large span2 pull-right" 
						onClick="return incheck()" style="background: lightgreen; width: 150px;">
						<input type="hidden" value="${member.m_name }" name="c_name">
                        <input type="hidden" value="${member.m_num }" name="m_num">	
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="image" src="./resources/imgs/퇴근.png" value="퇴근" style="border:none; background:none; padding:0;" onfocus="this.blur()" onClick="return outcheck()" class="btn4 btn-primary btn-large span2 pull-right" style="background: orange; width: 150px;"">
					</div>
				</div>
			</form>
		</div>
	</body>
<%@ include file="../../adminbottom.jsp" %>