<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css" integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/39534946cf.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://smtpjs.com/v3/smtp.js"></script>
    <title>Message</title>
    <link rel = "stylesheet" href = "css/Message.css" />
    <link  rel = "shortcut icon" href = "Images/U.jpg">
</head>
<body>
    <div class = "container">
        <div class = "navigation">
            <ul>
                <li>
                    <a href = "#">
                        <span class = "icon" onclick="toggleMenu();"><i class="fa fa-bars" aria-hidden="true"></i></span>
                        <span class = "title"><h2>BookBin</h2></span>
                    </a>
                </li>
                <li>
                    <a href = "<%=request.getContextPath()%>/AdminBooks">
                        <span class = "icon"><i class="fa fa-home" aria-hidden="true"></i></span>
                        <span class = "title">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href = "<%=request.getContextPath()%>/AllMembers">
                        <span class = "icon"><i class="fa fa-users" aria-hidden="true"></i></span>
                        <span class = "title">Users</span>
                    </a>
                </li>
                 <li>
                    <a href = "<%=request.getContextPath()%>/TransactionServlet">
                        <span class = "icon"><i class="fa fa-money" aria-hidden="true"></i></span>
                        <span class = "title">Transactions</span>
                    </a>
                </li>
                <li>
                    <a href = "Message.jsp"  style = "background-color: #03a9f4;">
                        <span class = "icon"><i class="fa fa-comment" aria-hidden="true"></i></span>
                        <span class = "title">Message</span>
                    </a>
                </li>
                <li>
                    <a href = "ChangePassword.jsp">
                        <span class = "icon"><i class="fa fa-unlock-alt" aria-hidden="true"></i></span>
                        <span class = "title">Change Password</span>
                    </a>
                </li>
                <li>
                    <a href = "User.jsp">
                        <span class = "icon"><i class="fa fa-sign-out" aria-hidden="true"></i></span>
                        <span class = "title">Signout</span>
                    </a>
                </li>
            </ul>

        </div>

        <div class = "main">
            <div class = "topbar">
                <div class = "toggle"></div>
                <div class = "search">
                    <label>
                        <input type = "text" placeholder="Search here">
                        <i class="fa fa-search" aria-hidden="true"></i>
                    </label>
                </div> 
                <div class = "user" onclick="openDropdown()">
                        Admin
                       <i class="fa fa-user-circle" aria-hidden="true"></i>
                </div>                               
            </div>
            
            <div class="dropdown-menu">
                <a href="ChangePassword.jsp">Change Password</a>
                <a href="User.jsp">Signout</a>
            </div>


            <div class="contact-form">
                <div class = "contact-header">
                    <h1 class = "contact-header-text"> Message User </h1>
                    <div class = "contact-header-design">
                        <hr>
                        <i class="fa fa-envelope-o" aria-hidden="true"></i>
                        <hr>
                    </div>
                </div>
    
    
                <div class = "form-container">
                    <form action = "SendEmailToUser" method = "post">
                        <h3>Contact User</h3>
                        <input type = "text" name = "name" placeholder="User name" required>
                        <input type = "email" name = "email" placeholder="Email id" required>
                        <input type = "text" name = "sub" placeholder="Subject" required>
                        <textarea  rows = "6" name = "message" placeholder="Your message to user"></textarea>
                        <button type = "submit" onclick="alert('Message Sent!')">Send</button>
                    </form>
    
                </div>

            </div> 
    
            




        </div>
    </div>

        
    
</body>
<script>
    function toggleMenu()
    {
        let toggle  = document.querySelector('.toggle');
        let navigation  = document.querySelector('.navigation');
        let main  = document.querySelector('.main');
        toggle.classList.toggle('active');
        navigation.classList.toggle('active');
        main.classList.toggle('active');
    }
    
    function openDropdown()
    {
    	if(document.getElementsByClassName("dropdown-menu")[0].style.opacity == 0)
    	{
       		 document.getElementsByClassName("dropdown-menu")[0].style.opacity = 1;
        	 document.getElementsByClassName("dropdown-menu")[0].style.transform = "translateY(0)"
   		 }
    	
   	 	else
   	 	{
        	document.getElementsByClassName("dropdown-menu")[0].style.opacity = 0;
        	document.getElementsByClassName("dropdown-menu")[0].style.transform = "translateY(-10px)";
    	}
    }
    
</script>
</html>