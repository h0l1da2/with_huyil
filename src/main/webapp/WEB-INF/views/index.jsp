<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
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
                <li class="nav-item"><a href="/host" class="nav-link title">호스트등록</a></li>
                <c:choose>
                    <c:when test="${userId eq null}"><li class="nav-item"><a href="/user/loginForm" class="nav-link title">로그인</a></li></c:when>
                    <c:when test="${role eq '[ROLE_USER]'}"><li class="nav-item"><a href="<c:url value='/user/info'/>" class="nav-link title">${userId}</a></li></c:when>
                    <c:when test="${role eq '[ROLE_HOST]'}"><li class="nav-item"><a href="<c:url value='/hosts/info'/>" class="nav-link title">${userId}</a></li></c:when>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->

<section class="home-slider owl-carousel">
    <div class="slider-item" style="background-image:url(/resources/static/home/images/bg_1.jpg);">
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
                <form action="/hotel/list" method="GET" class="booking-form">
                    <div class="row">
                        <div class="col-md d-flex">
                            <div class="form-group p-4 align-self-stretch d-flex align-items-end">
                                <div class="wrap">
                                    <label for="#">WHERE</label>
                                    <div class="form-field">
                                        <div class="select-wrap">
                                            <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                            <select name="sido" id="sido" class="form-control">
                                                <option value="서울">서울</option>
                                                <option value="부산">부산</option>
                                                <option value="제주">제주</option>
                                                <option value="경기">경기</option>
                                                <option value="인천">인천</option>
                                                <option value="강원">강원</option>
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
                                    <input type="date" id="checkIn" name="checkIn" class="form-control checkin_date" placeholder="체크인">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 d-flex">
                            <div class="form-group p-4 align-self-stretch d-flex align-items-end">
                                <div class="wrap">
                                    <label for="#">Check-out</label>
                                    <input type="date" id="checkOut" name="checkOut" class="form-control checkout_date" placeholder="체크아웃">
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
                                            <select name="max" id="max" class="form-control">
                                                <option value="1">1 인</option>
                                                <option value="2">2 인</option>
                                                <option value="3">3 인</option>
                                                <option value="4">4 인</option>
                                                <option value="5">5 인</option>
                                                <option value="6">6 인이상</option>
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
                    <a href="<c:url value="/hotel/list/서울"/>" class="img d-flex justify-content-center align-items-center" style="background-image: url(/resources/static/home/images/seoul.jpg);">
                        <div class="icon d-flex justify-content-center align-items-center">
                            <span class="icon-search2"></span>
                        </div>
                    </a>
                    <div class="text p-3 text-center">
                        <h3 class="mb-3"><a href="<c:url value="/hotel/list/서울"/>">서울</a></h3>
                        <hr>
                        <p class="pt-1"><a href="<c:url value="/hotel/list/서울"/>" class="btn-custom">지금 찾아보기 <span class="icon-long-arrow-right"></span></a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm col-md-6 col-lg-4 ftco-animate">
                <div class="room">
                    <a href="<c:url value="/hotel/list/부산"/>" class="img d-flex justify-content-center align-items-center" style="background-image: url(/resources/static/home/images/busan.jpg);">
                        <div class="icon d-flex justify-content-center align-items-center">
                            <span class="icon-search2"></span>
                        </div>
                    </a>
                    <div class="text p-3 text-center">
                        <h3 class="mb-3"><a href="<c:url value="/hotel/list/부산"/>">부산</a></h3>
                        <hr>
                        <p class="pt-1"><a href="<c:url value="/hotel/list/부산"/>" class="btn-custom">지금 찾아보기 <span class="icon-long-arrow-right"></span></a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm col-md-6 col-lg-4 ftco-animate">
                <div class="room">
                    <a href="<c:url value="/hotel/list/제주"/>" class="img d-flex justify-content-center align-items-center" style="background-image: url(resources/static/home/images/jeju.jpg);">
                        <div class="icon d-flex justify-content-center align-items-center">
                            <span class="icon-search2"></span>
                        </div>
                    </a>
                    <div class="text p-3 text-center">
                        <h3 class="mb-3"><a href="<c:url value="/hotel/list/제주"/>">제주</a></h3>
                        <!-- <p><span class="price mr-2">$150.00</span> <span class="per">per night</span></p> -->
                        <hr>
                        <p class="pt-1"><a href="<c:url value="/hotel/list/제주"/>" class="btn-custom">지금 찾아보기 <span class="icon-long-arrow-right"></span></a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm col-md-6 col-lg-4 ftco-animate">
                <div class="room">
                    <a href="<c:url value="/hotel/list/경기"/>" class="img d-flex justify-content-center align-items-center" style="background-image: url(resources/static/home/images/gyeongi.jpg);">
                        <div class="icon d-flex justify-content-center align-items-center">
                            <span class="icon-search2"></span>
                        </div>
                    </a>
                    <div class="text p-3 text-center">
                        <h3 class="mb-3"><a href="<c:url value="/hotel/list/경기"/>">경기</a></h3>
                        <!-- <p><span class="price mr-2">$130.00</span> <span class="per">per night</span></p> -->
                        <hr>
                        <p class="pt-1"><a href="<c:url value="/hotel/list/경기"/>" class="btn-custom">지금 찾아보기 <span class="icon-long-arrow-right"></span></a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm col-md-6 col-lg-4 ftco-animate">
                <div class="room">
                    <a href="<c:url value="/hotel/list/인천"/>" class="img d-flex justify-content-center align-items-center" style="background-image: url(resources/static/home/images/incheon.jpg);">
                        <div class="icon d-flex justify-content-center align-items-center">
                            <span class="icon-search2"></span>
                        </div>
                    </a>
                    <div class="text p-3 text-center">
                        <h3 class="mb-3"><a href="<c:url value="/hotel/list/인천"/>">인천</a></h3>
                        <!-- <p><span class="price mr-2">$300.00</span> <span class="per">per night</span></p> -->
                        <hr>
                        <p class="pt-1"><a href="<c:url value="/hotel/list/인천"/>" class="btn-custom">지금 찾아보기 <span class="icon-long-arrow-right"></span></a></p>
                    </div>
                </div>
            </div>
            <div class="col-sm col-md-6 col-lg-4 ftco-animate">
                <div class="room">
                    <a href="<c:url value="/hotel/list/강원"/>" class="img d-flex justify-content-center align-items-center" style="background-image: url(resources/static/home/images/gangwon.jpg);">
                        <div class="icon d-flex justify-content-center align-items-center">
                            <span class="icon-search2"></span>
                        </div>
                    </a>
                    <div class="text p-3 text-center">
                        <h3 class="mb-3"><a href="<c:url value="/hotel/list/강원"/>">강원</a></h3>
                        <hr>
                        <p class="pt-1"><a href="<c:url value="/hotel/list/강원"/>" class="btn-custom">지금 찾아보기 <span class="icon-long-arrow-right"></span></a></p>
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