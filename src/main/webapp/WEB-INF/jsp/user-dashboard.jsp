<%--
  Created by IntelliJ IDEA.
  User: Fei
  Date: 12/4/2021
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Dashboard</title>
</head>
<body>
    <h1>Welcome ${sessionScope.currentUser.name}</h1>
    <a href="/TopShop_war_exploded/index.htm" id="index">Go Back To Home Page</a>
</body>
</html>
