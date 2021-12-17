<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Fei
  Date: 12/17/2021
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
    <style>
    .styled-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
    }
    </style>
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
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="topnav">
    <a class="active" href="${contextPath}/admin/index.htm">Home</a>
    <%--    <a href="#about">About</a>--%>
    <a>Add Product page</a>
    <%--    <a href="${contextPath}/showProduct.htm?product_id=${p.id}">Home</a>--%>
</div>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form action="${contextPath}/admin/createProduct.htm" method="post">
<table class="styled-table">
    <thead>
    <tr>
        <th>Name</th>
        <th>price</th>

        <th>review</th>
        <th>sale</th>
        <th>Stock</th>
        <th>subtitle</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><input type="text" name="name" required></td>
        <td><input type="number" name="price" required></td>
        <td><input type="number" name="review" required></td>
        <td><input type="number" name="sale" required></td>
        <td><input type="number" name="stock" required></td>
        <td><input type="subtitle" name="subtitle" required></td>
    </tr>
    <!-- and so on... -->
    <input type="submit" value="submit">
    </tbody>
</table>
</form>

</body>
</html>
