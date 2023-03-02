<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>위드 휴일 - 리뷰</title>
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
    <style>
        .title {
            font-family: 'yg-jalnan';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }
        .info-menu {
            display : flex;
            justify-content: center;
            align-items : center;
        }
        .hide {
            display: none;
        }
        .menuBtn {
            cursor: pointer;
            margin: 0px 0px 8px;
        }
        .text-type {
            color: #dc3545;
            display: none;
        }
        .tdReview {
            color: black;
        }
        .reviews {
            margin-left: 10px;
        }
        .lines {
            border: solid;
            width: 800px;
            color: black;
        }
    </style>
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
                <li class="nav-item"><a href="/host" class="nav-link title">호스트등록</a></li>
                <c:choose>
                    <c:when test="${userId eq null}"><li class="nav-item"><a href="/user/loginForm" class="nav-link title">로그인</a></li></c:when>
                    <c:when test="${role eq '[ROLE_USER]'}"><li class="nav-item"><a href="<c:url value='/user/info'/>" class="nav-link title">${userId}</a></li></c:when>
                    <c:when test="${role eq '[ROLE_HOST]'}"><li class="nav-item"><a href="<c:url value='/hosts/info'/>" class="nav-link title">${userId}</a></li></c:when>
                </c:choose>
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
                    <p class="breadcrumbs mb-2"><span class="mr-2"><a href="/">Home</a></span>
                    <h1 class="mb-4 bread">리뷰</h1>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section">
    <div class="container">
        <div class="col-lg-8">
            <div class="col-md-12 ftco-animate">
                <div class="single-slider owl-carousel">
                    <div class="item">
                        <a href="/hotel/detail?id=${hotelVo.id}">
                            <!-- 컨트롤러에서 파일 받아오ㅏ야함 -->
                            <img class="room-img" src="/img?filename=${filevo.uuid }"></img></a>
                    </div>
                </div>
            </div>
            <div class="col-md-12">
                <h2 class="mb-4"><a href="/hotel/detail?id=${hotelVo.id}"> ${hotelVo.name}</a></h2>
                <div class="star-rating">
                    <div class="rating" data-rate="<%--${hotelvo.star}--%>">
                        <i><a href="/hotel/review?id=${hotelVo.id}">리뷰 ${star.totcnt}개</a></i>
                        <c:if test="${0.0 < star.reviewStars && star.reviewStars <= 1.5}">
                            <i class="icon-star"></i><i class="icon-star-o"></i><i class="icon-star-o"></i><i class="icon-star-o"></i><i class="icon-star-o"></i>
                        </c:if>
                        <c:if test="${1.5 < star.reviewStars && star.reviewStars <= 2.5}">
                            <i class="icon-star"></i><i class="icon-star"></i><i class="icon-star-o"></i><i class="icon-star-o"></i><i class="icon-star-o"></i>
                        </c:if>
                        <c:if test="${2.5 < star.reviewStars && star.reviewStars <= 3.5}">
                            <i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star-o"></i><i class="icon-star-o"></i>
                        </c:if>
                        <c:if test="${3.5 < star.reviewStars && star.reviewStars <= 4.5}">
                            <i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star-o"></i>
                        </c:if>
                        <c:if test="${4.5 < star.reviewStars && star.reviewStars <= 5.0}">
                            <i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i>
                        </c:if>
                        <c:if test="${star.reviewStars == 0.0}">
                            <i class="icon-star-o"></i><i class="icon-star-o"></i><i class="icon-star-o"></i><i class="icon-star-o"></i><i class="icon-star-o"></i>
                        </c:if>
                    </div>
                </div>
                <br>
                <table>
                    <tr> <td style="padding: 0 20px 0 20px;"><a href="<c:url value="/hotel/detail?id=${hotelVo.id}"/>" style="font-size: 30px; color: #002a80;">호텔 정보</a></td>
                </table>
                <br>
            </div>
            <hr class="lines">
            <c:if test="${bookId ne null}">
            <div class="row block-9 info-menu" style="text-align: center;">
                <form id="form" action="<c:url value="/hotel/review/write"/>" method="POST" class="bg-white p-5 contact-form" onsubmit="return formCheck(this)">
                    <div class="menu">
                        <h2><label class="h3 menuBtn">리뷰 쓰기</label></h2>
                        <ul class="hide">
                            <div class="form-group">
                                <label class="title for-label">청결
                                    <input type="radio" name="clean" id="clean5" class="custom-check-box for-delete" value="5" checked>★★★★★</label>
                                <input type="radio" name="clean" id="clean4" class="custom-check-box for-delete" value="4">★★★★☆</label>
                                <input type="radio" name="clean" id="clean3" class="custom-check-box for-delete" value="3">★★★☆☆</label>
                                <input type="radio" name="clean" id="clean2" class="custom-check-box for-delete" value="2">★★☆☆☆</label>
                                <input type="radio" name="clean" id="clean1" class="custom-check-box for-delete" value="1">★☆☆☆☆</label>
                            </div>
                            <div class="form-group">
                                <label class="title for-label">시설
                                    <input type="radio" name="facilities" id="facilities5" class="custom-check-box for-delete" value="5" checked>★★★★★</label>
                                <input type="radio" name="facilities" id="facilities4" class="custom-check-box for-delete" value="4">★★★★☆</label>
                                <input type="radio" name="facilities" id="facilities3" class="custom-check-box for-delete" value="3">★★★☆☆</label>
                                <input type="radio" name="facilities" id="facilities2" class="custom-check-box for-delete" value="2">★★☆☆☆</label>
                                <input type="radio" name="facilities" id="facilities1" class="custom-check-box for-delete" value="1">★☆☆☆☆</label>

                            </div>
                            <div class="form-group">
                                <label class="title for-label">방 상태
                                    <input type="radio" name="condition" id="condition5" class="custom-check-box for-delete" value="5" checked>★★★★★</label>
                                <input type="radio" name="condition" id="condition4" class="custom-check-box for-delete" value="4">★★★★☆</label>
                                <input type="radio" name="condition" id="condition3" class="custom-check-box for-delete" value="3">★★★☆☆</label>
                                <input type="radio" name="condition" id="condition2" class="custom-check-box for-delete" value="2">★★☆☆☆</label>
                                <input type="radio" name="condition" id="condition1" class="custom-check-box for-delete" value="1">★☆☆☆☆</label>
                            </div>
                            <div class="form-group">
                                <label class="title for-label">주변 환경
                                    <input type="radio" name="organic" id="organic5" class="custom-check-box for-delete" value="5" checked>★★★★★</label>
                                <input type="radio" name="organic" id="organic4" class="custom-check-box for-delete" value="4">★★★★☆</label>
                                <input type="radio" name="organic" id="organic3" class="custom-check-box for-delete" value="3">★★★☆☆</label>
                                <input type="radio" name="organic" id="organic2" class="custom-check-box for-delete" value="2">★★☆☆☆</label>
                                <input type="radio" name="organic" id="organic1" class="custom-check-box for-delete" value="1">★☆☆☆☆</label>
                                </label>
                            </div>
                            <div class="form-group">
                                <input type="text" name="title" id="title" class="form-control" placeholder="제목">
                                <span class="title text-type" id="noTitle" name="noTitle">제목을 입력해주세요</span>
                            </div>
                            <div class="form-group">
                                <textarea id="content" name="content" cols="30" rows="7" class="form-control msg-box" placeholder="내용"></textarea>
                                <span class="title text-type" id="noContent" name="noContent">내용을 입력해주세요</span>
                            </div>
                            <div class="form-group">
                                <input type="button" id="reviewBtn" class="btn btn-primary py-3 px-5" value="리뷰 쓰기">
                            </div>
                        </ul>
                    </div>
                </form>
            </div>
            </c:if>
            <!-- Rooms Section Begin -->
            <section class="rooms-section spad" id="selectroom">
                <div class="container">
                    <h1>리뷰</h1>
                    <div class="row" style="width:800px;">
                        <hr class="lines">
                        <c:forEach items="${reviewDtoList}" var="review">
                                <c:if test="${review.userType eq 'USER'}">
                            <div class="col-md-6 reviews">
                                <div class="room-item" style="width: 400px;">
                                    <div class="ri-text">
                                        <h3>${review.title}</h3>
                                        <h6>${review.userId}</h6>
                                        <a>청결 ${review.clean}점 | 시설 ${review.facilities}점 | </a>
                                        <a>방 상태 ${review.condition}점 | 주변 환경 ${review.organic}점</a>
                                        <table>
                                            <tr>
                                                <td class="tdReview">${review.userCreate}</td>
                                            </tr>
                                            <tr>
                                                <td class="tdReview">${review.content}</td>
                                            </tr>
                                        </table>
                                    </div>
                                    <br>
                                </div>
                            </div>
                                    <hr class="lines">
                                    <c:forEach items="${reviewDtoList}" var="reviewHost">
                                        <c:if test="${reviewHost.userType eq 'HOST' && review.id eq reviewHost.replyId}">
                                            <div class="col-md-6 reviews">
                                                <div class="room-item" style="width: 400px;">
                                                    <div class="ri-text">
                                                        <h6>사장님의 댓글</h6>
                                                        <table>
                                                            <tr>
                                                                <td class="tdReview">${reviewHost.content}</td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                    <br>
                                                </div>
                                            </div>
                                            <hr class="lines">
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${hotelVo.userId eq userLongId}">
                                        <form id="form" action="<c:url value="/hotel/review/write/host"/>" method="POST" class="bg-white p-5 contact-form" onsubmit="return formCheck(this)">
                                            <div class="menu">
                                                <h2><label class="h3 menuBtn">댓글 쓰기</label></h2>
                                                <ul>
                                                    <div class="form-group">
                                                        <textarea id="hostContent" name="content" cols="30" rows="7" class="form-control msg-box" placeholder="내용"></textarea>
                                                        <span class="title text-type" id="noHostContent" name="noHostContent">내용을 입력해주세요</span>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" name="hotelId" class="form-control" value="${hotelVo.id}" hidden>
                                                        <input type="text" name="replyId" class="form-control" value="${review.id}" hidden>
                                                        <input type="text" name="userLongId" class="form-control" value="${userLongId}" hidden>
                                                    </div>

                                                    <div class="form-group">
                                                        <input type="submit" id="reviewHostBtn" class="btn btn-primary py-3 px-5" value="댓글 쓰기">
                                                    </div>
                                                </ul>
                                            </div>
                                        </form>
                                    </c:if>
                                </c:if>
                        </c:forEach>
                    </div>
                </div>
            </section>
        </div>
    </div>
</section>
<!-- Rooms Section End -->
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
<!-- 별점 icon -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"></script>
<script src="https://kit.fontawesome.com/d89e70aecc.js"></script>
<script>
    function formCheck() {
        $('#noHostTitle').css('display', 'block');
        $('#noHostContent').css('display', 'block');
        let title = document.getElementById('hostTitle').value;
        if (title == "") {
            $('#noHostTitle').css('display', 'none');
            return false;
        }
        let content = document.getElementById('hostContent').value;
        if (content == "") {
            $('#noHostContent').css('display', 'none');
            return false;
        }
    }
    $(document).ready(function() {
        $("#reviewBtn").click(function () {
            $('#noTitle').css('display', 'block');
            $('#noContent').css('display', 'block');
            let title = document.getElementById('title').value;
            if (title == "") {
                $('#noTitle').css('display', 'none');
                return false;
            }
            let content = document.getElementById('content').value;
            if (content == "") {
                $('#noContent').css('display', 'none');
                return false;
            }
            let clean = document.querySelector('input[name="clean"]:checked').value;
            let facilities = document.querySelector('input[name="facilities"]:checked').value;
            let condition = document.querySelector('input[name="condition"]:checked').value;
            let organic = document.querySelector('input[name="organic"]:checked').value;

            $.ajax({
                type: 'POST',
                url: '/hotel/review/write',
                contentType: "application/json",
                data: JSON.stringify({userLongId:'${userLongId}', hotelId:${hotelVo.id}, bookId:${bookId},
                clean:clean, facilities:facilities, condition:condition, organic:organic, title:title, content:content}),
                dataType: 'text',
                success: function (result) {
                    if(result=='리뷰 성공') {
                        location.href = '/hotel/review?id=${hotelVo.id}';
                    } else {
                        alert("리뷰 작성 실패");
                    }
                },
                error: function(result) {
                    alert("확인실패");
                }})
        });

        <%--$("#reviewHostBtn").click(function () {--%>
        <%--    $('#noHostTitle').css('display', 'block');--%>
        <%--    $('#noHostContent').css('display', 'block');--%>
        <%--    let title = document.getElementById('hostTitle').value;--%>
        <%--    if (title == "") {--%>
        <%--        $('#noHostTitle').css('display', 'none');--%>
        <%--        return false;--%>
        <%--    }--%>
        <%--    let content = document.getElementById('hostContent').value;--%>
        <%--    if (content == "") {--%>
        <%--        $('#noHostContent').css('display', 'none');--%>
        <%--        return false;--%>
        <%--    }--%>
        <%--    $.ajax({--%>
        <%--        type: 'POST',--%>
        <%--        url: '/hotel/review/write/host',--%>
        <%--        contentType: "application/json",--%>
        <%--        data: JSON.stringify({userId:${userLongId}, hotelId:${hotelVo.id}, title:title, content:content, reviewId:${}}),--%>
        <%--        dataType: 'text',--%>
        <%--        success: function (result) {--%>
        <%--            if(result=='리뷰 성공') {--%>
        <%--                location.href = '/hotel/review?id=${hotelVo.id}';--%>
        <%--            } else {--%>
        <%--                alert("리뷰 작성 실패");--%>
        <%--            }--%>
        <%--        },--%>
        <%--        error: function(result) {--%>
        <%--            alert("확인실패");--%>
        <%--        }})--%>
        <%--})--%>
            $(".menu>h2").click(function () {
            var submenu = $(this).next("ul");
            if (submenu.is(":visible")) {
                submenu.slideUp();
            } else {
                submenu.slideDown();
            }
        });
    })
</script>
</body>
</html>