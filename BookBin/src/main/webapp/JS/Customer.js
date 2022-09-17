let preveiwContainer = document.querySelector('.cards-preview');
let previewBox = preveiwContainer.querySelectorAll('.preview');
 
document.querySelectorAll('.cards-container .cards').forEach(cards =>{
  cards.onclick = () =>{
    preveiwContainer.style.display = 'flex';
    let name = cards.getAttribute('data-name');
    previewBox.forEach(preview =>{
      let target = preview.getAttribute('data-target');
      if(name == target){
        preview.classList.add('active');
      }
    });
  };
});
 
previewBox.forEach(close =>{
  close.querySelector('.fa-times').onclick = () =>{
    close.classList.remove('active');
    preveiwContainer.style.display = 'none';
  };
});
 
 
window.onload = function urgentCardColor(){
  var urgentCount = document.getElementsByClassName("numbers")[2].innerHTML;
  const urgentCard = document.getElementById("urgent-card");
  if(urgentCount == 0)
    {
      urgentCard.style.background = "mintcream";
      document.getElementsByClassName("cardName")[2].innerHTML.style.color = "white";
    }
  else
    {
      urgentCard.style.background = "#fad1d0";     // #FFCCCB
     
    }
}
 
 
 
function openDropdown()
{
  if(document.getElementsByClassName("dropdown-menu")[0].style.opacity == 0){
    document.getElementsByClassName("dropdown-menu")[0].style.opacity = 1;
    document.getElementsByClassName("dropdown-menu")[0].style.transform = "translateY(0)"
  }
  else{
    document.getElementsByClassName("dropdown-menu")[0].style.opacity = 0;
    document.getElementsByClassName("dropdown-menu")[0].style.transform = "translateY(-10px)";
  }
}
 
 
function showDashboard()
{
  document.getElementsByClassName("dashboard-view")[0].style.display = "block";
  document.getElementsByClassName("cart-view")[0].style.display = "none";
  document.getElementsByClassName("db")[0].style.background = "#03a9f4";
  document.getElementsByClassName("ct")[0].style.background = "#003147";
}
 
function showCart()
{
  document.getElementsByClassName("dashboard-view")[0].style.display = "none";
  document.getElementsByClassName("cart-view")[0].style.display = "block";
  document.getElementsByClassName("ct")[0].style.background = "#03a9f4";
  document.getElementsByClassName("db")[0].style.background = "#003147";
}
 
 
let db = document.querySelector('.db');
let ct = document.querySelector('.ct');
 
db.onclick = () =>{
  ct.style.background = "#03a9f4";
}
 
 
 
 
  /*                    SCRIPT  FOR  CART*             */
 
let cart = document.querySelector('.cart');
 
//cart open
// cartIcon.onclick = () =>{
//     cart.classList.add("active");
// };
 
 
// //cart close
// closeCart.onclick = () =>{
//     cart.classList.remove("active");
// };
 
//Cart working
if(document.readyState == "loading"){
        document.addEventListener('DOMContentLoaded', ready)
}else{
    ready();
}
 
function ready(){
  var reomveCartButtons = document.getElementsByClassName('cart-remove')
  console.log(reomveCartButtons)
  for(var i = 0; i< reomveCartButtons.length; i++){
    var button = reomveCartButtons[i];
    button.addEventListener('click', removeCartItem);
 
  }
 
  var quantityInputs = document.getElementsByClassName("cart-quantity")
  for(var i = 0; i < quantityInputs.length; i++){
    var input = quantityInputs[i]
    input.addEventListener('change', quantityChanged);
  }
 
  var addCart = document.getElementsByClassName("add-to-cart")    //button class
  for(var i = 0; i < addCart.length; i++) {
    var button  = addCart[i];
    button.addEventListener('click', addCartClicked);
  }
  //Buy Button Work
  document.getElementsByClassName("btn-buy")[0].addEventListener('click',buyButtonClicked);
 
}
 
//Buy Button
function buyButtonClicked(){
  var total = document.getElementsByClassName("total-price")[0].innerHTML;
  
  if(total==="$0")
  alert("No item to request. Please add some items to cart.");
  else{
    alert('Your Order is Placed');
    var cartContent = document.getElementsByClassName("cart-content")[0];
    while(cartContent.hasChildNodes()){
      cartContent.removeChild(cartContent.firstChild);
    }
    updatetotal();
  }
}
 
 
//Remove items from cart
function removeCartItem(event){
    var buttonClicked  = event.target;
    buttonClicked.parentElement.remove();
    updatetotal();
}
 
//Quantity changes
function quantityChanged(event){
    var input = event.target;
    if(isNaN(input.value) || input.value <= 0){
        input.value = 1;
    }
 
    updatetotal();
}
 
 
//Add to Cart
 
function addCartClicked(event){
  var button  = event.target;
  var shopBooks = button.parentElement.parentElement;
  var title = shopBooks.getElementsByClassName("card-title")[0].innerText;   //title name on the card
  var price = shopBooks.getElementsByClassName("card-price")[0].innerText;
  var bookImg = shopBooks.getElementsByClassName("card-Img")[0].src;
  addBookToCart(title,price, bookImg);
  updatetotal();
  alert(title+" added to cart!");
}
 
function addBookToCart(title, price, bookImg){
  var cartShopBox = document.createElement("div");
  cartShopBox.classList.add("cart-box");
  var cartItems = document.getElementsByClassName("cart-content")[0];
  var cartItemsNames = cartItems.getElementsByClassName("cart-product-title");
  for(var i = 0; i < cartItemsNames.length; i++) {
    if(cartItemsNames[i].innerText == title){
      alert("You have already added this item to cart");
      return 0; 
    }  
  }
 
  var cartBoxContent = `  <img  class = "cart-img" src = "${bookImg}">
                            <div class = "cart-detail-box">
                            <div class = "cart-product-title" id="product-title">${title}</div>
                            <div class = "cart-price">${price}</div>
                            <input type = "number" value = "1" class = "cart-quantity">
                            <input type = "text" onfocusout = "updateDays()" placeholder = "Number of Days to request" id = "rdays" class = "days" required>
                        </div>
                        <i class="fa fa-trash cart-remove" aria-hidden="true"></i> `;
  cartShopBox.innerHTML = cartBoxContent;  
  cartItems.append(cartShopBox);
  
  document.getElementsByClassName("write-title")[0].value = title;
  
  cartShopBox
    .getElementsByClassName("cart-remove")[0]
    .addEventListener("click", removeCartItem);
  cartShopBox
    .getElementsByClassName("cart-quantity")[0]
    .addEventListener("change", quantityChanged);
}
 
 //Update requested days
 function updateDays(){
 var days = document.getElementsByClassName("days")[0].value;
 document.getElementsByClassName("requestdays")[0].value = days;
 }
 
//Update Total
function updatetotal(){
  var cartContent  = document.getElementsByClassName("cart-content")[0];
  var  cartBoxes = cartContent.getElementsByClassName("cart-box");
  var total = 0;
  var totalQuantity = 0;
  for(var i = 0; i<cartBoxes.length; i++){
    var cartBox = cartBoxes[i];
    var priceElement = cartBox.getElementsByClassName("cart-price")[0];
    var quantityElement = cartBox.getElementsByClassName("cart-quantity")[0];
    var price = parseFloat(priceElement.innerText.replace("$",""));
    var quantity = quantityElement.value;
    total = total + (price * quantity);
    totalQuantity = totalQuantity + parseInt(quantity);
  }
  total = Math.round(total *  100) /100;
  document.getElementsByClassName("total-price")[0].innerText = "$" + total;
  if(totalQuantity > 0){
    document.getElementsByClassName("items-number")[0].style.display = "block";
    document.getElementsByClassName("items-number")[0].innerText = totalQuantity;
    document.getElementsByClassName("empty-cart")[0].style.display = "none";
  }
  else{
    document.getElementsByClassName("items-number")[0].style.display = "none";
  } 
    
}
 