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
<script>
    function confirmSubmit() {
        var result = true;
        if ($('.error').length > 0) {
            alert("Vui lòng kiểm tra thông tin");
            result = false;
        } else {
            result = confirm("Bạn có chắc chắn không?");
        }
        return result;
    }
</script>
<body>
<%@include file="layout/header.jsp" %>
<a href="/trang-cua-toi" type="button" class="btn btn-success"><<<</a>
<div class="container text-center">
    <br/>
    <div><h1>PHÂN LOẠI HÀNG</h1></div>
</div>
<div class="container">
    <form:form action="/phan-loai-hang/add" method="post" modelAttribute="phanHang">
        <br/>
        Code:<form:input path="code" class="form-control" value="${PHL.code}"/>
        <form:errors path="code" cssStyle="color: red"/>
        <br/>
        Name:<form:input path="name" class="form-control" value="${PHL.name}"/>
        <form:errors path="name" cssStyle="color: red"/>
        <br/>
        Color: <form:select path="color" class="form-select">
        <form:option value="${PHL.color.id}">${PHL.color.name}</form:option>
        <c:forEach items="${color}" var="co">
            <form:option value="${co.id}">${co.id} - ${co.name}</form:option>
        </c:forEach>
    </form:select>
        <br/>
        Capacity: <form:select path="capacity" class="form-select">
        <form:option value="${PHL.capacity.id}">${PHL.capacity.name}</form:option>
        <c:forEach items="${capacity}" var="ca">
            <form:option value="${ca.id}">${ca.id} - ${ca.name}</form:option>
        </c:forEach>
    </form:select>
        <br/>
        ProductLine: <form:select path="productLine" class="form-select">
        <form:option value="${PHL.productLine.id}"/>
        <c:forEach items="${productLine}" var="productLine">
            <form:option value="${productLine.id}">${productLine.id} - ${productLine.name}</form:option>
        </c:forEach>
    </form:select>
        <br/>
        Status:
        <br/>
        <form:radiobutton path="status" value="0" checked="${PHL.status ==0 ? 'checked':''} || 'true'"
                          class="form-check-input"/>Online
        <form:radiobutton path="status" value="1" checked="${PHL.status ==1 ? 'checked':''}" class="form-check-input"/>Offline
        <br>
        <form:button type="submit" class="btn btn-info" onclick="return confirmSubmit()">ADD</form:button>
        <br/>
    </form:form>
</div>
<table class="table table-dark table-striped-columns">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Code</th>
        <th scope="col">Name</th>
        <th scope="col">Color</th>
        <th scope="col">Capacity</th>
        <th scope="col">ProductLine</th>
        <th scope="col">Status</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${phanLoai}" var="phanLoai">
        <tr>
            <td>${phanLoai.id}</td>
            <td>${phanLoai.code}</td>
            <td>${phanLoai.name}</td>
            <td>${phanLoai.color.id} - ${phanLoai.color.name}</td>
            <td>${phanLoai.capacity.id} - ${phanLoai.capacity.name}</td>
            <td>${phanLoai.productLine.id} - ${phanLoai.productLine.name}</td>
            <c:if test="${phanLoai.status == 0}">
                <td>Online</td>
            </c:if>
            <c:if test="${phanLoai.status == 1}">
                <td>Offline</td>
            </c:if>
            <td>
                <a href="/phan-loai-hang/remove/${phanLoai.id}" type="button"
                   class="btn btn-danger" onclick="return  confirmSubmit()">Delete</a>
                <a href="/phan-loai-hang/detail/${phanLoai.id}" type="button"
                   class="btn btn-warning">Detail</a>
                <a href="/phan-loai-hang/view-update/${phanLoai.id}" type="button" class="btn btn-warning">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:if test="${phanLoaiPage.number - 1 >= 0}">
            <li class="page-item">
                <a class="page-link"
                   href="/phan-loai-hang/hien-thi?pageNo=${phanLoaiPage.number - 1}">Previous</a>
            </li>
        </c:if>
        <c:if test="${phanLoaiPage.number - 1 < 0}">
            <li class="page-item disabled"><span class="page-link">Previous</span></li>
        </c:if>
        <c:forEach begin="0" end="${phanLoaiPage.totalPages - 1}" varStatus="page">
            <li class="page-item">
                <a class="page-link"
                   href="/phan-loai-hang/hien-thi?pageNo=${page.index}">${page.index+1}
                </a>
            </li>
        </c:forEach>
        <c:if test="${phanLoaiPage.number + 1 <= phanLoaiPage.totalPages - 1}">
            <li class="page-item">
                <a class="page-link"
                   href="/phan-loai-hang/hien-thi?pageNo=${phanLoaiPage.number + 1}">Next
                </a>
            </li>
        </c:if>
        <c:if test="${phanLoaiPage.number + 1 > phanLoaiPage.totalPages - 1}">
            <li class="page-item disabled"><span class="page-link">Next</span></li>
        </c:if>
    </ul>
</nav>
<div class="container">
    <a href="/mau-sac/hien-thi" type="button"
       class="btn btn-warning">Color</a>
    <a href="/dung-luong/hien-thi" type="button"
       class="btn btn-warning">Capacity</a>
    <a href="/dong-san-pham/hien-thi" type="button"
       class="btn btn-warning">Product Line</a>
</div>
<%@include file="layout/footer.jsp" %>
</body>
</html>