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
      padding-left: 130px;
      display : flex;
      justify-content: center;
      width: 1000px;
    }
    .info-title {
      font-size: 40px;
    }
    .msg-box {
      margin-top: 20px;
      padding-top: 10px;
      padding-left: 13px;
      padding-right: 13px;
      padding-bottom: 10px;
      width: 550px;
    }
    .for-label {
      color: #000000;
      font-size: 20px;
    }
    .for-delete {
      width: 19px;
      height: 19px;
      margin-right: 10px;
    }
    .delete-form {
      padding-top: 25px;
      padding-left: 25px;
    }
    .deleteBtn {
      margin-top: 10px;
      margin-left: 200px;
    }
    .for-pwd {
      width: 350px;
    }
    .for-delete-div {
      margin-left: 100px;
    }
    .for-pwd-delete {
      margin-left: 32px;
    }
    .text-type {
      color: #dc3545;
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
        <li class="nav-item"><a href="<c:url value='/user/info'/>" class="nav-link title">${userId}</a></li>
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
          <h1 class="mb-4 bread">회원 탈퇴</h1>
        </div>
      </div>
    </div>
  </div>
</div>


<section class="ftco-section contact-section bg-light">
  <div class="container">
    <div class="row d-flex mb-5 contact-info">
      <div class="col-md-12 mb-4" style="text-align: center;">
        <label class="h3 info-title">탈퇴하시겠어요?</label>
      </div>
    </div>
    <div class="row block-9 info-menu">
      <form class="bg-white p-5 contact-form" style="width: 696px;">
        <div class="delete-form">
          <div class="form-group">
            <label class="title for-label"><input type="checkbox" name="deleteReason" id="privacy" class="custom-check-box for-delete" value="privacy">개인정보 보호를 위해</label>
          </div>
          <div class="form-group">
            <label class="title for-label"><input type="checkbox" name="deleteReason" id="otherSite" class="custom-check-box for-delete" value="otherSite">다른 사이트가 더 낫다</label>
          </div>
          <div class="form-group">
            <label class="title for-label"><input type="checkbox" name="deleteReason" id="hate" class="custom-check-box for-delete" value="hate">이 사이트는 개구리다</label>
          </div>
          <div class="form-group">
            <label class="title for-label"><input type="checkbox" name="deleteReason" id="joinAgain" class="custom-check-box for-delete" value="joinAgain">재가입할 거다</label>
          </div>
          <div class="form-group">
            <label class="title for-label">기타 이유
              <textarea id="etc" cols="30" rows="7" class="form-control msg-box" placeholder="Message"></textarea></label>
          </div>
          <div class="for-delete-div">
            <div class="form-group">
              <label class="title for-label for-pwd-delete">계정 비밀번호를 입력해주세요</label>
            </div>
            <div class="form-group">
              <input type="password" id="password" class="form-control for-pwd" placeholder="계정 비밀번호">
              <span class="title text-type" id="passwordCheck">비밀번호를 입력해주세요</span>
            </div>
          </div>
          <div class="form-group">
            <span class="title text-type" id="passwordFail">비밀번호가 틀립니다</span>
            <input type="button" id="deleteButton" value="탈퇴하기" class="btn btn-primary py-3 px-5 deleteBtn">
            <span class="title text-type" id="whyDelete">탈퇴 이유를 알려주세요 ㅠ_ㅠ</span>
          </div>
        </div>
      </form>
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
<script src="<c:url value='/resources/static/home/js/google-map.js'/>"></script>
<script src="<c:url value='/resources/static/home/js/main.js'/>"></script>
<script>
  $(document).ready(function(){
    $('#password').on("propertychange change keyup paste input", function (frm) {
      $('#passwordCheck').css('display', 'none');
    });
    $('#deleteButton').click(function () {
      let totalCnt = 0;
      let whyDelete = new Array();
      $('#whyDelete').css('display', 'none');
      $('input:checkbox[name="deleteReason"]').each(function () {
        if(this.checked) {
          whyDelete[totalCnt] = this.value;
          totalCnt++;
        }
      });

      let password = document.getElementById("password").value;
      let etc = document.getElementById("etc").value;
      console.log(password);
      console.log(etc);
      console.log(whyDelete);
      console.log(totalCnt);

      if(totalCnt == 0 && etc == "") {
        console.log("내용없음");
        $('#whyDelete').css('display', 'block');
        return false;
      }
      if(password == "") {
        console.log("패스워드없음");
        $('#passwordCheck').css('display', 'block');
        return false;
      }

      console.log("Dto시작");
      let deleteDto = JSON.stringify({'password':password, 'whyDelete':whyDelete, 'etc': etc, 'userId':'${userId}'});
      console.log("Dto끝");

      $.ajax({
        type: 'POST',
        url: '/user/info/delete',
        contentType: "application/json",
        data: deleteDto,
        dataType: 'text',
        success: function (result) {
          if(result=='탈퇴 성공') {
            alert("탈퇴가 완료되었습니다");
            location.href = "/";
          } else {
            alert(result);
          }
        },
        error: function(result) {
          alert("통신 실패");
        }});
    });
  });
</script>
</body>
</html>
