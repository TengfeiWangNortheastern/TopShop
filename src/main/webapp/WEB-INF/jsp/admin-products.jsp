<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Fei
  Date: 12/7/2021
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Products</title>
    <style>
        .product {
            margin-top: 40px;
            margin-right: 20px;
            margin-bottom: 20px;
            width: 220px;
            height: 290px;
            position: relative;
            float: left;
            padding: 0;
            /*margin: 0 0 20px;*/
            line-height: 1.5;
            overflow: visible;
            z-index: 1;
        }

        .product-hover .product-iWrap, .product:hover .product-iWrap {
            height: auto;
            margin: -3px;
            border: 4px solid #ff0036;
            border-radius: 0;
            -webkit-transition: border-color .2s ease-in;
            -moz-transition: border-color .2s ease-in;
            -ms-transition: border-color .2s ease-in;
            -o-transition: border-color .2s ease-in;
            transition: border-color .2s ease-in;
        }

        .product:hover {
            overflow: visible;
            z-index: 3;
            background: #fff;
        }

        .product-iWrap {
            min-height: 98%;
            width: 210px;
            position: absolute;
            background-color: #fff;
            margin: 0;
            padding: 4px 4px 0;
            font-size: 12px;
            border: 1px solid #f5f5f5;
            border-radius: 3px;
        }

        .productImg-wrap a, .productImg-wrap img {
            max-width: 100%;
            max-height: 210px;
        }

        .productPrice {
            font-family: arial, verdana, sans-serif !important;
            color: #ff0036;
            font-size: 14px;
            height: 30px;
            line-height: 30px;
            margin: 0 0 5px;
            letter-spacing: normal;
            overflow: inherit !important;
            white-space: nowrap;
        }

        .productPrice em {
            float: left;
            font-family: arial;
            font-weight: 400;
            font-size: 20px;
            color: #ff0036;
        }

        .productPrice em b {
            margin-right: 2px;
            font-weight: 700;
            font-size: 14px;
            vertical-align: middle;
        }

        .productTitle {
            display: block;
            color: #666;
            height: 14px;
            line-height: 12px;
            margin-bottom: 3px;
            word-break: break-all;
            position: relative;
            overflow: hidden;

        }

        .productTitle a {
            color: #333;
            font-family: 微软雅黑;
            line-height: 14px;
            font-size: 12px;
        }

        .productStatus {
            position: relative;
            height: 33px;
            border: none;
            border-top: 1px solid #eee;
            margin-bottom: 0;
            color: #999;
            display: block;
            overflow: hidden;
        }

        .productStatus em {
            color: #b57c5b;
        }

        .productStatus a, .productStatus em {
            margin-top: -8px;
            font-family: arial;
            font-size: 12px;
            font-weight: 700;
        }

        em {
            font-style: normal;
        }

        .productStatus span {
            float: left;
            display: inline-block;
            border-right: 1px solid #eee;
            width: 39%;
            padding: 10px 1px;
            margin-right: 6px;
            line-height: 12px;
            text-align: left;
            white-space: nowrap;
        }

        .productStatus a {
            color: #38b;
        }

        .productStatus .ww-light {
            border-right: none;
            width: 11%;
            text-align: center;
        }

        .productStatus .ww-light a {
            /*background: url(/img/fore/ww-online.png) center center no-repeat !important;*/
            background-size: 16px !important;
            position: relative;
            width: 16px;
            height: 16px;
            margin-top: -3px;
            overflow: hidden;
            display: inline-block;
            vertical-align: text-bottom;
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
    <a>Admin Product page</a>
    <form action="${contextPath}/admin/showProduct.htm" method="post">
        <a>
        <input type="radio" value="productid" name="color">Search By ID
        <input type="radio" value="productname" name="color">Search By Name
        </a>
        <input type="text" placeholder="Search.." name="search">
        <input type="submit" value="search">
    </form>
</div>
<hr>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:forEach items="${sessionScope.productlist}" var="p">
    <div class="product">
        <div class="product-iWrap">
            <div class="productImg-wrap">
                    <%--        <a class="productImg" href="${contextPath}/showProduct?product_id=${p.id}">--%>
                <a class="productImg" href="${contextPath}/showProduct.htm?product_id=${p.id}">
                    <img src="img/product/${p.id}/1.png">
                </a>
            </div>
            <div style="clear: both;"></div>
            <p class="productPrice">
                <em title="${p.price}">
                    <b>$</b>${p.price}
                </em>
            </p>
            <div style="clear: both;"></div>
            <p class="productTitle">
                <a href="${contextPath}/showProduct.htm?product_id=${p.id}">${p.name}</a>
            </p>
            <p class="productStatus">
                <span>sale<em>${p.sale}</em></span>
                <span>review<a href="#nowhere">${p.reviewCount}</a></span>
                <span class="ww-light"><a></a></span>
            </p>
        </div>
    </div>
</c:forEach>
</body>
</html>
