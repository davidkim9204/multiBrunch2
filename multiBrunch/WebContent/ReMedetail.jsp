<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
    if (session.getAttribute("loginUser") == null) {
        response.sendRedirect("login.do");
    }
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=TQHL3aV0s7CKyPelavqy&callback=initMap"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<style>
table {
	border: 1px solid #bcbcbc;
	width: 100%;
	height: 100px;
	text-align: center;
}

td {
	border: 1px solid #444444;
	font-size: 15px;
	height: 150px;
}

h1 {
	text-align: center;
	font-size: 25px;
}

img {
	width: 150px;
	height: 150px;
}
</style>
</head>
<body>

	<form action="btn.do" method="get" align="right">
		<input type="submit" value="로그아웃" name=Restaurant.rId+1> <input
			type="submit" value="수정" name=Restaurant.rId+2>
			<a href="RestaurantServlet?command=Restaurant_update_form">수정</a>
			 <input
			type="submit" value="삽입" name=Restaurant.rId+3> <input
			type="submit" value="삭제" name=Restaurant.rId+4>
	</form>
	<h1>음식 상세페이지</h1>
	<table align="center">
		<tr>
			<td>이름</td>
			<td colspan="3">${Restaurant.rName}</td>
		</tr>
		<tr>
			<td id="p">사진</td>
			<c:forEach var="menu" items="${menulist}">
				<td><img src="${menu.mPicture1}"></td>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td>메뉴</td>
			<td colspan="3"><c:forEach var="menu" items="${menulist}">
						${menu.mName}<br>
				</c:forEach></td>
		</tr>
		<tr>
			<td>평점</td>
			<td>${Restaurant.rRate}</td>
			<td>거리</td>
			<td>${Restaurant.rDistance}KM</td>
		</tr>
		<tr>
			<td>댓글</td>
			<td colspan="2"><c:forEach var="comment" items="${commentlist}">
						${comment.cContents}<br>
				</c:forEach></td>
			<td><c:forEach var="comment" items="${commentlist}">
					<c:choose>
						<c:when test="${comment.cRate eq 1}">
							        ★☆☆☆☆<br>
						</c:when>

						<c:when test="${comment.cRate eq 2}">
							        ★★☆☆☆<br>
						</c:when>

						<c:when test="${comment.cRate eq 3}">
	        					★★★☆☆<br>
						</c:when>

						<c:when test="${comment.cRate eq 4}">
	        					★★★★☆<br>
						</c:when>

						<c:when test="${comment.cRate eq 5}">
	        					★★★★★<br>
						</c:when>
					</c:choose>
				</c:forEach>
		</tr>
		<tr>
			<td>댓글쓰기</td>
			<td>
				<form action="commentwrite.do" method="get">
					아이디&nbsp;<input type="text" name="uId"><br>
					내&nbsp;&nbsp; 용&nbsp;<input type="text" name="comment"><br>
					평&nbsp;&nbsp; 점&nbsp;<input type="text" name="Rate"><br>
					<input type="hidden" name="rName" value="${Restaurant.rId}">
					<input type="submit" value="댓글달기">
				</form>
			</td>
		</tr>
		<tr>

		</tr>

	</table>
	<div id="map" style="width: 600px; height: 400px; align: center;">
		<script>
			var map = null;
		
			function initMap() {
				map = new naver.maps.Map('map', {
					center : new naver.maps.LatLng(37.504298, 127.039659),
					zoom : 10
				});
			}
		</script>
	</div>

</body>
</html>