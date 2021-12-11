<%--
  Created by IntelliJ IDEA.
  User: Fei
  Date: 12/10/2021
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Page</title>
</head>
<body>
<button>Confirm</button>
<div id="contentdiv"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $("button").click(function (){
        $.get("user/login.htm",function (data){
            $("#contentdiv").html(data);
        });
    });

</script>

</body>
</html>
