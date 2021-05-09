<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %> 
<%@ include file="../../admintop.jsp" %>
<div class="mlist" style="width: 700">
	<div class="jsptitle">
	열차 목록 및 열차 정보
	</div>
	<div class="search" style="width: 700px">
	<form action="deleteTrain.tr" method="get">
		<div class="columnchk" style="float: right;">
		<select name="whatColumn">
			<option value="all">전체 검색
			<option value="t_num">열차번호
		</select>&nbsp;
		<input type="text" name="keyword" value="" class="keyword">&nbsp;&nbsp;
		<input type="submit" value="검색" class="searchbtn">
		</div>
	</form>
	</div>
	<table class="table table-hover" style="width: 700; padding: 10;">
		<thead>
			<tr>
			<th>열차번호</th>
			<th>열차종류</th>
			<th>운행노선</th>
			<th>좌석갯수</th>
			<th>삭제</th>
			</tr>
		</thead>
		<c:forEach items="${trainLists }" var="train"> 
			<tr>
				<td align="center">
					<a href="trainlist.tr?whatColumn=t_num&keyword=${train.t_num }">${train.t_num }</a>
				</td>
	 			<td>
					${train.t_type }
				</td>
				<td>
					${train.t_way }
				</td>
				<td>
					${train.t_count }
				</td>
				<td>
					<a href="deleteNum.tr?t_num=${train.t_num }">${train.t_num }호차 삭제</a>
				</td>
			</tr>		
		</c:forEach>
	</table><br><br>
		${pageInfo.pagingHtml }
</div>
	
<%@ include file="../../adminbottom.jsp" %>