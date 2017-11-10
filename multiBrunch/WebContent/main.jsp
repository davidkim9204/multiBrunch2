<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Food and Restorent One page Template</title>
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
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
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

	<section id="slider" class="slider">
	<div class="slider_overlay">
		<div class="container">
			<div class="row">
				<div class="main_slider text-center">
					<div class="col-md-12">
						<div class="main_slider_content wow zoomIn" data-wow-duration="1s">
							<h1>MultiBrunch</h1>
							<form class="mainPageSearchForm" role="search" method="get"
								action=ChosenRestaurantsServlet>
								<!--    <input type="text" name="r.rCategory" value="kor" hidden="true"> -->
								<div class="mainSearch">
									<select name="categorySelect" id="categorySelect"
										class="btn-lg">
										<option class="btn-lg" value="chooseCategory" style="color: black;">분류ㅇ</option>
										<option value="kor" style="color: black;">한식</option>
										<option value="ch" style="color: black;">중식</option>
										<option value="jp" style="color: black;">일식</option>
									</select> <select name="distanceSelect" id="distanceSelect"
										class="btn-lg">
										<option value="0" style="color: black;">거리(m)</option>
										<option value="100" style="color: black;">0 ~ 100</option>
										<option value="200" style="color: black;">100 ~ 200</option>
										<option value="300" style="color: black;">200 ~ 300</option>
										<option value="400" style="color: black;">300 ~</option>
									</select> <select name="priceSelect" id="priceSelect" class="btn-lg">
										<option value="0" style="color: black;">가격(원)</option>
										<option value="5000" style="color: black;">0 ~ 5000</option>
										<option value="10000" style="color: black;">5000 ~	10000</option>
										<option value="15000" style="color: black;">10000 ~
											15000</option>
										<option value="20000" style="color: black;">15000 ~</option>
									</select> <input type="IMAGE" src="assets/images/frypan.png"
										width="48px" height="48px"
										style="vertical-align: middle; margin-bottom: 11px;"
										name="submit" value="submit">
								</div>
							</form>

							<br> <br> <br> <br>
							<div class="btn-lg">
								인기순위 <br> <br> <br>
								<p>
									<c:forEach var="popularRestaurantList"
										items="${popularRestaurantList}" varStatus="myIndex">
										<td>${myIndex.index+1}</td>
										<td><a
											href="ReMeservlet.do?userid=${popularRestaurantList.rId}">
												${popularRestaurantList.rName } </a></td>
										<br>
										<br>
									</c:forEach>
									
								</p>
							</div>
							<div class="btn-lg1">
								오늘의 추천 <br> <br> <br>
								<p>
									<c:forEach var="recommendRestaurantList"
										items="${recommendRestaurantList}" varStatus="myIndex">
										<td>${myIndex.index+1}</td>
										<td><a
											href="ReMeservlet.do?userid=${recommendRestaurantList.rId}">
												${recommendRestaurantList.rName } </a></td>
										<br>
										<br>
									</c:forEach>
								</p>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	</section>

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