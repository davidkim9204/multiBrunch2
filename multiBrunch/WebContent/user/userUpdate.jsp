<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리</title>
<script type = "text/javascript" src = "script/user.js"></script>
</head>
<body>
	<h2>회원 수정	</h2>
	<form action="userUpdate.do" method = "post" name ="frm">
	<table>
	
	<tr>
		<td> 이름 </td>
		<td><input type = "text" name = "uName" size = "20"></td>
	</tr>
	<tr>
		<td> 이메일 </td>
		<td>
		<input type = "text" name = "uEmail" size = "20" id = "uEmail" value = "${uVo.uEmail}" readonly>
		</td>
	</tr>
	<tr>
	<td>암 호 </td>
	<td><input type = "password" name ="uPassword" size = "20">*</td>
	</tr>
	<tr height = "30">
		<td width="80">암호 확인</td>
		<td><input type = "password" name = "uPassword_check" size = "20">*</td>
	</tr>
	<tr>
		<td>성별 </td>
		<td><input type = "radio" name = "uGender" value = "male" checked = "checked">남자
		<input type = "radio" name = "uGender" value = "female">여자</td>
	</tr>
	<tr>
		<td>나이 </td>
		<td><input type = "text" name = "uAge" size = "20"></td>
	</tr>		
	<tr>
		<td>선호 </td>
		<td><input type = "checkbox" name = "uPreference" value = "kor" checked = "checked">한식
		<input type = "checkbox" name = "uPreference" value = "jp">중식
		<input type = "checkbox" name = "uPreference" value = "ch">일식
		<input type = "checkbox" name = "uPreference" value = "wf">양식		
		</td>
	</tr>
	
	<tr>
		<td colspan = "2" align = "center">
		<input type = "submit" value = "확인" onclick = "return joinCheck()">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type = "reset" value = "취소">
		</td>
		</tr>
	</table>
	</form>
</body>
</html>