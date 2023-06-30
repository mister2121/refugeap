<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <!DOCTYPE html>
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
                        <li><a href="Blog" class="active">Blog</a></li>
                        <li><a href="Events">Events</a></li>
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
            <main class="main-column">
                <div class="form">
                    <form:form action="/addComment?blogID=${blogID}" modelAttribute="comment">
                        <p>Content:</p>
                        <form:textarea path="content" class="post-text-input" />
                        <form:errors path="content" /><br />
                        <input type="submit" class="submit-input" />
                        <form:errors />
                    </form:form>
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