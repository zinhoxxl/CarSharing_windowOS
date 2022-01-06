<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head>
<link rel="stylesheet" 
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>      
<meta charset="UTF-8">
<title>예약관리</title>
<style>
 div.jumbotron {
        font-family: 'Do Hyeon', sans-serif;
    }
    div.control-label {
        font-family: 'Do Hyeon', sans-serif;
    }
    
</style>
</head>
<body>
<jsp:include page="/view/main/menu.jsp"/>
<div class="jumbotron">
   <div class="container">
     <h1 class="display-3">예약관리</h1>
   </div>
</div>
<c:choose>
<c:when test="${resvDto.reservationNo!=0}">
<div class="container">
   <form action="<c:url value="PaymentAction.car"/>" class="form-horizontal" method="post">
      
<div class="form-group row">
       <label class="col-sm-2 control-label">예약번호</label>
        <div class="col-sm-3">
            <input name="reservationNo" class="form-control" value="${resvDto.reservationNo}" readonly> <!-- 여기 커맨드 부분에서 수정 원래 payment에서 오게했었음 -->
        </div>
    </div>
    
  <div class="form-group row">
       <label class="col-sm-2 control-label">차량 픽업일</label>
        <div class="col-sm-3">
            <input name="carPickupDate" class="form-control" value="${resvDto.carPickupDate}" readonly>
        </div>
    </div>  
    
    <div class="form-group row">
       <label class="col-sm-2 control-label">차량 반납일</label>
        <div class="col-sm-3">
            <input name="carReturnDate" class="form-control" value="${resvDto.carReturnDate}" readonly>
        </div>
    </div>
    
    
        <div class="form-group row">
       <label class="col-sm-2 control-label">사용기간(일)</label> 
        <div class="col-sm-3">
            <input name="rentalDate" class="form-control" value="${resvDto.rentalDate}" readonly> <!--여기 커맨드 부분에서 수정 -테이블 수정 필요 / -->
        </div>
    </div>
    
           <div class="form-group row">
        <label class="col-sm-2 control-label">총 렌트비(원)</label>
        <div class="col-sm-3">
            <input name="totalRentalFee" class="form-control" value="${resvDto.totalRentalFee}" readonly>
        </div>
    </div>
       
      <div class="form-group row">
        <label class="col-sm-2 control-label">아이디</label>
        <div class="col-sm-3">
            <input name="memberId" class="form-control" value="${resvDto.memberId}" readonly>
        </div>
    </div>  
       
    <div class="form-group row">
        <label class="col-sm-2 control-label">이름</label> <!-- 예약시 등록한 이름  -->
        <div class="col-sm-3">
            <input name="name" class="form-control" value="${resvDto.name}" readonly> 
        </div>
    </div>

    <div class="form-group row">
              <label class="col-sm-2 control-label">생년월일</label>
              <div class="col-sm-3">
                  <input name="birth" class="form-control" value="${resvDto.birth}" readonly> 
              </div>
        </div>
        
        <div class="form-group row">
         <label class="col-sm-2 control-label">전화번호</label>
         <div class="col-sm-3">
				<input name="phone" class="form-control" value="${resvDto.phone}" readonly> 
         </div>
       </div>
     <div class="form-group row">
      <label class="col-sm-2">면허증</label>
       <div class="col-sm-5">
         <img name="driverLicence" style="width: 500px;" id="preview-image" src="/resources/reservation/images/${resvDto.driverLicence}" alt="${resvDto.driverLicence}">
       </div>
   </div>
		
	  <div class="form-gorup row">
          <div class="col-sm-offset-2 col-sm-10">
               <input type="submit" class="btn btn-primary" value="결제">
          </div>
       </div>
		
    </form>
    </div>
    </c:when>
    <c:otherwise>
		  <div class="container" align="center">
		  <h2 class='alert alert-secondary'>예약 내역이 존재하지 않습니다.</h2>
		  </div>
    </c:otherwise>
   </c:choose>

 <jsp:include page="/view/main/footer.jsp"/>              
<script>
function readImage(input) {
    // 인풋 태그에 파일이 있는 경우
    if(input.files && input.files[0]) {
        // 이미지 파일인지 검사 (생략)
        // FileReader 인스턴스 생성
        const reader = new FileReader()
        // 이미지가 로드가 된 경우
        reader.onload = e => {
            const previewImage = document.getElementById("preview-image")
            previewImage.src = e.target.result
        }
        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0])
    }
}
// input file에 change 이벤트 부여
const inputImage = document.getElementById("input-image")
inputImage.addEventListener("change", e => {readImage(e.target)})
</script>    
</body>
</html>