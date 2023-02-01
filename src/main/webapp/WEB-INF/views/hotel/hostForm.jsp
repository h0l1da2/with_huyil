<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>with hyuil mypage</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="author" content="" />
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=|Roboto+Sans:400,700|Playfair+Display:400,700">
	<link rel="stylesheet" type="text/css" href="/resources/static/hotelForm/css/state.css">	

    <!-- Theme Style -->
    <link rel="stylesheet" href="/resources/static/hotelForm/css/style.css">
	
	<!-- 네비바, 풋 css따오기 -->    
    <link rel="stylesheet" href="/resources/static/home/css/style.css">
</head>
<body>
    
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand title" href="/">위드휴일</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a href="/host" class="nav-link">호스트등록</a></li>
                <li class="nav-item"><a href="/user/login" class="nav-link">로그인</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->

    <section class="site-hero inner-page overlay" style="background-image: url(images/hero_4.jpg)" data-stellar-background-ratio="0.5">
      <div class="container">
        <div class="row site-hero-inner justify-content-center align-items-center">
          <div class="col-md-10 text-center" data-aos="fade">
            <h1 class="heading mb-3">myPage</h1>
            <ul class="custom-breadcrumbs mb-4">
              <li><a href="/host">Home</a></li>
            </ul>
          </div>
        </div>
      </div>
      </section>

<div class="step-box">
   <div class="step-state step">
    <ul>
      <li><p>마이페이지</p></li>
      <li><p>호텔등록</p></li>
      <li><p>객실등록</p></li>
    </ul>
  </div>
</div>	

<section id="hotelForm">
<form>
  <div style="margin:0 0 30px 100px;" class="form-group">
  <br>
    <label for="exampleFormControlInput1">이 름</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" id="name" style="width:250px; height:50px;">
    <br> <br>

    <label for="exampleFormControlInput1">전화번호</label>  &nbsp;&nbsp;&nbsp;
    <input type="text" id="tel" placeholder="숫자만입력해주세요" style="width:300px; height:50px;">
    <div class="form-group">
    <br>
    
    <label for="exampleFormControlInput1">거래은행</label> &nbsp;&nbsp;&nbsp;
    <select name="bank" style="width:100px; height:50px;">
    <option value="" selected>---은행선택---</option>
    <option value="1">KEB하나은행</option>
    <option value="2">SC제일은행</option>
    <option value="3">KB국민은행</option>
    <option value="4">IBK기업은행</option>
    <option value="5">NH농협은행</option>
    <option value="6">SH수협은행</option>
    </select> <br> <br>
    
    <label for="exampleFormControlInput1">예금주</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" id="bkname" style="width:250px; height:50px">
    <br> <br>
    
    <label for="exampleFormControlInput1">계좌번호</label> &nbsp;&nbsp;&nbsp;
    <input type="text" id="bkname" placeholder="숫자만 입력해주세요" style="width:300px; height:50px">
    <br> <br>
    
    <label for="exampleFormControlInput1">사업자번호</label>
    <input type="text" id="bkname" placeholder="숫자만 입력해주세요" style="width:300px; height:50px">
    <br> <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
    <button class="w-btn-neon2" type="submit">
        다음단계
    </button>
    <br>
    <br>
    <br>
    
    </div>
  </div>
</form>
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
    
    <script src="/resources/static/hotelForm/js/jquery-3.3.1.min.js"></script>
    <script src="/resources/static/hotelForm/js/jquery-migrate-3.0.1.min.js"></script>
    <script src="/resources/static/hotelForm/js/owl.carousel.min.js"></script>
    <script src="/resources/static/hotelForm/js/jquery.stellar.min.js"></script>
    <script src="/resources/static/hotelForm/js/jquery.fancybox.min.js"></script>
    <script src="/resources/static/hotelForm/js/aos.js"></script>
     
    	<!-- 네비bar 고정 -->
	<script src="/resources/static/home/js/scrollax.min.js"></script>
	<script src="/resources/static/home/js/main.js"></script>
</body>
</html>