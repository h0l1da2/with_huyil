<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">

<link rel="stylesheet" href="/static/fav/css/bootstrap.min.css">
</head>
<body>
<div class="card-group">
  <div style=" cursor: pointer;" onclick="location.href='/fav/favDetail';" class="card" >
    <img src="${pageContext.request.contextPath }/static/fav/images/seoul.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">���￩��</h5>
      <p class="card-text">����Ʈ �߰��� ������ ������</p>
      <p class="card-text"><small class="text-muted">������¥</small></p>
    </div>
  </div>
  <div class="card">
    <img src="${pageContext.request.contextPath }/static/fav/images/busan.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">�λ꿩��</h5>
      <p class="card-text">����Ʈ �߰��� ������ ������</p>
      <p class="card-text"><small class="text-muted">������¥</small></p>
    </div>
  </div>
  <div class="card">
    <img src="${pageContext.request.contextPath }/static/fav/images/jeju.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">���ֿ���</h5>
      <p class="card-text">����Ʈ �߰��� ������ ������</p>
      <p class="card-text"><small class="text-muted">������¥</small></p>
    </div>
  </div>
</div>

<script src="/static/fav/js/bootstrap.min.js"></script>
<script src="/static/loginForm/js/jquery.min.js"></script>
</body>
</html>