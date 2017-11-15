<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메뉴수정</title>
<script type="text/javascript">

	function popmenumodify1() {
		if (confirm("메뉴 수정합니당~^^") == true) { //확인
			document.menumodify.submit();

		} else { //취소
			return false;
		}
	}
</script>
</head>
<body>
<form name="menumodify" action="menumodify.do" method="get">
		메뉴 아이디: &nbsp; <input type="text" name="mId"><br>
		식점 아뒤: &nbsp; <input type="text" name="rId"><br>
		음식 이름: &nbsp; <input type="text" name="mMenu"><br>
		음식 가격: &nbsp; <input type="text" name="mPrice"><br>
		음식 그림1: <input type="text" name="mPicture1"><br>
		음식 그림2: <input type="text" name="mPicture2"><br>
		<input type="submit" value="메뉴수정" onclick="return popmenumodify1()">
	</form>


</body>
</html>