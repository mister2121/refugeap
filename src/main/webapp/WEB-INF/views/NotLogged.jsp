<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RefugEAP NotLogIn Page</title>
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
                    <li><a href="ContactPage">Contact us</a></li>
                    <li>
                        <form action="LogIn"><button type="submit" class="login">Log In</button></form>
                    </li>
                </ul>
            </div>
        </nav>
    <main class="main-row">
        <div class="form-login">
            <a>Your username or password is incorrect.</a> <br>
            <a href="/LogIn"><button class="submit-input">Go back</button></a>
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