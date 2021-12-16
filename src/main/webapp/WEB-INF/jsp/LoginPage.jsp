<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Fei
  Date: 12/1/2021
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .page {
            width: 990px;
            margin: 0 auto;
            color: #3c3c3c;
            font: 400 12px/1.6 arial, 'Hiragino Sans GB', "Arial Black", sans-serif;
        }

        .page-top {
            height: 46px;
            border-bottom: 2px solid #e6e6e6;
            position: relative;
        }
        .btn-register {
            height: 36px;
            line-height: 36px;
            padding: 0 20px;
            color: #FFF;
            font-weight: 700;
            font-size: 16px;
            text-align: center;
            background: #ff0036;;
            border: 0;
            vertical-align: middle;
            border-radius: 3px;
            cursor: pointer;
            width: 300px;
        }

        .btn-register:hover {
            background-color: rgba(255, 0, 54, .8);
        }
        a {
            text-decoration: none;
        }

        .header .tm-logo {
            margin-top: 8px;
            width: 190px;
        }

        #mallPage, #mallPage.mallChn {
            width: auto;
            min-width: 990px;
            background-color: transparent;
        }
    </style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="page">
<div class="page-top">
    <div class="active">
        <div class="tsl">Login Page</div>
    </div>
</div>
<form action="${contextPath}/user/login.htm" method="POST">
    <table>
        <tr>
            <div class="form-item">
            <td><span class="form-label tsl">USERNAME:</span></td>
            <td><input type="text" name="username" id="username" maxlength="20" size="30" required="required"/></td>
            </div>
        </tr>

        <tr>
            <div class="form-item">
            <td><span class="form-label tsl">PASSWORD:</span></td>
            <td><input type="password" name="password" id="password" maxlength="20" size="30" required="required"/></td>
            </div>
        </tr>

        <tr>
            <div class="form-item">
            <td colspan="2"><input type="submit" name="action" value="Login" class="btn-register"/></td>
            </div>
        </tr>

    </table>
</form>
<br><br>
<div id="info"></div>
<br><br><br><br>

<a href="${contextPath}/user/register.htm">Create New User Account</a>
<br>

</div>
</body>
</body>
</html>
