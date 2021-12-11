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
        .header {
            padding: 22px 0px;
            height: 88px;
            width: 1190px;
            margin: auto;
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
<h1> Top Shop Login </h1>
<form action="${contextPath}/user/login.htm" method="POST">
    <table>
        <tr>
            <td>USERNAME:</td>
            <td><input type="text" name="username" id="username" maxlength="20" size="30" required="required" /></td>
        </tr>

        <tr>
            <td>PASSWORD:</td>
            <td><input type="password" name="password" id="password" maxlength="20" size="30" required="required"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" name="action" value="Login" /></td>
        </tr>

    </table>
</form>
<br><br>
<div id="info"></div>
<br><br><br><br>

<a href="${contextPath}/user/register.htm">Create New User Account</a>

<br>
<a href="${contextPath}/admin/central.htm">I am a System Admin</a>


</body>
</body>
</html>
