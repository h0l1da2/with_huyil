<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
  <head>
  	<title>위드휴일 - 회원가입</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="static/loginForm/css/style.css">

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
	<body class="img js-fullheight" style="background-image: url(static/loginForm/images/bg.jpg);">
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">위드휴일</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
		      	<h3 class="mb-4 text-center">당신의 휴일을 디자인하세요</h3>
		      	<form action="#" class="signin-form">
		      		<div class="form-group">
		      			<input type="text" class="form-control" placeholder="아이디" required>
		      		</div>
	            <div class="form-group">
	              <input id="password-field" type="password" class="form-control" placeholder="비밀번호" required>
	            </div>
				<div class="form-group">
					<input id="password-field" type="password" class="form-control" placeholder="비밀번호 확인" required>
				  </div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이름" required>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="전화번호" required>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이메일" required>
				</div>
	            <div class="form-group">
	            	<button type="submit" class="form-control btn btn-primary submit px-3">인증번호 발송</button>
	            </div>
	            <div class="form-group d-md-flex">
	            </div>
	          </form>
		      </div>
				</div>
			</div>
		</div>
	</section>

	<script src="static/loginForm/js/jquery.min.js"></script>
  <script src="static/loginForm/js/popper.js"></script>
  <script src="static/loginForm/js/bootstrap.min.js"></script>
  <script src="static/loginForm/js/main.js"></script>

	</body>
</html>

