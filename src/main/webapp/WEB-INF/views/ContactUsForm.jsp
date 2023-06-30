<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Contact Form - PHP/MySQL Demo Code</title>
  <!-- Latest compiled and minified CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>

<body class="bg-light">

<div class="container">
  <img class="d-block mx-auto mb-4" src="https://le.ac.uk/-/media/uol/images/professional-services/cite/university-of-sanctuary/logos/refugeap-logo-406.jpg?h=228&w=406&hash=DDCFB1F7847BE28F34AE54A00AA64B57" alt="" width="240" height="64">
  <h2>Contact us form</h2>
</div>
<fieldset>

  <form name="frmContact" class="needs-validation " method="post" action="contact.php">
    <p>
      <label for="Name">Your Name </label>
      <input type="text" class="form-control" name="txtName" id="txtName" placeholder="Name" value="" required>
    <div class="invalid-feedback">
      Valid first name is required.
    </div>
    </p>
    <p>
      <label for="email">Your Email</label>
      <input type="text"  class="form-control"  name="txtEmail" id="txtEmail" placeholder="Email" value="" required>
    </p>
    <p>
      <label for="phone">Your Phone</label>
      <input type="text"  class="form-control" name="txtPhone" id="txtPhone" placeholder="Phone" value="" required>
    </p>
    <p>
      <label for="message">Message</label>
      <textarea name="txtMessage" class="form-control"  id="txtMessage"  placeholder="Message" required></textarea>
    </p>
    <p>&nbsp;</p>
    <p>
      <input type="submit" name="Submit" id="Submit" value="Send"  class="btn btn-primary btn-lg btn-block">
    </p>
  </form>
</fieldset>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>
