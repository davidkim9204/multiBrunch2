<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 700px;
}

h1 {
	font-size: 20px;
	color: blue;
}
</style>
</head>
<body>
	<table class="table" border="2" align="center">
		<caption>
			<h1>음식점 상세 설명<h1>
		</caption>
		<tbody align="center">
			<tr>
				<td>이름</td>
				<td colspan="3">데이터2</td>
			</tr>
			<tr>
				<td>사진</td>
				<td>데이터2</td>
				<td>데이터3</td>
				<td>데이터4</td>
			</tr>
			<tr>
				<td>메뉴</td>
				<td colspan="3">데이터2</td>
			</tr>
			<tr>
				<td>평점</td>
				<td>데이터2</td>
				<td>거리</td>
				<td>데이터2</td>
			</tr>
			<tr>
				<td>댓글</td>
				<td colspan="2">데이터2</td>
				<td>별점</td>
			</tr>
		</tbody>
	</table>



	<%-- <c:forEach var="menu" items="${menulist}">
메뉴 아이디:${menu.mId}<br>
메뉴 이름:${menu.mName}<br>
메뉴 그림1:${menu.mPicture1}<br>
메뉴 그림2:${menu.mPicture2}<br>
메뉴 가격:${menu.mPrice}<br>
<br>
</c:forEach>
<br>
음식점 아이디:${Restaurant.rName}<br>
음식점 제목:${Restaurant.rAddress}<br>
음식점 출판사:${Restaurant.rDistance}<br>
음식점 오픈시간:${Restaurant.rOpenHours}<br>
음식점 전번:${Restaurant.rTel}<br>
음식점 평판:${Restaurant.rRate}<br>
음식점 목록:${Restaurant.rCategory}<br> --%>

</body>
</html>