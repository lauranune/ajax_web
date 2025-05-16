function nuevoUser(){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("newUserButton").innerHTML= 
    }
    xhttp.open("GET", "ajax_info.txt", true);
    xhttp.send();
}