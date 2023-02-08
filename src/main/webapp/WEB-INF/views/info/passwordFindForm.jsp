<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String error = request.getParameter("error");
%>
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
	<input type="text" class="title text-type" id="referer" value="${referer}" hidden>
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
						<h3 class="mb-4 text-center">등록한 이메일로 비밀번호 찾기</h3>
						<form action="<c:url value="/findPassword"/>" class="signin-form" method="POST">
							<div class="form-group">
								<input type="text" id="userId" class="form-control" placeholder="Id" required>
								<span class="title text-type" id="idNotFound">가입 회원이 아닙니다</span>
								<span class="title text-type" id="idCheck">아이디를 입력해주세요</span>
							</div>
							<div class="form-group">
								<input type="text" id="email" class="form-control" placeholder="Email" required>
								<span class="title text-type" id="emailNotValid">이메일이 다릅니다</span>
								<span class="title text-type" id="emailCheck">이메일을 입력해주세요</span>
							</div>
							<div class="form-group">
								<button type="button" id="sendEmail" class="form-control btn btn-primary submit px-3">이메일로 임시 비밀번호 받기</button>
							</div>
					<div class="form-group d-md-flex">
						<div class="w-50">
							<label class="checkbox-wrap checkbox-primary">
								<span class="checkmark"></span>
							</label>
						</div>
						<div class="w-50 text-md-right">
							<a href="<c:url value="/findId"/>" style="color: #fff">아이디를 몰라요</a>
						</div>
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
				$('#idCheck').css('display', 'none');
				$('#emailCheck').css('display', 'none');
				$('#idNotFound').css('display', 'none');
				$('#emailNotValid').css('display', 'none');

				let userId = document.getElementById("userId").value;
				let email = document.getElementById("email").value;
				let referer = document.getElementById("referer").value;
				if(userId=="") {
					$('#idCheck').css('display', 'block');
					document.getElementById("userId").focus();
					return false;
				}
				if(email=="") {
					$('#emailCheck').css('display', 'block');
					document.getElementById("email").focus();
					return false;
				}
				$.ajax({
					type: 'POST',
					url: '/findPassword',
					contentType: "application/json",
					data: JSON.stringify({userId:userId, email:email}),
					dataType: 'text',
					success: function (result) {
						if(result=='유저가 없습니다') {
							$('#idNotFound').css('display', 'block');
						} else if(result=='이메일이 다릅니다') {
							$('#emailNotValid').css('display', 'block');
						} else if(result=='변경 오류') {
							alert("잠시 후 다시 시도해주세요");
						} else {
							alert("이메일로 임시 비밀번호가 전송되었습니다");
							location.href = referer;
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

