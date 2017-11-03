<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shop.css">
<style>
	.logout{
		margin-right: 20.3%;	
	}
</style>
</head>
<body>
	<form action="logout.do" method="get" name="frm" align="right">
		<input type="button" value = "로그아웃 " class="logout" />
	</form>
	
	<div id="wrap" align="center">
		<h1>맛집 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="6" style="border: #000022; text-align: right"><a
					href="RestaurantServlet?command=Restaurant_write_form">맛집 등록</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>분류</th>
				<th>거리</th>
				<th>평점</th>
				<th>선택</th>
			</tr>
			<c:forEach var="Restaurant" items="${RestaurantList }">
				<tr class="record" align="center">
					<td width="40px">${Restaurant.rId }</td>
					<td width="350px"><a href="ReMeservlet.do?userid=${Restaurant.rId}">
							${Restaurant.rName } </a></td>
					<td width="78px">${Restaurant.rCategory}</td>
					<td width="78px">${Restaurant.rDistance} m</td>
					<td width="78px">${Restaurant.rRate } / 10</td>
					<td width="40px"><input type="checkbox" value="${Restaurant.rId }"/></td>
				</tr>
			</c:forEach>
		</table><br>
		<form action="compareservlet.do" method="get" name="frm" align="center">
			<input type="text" name="userid" value="1" hidden="true">
			<input type="submit" value = "비교하기 " class="compare3" />
		</form>
	</div>
</body>
</html>