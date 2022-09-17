<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core"  prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css" integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">
  
   <script src="https://kit.fontawesome.com/39534946cf.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://unpkg.com/jspdf@latest/dist/jspdf.umd.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.3/jspdf.min.js"></script>
    <script src="https://html2canvas.hertzen.com/dist/html2canvas.js"></script>
    
    <script src="JS/Members.js" defer></script>
    <link rel = "stylesheet" href = "css/Members.css" />
    <link  rel = "shortcut icon" href = "Images/A.png">
    <title>All Users</title>
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
                        <span class = "icon"><i class="fa fa-home" aria-hidden="true" title="Dashboard"></i></span>
                        <span class = "title">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href = "<%=request.getContextPath()%>/AllMembers" style = "background-color: #03a9f4;">
                        <span class = "icon"><i class="fa fa-users" aria-hidden="true" title="Users"></i></span>
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
                    <a href = "Message.jsp">
                        <span class = "icon"><i class="fa fa-comment" aria-hidden="true" title="Message"></i></span>
                        <span class = "title">Message</span>
                    </a>
                </li>
                <li>
                    <a href = "ChangePassword.jsp">
                        <span class = "icon"><i class="fa fa-unlock-alt" aria-hidden="true" title="Change Password"></i></span>
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

			
              <div class="main-container">
                <br>
                   <div class="users-table">
                    <h3 class = "title">Admins</h3>
                    <div class="number-of-rows">Number of rows per page: 
                        <select name="rows" id="rows">
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                            <option value="40">40</option>
                            <option value="50">50</option>
                        </select>
                    </div>
                    
                    <table class="content-table">
                        <thead>
                            <tr>                                
                                <th>Username</th>
                                <th>Email ID</th>
                                <th>Mobile No.</th>
                                <th>User ID</th>
                               <th style = "dispaly:none">Details</th>
                                
                            </tr>
                        </thead>
                        <tbody class="pop-table">
                        	<c:forEach var="admin" items="${listAdmin}">
                        		<tr>									
									<td><c:out value="${admin.username}" /></td>
									<td><c:out value="${admin.email}" /></td>
									<td><c:out value="${admin.mobile_number}" /></td>
									<td><c:out value="${admin.customer_id}" /></td>
									<td style = "dispaly:none"><button class="user-button" onclick="showUserDetails(this)">Get details</button></td>
								</tr>
                        	</c:forEach>             
	                   </tbody>
                    </table>
                 </div><br>
                <div class="users-table">
                    <h3 class = "title">All Users</h3>
                    <div class="number-of-rows">Number of rows per page: 
                        <select name="rows" id="rows">
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                            <option value="40">40</option>
                            <option value="50">50</option>
                        </select>
                    </div>
                    
                    <table class="content-table">
                        <thead>
                            <tr>                                
                                <th>Username</th>
                                <th>Email ID</th>
                                <th>Mobile No.</th>
                                <th>User ID</th>
                               <!-- <th>Details</th> --> 
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody class="pop-table">
                        	<c:forEach var="customer" items="${listCustomer}">
                        		<tr onclick="showUserDetails(this)" style="cursor:pointer;">									
									<td><c:out value="${customer.username}" /></td>
									<td><c:out value="${customer.email}" /></td>
									<td><c:out value="${customer.mobile_number}" /></td>
									<td><c:out value="${customer.customer_id}" /></td>
									<!--<td><button class="user-button" onclick="showUserDetails(this)">Get details</button></td> -->
									<td>
										<label class="table-buttons">
												<button class="generate-button"  type="button" onclick="showUserDetails(this)">Generate Report</button>     
																				
										
												<a href="<%=request.getContextPath()%>/DeleteMembers?id=<c:out value='${customer.customer_id}'/>"><button class="delete-button"  type="button" onclick="alert('User Removed!')"> Delete</button></a>
										</label>
										
                        
									
									</td>
								</tr>
                        	</c:forEach>             
	                   </tbody>
                    </table><br><br>
                    
                 
                </div>



			
				




            </div>





         <div class="user-details" style = "display:none">
                <button class="close-user-details" onclick="closeUserDetails()">x</button>
                <div class="pdf-content">
                    <div class = "user-preview-header">
                        <h1 class="user-name">Username</h1>
                    </div><br>
                    <h4 style = " font-size:22px; font-weight: 300;" class="title-left">User ID :  </h4><span class="user-id details-right"></span><br>
                    <h4 style = " font-size:22px; font-weight: 300;" class="title-left">Email ID :  </h4><span class="email-id details-right"></span><br>
                    <h4 style = " font-size:22px; font-weight: 300;" class="title-left">Mobile :  </h4><span class="mobile details-right"></span><br>
                    <h4 style = " font-size:22px; font-weight: 300;" class="title-left">Wallet Amount :  </h4><span class="wallet-amount details-right"></span><br>
                
                </div>
                <div class = "user-op">
                    <button class="generate-button"  type="button" onclick="CreatePDFfromHTML()">Generate Report</button> &nbsp;
                    <button class="delete-button"  type="button" onclick="alert('User Removed!')"><a href = "<%=request.getContextPath()%>/DeleteMembers?id=4126">Delete User </a></button>
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