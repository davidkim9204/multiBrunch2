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
	
	<div id="wrap" align="center">

		<form name="frm" method="post" action="RestaurantServlet">
			<input type="hidden" name="command" value="Restaurant_write">

			<table>
			<tr>
			<td colspan="6" style="border: #000022; text-align: center; padding-top: 150px;	">
            <h3>맛집 등록</h3><br></td>
			</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" size="70" name="rName"
						></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" size="70" name="rAddress"
						></td>
				</tr>
				<tr>
					<th>거리</th>
					<td><input type="text" size="70" name="rDistance"
						></td>
				</tr>
				<tr>
					<th>운영시간</th>
					<td><input type="text" size="70" name="rOpenhours"
						></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" size="70" name="rTel"
						></td>
				</tr>
				<tr>
					<th>평점</th>
					<td><input type="text" size="70" name="rRate"
						></td>
				</tr>
				<tr>
					<th>분류</th>
					<td>
						<select name="rCategory" id="categorySelect">
						<option value="kor" style="color: black;">한식</option>
						<option value="ch" style="color: black;">중식</option>
						<option value="jp" style="color: black;">일식</option>
						<option value="wf" style="color: black;">양식</option>
						</select>
						</td>
				</tr>


			</table>
			<br>
			<br> <input type="submit" class="btn btn-primary" value="등록"
				onclick="return RestaurantCheck()"> <input type="reset" class="btn btn-primary" 
				value="다시 작성"> <input type="button" class="btn btn-primary" value="목록"
				onclick="location.href='RestaurantServlet?command=Restaurant_list'">
				<br><br>
				<br><br>
				<br><br>
				<br><br>
				<br><br>
		</form>
	</div>
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