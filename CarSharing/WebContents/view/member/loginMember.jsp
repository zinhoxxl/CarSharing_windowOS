<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
<title>로그인</title>
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
         <h1 class="display-3">로그인</h1>
     </div>
 </div>
  <div class="container" align="center">
     <div class="col-md-4 col-md-offset-4">
          <h3 class="form-signin-heading">Please sign in</h3>
          <%
          	 String error = request.getParameter("error");
              if(error!=null){
            	  out.print("<div class='alert alert-danger'>");
            	  out.print("아이디와 비밀번호를 확인해 주세요");
            	  out.print("</div>");
              }
          %> 
          <form class="form-signin" action="<c:url value="/LoginProcess.car"/>" method="post">
              <div class="form-group">
                  <label for="inputUserName" class="sr-only">User Name</label>
                  <input type="text" class="form-control" placeholder="ID" name="id" required autofocus>
              </div>
              <div class="form-group">
                 <label class="sr-only" for="inputPassword">Password</label>
                 <input type="password" class="form-control" placeholder="Password" name="password" required>
              </div>
              <button class="btn btn btn-lg btn-success btn-block" type="submit">로그인</button>
              <button class="btn btn btn-lg btn-secondary btn-block" type="button" 
                        onclick="location.href='<c:url value="/AddMemberForm.car"/>'">회원가입</button>
          </form>
     </div>
  </div>
</body>
</html>