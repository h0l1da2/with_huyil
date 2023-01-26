<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
  <head>
  	<title>위드휴일 - 회원가입</title>
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
		#passwordCheckP {
			color: #dc3545;
			display: none;
		}
	</style>
	</head>
	<body class="img js-fullheight" style="background-image: url(<c:url value='/static/loginForm/images/bg.jpg'/>); height: 1000px">
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
		      	<h3 class="mb-4 text-center">호스트로 휴일을 함께하세요</h3>
		      	<form id="form" action="<c:url value='/host/join/email'/>" class="signin-form" method="POST" onsubmit="return formCheck(this)">
		      		<div class="form-group">
		      			<input type="text" id="userId" name="userId" class="form-control" placeholder="아이디" required>
		      		</div>
					<div class="form-group">
						<button type="button" id="idCheck" name="idCheck" class="form-control btn btn-primary submit px-3">중복확인</button>
		      		</div>
	            <div class="form-group">
	              <input id="password" name="password" type="password" class="form-control" placeholder="비밀번호" required>
	            </div>
				<div class="form-group">
					<input id="passwordCheck" name="passwordCheck" type="password" class="form-control" placeholder="비밀번호 확인" required>
					<span id="passwordCheckP" name="passwordCheckP">비밀번호가 틀립니다</span>
				</div>
				<div class="form-group">
					<input type="text" id="name" name="name" class="form-control" placeholder="이름" required>
				</div>
					<div class="form-group">
					<input type="text" id="account" name="account" class="form-control" placeholder="사업자번호" required>
				</div>
					<div class="form-group">
					<input type="text" id="bank" name="bank" class="form-control" placeholder="은행" required>
				</div>
					<div class="form-group">
					<input type="text" id="bNumber" name="bNumber" class="form-control" placeholder="계좌번호" required>
				</div>
				<div class="form-group">
					<input type="text" id="tel" name="tel" class="form-control" placeholder="전화번호" required>
				</div>
				<div class="form-group">
					<input type="text" id="email" name="email" class="form-control" placeholder="이메일" required>
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
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="<c:url value='/resources/static/loginForm/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/static/loginForm/js/popper.js'/>"></script>
  <script src="<c:url value='/resources/static/loginForm/js/bootstrap.min.js'/>"></script>
  <script src="<c:url value='/resources/static/loginForm/js/main.js'/>"></script>
	<script>
		function formCheck(form) {
			if(check == 0) {
				alert("아이디 중복 확인을 해주세요");
				return false;
			}
			if($('#passwordCheckP').css('display') == 'block') {
				alert("비밀번호가 같아야합니다");
				document.getElementById("passwordCheck").focus();
				return false;
			}
		}
		//아이디 중복 확인을 위한 변수
		let check = 0;
		//id값 변경 감지하는 변수
		let oldVal = 0;
		$( document ).ready( function() {
			$('#passwordCheck').on("propertychange change keyup paste input", function (frm) {
				$('#passwordCheckP').css('display', 'block');
					if(document.getElementById('password').value == document.getElementById('passwordCheck').value) {
						$('#passwordCheckP').css('display', 'none');
						return false;
					}
			});
			$("#userId").on("propertychange change keyup paste input", function() {
				var currentVal = $(this).val();
				if(currentVal == oldVal) {
					return;
				}
				oldVal = currentVal;
				check = 0;
			});
		});

		$('#idCheck').click(function () {
			let userId = document.getElementById("userId").value;
			if(userId=="") {
				alert("아이디를 입력하세요");
				document.getElementById("userId").focus();
				return false;
			}
			$.ajax({
				type: 'POST',
				url: '/host/join/id',
				contentType: "application/json",
				data: JSON.stringify({userId:userId}),
				dataType: 'text',
				success: function (result) {
					if(result=="true") {
						alert("중복이 아닙니다");
						check=1;
					} else {
						alert("중복입니다");
						document.getElementById('userId').focus();
					}
				},
			error: function(result) {
				alert("확인실패");
			}})
		});
	</script>
	</body>
</html>

