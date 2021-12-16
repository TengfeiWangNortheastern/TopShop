<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Fei
  Date: 12/6/2021
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <style>
        .bigImg {
            width: 418px;
            height: 418px;
        }

        .smallImg {
            width: 56px !important;
            height: 56px;
            border: 2px solid white;
        }

        div.product {
            margin-top: 90px;
            /*	margin-left: 25%;*/
            /*margin-right: auto;
            margin-left: auto;*/
            position: relative;
            float: left;
            left: 50%;
        }

        div.imgAndInfo div.smallImageDiv {
            width: 80%;
            margin: 20px auto;
        }

        div.imgAndInfo img.smallImg:hover {
            border: 2px solid black;
        }

        div.imgAndInfo {
            width: 980px;
            height: 550px;
            display: inline-flex;
            position: relative;
            float: left;
            left: -50%;
        }

        /*div.imgInimgAndInfo {*/
        /*    width: 420px;*/
        /*    float: center;*/
        /*}*/

        div.imgInimgAndInfo img {
            width: 420px;
        }

        div.infoInimgAndInfo {
            padding: 0px 20px;
            overflow: hidden;
            width: 560px;
        }

        div.infoInimgAndInfo div.productTitle {
            color: black;
            font-size: 16px;
            font-weight: bold;
            margin: 0px 10px;
        }

        div.infoInimgAndInfo div.productSubTitle {
            color: #DD2727;
            font-size: 12px;
            margin: 0px 10px;
        }

        div.infoInimgAndInfo div.productPriceDiv {
            /*background-image: url(/img/fore/priceBackground.png);*/
            height: 85px;
            padding: 10px;
            color: #666666;
        }

        div.infoInimgAndInfo div.gouwujuanDiv {
            margin-top: 5px;
        }

        div.infoInimgAndInfo span.promotionPriceYuan {
            font-family: Arial;
            font-size: 18px;
            color: #FF0036;
        }

        div.infoInimgAndInfo span.promotionPrice {
            color: #FF0036;
            font-family: Arial;
            font-size: 30px;
            font-weight: bold;
        }

        div.infoInimgAndInfo span.promotionPriceDesc {
            color: #999999;
            display: inline-block;
            width: 68px;
            position: relative;
            left: 0px;
            top: -10px;
        }

        div.infoInimgAndInfo div.productSaleAndReviewNumber {
            margin: 20px 0px;
            border-top: 1px dotted #C9C9C9;
            border-bottom: 1px dotted #C9C9C9;
            padding: 10px;
        }

        div.infoInimgAndInfo div.productSaleAndReviewNumber div {
            display: inline-block;
            width: 49%;
            text-align: center;
            color: #999999;
            font-size: 12px;
        }

        div.infoInimgAndInfo div.productSaleAndReviewNumber div:first-child {
            border-right: 1px solid #E5DFDA;
        }

        div.infoInimgAndInfo div.productNumber {
            color: #999999;
        }

        div.infoInimgAndInfo span.productNumberSettingSpan {
            border: 1px solid #999;
            display: inline-block;
            width: 43px;
            height: 32px;
            padding-top: 7px;
        }

        div.infoInimgAndInfo input.productNumberSetting {
            border: 0px;
            height: 80%;
            width: 80%;
        }

        div.productNumber span.updown img {
            display: inline-block;
            vertical-align: top;
        }

        div.productNumber span.updown {
            border: 1px solid #999;
            display: block;
            width: 20px;
            height: 14px;
            text-align: center;
            padding-top: 4px;
        }

        div.productNumber span.updownMiddle {
            height: 4px;
            display: block;
        }

        div.productNumber span.arrow {
            display: inline-block;
            width: 22px;
            height: 32px;
            vertical-align: top;
        }

        div.serviceCommitment {
            margin: 20px 0px;
        }

        div.infoInimgAndInfo span.serviceCommitmentDesc {
            color: #999999;
        }

        div.infoInimgAndInfo span.serviceCommitmentLink a {
            color: #666666;
        }

        div.buyDiv {
            margin: 20px auto;
            text-align: center;
        }

        div.buyDiv button {
            display: inline-block;
            margin: 0px 10px;
            width: 180px;
            height: 40px;
        }


        #button.addCartButton {
            border: 1px solid #FF0036;
            background-color: #FF0036;
            text-align: center;
            line-height: 40px;
            font-size: 16px;
            color: white;
        }

        #button.addCartButton span.glyphicon {
            font-size: 12px;
            margin-right: 8px;
        }
    </style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<form action="${contextPath}/user/addCart.htm" method="get">
    <input type="hidden" id="product_id" name="product_id" value="${product.id}">
<div class="product">
    <div class="imgAndInfo">
        <div class="imgInimgAndInfo">
            <img class="bigImg" src="img/product/${product.id}/1.png">
            <div class="smallImageDiv">
                <img class="smallImg" src="img/product/${product.id}/1.png" bigImgURL="img/product/${product.id}/1.png">
                <img class="smallImg" src="img/product/${product.id}/2.png" bigImgURL="img/product/${product.id}/2.png">
                <img class="smallImg" src="img/product/${product.id}/3.png" bigImgURL="img/product/${product.id}/3.png">
                <img class="smallImg" src="img/product/${product.id}/4.png" bigImgURL="img/product/${product.id}/4.png">
                <img class="smallImg" src="img/product/${product.id}/5.png" bigImgURL="img/product/${product.id}/5.png">
                <div class="img4load hidden"></div>
            </div>
        </div>

        <div class="infoInimgAndInfo">
            <div class="productTitle">
                ${product.name}
            </div>
            <div class="productSubTitle">
                ${product.subTitle}
            </div>
            <div class="productPrice">
                <div class="productPriceDiv">
                    <div class="gouwujuanDiv">
                        <span> Top Shop</span>
                    </div>

                    <div class="promotionDiv">
                        <span class="promotionPriceDesc">Price</span>
                        <span class="promotionPriceYuan">$</span>
                        <span class="promotionPrice">${product.price}</span>
                    </div>
                </div>
            </div>

            <div class="productSaleAndReviewNumber">
                <div>sale<span class="redColor boldWord">${product.sale}</span></div>
                <div>comments<span class="redColor boldWord">${product.reviewCount}</span></div>
            </div>
            <div class="productNumber">
                <span>Quantity</span>
                <span>
                <span class="productNumberSettingSpan">
                <input type="number" name="number" value="1" class="productNumberSetting">
                </span>
					</span>
                <span>stock${product.stock}</span>
            </div>
            <div class="buyDiv">
                <%--<c:set var="number" scope="page" value="${('#number').val()}"--%>
                    <input type="submit" id="button" class="addCartButton" value="Add to Cart"><span class="glyphicon glyphicon-shopping-cart"></span></input>
            </div>
        </div>
        <div style="clear:both"></div>
    </div>
</div>
</form>
<div style="clear: both;"></div>
<style>
    div.productParamterList span {
        display: block;
        width: 220px;
        float: left;
        padding: 8px 0px;
        color: #666666;
    }

    div.productDetailImagesPart img {
        display: block;
        width: 790px;
        margin: 20px 0px;
    }
</style>
</body>
</html>
