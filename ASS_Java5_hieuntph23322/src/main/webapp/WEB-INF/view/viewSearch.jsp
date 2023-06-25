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
<body>
<%@include file="layout/header.jsp" %>
<div class="container text-center">
    <br/>
    <div><h1>HÓA ĐƠN</h1></div>
</div>
<div class="container">
    <table class="table table-dark table-striped-columns">
        <thead>
        <tr>
            <th scope="col">Mã hóa đơn</th>
            <th scope="col">Tên</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Đơn giá</th>
            <th scope="col">Tổng tiền</th>
            <th scope="col">Ngày đặt</th>
            <th scope="col">Tên khách hàng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${billProduct}" var="billProduct">
            <tr>
                <td>${billProduct.bill.code}</td>
                <td>${billProduct.productDetail.name}</td>
                <td>${billProduct.number}</td>
                <td>${billProduct.unitPrice}</td>
                <td>${billProduct.amount}</td>
                <td>${billProduct.bill.purchaseDate}</td>
                <td>${billProduct.bill.customer.fullName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>