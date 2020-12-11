function imprimer(test) {
    var printContents = document.getElementById(test).innerHTML;
    var originalContents = document.body.innerHTML;
    document.body.innerHTML = printContents;
    window.print();
    document.body.innerHTML = originalContents;
}
$('document').ready(function () {

    $('table #editButton').on('click',function (event) {
        $('#editModal').modal();
    });
});