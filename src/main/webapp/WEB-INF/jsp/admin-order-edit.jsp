<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Fei
  Date: 12/15/2021
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Order</title>
</head>
<body>
<h1>Edit Order Page</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="cartDiv">
    <div class="cartProductList">
        <table class="cartProductTable" id="table">
            <thead>
            <tr>
                <th>Order id</th>
                <th>total</th>
                <th>payment</th>
                <th>address</th>
                <th>recipient name</th>
                <th>status</th>
                <th>time</th>
                <th>userId</th>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td> ${order.id}</td>
                <td> ${order.total}</td>
                <td> ${order.payment}</td>
                <td> ${order.shippingAddress}</td>
                <td> ${order.recipientName}</td>
                <td> ${order.status}</td>
                <td> ${order.time}</td>
                <td> ${order.userId}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
