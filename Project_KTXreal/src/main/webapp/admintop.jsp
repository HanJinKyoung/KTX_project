<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/common/common.jsp" %>
<link rel="stylesheet" type="text/css" href="resources/css/newstyle.css"/>
<script type="text/javascript" src="./resources/js/jquery.js"></script>
<script type="text/javascript" src="./resources/js/menu.js"></script>
<c:if test="${m_grade eq'S'}">
<script type="text/javascript" src="./resources/js/admin.js"></script>
</c:if>
<title>Let's_Korail</title>  
<body style="background: url(resources/imgs/korail_img/body_bg.gif) repeat-x;">
<div class="header">
	<div class="htop">
		<div class="top_menu">
			<a href="admin.jsp">홈</a>&nbsp;|&nbsp;
			<b>${m_id}님</b>
			<a href="<%=request.getContextPath() %>/logout.mem">로그아웃</a>&nbsp;│&nbsp;
			<a href="main.jsp">홈페이지</a>&nbsp;│&nbsp;
		</div>
	</div>
	<div class="htitle">
		<div>
			<a href="admin.jsp">
			<img src="resources/imgs/lets_logo.gif">
			</a>
		</div>
	</div>
	<div class="hbottom">
		<nav class="slide_menu">
			<ul>
	            <li>
	            <a class="topNav">열차관리</a>
	               	<ul class="subNav">
	                   	<li><a href="<%=request.getContextPath()%>/trainlist.tr">열차조회</a></li>
                        <li><a href="<%=request.getContextPath()%>/insert.tr" onclick="return server()">열차등록(A)</a></li>
                        <li><a href="<%=request.getContextPath()%>/deleteTrain.tr" onclick="return server()">열차삭제(A)</a></li>
	               	</ul>
	            </li>
	            <li>
	            <a class="topNav">회원관리</a>
	            	<ul class="subNav">
	     	    	   	<li><a href="<%=request.getContextPath()%>/list.mem">회원조회/관리</a></li>
	            	</ul>
	            </li>
	            <li>
	            <a class="topNav">공지사항</a>
	               	<ul class="subNav">
	                   	<li><a href="<%=request.getContextPath()%>/inlist.ib">사내공지</a></li>
	                   	<li><a href="<%=request.getContextPath()%>/klist.kbd">코레일 공지</a></li>
	               		<li><a href="<%=request.getContextPath()%>/voclist.vd" onclick="return server()">1:1 QnA(A)</a></li>
	               	</ul>
	            </li>
	            <li>
	            <a class="topNav">근태관리</a>
                   <ul class="subNav">
                         <li><a href="<%=request.getContextPath()%>/check.ad">출퇴근관리</a></li>
                       <li><a href="<%=request.getContextPath()%>/checklist.ad">출퇴근내역</a></li>
                   </ul>
	            </li>
	       	</ul>
		</nav>
	</div>
</div>
<div class="content" style="background: url(resources/imgs/tra_visual12.jpg) no-repeat right top 8px;">