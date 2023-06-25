<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/3/2023
  Time: 2:55 PM
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
    <link rel="stylesheet" href="/view/css/trangChu.css">
</head>
<script>
    function confirmSubmit() {
        var result = confirm("Bạn có chắc chắn muốn thanh toán?");
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
<%@include file="layout/header.jsp" %>
<h3 style="text-align: center">THANH TOÁN GIỎ HÀNG</h3>
<div class="container">
    <form action="/gio-hang/thanh-toan" method="post" onsubmit="return confirmSubmit()">
        Tên khách hàng:
        <input type="text" class="form-control" name="tenKhachHang" value="${tenKhachHang}">
        Số điện thoại:
        <input type="text" class="form-control" name="soDienThoai" value="${soDienThoai}">
        Địa chỉ:
        <input type="text" class="form-control" name="diaChi" value="${diaChi}">
        <br/>
        <button type="submit" class="btn btn-danger">THANH TOÁN</button>
    </form>
</div>
<table class="table table-dark table-striped-columns">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Tên sản phẩm</th>
        <th scope="col">Số lượng</th>
        <th scope="col">Giá bán</th>
        <th scope="col">Mẫu</th>
        <th scope="col">Thành tiền</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="items" items="${cartDetailList}">
        <tr>
            <td>${items.id}</td>
            <td>${items.name}</td>
            <td>${items.number}</td>
            <td>${items.unitPrice}</td>
            <td><img src="/assets/${items.images}" style="width: 100px"/></td>
            <td>${items.number*items.unitPrice}</td>
        </tr>
        <c:set var="totalPrice" value="${totalPrice + items.number * items.unitPrice}"/>
    </c:forEach>
    </tbody>
</table>
<h2 style="color: red">Tổng tiền: ${totalPrice} VNĐ</h2>


<%@include file="layout/footer.jsp" %>
</body>
</html>
