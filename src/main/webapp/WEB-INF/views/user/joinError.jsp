<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <title>위드휴일 - 가입에러</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="<c:url value='/resources/static/loginForm/css/style.css'/>">

    <style>
        .join {
            margin: 10px;
            margin-left: 4px;
        }
        .ftco-section {
            padding-top: 70px;
        }
    </style>
</head>
<body class="img js-fullheight" style="background-image: url(<c:url value='/resources/static/loginForm/images/bg.jpg'/>);">
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">가입에러</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <div class="login-wrap p-0">
                    <h3 class="mb-4 text-center">이메일 코드가 틀립니다</h3>
                    <form action="#" class="signin-form">
                        <div class="form-group">
                            <a href="<c:url value='/user/join'/>">
                                <button type="button" class="form-control btn btn-primary submit px-3">회원가입으로 돌아가기</button></a>
                        </div>
                        <div class="form-group d-md-flex">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="<c:url value='/resources/static/loginForm/js/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/static/loginForm/js/popper.js'/>"></script>
<script src="<c:url value='/resources/static/loginForm/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/static/loginForm/js/main.js'/>"></script>

</body>
</html>

