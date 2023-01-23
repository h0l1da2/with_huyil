<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <title>위드휴일</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i" rel="stylesheet">

    <link rel="stylesheet" href="<c:url value='/static/home/css/open-iconic-bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/home/css/open-iconic-bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/home/css/open-iconic-bootstrap.min.css'/>">

    <link rel="stylesheet" href="<c:url value='/static/home/css/animate.css'/>">

    <link rel="stylesheet" href="<c:url value='/static/home/css/owl.carousel.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/home/css/owl.theme.default.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/home/css/magnific-popup.css'/>">

    <link rel="stylesheet" href="<c:url value='/static/home/css/aos.css'/>">

    <link rel="stylesheet" href="<c:url value='/static/home/css/ionicons.min.css'/>">

    <link rel="stylesheet" href="<c:url value='/static/home/css/bootstrap-datepicker.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/home/css/jquery.timepicker.css'/>">

    <link rel="stylesheet" href="<c:url value='/static/home/css/flaticon.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/home/css/icomoon.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/home/css/style.css'/>">
    <style>
        .title {
            font-family: 'yg-jalnan';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }
    </style>
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
                <li class="nav-item"><a href="/user/loginForm" class="nav-link">로그인</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->

<section class="home-slider owl-carousel">
    <div class="slider-item" style="background-image:url(static/home/images/bg_1.jpg);">
        <div class="overlay"></div>
        <div class="container">
            <div class="row no-gutters slider-text align-items-center justify-content-center">
                <div class="col-md-12 ftco-animate text-center">
                    <div class="text mb-5 pb-3">
                        <h1 class="mb-3">어디에서 휴일을 즐기시나요?</h1>
                        <h2>당신의 휴일을 디자인하세요</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-booking">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <form action="#" class="booking-form">
                    <div class="row">
                        <div class="col-md d-flex">
                            <div class="form-group p-4 align-self-stretch d-flex align-items-end">
                                <div class="wrap">
                                    <label for="#">WHERE</label>
                                    <div class="form-field">
                                        <div class="select-wrap">
                                            <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                            <select name="" id="" class="form-control">
                                                <option value="">서울</option>
                                                <option value="">Family Room</option>
                                                <option value="">Deluxe Room</option>
                                                <option value="">Classic Room</option>
                                                <option value="">Superior Room</option>
                                                <option value="">Luxury Room</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 d-flex">
                            <div class="form-group p-4 align-self-stretch d-flex align-items-end">
                                <div class="wrap">
                                    <label for="#">Check-in</label>
                                    <input type="text" class="form-control checkin_date" placeholder="체크인">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 d-flex">
                            <div class="form-group p-4 align-self-stretch d-flex align-items-end">
                                <div class="wrap">
                                    <label for="#">Check-out</label>
                                    <input type="text" class="form-control checkout_date" placeholder="체크아웃">
                                </div>
                            </div>
                        </div>

                        <div class="col-md d-flex">
                            <div class="form-group p-4 align-self-stretch d-flex align-items-end">
                                <div class="wrap">
                                    <label for="#">Customer</label>
                                    <div class="form-field">
                                        <div class="select-wrap">
                                            <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                            <select name="" id="" class="form-control">
                                                <option value="">1 인</option>
                                                <option value="">2 인</option>
                                                <option value="">3 인</option>
                                                <option value="">4 인</option>
                                                <option value="">5 인</option>
                                                <option value="">6 인이상</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md d-flex">
                            <div class="form-group d-flex align-self-stretch">
                                <input type="submit" value="검색" class="btn btn-primary py-3 px-4 align-self-stretch">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section bg-light">
    <div class="container">
        <div class="row justify-content-center mb-5 pb-3">
            <div class="col-md-7 heading-section text-center ftco-animate">
                <h2 class="mb-4">추천 지역</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-sm col-md-6 col-lg-4 ftco-animate">
                <div class="room">
                    <a href="hotelList.jsp" class="img d-flex justify-content-center align-items-center" style="background-image: url(static/home/images/room-1.jpg);">
                        <div class="icon d-flex justify-content-center align-items-center">
                            <span class="icon-search2"></span>
                        </div>
                    </a>
                    <div class="text p-3 text-center">
                        <h3 class="mb-3"><a href="hotelList.jsp">서울</a></h3>
                        <hr>
                        <p class="pt-1"><a href="room-single.html" class="btn-custom">지금 찾아보기 <span class="icon-long-arrow-right"></span></a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm col-md-6 col-lg-4 ftco-animate">
                <div class="room">
                    <a href="hotelList.jsp" class="img d-flex justify-content-center align-items-center" style="background-image: url(static/home/images/room-2.jpg);">
                        <div class="icon d-flex justify-content-center align-items-center">
                            <span class="icon-search2"></span>
                        </div>
                    </a>
                    <div class="text p-3 text-center">
                        <h3 class="mb-3"><a href="hotelList.jsp">부산</a></h3>
                        <!-- <p><span class="price mr-2">$20.00</span> <span class="per">per night</span></p> -->
                        <hr>
                        <p class="pt-1"><a href="room-single.html" class="btn-custom">지금 찾아보기 <span class="icon-long-arrow-right"></span></a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm col-md-6 col-lg-4 ftco-animate">
                <div class="room">
                    <a href="hotelList.jsp" class="img d-flex justify-content-center align-items-center" style="background-image: url(static/home/images/room-3.jpg);">
                        <div class="icon d-flex justify-content-center align-items-center">
                            <span class="icon-search2"></span>
                        </div>
                    </a>
                    <div class="text p-3 text-center">
                        <h3 class="mb-3"><a href="hotelList.jsp">제주</a></h3>
                        <!-- <p><span class="price mr-2">$150.00</span> <span class="per">per night</span></p> -->
                        <hr>
                        <p class="pt-1"><a href="room-single.html" class="btn-custom">지금 찾아보기 <span class="icon-long-arrow-right"></span></a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm col-md-6 col-lg-4 ftco-animate">
                <div class="room">
                    <a href="hotelList.jsp" class="img d-flex justify-content-center align-items-center" style="background-image: url(static/home/images/room-4.jpg);">
                        <div class="icon d-flex justify-content-center align-items-center">
                            <span class="icon-search2"></span>
                        </div>
                    </a>
                    <div class="text p-3 text-center">
                        <h3 class="mb-3"><a href="hotelList.jsp">경기</a></h3>
                        <!-- <p><span class="price mr-2">$130.00</span> <span class="per">per night</span></p> -->
                        <hr>
                        <p class="pt-1"><a href="room-single.html" class="btn-custom">지금 찾아보기 <span class="icon-long-arrow-right"></span></a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm col-md-6 col-lg-4 ftco-animate">
                <div class="room">
                    <a href="hotelList.jsp" class="img d-flex justify-content-center align-items-center" style="background-image: url(static/home/images/room-5.jpg);">
                        <div class="icon d-flex justify-content-center align-items-center">
                            <span class="icon-search2"></span>
                        </div>
                    </a>
                    <div class="text p-3 text-center">
                        <h3 class="mb-3"><a href="hotelList.jsp">인천</a></h3>
                        <!-- <p><span class="price mr-2">$300.00</span> <span class="per">per night</span></p> -->
                        <hr>
                        <p class="pt-1"><a href="room-single.html" class="btn-custom">지금 찾아보기 <span class="icon-long-arrow-right"></span></a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm col-md-6 col-lg-4 ftco-animate">
                <div class="room">
                    <a href="hotelList.jsp" class="img d-flex justify-content-center align-items-center" style="background-image: url(static/home/images/room-6.jpg);">
                        <div class="icon d-flex justify-content-center align-items-center">
                            <span class="icon-search2"></span>
                        </div>
                    </a>
                    <div class="text p-3 text-center">
                        <h3 class="mb-3"><a href="hotelList.jsp">강원</a></h3>
                        <hr>
                        <p class="pt-1"><a href="room-single.html" class="btn-custom">지금 찾아보기 <span class="icon-long-arrow-right"></span></a></p>
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

<script src="<c:url value='/static/home/js/jquery.min.js'/>"></script>
<script src="<c:url value='/static/home/js/jquery-migrate-3.0.1.min.js'/>"></script>
<script src="<c:url value='/static/home/js/popper.min.js'/>"></script>
<script src="<c:url value='/static/home/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/static/home/js/jquery.easing.1.3.js'/>"></script>
<script src="<c:url value='/static/home/js/jquery.waypoints.min.js'/>"></script>
<script src="<c:url value='/static/home/js/jquery.stellar.min.js'/>"></script>
<script src="<c:url value='/static/home/js/owl.carousel.min.js'/>"></script>
<script src="<c:url value='/static/home/js/jquery.magnific-popup.min.js'/>"></script>
<script src="<c:url value='/static/home/js/aos.js'/>"></script>
<script src="<c:url value='/static/home/js/jquery.animateNumber.min.js'/>"></script>
<script src="<c:url value='/static/home/js/bootstrap-datepicker.js'/>"></script>
<script src="<c:url value='/static/home/js/jquery.timepicker.min.js'/>"></script>
<script src="<c:url value='/static/home/js/scrollax.min.js'/>"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="<c:url value='/static/home/js/google-map.js'/>"></script>
<script src="<c:url value='/static/home/js/main.js'/>"></script>
<script>
    var count=0;
    function increase(){
        count=count+1;
        document.querySelector("#countBtn").innerText=count;
    }</script>
</body>
</html>