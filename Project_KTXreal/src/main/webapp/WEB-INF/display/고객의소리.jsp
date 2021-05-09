<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp" %>
<script>
	function vocsubmit(){
		location.href="vocwriteForm.vd";
	}
	function myvoc(){
		location.href="voclist.vd";
	}
</script>
<div class="content_ser">
	<div class="jsptitle" style="padding-bottom: 50;">
	<h3>VOC 이용안내</h3>
	</div>
	<div class="v_title">
		<h4>VOC 서비스를 쉽게 이용할 수 있도록 안내해드립니다.</h4><br>
			<a href="http://www.letskorail.com/ebizcom/event/korail/w_cus181129.do">코로나19에 따른 병원진료, 자가격리, 재택근무등으로 사용하지 못한 정기승차권 반환 및 N카드 기한연장 요청을 하실 고객께서는 여기를 눌러주시기 바랍니다.</a>
		<br><br>
		<hr></hr>
	</div>
	<div class="cs-center">
		<h2 class="c_tit">VOC 개요</h2>
		<ul>
			<li>한국철도는 고객님께서 서비스를 이용하시며 느끼신 불편한 점, 개선할 점 및 칭찬 등의 의견을 수렴하여 개선을 추진하고자 고객의
			<br>소리(이하 VOC)를 운영합니다. 단순 문의사항은 철도고객센터(1544-7788)로 문의하시면 빠르게 답변받으실 수 있습니다</li>
		</ul>
	</div>
	<div class="cs-center">
		<h2 class="c_tit">VOC 처리 예외</h2>
		<ul>
			<li>다음과 같은 경우는 ‘고객의 소리’로 보지 않습니다.(고객의 소리 운영 규정 제3조) </li>
			<li>행정기관 또는 공공단체가 특별히 정한 행위를 요구하는 사항(다만, 사경제의 주체로서 요구하는 경우는 제외)</li>
			<li>공사와 사법상의 계약관계에 있는 자가 계약과 관련하여 특별히 정한 행위를 요구하는 사항</li>
			<li>성명·주소 등이 분명하지 않은 자나 법인 또는 단체의 경우 명칭, 소재지, 대표자 등이 분명하지 않은 자가 요구하는 사항</li>
			<li>방송·신문·인터넷·모바일 등 언론매체에서 퍼온 글, 광고·선전, 상행위, 학업과제물, 욕설·비방·음해·인격침해 등 <br>
			불건전하고 폭력적인 내용을 위주로 하여 특별히 정한 행위를 요구하는 사항</li>
			<li>장난성 글 또는 요구내용이 막연하여 도저히 이행할 수 없거나 특정 지을 수 없는 경우</li>
			<li>※ 민원처리에 관한 법률 제21조(민원 처리의 예외)에 해당하는 사항</li>
		</ul>
	</div>
	<div class="cs-center">
		<h2 class="c_tit">담당부서</h2>
		<ul>
			<li>고객마케팅단 서비스혁신처 (업무시간 : 평일 09:00~18:00, 주말/공휴일 제외) </li>
			<li>주소 : 대전광역시 동구 중앙로 240</li>
			<li>공사와 사법상의 계약관계에 있는 자가 계약과 관련하여 특별히 정한 행위를 요구하는 사항</li>
			<li>팩스 : 02-361-8385</li>
			<li>대표 전화번호 : 042-472-5000 * 민원접수용 창구로는 활용되지 않습니다 </li>
		</ul>
	</div>
<br><br>
	<div class="vocbtn">
	<c:if test="${m_id eq 'admin'}">
		<input type="button" value="VOC목록" onClick="myvoc()" class="btn3" style="width: 100px;">&nbsp;
	</c:if>
	<c:if test="${m_id ne 'admin'}">
		<input type="button" value="VOC접수하기" onClick="vocsubmit()" class="btn3" style="width: 100px;">&nbsp;
		<input type="button" value="나의 VOC" onClick="myvoc()" class="btn3" style="width: 100px;">&nbsp;
	</c:if>
	</div>
</div>
<%@ include file="../../bottom.jsp" %>