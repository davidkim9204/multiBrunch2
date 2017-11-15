<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>음식메뉴 삭제</title>
<script type="text/javascript">

	function popmenudelete1() {
		if (confirm("메뉴 삭제합니당~^^") == true) { //확인
			document.menudelete.submit();

		} else { //취소
			return false;
		}
	}
</script>
</head>
<body>
<form name="menudelete" action="menudelete.do" method="get">
		음식 이름: &nbsp; <input type="text" name="mMenu"><br>
		식점 아뒤: &nbsp; <input type="text" name="rId"><br>
		<input type="submit" value="메뉴삭제" onclick="return popmenudelete1()">
	</form>
</body>
</html>