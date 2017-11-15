<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
var onStar = '여기다가 별점 숫자 입력(데이터 받는 부분)';
var stars = $('#stars li').parent().children('li.star');
for (i = 0; i < stars.length; i++) {
	$(stars[i]).removeClass('selected');
}

for (i = 0; i < onStar; i++) {
	$(stars[i]).addClass('selected');
}
</script>

<style type="text/css">
.rating-stars ul {
	list-style-type: none;
	padding: 0;
	-moz-user-select: none;
	-webkit-user-select: none;
}

.rating-stars ul>li.star {
	display: inline-block;
}

/* Idle State of the stars */
.rating-stars ul>li.star>i.fa {
	font-size: 2.5em; /* Change the size of the stars */
	color: #ccc; /* Color on idle state */
}

/* Selected state of the stars */
.rating-stars ul>li.star.selected>i.fa {
	color: #FF912C;
}
</style>
</head>
<body>
	<section class='rating-widget'> <!-- Rating Stars Box -->
	<div class='rating-stars text-center'>

		<ul id='stars'>
			<li class='star' title='1' data-value='1'><i
				class='fa fa-star fa-fw'></i></li>
			<li class='star' title='2' data-value='2'><i
				class='fa fa-star fa-fw'></i></li>
			<li class='star' title='3' data-value='3'><i
				class='fa fa-star fa-fw'></i></li>
			<li class='star' title='4' data-value='4'><i
				class='fa fa-star fa-fw'></i></li>
			<li class='star' title='5' data-value='5'><i
				class='fa fa-star fa-fw'></i></li>
		</ul>
	</div>
	</section>
</body>
</html>