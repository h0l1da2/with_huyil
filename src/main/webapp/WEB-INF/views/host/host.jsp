<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shop Item - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="<c:url value='/static/host/assets/favicon.ico'/>" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="<c:url value='/static/host/css/styles.css'/>" rel="stylesheet" />
</head>
<body style="height: 600px;">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container title">
        <a class="navbar-brand title" href="/">위드휴일</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>
        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a href="/loginForm" class="nav-link">로그인</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- Product section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6">
                <div class="small mb-1">SKU: BST-498</div>
                <h1 class="display-5 fw-bolder">위드휴일의 호스트ㄱㄱ?</h1>
                <div class="fs-5 mb-5">
                    <p class="lead">
                        탐욕스러우시다고요? 돈이존나필요하시다구요?
                        당장여기로와서돈을쓸어담으세요존나열려잇습니
                        다당신을환영해요다당신을환영해요다당신을환영해요다당신을환영해요다당신을환영해요다당신을환영해요다당신을환영해요다당신을환영해요다당신을환영해요
                    </p>
                </div>
                <div class="d-flex">
                    <button onclick="location.href='<c:url value='/host/loginForm'/>'" type="button" class="form-control btn btn-primary submit px-3">당장 함께하기</button>
                </div>
            </div>
            <div id="map" style="width:600px; height:500px;"></div>
        </div>
    </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark foot" style="height: 255px;">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; WithHyuil 2023</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="<c:url value='/static/host/js/scripts.js'/>"></script>
<!-- 카카오맵 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9093f985faa6566619ee93146e47c723"></script>
<script>
    var container = document.getElementById('map');
    var options = {
        center: new kakao.maps.LatLng(37.47228753186775, 126.8860873478374),
        level: 3
    };

    var map = new kakao.maps.Map(container, options);
</script>
</body>
</html>
