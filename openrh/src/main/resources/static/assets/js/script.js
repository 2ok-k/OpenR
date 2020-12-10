function imprimer(test) {
    var printContents = document.getElementById(test).innerHTML;
    var originalContents = document.body.innerHTML;
    document.body.innerHTML = printContents;
    window.print();
    document.body.innerHTML = originalContents;
}

var selectedRow = null
function onEdit(td) {
    selectedRow = td.parentElement.parentElement;
    document.getElementById("code").value = selectedRow.cells[0].innerHTML;
    document.getElementById("libelle").value = selectedRow.cells[1].innerHTML;
}