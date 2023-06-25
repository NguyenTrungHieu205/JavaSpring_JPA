<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"/>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<script>
    function confirmSubmit() {
        alert("Thêm giỏ hàng thành công");
    }
</script>
<body>
<%@include file="layout/header.jsp" %>
<div class="container">
    <div class="row">
        <h1 id="title">Tất cả sản phẩm</h1>
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
                            <a href="/gio-hang/add-to-cart/${ctsp.id}" type="button" class="btn btn-success"
                               onclick="return confirmSubmit()">THÊM VÀO
                                GIỎ HÀNG</a>

                            <a href="/mua-ngay/xac-nhan/${ctsp.id}" type="button" class="btn btn-danger">MUA NGAY</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:if test="${chiTietSanPhamPage.number - 1 >= 0}">
                <li class="page-item">
                    <a class="page-link"
                       href="/view-chi-tiet-san-pham?pageNo=${chiTietSanPhamPage.number - 1}">Previous</a>
                </li>
            </c:if>
            <c:if test="${chiTietSanPhamPage.number - 1 < 0}">
                <li class="page-item disabled"><span class="page-link">Previous</span></li>
            </c:if>
            <c:forEach begin="0" end="${chiTietSanPhamPage.totalPages - 1}" varStatus="page">
                <li class="page-item">
                    <a class="page-link"
                       href="/view-chi-tiet-san-pham?pageNo=${page.index}">${page.index+1}
                    </a>
                </li>
            </c:forEach>
            <c:if test="${chiTietSanPhamPage.number + 1 <= chiTietSanPhamPage.totalPages - 1}">
                <li class="page-item">
                    <a class="page-link"
                       href="/view-chi-tiet-san-pham?pageNo=${chiTietSanPhamPage.number + 1}">Next
                    </a>
                </li>
            </c:if>
            <c:if test="${chiTietSanPhamPage.number + 1 > chiTietSanPhamPage.totalPages - 1}">
                <li class="page-item disabled"><span class="page-link">Next</span></li>
            </c:if>
        </ul>
    </nav>
</div>
<%@include file="layout/footer.jsp" %>
</body>
</html>
