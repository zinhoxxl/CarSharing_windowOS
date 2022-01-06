<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gothic+A1&family=Nanum+Pen+Script&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Do+Hyeon&family=Gothic+A1&family=Nanum+Pen+Script&family=Public+Sans:ital,wght@1,900&display=swap');
     div.navbar-header{
        font-family: 'Public Sans', sans-serif;
     }
     ul {
        font-family: 'Do Hyeon', sans-serif;
     }

</style>
<nav class="navbar navbar-expand navbar-dark bg-primary">
<div class="container">
  <div class="navbar-header">
  	<h4><a class="navbar-brand" href="<c:url value="/MainViewProcess.car"/>">CarSharing</a></h4>
  </div>
  <div>
  	<ul class="navbar-nav mr-auto">
  	   <c:choose>
  	     <c:when test="${empty sessionId}"><%-- ${sessionId==null} --%>
  	        <li class="nav-item"><a class="nav-link" href="<c:url value="/LoginForm.car"/>">로그인</a></li>
  	        <li class="nav-item"><a class="nav-link" href="<c:url value="/AddMemberForm.car"/>">회원가입</a></li>
  	     </c:when>
  	     <c:otherwise>
  	       <li style="padding-top:7px; color:white;">[${sessionId}님]</li>
  	       <li class="nav-item"><a class="nav-link" href="<c:url value="/LogoutProcess.car"/>">로그아웃</a></li>
  	       <li class="nav-item"><a class="nav-link" href="<c:url value="/MemberManagementForm.car"/>">회원관리</a></li>
  	     </c:otherwise>
  	  </c:choose>
  	   <c:choose>
  	    <c:when test="${sessionId=='admin'}"> <!-- sessionId가 admin일때만 메뉴 보이기 -->
  	  <li class="nav-item"><a class="nav-link" href="<c:url value="/CarManagementAction.car"/>">차량관리</a> <!--sessionId가 admin일때 메뉴활성화-->
  	  </c:when>
  	   </c:choose>
  	  <li class="nav-item"><a class="nav-link" href="<c:url value="/ReservationCarListProcess.car"/>">렌트카 예약</a>
 	  <li class="nav-item"><a class="nav-link" href="<c:url value="/ReservationListProcess.car"/>">내 예약관리</a>
  	  <li class="nav-item"><a class="nav-link" href="<c:url value="/QnABoardListProcess.car"/>">Q&A</a>
 	  <li class="nav-item"><a class="nav-link" href="<c:url value="/NoticeListAction.car"/>">공지사항</a>
  	</ul>
  </div>
</div>
</nav>