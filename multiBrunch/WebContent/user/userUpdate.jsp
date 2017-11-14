<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리</title>

<script src="https://code.jquery.com/jquery-2.2.4.min.js">
</script>

<link rel="stylesheet" type="text/css" href="../css/login.css">

<script type="text/javascript" src="../script/user.js">

</script>

</head>
<body>


	<div class="form">

		<ul class="tab-group">
			<li class="tab active"><a href="#Update">Update</a></li>
			<li class="tab"><a href="#emailCheck">Email</a></li>
		</ul>

		<!-- Join -->
		<div class="tab-content">


			<!-- signup -->
			<div id="Update">
				<h1>Change Yours</h1>

				<form action="userUpdate.do" method="post" name="frm">

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
							type="text" name="uEmail" id="uEmail" value="${uVo.uEmail}"
							readonly />
					</div>

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
							type="checkbox" name="uPreference" value="jp">일식</input></span> <span><input
							type="checkbox" name="uPreference" value="ch">중식</input></span> <span><input
							type="checkbox" name="uPreference" value="wf">양식</input></span>
					</div>


					<button type="submit" class="button button-block" value="확인"
						onclick="return joinCheck()" />
					Get Started
					</button>

				</form>

			</div>
			<!-- login -->
			<div id="emailCheck">
				<h1>Check your Email</h1>

				<form action="emailCheck.do" method="get" name="frm">

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" name="uEmail" value="${uEmail}" />
					</div>

					<button class="button button-block" type="submit" value="중복 체크" />
					Confirm
					</button>

					<c:if test="${result == 1 }">
						<script type="text/javascript">
				opener.document.frm.uEmail.value = "";
			</script>
			${uEmail}는 이미 사용중입니다.
		</c:if>

					<c:if test="${result == -1 }">
			${uEmail}은 사용 가능합니다.
			<input type="button" value="사용" class="cancel" onclick="emailok()">
					</c:if>


				</form>
				<!-- email check form-->


			</div>
			<!-- email check -->
		</div>
		<!-- tab-content -->

	</div>

</body>
</html>