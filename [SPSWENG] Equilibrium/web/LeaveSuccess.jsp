<%@page import="Models.modelEmployee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="img/eq logo.ico"/>
        <title> Leave Filed Successful - Equilibrium </title>

        <link rel="stylesheet" type="text/css" 	media="all" href="css/LeaveSuccess.css" />
    </head>
    <body bgcolor=#E8E8E8>
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