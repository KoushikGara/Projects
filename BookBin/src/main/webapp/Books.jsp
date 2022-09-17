<%

	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	response.setHeader("Pragma","no-cache");
	response.setHeader("Expires","0");

%>



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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="JS/Books.js" defer></script>
    <link rel = "stylesheet" href = "css/Books.css" />
    <link  rel = "shortcut icon" href = "Images/B.jpg">
    <title>Books</title>
</head>
<body>
    <div class = "main-container">
        <div class = "navigation">
            <ul>
                <li>
                    <a href = "#">
                        <span class = "icon" onclick="toggleMenu();"><i class="fa fa-bars" aria-hidden="true"></i></span>
                        <span class = "title"><h1>BookBin</h1></span>
                    </a>
                </li>
                <li>
                    <a href = "<%=request.getContextPath()%>/CustomerServlet">
                        <span class = "icon"><i class="fa fa-home" aria-hidden="true" title="Dashboard" ></i></span>
                        <span class = "title">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href = "#" style = "background-color: #03a9f4;">
                        <span class = "icon"><i class="fa fa-book" aria-hidden="true" title = "MyBooks"></i></span>
                        <span class = "title">My Books</span>
                    </a>
                </li>
                <li>
                    <a href = "<%=request.getContextPath()%>/Wallet">
                        <span class = "icon"><i class="fa fa-credit-card" aria-hidden="true" title="Wallet"></i></span>
                        <span class = "title">Wallet</span>
                    </a>
                </li>
                <li>
                    <a href = "Customer.jsp" class = "ct" onclick = "showCart()">
                        <span class = "icon"><i class="fa fa-shopping-cart" aria-hidden="true" title="Cart"></i></span>
                        <span class = "title">Cart</span>
                    </a>
                </li>
                <li>
                    <a href = "Help.jsp">                
                        <span class = "icon"><i class="fa fa-question-circle" aria-hidden="true" title="Help"></i></span>
                        <span class = "title">Help</span>
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
                        <span class = "icon"><i class="fa fa-sign-out" aria-hidden="true" title="Signout"></i></span>
                        <span class = "title">Signout</span>
                    </a>
                </li>
                <li class="error-msg" style="background-color:red; padding:10px;">
                	<span class="flag" style="display:none;">${status_flag}</span>
                	<span>
		               	Previous <b>Transaction Failed</b>,
		               	because the requested book is not active.
		               	<b>Reasons:</b> The requested book might be using by others or got deleted.
		            </span>
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
                       ${username}
                       <i class="fa fa-user-circle" aria-hidden="true"></i>
                </div>   
                
      		</div>
			
			<div class="dropdown-menu">
                <a href="<%=request.getContextPath()%>/WithdrawAccount">Withdraw Account</a>
                <a href="ChangePassword.jsp">Change Password</a>
                <a href="User.jsp">Signout</a>
            </div>
            
                                      
                                             
       
			
			 
            
            <div class = "cardBox">
                <div class = "card">
                    <div>
                        <div class = "numbers">5</div>
                        <div class  ="cardName">Books Published</div>
                    </div>
                </div>
    
                <div class = "card" >
                    <div>
                        <div class = "numbers">3</div>
                        <div class  ="cardName">Books Borrowed</div>
                    </div>
                </div>
    
                <div class = "card" id="pending-card">
                    <div>
                        <div class = "numbers" id="pending-count"> ${booksPending}</div>
                        <div class  ="cardName">Books Pending </div>
                    </div>
                </div>    
            </div>


            
  

             <div class = "container">
                <br>
                <div class="books-table">
                    <h3 class = "title">My Published Books</h3>
                    <div class="number-of-rows">Number of rows per page: 
                        <select name="rows" id="rows">
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                            <option value="40">40</option>
                            <option value="50">50</option>
                        </select>
                    </div>
                    
                    <table class="content-table" id="table1">
                        <thead>
                            <tr>
                                <th>Book ID</th>
                                <th>Book Name</th>
                                <th>Author</th>
                                <th>Price</th>
                                <th style = "display: none">edition</th>
                                <th style = "display: none">status</th>
                                <th style = "display: none">desc</th>
                                <th style = "display: none">year</th>
                                <th>Details</th>
                            </tr>
                        </thead>
                        <tbody class="published-table">
                            <c:forEach var="publishedbook" items="${listPublishedBook}">
                              	 <c:set var = "published_book_id" scope = "session" value = "${publishedbook.book_id}"/>
                        		<tr>									
									<td><c:out value="${publishedbook.book_id}" /></td>
									<td><c:out value="${publishedbook.book_title}" /></td>
									<td><c:out value="${publishedbook.book_author}" /></td>
									<td><c:out value="${publishedbook.book_price}" /></td>
									<td style = "display: none"><c:out value="${publishedbook.book_edition}" /></td>
									<td style = "display: none"><c:out value="${publishedbook.book_status}" /></td>
									<td style = "display: none"><c:out value="${publishedbook.book_description}" /></td>
									<td style = "display: none"><c:out value="${publishedbook.published_year}" /></td>
									<td><button class="user-button" onclick="showBookDetails(this)">Get details</button></td> 
								</tr>
                        	</c:forEach>   
                        </tbody>
                    </table>
					<span class="empty-table">
                           <h2>No Published Books</h2>  
                           <p>Add <b>New Book</b> to see all published books here.</p>
                    </span>
                    
                  </div><br>
                  
                  <div class="books-table">
                    <h3 class = "title">My Borrowed Books</h3>
                    <div class="number-of-rows">Number of rows per page: 
                        <select name="rows" id="rows">
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                            <option value="40">40</option>
                            <option value="50">50</option>
                        </select>
                    </div>
					
                    <table class="content-table" id="table2">
                        <thead>
                            <tr>
                                <th>Book ID</th>
                                <th>Book Name</th>
                                <th>Author</th>
                                <th>Price</th>
                                <th>Details</th>
                            </tr>
                        </thead>
                        <tbody class="borrowed-table">
                           <c:forEach var="borrowedbook" items="${listBorrowedBook}">
                            	 <c:set var = "borrowed_book_id" scope = "session" value = "${borrowedbook.book_id}"/>
                        		<tr>									
									<td><c:out value="${borrowedbook.book_id}" /></td>
									<td><c:out value="${borrowedbook.book_title}" /></td>
									<td><c:out value="${borrowedbook.book_author}" /></td>
									<td><c:out value="${borrowedbook.book_price}" /></td>
									<td><button class="user-button" onclick="showBookDetails1(this)">Get details</button></td> 
								</tr>
                        	</c:forEach> 
                        </tbody>
                    </table>
						<span class="empty-table">
                            <h2>No Borrowed Books</h2>  
                            <p>All <b>Borrowed Books</b> will appear here.</p>
	                    </span>
                    
                    </div><br>
                    
                    <div class="books-table">
	                    <h3 class = "title">Requests</h3>
	                    <div class="number-of-rows">Number of rows per page: 
	                        <select name="rows" id="rows">
	                            <option value="10">10</option>
	                            <option value="20">20</option>
	                            <option value="30">30</option>
	                            <option value="40">40</option>
	                            <option value="50">50</option>
	                        </select>
	                    </div>
	                    
						<table class="content-table" style="width:100%" id="table3">
	                        <thead>
	                            <tr>
	                                <th style="width:10%">Book ID</th>
	                                <th style="width:30%">Book Name</th>
	                                <th style="width:25%">Request from</th>
	                                <th style="width:15%">No. of days requested</th>
	                                <th style="width:10%">Price</th>
	                                <th style="display:none;">ID</th>
	                                <th style="width:10%">Accept/Reject</th>
	                            </tr>
	                        </thead>
	                        <tbody class="request-table">
	                           <c:forEach var="requestedbook" items="${listRequestedBook}">
	                            	 <c:set var = "transaction_id" scope = "session" value = "${requestedbook.trans_id}"/>
	                        		<tr>									
										<td><c:out value="${requestedbook.book_id}" /></td>
										<td><c:out value="${requestedbook.book_title}" /></td>
										<td><c:out value="${requestedbook.receiver_id}" /></td>
										<td><c:out value="${requestedbook.remaining_days}" /></td>
										<td><c:out value="${requestedbook.trans_amount}" /></td>
										<td style="display:none;"><c:out value="${requestedbook.trans_id}" /></td>
										<td style="background-color:ghostwhite;">
											 <a href="<%=request.getContextPath()%>/AcceptRequest?transaction_id=<c:out value='${transaction_id}' />"><button class="request-button" style="background-color:lightgreen">A</button></a>
											  <a href="<%=request.getContextPath()%>/RejectRequest?transaction_id=<c:out value='${transaction_id}' />"><button class="request-button" style="background-color:red">R</button>
										</td> 
									</tr>
	                        	</c:forEach> 
	                        </tbody>
	                    </table>
							<span class="empty-table">
	                            <h2>No Requests</h2>  
	                            <p>The <b>requests</b> for your published books will be shown here.</p>
		                    </span>
						<br><br><br>
						
					
                </div>
            </div>



             <div class="published-book-details">
                <div class = "book-preview-header">
                    <h1 class = "book-name">Book Name</h1> 
                    <button class= "close-book-preview-details" onclick="closeBookDetails()">x</button>
                </div><br>                                            
                <h4 class="title-left">Author : </h4><span class="details-right author"></span><br>
                <h4 class="title-left">Book ID :  </h4><span class="details-right book-id"></span><br>
                <h4 class="title-left">Book Edition :  </h4><span class="details-right book-edition"></span><br>
                <h4 class="title-left">Book Description : </h4><span class="details-right book-desc"></span><br>
                <h4 class="title-left">Price : </h4><span class="details-right price"></span><br>
                <h4 class="title-left">Published Year : </h4><span class="details-right published-year"></span><br>
                <h4 class="title-left">Book Status : </h4><span class="details-right book-status"></span><br>
                <br>
                <a href="<%=request.getContextPath()%>/DeleteBooks?published_book_id=<c:out value='${published_book_id}' />"><button class="book-button"  type="button" onclick="alert('Book Deleted!')">
                	Delete Book </button>
				</a>
            </div>
              

            <div class="borrowed-book-details">
                <div class = "book-preview-header">
                    <h1 class = "book-name">Book Name</h1> 
                    <button class= "close-book-preview-details" onclick="closeBookDetails()">x</button>
                </div><br>                                            
                <h4 class="title-left">Book ID :  </h4><span class ="details-right book-id"></span><br>
                <h4 class="title-left">Author : </h4><span class="details-right author"></span><br>
                <h4 class="title-left">Publication :  </h4><span class="details-right publication"></span><br>
                <h4 class="title-left">Published Date : </h4><span class="details-right published-date"></span><br>
                <h4 class="title-left">Return Date : </h4><span class="details-right return-date"></span><br>
                <h4 class="title-left">Contact Details : </h4><span class="details-right contact-details"></span><br>
                <h4 class="title-left">Book Status : </h4><span class="details-right book-status"></span><br>
                <h4 class="title-left">Publisher : </h4><span class="details-right publisher"></span>
                <br><br>
                 
                <form action="ReturnBook" method="post">
                	<input type = "hidden" value = "" id="testing1" name = "borrowed-book-id-1">
                	<button type = "submit" class="book-button" onclick="alert('Book Returned!')">Return Book</button>
                </form>
                <form action="RequestExtension" method="post">
                	<input type = "hidden" value = "" name = "borrowed-book-id-2" id="testing2">
                	<button type = "submit" class="book-button" onclick="alert('Book Returned!')">Request Delay</button>
                </form>
                
               <!-- 
                <a href="<%=request.getContextPath()%>___________?borrowed_book_id=<c:out value='${borrowed_book_id}' />">
                	<button class="book-button"  type="button" onclick="alert('Book Returned!')">Return Book</button>
                </a>
                  <a href="<%=request.getContextPath()%>/RequestExtension?borrowed_book_id= <c:out value="${borrowedbook.book_id}" />">
                	<button class="book-button"  type="button" onclick="alert('Requested for 15 more days to return the book!')">Request Delay</button>
            	</a> 
            	-->
            </div>



            <div class = "addcard" style="position:fixed; z-index: 4;">
                <button class = "addbutton" onclick="addBookDetails()">
                    <span class="addfront">+</span> 
                </button>
            </div>

            <div class="book-details">
                <div class = "book-preview-header">
                    <h1 class = "book-name">Publish a Book</h1> 
                    <button class= "add-book-preview-details" onclick="closeBookDetails()">x</button>
                </div><br>
                               
                <form action = "AddBook" class="add-book-form" method = "post">
                    <input type="text" name="book-name" placeholder="Enter Book Name" required>
                    <input type="text"  name="book-author" placeholder=" Book Author" required>
                    <input type="text"  name="book-edition" placeholder=" Book Edition" required>
                    <input type="number"  name="book-price" placeholder="Price in $" required>
                    <input type="text"  name="book-desc" placeholder="Description" >
                    <input type="text"  name="book-year" placeholder="PublishedYear" >
                    <button class="publish-button"  type="submit" onclick="alert('Book Published')">Publish!</button>
                </form>

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
</script>
</html>