function imprimer(test) {
    var printContents = document.getElementById(test).innerHTML;
    var originalContents = document.body.innerHTML;
    document.body.innerHTML = printContents;
    window.print();
    document.body.innerHTML = originalContents;
}

function onEdit(td) {
    var table = document.getElementById("list").getElementsByTagName("tbody")[0];
    var newRow = table.insertRow(table.length);
    selectedRow = td.parentElement.parentElement;
    document.getElementById("code").value = selectedRow.cells[0].innerHTML;
    document.getElementById("code").value = selectedRow.cells[1].innerHTML;
}