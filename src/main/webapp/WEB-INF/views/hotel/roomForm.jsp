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
		document.querySelector("div#image_thumnail").appendChild(img);
	};
	reader.readAsDataURL(event.target.files[0]);
}
</script>
<head>
<meta charset="EUC-KR">
<title>with hyuil 객실등록</title>
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
            <h1 class="heading mb-3">Rooms</h1>
            <ul class="custom-breadcrumbs mb-4">
              <li><a href="/host">Home</a></li>
            </ul>
          </div>
        </div>
      </div>
      </section>

<div class="step-box">
   <div class="step-state step3">
    <ul>
      <li onclick="location.href='/host/hostForm'" style="cursor:pointer;"><p>마이페이지</p></li>
      <li onclick="location.href='/host/hotelForm'" style="cursor:pointer;"><p>호텔등록</p></li>
      <li><p>객실등록</p></li>
    </ul>
  </div>
</div>	

<section id="hotelForm">
<form action="/host/roomForm" method="post" enctype="multipart/form-data">
  <div style="margin:0 0 30px 100px;" class="form-group">
  <br>
    <label for="exampleFormControlInput1">객실명</label> &nbsp;&nbsp;
    <input type="text" name="name" style="width:300px; height:50px;" placeholder="예)디럭스 더블 트윈">
    <br> <br>
    
    <label for="exampleFormControlInput1">객실소개 이미지(1장)</label>
	<input class="form-control form-control-user" type="file" 
	name="uploadFile" id="product_image" onchange="setThumbnail(event);" style="width:300px; height:50px;"> <br>
	<div class="product_title">
		<div class="product-img-div">
			<div class="image_thumnail" id="image_thumnail"></div>
		</div>
	</div>
	<label for="exampleFormControlInput1">객실소개글</label> <br>
    <textArea style=resize:none; name="content" rows="7" cols="100"></textArea> <br> <br>
    
    <table>
    <tr>
    <td width="200"> <label for="exampleFormControlInput1">최대인원</label> </td>
    <td> <label for="exampleFormControlInput1">침대 사이즈</label> </td>
    </tr>
    <tr><td>
    <select name="max">
    <option value="" selected>--인원선택--</option>
    <option value="1">1인</option>
    <option value="2">2인</option>
    <option value="3">3인</option>
    <option value="4">4인</option>
    <option value="5">5인</option>
    <option value="6">6인 이상</option>
    </select></td><td>
    <select name="bed">
    <option value="" selected>--침대사이즈--</option>
    <option value="Single">Single</option>
    <option value="Super single">Super single</option>
    <option value="Queen">Queen</option>
    <option value="King">King</option>
    <option value="Double">Double</option>
    <option value="Large king">Large king</option>
    <option value="California king">California king</option>
    </select></td></tr>
    </table> <br><br><br>
    
    <h4>객실요금</h4> <br>
    <label for="exampleFormControlInput1">일반요금</label>
    <input type="text" name="nPrice" style="width:200px; height:50px; padding-right: 10px; text-align: right" placeholder="예)50000">원
    &nbsp;&nbsp;&nbsp;&nbsp;/ &nbsp;&nbsp;&nbsp;&nbsp; 
    
    <label for="exampleFormControlInput1">주말요금</label>
    <input type="text" name="hPrice" style="width:200px; height:50px; padding-right: 10px; text-align: right" placeholder="예)80000">원
    <br> <br> <br>
    
    <button class="w-btn-neon2" type="submit">
        등록
    </button>
    </div>
</form>
</section> <br>
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