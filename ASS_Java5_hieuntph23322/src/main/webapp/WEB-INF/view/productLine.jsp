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
    <div><h1>DÒNG SẢN PHẨM</h1></div>
</div>
<div class="container">
    <form:form action="/dong-san-pham/add" method="post" modelAttribute="pro">
        <br/>
        Code:<form:input path="code" class="form-control" value="${proLine.code}"/>
        <form:errors path="code" cssStyle="color: red"/>
        <br/>
        Name:<form:input path="name" class="form-control" value="${proLine.name}"/>
        <form:errors path="name" cssStyle="color: red"/>
        <br/>
        ImportPrice:<form:input path="importPrice" class="form-control" value="${proLine.importPrice}"/>
        <form:errors path="importPrice" cssStyle="color: red"/>
        <br>
        Price:<form:input path="price" class="form-control" value="${proLine.price}"/>
        <form:errors path="price" cssStyle="color: red"/>
        <br>
        Manufacturer: <form:select path="manufacturer" class="form-select">
        <form:option value="${proLine.manufacturer.id}"/>
        <c:forEach items="${manu}" var="manu">
            <form:option value="${manu.id}">${manu.id} - ${manu.nameManufacturer}</form:option>
        </c:forEach>
    </form:select>
        <br/>
        Status:<form:radiobutton path="status" value="0" checked="${proLine.status ==0 ? 'checked':''} || 'true'"
                                 class="form-check-input"/>Online
        <form:radiobutton path="status" value="1" checked="${proLine.status == 1 ? 'checked':''}"
                          class="form-check-input"/>Offline
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
        <th scope="col">ImportPrice</th>
        <th scope="col">Price</th>
        <th scope="col">DateCreate</th>
        <th scope="col">DateCorrect</th>
        <th scope="col">Manufacturer</th>
        <th scope="col">Status</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${product}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.code}</td>
            <td>${product.name}</td>
            <td>${product.importPrice}</td>
            <td>${product.price}</td>
            <td>${product.dateCreate}</td>
            <td>${product.dateCorrect}</td>
            <td>${product.manufacturer.id}</td>
            <td>${product.status}</td>
            <td>
                <a href="/dong-san-pham/remove/${product.id}" type="button"
                   class="btn btn-danger" onclick="return confirmSubmit()">Delete</a>
                <a href="/dong-san-pham/detail/${product.id}" type="button"
                   class="btn btn-warning">Detail</a>
                <a href="/dong-san-pham/view-update/${product.id}" type="button" class="btn btn-warning">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:if test="${productPage.number - 1 >= 0}">
            <li class="page-item">
                <a class="page-link"
                   href="/dong-san-pham/hien-thi?pageNo=${productPage.number - 1}">Previous</a>
            </li>
        </c:if>
        <c:if test="${productPage.number - 1 < 0}">
            <li class="page-item disabled"><span class="page-link">Previous</span></li>
        </c:if>
        <c:forEach begin="0" end="${productPage.totalPages - 1}" varStatus="page">
            <li class="page-item">
                <a class="page-link"
                   href="/dong-san-pham/hien-thi?pageNo=${page.index}">${page.index+1}
                </a>
            </li>
        </c:forEach>
        <c:if test="${productPage.number + 1 <= productPage.totalPages - 1}">
            <li class="page-item">
                <a class="page-link"
                   href="/dong-san-pham/hien-thi?pageNo=${productPage.number + 1}">Next
                </a>
            </li>
        </c:if>
        <c:if test="${productPage.number + 1 > productPage.totalPages - 1}">
            <li class="page-item disabled"><span class="page-link">Next</span></li>
        </c:if>
    </ul>
</nav>
<div class="container">
    <a href="/hang-san-pham/hien-thi" type="button"
       class="btn btn-warning">Manufacturer</a>

</div>
<%@include file="layout/footer.jsp" %>
</body>
</html>