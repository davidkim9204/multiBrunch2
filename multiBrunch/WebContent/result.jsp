<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="list">
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
				<td width="350px"><a
					href="ReMeservlet.do?userid=${Restaurant.rId}">
						${Restaurant.rName } </a></td>
				<td width="78px">${Restaurant.rCategory}</td>
				<td width="78px">${Restaurant.rDistance} m</td>
				<td width="78px">${Restaurant.rRate } / 10</td>
				<td width="40px"><input type="checkbox"
					value="${Restaurant.rId }" /></td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>