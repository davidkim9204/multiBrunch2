<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>MultiBrunch</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Pacifico'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<!--        <link rel="stylesheet" href="assets/css/bootstrap-theme.min.css">-->


<!--For Plugins external css-->
<link rel="stylesheet" href="assets/css/animate/animate.css" />
<link rel="stylesheet" href="assets/css/plugins.css" />

<!--Theme custom css -->
<link rel="stylesheet" href="assets/css/style.css">

<!--Theme Responsive css-->
<link rel="stylesheet" href="assets/css/responsive.css" />

<script src="assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
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
	<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	<div class='preloader'>
		<div class='loaded'>&nbsp;</div>
	</div>
	<header id="home" class="navbar-fixed-top"> <!-- End navbar-collapse-->

	<div class="main_menu_bg">
		<div style="position: absolute; z-index: 1;">
			<a href="index.do" class="booking-1"><br>　　　　MultiBrunch</a>
			<a href="RestaurantServlet?command=Restaurant_list" ><font size=2 style="color: white; margin-bottom: 6px;">　모든 맛집 보기</font></a>
			<font size=2 style="color: white; margin-bottom: 6px;">　|　</font>
			<a href="ReMeservlet.do?rId=${randomRestaurant}&uId=${loginUser.uId}" ><font size=2 style="color: white; margin-bottom: 6px;">아무거나</font></a>
			<font size=2 style="color: white; margin-bottom: 6px;">　|　</font>
			<a href="laddergame.html" ><font size=2 style="color: white; margin-bottom: 6px;">사다리타기</font></a>
		</div>
			
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only"></span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>

					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">

						<ul class="nav navbar-nav navbar-right">
							<li>
								<form class="form-inline" role="search" id="header_search" method="get" action=SearchedRestaurantsServlet>
<!-- 									<input type="text" name="m.Mname" value="menuSearch" hidden="true"> -->
									<input class="form-control mr-sm-2" type="text"
										style="color: white; width: 250px;" placeholder="메뉴 검색" name="m.mName">
									<button class="btn btn-outline-success my-2 my-sm-0"
										type="submit">검색</button>
								</form>
							</li>
							<li><a href="login.do" class="booking">로그인</a></li>
							<li><a href="join.do" class="booking">회원가입</a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid --> </nav>
			</div>
		</div>
	</div>
	</header>
	<!-- End Header Section -->

	<div style="margin-top: 100px;"><h1>상세페이지</h1></div>

	<form name="menuinsert" action="MenuInsert.jsp" method="get" style="margin-right: 260px; text-align: right;">
	<a type="submit" onclick="return popmenuinsert()">메뉴 추가</a></form><form name="menumodify" action="Menumodify.jsp" method="get" style="margin-right: 260px; text-align: right;">
	<a type="submit" onclick="return popmenumodify()">메뉴 수정</a></form><form name="menudelete" action="Menudelete.jsp" method="get" style="margin-right: 260px; text-align: right;">
	<a type="submit" onclick="return popmenudelete()">메뉴 삭제</a></form><table align="center">
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
					평&nbsp;&nbsp; 점&nbsp;
					<select name="Rate" id="RT">
						<option value="10" style="color: black;">10</option>
						<option value="9" style="color: black;">9</option>
						<option value="8" style="color: black;">8</option>
						<option value="7" style="color: black;">7</option>
						<option value="6" style="color: black;">6</option>
						<option value="5" style="color: black;">5</option>
						<option value="4" style="color: black;">4</option>
						<option value="3" style="color: black;">3</option>
						<option value="2" style="color: black;">2</option>
						<option value="1" style="color: black;">1</option>
					</select><br><br>
					내&nbsp;&nbsp; 용&nbsp;<input type="text" name="comment" size="75"
						id="comment">　　　　<input type="submit" value="댓글달기" class="btn btn-primary" onclick="return popComment()">
						<input type="hidden" name="uId" value="${uId}">
						<input type="hidden" name="rName" value="${Restaurant.rId}">
					
				</form>
			</td>
		</tr>
	</table>
	<div id="map" style="width: 600px; height: 400px; align: center; margin: auto">
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
	<div style="margin-bottom: 70px;"></div>

	
	<footer id="footer" class="footer">
	<div class="container text-center">
		<div class="row">
			<div class="col-sm-12">
				<div class="copyright wow zoomIn" data-wow-duration="3s">
					<p>
						Made with <i class="fa fa-heart"></i> by <a
							href="http://bootstrapthemes.co">MultiBrunch</a>2017. All Rights
						Reserved
					</p>
				</div>
			</div>
		</div>
	</div>
	</footer>


	<script src="assets/js/vendor/jquery-1.11.2.min.js"></script>
	<script src="assets/js/vendor/bootstrap.min.js"></script>

	<script src="assets/js/jquery-easing/jquery.easing.1.3.js"></script>
	<script src="assets/js/wow/wow.min.js"></script>
	<script src="assets/js/plugins.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>