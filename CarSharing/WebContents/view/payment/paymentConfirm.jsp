<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>     
<title>예약 확정 정보</title>
<script>
function confirmDelete(reservationNo){
 location.href="./PaymentCancelAction.car?reservationNo="+reservationNo;
}
</script>
</head>
<body>
<jsp:include page="/view/main/menu.jsp"/>
<div class="jumbotron">
    <div class="container">
      <h1 class="display-3">예약 확정 정보</h1>
    </div>
</div>
<div class="container col-8 alert alert-info" >
    <div class="text-center">
         <h1>예약 확인증</h1>
    </div>
    <div class="row justify-content-between">
            <div class="col-4" align="left">
               <strong>예약번호</strong><br>예약자:${dto.name}<br>
               아이디:${dto.memberId}<br>
               생년월일:${dto.birth}<br>
               전화번호:${dto.phone}<br>
            </div>
            <div class="col-4" align="right">
                <p><em>렌턴카 픽업일:${resvDto.carPickupDate}</em></p> <!--예약테이블에서 정보 가져와서 값 출력-->
                <p><em>렌턴카 반납일:${resvDto.carReturnDate}</em></p> <!--예약테이블에서 정보 가져와서 값 출력-->
            </div>
    </div>
    <div>
      <table class="table table-hover">
        <tr>
         <th class="text-center">차량정보</th>
        </tr>
        <tr>
        	<td class="text-center"><em>차   종: ${resvDto.carName}</em></td>
        	<td class="text-center"><em>차량번호: ${resvDto.carNumber}</em></td>
        </tr>
        <tr>
         <td></td>
         <td></td>
         <td class="text-right"><strong>총 렌트비 :</strong></td>
         <td class="text-center text-danger"><strong>${dto.totalRentalFee}</strong></td>
        </tr> 
      </table>
      <a type="button" class="btn btn-primary" href="./PaymentResultForm.car">예약완료</a>
     <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">예약취소</button>
        </div>    
</div>
<jsp:include page="/view/main/footer.jsp"/>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">예약 취소</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
         ${dto.name}님 예약을 취소 하시겠습니까?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">아니오</button>
        <button type="button" class="btn btn-primary" onclick="confirmDelete('${dto.reservationNo}')">예</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>