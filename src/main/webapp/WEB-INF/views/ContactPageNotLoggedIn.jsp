<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RefugEAP Contact Page</title>
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
                <li><a href="Events">Events</a></li>
                <li><a href="FAQ">FAQ</a></li>
                <li><a href="ContactPage" class="active">Contact us</a></li>
                <li>
                    <form action="LogIn"><button type="submit" class="login">Log in</button></form>
                </li>
            </ul>
        </div>
    </nav>
<main class="main-column">
    <div class="Contact-main">
        <h1>Contact Us</h1>

        <h2>Reach out we would love to hear from you!</h2>

        <p>Whether you would like to find out more about what we do, join in with our discussions, let us know what
            social justice work you are involved with, contribute a blog to the site or simply say hello, do get in
            touch!
        </p>

        <p>EMAIL: eap4socialjustice@baleap.org</p>

        <p>TWITTER: @EapforSJ </p>
    </div>

</main>
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