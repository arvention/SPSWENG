function submitLeave() {
    $.ajax({
        type: "POST",
        url: "LeaveSubmit",
        data: $("#leave_form").serialize(),
        success: function(html) {
            if (html)
            {
                $("#leaveMessage").html(html);
            }
            else {
                goNext();
            }
        }
    });
    return false;
}

function goNext() {
    window.location.href = "LeaveSuccess.jsp";
}

$(document).ready(function() {
    var date = new Date();
    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    //initialize dates to today
    if (day < 10)
        day = "0" + day;

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
        var dayCount = $("input[name='dayCount']").val();

        dayCount = Math.ceil(dayCount);

        dayCount--;
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