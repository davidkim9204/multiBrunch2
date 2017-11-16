<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 820px;
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	border-left: 3px solid #8c6c0c;
	margin: 20px 200px;
}

th {
	width: 440px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #153d73;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

td {
	width: 400px;
	padding: 12px;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

/* table { */
/* 	border: 1px solid #bcbcbc; */
/* 	width: 100%; */
/* 	height: 100px; */
/* 	text-align: center; */
/* 	margin:100px; */
/* } */

/* td { */
/* 	border: 1px solid #444444; */
/* 	font-size: 15px; */
/* 	height: 150px; */
/* } */
h1 {
	text-align: center;
	font-size: 25px;
}

img {
	width: 150px;
	height: 150px;
}

#mi {
	position: absolute;
	right: 170px;
}

#md {
	position: absolute;
	right: 30px;
}

#mf {
	position: absolute;
	right: 100px;
}
</style>
<script type="text/javascript">
	var temp = null;
	function popdelete() {
		if (confirm("정말 지울거니??") == true) { //확인
			document.del.submit();

		} else { //취소
			return false;
		}
	}
	function popComment() {
		// 		var CM=document.getElementById("comment").value;
		// 		var RT=document.getElementById("RT").value;
		// 		alert(RT);
		var CM = document.getElementById("comment").value;
		var RT = document.getElementById("RT").value;

		if (CM == "") {
			alert("코멘트가 없네영");
			return false
		} else if (RT == "") {
			alert("평점 정보가 없네영");
			return false;
		} else {
			if (confirm("댓글달거 맞죠??") == true) { //확인
				document.Com.submit();
			} else {
				return false;
			}
		}
	}

	//------------------------메뉴 수정,삽입,삭제 버튼------------------------------
	function popmenuinsert() {
		if (confirm("메뉴를 추가하시겠습니까?") == true) { //확인
			document.menuinsert.submit();

		} else { //취소
			return false;
		}
	}
	function popmenudelete() {
		if (confirm("메뉴를 삭제하시겠습니까?") == true) { //확인
			document.menudelete.submit();

		} else { //취소
			return false;
		}
	}
	function popmenumodify() {
		if (confirm("메뉴를 수정하시겠습니까?") == true) { //확인
			document.menumodify.submit();

		} else { //취소
			return false;
		}
	}
	
</script>

<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=TQHL3aV0s7CKyPelavqy"></script>
	
</head>
<body>

	<form name="menuinsert" action="MenuInsert.jsp" method="get" id="mi">
		<input type="submit" value="메뉴삽입" onclick="return popmenuinsert()">
	</form>
	<form name="menudelete" action="Menudelete.jsp" method="get" id="md">
		<input type="submit" value="메뉴삭제" onclick="return popmenudelete()">
	</form>
	<form name="menumodify" action="Menumodify.jsp" method="get" id="mf">
		<input type="submit" value="메뉴수정" onclick="return popmenumodify()">
	</form>
	<h1>음식 상세페이지</h1>
	<table align="center">
		<tr>
			<td>이름</td>
			<td colspan="3">${Restaurant.rName}</td>
		</tr>
		<tr>
			<td id="p">사진</td>
			<c:forEach begin="0" end="2" step="1" var="menu" items="${menulist}">
				<td align="center"><img src="${menu.mPicture1}"></td>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td>메뉴</td>
			<td colspan="3"><c:forEach var="menu" items="${menulist}">
						${menu.mName}: &nbsp;${menu.mPrice}won<br>
				</c:forEach></td>
		</tr>
		<tr>
			<td>평점</td>
			<td colspan="3" align="left">${Restaurant.rRate}</td>
		</tr>
		<tr>
			<td>거리</td>
			<td colspan="3" align="left">${Restaurant.rDistance}KM</td>
		</tr>

		<tr>
			<td>댓글</td>
			<td colspan="2"><c:forEach var="comment" items="${commentlist}">
					<form name="del" action="commentdelete.do" method="get">
						<input type="hidden" name="uId" value="${uId}"> <input
							type="hidden" name="cId" value="${comment.cId}"> <input
							type="hidden" name="rId" value="${Restaurant.rId}">
						${comment.cContents} <input type="submit" value="삭제"
							onclick="return popdelete()">
					</form>

					<br>
				</c:forEach></td>
			<td><c:forEach var="comment" items="${commentlist}">
					<c:choose>
						<c:when test="${comment.cRate eq 1}">
							        ★☆☆☆☆<br>
						</c:when>

						<c:when test="${comment.cRate eq 2}">
							        ★★☆☆☆<br>
						</c:when>

						<c:when test="${comment.cRate eq 3}">
	        					★★★☆☆<br>
						</c:when>

						<c:when test="${comment.cRate eq 4}">
	        					★★★★☆<br>
						</c:when>

						<c:when test="${comment.cRate eq 5}">
	        					★★★★★<br>
						</c:when>
					</c:choose>
				</c:forEach>
		</tr>
		<tr>
			<td>댓글쓰기</td>
			<td colspan="3">
				<form name="Com" action="commentwrite.do" method="get">
					내&nbsp;&nbsp; 용&nbsp;<input type="text" name="comment" size="75"
						id="comment"><br> 평&nbsp;&nbsp; 점&nbsp;<input
						type="text" name="Rate" id="RT"><br> <input
						type="hidden" name="uId" value="${uId}"><br> <input
						type="hidden" name="rName" value="${Restaurant.rId}"><br>
					<input type="submit" value="댓글달기" onclick="return popComment()">
				</form>
			</td>
		</tr>
	</table>
	<div id="map" style="width: 600px; height: 400px; align: center;">
		<script>
			
			var position = new naver.maps.LatLng(37.504298, 127.039659);
			
			var map = new naver.maps.Map('map', {
			    center: position,
			    zoom: 10
			});

			var marker = new naver.maps.Marker({
			    position: position,
			    map: map
			});
			
		</script>
	</div>

</body>
</html>