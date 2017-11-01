<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shop.css">
<script type="text/javascript" src="script/Restaurant.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>맛집 등록</h1>
		<form name="frm" method="post" action="RestaurantServlet">
			<input type="hidden" name="command" value="Restaurant_write"> <input
				type="hidden" name="num" value="${Restaurant.rId}">
			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" size="70" name="rName"
						value="${Restaurant.rName}"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" size="70" name="rAddress"
						value="${Restaurant.rAddress}"></td>
				</tr>
				<tr>
					<th>거리</th>
					<td><input type="text" size="70" name="rDistance"
						value="${Restaurant.rDistance}"></td>
				</tr>
				<tr>
					<th>운영시간</th>
					<td><input type="text" size="70" name="rOpenhours"
						value="${Restaurant.rOpenhours}"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" size="70" name="rTel"
						value="${Restaurant.rTel}"></td>
				</tr>
				<tr>
					<th>평점</th>
					<td><input type="text" size="70" name="rRate"
						value="${Restaurant.rRate}"></td>
				</tr>
				<tr>
					<th>분류</th>
					<td><input type="text" size="70" name="rCategory"
						value="${Restaurant.rCategory}"></td>
				</tr>


			</table>
			<br>
			<br> <input type="submit" value="등록"
				onclick="return RestaurantCheck()"> <input type="reset"
				value="다시 작성"> <input type="button" value="목록"
				onclick="location.href='RestaurantServlet?command=Restaurant_list'">
		</form>
	</div>
</body>
</html>