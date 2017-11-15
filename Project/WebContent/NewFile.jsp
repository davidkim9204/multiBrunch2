<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
table { 
    border: 1px solid #bcbcbc;
 	 width: 600px;
 } 
 th, td {
    border: 1px solid #444444;
  }
</style>
</head>
<body>
<table>
      <thead>
        <tr>
          <th class="jb-th-1">Lorem</th>
          <th>Ipsum</th>
          <th>Dolor</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Lorem</td>
          <td>Ipsum</td>
          <td>Dolor</td>
        </tr>
        <tr>
          <td>Lorem</td>
          <td>Ipsum</td>
          <td>Dolor</td>
        </tr>
      </tbody>
    </table>
    
    <!-- 	<form action="logout.do" method="get" name="frm" align="right"> -->
<!-- 		<input type="button" value="로그아웃" class="logout"> -->
<!-- 	</form> -->

<!-- 	<div id="compare" align="center"> -->
<!-- 		<h1>식당 상세페이지</h1> -->
<!-- 		<form method="get" enctype="multipart/form-data" name="frm"> -->
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<th></th> -->
<!-- 					<th><input type="button" id="c1" value="선택1"></th> -->
<!-- 				</tr> -->

<!-- 				<tr> -->
<!-- 					<th>레스토랑 이름</th> -->
<%-- 					<td>${Restaurant.rName}</td> --%>
<!-- 					<td></td> -->
<!-- 					<td></td> -->
<!-- 				</tr> -->



<!-- 				<tr> -->
<!-- 					<th>메뉴&사진</th> -->
<%-- 					<td>${Menu[0].mName}${Menu[0].mPicture1}<br> --%>
<%-- 						${Menu[1].mName}${Menu[1].mPicture1}<br> --%>
<%-- 						${Menu[2].mName}${Menu[2].mPicture1} --%>
<!-- 					</td> -->
<!-- 					<td></td> -->
<!-- 					<td></td> -->

<!-- 				</tr> -->

<!-- 				<tr> -->
<!-- 					<th>멀캠으로부터 거리</th> -->
<%-- 					<td>${Restaurant.rDistance}</td> --%>
<!-- 					<td></td> -->
<!-- 					<td></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<th>레스토랑 평점</th> -->
<%-- 					<td>${Restaurant.rRate}</td> --%>
<!-- 					<td></td> -->
<!-- 					<td></td> -->
<!-- 				</tr> -->

<!-- 			</table> -->

<!-- 			<br> <br> <input type="button" id="back" value="이전페이지"> -->

<!-- 		</form> -->


<!-- 	</div> -->
	<%--    이름:${Restaurant.rname} --%>
	<%--    <br> 사진:${Menu[0].mpicture1} --%>
	<%--    <br> 메뉴:${Menu[0].mname} --%>
	<%--    <br> 사진:${Menu[1].mpicture1} --%>
	<%--    <br> 메뉴:${Menu[1].mname} --%>
	<%--    <br> 사진:${Menu[2].mpicture1} --%>
	<%--    <br> 메뉴:${Menu[2].mname} --%>
	<%--    <br> 거리:${Restaurant.rdistance} --%>
	<%--    <br> 평점:${Restaurant.rrate} --%>
	<!--    <br> -->



<!-- 		<table border="2" align="center"> -->
<%-- 			<caption> --%>
<!-- 				<h1>음식점 상세 설명<h1> -->
<%-- 			</caption> --%>
<!-- 			<tbody align="center"> -->
<!-- 				<tr> -->
<!-- 					<td>이름</td> -->
<%-- 					<td colspan="3">${Restaurant.rName}</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>사진</td> -->
<%-- 					<td><img src="/images/${menu.mPicture1}" width="10" height="10"></td> --%>
<!-- 					<td>데이터3</td> -->
<!-- 					<td>데이터4</td> -->
					
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>메뉴</td> -->
<!-- 					<td colspan="3"> -->
<%-- 					<c:forEach var="menu" items="${menulist}"> --%>
<%-- 						${menu.mName} --%>
<%-- 					</c:forEach> --%>
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>평점</td> -->
<%-- 					<td>${Restaurant.rRate}</td> --%>
<!-- 					<td>거리</td> -->
<%-- 					<td>${Restaurant.rDistance}</td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>댓글</td> -->
<!-- 					<td colspan="2">데이터2</td> -->
<!-- 					<td>별점</td> -->
<!-- 				</tr> -->
<!-- 			</tbody> -->
<!-- 		</table> -->



	<%-- <c:forEach var="menu" items="${menulist}"> --%>
	<%-- 메뉴 아이디:${menu.mId}<br> --%>
	<%-- 메뉴 이름:${menu.mName}<br> --%>
	<%-- 메뉴 그림1:${menu.mPicture1}<br> --%>
	<%-- 메뉴 그림2:${menu.mPicture2}<br> --%>
	<%-- 메뉴 가격:${menu.mPrice}<br> --%>
	<!-- <br> -->
	<%-- </c:forEach> --%>
	<!-- <br> -->
	<%-- 음식점 아이디:${Restaurant.rName}<br> --%>
	<%-- 음식점 제목:${Restaurant.rAddress}<br> --%>
	<%-- 음식점 출판사:${Restaurant.rDistance}<br> --%>
	<%-- 음식점 오픈시간:${Restaurant.rOpenHours}<br> --%>
	<%-- 음식점 전번:${Restaurant.rTel}<br> --%>
	<%-- 음식점 평판:${Restaurant.rRate}<br> --%>
	<%-- 음식점 목록:${Restaurant.rCategory}<br> --%>
    
    
</body>
</html>