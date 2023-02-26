<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>위드휴일 - 사업자회원관리</title>

  <!-- Custom fonts for this template -->
  <link href="/resources/static/management/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/static/management/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="/resources/static/management/css/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<!-- Page Wrapper -->
<div id="wrapper">

  <!-- Sidebar -->
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/admin">
      <div class="sidebar-brand-icon rotate-n-15">
        <i class="fas fa-laugh-wink"></i>
      </div>
      <div class="sidebar-brand-text mx-3">위드휴일 <sup>ADMIN</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
      <a class="nav-link" href="/admin">
        <i class="fas fa-fw fa-tachometer-alt"></i>
        <span>관리자페이지</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
      회원관리
    </div>
    <li class="nav-item">
      <a class="nav-link" href="/admin/userList">
        <i class="fas fa-fw fa-table"></i>
        <span>일반회원관리</span></a>
    </li>

    <li class="nav-item">
      <a class="nav-link" href="/admin/hostList">
        <i class="fas fa-fw fa-table"></i>
        <span>사업자회원관리</span></a>
    </li>

    <!-- Heading -->
    <div class="sidebar-heading">
      예약관리
    </div>
    <li class="nav-item">
      <a class="nav-link" href="/admin/bookList">
        <i class="fas fa-fw fa-table"></i>
        <span>예약목록</span></a>
    </li>

    <!-- Heading -->
    <div class="sidebar-heading">
      매출관리
    </div>
    <li class="nav-item">
      <a class="nav-link" id="noComplete">
        <i class="fas fa-fw fa-table"></i>
        <span>매출내역확인</span></a>
    </li>



    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
      <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

  </ul>
  <!-- End of Sidebar -->

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">

      <!-- Topbar -->
      <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <form class="form-inline">
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>
        </form>

        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">

          <!-- Nav Item - Search Dropdown (Visible Only XS) -->
          <li class="nav-item dropdown no-arrow d-sm-none">
            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-search fa-fw"></i>
            </a>
            <!-- Dropdown - Messages -->
            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                 aria-labelledby="searchDropdown">
              <form class="form-inline mr-auto w-100 navbar-search">
                <div class="input-group">
                  <input type="text" class="form-control bg-light border-0 small"
                         placeholder="Search for..." aria-label="Search"
                         aria-describedby="basic-addon2">
                  <div class="input-group-append">
                    <button class="btn btn-primary" type="button">
                      <i class="fas fa-search fa-sm"></i>
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </li>


          <div class="topbar-divider d-none d-sm-block"></div>

          <!-- Nav Item - User Information -->
          <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="mr-2 d-none d-lg-inline text-gray-600 small">${userId}</span>
            </a>
          </li>

        </ul>

      </nav>
      <!-- End of Topbar -->

      <!-- Begin Page Content -->
      <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">사업자 회원 </h1>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
          <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">호스트 목록</h6>
          </div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" width="100%" cellspacing="0">
                <thead>
                <tr>
                  <th>id</th>
                  <th>아이디</th>
                  <th>이름</th>
                  <th>이메일</th>
                  <th>전화번호</th>
                  <th>사업자번호</th>
                  <th>가입일</th>
                  <th>마지막 로그인</th>
                  <th>상태</th>
                  <th>정지</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="userList" items="${adminUserListDtoList}">
                  <tr>
                    <td>${userList.id}</td>
                    <td>${userList.userId}</td>
                    <td>${userList.name}</td>
                    <td>${userList.email}</td>
                    <td>${userList.tel}</td>
                    <td>${userList.account}</td>
                    <td>${userList.joinDate}</td>
                    <td>${userList.lastLogin}</td>
                    <td>${userList.out}</td>
                    <td>
                      <button type="button" class="btn btn-primary" onclick="stopCancel('${userList.userId}')" <c:if test="${userList.out eq 'STOP'}">hidden</c:if>>정지</button>
                    </td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>
            <c:if test="${ph.showPrev}"><a href="<c:url value="/admin/hostList${ph.getPageInfo(ph.beginPage-1)}"/>">&lt;</a></c:if>
            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
              <a href="<c:url value="/admin/hostList${ph.getPageInfo(i)}"/>" <c:if test="${ph.viewPage eq i}"> class="active"</c:if>>${i}</a>
            </c:forEach>
            <c:if test="${ph.showNext}"><a href="<c:url value="/admin/hostList${ph.getPageInfo(ph.endPage+1)}"/>">&gt;</a></c:if>
          </div>
        </div>

      </div>
      <!-- /.container-fluid -->

    </div>
    <!-- End of Main Content -->

    <!-- Footer -->
    <footer class="sticky-footer bg-white">
      <div class="container my-auto">
        <div class="copyright text-center my-auto">
          <span>위 드 휴 일</span>
        </div>
      </div>
    </footer>
    <!-- End of Footer -->


  </div>
  <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
  <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">로그아웃하시겠습니까?</h5>
        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="modal-body">로그아웃하실경우 "Logout" 버튼을 클릭해주세요.</div>
      <div class="modal-footer">
        <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
        <a class="btn btn-primary" href="/logout">로그아웃</a>
      </div>
    </div>
  </div>
</div>

    <!-- Bootstrap core JavaScript-->
    <script src="/resources/static/management/js/jquery.min.js"></script>
    <script src="/resources/static/management/js/bootstrap/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/static/management/js/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
   <script src="/resources/static/management/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/resources/static/management/js/jquery.dataTables.min.js"></script>
    <script src="/resources/static/management/js/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/resources/static/management/js/demo/datatables-demo.js"></script>
<script>
  $(document).ready(function() {
    $('#noComplete').click(function () {
      alert("준비 중입니다");
      return false;
    });
  })
  function stopCancel(result) {
    if (!confirm("회원을 정지시킵니까?")) {
      return false;
    }

    $.ajax({
      type: 'POST',
      url: '/admin/stopUsers',
      contentType: "application/json",
      data: JSON.stringify({userId: result}),
      dataType: 'text',
      success: function (result) {
        if (result == '정지 완료') {
          alert("정지 완료")
          location.reload();
        } else {
          alert(result);
        }
      },
      error: function (result) {
        alert("확인실패");
      }
    })
  }
</script>
</body>

</html>