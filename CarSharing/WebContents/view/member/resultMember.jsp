<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>회원 정보</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
        <h1 class="display-3">회원 정보</h1>
      </div>
  </div>
  <div class="container" align="center">
      <%
             /* 파라미터로 넘어온 msg 값 얻기 */
      		String msg = (String)request.getAttribute("msg");
    		/* String userid=(String)request.getAttribute("sessionId"); */
            /* 파라미터 값: 0-수정, 1-가입(입력), 2-로그인, 3-회원삭제 */
            if(msg !=null){
            	     if(msg.equals("0"))
            	       	  out.print("<h2 class='alert alert-parimary'>회원정보가 수정되었습니다.</h2>");
            	     else if(msg.equals("1"))
           	       	  out.print("<h2 class='alert alert-success'>회원가입을 축하드립니다.</h2>");
            	     else if(msg.equals("2")){
              	       	out.print("<h2 class='alert alert-info'>");%>${sessionId}<%out.print("님 환영합니다.</h2>");
            	     }else if(msg.equals("3")){
            	    	 session.invalidate();
            	    	 out.print("<h2 class='alert alert-secondary'>회원정보가 삭제되었습니다.</h2>");
            	     }else if(msg.equals("4")){
            	    	 session.invalidate();
            	    	 out.print("<h2 class='alert alert-secondary'>아이디와 비밀번호의 정보가 일치 하지 않습니다.</h2>");
            	     }else if(msg.equals("5")){
            	    	 session.invalidate();
            	    	 response.sendRedirect("LoginForm.car");
            	     }else if(msg.equals("6")){
            	    	 out.print("<h2 class='alert alert-secondary'>예약이 취소 되었습니다. 이용해주셔서 감사합니다.</h2>");
            	     }else if(msg.equals("7")){
            	    	 out.print("<h2 class='alert alert-success'>결제가 완료되었습니다.<br> 픽업일에 예약 확인증과 면허증을 지참하여 예약지점으로 방문해 주세요.</h2>");
            	     }else if(msg.equals("8")){
            	    	 out.print("<h2 class='alert alert-success'>예약이 완료되었습니다.<br> 결제는 '내 예약관리' 페이지에서 진행 해주세요.</h2>");
            	     }
            }else{
	             session.invalidate();
	   	    	 out.print("<h2 class='alert alert-secondary'>지속된 문제 발생시 웹사이트 관리자와 연락바랍니다.</h2>");
            }
            	
      %>
  </div>
</body>
</html>