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
<script>
	function checkForm() {
		var f = document.hostForm;
		if(f.tel.value == "" || f.tel.value == null){
			alert("전화번호를 확인해주세요.");
			f.tel.focus();
			return false;
		}
		if(f.bank.value == "" || f.bank.value == null){
			alert("은행을 확인해주세요");
			f.tel.focus();
			return false;
		}
		if(f.bankNumber.value == "" || f.bankNumber.value == null){
			alert("계좌번호를 확인해주세요.");
			f.bankNumber.focus();
			return false;
		}
		if(f.account.value == "" || f.account.value == null){
			alert("사업자번호를 확인해주세요.");
			f.account.focus();
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
                <li class="nav-item"><a href="/host" class="nav-link title">호스트등록</a></li>
                <li class="nav-item"><a href="/user/loginForm" class="nav-link title">${userId }</a></li>
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
                    <li><a href="/">Home</a></li>
                </ul>
            </div>
        </div>
    </div>
</section>

<div class="step-box">
    <div class="step-state step">
        <ul>
            <li><p>마이페이지</p></li>
            <li onclick="location.href='/hosts/hotelForm'" style="cursor:pointer;"><p>호텔등록</p></li>
            <li onclick="location.href='/hosts/roomForm'" style="cursor:pointer;"><p>객실등록</p></li>
        </ul>
    </div>
</div>

<section id="hotelForm">
    <form name="hostForm" action="/hosts/hostForm" method="post" onsubmit="return checkForm();">
        <div style="margin:0 0 30px 100px;" class="form-group">
            <br>
            <label for="exampleFormControlInput1">이 름</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="text" name="name" value="${users.getName() }" readonly style="width:250px; height:50px;">
            <br> <br>

            <label for="exampleFormControlInput1">전화번호</label>  &nbsp;&nbsp;&nbsp;
            <input type="text" id="tel" name="tel" value="${users.getTel() }" placeholder="숫자만입력해주세요" style="width:300px; height:50px;">
            <div class="form-group">
                <br>

                <label for="exampleFormControlInput1">거래은행</label>  &nbsp;&nbsp;&nbsp;
                <input type="text" id="bank" name="bank" value="${business.bank }" placeholder="예)국민은행" style="width:300px; height:50px;">
                <div class="form-group"> <br> <br>

                    <label for="exampleFormControlInput1">계좌번호</label> &nbsp;&nbsp;&nbsp;
                    <input type="text" id="bankNumber" name="bankNumber" placeholder="숫자만 입력해주세요" value="${business.account }" style="width:300px; height:50px">
                    <br> <br>

                    <label for="exampleFormControlInput1">사업자번호</label>
                    <input type="text" id="account" name="account" placeholder="숫자만 입력해주세요" value="${business.bankNumber }" style="width:300px; height:50px">
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
        </div>
    </form>
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