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
    <div><h1>DÒNG SẢN PHẨM</h1></div>
</div>
<div class="container">
    <form:form action="/dong-san-pham/update" method="post" modelAttribute="pro" onsubmit="return confirmSubmit()">
        <br>
        ID:<form:input path="id" class="form-control" value="${proLine.id}"/>
        <form:errors path="id" cssStyle="color: red"/>
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
        Status:<form:radiobutton path="status" value="0" checked="${proLine.status == 0 ? 'checked':''} || 'true'"
                                 class="form-check-input"/>Online
        <form:radiobutton path="status" value="1" checked="${proLine.status == 1 ? 'checked':''}"
                          class="form-check-input"/>Offline
        <br>
        <form:button type="submit" class="btn btn-info">Update</form:button>
        <br/>
    </form:form>
</div>
</body>
</html>