<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리d</title>

<script src="https://code.jquery.com/jquery-2.2.4.min.js">
</script>

<!-- <link rel="stylesheet" type="text/css" href="../css/login.css"> -->
<link rel="stylesheet" type="text/css" href="css/login.css">

<script type="text/javascript" src="script/user.js">

</script>

</head>
<body>


	<div class="form">

		<ul class="tab-group">
			<li class="tab active"><a href="#login">Log In</a></li>
			<li class="tab"><a href="#signup">Sign Up</a></li>
		</ul>

		<!-- Join -->
		<div class="tab-content">

			<!-- login -->
			<div id="login">
				<h1>Welcome Brunch♡</h1>

				<form action="login.do" method="post" name="frm">

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" name="uEmail" />
					</div>

					<div class="field-wrap">
						<label> Password<span Sinclass="req">*</span>
						</label> <input type="password" name="uPassword" />
					</div>

					<p class="forgot">
						<a href="#">Rewrite?</a>
					</p>

<input type="submit" class="button button-block" 
value="Log in" onclick="return loginCheck()">



					<p class="forgot">
						<a>${message}</a>
					</p>
				</form>
			</div>
			<!-- signup -->
			<div id="signup">
				<h1>Join with us~~</h1>

				<form action="join.do" method="post" name="frm">

					<div class="field-wrap">
						<label> Name<span class="req">*</span>
						</label> <input type="text" name="uName" />
					</div>
					<div class="field-wrap">
						<label> Age<span class="req">*</span>
						</label> <input type="text" name="uAge" />
					</div>
					<div class="field-wrap">
						<label> Email Address<span class="req">*</span></label> <input
							type="text" name="uEmail" id="uEmail" /> <input type="hidden"
							name="re_uEmail" size="20">
					</div>
					<p class="forgot">
						<a href="emailCheck()">EmailCheck</a>
					</p>

					<div class="top-row">
						<div class="field-wrap">
							<label> Set Password<span class="req">*</span>
							</label> <input type="password" name="uPassword" />
						</div>

						<div class="field-wrap">
							<label> Confirm Password<span class="req">*</span>
							</label> <input type="password" name="uPassword_check" />
						</div>
					</div>

					<div class="field-wrap">
						<span>Gender : </span> <span><input type="radio"
							name="uGender" value="m" checked="checked" />Male</span> <span><input
							type="radio" name="uGender" value="f" />Female</span>


					</div>

					<div class="field-wrap">
						<span>Preferences : </span> <span><input type="checkbox"
							name="uPreference" value="kor" checked="checked" />한식</span> <span><input
							type="checkbox" name="uPreference" value="jp"/>일식</span> <span><input
							type="checkbox" name="uPreference" value="ch"/>중식</span> <span><input
							type="checkbox" name="uPreference" value="wf"/>양식</span>
					</div>

					<button type="submit" class="button button-block" />
					Get Started
					</button>
				</form>

			</div>

		</div>
		<!-- tab-content -->

	</div>

</body>
</html>