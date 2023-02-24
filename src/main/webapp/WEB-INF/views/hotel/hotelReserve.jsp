<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숙박 예약페이지</title>
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
	<link rel="stylesheet" type="text/css" href="/resources/static/hotelForm/css/state.css">	
    
    <link rel="stylesheet" href="/resources/static/hotelDetail/css/flaticon.css">
    <link rel="stylesheet" href="/resources/static/hotelDetail/css/icomoon.css">
    <link rel="stylesheet" href="/resources/static/hotelDetail/css/style.css">
    
	<!-- 네비바, 풋 css따오기 -->    
    <link rel="stylesheet" href="/resources/static/home/css/style.css">
    
</head>
<script>
	function addPrice() {
		var checkIndate = new Date(document.getElementById("checkIn").value);
		var checkOutdate = new Date(document.getElementById("checkOut").value);	
		var diff = checkOutdate.getTime() - checkIndate.getTime();
		var day = Math.abs(diff / (1000 * 60 * 60 * 24));
		if(diff > 0) {
			var totalPrice = ${roomvo.normalPrice } * day;
			if(document.getElementById("seePrice")){
				document.getElementById("seePrice").remove();
				$("#price").append("<div id='seePrice'><h3>총금액 : "+totalPrice+"원</h3></div>");
			}else {
				$("#price").append("<div id='seePrice'><h3>총금액 : "+totalPrice+"원</h3></div>");
			}
		}
		if(diff <= 0) {
			document.getElementById("seePrice").remove();	
		}
	}
	
	function addPrice2() {
		var checkIndate = new Date(document.getElementById("checkIn").value);
		var checkOutdate = new Date(document.getElementById("checkOut").value);	
		var diff = checkOutdate.getTime() - checkIndate.getTime();
		var day = Math.abs(diff / (1000 * 60 * 60 * 24));
		if(diff > 0) {
			var totalPrice = ${roomvo.normalPrice } * day;
			if(document.getElementById("seePrice")){
				document.getElementById("seePrice").remove();
				$("#price").append("<div id='seePrice'><h3>총금액 : "+totalPrice+"원</h3></div>");
			}else {
				$("#price").append("<div id='seePrice'><h3>총금액 : "+totalPrice+"원</h3></div>");
			}
		}
		if(diff <= 0) {
			document.getElementById("seePrice").remove();	
		}
	}

	function checkForm() {
		var checkIn = document.getElementById("checkIn");
		var checkOut = document.getElementById("checkOut");
		if(checkIn.value == "" || checkIn.value == null){
			alert("체크인 날짜를 입력해주세요.");
			checkIn.focus();
			return false;
		}
		if(checkOut.value == "" || checkOut.value == null){
			alert("체크아웃 날짜를 입력해주세요.");
			checkOut.focus();
			return false;
		}
		var checkIndate = new Date(checkIn.value);
		var checkOutdate = new Date(checkOut.value);	
		var diff = checkOutdate.getTime() - checkIndate.getTime();
		if(diff <= 0){
			alert("체크인/체크아웃 날짜를 확인해주세요.");
			checkIn.focus();
			return false;
		}
	}
</script>
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
	<div class="hero-wrap" style="background-image: url('/resources/static/hotelDetail/images/bg_3.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          	<div class="text">
	            <p class="breadcrumbs mb-2"><span class="mr-2"><a href="/">Home</a></span>
	            <h1 class="mb-4 bread">Reserve</h1>
            </div>
          </div>
        </div>
      </div>
    </div>
<section id="hotelForm">
<form method="post" action="/kakaoPay" onsubmit="return checkForm();">
  <div style="margin:50px 0 30px 300px;" class="form-group">
  <br>
  <label for="exampleFormControlInput1">---------------------회원정보---------------------</label> <br><br>
  	<label for="exampleFormControlInput1" style="width:50px;">아이디</label>
    <input type="text" name="userId" value="${usersvo.userId }" style="width:300px; height:50px;" readonly><br> <br>
    <label for="exampleFormControlInput1" style="width:50px;">이 름</label> 
    <input type="text" name="userName" value="${usersvo.name }" style="width:300px; height:50px;" readonly><br> <br>
    <label for="exampleFormControlInput1" style="width:50px;">연락처</label> 
    <input type="text" name="userTel" value="${usersvo.tel }" style="width:300px; height:50px;" readonly><br> <br> <br>
    <label for="exampleFormControlInput1">---------------------예약상품---------------------</label> 
	 <section class="rooms-section spad" id="selectroom">
        <div class="container" style="padding-left: 0px;">
            <div class="row">
                <div class="col-md-6" style="padding-left: 0px;">
                    <div class="room-item" style="width: 600px;" style="padding-left: 0px;"> <br>                
                    	<label for="#">Check-in</label>
                    	<input type="date" id="checkIn" name="checkin" style="width:120px;" oninput="addPrice2()">               
                     	<label for="#">Check-out</label>
                     	<input type="date" id="checkOut" name="checkout" style="width:120px;" oninput="addPrice()"> <br>                     
                     	<img src="/img?filename=${filevo.uuid }" width="370" height="240">
                     	<div class="ri-text">
                      	<h3>${hotelvo.name }</h3>
                        <h3>${roomvo.name }</h3>
                        <h4>${roomvo.normalPrice } /1박</h4>
                        <table>
                            <tbody>
                                <tr>
                                    <td class="r-o" width="70">상세정보:</td>
                                    <td>${roomvo.content }</td>
                                </tr>
                                <tr>
                                    <td class="r-o" width="70">최대인원:</td>
                                    <td>${roomvo.max }인</td>
                                </tr>
                                <tr>
                                    <td class="r-o" width="70">침대크기:</td>
                                    <td>${roomvo.bed }</td>
                                </tr>
                            </tbody>
                        </table> <br>
                        <label for="exampleFormControlInput1">---------------------요청사항---------------------</label>
                        <textArea style=resize:none; name="please" rows="7" cols="55"></textArea> <br>
                        <label for="exampleFormControlInput1">---------------------결제금액---------------------</label>
                        <div id="price"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</section> <br> <br>
	<button class="w-btn-neon2" type="submit">결제하기</button>
    <br> <br>
  </div>
  <input type="hidden" name="price" value="${roomvo.normalPrice }">
  <input type="hidden" name="name" value="${hotelvo.name } / ${roomvo.name }">
  <input type="hidden" name="roomId" value="${roomvo.id }">
</form>
</section>
    <!-- footer -->
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
</body>
</html>