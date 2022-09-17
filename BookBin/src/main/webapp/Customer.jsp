
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
    <link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css"/>
    <script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>Customer</title>
    <script src="JS/Customer.js" defer></script>
    <link rel = "stylesheet" href = "css/Customer.css" />
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
                    <a href = "<%=request.getContextPath()%>/CustomerServlet" class = "db" style = "background-color: #03a9f4;" onclick="showDashboard()">
                        <span class = "icon"><i class="fa fa-home" aria-hidden="true" title="Dashboard"></i></span>
                        <span class = "title">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href = "<%=request.getContextPath()%>/Books">
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
                    <a class="ct" onclick="showCart()">
                        <span class = "icon"><i class="fa fa-shopping-cart" aria-hidden="true" title="Cart"></i></span>
                        <span class="items-number"></span>
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
                        <div class = "numbers"> ${userscount} </div>
                        <div class  ="cardName">Users</div>
                    </div>
                    
                </div>
    
                <div class = "card">
                    <div>
                        <div class = "numbers"> ${bookscount}</div>
                        <div class  ="cardName">Books Available</div>
                    </div>
                   
                </div>
    
              <div class = "card" id = "urgent-card">
                    <div>
                        <div class = "numbers" id = "urgent-count">${transcount}</div>
                        <div class  ="cardName">Requests Received</div>
                    </div>
                    
                </div>
    
                
            </div>
            
            <div class="dashboard-view">
            <div class = "container">
                <br>
                <h3 class = "title">Available Books</h3>
                
                    <!-- Swiper -->
                <div class="swiper mySwiper cards-container" style="position: inherit; z-index: 1;">
                    <div class="swiper-wrapper">
                    
                    
                    <!--Card 1-->
                    <div class="swiper-slide">
                        <div class = "cards" data-name = "p-1">
                            <div class =  "image">
                                <img src = "Images/Complete_Reference.png">
                            </div>
                            <h1 class = "cards-title" style = "font-size: 21px;">The Complete JAVA Reference</h1> <br>
                            <div class = "price">
                                $85.00                
                            </div>
                        </div>
                    </div>
                    
                    <!--Card 2-->
                    <div class="swiper-slide">
                        <div class = "cards" data-name = "p-2">
                            <div class =  "image">
                                <img src = "Images/Advanced_JAVA.jpg">
                            </div>
                            <h1 class = "cards-title">Advanced JAVA</h1> <br>
                            <div class = "price">
                                $45.00                
                            </div>
                        </div>
                    </div>

                    <!--Card 3-->
                    <div class="swiper-slide">
                        <div class = "cards" data-name = "p-3">
                            <div class =  "image">
                                <img src = "Images/Core_JAVA.jpg">
                            </div>
                            <h1 class = "cards-title">Core JAVA</h1> <br>
                            
                            <div class = "price">
                                    $125.00                
                            </div>
                        </div>
                    </div>

                    <!--Card 4-->
                    <div class="swiper-slide"> 
                        <div class = "cards" data-name = "p-4">
                            <div class =  "image">
                                <img src = "Images/JSP_SERVLETS.jpg">
                            </div>
                            <h1 class = "cards-title">Servlets and JSP's </h1><br>
                            <div class = "price">
                                $75.00                
                            </div> 
                        </div>
                    </div>

                    <!--Card 5-->
                    <div class="swiper-slide">
                        <div class = "cards" data-name = "p-5">
                            <div class =  "image">
                                <img src = "Images/JAVA.jpg">
                            </div>
                            <h1 class = "cards-title">Introduction to JAVA</h1> <br>
                            <div class = "price">
                                    $115.00                
                            </div>
                        </div>
                    </div>
                    
                    <!--Card 6-->
                    <div class="swiper-slide">
                        <div class = "cards" data-name = "p-6">
                            <div class =  "image">
                                <img src = "Images/CoreServlets.jpg">
                            </div>
                            <h1 class = "cards-title">Core Servlets</h1> <br>
                            <div class = "price">
                                    $80.00                
                            </div>
                        </div>
                    </div>
                    <!--Card 7-->
                    <div class="swiper-slide">
                        <div class = "cards" data-name = "p-7">
                            <div class =  "image">
                                <img src = "Images/Think_JAVA.jpeg">
                            </div>
                            <h1 class = "cards-title">Think JAVA</h1> <br>
                            <div class = "price">
                                    $30.00                
                            </div>
                        </div>
                    </div>
                    <!--Card 8-->
                    <div class="swiper-slide">
                        <div class = "cards" data-name = "p-8">
                            <div class =  "image">
                                <img src = "Images/Java_Server.jpeg">
                            </div>
                            <h1 class = "cards-title" style = "font-size: 21px;">JAVA Server Programming</h1> <br>
                            <div class = "price">
                                    $250.00                
                            </div>
                        </div>
                    </div>
                    <!--Card 9-->
                    <div class="swiper-slide">
                        <div class = "cards" data-name = "p-9">
                            <div class =  "image">
                                <img src = "Images/JS.jpg">
                            </div>
                            <h1 class = "cards-title">JAVA Servlets</h1> <br>
                            <div class = "price">
                                    $180.00                
                            </div>
                        </div>
                    </div>
                    </div>
                    <div class="swiper-pagination"></div>
                </div>


                <!--Cards Preview--> 
                <div class = "cards-preview" style="position: absolute; z-index: 10;">

                    <!--Card 1 Preview-->
                    <section class="preview" data-target="p-1">
                        <i class="fas fa-times"></i>
                        <img class ="card-Img" src = "Images/Complete_Reference.png">
                        <h3 class = "card-title" name = "title" style = "font-size: 24px;">The Complete JAVA Reference</h3>
                        <table style = "margin-left: 15px;">
                            <tbody>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Author : </td>
                                    <td style = "font-size: 17px; padding: 1px;">&nbsp;  K RamaSwamy</td>
                                </tr>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Editon : </td>
                                    <td  style = "font-size: 17px; padding: 1px;">2e</td>
                                </tr>
                            </tbody>
                        </table>
                        <p>
                            This Book involves complete overview of core JAVA and 
                            a breif introduction to JAVA EE.
                        </p>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        <span>( 250 )</span>
                        </div>
                        <div class="card-price">$85.00 </div>
                        <div class="buttons">
                            
                            <a href="#" class="add-to-cart">Add to Cart</a>
                        </div><br>
                    </section>


                    <!--Card 2 Preview-->
                    <div class="preview" data-target="p-2">
                        <i class="fas fa-times"></i>
                        <img class ="card-Img" src = "Images/Advanced_JAVA.jpg">
                        <h3 class = "card-title">Advanced JAVA</h3>
                        <table style = "margin-left: 15px;">
                            <tbody>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Author : </td>
                                    <td style = "font-size: 17px; padding: 1px;">&nbsp;  R Sundar Rao</td>
                                </tr>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Editon : </td>
                                    <td  style = "font-size: 17px; padding: 1px;">6e</td>
                                </tr>
                            </tbody>
                        </table>
                        <p>
                            This Book involves Advanced Java topics and 
                            the reader is expected to be well-known with the basic JAVA.
                        </p>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        <span>( 425 )</span>
                        </div>
                        <div class="card-price">$45.00</div>
                        <div class="buttons">
                           
                            <a href="#" class="add-to-cart">Add to cart</a>
                        </div><br>
                    </div>



                    <!--Card 3 Preview-->
                    <div class="preview" data-target="p-3">
                        <i class="fas fa-times"></i>
                        <img class ="card-Img"  src = "Images/Core_JAVA.jpg">
                        <h3 class = "card-title">Core JAVA</h3>
                        <table style = "margin-left: 15px;">
                            <tbody>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Author : </td>
                                    <td style = "font-size: 17px; padding: 1px;">&nbsp; L RamaKrishna</td>
                                </tr>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Editon : </td>
                                    <td  style = "font-size: 17px; padding: 1px;">4e</td>
                                </tr>
                            </tbody>
                        </table>
                        <p>
                           Description of JAVA from scratch and 
                            the reader belonging to any field could begin with ease.
                        </p>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                        
                        <span>( 345 )</span>
                        </div>
                        <div class="card-price"> $125.00 </div>
                        <div class="buttons">
                           
                            <a href="#" class="add-to-cart">Add to Cart</a>
                        </div><br>
                    </div>



                    <!--Card 4 Preview-->
                    <div class="preview" data-target="p-4">
                        <i class="fas fa-times"></i>
                        <img class ="card-Img"  src = "Images/JSP_SERVLETS.jpg">
                        <h3 class = "card-title">Servlets and JSP's</h3>
                        <table style = "margin-left: 15px;">
                            <tbody>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Author : </td>
                                    <td style = "font-size: 17px; padding: 1px;">&nbsp;  Jain Sharma</td>
                                </tr>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Editon : </td>
                                    <td  style = "font-size: 17px; padding: 1px;">3e</td>
                                </tr>
                            </tbody>
                        </table>
                        <p>
                            Complete overview of JAVA EE and 
                           the reader is expected to be familiar with basic html and css.
                        </p>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                        
                            <span>( 241 )</span>
                        </div>
                        <div class="card-price">$75.00</div>
                        <div class="buttons">
                            <a href="#" class="buy">Buy now</a>
                            <a href="#" class="add-to-cart">Add to Cart</a>
                        </div><br>
                    </div>



                    <!--Card 5 Preview-->
                    <div class="preview" data-target="p-5">
                        <i class="fas fa-times"></i>
                        <img class ="card-Img"  src = "Images/JAVA.jpg">
                        <h3 class = "card-title">Introduction to JAVA</h3>
                        <table style = "margin-left: 15px;">
                            <tbody>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Author : </td>
                                    <td style = "font-size: 17px; padding: 1px;">&nbsp;  Manish Agarwal</td>
                                </tr>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Editon : </td>
                                    <td  style = "font-size: 17px; padding: 1px;">2e</td>
                                </tr>
                            </tbody>
                        </table>
                        <p>
                          One of the Finest books a JAVA programmer could begin with.
                          Every topic is taken through the attention of the reader in detail.
                        </p>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        <span>( 410 )</span>
                        </div>
                        <div class="card-price">$115.00 </div>
                        <div class="buttons">
                           
                            <a href="#" class="add-to-cart">Add to Cart</a>
                        </div><br>
                    </div>




                    <!--Card 6 Preview-->
                    <div class="preview" data-target="p-6">
                        <i class="fas fa-times"></i>
                        <img class ="card-Img"  src = "Images/CoreServlets.jpg">
                        <h3 class = "card-title">Core Servlets</h3>
                        <table style = "margin-left: 15px;">
                            <tbody>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Author : </td>
                                    <td style = "font-size: 17px; padding: 1px;">&nbsp;  Pranav Thakur</td>
                                </tr>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Editon : </td>
                                    <td  style = "font-size: 17px; padding: 1px;">5e</td>
                                </tr>
                            </tbody>
                        </table>
                        <p>
                            This Book involves complete overview of Servlets and 
                            servlet filters.
                        </p>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>                           
                            <span>( 190 )</span>
                        </div>
                        <div class="card-price"> $80.00 </div>
                        <div class="buttons">
                           
                            <a href="#" class="add-to-cart">Add to Cart</a>
                        </div><br>
                    </div>


                     <!--Card 7 Preview-->
                     <div class="preview" data-target="p-7">
                        <i class="fas fa-times"></i>
                        <img class ="card-Img"  src = "Images/Think_JAVA.jpeg">
                        <h3 class = "card-title">Think JAVA</h3>
                        <table style = "margin-left: 15px;">
                            <tbody>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Author : </td>
                                    <td style = "font-size: 17px; padding: 1px;">&nbsp;  K RamaSwamy</td>
                                </tr>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Editon : </td>
                                    <td  style = "font-size: 17px; padding: 1px;">2e</td>
                                </tr>
                            </tbody>
                        </table>
                        <p>
                            A different perspective or a different approach of JAVA problem
                            solving, it changes the problem approach of  the programmer.
                        </p>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        <span>( 302 )</span>
                        </div>
                        <div class="card-price">$30.00</div>
                        <div class="buttons">
                           <a href="#" class="add-to-cart">Add to Cart</a>
                        </div><br>
                    </div>


                     <!--Card 8 Preview-->
                     <div class="preview" data-target="p-8">
                        <i class="fas fa-times"></i>
                        <img class ="card-Img"  src = "Images/Java_Server.jpeg">
                        <h3 class = "card-title" style = "font-size: 24px;">JAVA Server Programming</h3>
                        <table style = "margin-left: 15px;">
                            <tbody>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Author : </td>
                                    <td style = "font-size: 17px; padding: 1px;">&nbsp;  K L Narsimham</td>
                                </tr>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Editon : </td>
                                    <td  style = "font-size: 17px; padding: 1px;">8e</td>
                                </tr>
                            </tbody>
                        </table>
                        <p>
                            Complete web development using java with Servlets and JSP's
                            at the frontend and mysql database at the backend.
                        </p>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        <span>( 298 )</span>
                        </div>
                        <div class="card-price"> $250.00  </div>
                        <div class="buttons">
                            
                            <a href="#" class="add-to-cart">Add to Cart</a>
                        </div><br>
                    </div>


                     <!--Card 9 Preview-->
                     <div class="preview" data-target="p-9">
                        <i class="fas fa-times"></i>
                        <img class ="card-Img"  src = "Images/JS.jpg">
                        <h3 class = "card-title">JAVA Servlets</h3>
                        <table style = "margin-left: 15px;">
                            <tbody>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Author : </td>
                                    <td style = "font-size: 17px; padding: 1px;">&nbsp;  R Gurumurthy</td>
                                </tr>
                                <tr>
                                    <td style = "font-size: 20px; font-weight: bolder;">Editon : </td>
                                    <td  style = "font-size: 17px; padding: 1px;">3e</td>
                                </tr>
                            </tbody>
                        </table>
                        <p>
                            Complete overview of JAVA Servlets and 
                            with a parallel take through  of core JAVA.
                        </p>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                        <span>( 345 )</span>
                        </div>
                        <div class="card-price"> $180.00  </div>
                        <div class="buttons">
                            
                            <a href="#" class="add-to-cart">Add to Cart</a>
                        </div><br>
                    </div>










                    


                </div>
            </div>
			</div>
			
			<div class="cart-view">
                <!--           CART            --> 
                <div class = "cart">
                    <label class ="cart-header">
                        <h3 class = "cart-title">My Cart</h3>  
                        <h1><i class="fa fa-shopping-cart    cart-header-icon" aria-hidden="true"></i></h1>
                    </label>
                    <br>
	                    <div class = "cart-content">
	                        <span class="empty-cart">
	                            <h2>Empty Cart...</h2>  
	                            <p>Click <b>Shop More</b> to see all available books.</p>
	                        </span>
	                        <!-- <div class = "cart-box">
	                            <img  class = "cart-img" src = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Gfp-missouri-st-louis-clubhouse-pond-and-scenery.jpg/1199px-Gfp-missouri-st-louis-clubhouse-pond-and-scenery.jpg">
	                            <div class = "cart-detail-box">
	                                <div class = "cart-product-title">Earbuds</div>
	                                <div class = "cart-price">$25.00</div>
	                                <input type = "number" value = "1" class = "cart-quantity">
                            		<input type = "text" placeholder = "Number of Days to request" class = "days">
	                            </div>
	                            <i class="fa fa-trash cart-remove" aria-hidden="true"></i>
	                        </div> -->
	                    </div>
	                    <div class = "total">
	                        <div class = "total-title">Total</div>
	                        <div class = "total-price">$0</div>
	                    </div>
						<form action ="Cart" method="post" id="form1">
								<input type="hidden" class="write-title" name="title-data">
								<input type = "hidden" class = "requestdays" name = "request-days" >
	                    		<button type = "submit" class = "btn-buy">Make Request</button>
                    			<button type = "button" class = "btn-buy" onclick="showDashboard()">Shop More</button>
						</form>
	 
	            </div>
            </div>

            <!--         CART ACTIVATION          -->
            <div class = "cart3" style="display: none;">
                <i class="fas fa-times" id = "close-cart"></i>
            </div>
			
        </div>
    </div>

        
    <!-- Initialize Swiper -->
    <script>
        var swiper = new Swiper(".mySwiper", {
        slidesPerView: 3,
        spaceBetween: 30,
        pagination: {
            el: ".swiper-pagination",
            clickable: true,
        },
        });
    </script>
    


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