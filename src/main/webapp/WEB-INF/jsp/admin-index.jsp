<%--
  Created by IntelliJ IDEA.
  User: Fei
  Date: 12/7/2021
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        /* The sidebar menu */
        .sidenav {
            height: 100%; /* Full-height: remove this if you want "auto" height */
            width: 160px; /* Set the width of the sidebar */
            position: fixed; /* Fixed Sidebar (stay in place on scroll) */
            z-index: 1; /* Stay on top */
            top: 0; /* Stay at the top */
            left: 0;
            background-color: #111; /* Black */
            overflow-x: hidden; /* Disable horizontal scroll */
            padding-top: 20px;
        }

        /* The navigation menu links */
        .sidenav a {
            padding: 6px 8px 6px 16px;
            text-decoration: none;
            font-size: 25px;
            color: #818181;
            display: block;
        }

        /* When you mouse over the navigation links, change their color */
        .sidenav a:hover {
            color: #f1f1f1;
        }

        /* Style page content */
        .main {
            margin-left: 160px; /* Same as the width of the sidebar */
            padding: 0px 10px;
        }

        /* On smaller screens, where height is less than 450px, change the style of the sidebar (less padding and a smaller font size) */
        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }
        h1{
            text-align: center;
        }
        #userTag{
            padding: 6px 8px 6px 16px;
            text-decoration: none;
            font-size: 25px;
            color: #818181;
            display: block;
        }
    </style>
    <script>
        function ajaxEvent() {

            var xmlHttp;
            try // Firefox, Opera 8.0+, Safari
            {
                xmlHttp = new XMLHttpRequest();
            } catch (e) {
                try // Internet Explorer
                {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                        alert("Your browser does not support AJAX!");
                        return false;
                    }
                }
            }

            xmlHttp.onreadystatechange = function() {
                if (xmlHttp.readyState == 4) {
                    document.getElementById("info").innerHTML = xmlHttp.responseText;
                }
            }

            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;

            xmlHttp.open("POST", "../ajaxservice.htm?username="+username+"&password="+password, true);
            xmlHttp.send();
        }
    </script>
</head>
<body>
<h1>Top Shop Administration Page</h1>
<div class="sidenav">
    <div id="userTag">${sessionScope.currentUser.name}</div>
    <a href="/TopShop_war_exploded/index.htm" id="index">Home</a>
    <a href="user/login.htm" id="login-selector">Login</a>
    <a href="user/register.htm" id="register-selector">Register</a>
    <a href="user/products.htm">Products</a>
    <a href="cart.htm">Cart</a>
    <a href="user/logout.htm">LogOut</a>
</div>

<!-- Page content -->
<div class="main">
    <button>Get Server Response</button>
    <div id="contentdiv"></div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $("button").click(function (){
            $.get("user/login.htm",function (data){
                $("#contentdiv").html("AJAX"+data);
            });
        });

    </script>

</div>
</body>
</html>

