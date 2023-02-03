<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i" rel="stylesheet">

    <link rel="stylesheet" href="/static/home/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="/static/home/css/style.css">


    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
      integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
    <script src="/static/user/js/user-book-check.js" defer></script>
    <link rel="stylesheet" href="/static/user/css/user-book-check.css">
  </head>

  <body>
    <header class=" navbar navbar-expand-lg navbar-dark ftco-navbar bg-dark" id="ftco-navbar">
      <div class="container">
        <a class="navbar-brand title" href="/">위드휴일</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
          aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a href="#" class="nav-link title">내 예약내역</a></li>
            <li style=" margin: auto 0; cursor: pointer;" class="user-profile">
              <img src="/static/user/images/카리나.jpg" alt="카리나" style="width: 35px; height: 35px;">
            </li>
            <li>
            </li>
          </ul>
        </div>
      </div>
    </header>
    <section>
      <div class="checked">
        <div class="picture">
          <img src="/static/user/images/카리나.jpg" alt="">
        </div>
        <div class="booked-info">
          <div class="room-name">객실이름</div>
          <div class="user-info">결제자 이름 + 인원수 + 가격</div>
        </div>
        <div class="booked-status">상태</div>
      </div>
      <div class="checked">
        <div class="picture">
          <img src="/static/user/images/카리나.jpg" alt="">
        </div>
        <div class="booked-info">
          <div class="room-name">객실이름</div>
          <div class="user-info">결제자 이름 + 인원수 + 가격</div>
        </div>
        <div class="booked-status">상태</div>
      </div>
      <div class="checked">
        <div class="picture">
          <img src="/static/user/images/카리나.jpg" alt="">
        </div>
        <div class="booked-info">
          <div class="room-name">객실이름</div>
          <div class="user-info">결제자 이름 + 인원수 + 가격</div>
        </div>
        <div class="booked-status">상태</div>
      </div>
      <div class="checked">
        <div class="picture">
          <img src="/static/user/images/카리나.jpg" alt="">
        </div>
        <div class="booked-info">
          <div class="room-name">객실이름</div>
          <div class="user-info">결제자 이름 + 인원수 + 가격</div>
        </div>
        <div class="booked-status">상태</div>
      </div>
    </section>


    <!-- modal -->
    <div class="modal">
      <div class="modal-body">
        <!-- 호텔 정보 -->
        <div class="left">
          <div class=" left hotel-info">
            <!-- 호텔 사진 -->
            <div class="hotel-info picture"><img src="/static/user/images/카리나.jpg" alt=""></div>
            <!-- 호텔 설명 -->
            <div class="hotel-info description">
              <div class="hotel-info hotel-name">신라호텔 디럭스 1130호</div>
              <div class="hotel-info hotel-location">서울 중구 동호로 249</div>
            </div>
          </div>

          <!-- 예약 정보 (체크인, 체크아웃, 인원수, 금액) -->
          <div class="left book-info">
            <div class="book-info date">
              <div class="check-in">yyyy-mm-dd</div>
              <div class="check-out">yyyy-mm-dd</div>
            </div>
            <div class="book-info people">15명</div>
            <div class="book-info price">250.000</div>
            <!-- 요청 사항-->
            <div class="left require">요청사항
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Nulla vero labore magnam. Magnam, incidunt omnis
              dicta perferendis porro, sint est earum, repellendus doloremque veniam repellat. Ad assumenda quos saepe
              quaerat.
            </div>
          </div>

        </div>
        <div class="hotel-info rights">호텔설명Lorem ipsum dolor sit, amet consectetur adipisicing elit. Inventore dolorem
          libero
          nesciunt eius fugit maiores, necessitatibus, repellendus minima veritatis debitis aliquam consectetur vitae
          tempore optio. Dolor eligendi at incidunt natus?
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Officiis quis maxime unde nam assumenda modi eum,
          aperiam culpa rem, facilis magni sit? Esse, sunt magnam! Et eius ea reiciendis itaque!
        </div>
        <!-- 결제, 취소 -->
        <div class="left btn">
          <button id="cancle-btn">예약 취소</button>
          <button id="check-btn">예약 확인</button>
        </div>
      </div>
    </div>
  </body>

  <!-- paging -->
  <div class="paging">1|2|3|4</div>

  <footer>
    Footer
  </footer>

  </body>

  </html>