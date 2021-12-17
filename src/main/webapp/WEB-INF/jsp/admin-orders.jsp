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
    <style>
        /* Add a black background color to the top navigation bar */
        .topnav {
            overflow: hidden;
            background-color: #e9e9e9;
        }

        /* Style the links inside the navigation bar */
        .topnav a {
            float: left;
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        /* Change the color of links on hover */
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        /* Style the "active" element to highlight the current page */
        .topnav a.active {
            background-color: #2196F3;
            color: white;
        }

        /* Style the search box inside the navigation bar */
        .topnav input[type=text] {
            float: right;
            padding: 6px;
            border: none;
            margin-top: 8px;
            margin-right: 16px;
            font-size: 17px;
        }
        .topnav input[type=submit] {
            float: right;
            padding: 6px;
            margin-top: 8px;
            margin-right: 16px;
            font-size: 17px;
            color: red;
        }

        /* When the screen is less than 600px wide, stack the links and the search field vertically instead of horizontally */
        @media screen and (max-width: 600px) {
            .topnav a, .topnav input[type=text] {
                float: none;
                display: block;
                text-align: left;
                width: 100%;
                margin: 0;
                padding: 14px;
            }
            .topnav input[type=text] {
                border: 1px solid #ccc;
            }
        }
    </style>
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
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="topnav">
    <a class="active" href="${contextPath}/admin/index.htm">Home</a>

    <%--    <a href="#about">About</a>--%>
    <a>Admin Orders page</a>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <form action="${contextPath}/admin/showProduct.htm" method="post">
        <a>
            <input type="radio" value="productid" name="color">Search By ID
            <input type="radio" value="productname" name="color">Search By Name
        </a>
        <input type="text" placeholder="Search.." name="search">
        <input type="submit" value="search">
    </form>
</div>
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
                <td><a class="deleteOrder"  href="${contextPath}/admin/deleteOrder.htm?order_id=${oi.id}">delete</a></td>
            </tr>
            </c:forEach>
        </table>

    </div>
</div>
</body>
</html>
