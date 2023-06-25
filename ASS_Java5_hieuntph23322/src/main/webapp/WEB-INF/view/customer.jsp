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
    <div><h1>KHÁCH HÀNG</h1></div>
</div>
<div class="container">
    <form:form action="/khach-hang/add" method="post" modelAttribute="KH">
        <%--        <br/>--%>
        <%--        Code:<form:input path="id" readonly="false" class="form-control" />--%>
        <br/>
        Code:<form:input path="code" class="form-control" value="${KhachHang.code}"/>
        <form:errors path="code" cssStyle="color: red"/>
        <br/>
        FullName:<form:input path="fullName" class="form-control" value="${KhachHang.fullName}"/>
        <form:errors path="fullName" cssStyle="color: red"/>
        <br/>
        Gender:<form:radiobutton path="gender" value="0" checked="${KhachHang.gender ==0 ? 'checked':''} || 'true'"
                                 class="form-check-input"/>Nam
        <form:radiobutton path="gender" value="1" checked="${KhachHang.gender ==1 ? 'checked':''}"
                          class="form-check-input"/>Nữ
        <br>
        PhoneNumber:<form:input path="phoneNumber" class="form-control" value="${KhachHang.phoneNumber}"/>
        <form:errors path="phoneNumber" cssStyle="color: red"/>
        <br>
        Address:<form:input path="adrress" class="form-control" value="${KhachHang.adrress}"/>
        <form:errors path="adrress" cssStyle="color: red"/>
        <br/>
        <form:button type="submit" class="btn btn-info" onclick="return confirmSubmit()">ADD</form:button>
        <br/>
    </form:form>
</div>
<table class="table table-dark table-striped-columns">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Code</th>
        <th scope="col">FullName</th>
        <th scope="col">Gender</th>
        <th scope="col">PhoneNumber</th>
        <th scope="col">Address</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${custumerGet}" var="cus">
        <tr>
            <td>${cus.id}</td>
            <td>${cus.code}</td>
            <td>${cus.fullName}</td>
            <td>${cus.gender}</td>
            <td>${cus.phoneNumber}</td>
            <td>${cus.adrress}</td>
            <td>
                <a href="/khach-hang/remove/${cus.id}" type="button"
                   class="btn btn-danger" onclick="return  confirmSubmit()">Delete</a>
                <a href="/khach-hang/detail/${cus.id}" type="button"
                   class="btn btn-warning">Detail</a>
                <a href="/khach-hang/view-update/${cus.id}" type="button" class="btn btn-warning">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:if test="${custumerGetPage.number - 1 >= 0}">
            <li class="page-item">
                <a class="page-link"
                   href="/khach-hang/hien-thi?pageNo=${custumerGetPage.number - 1}">Previous</a>
            </li>
        </c:if>
        <c:if test="${custumerGetPage.number - 1 < 0}">
            <li class="page-item disabled"><span class="page-link">Previous</span></li>
        </c:if>
        <c:forEach begin="0" end="${custumerGetPage.totalPages - 1}" varStatus="page">
            <li class="page-item">
                <a class="page-link"
                   href="/khach-hang/hien-thi?pageNo=${page.index}">${page.index+1}
                </a>
            </li>
        </c:forEach>
        <c:if test="${custumerGetPage.number + 1 <= custumerGetPage.totalPages - 1}">
            <li class="page-item">
                <a class="page-link"
                   href="/khach-hang/hien-thi?pageNo=${custumerGetPage.number + 1}">Next
                </a>
            </li>
        </c:if>
        <c:if test="${pageNhanVien.number + 1 > pageNhanVien.totalPages - 1}">
            <li class="page-item disabled"><span class="page-link">Next</span></li>
        </c:if>
    </ul>
</nav>
<%@include file="layout/footer.jsp" %>
</body>
</html>