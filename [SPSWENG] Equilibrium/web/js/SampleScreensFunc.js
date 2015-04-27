function submitData() {
    if (validateForm())
    {
        $.ajax({
            type: "POST",
            url: "EnterBioData",
            data: $(".data_form").serialize(),
            success: function(html) {
                if (html)
                {
                    $("#bioMessage").html(html);
                }
                else {
                    goNext();
                }
            }
        });
    }
    return false;
}

function validateForm() {
    //var educationInputs = document.getElementsByClassName("educationinput");
    // var infoInputs = document.getElementsByClassName("infoinput");
    var hasBlank = false;
    /*
     for(var i = 0; i < infoInputs.length; i++){
     if(infoInputs[i].value === "")
     {
     infoInputs[i]
     isInfoEmpty = true;
     }
     }*/
    $(".infoinput").each(function() {
        if ($(this).val().length === 0)
        {
            $(this).css("border", "2px rgba(230, 60, 60, .4) solid");
            hasBlank = true;
        }
        else
        {
            $(this).css("border", "1px rgb(200, 200, 200) solid");
        }
    });

    $(".educationinput").each(function() {
        if ($(this).val().length === 0)
        {
            $(this).css("border", "2px rgba(230, 60, 60, .4) solid");
            hasBlank = true;
        }
        else
        {
            $(this).css("border", "1px rgb(200, 200, 200) solid");
        }
    });

    /*
     for(var i = 0; i < educationInputs.length && !isEducationEmpty; i++){
     if(educationInputs[i].value === "")
     isEducationEmpty = true;
     }
     */
    if (hasBlank) {
        alert("Please fill up the all the required fields for the employee's biodata.\n(Personal Information and Education History)");
        return false;
    }
    else {
        return true;
    }
}

function goNext(){
    window.location.href = "BiodataFiled.jsp";
}

$(document).ready(function() {
    var siblingwrapper = $('table[name=siblings]');
    var childwrapper = $('table[name=children]');
    var tohide = $('.tohide');
    var elemwrapper = $('table[name=elementary]');
    var highschoolwrapper = $('table[name=highschool]');
    var collegewrapper = $('table[name=college]');
    var vocationalwrapper = $('table[name=vocational]');
    var masteralwrapper = $('table[name=masteral]');
    var otherswrapper = $('table[name=others]');
    var licensewrapper = $('table[name=license]');
    var employmentwrapper = $('table[name=employment]');
    var criminaloffensewrapper = $('table[name=criminaloffense]');
    var miscfilewrapper = $('table[name=miscellaneous]');

    $(tohide).hide();
    $('select[name=civilstatus]').change(function() {
        if ($('select[name=civilstatus]').find(':selected').val() === "Single")
            $(tohide).hide();
        else
            $(tohide).show();
    });

    $('select[name=convicted]').change(function() {
        if ($('select[name=convicted]').find(':selected').val() === "Yes") {
            $('input[name=offensename]').prop("required", true);
            $('input[name=offensedate]').prop("required", true);
            $(tohide).show();
        }
        else {
            $('input[name=offensename]').prop("required", false);
            $('input[name=offensedate]').prop("required", false);
            $(tohide).hide();
        }
    });

    $(document).on("click", ".addsibling", function(e) {
        e.preventDefault();

        $(siblingwrapper).append(
                '<tr><td><input type="text" maxlength = 45 name="siblingname" placeholder="ex. Virma Lopez"  /></td>'
                + '<td><input type="number" min = "0" max = "999" step = "1" name="siblingage" placeholder="ex. 14"  /></td>'
                + '<td><input type="text" maxlength = 20 name="siblingoccupation" placeholder="ex. Student"  /></td>'
                + '<td><input type="text" maxlength = 100 name="siblinglocation" placeholder="ex. Binan, Laguna"  /></td>'
                + '<td><button class="removesibling">-</button></td></tr>'
                );
    });

    $(document).on("click", ".removesibling", function(e) {
        e.preventDefault();
        var c = confirm("Do you want to remove this row of data?");
        if (c) {
            $(this).parent().parent().remove();
        }
    });

    $(document).on("click", ".addchild", function(e) {
        e.preventDefault();

        $(childwrapper).append(
                '<tr><td><input type="text" maxlength = 45 name="childrenname" placeholder="Name of Child" /></td>'
                + '<td><input type="number" min = "0" max = "999" step = "1" name="childrenage" placeholder="Age" /></td>'
                + '<td><input type="text" maxlength = 20 name="childrenoccupation" placeholder="Occupation of Child" /></td>'
                + '<td><input type="text" maxlength = 100 name="childrenlocation" placeholder="School/Location" /></td>'
                + '<td><button class="removechild">-</button></td></tr>'
                );
    });

    $(document).on("click", ".removechild", function(e) {
        e.preventDefault();
        var c = confirm("Do you want to remove this row of data?");
        if (c) {
            $(this).parent().parent().remove();
        }
    });

    $(document).on("click", ".addelem", function(e) {
        e.preventDefault();

        $(elemwrapper).append(
                '<tr><td><input type="text" maxlength = 45 name="elemschool" placeholder="ex. Don Bosco School" required /></td>'
                + '<td><input type="number" min = "1000" max = "9999" step = "1" name="elemfrom" placeholder="ex. 2000" required /></td>'
                + '<td><input type="number" min = "1000" max = "9999" step = "1" name="elemto" placeholder="ex. 2012" required /></td>'
                + '<td><input type="text" maxlength = 45 name="elemawards" placeholder="ex. Perfect Attendance" /></td>'
                + '<td><button class="removeelem">-</button></td></tr>'
                );
    });

    $(document).on("click", ".removeelem", function(e) {
        e.preventDefault();
        var c = confirm("Do you want to remove this row of data?");
        if (c) {
            $(this).parent().parent().remove();
        }
    });

    $(document).on("click", ".addhighschool", function(e) {
        e.preventDefault();

        $(highschoolwrapper).append(
                '<tr><td><input type="text" maxlength = 45 name="highschool" placeholder="ex. Don Bosco School" required /></td>'
                + '<td><input type="number" min = "1000" max = "9999" step = "1" name="highschoolfrom" placeholder="ex. 2000" required /></td>'
                + '<td><input type="number" min = "1000" max = "9999" step = "1" name="highschooltoelemto" placeholder="ex. 2012" required /></td>'
                + '<td><input type="text" maxlength = 45 name="highschoolawards" placeholder="ex. Perfect Attendance" /></td>'
                + '<td><button class="removehighschool">-</button></td></tr>'
                );
    });

    $(document).on("click", ".removehighschool", function(e) {
        e.preventDefault();

        $(this).parent().parent().remove();
    });

    $(document).on("click", ".addcollege", function(e) {
        e.preventDefault();

        $(collegewrapper).append(
                '<tr><td><input type="text" maxlength = 45 name="college" placeholder="ex. Don Bosco School" required /></td>'
                + '<td><input type="number" min = "1000" max = "9999" step = "1" name="collegefrom" placeholder="ex. 2000" required /></td>'
                + '<td><input type="number" min = "1000" max = "9999" step = "1" name="collegeto" placeholder="ex. 2012" required /></td>'
                + '<td><input type="text" maxlength = 45 name="collegewards" placeholder="ex. Perfect Attendance" /></td>'
                + '<td><button class="removecollege">-</button></td></tr>'
                );
    });

    $(document).on("click", ".removecollege", function(e) {
        e.preventDefault();
        var c = confirm("Do you want to remove this row of data?");
        if (c) {
            $(this).parent().parent().remove();
        }
    });

    $(document).on("click", ".addvocational", function(e) {
        e.preventDefault();

        $(vocationalwrapper).append(
                '<tr><td><input type="text" maxlength = 45 name="vocationalschool" placeholder="ex. Don Bosco School" /></td>'
                + '<td><input type="number" min = "1000" max = "9999" step = "1" name="vocataionalschoolfrom" placeholder="ex. 2000"  /></td>'
                + '<td><input type="number" min = "1000" max = "9999" step = "1" name="vocationalschoolto" placeholder="ex. 2012"  /></td>'
                + '<td><input type="text" maxlength = 45 name="vocationalschoolawards" placeholder="ex. Perfect Attendance"  /></td>'
                + '<td><button class="removevocational">-</button></td></tr>'
                );
    });

    $(document).on("click", ".removevocational", function(e) {
        e.preventDefault();

        $(this).parent().parent().remove();
    });

    $(document).on("click", ".addmasteral", function(e) {
        e.preventDefault();

        $(masteralwrapper).append(
                '<tr><td><input type="text" maxlength = 45 name="masteralschool" placeholder="ex. Don Bosco School" /></td>'
                + '<td><input type="number" min = "1000" max = "9999" step = "1" name="masteralschoolfrom" placeholder="ex. 2000"  /></td>'
                + '<td><input type="number" min = "1000" max = "9999" step = "1" name="masteralschoolto" placeholder="ex. 2012"  /></td>'
                + '<td><input type="text" maxlength = 45 name="masteralschoolawards" placeholder="ex. Perfect Attendance"  /></td>'
                + '<td><button class="removemasteral">-</button></td></tr>'
                );
    });

    $(document).on("click", ".removemasteral", function(e) {
        e.preventDefault();
        var c = confirm("Do you want to remove this row of data?");
        if (c) {
            $(this).parent().parent().remove();
        }
    });

    $(document).on("click", ".addother", function(e) {
        e.preventDefault();

        $(otherswrapper).append(
                '<tr><td><input type="text" maxlength = 45 name="otherschool" placeholder="ex. Don Bosco School" /></td>'
                + '<td><input type="number" min = "1000" max = "9999" step = "1" name="otherfrom" placeholder="ex. 2000"  /></td>'
                + '<td><input type="number" min = "1000" max = "9999" step = "1" name="otherto" placeholder="ex. 2012"  /></td>'
                + '<td><input type="text" maxlength = 45 name="otherawards" placeholder="ex. Perfect Attendance" /></td>'
                + '<td><button class="removeother">-</button></td></tr>');
    });

    $(document).on("click", ".removeother", function(e) {
        e.preventDefault();
        var c = confirm("Do you want to remove this row of data?");
        if (c) {
            $(this).parent().parent().remove();
        }
    });

    $(document).on("click", ".addlicense", function(e) {
        e.preventDefault();

        $(licensewrapper).append(
                '<tr><td><input type="text" name="license" placeholder="License/Exam Name" /></td>'
                + '<td><input type="number" min = "0" max = "100" name="licensepercentage" placeholder="Percentage" /></td>'
                + '<td><button class="removelicense">-</button></td></tr>'
                );
    });

    $(document).on("click", ".removelicense", function(e) {
        e.preventDefault();
        var c = confirm("Do you want to remove this row of data?");
        if (c) {
            $(this).parent().parent().remove();
        }
    });

    $(document).on("click", ".addemployment", function(e) {
        e.preventDefault();

        $(employmentwrapper).append(
                '<tr>'
                + '<td><hr></td>'
                + '<td><hr></td>'
                + '<td><hr></td>'
                + '<td><hr></td>'
                + '</tr>'
                + '<tr>'
                + '	<tdclass="here">Job Title</td>'
                + '	<td>Date of Employment</td>'
                + '	<td>Starting Salary</td>'
                + '	<td>Ending Salary</td>'

                + '</tr>'
                + '<tr>'
                + '	<td><input type="text" maxlength = 20 name="jobtitle" placeholder="Job Title" /></td>'
                + '	<td><input type="date" name="jobemploydate" placeholder="Date of Employment" /></td>'
                + '	<td><input type="number" min = "0" max = "9999999" step = "1" name="jobbegsal" placeholder="Starting Salary" /></td>'
                + '	<td><input type="number" min = "0" max = "9999999" step = "1" name="jobendsal" placeholder="Ending Salary" /></td>'
                + '</tr>'
                + '<tr>'
                + '	<td></td>'
                + '	<td>Employer\'s Name</td>'
                + '	<td>Employer\'s Address</td>'
                + '	<td>Employer\'s Contact Number</td>'
                + '</tr>'
                + '<tr>'
                + '	<td></td>'
                + '	<td><input type="text" maxlength = 45 name="jobemployer" placeholder="Employer\'s Name" /></td>'
                + '	<td><input type="text" maxlength = 100 name="jobaddress" placeholder="Employer\'s Address" /></td>'
                + '	<td><input type="number" min = "0" max = "99999999999" step = "1" name="jobtelno" placeholder="Employer\'s Contact Number" /></td>'
                + '</tr>'
                + '<tr>'
                + '	<td></td>'
                + '	<td>Supervisor\'s Name</td>'
                + '	<td>Supervisor\'s Contact Number</td>'
                + '	<td>Reason For Leaving</td>'
                + '	<td></td>'
                + '</tr>'
                + '<tr>'
                + '	<td></td>'
                + '	<td><input type="text" maxlength = 45 name="jobsupname" placeholder="Supervisor Name" /></td>'
                + '	<td><input type="number" min = "0" max = "99999999999" step = "1" name="jobsupno" placeholder="Supervisor Contact Number" /></td>'
                + '	<td><input type="text" maxlength = 256 name="jobreason" placeholder="Reason for Leaving" /></td>'
                + '	<td><button class="removeemployment">-</button></td>'
                + '</tr>'
                );
    });

    $(document).on("click", ".removeemployment", function(e) {
        var toremove = $(this).parent().parent();
        e.preventDefault();

        //$(toremove).nextUntil("input[name=jobreason]").remove();
        var c = confirm("Do you want to remove this row of data?");
        if (c) {
            $(toremove).prev().prev().prev().prev().prev().prev().remove();
            $(toremove).prev().prev().prev().prev().prev().remove();
            $(toremove).prev().prev().prev().prev().remove();
            $(toremove).prev().prev().prev().remove();
            $(toremove).prev().prev().remove();
            $(toremove).prev().remove();
            $(toremove).remove();
        }
    });

    $(document).on("click", ".addcriminaloffense", function(e) {
        e.preventDefault();

        $(criminaloffensewrapper).append(
                '<tr><td><input type="text" maxlength = 45 name="offensename" placeholder="Criminal Offense" /></td>'
                + '<td><input type="date" name="offensedate" placeholder="Date of Offense" /></td>'
                + '<td><input type="text" maxlength = 100 name="offenseplace" placeholder="Place of Offense" /></td>'
                + '<td><button class="removecriminaloffense">-</button></td></tr>'
                );
    });
    $(document).on("click", ".removecriminaloffense", function(e) {
        e.preventDefault();
        var c = confirm("Do you want to remove this row of data?");
        if (c) {
            $(this).parent().parent().remove();
        }

    });

    $(document).on("click", ".addmiscfile", function(e) {
        e.preventDefault();
        $(miscfilewrapper).append(
                '<tr><td><input type="text" name="filename" placeholder="File Name here" /></td>'
                + '<td><button name="attachfile">Attach File</button></td>'
                + '<td><button class="removemiscfile">-</button></td></tr>'
                );
    });

    $(document).on("click", ".removemiscfile", function(e) {
        e.preventDefault();
        var c = confirm("Do you want to remove this row of data?");
        if (c) {
            $(this).parent().parent().remove();
        }
    });

    $('.tab-section').hide();
    $('.tabs a').bind('click', function(e) {
        $('.tabs a.current').removeClass('current');
        $('.tab-section:visible').hide();
        $(this.hash).show();
        $(this).addClass('current');
        e.preventDefault();
    }).filter(':first').click();

});
