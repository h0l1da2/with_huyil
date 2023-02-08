<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
  <head>
  	<title>위드휴일 - 로그인</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="/resources/static/loginForm/css/style.css">
	  <style>
		  .text-type {
			  color: #ffffff;
			  font-weight: bold;
			  vertical-align: middle;
			  display: none;
		  }
	  </style>
	</head>
	<body class="img js-fullheight" style="background-image: url(<c:url value='/resources/static/loginForm/images/bg.jpg'/>);">
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section"><a href="<c:url value='/'/>">위드휴일</a></h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
						<h3 class="mb-4 text-center">이메일로 인증하세요</h3>
						<form action="<c:url value="/findId"/>" class="signin-form" method="POST">
							<div class="form-group">
								<input type="text" id="email" class="form-control" placeholder="Email" required>
								<span class="title text-type" id="emailCheck">이메일을 입력해주세요</span>
							</div>
							<div class="form-group">
								<input type="text" id="name" class="form-control" placeholder="Name" required>
								<span class="title text-type" id="nameCheck">이름을 입력해주세요</span>
								<span class="title text-type" id="notFound">해당 회원을 찾지 못했습니다</span>
							</div>
							<div class="form-group">
								<button type="button" id="sendEmail" class="form-control btn btn-primary submit px-3">이메일로 아이디 받기</button>
							</div>
					</form>
				</div>
			</div>
		</div>
		</div>
	</section>

	<script src="/resources/static/loginForm/js/jquery.min.js"></script>
	<script src="/resources/static/loginForm/js/popper.js"></script>
	<script src="/resources/static/loginForm/js/bootstrap.min.js"></script>
	<script src="/resources/static/loginForm/js/main.js"></script>
	<script>
		$( document ).ready( function() {
			$('#sendEmail').click(function () {

				$('#nameCheck').css('display', 'none');
				$('#emailCheck').css('display', 'none');
				$('#notFound').css('display', 'none');

				let name = document.getElementById("name").value;
				let email = document.getElementById("email").value;
				console.log(name);
				console.log(email);

				if(name=="") {
					$('#nameCheck').css('display', 'block');
					document.getElementById("name").focus();
					return false;
				}
				if(email=="") {
					$('#emailCheck').css('display', 'block');
					document.getElementById("email").focus();
					return false;
				}
				$.ajax({
					type: 'POST',
					url: '/findId',
					contentType: "application/json",
					data: JSON.stringify({name:name, email:email}),
					dataType: 'text',
					success: function (result) {
						if(result=='전송완료') {
							alert("이메일로 아이디가 전송되었습니다");
							location.href = "/user/loginForm";
						} else {
							$('#notFound').css('display', 'block');
						}
					},
					error: function(result) {
						alert("확인실패");
					}})

			})
		})
	</script>
	</body>
</html>

