<%@page import="Database.Database"%>
<%@page import="Models.modelEmployee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel = "shortcut icon" href="img/eq logo.ico"/>

        <title>Leave Application - EQuilibrium</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/jquery-ui.min.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" 	media="all" href="css/LeaveForm.css" />

        <script src="js/jquery-1.11.2.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css"/>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script>
            $("#datepicker").datepicker({
                changeMonth: true,
                changeYear: true
            });</script>
        <script type = "text/javascript" src = "js/LeaveForm.js"></script>
        <script>
            $(document).ready(function() {
                var sugg = [];
                var search;


                $("#search").keyup(function() {
                    search = $("#search").val();
                    search = search.trim();
                    console.log("HEREE");
                    $.get('AutoCompleteServlet', {keyword: search}, function(responseText) {

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

    <body>
        <%
            HttpSession reqSession = request.getSession();

            modelEmployee m = (modelEmployee) session.getAttribute("employee");

            if (m.getEmployeeType().equals("Hr Head")) {
        %>
        <DIV class= "nav">
            <form method="GET" action="SearchEmployee">
                <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
                <ul>
                    <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                    <li><a href= "changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                    <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li> 
                    <li><a href= "GenerateReport.jsp"><span class="selectText">Generate Report</span></a></li>
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
                    <li><a href= "GenerateReport.jsp"><span class="selectText">Generate Report</span></a></li>
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

        <span class="titleText">Leave Form Application</span>
        <div align="center" class="content">
            <form onsubmit = "return submitLeave()" id = "leave_form"><br>
                <!--h4>ID Number: <input type="number" name = "idNum" required></h4-->
                <h4>Type of Leave:
                    <select name= "leaveType" required class = "form-input">
                        <option value= "Sick">Sick</option>
                        <option value= "Vacation">Vacation</option>
                        <option value= "Emergency">Emergency</option>
                        <option value= "Maternity">Maternity</option>
                        <option value= "Paternity">Paternity</option>
                        <option value= "Bereavement">Bereavement</option>
                    </select></h4>
                <h4>Days of Leave: <input class = "form-input" type="number" min="0.5" max="15" name = "dayCount" step="0.5" required></h4>
                <h4>
                    Inclusive Dates:<span style="margin-right: 10px"></span>
                    <input type= "date" class= "leaveDate" id="dp" name = "startDate" required/> 
                    until 
                    <input type= "date" class= "leaveDate" id="dp" name = "endDate" required/>
                </h4>

                <div id="leaveLeft"><b>Remaining leave requests left:</b> 
                    <%
                        Database db = Database.getInstance();
                        int vacLeave = 0, sickLeave = 0, patLeave = 0;

                        //if employee reaches 1 year of service.
                        if (db.getEmployeeYears(db.getEntryNum(m.getEmployeeID())) < 5) {
                            vacLeave = 7;
                            sickLeave = 5;
                            //paternity leave of 7 days for married employees.
                            if (db.getSpouse(db.getEntryNum(m.getEmployeeID())) != null) {
                                patLeave = 7;
                            }
                        } //if employee reaches 5 or more years of service
                        else if (db.getEmployeeYears(db.getEntryNum(m.getEmployeeID())) >= 5) {
                            vacLeave = 10;
                            sickLeave = 5;
                            //paternity leave of 7 days for married employees.
                            if (db.getSpouse(db.getEntryNum(m.getEmployeeID())) != null) {
                                patLeave = 7;
                            }
                        }
                        /*
                         Categorize the leave into 3(sick, vacation, paternity) and display them 
                         accordingly instead of displaying the overall number.
                         */
                        float remainingVacLeaves = vacLeave - db.getApprovedVac(m.getEmployeeID());
                        float remainingSickLeaves = sickLeave - db.getApprovedSick(m.getEmployeeID());
                        float remainingPatLeaves = patLeave - db.getApprovedPat(m.getEmployeeID());
                    %>
                    <br>
                    <b>Vacation:</b> <%=remainingVacLeaves%> days<br>
                    <b>Sick:</b> <%=remainingSickLeaves%> days<br>
                    <b>Paternity:</b> 
                    <%
                        if (db.getSpouse(db.getEntryNum(m.getEmployeeID())) == null) {
                    %>
                    n/a
                    <%
                    } else {
                    %>
                    <%=remainingPatLeaves%>
                    days
                    <%
    }
                    %><br>
                </div>
                <div id="leaveMessage" align = "center"></div>
                <input class= "submitButton" type="submit" value= "Submit" name= "dataSubmit"/>
            </form>
            <%                modelEmployee modelEmployee = (modelEmployee) reqSession.getAttribute("employee");
                if (modelEmployee.getEmployeeType().equalsIgnoreCase("Employee")) {
            %>
            <a href="Homepage-Employee.jsp"><button class="back" type="submit" name="bBack">Back</button></a>
            <%  } else if (modelEmployee.getEmployeeType().equalsIgnoreCase("HR Head")) {
            %>
            <a href="Homepage-HrHead.jsp"><button class="back" type="submit" name="bBack">Back</button></a>
            <%  } else if (modelEmployee.getEmployeeType().equalsIgnoreCase("HR Employee")) {
            %>
            <a href="Homepage-HrEmployee.jsp"><button class="back" type="submit" name="bBack">Back</button></a>
            <%  } else if (modelEmployee.getEmployeeType().equalsIgnoreCase("Manager")) {
            %>
            <a href="Homepage-Manager.jsp"><button class="back" type="submit" name="bBack">Back</button></a>
            <%}%>

            <DIV class="footer">
                <hr width="75%"/>
                EQUILIBRIUM INTERTRADE CORP.
            </DIV>
        </div>
        <!--div id = "leaveMessage">
           
        </div-->
    </body>
</html>

