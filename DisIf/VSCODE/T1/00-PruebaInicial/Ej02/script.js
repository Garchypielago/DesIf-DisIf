function Redirect(url) {
        window.location.href = url;
}

function Alerta(url) {
    var busq = document.getElementById("txtBuscarCat").value;
    if (busq == "") {
        window.location.href = url;
    }
}

function limpiar(bttId){
    document.getElementById(bttId).value = "";
}