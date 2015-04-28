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

    


        <title>Home - EQuilibrium</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/jquery-ui.min.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" 	media="all" href="css/LeaveForm.css" />
        <script src ="js/LeaveForm.js"></script>
        <script src="js/jquery-1.11.2.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script>
                    $("#datepicker").datepicker({
            changeMonth: true,
                    changeYear: true
            });</script>
        <script type = "text/javascript" src = "js/LeaveForm.js"></script>
    </head>

    <body>
        <%
            HttpSession reqSession = request.getSession();
        %>
        <div class= "nav">
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href= "changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href="Homepage-Employee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </div>
        
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
                        modelEmployee m = (modelEmployee) request.getSession().getAttribute("employee");
                        Database db = Database.getInstance();
                        int maxLeave = 15;
                        
                        float remainingLeaves = maxLeave - db.getApprovedLeaveCount(m.getEmployeeID());
                    %>
                    <%=remainingLeaves%> days
                </div>
                <div id="leaveMessage" align = "center"></div>
                <input class= "submitButton" type="submit" value= "Submit" name= "dataSubmit"/>
            </form>
            <%
                modelEmployee modelEmployee = (modelEmployee) reqSession.getAttribute("employee");
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
    </body>
</html>

