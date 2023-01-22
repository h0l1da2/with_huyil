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

<!-- 리뷰작성 모달 -->
<div class="modal fade" id="reviewModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered ">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">리뷰 작성</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form class="row g-3">
        <div class="col-md-6">
    <label for="inputEmail4" class="form-label">아이디</label>
    <input type="email" class="form-control" id="inputEmail4">
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label">비밀번호</label>
    <input type="password" class="form-control" id="inputPassword4">
  </div>
  
  <div class="row g-3">
  <strong>별점</strong>
  <select class="form-select form-select-sm" aria-label=".form-select-sm example">
  <option selected>청결상태</option>
  <option value="1">1점</option>
  <option value="2">2점</option>
  <option value="3">3점</option>
  <option value="4">4점</option>
  <option value="5">5점</option>
</select>
 <select class="form-select form-select-sm" aria-label=".form-select-sm example">
  <option selected>직원/서비스</option>
  <option value="1">1점</option>
  <option value="2">2점</option>
  <option value="3">3점</option>
  <option value="4">4점</option>
  <option value="5">5점</option>
</select>
 <select class="form-select form-select-sm" aria-label=".form-select-sm example">
  <option selected>편의시설</option>
  <option value="1">1점</option>
  <option value="2">2점</option>
  <option value="3">3점</option>
  <option value="4">4점</option>
  <option value="5">5점</option>
</select>
 <select class="form-select form-select-sm" aria-label=".form-select-sm example">
  <option selected>시설상태</option>
  <option value="1">1점</option>
  <option value="2">2점</option>
  <option value="3">3점</option>
  <option value="4">4점</option>
  <option value="5">5점</option>
</select>
 <select class="form-select form-select-sm" aria-label=".form-select-sm example">
  <option selected>친환경</option>
  <option value="1">1점</option>
  <option value="2">2점</option>
  <option value="3">3점</option>
  <option value="4">4점</option>
  <option value="5">5점</option>
</select>
</div>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">리뷰 제목</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="mb-3">
            <label for="message-text" class="col-form-label">내용</label>
            <textarea class="form-control" id="message-text"></textarea>
            <div class="input-group">
  <input type="file" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
</div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
        <button type="button" class="btn btn-primary">작성</button>
      </div>
    </div>
  </div>
</div>

<!-- 이미지 클릭시 확대 모달 -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">리뷰제목</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body" >
         <img src="${pageContext.request.contextPath }/static/fav/images/room1.jpg" class="img-fluid rounded-start" alt="..." >
      </div>
    </div>
  </div>
</div>

<!-- 대댓글(호스트) 작성 모달 -->
<div class="modal fade" id="hostReviewModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered ">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">리뷰 작성</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form class="row g-3">
        <div class="col-md-6">
    <label for="inputEmail4" class="form-label">아이디</label>
    <input type="email" class="form-control" id="inputEmail4">
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label">비밀번호</label>
    <input type="password" class="form-control" id="inputPassword4">
  </div>
          <div class="mb-3">
            <label for="message-text" class="col-form-label">내용</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
        <button type="button" class="btn btn-primary">작성</button>
      </div>
    </div>
  </div>
</div>

<!-- 삭제 모달 -->
<div class="modal" id="deleteModal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title"><strong>리뷰 삭제</strong></h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>정말 삭제하시겠습니까?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
        <button type="button" class="btn btn-primary">삭제한다</button>
      </div>
    </div>
  </div>
</div>

<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#reviewModal" data-bs-whatever="@mdo" style="display:inline;">리뷰 작성</button>
<nav>
<h2>4.7/5</h2>
<h5>훌륭해요!</h5>
<a>755개 실제 고객 이용 후기</a><br><br>
5-훌륭해요
<div class="progress">
  <div class="progress-bar" role="progressbar" aria-label="Example with label" style="width: 70%;" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100">70%</div>
</div>
4-좋아요
<div class="progress">
  <div class="progress-bar" role="progressbar" aria-label="Example with label" style="width: 15%;" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100">15%</div>
</div>
3-괜찮아요
<div class="progress">
  <div class="progress-bar" role="progressbar" aria-label="Example with label" style="width: 10%;" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100">10%</div>
</div>
2-별로예요
<div class="progress">
  <div class="progress-bar" role="progressbar" aria-label="Example with label" style="width: 5%;" aria-valuenow="5" aria-valuemin="0" aria-valuemax="100">5%</div>
</div>
1-너무 별로예요
<div class="progress">
  <div class="progress-bar" role="progressbar" aria-label="Example with label" style="width: 0%;" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100">0%</div>
</div>
<br>
<table>
<tr>
<td><h4>4.8/5</h4>청결상태</td>
<td><h4>4.8/5</h4>직원/서비스</td>
</tr>
<tr>
<td><h4>4.6/5</h4>편의시설</td>
<td><h4>4.8/5</h4>시설상태</td>
</tr>
<tr>
<td><h4>4.6/5</h4>친환경</td>
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
        <h5 class="card-title" style="display:inline;">5/5 - 리뷰제목</h5>
        <p class="card-text"><strong>작성자<br>숙박일자</strong></p>
        <p class="card-text">리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용</p>
        <a class="card-text"><small class="text-muted">리뷰작성날짜</small></a>
        <span>
        <img src="${pageContext.request.contextPath }/static/fav/images/likes.svg" alt="..." width="22" height="22"> count
        <!-- 좋아요 누를시 색채워진 아이콘으로 변경되게 -->
        </span>
        <span>
        <img src="${pageContext.request.contextPath }/static/fav/images/reply.svg" alt="..." width="22" height="22" data-bs-toggle="modal" data-bs-target="#hostReviewModal">
        </span> 
        <span>
        <img src="${pageContext.request.contextPath }/static/fav/images/trash.svg" alt="..." width="22" height="22" data-bs-toggle="modal" data-bs-target="#deleteModal">
        <!-- 아이콘 위에 마우스갖다대면 손모양으로 바뀌게 -->
        </span>
      </div>
    </div>
  </div>
</div>
 <div class="card mb-3" style="max-width: 440px;">
      <div class="card-body">
     
        <h5 class="card-title">Re:상위리뷰의제목</h5>
        
        <p class="card-text">리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용</p>
        <a class="card-text"><small class="text-muted">리뷰작성날짜</small></a>
        <span> <img src="${pageContext.request.contextPath }/static/fav/images/trash.svg" alt="..." width="22" height="22" data-bs-toggle="modal" data-bs-target="#deleteModal"></span>
        </div>
    </div>

</section>

<script src="/static/fav/js/bootstrap.min.js"></script>
<script src="/static/fav/js/bootstrap.bundle.min.js"></script>
<script src="/static/loginForm/js/jquery.min.js"></script>
</body>
</html>