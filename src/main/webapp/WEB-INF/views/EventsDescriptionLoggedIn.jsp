<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RefugEAP Blog Page</title>
</head>

<body>
    <nav class="nav">
        <img src="/images/refugeeslogo.png" id="logo" alt="logo">
        <a href="#" class="toggle-button">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </a>
        <div class="navbar-links">
            <ul id="navlist">
                <li><a href="/">Home</a></li>
                <li><a href="AboutUs" >About us</a></li>
                <li><a href="Blog">Blog</a></li>
                <li><a href="Events" class="active">Events</a></li>
                <li><a href="FAQ">FAQ</a></li>
                <li><a href="ContactPage">Contact us</a></li>
                </ul>
                    </div>
                    <div class="navbar-user">
                        <div class="navbar-user_info">
                            <i class="fa fa-user fa_custom"></i>
                            <p id="navlist-user">${currentUser}</p>
                        </div>
                        <form action="SignOut"><button type="submit" class="login">Sign out</button></form>
                    </div>
    </nav>
<div class="container">
    <div class="event">
        <%--Event description shown--%>
        <div class="eventcontainer">
            <br>
            <h1>Title: ${event.title}</h1><br>
            <p>${event.description}</p><br>
            <p>Author: ${event.author}</p><br>
        </div>
    </div>
</div>
<footer class="footer">
   <div id="footer-text">
       <a href="#">Twitter</a>
       |
       <a href="#">EAP for Social Justice SIG (BALEAP)</a>
       |
       <a href="#">Privacy policy</a>
   </div>
   <p>&copy; Copyright 2023 - UoL</p>
</footer>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>