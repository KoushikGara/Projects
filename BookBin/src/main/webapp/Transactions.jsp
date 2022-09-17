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
    <link rel = "stylesheet" href = "css/Transactions.css" />
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
                    <a href = "<%=request.getContextPath()%>/AdminBooks">
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
                    <a href = "<%=request.getContextPath()%>/TransactionServlet" style = "background-color: #03a9f4;">
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

           
            
              <div class="main-container">
                <br>
                  
                <div class="users-table">
                    <h3 class = "title">Transactions</h3>
                    
                    
                    <table class="content-table" id="table1" style="width:100%">
                        <thead>
                            <tr>                                
                                <th style="width:20%">Transaction_id</th>
                                <th style="width:10%">Receiver_id</th>
                                <th style="width:10%">Owner_id</th>
                                <th style="width:5%">Book_id</th>
                                <th style="width:30%; font-size:15px;">IssuedDate</th>
                                <th style="width:5%">Trans_Amt</th>
                                <th style="width:5%">Transaction_status</th>
                                <th style="width:5%">RemainingDays</th>
                              	<th style="width:10%" class="penalll">Penalty</th>
                            </tr>
                        </thead>
                        <tbody class="pop-table" id="tBody">
                        	<c:forEach var="ut" items="${listAllUserTransaction}">
                        		<tr>									
									<td><c:out value="${ut.trans_id}" /></td>
									<td><c:out value="${ut.receiver_id}" /></td>
									<td><c:out value="${ut.owner_id}" /></td>
									<td><c:out value="${ut.book_id}" /></td>
									<td><c:out value="${ut.issued_date}" /></td>
									<td><c:out value="${ut.trans_amount}" /></td>
									<td><c:out value="${ut.trans_status}" /></td>
									<td><c:out value="${ut.remaining_days}" /></td>
									<td>	
										<a href="<%=request.getContextPath()%>/ImposePenality?tid=<c:out value='${ut.trans_id}'/>">
											<button class="penalty-button">Impose Penalty</button>
										</a>
									</td>
									
								</tr>
                        	</c:forEach>             
	                   </tbody>
                    </table>
                    <span class="empty-table">
	                            <h2>No Transactions</h2>  
	                            <p>All the <b>transactions</b> will be shown here.</p>
	                </span>
                    <br><br>
                    
                 
                </div>









            </div>
            
            <div class="nota">
            	c : Transaction Completed<br>
            	a : Request Accepted<br>
            	r : Request Sent <br>
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
        
        
        
        window.onload = function showPenaltyButton()
        {
        	t = document.getElementById("tBody");
   			r = t.getElementsByTagName("tr");
        	rowCount = t.rows.length;
        	for(let i = 0; i < rowCount; i++)
       		{
        		td = r[i].getElementsByTagName("td");
        		if(td[7].innerHTML < 0)
        			{
        			td[8].style.display = "block";
        			document.getElementsByClassName("penalll")[0].style.display = "block";
        			}
        		else
        		{
        			td[8].style.display = "none";
        			document.getElementsByClassName("penalll")[0].style.display = "none";
        		}
       		}
        	

        	//checking table rows
        	var x = document.getElementById("table1").rows.length;
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