<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:if test="${empty loginUser}">
	<jsp:forward page="login.do"></jsp:forward>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리</title>
<script type="text/javascript" src="../script/user.js"></script>
</head>
<body>
	<h2>회원 전용 페이지</h2>
	<form action="logout.do">
	<table>
	<tr>
		<td>안녕하세요. ${loginUser.uName}(${loginUser.uEmail})님</td>
	</tr>
	<tr>
		<td colspan = "2" align = "center">
			<input type="submit" value="로그아웃">&nbsp;&nbsp;
			<input type="button" value ="회원정보변경"
				onclick="location.href = 'userUpdate.do?uEmail=${loginUser.uEmail}'">
		</td>
	</tr>
	</table>
	</form>
</body>
</html>