<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
    if (session.getAttribute("loginUser") == null) {
        response.sendRedirect("login.do");
    }
%>
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
		<h1>맛집 상세보기</h1>
		<table>
			<tr>
				<th>작성자</th>
				<td>${Restaurant.name}</td>
				<th>이메일</th>
				<td>${Restaurant.email}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${Restaurant.writedate}" /></td>
				<th>조회수</th>
				<td>${Restaurant.readcount }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${Restaurant.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${Restaurant.content }</pre></td>
			</tr>
		</table>
		<br> <br> <input type="button" value="게시글 수정"
			onclick="open_win('RestaurantServlet?command=Restaurant_check_pass_form&num=${Restaurant.num}', 'update')">
		<input type="button" value="게시글 삭제"
			onclick="open_win('RestaurantServlet?command=Restaurant_check_pass_form&num=${Restaurant.num}', 'delete')">
		<input type="button" value="게시글 리스트"
			onclick="location.href='RestaurantServlet?command=Restaurant_list'"> 
		<input type="button" value="게시글 등록"
			onclick="location.href='RestaurantServlet?command=Restaurant_write_form'">
	
	
		<form action="RestaurantServlet" method="post">
			<input type="hidden" name="command" value="commentWrite">
			<input type="hidden" name="RestaurantNum" value="${Restaurant.num}">
			<table width="900px">
				<tr>
					<td align="center" width="70%">내용</td>
					<td align="center" width="20%">작성자</td>
					<td align="center" width="10%"></td>
				</tr>
				<tr>
					<td align="center"><input style="width:95%" 
					type="text" name="content"></td>
					<td align="center"><input style="width:95%" 
					type="text" name="writer"></td>
					<td align="center"><input type="submit" 
					value="등록"></td>
				</tr>
				<c:forEach items="${commentList }" var="comment">
					<tr>
						<td>${comment.num } : ${comment.content } </td>
						<td> ${comment.writer }</td>
						<td align="center">
						<a href="RestaurantServlet?command=commentDelete&cId=${comment.id }&RestaurantNum=${Restaurant.num}">
						삭제</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
		
		
		
		
		
		
	
	
	</div>
	
	
	
</body>
</html>