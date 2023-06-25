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
</head>
<script>
    function confirmSubmit() {
        var result = confirm("Bạn có chắc chắn muốn xác nhận thông tin?");
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
<div class="container text-center">
    <br/>
    <div><h1>THANH TOÁN</h1></div>
</div>
<div class="container">
    <form action="/mua-ngay/thanh-toan/${chiTietSanPham.id}" method="post" onsubmit="return confirmSubmit()">
        Tên khách hàng:
        <input type="text" class="form-control" name="tenKhachHang">
        Số điện thoại:
        <input type="text" class="form-control" name="soDienThoai">
        Địa chỉ:
        <input type="text" class="form-control" name="diaChi">
        <br/>
        <button type="submit" class="btn btn-danger">THANH TOÁN</button>
    </form>
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
        <tr>
            <td>${chiTietSanPham.id}</td>
            <td>${chiTietSanPham.name}</td>
            <td>${1}</td>
            <td>${chiTietSanPham.category.productLine.price}</td>
            <td><img src="/assets/${chiTietSanPham.images}" style="width: 100px"/></td>
            <td>${chiTietSanPham.number*chiTietSanPham.category.productLine.price}</td>
        </tr>
        <c:set var="totalPrice"
               value="${totalPrice + chiTietSanPham.number * chiTietSanPham.category.productLine.price}"/>
        </tbody>
    </table>
    <h2 style="color: red">Tổng tiền: ${totalPrice} VNĐ</h2>

</div>
</div>
</div>
<%@include file="layout/footer.jsp" %>
</body>
</html>