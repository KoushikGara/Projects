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
    <link rel = "stylesheet" href = "css/Admin.css" />
    <link  rel = "shortcut icon" href = "Images/A.png">
    <title>Admin</title>
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
                    <a href = "<%=request.getContextPath()%>/AdminBooks" style = "background-color: #03a9f4;">
                        <span class = "icon"><i class="fa fa-home" aria-hidden="true" title="Dashboard"></i></span>
                        <span class = "title">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href = "<%=request.getContextPath()%>/AllMembers">
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
                        <span class = "icon"><i class="fa fa-sign-out" aria-hidden="true" title="Signout" title="Signout"></i></span>
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

            <div class = "cardBox">
                <div class = "card">
                    <div>
                        <div class = "numbers">${userscount}</div>
                        <div class  ="cardName">Users</div>
                    </div>
                   
                </div>
    
                <div class = "card">
                    <div>
                        <div class = "numbers">${transactionscount}</div>
                        <div class  ="cardName">Transactions</div>
                    </div>
                    
                </div>
    
                <div class = "card">
                    <div>
                        <div class = "numbers">${bookscount}</div>
                        <div class  ="cardName">Total Books Available</div>
                    </div>
                    
                </div>
    
               



            </div>
            
            
              <div class="main-container">
                <br>
                  
                <div class="users-table">
                    <h3 class = "title">Books</h3>
                    
                    
                    <table class="content-table">
                        <thead>
                            <tr>                                
                                <th>User</th>
                                <th>Book</th>
                                <th>Price</th>
                                <th>Book Status</th>
                              
                            </tr>
                        </thead>
                        <tbody class="pop-table" id="tBody">
                        	<c:forEach var="books" items="${listAllBook}">
                        		<tr>									
									<td><c:out value="${books.customer_id}" /></td>
									<td><c:out value="${books.book_title}" /></td>
									<td><c:out value="${books.book_price}" /></td>
									<td style="font-weight:bold;"><c:out value="${books.book_status}" /></td>
									
									
								</tr>
                        	</c:forEach>             
	                   </tbody>
                    </table><br><br>
                    
                 
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
        
        window.onload = function init()
        {
        	t = document.getElementById("tBody");
   			r = t.getElementsByTagName("tr");
   			rowCount = t.rows.length;
        	for(let i = 0; i < rowCount; i++)
       		{
        		td = r[i].getElementsByTagName("td");
        		if(td[3].innerHTML == "active")
        			{
	        			td[3].style.background = "lightgreen";
	        			td[3].style.color = "black";
        			}
        		else if(td[3].innerHTML == "inactive")
        		{
        			td[3].style.background = "red";
        			td[3].style.color = "white";
        		}
       		}
        }
    </script>
</html>