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
	</head>
	<body class="img js-fullheight" style="background-image: url(<c:url value='/resources/static/loginForm/images/bg.jpg'/>);">
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
						<h3 class="mb-4 text-center">이메일로 인증하세요</h3>
						<form action="#" class="signin-form">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Email" required>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Name" required>
							</div>
							<div class="form-group">
								<button type="submit" class="form-control btn btn-primary submit px-3">이메일로 아이디 받기</button>
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
			$('#loginBtn').click(function () {
				let userId = document.getElementById("userId").value;
				let password = document.getElementById("password-field").value;

				if(userId=="") {
					alert("아이디를 입력하세요");
					document.getElementById("userId").focus();
					return false;
				}
				if(password=="") {
					alert("패스워드를 입력하세요");
					document.getElementById("password-field").focus();
					return false;
				}
			})
		})
	</script>
	</body>
</html>

