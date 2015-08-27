<%@page import="Models.modelEmployee"%>
<html>
    <head>
        <link rel="shortcut icon" href="img/eq logo.ico">
        <link rel = "stylesheet" type="text/css" href= "css/FileMemo.css"/>
        <link rel="stylesheet" type="text/css" media="all" href="css/Homepage-HrHead.css"/>
        <script src="js/jquery-1.11.2.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css"/>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/jquery-ui.js"></script>
        <title> Memo Form - EQuilibrium </title>
        <style>

        </style>
        <script>
            
        </script>
        <script>
            $(document).ready(function () {
                $('#illnessDiv').hide();
                $('select[name=listTypeMedical]').change(function () {
                    if ($('select[name=listTypeMedical]').find(':selected').val() === "Illness")
                    {
                        $('#illnessDiv').show();
                        $('#examDiv').hide();
                    }
                    else{
                        $('#examDiv').show();
                        $('#illnessDiv').hide();
                    }
                    });
                
                var softmemowrapper = $('table[name=softmemo]');

                $(document).on("click", ".addsoftmemo", function (e) {
                    e.preventDefault();
                    $(softmemowrapper).append(
                            '<tr><td><input type="file" name="filename" placeholder="File Name here" /></td>'
                            + '<td><button class="removesoftmemo" align="center">-</button></td></tr>'
                            );
                });

                $(document).on("click", ".removesoftmemo", function (e) {
                    e.preventDefault();
                    var c = confirm("Do you want to remove this row of data?");
                    if (c) {
                        $(this).parent().parent().remove();
                    }
                });
            });
        </script>
        <script>
            <%

                String error = (String) session.getAttribute("error");

                if (error == null) {
                    error = "";
                    System.out.println("error is null");
                }


            %>


            $(document).ready(function () {
                var sugg = [];
                var search;
                $("#search").keyup(function () {
                    search = $("#search").val();
                    search = search.trim();
                    console.log("HEREE");
                    $.get('AutoCompleteServlet', {keyword: search}, function (responseText) {
                        console.log(responseText);
                        sugg = responseText.split("\n");
                        console.log(sugg);
                        $("#search").autocomplete({
                            source: sugg
                        });
                    });
                });
            });
        </script>
    </head>
    <body bgcolor=#E8E8E8>
        <%           modelEmployee m = (modelEmployee) session.getAttribute("employee");

            if (m.getEmployeeType().equals("Hr Head")) {
        %>
        <DIV class= "nav">
            <form method="GET" action="SearchEmployee">
                <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
                <ul>
                    <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                    <li><a href= "changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                    <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li> 
                    <li><a href= "generateReport"><span class="selectText">Generate Report</span></a></li>
                    <li><a href= "EmployeeData.jsp"><span class="selectText">Add Employee Record</span></a></li>
                    <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search Employee Records"/></li>
                    <li><a href="Homepage-HrHead.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
                </ul>
            </form>
        </DIV>
        <%
        } else if (m.getEmployeeType().equals("Hr Employee")) {

        %>
        <DIV class= "nav">
            <form method="GET" action="SearchEmployee">
                <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
                <ul>
                    <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                    <li><a href= "changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                    <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li> 
                    <li><a href= "generateReport.jsp"><span class="selectText">Generate Report</span></a></li>
                    <li><a href= "EmployeeData.jsp"><span class="selectText">Add Employee Record</span></a></li>
                    <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search Employee Records"/></li>
                    <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
                </ul>
            </form>
        </DIV>
        <%        } else if (m.getEmployeeType().equals("Senior Manager")) {

        %>
        <DIV class= "nav">
            <form method="GET" action="SearchEmployee">
                <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
                <ul>
                    <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                    <li><a href="changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                    <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li>
                    <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search Employee Records"/></li>
                    <li><a href="Homepage-SManager.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
                </ul>
            </form>
        </DIV>
        <%        } else if (m.getEmployeeType().equals("Manager")) {
        %>
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href="changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li>
                <li><a href="Homepage-Manager.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </DIV>
        <%
        } else if (m.getEmployeeType().equals("Employee")) {
        %>
        <div class= "nav">
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href="changePassword.jsp"><span class="selectText">Change Password</span></a></li>

                <li><a href="Homepage-Employee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </div>
        <%
            }
        %>        

        <div class = "memoForm">
            <br/><br/><br/>
            <div class= "contentText"><h3>Add Medical Files</h3></div>
            <div class = "contentText">

                <form action="SaveMemo" method="POST" enctype="multipart/form-data">
                    Select type : <!--This should be either Physical Exam or Previous Illness-->

                    <select required name="listTypeMedical">
                        <option value="PhyExam">Physical Exam</option>
                        <option value="Illness">Previous Illnesses</option>

<<<<<<< HEAD
                    </select>

                <div id ="illnessDiv">
                    <br/>
                    Findings: <input type="text" maxlength="45" name="sickname" placeholder="ex. Measles"/>
                    Age: <input type="number" min="0" max="999" step="1" name="sickage" placeholder="ex. 14"/>
                </div>
                <div id="examDiv">
                    <br/>
                    Findings: <input type="text" maxlength="45" name="sickname" placeholder="ex. Measles"/>
                    Date: <input type="date" name="dateTaken" placeholder="ex. January 2, 2010"/><br/>
                    Remarks: <textarea rows="7" cols = "70" name="memoNote" class="memoText" placeholder="Enter text here..." required ></textarea>
                </div>
                </div>
                <input type="submit" class="submitButton"/> 

            </form>
=======
                    </select></div>

            <div id ="illnessDiv">
                Findings: <input type="text" maxlength="45" name="sickname" placeholder="ex. Measles"/>
                Age: <input type="number" min="0" max="999" step="1" name="sickage" placeholder="ex. 14"/>
            </div>
            <div id="examDiv">
                Findings: <input type="text" maxlength="45" name="sickname" placeholder="ex. Measles"/>
                Date: <input type="date" name="dateTaken" placeholder="ex. January 2, 2010"/><br/>
                Remarks: <textarea rows="7" cols = "70" name="memoNote" class="memoText" placeholder="Enter text here..." required ></textarea>
            </div>

            <br/><input type="submit" class="submitButton"/> 

        </form>
>>>>>>> origin/DEV5
        <%=error%>     


    </div>


    <DIV class = "pageBottom"><hr width ="75%"/></br> EQUILIBRIUM INTERTRADE CORP.</div>
</body>

</html>