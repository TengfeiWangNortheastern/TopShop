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
    <style>
        table{
            width: 80%;
        }
        table, th, td {
            border: 1px solid black;
        }
        td{
            align-content: center;
        }
        #btn{
            border: red;
        }
    </style>
</head>
<body>
<h1>Edit Order Page</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form action="${contextPath}/admin/updateOrder.htm?order_id=${order.id}" method="post">
        <table>
            <thead>
            <tr>
                <th>Order id</th>
                <th>total</th>
                <th>payment</th>
                <th>address</th>
                <th>recipient name</th>
                <th>phone</th>
                <th>status</th>
                <th>time</th>
                <th>userId</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td> ${order.id}</td>
                <td> ${order.total}</td>
                <td> <input name="payment" value="${order.payment}" required></td>
                <td> <input name="address" value="${order.shippingAddress}" required></td>
                <td> <input name="receiver_name" value="${order.recipientName}" required></td>
                <td> <input name="phone" value="${order.recipientPhone}" required></td>
                <td> ${order.status}
                    <select name="status">
                        <option value="PENDING">Pending</option>
                        <option value="CANCELED">Cancel</option>
                        <option value="DELIVERED">Delivered</option>
                </select></td>
                <td> ${order.time}</td>
                <td> ${order.userId}</td>
            </tr>
        </table>
    <hr>
    <h1>Items in the order</h1>
<%--    <table>--%>
<%--        <c:forEach  items="${orderitems}" var="oi">--%>
<%--            <tr>--%>
<%--                <td>${oi.id}</td>--%>
<%--                <td>${oi.productId}</td>--%>
<%--                <td>${oi.subtotal}</td>--%>
<%--                <td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<input type="submit" name="updateBtn" value="update" id="btn">
</form>
<a href="/TopShop_war_exploded/admin/index.htm" id="index">Go Back To Home Page</a><br><br>
<a href="/TopShop_war_exploded/admin/showOrder.htm" id="index">Go Back To Order Page</a>
</body>
</html>
