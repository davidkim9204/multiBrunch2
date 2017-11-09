<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</script>
<link rel="stylesheet" type="text/css" href="css/shop.css">
<style>
   .logout{
      margin-right: 20.3%;   
   }
</style>
</head>
<body>
   <form action="logout.do" method="get" name="frm" align="right">
      <input type="button" value = "로그아웃 " class="logout" />
   </form>
   <form action="compareservlet.do" name="form" method="get" onsubmit="return chkchk(this);">
   <div id="wrap" align="center">
      <h1>맛집 리스트</h1>
      <table class="list">
         <tr>
            <td colspan="6" style="border: #000022; text-align: right"><a
               href="RestaurantServlet?command=Restaurant_write_form">맛집 등록</a></td>
         </tr>

         <c:forEach var="Restaurant" items="${RestaurantList }">
            <tr class="record" align="center">
				<td width="300px"><img src="img/chch.jpg" width="280px" height="190px"></td>
<%-- 				${Restaurant.Picture1 } --%>
               <td width="350px" style="text-align:left" ><font size=5 ><a href="ReMeservlet.do?userid=${Restaurant.rId}">
                     ${Restaurant.rName } </a></font>
                    <br><font color=grey size=4>${Restaurant.rCategory}</font>
                     <br><br><br><font size=3>${Restaurant.rRate } / 10</font>
                     <br>평점
                     </td>
                    
               <td width="350px" style="text-align:left"><font size=3>거리 : ${Restaurant.rDistance} m 
               <br><br>주소 : ${Restaurant.rAddress}
               <br><br>전화 : ${Restaurant.rTel}  
               <br><br>선택 <input type="checkbox" style="text-align:right;" name="comsel" onClick="CountChecked(this);" value="${Restaurant.rId }"/>
               </font>
               </td>
            </tr>
         </c:forEach>   
         <tr>
            <td colspan="6" style="border: #000022; text-align: center">
            <br><input type="submit" value="비교하기"></td>
         </tr>
               
      </table>
      </div>
      </form>
      
      <body onload="document.form.reset();">
      
</body>
</html>