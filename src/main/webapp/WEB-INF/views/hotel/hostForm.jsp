<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	<link rel="stylesheet" type="text/css" href="/static/hotelForm/css/state.css">	

    <!-- Theme Style -->
    <link rel="stylesheet" href="/static/hotelForm/css/style.css">
	
	<!-- �׺��, ǲ css������ -->    
    <link rel="stylesheet" href="/static/home/css/style.css">
</head>
<body>
    
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand title" href="/">��������</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a href="/host" class="nav-link">ȣ��Ʈ���</a></li>
                <li class="nav-item"><a href="/user/login" class="nav-link">�α���</a></li>
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
      <li><p>����������</p></li>
      <li><p>ȣ�ڵ��</p></li>
      <li><p>���ǵ��</p></li>
    </ul>
  </div>
</div>	

<section id="hotelForm">
<form>
  <div style="margin:0 0 30px 100px;" class="form-group">
  <br>
    <label for="exampleFormControlInput1">�� ��</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" id="name" style="width:250px; height:50px;">
    <br> <br>

    <label for="exampleFormControlInput1">��ȭ��ȣ</label>  &nbsp;&nbsp;&nbsp;
    <input type="text" id="tel" placeholder="���ڸ��Է����ּ���" style="width:300px; height:50px;">
    <div class="form-group">
    <br>
    
    <label for="exampleFormControlInput1">�ŷ�����</label> &nbsp;&nbsp;&nbsp;
    <select name="bank" style="width:100px; height:50px;">
    <option value="" selected>---���༱��---</option>
    <option value="1">KEB�ϳ�����</option>
    <option value="2">SC��������</option>
    <option value="3">KB��������</option>
    <option value="4">IBK�������</option>
    <option value="5">NH��������</option>
    <option value="6">SH��������</option>
    </select> <br> <br>
    
    <label for="exampleFormControlInput1">������</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" id="bkname" style="width:250px; height:50px">
    <br> <br>
    
    <label for="exampleFormControlInput1">���¹�ȣ</label> &nbsp;&nbsp;&nbsp;
    <input type="text" id="bkname" placeholder="���ڸ� �Է����ּ���" style="width:300px; height:50px">
    <br> <br>
    
    <label for="exampleFormControlInput1">����ڹ�ȣ</label>
    <input type="text" id="bkname" placeholder="���ڸ� �Է����ּ���" style="width:300px; height:50px">
    <br> <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
    <button class="w-btn-neon2" type="submit">
        �����ܰ�
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
                    <h2 class="ftco-heading-2">��ĥ �� ����</h2>
                    <p>��¥ ��¼�� ȣ����¥ ��¼�� ȣ����¥ ��¼�� ȣ����¥ ��¼�� ȣ����¥ ��¼�� ȣ����¥ ��¼�� ȣ����¥ ��¼�� ȣ����¥ ��¼�� ȣ����¥ ��¼�� ȣ�ڤ���</p>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4 ml-md-5">
                    <h2 class="ftco-heading-2">��α�</h2>
                    <ul class="list-unstyled">
                        <li><a href="#" class="py-2 d-block">������</a></li>
                        <li><a href="#" class="py-2 d-block">Rooms</a></li>
                        <li><a href="#" class="py-2 d-block">Amenities</a></li>
                        <li><a href="#" class="py-2 d-block">Gift Card</a></li>
                        <li><a href="#" class="py-2 d-block">Services</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">�����</h2>
                    <ul class="list-unstyled">
                        <li><a href="#" class="py-2 d-block">������</a></li>
                        <li><a href="#" class="py-2 d-block">About Us</a></li>
                        <li><a href="#" class="py-2 d-block">Contact Us</a></li>
                        <li><a href="#" class="py-2 d-block">Services</a></li>
                        <li><a href="#" class="py-2 d-block">Services</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">������</h2>
                    <div class="block-23 mb-3">
                        <ul>
                            <li><span class="icon icon-map-marker"></span><span class="text">����Ư���� ��õ��<br/>���������1�� 70<br/>ȣ���뺥óŸ�� 4��</span></li>
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
    
    <script src="/static/hotelForm/js/jquery-3.3.1.min.js"></script>
    <script src="/static/hotelForm/js/jquery-migrate-3.0.1.min.js"></script>
    <script src="/static/hotelForm/js/owl.carousel.min.js"></script>
    <script src="/static/hotelForm/js/jquery.stellar.min.js"></script>
    <script src="/static/hotelForm/js/jquery.fancybox.min.js"></script>
    <script src="/static/hotelForm/js/aos.js"></script>
     
    	<!-- �׺�bar ���� -->
	<script src="/static/home/js/scrollax.min.js"></script>
	<script src="/static/home/js/main.js"></script>
</body>
</html>