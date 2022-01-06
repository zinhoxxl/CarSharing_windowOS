<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html><html><head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
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
<title>나의 예약 리스트</title>
</head>
<body>
<jsp:include page="/view/main/menu.jsp"/>
<div class="jumbotron" style="background-color: #ffffff; ">
   <div class="container">
      <h1 class="display-3">나의 예약 리스트</h1>
   </div>
</div>
<div class="container">
     <div>
      <div class="text-right">
             <span class="badge badge-success">전체 ${total_record}</span>
      </div>
    </div>
    <div style="padding-top:50px">
       <table class="table table-hover">
            <tr style="font-family: 'Do Hyeon', sans-serif;">
            <th>예약번호</th>
             <th>아이디</th>
             <th>예약자</th>
             <th>차량종류</th>
             <th>픽업일</th>
             <th>반납일</th>
            </tr>
   <c:if test="${not empty dtoList}">    
       <!--반복 시작점--> 
  	<c:forEach var="dto" items="${dtoList}">
        <tr>
         <td><a href="./PaymentViewAction.car?reservationNo=${dto.reservationNo}">${dto.reservationNo}</a></td>
         <td>${dto.memberId}</td>
         <td>${dto.name}</td>
         <td>${dto.carName}</td>
         <td>${dto.carPickupDate}</td>
         <td>${dto.carReturnDate}</td>
        </tr>
       </c:forEach>       	    	       
   </c:if>  
       </table>
    </div>
  <hr>
</div>
<jsp:include page="/view/main/footer.jsp"/>
</body>
</html>