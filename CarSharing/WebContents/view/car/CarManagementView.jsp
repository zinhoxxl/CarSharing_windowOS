<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>차량 정보 관리</title>
<script>
function confirmDelete(num, carNumber){
	var result = confirm("선택하신 "+carNumber+" 차량의 정보를 삭제하시겠습니까?");
	if(result){
		location.href="./CarDeleteProcess.car?num="+num;
	}	
}
</script>
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
     <h1 class="display-3">차량 정보 관리</h1>
  </div>
</div>
<div class="container">
   <div class="row" align="center">
 
  <!--반복 시작점--> 
  	<c:forEach var="dto" items="${dtoList}">
      <div class="col-md-4">
        <img src="/resource/car/carpic/${dto.carPic}" style="width:100%">
        <table>
        <tr><td>순번   : ${dto.num}</td></tr>
        <tr><td>차량분류: ${dto.carSort}</td></tr>
	    <tr><td>차량번호: ${dto.carNumber}</td></tr>
	    <tr><td>차   종: ${dto.carName}</td></tr>
	    <tr><td>일일 렌트비: ${dto.retalFeePerDay}원</td></tr>
        <tr><td><a href="./CarUpdateViewProcess.car?carNumber=${dto.carNumber}" class="btn btn-primary" role="button">수정</a> 
        <button class="btn btn-danger" data-toggle="modal" data-target="#exampleModal" onclick="confirmDelete('${dto.num}','${dto.carNumber}')">삭제</button></td></tr>
       </table>
      </div>
      </c:forEach>
   <!--반복 종료지점-->      
   </div>
    <div>
      <div class="text-right">
           <a href="<c:url value="/CarRigestForm.car"/>" class="btn btn-success" role="button">신규등록</a>
      </div>
   </div>
   <hr>   
</div>
<jsp:include page="/view/main/footer.jsp"/>
</body>
</html>