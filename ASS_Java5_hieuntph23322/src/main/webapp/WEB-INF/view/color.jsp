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
    <div><h1>MÀU SẮC</h1></div>
</div>
<div class="container">
    <form:form action="/mau-sac/add" method="post" modelAttribute="col">
        <br/>
        Code:<form:input path="code" class="form-control" value="${sac.code}"/>
        <form:errors path="code" cssStyle="color: red"/>
        <br/>
        Name:<form:input path="name" class="form-control" value="${sac.name}"/>
        <form:errors path="name" cssStyle="color: red"/>
        <br/>
        Status:<form:radiobutton path="status" value="0" checked="${sac.status ==0 ? 'checked':''} || 'true'"
                                 class="form-check-input"/>Online
        <form:radiobutton path="status" value="1" checked="${sac.status ==1 ? 'checked':''}" class="form-check-input"/>Offline
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
        <th scope="col">Date_Create</th>
        <th scope="col">Date_Correct</th>
        <th scope="col">Status</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${color}" var="color">
        <tr>
            <td>${color.id}</td>
            <td>${color.code}</td>
            <td>${color.name}</td>
            <td>${color.dateCreate}</td>
            <td>${color.dateCorrect}</td>
            <c:if test="${color.status == 0}">
                <td>Online</td>
            </c:if>
            <c:if test="${color.status == 1}">
                <td>Offline</td>
            </c:if>
            <td>
                <a href="/mau-sac/remove/${color.id}" type="button"
                   class="btn btn-danger" onclick="return  confirmSubmit()">Delete</a>
                <a href="/mau-sac/detail/${color.id}" type="button"
                   class="btn btn-warning">Detail</a>
                <a href="/mau-sac/view-update/${color.id}" type="button" class="btn btn-warning">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:if test="${colorPage.number - 1 >= 0}">
            <li class="page-item">
                <a class="page-link"
                   href="/mau-sac/hien-thi?pageNo=${colorPage.number - 1}">Previous</a>
            </li>
        </c:if>
        <c:if test="${colorPage.number - 1 < 0}">
            <li class="page-item disabled"><span class="page-link">Previous</span></li>
        </c:if>
        <c:forEach begin="0" end="${colorPage.totalPages - 1}" varStatus="page">
            <li class="page-item">
                <a class="page-link"
                   href="/mau-sac/hien-thi?pageNo=${page.index}">${page.index+1}
                </a>
            </li>
        </c:forEach>
        <c:if test="${colorPage.number + 1 <= colorPage.totalPages - 1}">
            <li class="page-item">
                <a class="page-link"
                   href="/mau-sac/hien-thi?pageNo=${colorPage.number + 1}">Next
                </a>
            </li>
        </c:if>
        <c:if test="${colorPage.number + 1 > colorPage.totalPages - 1}">
            <li class="page-item disabled"><span class="page-link">Next</span></li>
        </c:if>
    </ul>
</nav>
<%@include file="layout/footer.jsp" %>
</body>
</html>