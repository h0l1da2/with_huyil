
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script>
function setThumbnail(event){
	var reader = new FileReader();
		
	reader.onload = function(event){
		var img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		img.setAttribute("class", "col-lg-6");
		document.querySelector("div#image_container").appendChild(img);
	};
		
	reader.readAsDataURL(event.target.files[0]);
}
</script>
<head>
<meta charset="EUC-KR">
    <title>with hyuil 호텔등록</title>
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
            <h1 class="heading mb-3">Hotel</h1>
            <ul class="custom-breadcrumbs mb-4">
              <li><a href="/host">Home</a></li>
            </ul>
          </div>
        </div>
      </div>
      </section>

<div class="step-box">
   <div class="step-state step2">
    <ul>
      <li onclick="location.href='/host/hostForm'" style="cursor:pointer;"><p>마이페이지</p></li>
      <li><p>호텔등록</p></li>
      <li onclick="location.href='/host/roomForm'" style="cursor:pointer;"><p>객실등록</p></li>
    </ul>
  </div>
</div>	

<section id="hotelForm">
<form action="/host/hotelForm" method="post" enctype="multipart/form-data">
  <div style="margin:0 0 30px 100px;" class="form-group">
  <br>
    <label for="exampleFormControlInput1">호텔명</label>
    <input type="text" name="name" style="width:300px; height:50px;">
    <br> <br>

    <label for="exampleFormControlInput1">주소 &nbsp;&nbsp;</label> 
    <input type="text" id="postcode" name="zonecode" placeholder="우편번호" style="width:200px; height:50px;"> &nbsp;&nbsp;
    <input type="text" id="sido" name="sido" placeholder="시/도" style="width:100px; height:50px;"> &nbsp;&nbsp;
    <input type="text" id="sigu" name="sigungu" placeholder="시/군/구" style="width:200px; height:50px;">
    <button class="w-btn w-btn-green" type="button" onclick="sample4_execDaumPostcode()">
        우편번호 찾기
    </button> <br> <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" id="addr" name="address" placeholder="도로명주소" size="40" style="width:400px; height:50px;"> &nbsp;&nbsp;
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
	function sample4_execDaumPostcode(){
		new daum.Postcode({
        	oncomplete: function(data) {
            	document.getElementById('postcode').value = data.zonecode;
            	document.getElementById("addr").value = data.roadAddress;
            	document.getElementById("sigu").value = data.sigungu;
            	document.getElementById("sido").value = data.sido;
            	document.getElementById("content").focus();       
        }
    }).open();
}
</script>
	<input type="text" id="content" name="detail" placeholder="상세주소" style="width:200px; height:50px;"><br><br>
	
    <div class="form-group">
    <label for="exampleFormControlInput1">호탤소개 이미지(1장)</label> 
	<input class="form-control form-control-user" type="file" 
	name="uploadFile" id="product_image" onchange="setThumbnail(event);" style="width:300px; height:50px;">

	<div style=width:6 id="image_container"></div> <br>

    <label for="exampleFormControlInput1">서비스</label>
    <table style='margin-top:0px; border:1px solid #000; height:60px;' cellspacing=0 cellpadding=10>
    <tr>
    <td style="padding:0 20px 0 20px"> <input type="checkbox" name="service" value=Breakfast>Breakfast</td>
    <td style="padding:0 20px 0 20px"> <input type="checkbox" name="service" value=Pool>Pool</td>
    <td style="padding:0 20px 0 20px"> <input type="checkbox" name="service" value=Parking>Parking</td>
    <td style="padding:0 20px 0 20px"> <input type="checkbox" name="service" value=WiFi>WiFi</td>
    <td style="padding:0 20px 0 20px"> <input type="checkbox" name="service" value=Fitness>Fitness</td>
    </tr>
    </table> <br>
    
    <label for="exampleFormControlInput1">호텔소개글</label> <br>
    <textArea style=resize:none; name="intro" rows="7" cols="100"></textArea> <br> <br>
    
    <label for="exampleFormControlInput1">교통안내</label> <br>
    <textArea style=resize:none; name="traffic" rows="5" cols="70"></textArea> <br> <br>
    
    <label for="exampleFormControlInput1">주변명소</label> <br>
    <textArea style=resize:none; name="spot" rows="5" cols="70"></textArea> <br> <br>
    
    <label for="exampleFormControlInput1">호텔정책</label> <br>
    <textArea style=resize:none; name="policy" rows="7" cols="100"></textArea> <br> <br>
    
    <label for="exampleFormControlInput1">이용시간</label> <br>
    <select name="checkIn">
    <option value="" selected>체크인 가능시간</option>
    <option value="오후 01:00">오후 01:00</option>
    <option value="오후 02:00">오후 02:00</option>
    <option value="오후 03:00">오후 03:00</option>
    <option value="오후 04:00">오후 04:00</option>
    <option value="오후 05:00">오후 05:00</option>
    <option value="오후 06:00">오후 06:00</option>
    <option value="오후 07:00">오후 07:00</option>
    <option value="오후 08:00">오후 08:00</option>
    </select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
    <select name="checkOut">
    <option value="" selected>체크아웃 가능시간</option>
    <option value="오전 10:00">오전 10:00</option>
    <option value="오전 11:00">오전 11:00</option>
    <option value="오전 12:00">오전 12:00</option>
    <option value="오후 01:00">오후 01:00</option>
    <option value="오후 02:00">오후 02:00</option>
    <option value="오후 03:00">오후 03:00</option>
    <option value="오후 04:00">오후 04:00</option>
    <option value="오후 05:00">오후 05:00</option>
    </select> <br><br>
    
    <br> <br>
    <button class="w-btn-neon2" type="submit">
        다음단계
    </button>
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