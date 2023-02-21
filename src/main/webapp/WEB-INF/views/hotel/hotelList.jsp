<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
	<title>Deluxe - Free Bootstrap 4 Template by Colorlib</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i" rel="stylesheet">

	<link rel="stylesheet" href="<c:url value='/resources/static/home/css/open-iconic-bootstrap.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources/static/home/css/open-iconic-bootstrap.min.css'/>">
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
		<a class="navbar-brand title" href="<c:url value='/'/>">위드휴일</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="oi oi-menu"></span> Menu
		</button>



		<div class="collapse navbar-collapse" id="ftco-nav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a href="/host" class="nav-link title">호스트등록</a></li>
				<c:choose>
					<c:when test="${userId eq null}"><li class="nav-item"><a href="/user/loginForm" class="nav-link title">로그인</a></li></c:when>
					<c:when test="${userId ne null}"><li class="nav-item"><a href="<c:url value='/user/info'/>" class="nav-link title">${userId}</a></li></c:when>
				</c:choose>
			</ul>
		</div>

</nav>
<!-- END nav -->

<div class="hero-wrap" style="background-image: url(<c:url value='/resources/static/home/images/bg_1.jpg'/>);">
	<div class="overlay"></div>
	<div class="container">
		<div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
			<div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
				<div class="text">
					<h1 class="mb-4 bread">${where}</h1>
				</div>
			</div>
		</div>
	</div>
</div>


<section class="ftco-section bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-9">
				<div class="row">
					<c:forEach var="hotelList" items="${hotelListDtoList}">
						<div class="col-sm col-md-6 col-lg-4 ftco-animate">
							<div class="room">
								<a href="rooms-single.html" class="img d-flex justify-content-center align-items-center" style="background-image: url(<c:url value='/resources/static/home/images/room-1.jpg'/>);">
									<div class="icon d-flex justify-content-center align-items-center">
										<span class="icon-search2"></span>
									</div>
								</a>
								<div class="text p-3 text-center">
									<h3 class="mb-3"><a href="rooms-single.html">${hotelList.name}</a></h3>
									<p><span class="price mr-2">${hotelList.price}</span> <span class="per">1 박</span></p>
									<ul class="list">
										<li><span>리뷰</span>${hotelList.star}</li>
										<div class="form-check">
											<input type="checkbox" class="form-check-input" id="exampleCheck1">
											<label class="form-check-label" for="exampleCheck1">
												<p class="rate"><span><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i></span></p>
											</label>
										</div>
										<li>${hotelList.sigungu}</li>
									</ul>
									<hr>
									<p class="pt-1"><a href="room-single.html" class="btn-custom">상세보기 <span class="icon-long-arrow-right"></span></a></p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="row mt-5">
					<div class="col text-center">
						<div class="block-27">
							<ul>
								<c:if test="${ph.showPrev}"><li><a href="#">&lt;</a></li></c:if>
								<c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
									<li<c:if test="${ph.viewPage eq i or null}"> class="active"</c:if>>
										<c:if test="${hotelListDtoList ne null}">
											<a href="#">
													${i}
											</a>
										</c:if>
									</li>
								</c:forEach>
								<c:if test="${ph.showNext}"><li><a href="#">&gt;</a></li></c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-3 sidebar">
				<div class="sidebar-wrap bg-light ftco-animate">
					<h3 class="heading mb-4">검색</h3>
					<form action="/hotel/list" method="GET" class="booking-form">
						<div class="fields">
							<div class="form-group">
								<div class="select-wrap one-third">
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
							<div class="form-group">
								<input type="date" id="checkIn" name="checkIn" class="form-control checkin_date" placeholder="체크인">
							</div>
							<div class="form-group">
								<input type="date" id="checkOut" name="checkOut" class="form-control checkout_date" placeholder="체크아웃">
							</div>
							<div class="form-group">
								<div class="select-wrap one-third">
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
							<!-- <div class="form-group">
                                <div class="range-slider">
                                    <span>
                                                  <input type="number" value="25000" min="0" max="120000"/>	-
                                                  <input type="number" value="50000" min="0" max="120000"/>
                                                </span>
                                                <input value="1000" min="0" max="120000" step="500" type="range"/>
                                                <input value="50000" min="0" max="120000" step="500" type="range"/>
                                                </svg>
                                              </div>
                            </div> -->
							<div class="form-group">
								<input type="submit" value="검색" class="btn btn-primary py-3 px-4 align-self-stretch">
							</div>
						</div>
					</form>
				</div>
				<div class="sidebar-wrap bg-light ftco-animate">
					<h3 class="heading mb-4">리뷰 순서</h3>
					<form method="post" class="star-rating">
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="exampleCheck1">
							<label class="form-check-label" for="exampleCheck1">
								<p class="rate"><span><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i></span></p>
							</label>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="exampleCheck1">
							<label class="form-check-label" for="exampleCheck1">
								<p class="rate"><span><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star-o"></i></span></p>
							</label>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="exampleCheck1">
							<label class="form-check-label" for="exampleCheck1">
								<p class="rate"><span><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star-o"></i><i class="icon-star-o"></i></span></p>
							</label>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="exampleCheck1">
							<label class="form-check-label" for="exampleCheck1">
								<p class="rate"><span><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star-o"></i><i class="icon-star-o"></i><i class="icon-star-o"></i></span></p>
							</label>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="exampleCheck1">
							<label class="form-check-label" for="exampleCheck1">
								<p class="rate"><span><i class="icon-star"></i><i class="icon-star-o"></i><i class="icon-star-o"></i><i class="icon-star-o"></i><i class="icon-star-o"></i></span></p>
							</label>
						</div>
					</form>
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

</body>
</html>