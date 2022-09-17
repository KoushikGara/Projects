
 
 
 
window.onload = function init(){

// pending card color
  var pendingBooks = document.getElementsByClassName("numbers")[2].innerHTML;
  const pendingCard = document.getElementById("pending-card");
  if(pendingBooks == 0)
    {
      pendingCard.style.background = "#fff";
      document.getElementsByClassName("cardName")[2].style.color = "#999";
    }
  else
    {
      pendingCard.style.background = "red";
      pendingCard.style.color = "white";
    }
    
	//checking table rows
	var x = document.getElementById("table1").rows.length;
	var y = document.getElementById("table2").rows.length;
	var z = document.getElementById("table3").rows.length;
	document.getElementsByClassName("numbers")[0].innerHTML = x-1;
	document.getElementsByClassName("numbers")[1].innerHTML = y-1;
	if(x <= 1)
	{
		document.getElementsByClassName("empty-table")[0].style.display = "block";
		document.getElementsByClassName("number-of-rows")[0].style.display = "none";
		document.getElementsByClassName("content-table")[0].style.display = "none";
	}
	else
	{
		document.getElementsByClassName("empty-table")[0].style.display = "none";
		document.getElementsByClassName("number-of-rows")[0].style.display = "block";
		document.getElementsByClassName("content-table")[0].style.display = "auto";
	}
	if(y <= 1)
	{
		document.getElementsByClassName("empty-table")[1].style.display = "block";
		document.getElementsByClassName("number-of-rows")[1].style.display = "none";
		document.getElementsByClassName("content-table")[1].style.display = "none";
	}
	else
	{
		document.getElementsByClassName("empty-table")[1].style.display = "none";
		document.getElementsByClassName("number-of-rows")[1].style.display = "block";
		document.getElementsByClassName("content-table")[1].style.display = "auto";
	}
	if(z <= 1)
	{
		document.getElementsByClassName("empty-table")[2].style.display = "block";
		document.getElementsByClassName("number-of-rows")[2].style.display = "none";
		document.getElementsByClassName("content-table")[2].style.display = "none";
	}
	else
	{
		document.getElementsByClassName("empty-table")[2].style.display = "none";
		document.getElementsByClassName("number-of-rows")[2].style.display = "block";
		document.getElementsByClassName("content-table")[2].style.display = "auto";
	}
	
	//Checking transaction status
	var flag = document.getElementsByClassName("flag")[0].innerHTML;
	console.log(flag);
	document.getElementsByClassName("error-msg")[0].style.display = "none";
	if(flag == "false")
	{
		document.getElementsByClassName("error-msg")[0].style.display = "block";
	}
}
 
 
function addBookDetails()
{
    document.getElementsByClassName("container")[0].style.filter = "blur(10px)";
    document.getElementsByClassName("cardBox")[0].style.filter = "blur(10px)";
    document.getElementsByClassName("book-details")[0].style.display = "block";
    document.getElementsByClassName("published-book-details")[0].style.display = "none";
    document.getElementsByClassName("borrowed-book-details")[0].style.display = "none";
    document.getElementsByClassName("container")[0].style['pointer-events'] = "none";
    document.getElementsByClassName("cardBox")[0].style['pointer-events'] = "none";
}
 
function showBookDetails(element)
{
  var p = element.parentNode.parentNode;
  document.getElementsByClassName("container")[0].style.filter = "blur(5px)";
  document.getElementsByClassName("cardBox")[0].style.filter = "blur(5px)";
  document.getElementsByClassName("book-details")[0].style.display = "none";
  document.getElementsByClassName("published-book-details")[0].style.display = "block";
  document.getElementsByClassName("borrowed-book-details")[0].style.display = "none";
  document.getElementsByClassName("container")[0].style['pointer-events'] = "none";
  document.getElementsByClassName("cardBox")[0].style['pointer-events'] = "none";

  //pop-up book details
  var t = document.getElementsByClassName("published-table")[0];
  var d = t.getElementsByTagName("tr")[p.rowIndex-1];
  var k = console.log();
  document.getElementsByClassName("book-name")[0].innerHTML = d.getElementsByTagName("td")[1].innerHTML;
  document.getElementsByClassName("book-id")[0].innerHTML = d.getElementsByTagName("td")[0].innerHTML;
  document.getElementsByClassName("author")[0].innerHTML = d.getElementsByTagName("td")[2].innerHTML;
  document.getElementsByClassName("price")[0].innerHTML = d.getElementsByTagName("td")[3].innerHTML;
  document.getElementsByClassName("book-edition")[0] = d.getElementsByTagName("td")[4].innerHTML;
  document.getElementsByClassName("book-status")[0].innerHTML = d.getElementsByTagName("td")[5].innerHTML;
  document.getElementsByClassName("book-desc")[0].innerHTML = d.getElementsByTagName("td")[6].innerHTML;
  document.getElementsByClassName("published-year")[0].innerHTML = d.getElementsByTagName("td")[7].innerHTML;
}
 
function showBookDetails1(element)
{
  var p = element.parentNode.parentNode;
  document.getElementsByClassName("container")[0].style.filter = "blur(5px)";
  document.getElementsByClassName("cardBox")[0].style.filter = "blur(5px)";
  document.getElementsByClassName("book-details")[0].style.display = "none";
  document.getElementsByClassName("published-book-details")[0].style.display = "none";
  document.getElementsByClassName("borrowed-book-details")[0].style.display = "block";
  document.getElementsByClassName("container")[0].style['pointer-events'] = "none";
  document.getElementsByClassName("cardBox")[0].style['pointer-events'] = "none";
 
  //pop-up book details
  var t = document.getElementsByClassName("borrowed-table")[0];
  var d = t.getElementsByTagName("tr")[p.rowIndex-1];
  document.getElementsByClassName("book-name")[1].innerHTML = d.getElementsByTagName("td")[1].innerHTML;
  document.getElementsByClassName("book-id")[1].innerHTML = d.getElementsByTagName("td")[0].innerHTML;
  document.getElementsByClassName("author")[1].innerHTML = d.getElementsByTagName("td")[2].innerHTML;
  document.getElementsByClassName("return-date")[0].innerHTML = d.getElementsByTagName("td")[3].innerHTML;
  
  //borrowedbook in hidden input
  document.getElementById("testing1").value = document.getElementsByClassName("book-id")[1].innerHTML;
  document.getElementById("testing2").value = document.getElementsByClassName("book-id")[1].innerHTML;
  }
 
function closeBookDetails()
{
    document.getElementsByClassName("container")[0].style.filter = "none";
    document.getElementsByClassName("cardBox")[0].style.filter = "none";
    document.getElementsByClassName("book-details")[0].style.display = "none";
    document.getElementsByClassName("published-book-details")[0].style.display = "none";
    document.getElementsByClassName("borrowed-book-details")[0].style.display = "none";
    document.getElementsByClassName("container")[0].style['pointer-events'] = "auto";
    document.getElementsByClassName("cardBox")[0].style['pointer-events'] = "auto";
}

 function showCart()
{
  document.getElementsByClassName("dashboard-view")[0].style.display = "none";
  document.getElementsByClassName("cart-view")[0].style.display = "block";
  document.getElementsByClassName("ct")[0].style.background = "#03a9f4";
  document.getElementsByClassName("db")[0].style.background = "#003147";
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
 
 

