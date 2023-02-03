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
    <link rel="icon" type="image/x-icon" href="<c:url value='/resources/static/host/assets/favicon.ico'/>" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="<c:url value='/resources/static/host/css/styles.css'/>" rel="stylesheet" />
<<<<<<< HEAD
    <style>
        .afterLogin {
            margin-bottom: 20px;
            align-content: space-between;
        }
        .infoBtn {
            width: 233px;
            margin-right: 10px;
        }
    </style>
=======
>>>>>>> 78df10a (호텔 폼 / 호텔 검색 / 리스트 (#20))
</head>
<body style="height: 600px;">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container title">
        <a class="navbar-brand title" href="<c:url value='/'/>">위드휴일</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>
        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
<<<<<<< HEAD
<<<<<<< HEAD
                <c:choose>
                    <c:when test="${userId eq null}"><li class="nav-item"><a href="<c:url value='/host/loginForm'/>" class="nav-link title">로그인</a></li></c:when>
                    <c:when test="${userId ne null && role eq '[ROLE_HOST]'}"><li class="nav-item"><a href="<c:url value='/hosts/info'/>" class="nav-link title">${userId}</a></li></c:when>
                    <c:when test="${userId ne null && role eq '[ROLE_USER]'}"><li class="nav-item"><a href="<c:url value='/user/info'/>" class="nav-link title">${userId}</a></li></c:when>
                </c:choose>
                <c:if test="${userId ne null}"><li class="nav-item"><a href="<c:url value='/logout'/>" class="nav-link title">로그아웃</a></li></c:if>
=======
                <li class="nav-item"><a href="<c:url value='/host/loginForm'/>" class="nav-link">로그인</a></li>
>>>>>>> 78df10a (호텔 폼 / 호텔 검색 / 리스트 (#20))
=======

                <c:choose>
                    <c:when test="${userId eq null}"><li class="nav-item"><a href="/host/loginForm" class="nav-link title">로그인</a></li></c:when>
                    <c:when test="${userId ne null}"><li class="nav-item"><a href="<c:url value='/users/info'/>" class="nav-link title">${userId}</a></li></c:when>
                </c:choose>

<<<<<<< HEAD
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
=======

>>>>>>> b1c1dc2 (깃 충돌 수정중 (#24))
            </ul>
        </div>
    </div>
</nav>
<!-- Product section-->
<section class="py-5">
    <c:choose>
        <c:when test="${userId eq null || role ne '[ROLE_HOST]'}">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6">
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
        </c:when>
        <c:when test="${userId ne null || role eq '[ROLE_HOST]'}">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6">
                        <h1 class="display-5 fw-bolder">${userId}님 환영합니다!</h1>
                        <div class="fs-5 mb-5">
                            <p class="lead">
                                위드 휴일에서 숙소를 등록하고 돈방석에 앉아보세요!<br>
                                위드 휴일과 함께라면!!!<br>
                                강남 재벌도 망상은 아닙니다<br>
                                숙소 등록 먼저 하시죠?
                            </p>
                        </div>
                        <div class="fs-5 mb-5">
                            <div class="d-flex afterLogin">
                                <button type="button" class="form-control btn btn-primary submit px-3 infoBtn">숙소 등록</button>
                                <button type="button" class="form-control btn btn-primary submit px-3 infoBtn">내 숙소 보기</button>
                            </div>
                            <div class="d-flex afterLogin">
                                <button type="button" class="form-control btn btn-primary submit px-3 infoBtn">매출 확인</button>
                                <button onclick="location.href='<c:url value='/hosts/info'/>'" type="button" class="form-control btn btn-primary submit px-3 infoBtn">마이페이지</button>
                            </div>
                        </div>
                    </div>
                    <div id="map" style="width:600px; height:500px;"></div>
                </div>
            </div>
        </c:when>
    </c:choose>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark foot" style="height: 255px;">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; WithHyuil 2023</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="<c:url value='/resources/static/host/js/scripts.js'/>"></script>
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