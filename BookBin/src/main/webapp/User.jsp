<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css" integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">
    <link href="css/User.css" rel="stylesheet" />
    <script src="https://kit.fontawesome.com/39534946cf.js" crossorigin="anonymous"></script>
    <link  rel = "shortcut icon" href = "Images/Icon2.jpg">
<title>Login</title>
</head>
<body>
	
<input type = "hidden" id = "status1" value = "<%= request.getAttribute("status1") %>">
<input type = "hidden" id = "status2" value = "<%= request.getAttribute("status2") %>">


	<div class="container" id="container">



    					<!-- Sign Up Form-->

	<div class="form-container sign-up-container">
		<form id="testForm" method="post" reset(); action="register" >
            <br><br><br><br><br>
			<h1>Create Account</h1><br>
			<div class = "input-field">
                <i class="fas fa-user" aria-hidden="true"></i>
                <input class = "uname" name = "name" id= "username" type = "text" placeholder="Username" required = "required" />
            </div>
            <div class = "input-field">
                <i class="fas fa-envelope" aria-hidden="true"></i>
                <input type = "email" name = "email" id = "user_email" placeholder="Email" required = "required">
            </div>
            <div class = "input-field">
                <i class="fa fa-mobile" aria-hidden="true"></i>
                <input type = "tel" name = "mobile_number" id = "user_mobilenumber" placeholder="Mobile Number">
            </div>

            <div class = "input-field">
                <i class="fas fa-lock" aria-hidden="true"></i>
                <input class = "pswd" name = "pswd" id = "user_password" type = "password" placeholder="Password" required = "required">
            </div>
            <div class = "input-field">
                <i class="fas fa-lock" aria-hidden="true"></i>
                <input class = "pswd" name = "re_pswd"  id = "user_re_password" type = "password" placeholder="Confirm Password" required = "required">
            </div>
            <div class="radio">
                <input id = "rb1" name = "user_type" type ="radio" value ="Admin">Admin</input>  &nbsp;
                <input id = "rb2" name = "user_type" type ="radio" value ="Customer">Customer</input><br><br>
			</div>
			<button class = "btn-f">Sign Up</button>
            <span class = "social-text">Or Sign Up with social platforms</span>
            <div class="social-container">
				<a href="https://www.facebook.com/login/" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class = "fab fa-google" aria-hidden="true"></i></a>
				<a href="https://www.linkedin.com/" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
    	</form>
	</div>















    							 <!-- Sign In Form-->
     
     
     
	<div class="form-container sign-in-container">
		<form id="testForm" method ="post" reset(); action="login">
            <h1>Sign in</h1><br>		
            <div class = "input-field">
                <i class="fas fa-user" aria-hidden="true"></i>
                <input class = "uname" name = "email" id= "user_email" type = "email" placeholder="Email Id"  required = "required"/>
            </div>
			<div class = "input-field">
                <i class="fas fa-lock" aria-hidden="true"></i>
                <input class = "pswd" name = "pswd" id = "user_password" type = "password" placeholder="Password" required = "required"/>
            </div>
			<a href="forgotPassword.jsp" style = "font-size: smaller; color:#964B00; margin-left: 2px;">Forgot your password?</a><br>
            <div class="radio">
                <input id = "rb1" name = "user_type" type ="radio" value ="Admin" required = "required">Admin</input>  &nbsp; 
                <input id = "rb2" name = "user_type" type ="radio" value ="Customer" required = "required">Customer</input><br><br>
			</div>
            <button class = "btn-f">Sign In</button>
            <span class = "social-text">Or Sign Up with social platforms</span>
            <div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class = "fab fa-google"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>			
		</form>
	</div>
	
	
	
	
	
	
	
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1 class = "side-title">Welcome Back!</h1>
				<p class = "side-text">To keep connected with us please login with your personal info</p>
				<button class="ghost" id="signIn">Sign In</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1 class = "side-title">Hello, Friend!</h1>
				<p class = "side-text">Enter your personal details and start journey with us</p>
				<button class="ghost" id="signUp">Sign Up</button>
			</div>
		</div>
	</div>
	
	
</div>
	

    <script>
        const signUpButton = document.getElementById('signUp');
        const signInButton = document.getElementById('signIn');
        const container = document.getElementById('container');

        signUpButton.addEventListener('click', () => {
	    container.classList.add("right-panel-active");
        });

        signInButton.addEventListener('click', () => {
	    container.classList.remove("right-panel-active");
        });

     </script>

<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type = "text/javascript">
	var status1 = document.getElementById("status1").value;
	
	
	if(status1 == "success")
		{
			swal("Congrats","Account Created Successfully Please check your email", "success");
		}
	else if(status1 == "invalidName")
	{
		swal("Sorry","Please enter your name", "error");
	}
	else if(status1 == "invalidEmail")
	{
		swal("Sorry","Please enter your email", "error");
	}
	else if(status1 == "invalidpassword")
	{
		swal("Sorry","Please enter your password", "error");
	}
	else if(status1 == "invalidConfirmpassword")
	{
		swal("Sorry","Password do not match", "error");
	}
	if(status1 == "invalidMobile")
	{
		swal("Sorry","Please enter your mobile number", "error");
	}
	else if(status1 == "invalidMobileNumber")
	{
		swal("Sorry","Mobile Number should be of 10 digits", "error");
	}
	
	
	var status2 = document.getElementById("status2").value;
	if(status2 == "failed")
	{
		swal("Sorry","Login Failed", "error");
	}
	else if(status2 == "invalidEmail")
	{
		swal("Sorry","Username is Mandatory", "error");
	}
	else if(status2 == "invalidpassword")
	{
		swal("Sorry","Password is Mandatory", "error");
	}
	else if(status2 == "invalidusertype")
	{
		swal("Sorry","Usertype is Mandatory", "error");
	}
	else if(status2 == "resetSuccess")
	{
		swal("Congrats","Password has been Reset Successfully", "success");
	}
	else if(status2 == "resetFailed")
	{
		swal("Sorry","Password Reset Failed", "error");
	}
	
	</script>


 




    
</body>
</html>