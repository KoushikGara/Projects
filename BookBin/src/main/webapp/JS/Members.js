function showUserDetails(element)
{
	var p = element.parentNode.parentNode;
    
    document.getElementsByClassName("main-container")[0].style.filter = "blur(5px)";
    document.getElementsByClassName("main-container")[0].style['pointer-events'] = "none";
    document.getElementsByClassName("user-details")[0].style.display = "block";
 	//console.log(p.rowIndex);
    //pop-up user details
    var t = document.getElementsByClassName("pop-table")[0];
    rowindex = element.closest('tr').rowIndex;
    var d = t.getElementsByTagName("tr")[rowindex-1];
	console.log(p);
	console.log(t);
	console.log(rowindex);
    
    console.log(d.getElementsByTagName("td")[1].innerHTML);
    document.getElementsByClassName("user-name")[0].innerHTML = d.getElementsByTagName("td")[0].innerHTML;
    document.getElementsByClassName("user-id")[0].innerHTML = d.getElementsByTagName("td")[3].innerHTML;
    document.getElementsByClassName("email-id")[0].innerHTML = d.getElementsByTagName("td")[1].innerHTML;
    document.getElementsByClassName("mobile")[0].innerHTML = d.getElementsByTagName("td")[2].innerHTML;
    //document.getElementsByClassName("wallet-money")[0].innerHTML = d.getElementsByTagName("td")[3].innerHTML;
}
 
function closeUserDetails()
{
    document.getElementsByClassName("main-container")[0].style.filter = "blur(0px)";
    document.getElementsByClassName("main-container")[0].style['pointer-events'] = "auto";
    document.getElementsByClassName("user-details")[0].style.display = "none";
}
 
//Create PDf from HTML...
function CreatePDFfromHTML() {
    var HTML_Width = $(".pdf-content").width();
    var HTML_Height = $(".pdf-content").height();
    var top_left_margin = 15;
    var PDF_Width = HTML_Width + (top_left_margin * 2);
    var PDF_Height = (PDF_Width * 1.5) + (top_left_margin * 2);
    var canvas_image_width = HTML_Width;
    var canvas_image_height = HTML_Height;
    var username = document.getElementsByClassName("user-name")[0].innerHTML;
 
    var totalPDFPages = Math.ceil(HTML_Height / PDF_Height) - 1;
 
    html2canvas($(".pdf-content")[0]).then(function (canvas) {
        var imgData = canvas.toDataURL("image/jpeg", 1.0);
        var pdf = new jsPDF('p', 'pt', [PDF_Width, PDF_Height]);
        pdf.addImage(imgData, 'JPG', top_left_margin, top_left_margin, canvas_image_width, canvas_image_height);
        for (var i = 1; i <= totalPDFPages; i++) { 
            pdf.addPage(PDF_Width, PDF_Height);
            pdf.addImage(imgData, 'JPG', top_left_margin, -(PDF_Height*i)+(top_left_margin*4),canvas_image_width,canvas_image_height);
        }
        pdf.save(username);
    });
 
    
}