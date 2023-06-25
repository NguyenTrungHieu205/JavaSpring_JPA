<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/21/2023
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="/css/header.css">
</head>
<body>
<div class="row">
    <div class="col-3">
        <h3 id="logo-wed">CellPhone H</h3>
    </div>
    <div class="col-5">
        <nav class="navbar navbar-expand-lg ">
            <div class="container-fluid">
                <ul class="navbar-nav">
                    <li class="nav-item" id="name-header">
                        <a class="nav-link active" aria-current="page" href="/trang-chu">Trang Chủ</a>
                    </li>
                    <li class="nav-item" id="name-header">
                        <a class="nav-link active" aria-current="page" href="/view-chi-tiet-san-pham">Sản Phẩm</a>
                    </li>
                    <li class="nav-item" id="name-header">
                        <a class="nav-link active" aria-current="page" href="">Giới Thiệu Cửa Hàng</a>
                    </li>
                    <li class="nav-item" id="name-header">
                        <a class="nav-link active" aria-current="page" href="">Sự Kiện</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="col-4" id="icon">
        <div class="row">
            <div class="col-4">
                <a href="/login"><p id="buttonDN">Đăng Nhập</p></a>
            </div>
            <div class="col-4">
                <a href="/trang-cua-toi"><p id="title">Trang của tôi</p></a>
            </div>
            <div class="col-4">
                <a href="/gio-hang/hien-thi">
                    <button type="button" class="btn btn-primary position-relative" id="giohang"
                            style="margin-top: 8px">

                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-cart"
                             viewBox="0 0 16 16">
                            <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                        </svg>
                        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                            ${myCartNum}
                        </span>
                    </button>
                </a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
