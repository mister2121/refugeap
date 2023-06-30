<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RefugEAP FAQ Page</title>
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
                    <li><a href="FAQ" class="active">FAQ</a></li>
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
        <br><h1>Frequently Asked Questions (FAQ):</h1>
        <br>
        <div class="faq-main">
            <details open>
                <summary>Question 1</summary>
                <p>Answer:[placeholder]</p>
            </details>
            <br>
            <hr>
            <br>
            <details>
                <summary>Question 2</summary>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut finibus ex, quis laoreet lectus. In hac habitasse platea dictumst. Aenean vehicula magna vitae mauris elementum, non posuere lacus iaculis. Praesent lacus lorem, imperdiet sed maximus ac, dictum vitae elit. Aenean aliquet sem ut dapibus placerat. Mauris vitae mi odio. Vivamus tristique feugiat accumsan. Praesent non finibus velit, et sagittis ante.</p>
            </details>
            <br>
            <hr>
            <br>
            <details>
                <summary>Question 3</summary>
                <p>Answer:[placeholder]</p>
            </details>
            <br>
            <hr>
            <br>
            <details>
                <summary>Question 4</summary>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut finibus ex, quis laoreet lectus. In hac habitasse platea dictumst. Aenean vehicula magna vitae mauris elementum, non posuere lacus iaculis. Praesent lacus lorem, imperdiet sed maximus ac, dictum vitae elit. Aenean aliquet sem ut dapibus placerat. Mauris vitae mi odio. Vivamus tristique feugiat accumsan. Praesent non finibus velit, et sagittis ante.</p>
            </details>
            <br>
            <hr>
            <br>
            <details>
                <summary>Question 5</summary>
                <p>Answer:[placeholder]</p>
            </details>
            <br>
        </div>
        <br>
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