<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title> Login and Registration</title>
    <link rel="stylesheet" href="CSS/style.css">
    <!-- Fontawesome CDN Link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
<input type="hidden" id="status1" value="<%= request.getAttribute("status1") %>">
<input type="hidden" id="condition" value="<%=session.getAttribute("condition") %>">
<input type="hidden" id="logoutMsg" value="<%= request.getAttribute("logoutMsg") %>">
<div class="container">
    <input type="checkbox" id="flip">
    <div class="cover">
      <div class="front">
        <img src="Images/bbbb.jpg" alt="">
        <div class="text">
          <span class="text-1">Every new friend is a <br> new adventure</span>
          <span class="text-2">Let's get connected</span>
        </div>
      </div>
      <div class="back">
        <img src="Images/backImg.jpg" alt="">
        <div class="text">
          <span class="text-1">Complete miles of journey <br> with one step</span>
          <span class="text-2">Let's get started</span>
        </div>
      </div>
    </div>
    <div class="forms">
        <div class="form-content">
          <div class="login-form">
            <div class="title">Login</div>
          <form action="login" method="post">
            <div class="input-boxes">
              <div class="input-box">
                <i class="fas fa-envelope"></i>
                <input type="email" name="lemail" placeholder="Enter your email" required>
              </div>
              <div class="input-box">
                <i class="fas fa-lock"></i>
                <input type="password" name="lpassword" placeholder="Enter your password" required>
              </div>
              <div class="text"><a href="#">Forgot password?</a></div>
              <div class="button input-box">
                <input type="submit" value="Sumbit">
              </div>
              <div class="text sign-up-text">Don't have an account? <label for="flip">Sigup now</label></div>
            </div>
        </form>
      </div>

        <div class="signup-form">

          <div class="title">Signup</div>
          
        
          
        <form action="register" method="post">
            <div class="input-boxes">
              <div class="input-box">
                <i class="fas fa-user"></i>
                <input type="text" name="signname" placeholder="Enter your name" required>
              </div>
              <div class="input-box">
                <i class="fas fa-envelope"></i>
                <input type="email" name="signemail" placeholder="Enter your email" required>
              </div>
              <div class="input-box">
                <i class="fas fa-lock"></i>
                <input type="password" name="signpassword" placeholder="Enter your password" required>
              </div>
              <div class="button input-box">
                <input type="submit" value="Sumbit">
              </div>
              <div class="text sign-up-text">Already have an account? <label for="flip">Login now</label></div>
            </div>
      </form>
    </div>
    </div>
    </div>
  </div>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <script type="text/javascript">
    var status=document.getElementById("status").value;
    if(status=="Success"){
    swal("Congrats", "Account Created Successfully!", "success");
    }
    if(status=="InvalidName"){
    swal("Oops", "Please Enter Name!", "error");
    }
    if(status=="InvalidEmail"){
    swal("Oops", "Please Enter Email!", "error");
    }
    if(status=="InvalidPassword"){
    swal("Oops", "Please Enter Password!", "error");
    }
     
    </script>
    
     <script>
     var status=document.getElementById("status1").value;
    if(status=="AlreadyExist"){
    swal("Oops", "User already Exists!, Login Now...", "error");
    }
    </script>
    <script>
     var status=document.getElementById("condition").value;
    if(status=="failed"){
    swal("Oops", "Invalid Credentials! Try Again..", "error");
    }
    </script>
     <script>
     var status=document.getElementById("logoutMsg").value;
    if(status=="success"){
    swal("Thank You!", "Logged Out Successfully", "success");
    }
    </script>
</body>
</html>