<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shop.css">
</head>
<body>

   <form action="logout.do" method="get" name="frm" align="right">
      <input type="button" value="로그아웃" class="logout">
   </form>

   <div id="compare" align="center">
      <h1>맛집 비교</h1>
      <form method="get" enctype="multipart/form-data" name="frm">
         <table>
            <tr>
               <th>레스토랑 이름</th>
               <c:forEach var="Restaurant" items="${Restaurant}">
                  <td><a href="ReMeservlet.do?userid=${Restaurant.rId}">
                     ${Restaurant.rName } </a></td>
               </c:forEach>
            </tr>
            <tr>
               <th>메뉴&사진 </th>
               
               <c:forEach var="Restaurant" items="${Restaurant}">
               <td>
                  <c:forEach var="Menu" items="${Menu}">
                     ${Menu.mName}${Menu.mPicture1}<br>
                  </c:forEach>
               </td>
               </c:forEach>
               
            </tr>
            <tr>
               <th>멀캠으로부터 거리</th>
               <c:forEach var="Restaurant" items="${Restaurant}">
                  <td>${Restaurant.rDistance}</td>
               </c:forEach>
            </tr>
            <tr>
               <th>레스토랑 평점</th>
               <c:forEach var="Restaurant" items="${Restaurant}">
                  <td>${Restaurant.rRate}</td>
               </c:forEach>
            </tr>
         </table>
         <br> <br> <input type="button" id="back" value="이전페이지"
            onclick="location.href='javascript:history.back()'">

      </form>
   </div>

</body>
</html>