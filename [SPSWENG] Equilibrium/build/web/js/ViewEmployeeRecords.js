$(document).ready(function () {
    var currPage = "#personal";
    var nextPage;
    $(".pages").hide();
    $("#personal").show();

    $("#options").change(function () {
        nextPage = "#" + $("#options").find(":selected").val();
        $(currPage).hide();
        $(nextPage).show();
        currPage = nextPage;
    });
});