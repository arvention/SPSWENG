$(document).ready(function () {
    $("#datepicker").datepicker({
        changeMonth: true,
        changeYear: true
    });

    var date = new Date();
    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    //initialize dates to today
    if (month < 10)
    {
        $("input[name='startDate']").val(year + "-0" + month + "-" + day);
        $("input[name='endDate']").val(year + "-0" + month + "-" + day);
    }
    else
    {
        $("input[name='startDate']").val(year + "-" + month + "-" + day);
        $("input[name='endDate']").val(year + "-0" + month + "-" + day);
    }

    $("input[name='dayCount']").change(function() {
        var tempDate = new Date($("input[name='startDate']").val());
        var dayCount = Math.floor($("input[name='dayCount']").val());

        tempDate.setDate(tempDate.getDate() + dayCount);

        var tempMonth;
        var tempDay;

        if (tempDate.getMonth() + 1 < 10)
            tempMonth = "-0" + (tempDate.getMonth() + 1);
        else
            tempMonth = "-" + (tempDate.getMonth() + 1);

        if (tempDate.getDate() < 10)
            tempDay = "-0" + tempDate.getDate();
        else
            tempDay = "-" + tempDate.getDate();

        $("input[name='endDate']").val(tempDate.getFullYear() + tempMonth + tempDay);
    });
});