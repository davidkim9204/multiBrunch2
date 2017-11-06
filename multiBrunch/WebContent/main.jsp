<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- select 부트스트랩 -->
<link href="~/Content/bootstrap-select/bootstrap-select.min.css"
	rel="stylesheet" type="text/css" />
<script src="/Content/bootstrap-select/bootstrap-select.min.js"></script>

<script>
	$(window).on('load', function() {
		$('.selectpicker').selectpicker(
			{
				'selectedText' : 'cat'
			});
	});
</script>

<style>
.mainPageSearchForm {
	text-align: center;
	position: absolute;
	top: 50%;
	left: 42%;
	width: 400px;
	height: 200px;
	overflow: hidden;
	margin-top: -150px;
	margin-left: -100px;
}

.restaurantRank {
	text-align: center;
	position: absolute;
	top: 60%;
	left: 20%;
	width: 400px;
	height: 400px;
	overflow: hidden;
	margin-top: -150px;
	margin-left: -100px;
	border: 1px solid black;
}

.todaysRecommendation {
	text-align: center;
	position: absolute;
	top: 60%;
	left: 60%;
	width: 400px;
	height: 400px;
	overflow: hidden;
	margin-top: -150px;
	margin-left: -100px;
	border: 1px solid black;
}

.selectpicker {
	text-align: center;
	height: 30px;
}

.navbar-header-div {
	border: 1px solid black;
	height: 50px;
	width: 100%;
	text-align: center;
}

.navbar-brand {
	display: inline;
	left: 20%;
	position: absolute;
}

.form-inline {
	display: inline;
	left: 60%;
	position: absolute;
}

.navbar-login {
	display: inline;
	left: 80%;
	position: absolute;
	height: 30px;
}
</style>
</head>
<body>
	우리 팀 명 / 로그인/회원가입은 헤더 html파일 만들어서 공유할꺼
	<nav class="navbar navbar-light bg-faded">
	<div class="navbar-header-div" id="navbar-header-div">
		<a class="navbar-brand" id="header_homelink" href="#"> MultiBrunch
		</a>

		<form class="form-inline" id="header_search">
			<input class="form-control mr-sm-2" type="text" placeholder="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>

		<a class="navbar-login" id="navbar-login" href="login.do">login</a>
	</div>
	</nav>


<!--     <form class="mainPageSearchForm" role="search" method="get" action=RestaurantServlet>  -->
<!--     <input type="text" name="command" value="Restaurant_list" hidden="true">  -->
   <form class="mainPageSearchForm" role="search" method="get" action=ChosenRestaurantsServlet> 
<!--    <input type="text" name="r.rCategory" value="kor" hidden="true"> -->
		<div class="mainSearch">
			<select name="categorySelect" id="categorySelect"
				class="selectpicker">
				<option>분류
					<option value="kor">한식</option>
            <option value="ch">중식</option>
            <option value="jp">일식</option>
         </select> 
         <select name="distanceSelect" id="distanceSelect"
				class="selectpicker">
            <option>거리(m)
            
				<option value="100">0 ~ 100</option>
            <option value="200">100 ~ 200</option>
            <option value="300">200 ~ 300</option>
            <option value="400">300 ~</option>
         </select> 
         <select name="priceSelect" id="priceSelect"
				class="selectpicker">
            <option>가격(원)
            
				<option value="5000">0 ~ 5000</option>
            <option value="10000">5000 ~ 10000</option>
            <option value="15000">10000 ~ 15000</option>
            <option value="20000">15000 ~</option>
         </select>
         <input type="submit" class="priceSearch" value="검색하기">
      </div>
   </form>


	<div class="restaurantRank">
						인기순위 <br>
		<br>
		<h1>1. test1</h1>
		<br>
		<h1>2. test2</h1>
		<br>
		<h1>3. test3</h1>
		<br>
	</div>
	<div class="todaysRecommendation">
		오늘의 추천 <br>
		<br>
		<h1>1. test1</h1>
		<br>
		<h1>2. test2</h1>
		<br>
		<h1>3. test3</h1>
		<br>
	</div>


				</body>
</html>