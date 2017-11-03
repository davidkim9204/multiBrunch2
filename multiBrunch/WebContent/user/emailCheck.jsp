<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리</title>
<script type = "text/javascript" src="script/user.js"></script>
</head>
<body>
	<h2>이메일주소 중복확인</h2>
	<form action = "emailCheck.do" method = "get" name = "frm">
	이메일주소 <input type = "text" name = "uEmail" value = "${uEmail}">
		<input type = "submit" value = "중복 체크">
	<br> 
		<c:if test="${result == 1 }">
			<script type = "text/javascript">
			opener.document.frm.uEmail.value="";
			</script>
			${uEmail}는 이미 사용중인 이메일주소입니다.
			<input type = "button" value = "사용" class = "cancel" onclick = "emailok()">
		</c:if>
	</form>
</body>
</html>
