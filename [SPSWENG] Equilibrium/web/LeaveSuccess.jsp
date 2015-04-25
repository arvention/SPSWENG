<%@page import="Models.modelEmployee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="img/eq logo.ico"/>
        <title> Leave Filed Successful - Equilibrium </title>

        <link rel="stylesheet" type="text/css" 	media="all" href="css/LeaveSuccess.css" />
        <link rel="stylesheet" type="text/css" 	media="all" href="css/navigationBar.css" />
    </head>
    <body bgcolor=#E8E8E8>
        <%
	   modelEmployee m = (modelEmployee)session.getAttribute("employee");
            
           if (m.getEmployeeType().equals("Hr Head")){
       %>
                <DIV class= "nav">
            <form method="GET" action="SearchEmployee">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href= "changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li> 
                <li><a href= "#"><span class="selectText">Generate Report</span></a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search EQuilibrium"/></li>
                <li><a href="Homepage-HrHead.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
            </form>
        </DIV>
        <%
           }
           else if (m.getEmployeeType().equals("Hr Employee")){
               
        %>
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href= "changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li> 
                <li><a href= "#"><span class="selectText">Generate Report</span></a></li>
                <li><a href= "EmployeeData.jsp"><span class="selectText">Add Employee Record</span></a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search EQuilibrium"/></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </DIV>
        <% 
           }
           
           else if (m.getEmployeeType().equals("Senior Manager")){
               
        %>
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href="changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search EQuilibrium"/></li>
                <li><a href="Homepage-SManager.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </DIV>
        <%       
           }
           
           else if(m.getEmployeeType().equals("Manager")){
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
           }
           
           else if (m.getEmployeeType().equals("Employee")){
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
        <div class = "memoForm" align="center">
            <br/><br/><br/><br/><br/><br/><br/><br/><br/>
            <text class="titleText">Leave has been successfully filed!</text><br/>
            <%
                HttpSession reqSession = request.getSession();
                modelEmployee modelEmployee  = (modelEmployee)reqSession.getAttribute("employee");
            %>
            <%
                if(modelEmployee.getEmployeeType().equalsIgnoreCase("Employee")){
            %>
                <a href="Homepage-Employee.jsp">Click here to return to home page...<html></a>
            <%  }
                else if(modelEmployee.getEmployeeType().equalsIgnoreCase("HR Head")){
            %>
                <a href="Homepage-HrHead.jsp">Click here to return to home page...<html></a>
            <%  }
                else if(modelEmployee.getEmployeeType().equalsIgnoreCase("HR Employee")){
            %>
                <a href="Homepage-HrEmployee.jsp">Click here to return to home page...<html></a>
            <%  }
                else if(modelEmployee.getEmployeeType().equalsIgnoreCase("Manager")){
            %>
                <a href="Homepage-Manager.jsp">Click here to return to home page...<html></a>
            <%}%>

        </div>
        <DIV class = "pageBottom" style="margin-bottom: 3px"><hr width ="75%"/></br> EQUILIBRIUM INTERTRADE CORP.</div>
    </body>
</html>
