<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<link rel="stylesheet" href="/static/fav/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>
<h3>���￩��</h3>
<div class="card mb-3" style="max-width: 800px;">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="${pageContext.request.contextPath }/static/fav/images/sig.jpg" class="img-fluid rounded-start" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
      <div  style="float: right;" class="btn-group">
  <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
    �����޴�
  </button>
  <ul class="dropdown-menu">
    <li><a class="dropdown-item" href="#">ȣ����������</a></li>
    <li><a class="dropdown-item" href="#">����</a></li>
    <li><a class="dropdown-item" href="#">����Ʈ���� ����</a></li>
  </ul>
</div>
        <h5 class="card-title"><a href="">�Ե� �ñ״Ͽ�</a></h5>
        
        <p class="card-text">���� ����, �ο�, ���� Ȯ�� ����</p>
      </div>
    </div>
  </div>
</div>
<div class="card mb-3" style="max-width: 800px;">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="${pageContext.request.contextPath }/static/fav/images/sinra.jpg" class="img-fluid rounded-start" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
      <div  style="float: right;" class="btn-group">
  <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
    �����޴�
  </button>
  <ul class="dropdown-menu">
    <li><a class="dropdown-item" href="#">ȣ����������</a></li>
    <li><a class="dropdown-item" href="#">�� ȣ�� ����</a></li>
    <li><a class="dropdown-item" href="#">����Ʈ���� ����</a></li>
  </ul>
</div>
        <h5 class="card-title"><a href="">�Ŷ� ȣ��</a></h5>
        <p class="card-text">���� ����, �ο�, ���� Ȯ�� ����</p>
      </div>
    </div>
  </div>
</div>
<div class="d-grid gap-2 col-7">
  <button class="btn btn-primary" type="button">����</button>
</div>

<script src="/static/fav/js/bootstrap.min.js"></script>
<script src="/static/fav/js/bootstrap.bundle.min.js"></script>
<script src="/static/loginForm/js/jquery.min.js"></script>
</body>
</html>