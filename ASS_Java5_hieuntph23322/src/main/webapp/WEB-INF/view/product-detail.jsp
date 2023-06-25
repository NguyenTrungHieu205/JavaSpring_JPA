<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"/>
</head>
<%--<script>--%>
<%--    function confirmSubmit() {--%>
<%--        var result = true;--%>
<%--        if ($('.error').length > 0) {--%>
<%--            alert("Vui lòng kiểm tra thông tin");--%>
<%--            result = false;--%>
<%--        } else {--%>
<%--            result = confirm("Bạn có chắc chắn không?");--%>
<%--        }--%>
<%--        return result;--%>
<%--    }--%>
<%--</script>--%>
<body>
<%@include file="layout/header.jsp" %>
<a href="/trang-cua-toi" type="button" class="btn btn-success"><<<</a>
<div class="container text-center">
    <br/>
    <div><h1>CHI TIẾT SẢN PHẨM</h1></div>
</div>
<div class="container">
    <form action="/chi-tiet-san-pham/add" enctype="multipart/form-data" method="post">
        <div class="mb-3">
            <input type="text" placeholder="Code" class="form-control" name="code" value="${ProDetail.code}">
        </div>
        <div class="mb-3">
            <input type="text" placeholder="Name" class="form-control" name="name" value="${ProDetail.name}">
        </div>
        <label>Status</label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="status" value="0" id="flexRadioDefault1"
                   checked="${ProDetail.status == 0 ? 'checked':''}">
            <label class="form-check-label" for="flexRadioDefault1">
                Online
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="status" value="1" id="flexRadioDefault2"
                   checked="${ProDetail.status == 1 ? 'checked':''}">
            <label class="form-check-label" for="flexRadioDefault2">
                Offline
            </label>
        </div>
        <br>
        <div class="mb-3">
            <input type="text" placeholder="Number" class="form-control" name="number" value="${ProDetail.number}">
        </div>
        <label>Category</label>
        <select class="form-select" aria-label="Default select example" name="category">
            <option value="${ProDetail.category.id}">${ProDetail.category.name}</option>
            <c:forEach items="${category}" var="category">
                <option value="${category.id}">${category.id} - ${category.name}</option>
            </c:forEach>
        </select>
        <br>
        <div class="mb-3">
            <input type="file" class="form-control" name="images" value="${ProDetail.images}">
        </div>
        <button type="submit" class="btn btn-primary">ADD</button>
    </form>
</div>
<table class="table table-dark table-striped-columns">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Code</th>
        <th scope="col">Name</th>
        <th scope="col">Status</th>
        <th scope="col">Number</th>
        <th scope="col">Category</th>
        <th scope="col">Images</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productDetail}" var="productDetail">
        <tr>
            <td>${productDetail.id}</td>
            <td>${productDetail.code}</td>
            <td>${productDetail.name}</td>
            <c:if test="${productDetail.status == 0}">
                <td>Online</td>
            </c:if>
            <c:if test="${productDetail.status == 1}">
                <td>Offline</td>
            </c:if>
            <td>${productDetail.number}</td>
            <td>${productDetail.category.id} - ${productDetail.category.name}</td>
            <td><img src="/assets/${productDetail.images}" style="width: 100px"/></td>
            <td>
                <a href="/chi-tiet-san-pham/remove/${productDetail.id}" type="button"
                   class="btn btn-danger" onclick="return  confirmSubmit()">Delete</a>
                <a href="/chi-tiet-san-pham/detail/${productDetail.id}" type="button"
                   class="btn btn-warning">Detail</a>
                <a href="/chi-tiet-san-pham/view-update/${productDetail.id}" type="button"
                   class="btn btn-warning">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:if test="${productDetailPage.number - 1 >= 0}">
            <li class="page-item">
                <a class="page-link"
                   href="/chi-tiet-san-pham/hien-thi?pageNo=${productDetailPage.number - 1}">Previous</a>
            </li>
        </c:if>
        <c:if test="${productDetailPage.number - 1 < 0}">
            <li class="page-item disabled"><span class="page-link">Previous</span></li>
        </c:if>
        <c:forEach begin="0" end="${productDetailPage.totalPages - 1}" varStatus="page">
            <li class="page-item">
                <a class="page-link"
                   href="/chi-tiet-san-pham/hien-thi?pageNo=${page.index}">${page.index+1}
                </a>
            </li>
        </c:forEach>
        <c:if test="${productDetailPage.number + 1 <= productDetailPage.totalPages - 1}">
            <li class="page-item">
                <a class="page-link"
                   href="/chi-tiet-san-pham/hien-thi?pageNo=${productDetailPage.number + 1}">Next
                </a>
            </li>
        </c:if>
        <c:if test="${productDetailPage.number + 1 > productDetailPage.totalPages - 1}">
            <li class="page-item disabled"><span class="page-link">Next</span></li>
        </c:if>
    </ul>
</nav>
<div class="container">
    <a href="/phan-loai-hang/hien-thi" type="button"
       class="btn btn-warning">Category</a>
</div>
<%@include file="layout/footer.jsp" %>
</body>
</html>