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
<h3>ȣ���̸�</h3>
<textarea rows="10" cols="30">ȣ�ڳ���</textarea><br>
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">�� ���� �߰�</button>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered ">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">�� ���� ����Ʈ�� �߰�</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">���� ����</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="mb-3">
            <label for="message-text" class="col-form-label">����</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">���</button>
        <button type="button" class="btn btn-primary">�߰�</button>
        <!-- �߰� ��ư Ŭ���� �˸�â �߰� �����(�ڹٽ�ũ��Ʈ�̿�) -->
      </div>
    </div>
  </div>
</div>

<script src="/static/fav/js/bootstrap.min.js"></script>
<script src="/static/fav/js/bootstrap.bundle.min.js"></script>
<script src="/static/loginForm/js/jquery.min.js"></script>
</body>
</html>