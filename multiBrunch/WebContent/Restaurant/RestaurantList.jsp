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
<title>Restaurant List</title>
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

<script type="text/javascript">
	var maxChecked = 3;
	var totalChecked = 0;
	
	function CountChecked(form) {
	    if (form.checked)
	        totalChecked += 1;
	    else
	        totalChecked -= 1;
	    if (totalChecked > maxChecked) {
	        alert ("최대 3개 까지 비교 가능합니다.");
			form.checked = false;
			totalChecked -= 1;
	    }
	}
	
	function ResetCount(){
	    totalChecked = 0;
	}
	
	function chkchk (form){ 
		var arrForm = document.getElementsByName('comsel'); 
		var num = 0; 

		for(var i=0; i<arrForm.length; i++){ 
			if(arrForm[i].checked){ 
				num++; 
			} 
		} 
		if(num <= 1){ 
			alert('2개 이상 선택 해주세요!'); 
			return false; 
		} 
	}
	
	   function mover(id,distance) {
		      var time = distance/80;
//		       time = ;
		      var M = document.getElementById("rDistance_" +id);
		      M.innerHTML = "걸어서 " + Math.ceil(time) + " 분 ";

		   }


		   function mout(id,distance) {
		      
		      var M = document.getElementById("rDistance_" +id);
		       M.innerHTML = distance + " m";

		   }

</script>
<!-- <link rel="stylesheet" type="text/css" href="css/shop.css"> -->

<script type="text/javascript">
 var stmnLEFT = 150; // 오른쪽 여백 
 var stmnGAP1 = 0; // 위쪽 여백 
 var stmnGAP2 = 220; // 스크롤시 브라우저 위쪽과 떨어지는 거리 
 var stmnBASE = 150; // 스크롤 시작위치 
 var stmnActivateSpeed = 15; //스크롤을 인식하는 딜레이 (숫자가 클수록 느리게 인식)
 var stmnScrollSpeed = 4; //스크롤 속도 (클수록 느림)
 var stmnTimer; 
 
 function RefreshStaticMenu() { 
  var stmnStartPoint, stmnEndPoint; 
  stmnStartPoint = parseInt(document.getElementById('STATICMENU').style.top, 10); 
  stmnEndPoint = Math.max(document.documentElement.scrollTop, document.body.scrollTop) + stmnGAP2; 
  if (stmnEndPoint < stmnGAP1) stmnEndPoint = stmnGAP1; 
  if (stmnStartPoint != stmnEndPoint) { 
   stmnScrollAmount = Math.ceil( Math.abs( stmnEndPoint - stmnStartPoint ) / 15 ); 
   document.getElementById('STATICMENU').style.top = parseInt(document.getElementById('STATICMENU').style.top, 10) + ( ( stmnEndPoint<stmnStartPoint ) ? -stmnScrollAmount : stmnScrollAmount ) + 'px'; 
   stmnRefreshTimer = stmnScrollSpeed; 
   }
  stmnTimer = setTimeout("RefreshStaticMenu();", stmnActivateSpeed); 
  } 
 function InitializeStaticMenu() {
  document.getElementById('STATICMENU').style.right = stmnLEFT + 'px';  //처음에 오른쪽에 위치. left로 바꿔도.
  document.getElementById('STATICMENU').style.top = document.body.scrollTop + stmnBASE + 'px'; 
  RefreshStaticMenu();
  }
</script>

<style type="text/css">
#STATICMENU { margin: 0pt; padding: 7px;  position: absolute; right: 0px; top: 0px;}
</style>

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
			<a href="ReMeservlet.do?userid=${randomRestaurant}" ><font size=2 style="color: white; margin-bottom: 6px;">　|　아무거나</font></a>
			<a href="laddergame.html" ><font size=2 style="color: white; margin-bottom: 6px;">　|　사다리타기</font></a>
		</div>
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-default">
				<div class="container-fluid">

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
							<li><a href="logout.do" class="booking">로그아웃</a></li>
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
	
	<body id="" onload="InitializeStaticMenu();">
	
	<form action="compareservlet.do" name="form" method="get"
		onsubmit="return chkchk(this);">
		<div id="wrap" align="center">

			<table class="list">
				<tr>
					<td colspan="6"
						style="border: #000022; text-align: center; padding-top: 100px;">
						<h2>맛집 목록</h2>
					</td>
				</tr>
				<tr>
					<td colspan="6" style="border: #000022; text-align: right"><a
						href="RestaurantServlet?command=Restaurant_write_form">맛집 등록</a></td>
				</tr>

				<c:forEach var="Restaurant" items="${RestaurantList }">
					<tr class="record" align="center">
						<td width="300px"><img src="img/chch.jpg" width="280px"
							height="190px"></td>
						<%-- 				${Restaurant.Picture1 } --%>
						<td width="300px" style="text-align: left"><font size=5><a
								href="ReMeservlet.do?rId=${Restaurant.rId}&uId=${loginUser.uId}">
									${Restaurant.rName } </a></font> <br> <font color=grey size=4>${Restaurant.rCategory}</font>
							<br> <br> <br> <br> <font size=3>${Restaurant.rRate }
								/ 10</font> <br>평점</td>

						<td width="350px" style="text-align: left"> <img alt="" src="assets/images/map.png" /><font size=3>　:　</font><font id="rDistance_${Restaurant.rId}" onmouseover="mover(${Restaurant.rId},${Restaurant.rDistance})" onmouseout="mout(${Restaurant.rId},${Restaurant.rDistance})" size=3>${Restaurant.rDistance}
                        m</font> <br> <br> <img alt=""
								src="assets/images/home.png"><font size=3>　:　${Restaurant.rAddress}</font> <br>
								<br> <img alt="" src="assets/images/phone.png"><font size=3>　:　
								${Restaurant.rTel} </font><br> <img class="line"
								src="assets/images/line.png" width="300px" height="10px"
								style="margin-top: 7px;"> <br> <font size=2">&nbsp;선택&nbsp;</font><input
								type="checkbox"
								style="text-align: right; position: relative; top: 3px;"
								name="comsel" onClick="CountChecked(this);"
								value="${Restaurant.rId }" /> </font></td>
					</tr>
				</c:forEach>
				<tr>

					<td colspan="6" style="border: #000022; text-align: center"><br>
						<input type="submit" id="STATICMENU" class="btn btn-primary" value="비교하기"></td>
				</tr>

			</table>
		</div>
	</form>
<body onload="document.form.reset();">

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