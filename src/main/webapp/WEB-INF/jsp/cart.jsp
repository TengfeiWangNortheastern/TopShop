<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Fei
  Date: 12/8/2021
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<h1>Cart for ${sessionScope.currentUser.name}</h1>
<table>
    <c:forEach items="${sessionScope.cart}"  var="cartlist">
        <tr>
            <td>${cartlist.product.name}</td>
            <td>${cartlist.number}</td>
            <td>${cartlist.subtotal}</td>
        </tr>
    </c:forEach>
</table>
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

    img.cartProductImg {
        padding: 1px;
        border: 1px solid #EEEEEE;
        width: 80px;
        height: 80px;
    }

    table.cartProductTable th.selectAndImage {
        width: 140px;
    }

    table.cartProductTable th.operation {
        width: 30px;
    }

    div.cartProductLinkOutDiv {
        position: relative;
        height: 80px;
    }

    a.cartProductLink {
        color: #3C3C3C;
    }

    a.cartProductLink:hover {
        color: #FF0036;
        text-decoration: underline;
    }

    div.cartProductLinkInnerDiv {
        position: absolute;
        bottom: 0;
        height: 20px;
    }

    span.cartProductItemOringalPrice {
        text-decoration: line-through;
        color: #9C9C9C;
        display: block;
        font-weight: bold;
        font-size: 14px;
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

    span.cartProductItemSmallSumPrice {
        font-family: Arial;
        font-size: 14px;
        font-weight: bold;
        color: #FF0036;
    }

    img.cartProductItemIfSelected, img.selectAllItem {
        cursor: pointer;
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

    span.cartTitlePrice {
        color: #C40000;
        font-size: 14px;
        font-weight: bold;
        margin-left: 5px;
        margin-right: 3px;
    }

    div.cartFoot {
        background-color: #E5E5E5;
        line-height: 50px;
        margin: 20px 0px;
        color: black;
        padding-left: 20px;
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

    img.cartProductItemIfSelected, img.selectAllItem {
        cursor: pointer;
    }

    span.cartSumNumber {
        color: #C40000;
        font-weight: bold;
        font-size: 16px;
    }

    span.cartSumPrice {
        color: #C40000;
        font-weight: bold;
        font-size: 20px;
    }
</style>
<title>购物车</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="cartDiv">
    <div class="cartTitle pull-right">
        <span>Chosen Products</span>
        <span class="cartTitlePrice">$0.00</span>
        <button class="createOrderButton" disabled="disabled">Check Out</button>
    </div>

    <div class="cartProductList">
        <table class="cartProductTable">
            <thead>
            <tr>
                <th class="selectAndImage">
                    <img selectit="false" class="selectAllItem" src="img/fore/cartNotSelected.png">
                    全选

                </th>
                <th>商品信息</th>
                <th>单价</th>
                <th>数量</th>
                <th width="120px">金额</th>
                <th class="operation">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.cart}" var="oi">
                <tr  class="cartProductItemTR">
                    <td>
                        <img selectit="false"  class="cartProductItemIfSelected"
                             src="img/fore/cartNotSelected.png">
                        <a style="display:none" href="#nowhere"><img src="img/fore/cartSelected.png"></a>
                        <img class="cartProductImg"
                             src="img/product/${oi.product.id}/1.jpg">
                    </td>
                    <td>
                        <span class="cartProductItemOringalPrice">￥${oi.product.price}</span>
                        <span class="cartProductItemPromotionPrice">￥${oi.product.price}</span>

                    </td>
                    <td>

                        <div class="cartProductChangeNumberDiv">
                            <span class="hidden orderItemStock " product_id="${oi.product.id}">${oi.product.stock}</span>
                            <span class="hidden orderItemPromotePrice "
                                  product_id="${oi.product.id}">${oi.product.price}</span>
                            <a product_id="${oi.product.id}" class="numberMinus" href="#nowhere">-</a>
                            <input product_id="${oi.product.id}"  class="orderItemNumberSetting"
                                   autocomplete="off" value="${oi.number}">
                            <a stock="${oi.product.stock}" product_id="${oi.product.id}" class="numberPlus"
                               href="#nowhere">+</a>
                        </div>

                    </td>
                    <td>
                            <span class="cartProductItemSmallSumPrice" product_id="${oi.product.id}">
                                    ${oi.product.price*oi.number}
                            </span>

                    </td>
                    <td>
                        <a class="deleteOrderItem"  href="${contextPath}/user/deleteCart.htm?product_id=${oi.product.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
    <form action="${contextPath}/user/checkout.htm">
    <div class="cartFoot">
        <span>products</span><br>
        <a href="/TopShop_war_exploded/index.htm" >Go Back To Home Page</a><br>
        <a href="/TopShop_war_exploded/user/products.htm" >Continue Shopping</a>
        <!--         <a href="#">删除</a> -->

        <div class="pull-right">
            <span>Subtotal </span>
            <span class="cartSumPrice">${sessionScope.total}</span>
            <input type="submit" class="createOrderButton" value="Continue To Checkout"></input>
        </div>

    </div>
</form>
</div>
</body>
</html>
