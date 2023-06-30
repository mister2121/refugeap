<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/homepage.css" type="text/css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RefugEAP Home Page</title>
</head>

<body>
    <nav class="nav">
        <a href="#" class="toggle-button">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </a>
        <div class="navbar-links">
            <ul id="navlist">
                <li><a href="/" class="active">Home</a></li>
                <li><a href="AboutUs" >About us</a></li>
                <li><a href="Blog">Blog</a></li>
                <li><a href="Events">Events</a></li>
                <li><a href="FAQ">FAQ</a></li>
                <li><a href="ContactPage">Contact us</a></li>
            </ul>
        </div>
    </nav>
    <main class="main">
        <div id="main-logo"><img src="/images/refugeeslogo.png" id="logo" alt="logo"></div>
        <div id="main-text"><br>
            <div id="transbox"><h1>The <span class="span1">RefugEAP</span> Network's overarching objective is to facilitate the development and implementation of
                'pathway to Higher Education' English language provision for <span class="span1">refugee-background students (RBS)</span>, with
                a particular focus on English for Academic Purposes (EAP).</h1></div><br>
        </div>
        <div id="main-button">
            <button type="submit" id="aboutus"><a href="AboutUs">Learn more</a></button>
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