<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html><html><head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="resources/css/plugin/datepicker/bootstrap-datepicker.css">
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/themes/mint-choc/theme.min.css"></script>
<script src="resources/js/plugin/datepicker/bootstrap-datepicker.js"></script>
<script src="resources/js/plugin/datepicker/bootstrap-datepicker.ko.min.js"></script>
 <script>
  $( function() {
    $("#datepicker1").datepicker({
    	format: "yyyy-mm-dd",
    	title: "픽업일",
    	language : "ko"
    });
  } );
  </script>
<script>
  $( function() {
    $("#datepicker2").datepicker({
    	format: "yyyy-mm-dd",
    	title: "반납일",
    	language : "ko"
    });
  } );
</script>
<meta charset="UTF-8">
<title>렌트카 예약</title>
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
      <h1 class="display-3">렌트카 예약</h1>
   </div>
</div> 
<div class="container">
   <form name="newWrite" action="./ReservationRegistProcess.car"
      class="form-horizontal" method="post" enctype="multipart/form-data">
    
<fieldset>
<legend>선택한 차량정보</legend>
      <div class="form-group row">
        <label class="col-sm-2 control-label">차량번호</label>
        <div class="col-sm-2">
           <input name="carNumber" class="form-control" value="${dto.carNumber}" readonly>
        </div>
      </div>

      <div class="form-group row">
        <label class="col-sm-2 control-label">자동차 분류</label>
        <div class="col-sm-1">
           <input class="form-control" value="${dto.carSort}" readonly>
        </div>
      </div>
      
      <div class="form-group row">
        <label class="col-sm-2 control-label">자동차 종류</label>
        <div class="col-sm-2">
           <input name="carName" class="form-control" value="${dto.carName}" readonly>
        </div>
      </div>

      <div class="form-group row">
        <label class="col-sm-2 control-label">일일 렌트비용</label>
        <div class="col-sm-2">
           <input name="retalFeePerDay" class="form-control" value="${dto.retalFeePerDay}" readonly>
        </div>
      </div>
      <br>
      
<legend>이용자 정보 입력</legend>     
      <div class="form-group row">
        <label class="col-sm-2 control-label">차량 픽업일</label>
        <div class="col-sm-3">
           <input type="text" name="carPickupDate" id="datepicker1" class="form-control" required>
        </div>
      </div>
      
       <div class="form-group row">
        <label class="col-sm-2 control-label">차량 반납일</label>
        <div class="col-sm-3">
           <input type="text" name="carReturnDate" id="datepicker2" class="form-control" required>
        </div>
      </div>
      
      
      
	  <div class="form-group row">
        <label class="col-sm-2 control-label">이용자</label>
        <div class="col-sm-2">
           <input name="name" class="form-control" placeholder="실제 운전자 성함" required>
        </div>
      </div>

	
	<div class="form-group row">
              <label class="col-sm-2">생년월일</label>
              <div class="col-sm-4">
                   <input type="text" name="birthyy" maxlength="4" placeholder="년(4자)" size="6" required>
                   <select name="birthmm" required>
                   	<option value="">월</option>
                   	<option value="01">1</option>
                   	<option value="02">2</option>
                   	<option value="03">3</option>
                   	<option value="04">4</option>
                   	<option value="05">5</option>
                   	<option value="06">6</option>
                   	<option value="07">7</option>
                   	<option value="08">8</option>
                   	<option value="09">9</option>
                   	<option value="10">10</option>
                   	<option value="11">11</option>
                   	<option value="12">12</option>
                   </select>
                   <input type="text" name="birthdd" maxlength="2" placeholder="일" size="4" required>
              </div>
        </div>
	
		
		<div class="form-group row">
         <label class="col-sm-2">휴대전화</label>
         <div class="col-sm-5">
               <select name="phone1" required>
		              <option value="010" selected>010</option>
		              <option value="011">011</option>
		              <option value="016">016</option>
		              <option value="017">017</option>
		              <option value="019">019</option>
		           </select>
				- <input maxlength="4" size="4" name="phone2" required> -
				<input maxlength="4" size="4" name="phone3" required>
         </div>
       </div>
		
      
    <div class="form-group row">
      <label class="col-sm-2 control-label">면허증 업로드</label>
       <div class="col-sm-5">
       <img style="width:500px" id="preview-image">
       <input type="file" name="driverLicence" class="form-control" id="input-image" required>
       </div>
   </div>
   
     <div class="form-group row">
        <div class="col-sm-offset-2 col-sm-10">
           <input type="submit" class="btn btn-success" value="예약">
           <input type="reset" class="btn btn-primary" value="취소">
        </div>
      </div>
</fieldset>      
   </form>
</div>
<jsp:include page="/view/main/footer.jsp"/>
</body>
</html>
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