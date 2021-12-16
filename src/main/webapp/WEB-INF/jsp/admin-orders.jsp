<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Fei
  Date: 12/7/2021
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    div.cartDiv {
        max-width: 1013px;
        margin: 10px auto;
        color: black;
    }

    table.cartProductTable {
        width: 100%;
        font-size: 12px;
    }

    tr.cartProductItemTR {
        border: 1px solid #CCCCCC;
    }

    tr.cartProductItemTR td {
        padding: 20px 20px;
    }

    table.cartProductTable th {
        font-weight: normal;
        color: #3C3C3C;
        padding: 20px 20px;
    }
    table.cartProductTable th.operation {
        width: 30px;
    }

    span.cartProductItemPromotionPrice {
        font-family: Arial;
        font-size: 14px;
        font-weight: bold;
        color: #FF0036;
    }

    div.cartProductChangeNumberDiv {
        border: solid 1px #E5E5E5;
        width: 80px;
    }

    div.cartProductChangeNumberDiv a {
        width: 14px;
        display: inline-block;
        text-align: center;
        color: black;
        text-decoration: none;
    }

    div.cartProductChangeNumberDiv input {
        border: solid 1px #AAAAAA;
        width: 42px;
        display: inline-block;
    }


    div.cartDiv {
        max-width: 1013px;
        margin: 10px auto;
        color: black;
    }

    div.cartTitle button {
        background-color: #AAAAAA;
        border: 1px solid #AAAAAA;
        color: white;
        width: 53px;
        height: 25px;
        border-radius: 2px;
    }
    div.cartFoot button {
        background-color: #AAAAAA;
        border: 0px solid #AAAAAA;
        color: white;
        width: 120px;
        height: 50px;
        font-size: 20px;
        text-align: center;
    }
    td {border: 1px #DDD solid; padding: 5px; cursor: pointer;}

</style>
<title>Cart</title>
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
            <c:forEach items="${sessionScope.adminorders}" var="oi">
            <tr>
                <td> <a href="${contextPath}/admin/showSelectedOrder.htm?order_id=${oi.id}">${oi.id}</a></td>
                <td> ${oi.total}</td>
                <td> ${oi.payment}</td>
                <td> ${oi.shippingAddress}</td>
                <td> ${oi.recipientName}</td>
                <td> ${oi.status}</td>
                <td> ${oi.time}</td>
                <td> ${oi.userId}</td>

            </tr>
            </c:forEach>
        </table>

    </div>
</div>
</body>
</html>
