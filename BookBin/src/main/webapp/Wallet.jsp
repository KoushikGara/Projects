
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core"  prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css" integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/39534946cf.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css"/>
    <script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
    <title>Wallet</title>
    
    <link rel = "stylesheet" href = "css/Wallet.css" />
    <link  rel = "shortcut icon" href = "Images/U.jpg">
</head>
<body>
    <div class = "main-container">
        <div class = "navigation">
            <ul>
                <li>
                    <a href = "#">
                        <span class = "icon" onclick="toggleMenu();"><i class="fa fa-bars" aria-hidden="true"></i></span>
                        <span class = "title"><h2>BookBin</h2></span>
                    </a>
                </li>
                <li>
                    <a href = "<%=request.getContextPath()%>/CustomerServlet">
                        <span class = "icon"><i class="fa fa-home" aria-hidden="true"></i></span>
                        <span class = "title">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href = "<%=request.getContextPath()%>/Books">
                        <span class = "icon"><i class="fa fa-book" aria-hidden="true"></i></span>
                        <span class = "title">My Books</span>
                    </a>
                </li>
                <li>
                    <a href = "<%=request.getContextPath()%>/Wallet" style = "background-color: #03a9f4;">
                        <span class = "icon"><i class="fa fa-credit-card" aria-hidden="true"></i></span>
                        <span class = "title">Wallet</span>
                    </a>
                </li>
                <li>
                    <a href = "<%=request.getContextPath()%>/CustomerServlet" class = "ct" onclick = "showCart()">
                        <span class = "icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>
                        <span class = "title">Cart</span>
                    </a>
                </li>
                <li>
                    <a href = "Help.jsp">                
                        <span class = "icon"><i class="fa fa-question-circle" aria-hidden="true"></i></span>
                        <span class = "title">Help</span>
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
 
               <!-- <div id = "cart-icon">
                    <h2>
                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                        <span class="items-number"></span>
                    </h2>
                </div>-->
 
                <div class = "user">
                      ${username}
                       <i class="fa fa-user-circle" aria-hidden="true"></i>
                </div>  
                
                           
            </div>
            
            <div class="dropdown-menu">
                <a href="<%=request.getContextPath()%>/WithdrawAccount">Withdraw Account</a>
                <a href="ChangePassword.jsp">Change Password</a>
                <a href="User.jsp">Signout</a>
            </div>
            
            <div class="wallet-container">
		        <h3 class="title">BookBin Wallet</h3>
 
		        <div class="amount-box text-center">
		         	<img src="Images/Wallet.png" alt="wallet">
                    <br>
		         	<h2 class="title-left">Total Balance</h2><span class="amount details-right">$ ${walletMoney}</span>
		        </div>
 
	         	<div class="btn-group text-center">
                    <button class="wallet-button" onclick="showAddMoney()">Add Money</button>
                    <a href="<%=request.getContextPath()%>/CartServlet">
                    	<button class="wallet-button">Cart</button>
		      		</a>
		      	</div>
		      	
		      	<form method="post" action="Wallet" class="add-form">
		      		<input type="text" placeholder="Enter amount" name="wallet-money" >
		      		<button type="submit" class="wallet-button">Add</button>
		      	</form>
 
                <hr />
                <br>
		      	<div class="books-table">
	                    <h3 style="text-align:center;">All Transactions</h3>
	                    
	                    
						<table class="content-table" style="width:100%" id="table1">
	                         <thead>
                            <tr>
                                <th>Trans ID</th>
                                <th>Book Name</th>
                                <th>Days</th>
                                <th>Price</th>
                                <th>status</th>
                               
                            </tr>
                            </thead>
	                        <tbody class="request-table">
	                           <c:forEach var="transactions" items="${listTransactions}">
	                            	 <c:set var = "transaction_id" scope = "session" value = "${transactions.trans_id}"/>
	                        		<tr>									
										<td><c:out value="${transactions.trans_id}" /></td>
										<td><c:out value="${transactions.book_title}" /></td>
										<td style="display:none;"><c:out value="${transactions.issued_date}" /></td>
										<td><c:out value="${transactions.remaining_days}" /></td>
										<td>$<c:out value="${transactions.trans_amount}" /></td>
										<td><c:out value="${transactions.trans_status}" /></td>
									
									</tr>
	                        	</c:forEach> 
	                        </tbody>
	                    </table>
						<span class="empty-table">
	                            <h2>No Transactions</h2>  
	                            <p>All the <b>transactions</b> will be shown here.</p>
	                    </span>
						<br><br><br>
						
					
                </div>
 				<div class="nota">
	            	c : Transaction Completed<br>
	            	a : Request Accepted<br>
	            	r : Request Sent <br>
	            </div>
			</div>
 
 			<br><br><br><br>
 
 
 
 
 
 
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
    
    function showCart()
    {
      document.getElementsByClassName("dashboard-view")[0].style.display = "none";
      document.getElementsByClassName("cart-view")[0].style.display = "block";
      document.getElementsByClassName("ct")[0].style.background = "#03a9f4";
      document.getElementsByClassName("db")[0].style.background = "#003147";
    }
    
    function showAddMoney()
    {
    	if(document.getElementsByClassName("add-form")[0].style.display == "block")
    		document.getElementsByClassName("add-form")[0].style.display = "none";
    	else
    		document.getElementsByClassName("add-form")[0].style.display = "block";
    	//console.log("hello");
    }
    
    window.onload = function init(){

    	//checking table rows
    	var x = document.getElementById("table1").rows.length;
    	console.log(x);
    	if(x <= 1)
    	{
    		document.getElementsByClassName("empty-table")[0].style.display = "block";
    		document.getElementsByClassName("content-table")[0].style.display = "none";
    	}
    	else
    	{
    		document.getElementsByClassName("empty-table")[0].style.display = "none";
    		document.getElementsByClassName("content-table")[0].style.display = "auto";
    	}
    }
    
</script>
</html>