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
<body>
<%@include file="layout/header.jsp" %>
<div class="container" style="text-align: center">
    <h1>CẢM ƠN QUÝ KHÁCH ĐÃ MUA HÀNG</h1>
    <h5>Mã hóa đơn của bạn là: ${maHD}</h5>
    <c:forEach items="${cartDetailList}" var="items">
        <c:set var="totalPrice" value="${totalPrice + items.number * items.unitPrice}"/>
    </c:forEach>
    <h2>Số tiền cần phải trả: ${totalPrice}</h2>
    <c:forEach var="items" items="${cartDetailList}">
        <tr>
            <img src="/assets/${items.images}" style="width: 100px"/>
        </tr>
    </c:forEach>
    <h6>Ngày đặt hàng: ${ngayDat}</h6>
    <a href="/view-chi-tiet-san-pham">
        <button type="button" class="btn btn-success">Trang chủ</button>
    </a>

</div>

<%@include file="layout/footer.jsp" %>
</body>
</html>
