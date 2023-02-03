<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
  <title>위드휴일</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i" rel="stylesheet">

  <link rel="stylesheet" href="<c:url value='/resources/static/home/css/open-iconic-bootstrap.min.css'/>">

  <link rel="stylesheet" href="<c:url value='/resources/static/home/css/animate.css'/>">

  <link rel="stylesheet" href="<c:url value='/resources/static/home/css/owl.carousel.min.css'/>">
  <link rel="stylesheet" href="<c:url value='/resources/static/home/css/owl.theme.default.min.css'/>">
  <link rel="stylesheet" href="<c:url value='/resources/static/home/css/magnific-popup.css'/>">

  <link rel="stylesheet" href="<c:url value='/resources/static/home/css/aos.css'/>">

  <link rel="stylesheet" href="<c:url value='/resources/static/home/css/ionicons.min.css'/>">

  <link rel="stylesheet" href="<c:url value='/resources/static/home/css/bootstrap-datepicker.css'/>">
  <link rel="stylesheet" href="<c:url value='/resources/static/home/css/jquery.timepicker.css'/>">

  <link rel="stylesheet" href="<c:url value='/resources/static/home/css/flaticon.css'/>">
  <link rel="stylesheet" href="<c:url value='/resources/static/home/css/icomoon.css'/>">
  <link rel="stylesheet" href="<c:url value='/resources/static/home/css/style.css'/>">
  <style>
    .title {
      font-family: 'yg-jalnan';
      src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff') format('woff');
      font-weight: normal;
      font-style: normal;
    }
    .info-menu {
      display : flex;
      justify-content: center;
      align-items : center;
    }
    .hide {
      display: none;
    }
    .infoBtn {
      font-size: 28px;
      color: black;
    }
    .menuBtn {
      cursor: pointer;
      margin: 0px 0px 8px;
    }
    .info-title {
      font-size: 50px;
    }
    .text-type {
      color: #dc3545;
      display: none;
    }
    .forSpan {
      margin-bottom: 15px;
    }
    .codeSend {
      display: none;
    }

  </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
  <div class="container">
    <a class="navbar-brand title" href="<c:url value='/'/>">위드휴일</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="oi oi-menu"></span> Menu
    </button>

    <div class="collapse navbar-collapse" id="ftco-nav">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item"><a href="<c:url value='/logout'/>" class="nav-link title">로그아웃</a></li>
        <li class="nav-item"><a href="<c:url value='/users/info'/>" class="nav-link title">${userId}</a></li>
      </ul>
    </div>
  </div>
</nav>
<!-- END nav -->

<div class="hero-wrap" style="background-image: url(<c:url value='/resources/static/home/images/bg_1.jpg'/>);">
  <div class="overlay"></div>
  <div class="container">
    <div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
      <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
        <div class="text">
          <h1 class="mb-4 bread">회원 관리</h1>
        </div>
      </div>
    </div>
  </div>
</div>


<section class="ftco-section contact-section bg-light">
  <div class="container">
    <div class="row d-flex mb-5 contact-info">
      <div class="col-md-12 mb-4" style="text-align: center;">
<<<<<<< HEAD
        <label><a href="<c:url value="/user/info" />" class="h3 info-title infoBtn">${username} 회원님</a></label>
=======
        <label><a href="<c:url value="/users/info" />" class="h3 info-title infoBtn">${username} 회원님</a></label>
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
      </div>
    </div>

    <div class="row block-9 info-menu" style="text-align: center;">
      <form action="#" class="bg-white p-5 contact-form">
        <div>
<<<<<<< HEAD
          <h2><a href="<c:url value="/user/info/book"/>" class="infoBtn">예약 내역</a></h2>
=======
          <h2><a href="" class="infoBtn">예약 내역</a></h2>
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
        </div>
        </ul>
      </form>
    </div>

    <div class="row block-9 info-menu" style="text-align: center;">
      <form action="#" class="bg-white p-5 contact-form">
        <div class="menu">
          <h2><label class="h3 menuBtn">이메일 변경</label></h2>
          <ul class="hide">
            <div class="form-group">
              <input type="text" id="email" class="form-control forSpan" placeholder="기존 이메일">
              <span class="title text-type" id="emailFail" name="emailFail">기존 이메일이 다릅니다</span>
            </div>
            <div class="form-group">
              <input type="text" id="newEmail" class="form-control" placeholder="변경 이메일">
            </div>
            <div class="form-group">
              <input type="button" id="emailSend" value="이메일 전송" class="btn btn-primary py-3 px-5">
            </div>
            <div class="hide sendBtn">
              <div class="form-group">
                <input type="text" id="emailCode" class="form-control forSpan" placeholder="이메일 코드 입력">
                <span class="title text-type codeSend">코드를 전송했습니다 입력해주세요</span>
              </div>
              <div class="form-group">
                <input type="button" id="codeSend" value="코드 확인" class="btn btn-primary py-3 px-5">
              </div>
            </div>
          </ul>
      </form>
    </div>

    <form action="#" class="bg-white p-5 contact-form">
      <div class="menu">
        <h2><label class="h3 menuBtn">비밀번호 변경</label></h2>
        <ul class="hide">
          <div class="form-group">
            <input type="password" id="password" class="form-control" placeholder="기존 패스워드">
            <span class="title text-type" id="passwordFail" name="passwordFail">기존 패스워드를 확인해주세요</span>
          </div>
          <div class="form-group">
            <input type="password" id="newPassword" class="form-control" placeholder="변경 패스워드">
          </div>
          <div class="form-group">
            <input type="password" id="newPasswordCheck" class="form-control" placeholder="패스워드 확인">
            <span class="title text-type" id="newPasswordFail" name="newPasswordFail">패스워드가 서로 다릅니다</span>
          </div>
          <div class="form-group">
            <input type="button" id="passwordUpdate" value="비밀번호 변경" class="btn btn-primary py-3 px-5">
          </div>
        </ul>
      </div>
    </form>

  </div>

  <div class="row block-9 info-menu" style="text-align: center;">
    <form action="#" class="bg-white p-5 contact-form">
      <div class="menu">
        <h2><label class="h3 menuBtn">SNS 연결 정보</label></h2>
        <ul class="hide">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="카카오톡">
          </div>
          <div class="form-group">
            <input type="text" class="form-control" placeholder="페이스북">
          </div>
          <div class="form-group">
            <input type="text" class="form-control" placeholder="구글">
          </div>
          <div class="form-group">
            <input type="submit" value="연결 끊기" class="btn btn-primary py-3 px-5">
          </div>
        </ul>
      </div>
    </form>
  </div>

  <div class="row block-9 info-menu" style="text-align: center;">
    <form action="#" class="bg-white p-5 contact-form">
      <div>
        <h2><a href="" class="infoBtn">회원 탈퇴</a></h2>
      </div>
      </ul>
    </form>
  </div>
  </div>
  </div>
  </div>
  </div>
</section>



<footer class="ftco-footer ftco-bg-dark ftco-section">
  <div class="container">
    <div class="row mb-5">
      <div class="col-md">
        <div class="ftco-footer-widget mb-4">
          <h2 class="ftco-heading-2">놓칠 수 없다</h2>
          <p>진짜 개쩌는 호텔진짜 개쩌는 호텔진짜 개쩌는 호텔진짜 개쩌는 호텔진짜 개쩌는 호텔진짜 개쩌는 호텔진짜 개쩌는 호텔진짜 개쩌는 호텔진짜 개쩌는 호텔ㅇㅇ</p>
        </div>
      </div>
      <div class="col-md">
        <div class="ftco-footer-widget mb-4 ml-md-5">
          <h2 class="ftco-heading-2">블로그</h2>
          <ul class="list-unstyled">
            <li><a href="#" class="py-2 d-block">강휴일</a></li>
            <li><a href="#" class="py-2 d-block">Rooms</a></li>
            <li><a href="#" class="py-2 d-block">Amenities</a></li>
            <li><a href="#" class="py-2 d-block">Gift Card</a></li>
            <li><a href="#" class="py-2 d-block">Services</a></li>
          </ul>
        </div>
      </div>
      <div class="col-md">
        <div class="ftco-footer-widget mb-4">
          <h2 class="ftco-heading-2">깃허브</h2>
          <ul class="list-unstyled">
            <li><a href="#" class="py-2 d-block">강휴일</a></li>
            <li><a href="#" class="py-2 d-block">About Us</a></li>
            <li><a href="#" class="py-2 d-block">Contact Us</a></li>
            <li><a href="#" class="py-2 d-block">Services</a></li>
            <li><a href="#" class="py-2 d-block">Services</a></li>
          </ul>
        </div>
      </div>
      <div class="col-md">
        <div class="ftco-footer-widget mb-4">
          <h2 class="ftco-heading-2">고객지원</h2>
          <div class="block-23 mb-3">
            <ul>
              <li><span class="icon icon-map-marker"></span><span class="text">서울특별시 금천구<br/>가산디지털1로 70<br/>호서대벤처타워 4층</span></li>
              <li><a href="#"><span class="icon icon-phone"></span><span class="text">010 8346 8610</span></a></li>
              <li><a href="#"><span class="icon icon-envelope"></span><span class="text">whaleee@naver.com</span></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12 text-center">

        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
          Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart color-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
          <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
      </div>
    </div>
  </div>
</footer>



<!-- loader -->
<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


<script src="<c:url value='/resources/static/home/js/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/jquery-migrate-3.0.1.min.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/popper.min.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/jquery.easing.1.3.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/jquery.waypoints.min.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/jquery.stellar.min.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/owl.carousel.min.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/jquery.magnific-popup.min.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/aos.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/jquery.animateNumber.min.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/bootstrap-datepicker.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/jquery.timepicker.min.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/scrollax.min.js'/>"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="<c:url value='/resources/static/home/js/google-map.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/main.js'/>"></script>
<script>
<<<<<<< HEAD
  function CheckEmail(str){
    let reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
    if(!reg_email.test(str)) {
      return false;
    }else {
      return true;
    }
  }
=======

>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
  $(document).ready(function(){

    $('#newPasswordCheck').on("propertychange change keyup paste input", function (frm) {
      $('#newPasswordFail').css('display', 'block');
      if(document.getElementById('newPassword').value == document.getElementById('newPasswordCheck').value) {
        $('#newPasswordFail').css('display', 'none');
        return false;
      }
    });
    $('#newPassword').on("propertychange change keyup paste input", function (frm) {
      $('#newPasswordFail').css('display', 'block');
      if(document.getElementById('newPassword').value == document.getElementById('newPasswordCheck').value) {
        $('#newPasswordFail').css('display', 'none');
        return false;
      }
    });

    $('#passwordUpdate').click(function () {
      let password = document.getElementById("password").value;
      let newPassword = document.getElementById("newPassword").value;
      let newPasswordCheck = document.getElementById("newPasswordCheck").value;
<<<<<<< HEAD
      let regNum = /^.{6,20}$/;
=======
      console.log(password);
      console.log(newPassword);
      console.log('${userId}');
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))

      if(password=="" || newPassword == "" || newPasswordCheck == "") {
        alert("빈칸 없이 입력하세요");
        return false;
      }
      if($('#newPasswordFail').css('display') == 'block') {
        alert("변경 패스워드가 서로 다릅니다");
        return false;
      }
<<<<<<< HEAD
      if(!regNum.test(newPassword)) {
        alert("비밀번호는 6~20자리여야 합니다");
        document.getElementById("password").focus();
        return false;
      }
      $.ajax({
        type: 'POST',
        url: '/user/info/modify/password',
=======
      $.ajax({
        type: 'POST',
        url: '/users/info/modify/password',
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
        contentType: "application/json",
        data: JSON.stringify({password:password, newPassword:newPassword, userId:'${userId}'}),
        dataType: 'text',
        success: function (result) {
          if(result=='변경 완료') {
            alert("변경이 완료되었습니다")
            $('#newPasswordFail').css('display', 'none');
            $('#passwordFail').css('display', 'none');
          } else {
            alert(result);
          }
        },
        error: function(result) {
          alert("확인실패");
        }})
    })

    let newEmail;
    $('#emailSend').click(function () {
      let email = document.getElementById("email").value;
      newEmail = document.getElementById("newEmail").value;
<<<<<<< HEAD
=======
      console.log(email);
      console.log(newEmail);
      console.log('${userId}');
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))

      if(email=="") {
        alert("이메일을 입력하세요");
        document.getElementById("email").focus();
        return false;
      }
      if(newEmail=="") {
        alert("새로운 이메일 입력");
        document.getElementById("newEmail").focus();
        return false;
      }
<<<<<<< HEAD
      if(!CheckEmail(newEmail))	{
        alert("이메일 형식이 잘못되었습니다");
        document.getElementById("newEmail").focus();
        return false;
      }
      $.ajax({
        type: 'POST',
        url: '/user/info/modify/emailValid',
=======
      $.ajax({
        type: 'POST',
        url: '/users/info/modify/emailValid',
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
        contentType: "application/json",
        data: JSON.stringify({email:email, newEmail:newEmail, userId:'${userId}'}),
        dataType: 'text',
        success: function (result) {
          if(result=='false') {
            $('#emailFail').css('display', 'block');
          } else {
            $('#emailFail').css('display', 'none');
            $(".sendBtn").slideDown();
            $('.codeSend').css('display', 'block');
          }
        },
        error: function(result) {
          alert("확인실패");
        }})
  })
    $('#codeSend').click(function () {
      let code = document.getElementById("emailCode").value;
      console.log(code);
      if(code=="") {
        alert("코드를 입력하세요");
        document.getElementById("emailCode").focus();
        return false;
      }
      $.ajax({
        type: 'POST',
<<<<<<< HEAD
        url: '/user/info/modify/email',
=======
        url: '/users/info/modify/email',
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
        contentType: "application/json",
        data: JSON.stringify({newEmail:newEmail, code:code, userId:'${userId}'}),
        dataType: 'text',
        success: function (result) {
          if(result=='true') {
            alert("이메일 변경 완료!");
            $(".sendBtn").slideUp();
          } else {
            alert("코드가 다릅니다");
          }
        },
        error: function(result) {
          alert("확인실패");
        }})
    })
    $(".menu>h2").click(function(){
      var submenu = $(this).next("ul");
      if( submenu.is(":visible") ){
        submenu.slideUp();
      }else{
        submenu.slideDown();
      }
    });

  });
</script>
</body>
</html>
