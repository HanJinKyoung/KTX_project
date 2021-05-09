<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/common/common.jsp" %>
<link rel="stylesheet" type="text/css" href="resources/css/newstyle.css"/> 
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="./resources/js/menu.js"></script>
<c:if test="${m_grade eq'A' || m_grade eq'S'}">
<script type="text/javascript" src="./resources/js/admin.js"></script>
</c:if>
<title>Let's_Korail</title>  
<body style="background: url(resources/imgs/korail_img/body_bg.gif) repeat-x;">
<div class="header">
	<div class="htop">
		<div class="top_menu">
			<a href="main.jsp">홈</a>&nbsp;|&nbsp;
			<c:if test="${m_id eq null}">
			<a href="<%=request.getContextPath() %>/login.mem">로그인</a>&nbsp;│&nbsp;
			</c:if>
			<c:if test="${m_id ne null}">
			<b>${m_id}님</b>
			<a href="<%=request.getContextPath() %>/logout.mem">로그아웃</a>&nbsp;│&nbsp;
			</c:if>
			<a href="<%=request.getContextPath() %>/tklist.tk" onclick="return admin()">장바구니</a>&nbsp;│&nbsp;
			<a href="<%=request.getContextPath() %>/mypage.mem">마이페이지</a>&nbsp;│&nbsp;
			<a href="<%=request.getContextPath() %>/serviceCenter.dis">고객센터</a>&nbsp;│&nbsp;
			<c:if test="${m_grade eq'A' || m_grade eq'S'}">
			<a href="admin.jsp">관리자 페이지</a>&nbsp;│&nbsp;
			</c:if>
		</div>
	</div>
	<div class="htitle">
		<div>
			<a href="main.jsp">
			<img src="resources/imgs/lets_logo.gif">
			</a>
		</div>
	</div>
	<div class="hbottom">
		<nav class="slide_menu">
			<ul>
	            <li>
	            <a class="topNav">예매하기</a>
	               	<ul class="subNav">
	                   	<li><a href="<%=request.getContextPath()%>/trainbook.tr" onclick="return admin()">일반승차권</a></li>
	                   	<li><a href="<%=request.getContextPath()%>/tklist.tk" onclick="return admin()">발권/취소/변경</a></li>
	               	</ul>
	            </li>
	            <li>
	            <a class="topNav">이용안내</a>
	            	<ul class="subNav">
	     	    	   	<li><a href="<%=request.getContextPath()%>/승차권이용안내.dis">승차권 이용안내</a></li>
	     	    	   	<li><a href="<%=request.getContextPath()%>/trainlist.tr">열차운임 및 시간표</a></li>
	            	</ul>
	            </li>
	            <li>
	            <a class="topNav">공지사항</a>
	               	  <ul class="subNav">
                        <li><a href="<%=request.getContextPath()%>/lost.dis">유실물</a></li>
                      	<li><a href="<%=request.getContextPath()%>/voc.dis" onclick="return admin()">고객의 소리</a></li>
                        <li><a href="<%=request.getContextPath()%>/klist.kbd" onclick="return admin()">코레일 공지</a></li>
                     </ul>
	            </li>
	            <li>
	            <a class="topNav">기차역정보/노선도</a>
	                <ul class="subNav">
	                   	<li><a href="<%=request.getContextPath()%>/기차역안내.dis">기차역 안내</a></li>
	                    <li><a href="<%=request.getContextPath()%>/railway_rotue.dis">노선안내</a></li>
	                </ul>
	            </li>
	       	</ul>
		</nav>
	</div>
</div>
<div class="content" style="background: url(resources/imgs/tra_visual12.jpg) no-repeat right top 8px;">