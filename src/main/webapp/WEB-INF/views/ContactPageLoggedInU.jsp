<%@page import="com.example.refugeeap.controller.ContactPageController"%>
<%@ page import="org.apache.catalina.mbeans.ContainerMBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<main class="main-column">
    <div class="Contact-main">
        <br>
        <h1>Contact Us</h1>

        <h2>Reach out we would love to hear from you!</h2>

        <p>Whether you would like to find out more about what we do, join in with our discussions, let us know what
            social justice work you are involved with, contribute a blog to the site or simply say hello, do get in
            touch!
        </p>

        <p>EMAIL: eap4socialjustice@baleap.org</p>

        <p>TWITTER: @EapforSJ </p>
        <br><br>
        <h2> Or send us message now from here!:
    </div>
    <div class="form-main">
        <div class="container">
            <div class="formQuery">
                <form:form action="/addQuery" modelAttribute="userQuery">

                    <label class="form-label">Email:</label><br>
                    <form:input path="email" class="text-input" placeholder="Enter your email..." size="30" />
                    <form:errors path="email" /><br />

                    <label class="form-label">Phone Number:</label><br>
                    <form:input path="phoneNumber" class="text-input" placeholder="Enter your phone number..." size="30"/>
                    <form:errors path="phoneNumber" /><br />

                    <label class="form-label">Message:</label><br>
                    <form:input path="message" class="text-input" placeholder="Enter your message" size="30"/>
                    <form:errors path="message" /><br />

                    <input type="submit" class="submit-input"/>
                    <form:errors />
                </form:form>
                <br>
                <a href="/UserQuery"><button type="submit" id="Queries">View your queries</button></a>
            </div>
            <br>
        </div>
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