<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
    <title>with hyuil room detail</title>
    <meta charset="utf-8">
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
                <li class="nav-item"><a href="/user/login" class="nav-link">로그인</a></li>
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
	            <p class="breadcrumbs mb-2"><span class="mr-2"><a href="index.html">Home</a></span> <span class="mr-2"><a href="rooms.html">Hotel</a></span> <span>Detail</span></p>
	            <h1 class="mb-4 bread">Room Details</h1>
            </div>
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section">
      <div class="container">
        <div class="row">
          <div class="col-lg-8">
          	<div class="row">
          		<div class="col-md-12 ftco-animate">
          			<div class="single-slider owl-carousel">
          				<div class="item">
          					<div class="room-img" style="background-image: url(/resources/static/hotelDetail/images/room-4.jpg);"></div>
          				</div>
          			</div>
          		</div>
          		<div class="col-md-12 room-single mt-4 mb-5 ftco-animate">
          			<h2 class="mb-4">${hotelvo.Name }<span>${count }개</span></h2>
          					<p>${hotelvo.Star }</p>
    						<p>${infovo.Intro}</p>
						</div>
						<table>
						<tr> <td style="padding: 0 20px 0 20px;">객실선택</td> <td style="padding: 0 20px 0 20px;">위치/교통</td> 
							 <td style="padding: 0 20px 0 20px;">시설/서비스</td> <td style="padding: 0 20px 0 20px;">숙소정책</td> <td style="padding: 0 20px 0 20px;">리뷰</td> </tr>
						</table> <br><br>
						
	<!-- Rooms Section Begin -->
    <section class="rooms-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6" style="margin-right:200px;">
                    <div class="room-item" style="width: 400px;">
                        <img src="/resources/static/hotelDetail/img/room/room-1.jpg" alt="">
                        <div class="ri-text">
                            <h4>방 이름</h4>
                            <h3>가격<span>/1박</span></h3>
                            <table>
                                <tbody>
                                    <tr>
                                        <td class="r-o">intro</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">Maximum</td>
                                        <td> 인원수</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">bed</td>
                                        <td>size </td>
                                    </tr>
                                </tbody>
                            </table>
                            <a href="#" class="primary-btn">More Details</a> 
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="room-item" style="width: 400px;">
                        <img src="/resources/static/hotelDetail/img/room/room-2.jpg" alt="">
                        <div class="ri-text">
                            <h4>Deluxe Room</h4>
                            <h3>159$<span>/Pernight</span></h3>
                            <table>
                                <tbody>
                                    <tr>
                                        <td class="r-o">Size:</td>
                                        <td>30 ft</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">Capacity:</td>
                                        <td>Max persion 5</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">Bed:</td>
                                        <td>King Beds</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">Services:</td>
                                        <td>Wifi, Television, Bathroom,...</td>
                                    </tr>
                                </tbody>
                            </table>
                            <a href="#" class="primary-btn">More Details</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6" style="margin-right:200px; top:30px">
                    <div class="room-item" style="width: 400px;">
                        <img src="/resources/static/hotelDetail/img/room/room-3.jpg" alt="">
                        <div class="ri-text">
                            <h4>Double Room</h4>
                            <h3>159$<span>/Pernight</span></h3>
                            <table>
                                <tbody>
                                    <tr>
                                        <td class="r-o">Size:</td>
                                        <td>30 ft</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">Capacity:</td>
                                        <td>Max persion 2</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">Bed:</td>
                                        <td>King Beds</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">Services:</td>
                                        <td>Wifi, Television, Bathroom,...</td>
                                    </tr>
                                </tbody>
                            </table>
                            <a href="#" class="primary-btn">More Details</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6" style="top:30px;">
                    <div class="room-item" style="width: 400px;">
                        <img src="/resources/static/hotelDetail/img/room/room-3.jpg" alt="">
                        <div class="ri-text">
                            <h4>Double Room</h4>
                            <h3>159$<span>/Pernight</span></h3>
                            <table>
                                <tbody>
                                    <tr>
                                        <td class="r-o">Size:</td>
                                        <td>인트로</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">Capacity:</td>
                                        <td>Max persion 2</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">Bed:</td>
                                        <td>King Beds</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">Services:</td>
                                        <td>Wifi, Television, Bathroom,...</td>
                                    </tr>
                                </tbody>
                            </table>
                            <a href="#" class="primary-btn">More Details</a>
                        </div>
                    </div>
                <div class="col-lg-12">
                	<div class="room-pagination">
                    	<a href="#">1</a>
      	                <a href="#">2</a>
        	            <a href="#">Next <i class="fa fa-long-arrow-right"></i></a>
              	    </div>
           	    </div>
            </div>
            <div class="col-md-12 room-single ftco-animate mb-5 mt-4"> <br><br>
          		<h1 class="mb-4 bread">호텔상세내역</h1> <br>
          		<h4 class="heading mb-3">호텔서비스</h4>          		
          		<table>
          			<tr> <td width="130">(아이콘)WiFi</td> <td width="130">(아이콘)주차가능</td> </tr>
          			<tr> <td width="130">(아이콘)WiFi</td> <td width="130">(아이콘)주차가능</td> </tr>
          			<tr> <td width="130">(아이콘)WiFi</td> <td width="130">(아이콘)주차가능</td> </tr>
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
				geocoder.addressSearch('경기도 수원시 영화로25번길 22', function(result, status) {
			     	if (status === kakao.maps.services.Status.OK) {
				        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			        	var marker = new kakao.maps.Marker({
				            map: map,
			            	position: coords
			        	});
			        	var infowindow = new kakao.maps.InfoWindow({
				            content: '<div style="width:150px;text-align:center;padding:6px 0;">태영아파트</div>'
			        	});
			        	infowindow.open(map, marker);
			        	map.setCenter(coords);
			    	} 
				});    
				</script>
				<p>교통안내</p> <p>너네집에서 5분거리</p> <br>
				<p>주변명소</p> <p>편의점</p> <br>
				<h4 class="heading mb-3">호텔정책</h4> 
				<span>이용시간</span> <br> <span>체크인가능시간 : 00:00부터</span> <span>체크아웃시간 : 00:00까지</span> <br><br>
				<p>호텔정책 솰라솰라</p> <br>
				<h4 class="heading mb-3">리뷰</h4>
          	</div>
        </div>
      </div>  
    </section>
    <!-- Rooms Section End -->
	
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
  
  <!-- nav바 고정 -->
  <script src="/resources/static/home/js/scrollax.min.js"></script>
  <script src="/resources/static/home/js/main.js"></script>
  </body>
</html>