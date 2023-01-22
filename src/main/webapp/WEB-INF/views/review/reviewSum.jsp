<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/static/fav/css/bootstrap.min.css">
<title>Insert title here</title>
<style>
nav{
width:350px;
height:1000px;
float:left;
padding:15px;
}
section{
width:800px;
float:left;
padding:80px;
}
td {
padding:7px;
}
span {
padding:1px 2px 3px 20px;
}
</style>
</head>
<body>
<br>

<!-- �����ۼ� ��� -->
<div class="modal fade" id="reviewModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered ">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">���� �ۼ�</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form class="row g-3">
        <div class="col-md-6">
    <label for="inputEmail4" class="form-label">���̵�</label>
    <input type="email" class="form-control" id="inputEmail4">
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label">��й�ȣ</label>
    <input type="password" class="form-control" id="inputPassword4">
  </div>
  
  <div class="row g-3">
  <strong>����</strong>
  <select class="form-select form-select-sm" aria-label=".form-select-sm example">
  <option selected>û�����</option>
  <option value="1">1��</option>
  <option value="2">2��</option>
  <option value="3">3��</option>
  <option value="4">4��</option>
  <option value="5">5��</option>
</select>
 <select class="form-select form-select-sm" aria-label=".form-select-sm example">
  <option selected>����/����</option>
  <option value="1">1��</option>
  <option value="2">2��</option>
  <option value="3">3��</option>
  <option value="4">4��</option>
  <option value="5">5��</option>
</select>
 <select class="form-select form-select-sm" aria-label=".form-select-sm example">
  <option selected>���ǽü�</option>
  <option value="1">1��</option>
  <option value="2">2��</option>
  <option value="3">3��</option>
  <option value="4">4��</option>
  <option value="5">5��</option>
</select>
 <select class="form-select form-select-sm" aria-label=".form-select-sm example">
  <option selected>�ü�����</option>
  <option value="1">1��</option>
  <option value="2">2��</option>
  <option value="3">3��</option>
  <option value="4">4��</option>
  <option value="5">5��</option>
</select>
 <select class="form-select form-select-sm" aria-label=".form-select-sm example">
  <option selected>ģȯ��</option>
  <option value="1">1��</option>
  <option value="2">2��</option>
  <option value="3">3��</option>
  <option value="4">4��</option>
  <option value="5">5��</option>
</select>
</div>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">���� ����</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="mb-3">
            <label for="message-text" class="col-form-label">����</label>
            <textarea class="form-control" id="message-text"></textarea>
            <div class="input-group">
  <input type="file" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
</div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">���</button>
        <button type="button" class="btn btn-primary">�ۼ�</button>
      </div>
    </div>
  </div>
</div>

<!-- �̹��� Ŭ���� Ȯ�� ��� -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">��������</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body" >
         <img src="${pageContext.request.contextPath }/static/fav/images/room1.jpg" class="img-fluid rounded-start" alt="..." >
      </div>
    </div>
  </div>
</div>

<!-- ����(ȣ��Ʈ) �ۼ� ��� -->
<div class="modal fade" id="hostReviewModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered ">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">���� �ۼ�</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form class="row g-3">
        <div class="col-md-6">
    <label for="inputEmail4" class="form-label">���̵�</label>
    <input type="email" class="form-control" id="inputEmail4">
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label">��й�ȣ</label>
    <input type="password" class="form-control" id="inputPassword4">
  </div>
          <div class="mb-3">
            <label for="message-text" class="col-form-label">����</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">���</button>
        <button type="button" class="btn btn-primary">�ۼ�</button>
      </div>
    </div>
  </div>
</div>

<!-- ���� ��� -->
<div class="modal" id="deleteModal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><strong>���� ����</strong></h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>���� �����Ͻðڽ��ϱ�?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">���</button>
        <button type="button" class="btn btn-primary">�����Ѵ�</button>
      </div>
    </div>
  </div>
</div>

<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#reviewModal" data-bs-whatever="@mdo" style="display:inline;">���� �ۼ�</button>
<nav>
<h2>4.7/5</h2>
<h5>�Ǹ��ؿ�!</h5>
<a>755�� ���� �� �̿� �ı�</a><br><br>
5-�Ǹ��ؿ�
<div class="progress">
  <div class="progress-bar" role="progressbar" aria-label="Example with label" style="width: 70%;" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100">70%</div>
</div>
4-���ƿ�
<div class="progress">
  <div class="progress-bar" role="progressbar" aria-label="Example with label" style="width: 15%;" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100">15%</div>
</div>
3-�����ƿ�
<div class="progress">
  <div class="progress-bar" role="progressbar" aria-label="Example with label" style="width: 10%;" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100">10%</div>
</div>
2-���ο���
<div class="progress">
  <div class="progress-bar" role="progressbar" aria-label="Example with label" style="width: 5%;" aria-valuenow="5" aria-valuemin="0" aria-valuemax="100">5%</div>
</div>
1-�ʹ� ���ο���
<div class="progress">
  <div class="progress-bar" role="progressbar" aria-label="Example with label" style="width: 0%;" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100">0%</div>
</div>
<br>
<table>
<tr>
<td><h4>4.8/5</h4>û�����</td>
<td><h4>4.8/5</h4>����/����</td>
</tr>
<tr>
<td><h4>4.6/5</h4>���ǽü�</td>
<td><h4>4.8/5</h4>�ü�����</td>
</tr>
<tr>
<td><h4>4.6/5</h4>ģȯ��</td>
</tr>
</table>
</nav>
<section>
<div class="card mb-3" style="max-width: 540px;">
  <div class="row g-0">
    <div class="col-md-4" style=" display: flex; justify-content: center; align-items: center;" >
      <img src="${pageContext.request.contextPath }/static/fav/images/room1.jpg" class="img-fluid rounded-start" alt="..." data-bs-toggle="modal" data-bs-target="#exampleModal" style="margin-left:10px;">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title" style="display:inline;">5/5 - ��������</h5>
        <p class="card-text"><strong>�ۼ���<br>��������</strong></p>
        <p class="card-text">���䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻��</p>
        <a class="card-text"><small class="text-muted">�����ۼ���¥</small></a>
        <span>
        <img src="${pageContext.request.contextPath }/static/fav/images/likes.svg" alt="..." width="22" height="22"> count
        <!-- ���ƿ� ������ ��ä���� ���������� ����ǰ� -->
        </span>
        <span>
        <img src="${pageContext.request.contextPath }/static/fav/images/reply.svg" alt="..." width="22" height="22" data-bs-toggle="modal" data-bs-target="#hostReviewModal">
        </span> 
        <span>
        <img src="${pageContext.request.contextPath }/static/fav/images/trash.svg" alt="..." width="22" height="22" data-bs-toggle="modal" data-bs-target="#deleteModal">
        <!-- ������ ���� ���콺���ٴ�� �ո������ �ٲ�� -->
        </span>
      </div>
    </div>
  </div>
</div>
 <div class="card mb-3" style="max-width: 440px;">
      <div class="card-body">
     
        <h5 class="card-title">Re:��������������</h5>
        
        <p class="card-text">���䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻�븮�䳻��</p>
        <a class="card-text"><small class="text-muted">�����ۼ���¥</small></a>
        <span> <img src="${pageContext.request.contextPath }/static/fav/images/trash.svg" alt="..." width="22" height="22" data-bs-toggle="modal" data-bs-target="#deleteModal"></span>
        </div>
    </div>

</section>

<script src="/static/fav/js/bootstrap.min.js"></script>
<script src="/static/fav/js/bootstrap.bundle.min.js"></script>
<script src="/static/loginForm/js/jquery.min.js"></script>
</body>
</html>