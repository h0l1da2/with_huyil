<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <link rel="stylesheet" href="/static/host/css/host-book-check.css">
      <script src="/static/host/js/host-book-check.js" defer></script>

      <script>
        // $(document).ready(() => {
          // ok, 이건 탭에 따라 각 예약 상태별로 페이징 하기 위함
          // $(".status_confirmed").click(() => {

          //   $.get("/business/business-sales", {
          //   }).done((data) => {
          //     console.log(data);
          //   })
          // })

          // 이건 상태를 누르면 해당 예약의 상세내역을 확인
          // $(".table_status").click(() => {
          //   let tbl_num = $(".table_status").attr("name");
          //   console.log(tbl_num);

          //   $.get("/business/bookedDetail/${tbl_num}", {

          //   })

          // })

        // })
      </script>

    </head>

    <body>
      <header class=" navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark" id="ftco-navbar">
        <div class="container">
          <a class="navbar-brand title" href="/">위드휴일</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
            aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
          </button>

          <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item"><a href="#" class="nav-link">호스트 판매내역 확인</a></li>
              <li style=" margin: auto 0; cursor: pointer;" class="user-profile">
                <img src="/static/host/images/카리나.jpg" alt="카리나" style="width: 35px; height: 35px;">
              </li>
              <li>
              </li>
            </ul>
          </div>
        </div>
      </header>

      <section class="status">
        <div class="status_wait">
          <button>결제완료</button>
        </div>
        <div class="status_confirmed">
          <button>예약완료</button>
        </div>
        <div class="status_passed">
          <button>숙박종료</button>
        </div>
        <div class="status_cancle">
          <button>예약취소</button>
        </div>
      </section>

      <section>
        <table border="1" style="border-collapse: collapse;">
          <tr>
            <th class="table_picture">예약 번호</th>
            <th class="table_info">신라호텔 1100호 디럭스 블라블라 / 이수완(2013) 외 ${list.count}</th>
            <th class="table_status" name="${list.id}">${list.status}</th>
          </tr>
          <tr>
            <th class="table_picture">예약 번호</th>
            <th class="table_info">신라호텔 1100호 디럭스 블라블라 / 이수완(2013) 외 1명</th>
            <th class="table_status">결제완료</th>
          </tr>
          <tr>
            <th class="table_picture">예약 번호</th>
            <th class="table_info">신라호텔 1100호 디럭스 블라블라 / 이수완(2013) 외 1명</th>
            <th class="table_status">결제완료</th>
          </tr>
          <tr>
            <th class="table_picture">예약 번호</th>
            <th class="table_info">신라호텔 1100호 디럭스 블라블라 / 이수완(2013) 외 1명</th>
            <th class="table_status">결제완료</th>
          </tr>
        </table>
      </section>

      <!-- paging -->
      <div class=" paging">1|2|3|4
      </div>

      <footer>
        Footer
      </footer>

      <div class="modal">
        <div class="modal_body">
          <!-- modal header -->
          <div class="modal_header">
            <div class="modal_header room_pic">숙소 사진</div>
            <div class="modal_header booking_info">
              <div class="booking_info user">숙소 이름</div>
              <div class="booking_info user">${list.check_in}2023-02-28 ~ 2023-03-02${list.check_out} <br> 결제 금액:
                315,000</div>
            </div>
          </div>

          <!-- modal article? 머라하냐 -->
          <div class="modal_article">
            <div class="modal_article booking_detail">예약 상세내역
              <div></div>
            </div>
            <div class="modal_article booking_require">요청사항</div>
          </div>
          <!-- modal bottom -->
          <div class="modal_bottom">
            <button id="cancle-btn">취소</button>
            <button id="check-btn">확인</button>
          </div>
        </div>
      </div>

    </body>

    </html>