<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html><html><head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<meta charset="UTF-8">
<title>신규차량 정보 등록</title>
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
      <h1 class="display-3">신규차량 정보 등록</h1>
   </div>
</div> 
<div class="container">
   <form name="newWrite" action="./CarRigestProcess.car"
      class="form-horizontal" method="post" enctype="multipart/form-data">
    
      <div class="form-group row">
        <label class="col-sm-2 control-label">차량번호</label>
        <div class="col-sm-2">
           <input name="carNumber" class="form-control" required>
        </div>
      </div>

      <div class="form-group row">
        <label class="col-sm-2 control-label">자동차 분류</label>
        <div class="col-sm-3">
           <input name="carSort" class="form-control" placeholder="대형/중형/소형 택1" required>
        </div>
      </div>
      
      <div class="form-group row">
        <label class="col-sm-2 control-label">차 종</label>
        <div class="col-sm-2">
           <input name="carName" class="form-control" required>
        </div>
      </div>

	  <div class="form-group row">
        <label class="col-sm-2 control-label">일일 렌트비</label>
        <div class="col-sm-2">
           <input name="retalFeePerDay" class="form-control" required>
        </div>
      </div>

      
    <div class="form-group row">
      <label class="col-sm-2 control-label">차량 사진</label>
       <div class="col-sm-5">
       <img style="width:100%" id="preview-image">
       <input type="file" name="carPic" class="form-control" id="input-image" required>
       </div>
   </div>
   
     <div class="form-group row">
        <div class="col-sm-offset-2 col-sm-10">
           <input type="submit" class="btn btn-success" value="등록">
           <input type="reset" class="btn btn-primary" value="입력취소">
        </div>
      </div>
     
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