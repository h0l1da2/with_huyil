<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<<<<<<< HEAD
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
>>>>>>> 56faafe70a379487f8eb151a98050c4d748bb164
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
>>>>>>> refs/remotes/origin/NamSu
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>with hyuil room detail</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,600,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/resources/static/hotelDetail/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="/resources/static/hotelDetail/css/animate.css">

    <link rel="stylesheet" href="/resources/static/hotelDetail/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/resources/static/hotelDetail/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="/resources/static/hotelDetail/css/magnific-popup.css">

    <link rel="stylesheet" href="/resources/static/hotelDetail/css/aos.css">

    <link rel="stylesheet" href="/resources/static/hotelDetail/css/ionicons.min.css">

    <link rel="stylesheet" href="/resources/static/hotelDetail/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="/resources/static/hotelDetail/css/jquery.timepicker.css">
<<<<<<< HEAD
<<<<<<< HEAD


=======
>>>>>>> 56faafe70a379487f8eb151a98050c4d748bb164
=======
>>>>>>> refs/remotes/origin/NamSu
    <link rel="stylesheet" href="/resources/static/hotelDetail/css/flaticon.css">
    <link rel="stylesheet" href="/resources/static/hotelDetail/css/icomoon.css">
    <link rel="stylesheet" href="/resources/static/hotelDetail/css/style.css">

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
                <li class="nav-item"><a href="/user/loginForm" class="nav-link">로그인</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->
<div class="hero-wrap" style="background-image: url('/resources/static/hotelDetail/images/bg_3.jpg');">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
                <div class="text">
                    <p class="breadcrumbs mb-2"><span class="mr-2"><a href="/">Home</a></span>
                    <h1 class="mb-4 bread">Room Details</h1>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section">
    <div class="container">
        <div class="col-lg-8">
            <div class="col-md-12 ftco-animate">
                <div class="single-slider owl-carousel">
                    <div class="item">
                        <img class="room-img" src="/host/img?filename=${filevo.uuid }"></img>
                    </div>
                </div>
            </div>
            <div class="col-md-12">
                <h2 class="mb-4">${hotelvo.name}</h2>
                <div class="star-rating">
                    <div class="rating" data-rate="${hotelvo.star}">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i><a href="/host/hostForm">리뷰 더 보기</a></i>
                    </div>
                </div>
                <p>${infovo.intro}</p> <br>
                <table>
                    <tr> <td style="padding: 0 20px 0 20px;"><a href="#selectroom">객실선택</a></td> <td style="padding: 0 20px 0 20px;"><a href="#traffic">위치/교통</a></td>
                        <td style="padding: 0 20px 0 20px;"><a href="#service">시설/서비스</a></td> <td style="padding: 0 20px 0 20px;"><a href="#policy">숙소정책</a></td></tr>
                </table> <br>
            </div>
            <!-- Rooms Section Begin -->
            <section class="rooms-section spad" id="selectroom">
                <div class="container">
                    <div class="row">
                        <c:forEach items="${roomList}" var="list">
                            <div class="col-md-6">
                                <div class="room-item" style="width: 400px;">
                                    <img src="/host/img?filename=${list.UUID }" width="370" height="240">
                                    <div class="ri-text">
                                        <h3>${list.NAME }</h3>
                                        <h4>${list.NORMAL_PRICE } /1박</h4>
                                        <table>
                                            <tbody>
                                            <tr>
                                                <td class="r-o" width="70">상세정보:</td>
                                                <td>${list.CONTENT }</td>
                                            </tr>
                                            <tr>
                                                <td class="r-o" width="70">최대인원:</td>
                                                <td>${list.MAX }인</td>
                                            </tr>
                                            <tr>
                                                <td class="r-o" width="70">침대크기:</td>
                                                <td>${list.BED }</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                        <a href="/reserve?id=${list.ID }" class="primary-btn" style="margin-left:5px;">예약하기</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>
            <div class="col-md-12 room-single ftco-animate mb-5 mt-4" id="service"> <br><br>
                <h1 class="mb-4 bread">호텔상세내역</h1> <br>
                <h4 class="heading mb-3" id="traffic">호텔서비스</h4>
                <table> <c:forEach items="${service }" var="service">
                    <c:choose> <c:when test="${service == 'Breakfast' }">
                        <tr> <td width="30"><i class="fa-solid fa-utensils"></i></td> <td>${service }</td> </tr>
                    </c:when>
                        <c:when test="${service == 'Pool' }">
                            <tr> <td width="30"><i class="fa-solid fa-person-swimming"></i></td> <td>${service }</td></tr>
                        </c:when>
                        <c:when test="${service == 'Parking' }">
                            <tr> <td width="30"><i class="fa-solid fa-square-parking"></i></td> <td>${service }</td> </tr>
                        </c:when>
                        <c:when test="${service == 'Wifi' }">
                            <tr> <td width="30"><i class="fa-solid fa-wifi"></i></td> <td>${service }</td> </tr>
                        </c:when>
                        <c:when test="${service == 'Fitness' }">
                            <tr> <td width="30"><i class="fa-regular fa-dumbbell"></i></td> <td>${service }</td> </tr>
                        </c:when>
                    </c:choose>
                </c:forEach>
                </table> <br> <br>
                <h4 class="heading mb-3">위치및 지도</h4>
                <div id="map" style="width:100%;height:300px;"></div>
                <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e8df5130f0b97930c8e8a1f3c35073d1&libraries=services"></script>
                <script>
                    var mapContainer = document.getElementById('map'),
                        mapOption = {
                            center: new kakao.maps.LatLng(33.450701, 126.570667),
                            level: 3
                        };
                    var map = new kakao.maps.Map(mapContainer, mapOption);
                    var geocoder = new kakao.maps.services.Geocoder();
                    geocoder.addressSearch('${hotelvo.address}', function(result, status) {
                        if (status === kakao.maps.services.Status.OK) {
                            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                            var marker = new kakao.maps.Marker({
                                map: map,
                                position: coords
                            });
                            var infowindow = new kakao.maps.InfoWindow({
                                content: '<div style="width:150px;text-align:center;padding:6px 0;">${hotelvo.name}</div>'
                            });
                            infowindow.open(map, marker);
                            map.setCenter(coords);
                        }
                    });
                </script>
                <h5 id="policy">교통안내</h5> <p>${infovo.traffic }</p> <br>
                <h5>주변명소</h5> <p>${infovo.spot }</p> <br>
                <h4 class="heading mb-3">호텔정책</h4>
                <h5>이용시간</h5> <br> <span>체크인가능시간 : ${infovo.checkIn }부터</span><br>
                <span>체크아웃시간 : ${infovo.checkOut }까지</span> <br><br>
                <p>${infovo.policy }</p> <br>
            </div>
        </div>
    </div>
</section>
<!-- Rooms Section End -->
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


<script src="/resources/static/hotelDetail/js/jquery.min.js"></script>
<script src="/resources/static/hotelDetail/js/jquery-migrate-3.0.1.min.js"></script>
<script src="/resources/static/hotelDetail/js/popper.min.js"></script>
<script src="/resources/static/hotelDetail/js/bootstrap.min.js"></script>
<script src="/resources/static/hotelDetail/js/jquery.easing.1.3.js"></script>
<script src="/resources/static/hotelDetail/js/jquery.waypoints.min.js"></script>
<script src="/resources/static/hotelDetail/js/jquery.stellar.min.js"></script>
<script src="/resources/static/hotelDetail/js/owl.carousel.min.js"></script>
<script src="/resources/static/hotelDetail/js/jquery.magnific-popup.min.js"></script>
<script src="/resources/static/hotelDetail/js/aos.js"></script>
<script src="/resources/static/hotelDetail/js/jquery.animateNumber.min.js"></script>
<script src="/resources/static/hotelDetail/js/bootstrap-datepicker.js"></script>
<script src="/resources/static/hotelDetail/js/scrollax.min.js"></script>
<script src="/resources/static/hotelDetail/js/main.js"></script>
<script src="/resources/static/home/js/rating.js"></script>

<!-- nav바 고정 -->
<script src="/resources/static/home/js/scrollax.min.js"></script>
<script src="/resources/static/home/js/main.js"></script>
<!-- 별점 icon -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"></script>
<script src="https://kit.fontawesome.com/d89e70aecc.js"></script>
</body>
</html>