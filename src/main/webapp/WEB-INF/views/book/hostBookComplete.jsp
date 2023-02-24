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
      padding-bottom: 10px;
    }
    .for-label {
      color: #000000;
      font-size: 15px;
      width: 650px;
    }
    .delete-form {
      padding-top: 10px;
      padding-left: 10px;
    }
    .contact-form {
      margin-bottom: 50px;
    }
    .book-menu {
      word-spacing: 100px;
      margin-bottom: 30px;
    }
    .book-form {
      margin-bottom: 0px;
    }
    .contact-book-form {
      margin-bottom: 0px;
      padding: 10px !important;
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
        <li class="nav-item"><a href="<c:url value='/hosts/info'/>" class="nav-link title">${userId}</a></li>
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
          <h1 class="mb-4 bread">예약 내역</h1>
        </div>
      </div>
    </div>
  </div>
</div>


<section class="ftco-section contact-section bg-light">
  <div class="container">
    <div class="col-md-12 mb-4" style="text-align: center;"><label class="h3 book-menu"><a href="<c:url value='/hosts/info/book'/>">진행중</a> <a href="<c:url value='/hosts/info/book/complete'/>">완료예약</a> <a href="<c:url value='/hosts/info/book/cancel'/>">취소예약</a></label></div>
    <c:forEach var="bookList" items="${hostBookListDtoList}">
<div class="row block-9 info-menu">
      <!-- <div class="col-md-6 order-md-last d-flex"> -->
      <form action="#" class="bg-white p-5 contact-form contact-book-form">
        <div class="delete-form">
          <div class="form-group book-form">
            <label class="title for-label">${bookList.room} | ${bookList.name} | ${bookList.count} | ${bookList.checkIn} - ${bookList.checkOut}
            </label>
          </div>
          <div class="form-group book-form">
            <label class="title for-label">요구사항 ${bookList.please}
            </label>
          </div>
        </div>
      </form>
    </div>
</c:forEach>
    <div class="row mt-5">
      <div class="col text-center">
        <div class="block-27">
          <ul>
            <c:if test="${ph.showPrev}"><li><a href="<c:url value="/hosts/info/book/complete${ph.getPageInfo(ph.beginPage-1)}"/>">&lt;</a></li></c:if>
            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
              <li<c:if test="${ph.viewPage eq i}"> class="active"</c:if>>
                <a href="<c:url value="/hosts/info/book/complete${ph.getPageInfo(i)}"/>">${i}</a></li>
            </c:forEach>
            <c:if test="${ph.showNext}"><li><a href="<c:url value="/hosts/info/book/complete${ph.getPageInfo(ph.endPage+1)}"/>">&gt;</a></li></c:if>
          </ul>
        </div>
      </div>
    </div>  </div>
</section>



<footer class="ftco-footer ftco-bg-dark ftco-section">
  <div class="container">
    <div class="row mb-5">
      <div class="col-md">
        <div class="ftco-footer-widget mb-4 ml-md-5">
          <h2 class="ftco-heading-2">조원</h2>
          <ul class="list-unstyled">
            <li><a href="#" class="py-2 d-block">강휴일</a></li>
            <li><a href="#" class="py-2 d-block">김남수</a></li>
          </ul>
        </div>
      </div>
      <div class="col-md">
        <div class="ftco-footer-widget mb-4 ml-md-5">
          <h2 class="ftco-heading-2">블로그</h2>
          <ul class="list-unstyled">
            <li><a href="https://hyuil.tistory.com/" class="py-2 d-block">강휴일</a></li>
          </ul>
        </div>
      </div>
      <div class="col-md">
        <div class="ftco-footer-widget mb-4">
          <h2 class="ftco-heading-2">깃허브</h2>
          <ul class="list-unstyled">
            <li><a href="https://github.com/h0l1da2" class="py-2 d-block">강휴일</a></li>
            <li><a href="https://github.com/KimNamSu96" class="py-2 d-block">김남수</a></li>
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
</body>
</html>
