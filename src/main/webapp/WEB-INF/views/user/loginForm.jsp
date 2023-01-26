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
		.join {
			margin: 10px;
			margin-left: 4px;
		}
		.text-type {
			color: #ffffff;
			font-weight: bold;
			vertical-align: middle;
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
<<<<<<< HEAD
		</div>
		<div class="row justify-content-center">
			<div class="col-md-6 col-lg-4">
				<div class="login-wrap p-0">
					<h3 class="mb-4 text-center">당신의 휴일을 디자인하세요</h3>
					<span class="title text-type" <c:if test="<%= error == null %>"> hidden </c:if>>아이디 또는 비밀번호가 틀립니다</span>
					<form action="<c:url value="/login"/>" class="signin-form" method="POST">
						<div class="form-group">
							<input type="text" id="userId" name="userId" class="form-control" placeholder="Username" required>
						</div>
						<div class="form-group">
							<input id="password-field" name="password" type="password" class="form-control" placeholder="Password" required>
							<span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
						</div>
						<div class="form-group">
							<button type="submit" class="form-control btn btn-primary submit px-3">로그인</button>
						</div>
						<div class="form-group d-md-flex">
							<div class="w-50">
								<label class="checkbox-wrap checkbox-primary">아이디 기억
									<input type="checkbox" checked>
									<span class="checkmark"></span>
								</label>
							</div>
							<div class="w-50 text-md-right">
								<a href="<c:url value="/findPassword"/>" style="color: #fff">비밀번호찾기</a>
							</div>
						</div>
					</form>
					<div class="social d-flex text-center">
						<a href="<c:url value='/user/join'/>" class="px-2 py-2 mr-md-1 rounded join"><span class="ion-logo-facebook mr-2"></span> 회원가입</a>
					</div>
					<p class="w-100 text-center">&mdash; With SNS &mdash;</p>
					<div class="social d-flex text-center">
						<a href="<c:url value="/oauth2/authorization/kakao"/>" class="px-2 py-2 mr-md-1 rounded"><span class="ion-logo-facebook mr-2"></span> Kakao</a>
						<a href="<c:url value="/oauth2/authorization/google"/>" class="px-2 py-2 mr-md-1 rounded" style="margin-left: 4px;"><span class="ion-logo-facebook mr-2"></span> Google</a>
						<a href="<c:url value="/oauth2/authorization/naver"/>" class="px-2 py-2 ml-md-1 rounded"><span class="ion-logo-twitter mr-2"></span> Naver</a>
					</div>
=======
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
		      	<h3 class="mb-4 text-center">당신의 휴일을 디자인하세요</h3>
		      	<form action="<c:url value="/user/login"/>" class="signin-form" method="POST">
		      		<div class="form-group">
		      			<input type="text" id="userId" name="userId" class="form-control" placeholder="Username" required>
		      		</div>
	            <div class="form-group">
	              <input id="password-field" name="password" type="password" class="form-control" placeholder="Password" required>
	              <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
	            </div>
	            <div class="form-group">
<%--	            	<button type="submit" class="form-control btn btn-primary submit px-3">로그인</button>--%>
	            	<button type="button" id="loginBtn" name="loginBtn" class="form-control btn btn-primary submit px-3">로그인</button>
	            </div>
	            <div class="form-group d-md-flex">
	            	<div class="w-50">
		            	<label class="checkbox-wrap checkbox-primary">아이디 기억
									  <input type="checkbox" checked>
									  <span class="checkmark"></span>
									</label>
								</div>
								<div class="w-50 text-md-right">
									<a href="#" style="color: #fff">비밀번호찾기</a>
								</div>
	            </div>
	          </form>
			  <div class="social d-flex text-center">
				<a href="<c:url value='/user/join'/>" class="px-2 py-2 mr-md-1 rounded join"><span class="ion-logo-facebook mr-2"></span> 회원가입</a>
			</div>
	          <p class="w-100 text-center">&mdash; With SNS &mdash;</p>
			  <div class="social d-flex text-center">
	          	<a href="#" class="px-2 py-2 mr-md-1 rounded"><span class="ion-logo-facebook mr-2"></span> Kakao</a>
				<a href="#" class="px-2 py-2 mr-md-1 rounded" style="margin-left: 4px;"><span class="ion-logo-facebook mr-2"></span> Google</a>
	          	<a href="#" class="px-2 py-2 ml-md-1 rounded"><span class="ion-logo-twitter mr-2"></span> Naver</a>
	          </div>

		      </div>
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
				</div>
			</div>
		</div>
	</div>
</section>

<<<<<<< HEAD
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
=======
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
				$.ajax({
					type: 'POST',
					url: '/user/login',
					contentType: "application/json",
					data: JSON.stringify({userId:userId, password:password}),
					dataType: 'text',
					success: function (result) {
						localStorage.setItem("jwt", result);
					},
					error: function() {
						alert("아이디나 비밀번호를 확인하세요");
					}})
			})
		})
	</script>
	</body>
>>>>>>> 62589e9 (jwt 토큰 로컬스토리지 저장)
</html>
