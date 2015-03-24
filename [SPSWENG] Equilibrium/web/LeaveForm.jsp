<%@page import="Models.modelEmployee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel = "shortcut icon" href="eq logo.ico"/>
        <title>Leave Application</title>

        <!-- Bootstrap -->
        <!--
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/jquery-ui.min.css" rel="stylesheet">
        -->
        <link rel="stylesheet" type="text/css" 	media="all" href="css/LeaveForm.css" />

        <script src="js/jquery-1.11.2.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script>
                    $("#datepicker").datepicker({
            changeMonth: true;
                    changeYear: true;
            });        </script>
        <script type = "text/javascript" src = "js/LeaveForm.js"></script>
    </head>

    <body>
        <div class= "header">
            <h3>Leave Form Application</h3>
        </div>
        <div align="center" class="content">
            <form id = "leave_form" action = "LeaveSubmit" method = "post"><br>
                <!--h4>ID Number: <input type="number" name = "idNum" required></h4-->
                <h4>Type of Leave:
                    <select name= "leaveType" required>
                        <option value= "Sick">Sick</option>
                        <option value= "Vacation">Vacation</option>
                        <option value= "Emergency">Emergency</option>
                        <option value= "Maternity">Maternity</option>
                        <option value= "Paternity">Paternity</option>
                        <option value= "Bereavement">Bereavement</option>
                    </select></h4>
                <h4>Days of Leave: <input type="number" min="0.5" max="15" name = "dayCount" step="0.5" required></h4><br/>
                <h4>
                    Inclusive Dates:

                    <input type= "date" class= "form-control" id="dp" name = "startDate" required/> 
                    until 
                    <input type= "date" class= "form-control" id="dp" name = "endDate" required/>
                </h4>
                <%
                    HttpSession reqSession = request.getSession();
                    ArrayList<Boolean> errorFlags = (ArrayList) reqSession.getAttribute("errorFlags");

                    if (errorFlags != null) {
                        if (errorFlags.get(0)) {
                %>
                <h4><hr/>Invalid Input! The end date is earlier than the start date.</h4>
                    <%
                    } else if (errorFlags.get(1)) {
                    %>
                <h4><hr/>Invalid Input! The number of days of leave doesn't match the duration between the start and end date.</h4>
                    <%
                    } else if (errorFlags.get(2)) {
                    %>
                <h4><hr/>Employee ID not found.</h4>
                    <%
                            }
                        }
                    %>
                <input class= "submitButton" type="submit" value= "Submit" name= "dataSubmit"/>
            </form>
            
            <%
                modelEmployee modelEmployee = (modelEmployee) reqSession.getAttribute("employee");
            %>
            <%
                if (modelEmployee.getEmployeeType().equalsIgnoreCase("Employee")) {
            %>
            <a href="Homepage-Employee.jsp"><input class="back" type="submit" value="Back" name="bBack"/></a>
                <%  } else if (modelEmployee.getEmployeeType().equalsIgnoreCase("HR Head")) {
                %>
            <a href="Homepage-HrHead.jsp"><input class="back" type="submit" value="Back" name="bBack"/></a>
                <%  } else if (modelEmployee.getEmployeeType().equalsIgnoreCase("HR Employee")) {
                %>
            <a href="Homepage-HrEmployee.jsp"><input class="back" type="submit" value="Back" name="bBack"/></a>
                <%  } else if (modelEmployee.getEmployeeType().equalsIgnoreCase("Manager")) {
                %>
            <a href="Homepage-Manager.jsp"><input class="back" type="submit" value="Back" name="bBack"/></a>
                <%}%>
        </div>

        <div class= "footer">
            <hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </div>

    </body>
</html>

