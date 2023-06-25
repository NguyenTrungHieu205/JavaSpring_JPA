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
    <div><h1>KHÁCH HÀNG</h1></div>
</div>
<div class="container">
    <form:form action="/khach-hang/update" method="post" modelAttribute="KH" onsubmit="return confirmSubmit()">
        <br/>
        Code:<form:input path="id" readonly="false" class="form-control" value="${KhachHang.id}"/>
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
        <form:button type="submit" class="btn btn-info">UPDATE</form:button>
        <br/>
    </form:form>
</div>
</body>
</html>