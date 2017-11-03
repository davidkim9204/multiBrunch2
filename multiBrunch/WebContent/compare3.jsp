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
</head>
<body>

	<form action="logout.do" method="get" name="frm" align="right">
		<input type="button" value="로그아웃" class="logout">
	</form>

	<div id="compare" align="center">
		<h1>식당 3개 비교</h1>
		<form method="get" enctype="multipart/form-data" name="frm">
			<table>
				<tr>
					<th></th>
					<th><input type="button" id="c1" value="선택1"></th>
					<th><input type="button" id="c2" value="선택2"></th>
					<th><input type="button" id="c3" value="선택3"></th>
				</tr>

				<tr>
					<th>레스토랑 이름</th>
					<td>${Restaurant.rName}</td>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<th>메뉴&사진</th>
					<td>${Menu[0].mName}${Menu[0].mPicture1}<br>
					${Menu[1].mName}${Menu[1].mPicture1}<br>
					${Menu[2].mName}${Menu[2].mPicture1}</td>
					<td></td>
					<td></td>
					
				</tr>

				<tr>
					<th>멀캠으로부터 거리</th>
					<td>${Restaurant.rDistance}</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>레스토랑 평점</th>
					<td>${Restaurant.rRate}</td>
					<td></td>
					<td></td>
				</tr>

			</table>

			<br> <br> <input type="button" id="back" value="이전페이지">

		</form>


	</div>
	<%-- 	이름:${Restaurant.rname} --%>
	<%-- 	<br> 사진:${Menu[0].mpicture1} --%>
	<%-- 	<br> 메뉴:${Menu[0].mname} --%>
	<%-- 	<br> 사진:${Menu[1].mpicture1} --%>
	<%-- 	<br> 메뉴:${Menu[1].mname} --%>
	<%-- 	<br> 사진:${Menu[2].mpicture1} --%>
	<%-- 	<br> 메뉴:${Menu[2].mname} --%>
	<%-- 	<br> 거리:${Restaurant.rdistance} --%>
	<%-- 	<br> 평점:${Restaurant.rrate} --%>
	<!-- 	<br> -->
</body>
</html>