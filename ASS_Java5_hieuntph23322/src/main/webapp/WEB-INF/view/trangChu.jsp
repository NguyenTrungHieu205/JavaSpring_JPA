<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/22/2023
  Time: 8:26 PM
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
    <link rel="stylesheet" href="/css/trangChu.css">
</head>
<body>
<%@include file="layout/header.jsp" %>
<div class="container">
    <div class="row" id="timKiem">

        <input
                class="form-control me-2"
                type="search"
                placeholder="Nhập vào đây...."
                aria-label="Search"
                ng-model="search"
        />
    </div>
    <br>
    <%--    <div class="row" id="banner">--%>
    <%--        <div id="carouselExample" class="carousel slide">--%>
    <%--            <div class="carousel-inner">--%>
    <%--                <div class="carousel-item active">--%>
    <img src="/assets/banner1.jpg" class="d-block w-100" alt="..."/>
    <%--                </div>--%>
    <%--                <div class="carousel-item">--%>
    <%--                    <img src="/assets/banner2.png" class="d-block w-100" alt="..." />--%>
    <%--                </div>--%>
    <%--                <div class="carousel-item">--%>
    <%--                    <img src="/assets/banner3.png" class="d-block w-100" alt="..." />--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--            <button--%>
    <%--                    class="carousel-control-prev"--%>
    <%--                    type="button"--%>
    <%--                    data-bs-target="#carouselExample"--%>
    <%--                    data-bs-slide="prev"--%>
    <%--            >--%>
    <%--                <span class="carousel-control-prev-icon" aria-hidden="true"></span>--%>
    <%--                <span class="visually-hidden">Previous</span>--%>
    <%--            </button>--%>
    <%--            <button--%>
    <%--                    class="carousel-control-next"--%>
    <%--                    type="button"--%>
    <%--                    data-bs-target="#carouselExample"--%>
    <%--                    data-bs-slide="next"--%>
    <%--            >--%>
    <%--                <span class="carousel-control-next-icon" aria-hidden="true"></span>--%>
    <%--                <span class="visually-hidden">Next</span>--%>
    <%--            </button>--%>
    <%--        </div>--%>

    <h3 id="tieude-dienthoai">MẪU ĐIỆN THOẠI BÁN CHẠY</h3>
    <hr id="duongKe"/>
    <!-- Crad sản phẩm -->
    <div class="row">
        <c:forEach items="${chiTietSanPham}" var="ctsp">
            <div class="col-4" id="cardSP" style="margin-top: 30px">
                <div class="card" style="border: none" id="card-SP">
                    <a href="/dentail/${ctsp.id}">
                        <img src="/assets/${ctsp.images}" style="width: 350px"/></a>
                    <div class="card-body">
                        <div class="row">
                            <p class="card-text" id="tenSP" name="tenSP">${ctsp.name} | Chính Hãng VNA</p>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <p class="card-text" id="giaSP">${ctsp.category.productLine.price} VNĐ</p>
                            </div>
                            <div class="col-6">
                                <img src="/assets/img10.gif" style="width: 100px"/>
                            </div>
                        </div>
                        <a href="/gio-hang/add-to-cart/${ctsp.id}" type="button" class="btn btn-success">THÊM VÀO
                            GIỎ HÀNG</a>

                        <a href="/mua-ngay/xac-nhan/${ctsp.id}" type="button" class="btn btn-danger">MUA NGAY</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:if test="${chiTietSanPhamPage.number - 1 >= 0}">
                <li class="page-item">
                    <a class="page-link"
                       href="/trang-chu?pageNo=${chiTietSanPhamPage.number - 1}">Previous</a>
                </li>
            </c:if>
            <c:if test="${chiTietSanPhamPage.number - 1 < 0}">
                <li class="page-item disabled"><span class="page-link">Previous</span></li>
            </c:if>
            <c:forEach begin="0" end="${chiTietSanPhamPage.totalPages - 1}" varStatus="page">
                <li class="page-item">
                    <a class="page-link"
                       href="/trang-chu?pageNo=${page.index}">${page.index+1}
                    </a>
                </li>
            </c:forEach>
            <c:if test="${chiTietSanPhamPage.number + 1 <= chiTietSanPhamPage.totalPages - 1}">
                <li class="page-item">
                    <a class="page-link"
                       href="/trang-chu?pageNo=${chiTietSanPhamPage.number + 1}">Next
                    </a>
                </li>
            </c:if>
            <c:if test="${chiTietSanPhamPage.number + 1 > chiTietSanPhamPage.totalPages - 1}">
                <li class="page-item disabled"><span class="page-link">Next</span></li>
            </c:if>
        </ul>
    </nav>

    <div class="row">
        <h4 id="tenqc">CHUYÊN TRANG THƯƠNG HIỆU</h4>
    </div>
    <div class="row">
        <div class="col-3">
            <img src="/assets/bn1.jpg" alt="" id="bn"/>
        </div>
        <div class="col-3">
            <img src="/assets/bn3.png" alt="" id="bn"/>
        </div>
        <div class="col-3">
            <img src="/assets/bn2.png" alt="" id="bn"/>
        </div>
        <div class="col-3">
            <img src="/assets/bn4.png" alt="" id="bn"/>
        </div>
    </div>
    <div class="row">
        <h4 id="tenqc">ƯU ĐÃI THANH TOÁN</h4>
    </div>
    <div class="row">
        <div class="col-3">
            <img src="/assets/thanhtoan1.jpg" alt="" id="bn"/>
        </div>
        <div class="col-3">
            <img src="/assets/thanhtoan2.jpg" alt="" id="bn"/>
        </div>
        <div class="col-3">
            <img src="/assets/thanhtoan3.jpg" alt="" id="bn"/>
        </div>
        <div class="col-3">
            <img src="/assets/thanhtoan4.png" alt="" id="bn"/>
        </div>
    </div>
</div>
</div>
<%@include file="layout/footer.jsp" %>
</body>
</html>
