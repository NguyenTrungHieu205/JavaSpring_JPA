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
        var result = confirm("Bạn có chắc chắn không?");
        if (result) {
            // Nếu người dùng chọn "OK" (xác nhận), form sẽ được gửi đi
            // document.forms[0].submit();
            return true;
        } else {
            // Nếu người dùng chọn "Cancel" (hủy), không có hành động gì xảy ra
            return false;
        }
    }
</script>
<body>
<div class="container text-center">
    <br/>
    <div><h1>CHI TIẾT SẢN PHẨM</h1></div>
</div>
<div class="container">
    <form:form action="/chi-tiet-san-pham/update" method="post" modelAttribute="chiTiet"
               onsubmit="return confirmSubmit()">
        <br/>
        ID:<form:input path="id" class="form-control" value="${ProDetail.id}"/>
        <form:errors path="id" cssStyle="color: red"/>
        <br/>
        Code:<form:input path="code" class="form-control" value="${ProDetail.code}"/>
        <form:errors path="code" cssStyle="color: red"/>
        <br/>
        Name:<form:input path="name" class="form-control" value="${ProDetail.name}"/>
        <form:errors path="name" cssStyle="color: red"/>
        <br/>
        Status:<form:radiobutton path="status" value="0" checked="${ProDetail.status == 0 ? 'checked':''}"
                                 class="form-check-input"/>Online
        <form:radiobutton path="status" value="1" checked="${ProDetail.status == 1 ? 'checked':''}"
                          class="form-check-input"/>Offline
        <br>
        Number:<form:input path="number" class="form-control" value="${ProDetail.number}"/>
        <form:errors path="number" cssStyle="color: red"/>
        <br>
        Category: <form:select path="category" class="form-select">
        <c:forEach items="${category}" var="category">
            <form:option value="${ProDetail.category.id}"/>
            <form:option value="${category.id}">${category.id} - ${category.name}</form:option>
        </c:forEach>
    </form:select>
        <br/>
        <%--        <div class="mb-3">--%>
        <%--            <input type="file" class="form-control" value="${ProDetail.images}" name="images">--%>
        <%--        </div>--%>
        <div class="mb-3">
            <input type="text" class="form-control" value="${ProDetail.images}" name="images">
        </div>
        <br/>
        <form:button type="submit" class="btn btn-info">UPDATE</form:button>
        <br/>
    </form:form>
</div>
</body>
</html>