<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
    <title>with hyuil ȣ�ڵ��</title>
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
    <label for="exampleFormControlInput1">ȣ�ڸ�</label>
    <input type="text" id="name" style="width:300px; height:50px;">
    <br> <br>

    <label for="exampleFormControlInput1">�ּ� &nbsp;&nbsp;</label> 
    <input type="text" id="zonecode" name="postcode" placeholder="�����ȣ" style="width:200px; height:50px;"> &nbsp;&nbsp;

    <input type="text" id="sigoon9" placeholder="��/��/��" style="width:200px; height:50px;"> &nbsp;&nbsp;
  
    <input type="text" id="address" placeholder="���θ��ּ�" size="40" style="width:200px; height:50px;"> &nbsp;&nbsp;
    <button class="w-btn w-btn-green" type="button" onclick="sample4_execDaumPostcode()">
        �����ȣ ã��
    </button> <br> <br>
    <div class="form-group">
    
    <label for="exampleFormControlInput1">ȣ�żҰ� �̹���(1��)</label>
	<input class="form-control form-control-user" type="file" 
	name="product_image" id="product_image" onchange="setThumbnail(event);" style="width:300px; height:50px;"> <br>

	<div style=width:6 id="image_container"></div> <br>

    <label for="exampleFormControlInput1">����</label>
    <table style='margin-top:0px; border:1px solid #000' cellspacing=0 cellpadding=10>
    <tr>
    <td>
    <select name="bed" style="width:100px; height:50px;">
    <option value="" selected>ħ�� ������</option>
    <option value="1">single bed</option>
    <option value="2">double bed</option>
    <option value="3">king bed</option>
    </select>
    </td>
    <td style="padding:0 20px 0 20px"> <input type="checkbox" name="service" value=1>Breakfast</td>
    <td style="padding:0 20px 0 20px"> <input type="checkbox" name="service" value=2>Pool</td>
    <td style="padding:0 20px 0 20px"> <input type="checkbox" name="service" value=3>Parking</td>
    <td style="padding:0 20px 0 20px"> <input type="checkbox" name="service" value=4>WiFi</td>
    <td style="padding:0 20px 0 20px"> <input type="checkbox" name="service" value=5>Fitness</td>
    </tr>
    </table> <br>
    
    <label for="exampleFormControlInput1">ȣ�ڼҰ���</label> <br>
    <textArea style=resize:none; name="intro" rows="7" cols="100"></textArea> <br> <br>
    
    <label for="exampleFormControlInput1">����ȳ�</label> <br>
    <textArea style=resize:none; name="spot" rows="5" cols="70"></textArea> <br> <br>
    
    <label for="exampleFormControlInput1">�ֺ����</label> <br>
    <textArea style=resize:none; name="spot" rows="5" cols="70"></textArea> <br> <br>
    
    <label for="exampleFormControlInput1">ȣ����å</label> <br>
    <textArea style=resize:none; name="spot" rows="7" cols="100"></textArea> <br> <br>
    
    <label for="exampleFormControlInput1">�̿�ð�</label> <br>
    <select name="checkin">
    <option value="" selected>üũ�� ���ɽð�</option>
    <option value="1">���� 01:00</option>
    <option value="2">���� 02:00</option>
    <option value="3">���� 03:00</option>
    <option value="4">���� 04:00</option>
    <option value="5">���� 05:00</option>
    <option value="6">���� 06:00</option>
    <option value="7">���� 07:00</option>
    <option value="8">���� 08:00</option>
    </select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
    <select name="checkout">
    <option value="" selected>üũ�ƿ� ���ɽð�</option>
    <option value="1">���� 10:00</option>
    <option value="2">���� 11:00</option>
    <option value="3">���� 12:00</option>
    <option value="4">���� 01:00</option>
    <option value="5">���� 02:00</option>
    <option value="6">���� 03:00</option>
    <option value="7">���� 04:00</option>
    <option value="8">���� 05:00</option>
    </select> <br><br>
    
    <label for="exampleFormControlInput1">���ึ���ð�</label> <br>
    <select name="close">
    <option value="" selected>--�ð�����--</option>
    <option value="1">���� 06:00</option>
    <option value="2">���� 07:00</option>
    <option value="3">���� 08:00</option>
    <option value="4">���� 09:00</option>
    <option value="5">���� 10:00</option>
    <option value="6">���� 11:00</option>
    <option value="7">���� 12:00</option>
    <option value="8">���� 01:00</option>
    <option value="9">���� 02:00</option>
    </select>
    
    <br> <br>
    <button class="w-btn-neon2" type="submit">
        �����ܰ�
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