<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../top.jsp" %>
<script src="resources/js/magnify.js"></script>
<script type="text/javascript">
$(function(){ 
	magnify("myimage", 3);
});
</script>
<div class="content_ser">
	<div class="jsptitle" style="padding-bottom: 50;">
		<h3>철도 노선 안내</h3>
	</div>
	<div class="map">
		마우스를 지도위에 올려보세요
	<hr></hr>
	</div>
	<div class="img-magnifier-container">
		<img id="myimage" src= "resources/imgs/철도노선.jpg" usemap="#map_foot" width="100%">
	</div>
</div>
<%@ include file="../../bottom.jsp" %>