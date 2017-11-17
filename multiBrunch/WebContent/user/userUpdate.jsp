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

<link rel="stylesheet" type="text/css" href="css/login.css">

<script src="script/user.js"> </script>

</head>
<body>


	<div class="form">

<!-- 		<ul class="tab1-group"> -->
		
<!-- 			<li class="tab active"><a href="#Update">Update</a></li> -->

<!-- 		</ul> -->

		<!-- Join -->
<!-- 		<div class="tab-content"> -->


			<!-- signup -->
			<div id="Update">
				<h1>Update Yours</h1>

				<form action="userUpdate.do" method="post" name="frm">

					<div class="field-wrap">
						<label>Name<span class="req">*</span>
						</label> <input type="text" name="uName" id="s_uName" value="${uVo.uName}"/>
					</div>
					<div class="field-wrap">
						<label>Age<span class="req">*</span>
						</label> <input type="text" name="uAge" id="s_uAge" value="${uVo.uAge}"/>
					</div>
					<div class="field-wrap">
						<label><span class="req"></span></label> <input type="text"
							name="uEmail" id="uEmail" value="${uVo.uEmail}" readonly />
					</div>

					<div class="top-row">
						<div class="field-wrap">
							<label> Set Password<span class="req">*</span>
							</label> <input type="password" name="uPassword" id="s_uPassword"/>
						</div>

						<div class="field-wrap">
							<label> Confirm Password<span class="req">*</span>
							</label> <input type="password" name="uPassword_check"id="s_uPassword_check"/>
						</div>
					</div>

					<div class="field-wrap">
						<span>Gender : </span> <span><input type="radio"
							name="uGender" value="m" checked="checked" />Male</span> <span><input
							type="radio" name="uGender" value="f" />Female</span>


					</div>

					<div class="field-wrap">
						<span>Preferences : </span> <span><input type="radio"
							name="uPreference" value="kor" checked="checked" />한식</span> <span><input
							type="radio" name="uPreference" value="jp"/>일식</span> <span><input
							type="radio" name="uPreference" value="ch"/>중식</span> <span><input
							type="radio" name="uPreference" value="wf"/>양식</span>
					</div>


						<input type="submit" id="signup_c" class="button button-block"
						value="Get Started">
				</form>


			</div>
			<!-- login -->
<!-- 			<div id="a_emailCheck"> -->
<!-- 				<h1>Check your Email</h1> -->

<!-- 				<form action="emailCheck.do" method="get" name="frm"> -->

<!-- 					<div class="field-wrap"> -->
<!-- 						<label> <span class="req">*</span> -->
<%-- 						</label> <input type="text" name="uEmail" id="c_uEmail" value="${uEmail}" /> --%>
<!-- 					</div> -->



<!-- 					<button class="button button-block" type="submit" value="중복 체크" /> -->
<!-- 					Confirm -->
<!-- 					</button> -->




<%-- 					<c:if test="${result == 1 }"> --%>
<!-- 						<script type="text/javascript"> -->
<!-- // 				opener.document.frm.uEmail.value = ""; -->
<!-- 			</script> -->
<%-- 			${uEmail}는 이미 사용중입니다. --%>
<%-- 		</c:if> --%>

<%-- 					<c:if test="${result == -1 }"> --%>
<%-- 			${uEmail}은 사용 가능합니다. --%>
<!-- 			<input type="button" value="사용" class="cancel" id="emailok"> -->
<%-- 					</c:if> --%>


<!-- 				</form> -->
<!-- 				email check form -->


<!-- 			</div> -->
			<!-- email check -->
		</div>
		<!-- tab-content -->

<!-- 	</div> -->

</body>
</html>