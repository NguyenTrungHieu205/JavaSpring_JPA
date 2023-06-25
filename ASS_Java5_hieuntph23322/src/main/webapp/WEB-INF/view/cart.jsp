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
<body>
<%@include file="layout/header.jsp" %>
<h3 style="text-align: center">GIO HANG</h3>
<div class="container">
    <table class="table table-dark table-striped-columns">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Giá bán</th>
            <th scope="col">Mẫu</th>
            <th scope="col">Thành tiền</th>
            <%--            <th scope="col">Action</th>--%>
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
                <td>
                    <a href="/gio-hang/delete/${items.id}">
                        <button type="button" class="btn btn-outline-info">X</button>
                    </a>
                </td>
            </tr>
            <c:set var="totalPrice" value="${totalPrice + items.number * items.unitPrice}"/>
        </c:forEach>
        </tbody>
    </table>
    <a href="/gio-hang/removeall" type="button" class="btn btn-outline-warning">XÓA GIỎ HÀNG</a>
</div>
<div class="container">
    <h2 style="color: red">Tổng tiền: ${totalPrice} VNĐ</h2>
    <a href="/view-chi-tiet-san-pham" type="button" class="btn btn-warning" style="margin-top: 50px">TIẾP TỤC MUA
        HÀNG</a>
    <a href="/gio-hang/xac-nhan" type="button" class="btn btn-danger" style="margin-top: 50px; width: 200px">THANH
        TOÁN</a>
</div>


<%@include file="layout/footer.jsp" %>
</body>
</html>
