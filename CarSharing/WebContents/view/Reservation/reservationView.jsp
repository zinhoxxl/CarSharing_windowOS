<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>예약 페이지</title>
<style>
    div.jumbotron {
        font-family: 'Do Hyeon', sans-serif;
    }
    h5.control-label {
        font-family: 'Do Hyeon', sans-serif;
    }
    div.modal-header {
        font-family: 'Do Hyeon', sans-serif;
    }
</style>
</head>
<body>
<jsp:include page="/view/main/menu.jsp"/>
<div class="jumbotron">
  <div class="container">
     <h1 class="display-3">이용 가능차량 리스트</h1>
  </div>
</div>
<div class="container">
   <div class="row" align="center">
  
  <!--반복 시작점--> 
  	<c:forEach var="dto" items="${dtoList}">
      <div class="col-md-4">
        <img src="/resource/car/carpic/${dto.carPic}" style="width:100%">
        <table>
        <tr><td>차종: ${dto.carSort}</td></tr>
	    <tr><td>모델명: ${dto.carName}</td></tr>
	    <tr><td>차량번호: ${dto.carNumber}</td></tr>
	    <tr><td>일일이용금액: ${dto.retalFeePerDay}원</td></tr>
        <tr><td><a href="./ReservationRegistForm.car?carNumber=${dto.carNumber}" class="btn btn-success" role="button">&raquo;예약하기</a></td></tr>
       </table>
      </div>
      </c:forEach>
   <!--반복 종료지점-->        
   </div>
   <hr>   
</div>
<jsp:include page="/view/main/footer.jsp"/>
</body>
</html>