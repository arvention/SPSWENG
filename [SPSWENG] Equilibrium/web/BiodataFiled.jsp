<%-- 
    Document   : BiodataFiled
    Created on : Apr 27, 2015, 9:27:26 AM
    Author     : Arren Antioquia
--%>

<%@page import="Models.modelEmployee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bio Data Filed - Equilibrium</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel ="shortcut icon" href="img/eq logo.ico"/>
        <link href = "css/MemoFiled.css" rel = "stylesheet" />
    </head>
    <body bgcolor=#E8E8E8>
        <div class = "memoForm" align="center">
            <br/><br/><br/><br/><br/><br/><br/><br/><br/>
            <div class="titleText">Employee info has been stored!</div><br/>
            <%  modelEmployee employee = (modelEmployee) request.getSession().getAttribute("employee");
                if (employee.getEmployeeType().equals("Hr Employee")){
            %>
            <a href="Homepage-HrEmployee.jsp">Click here to return to home page...</a>
            <%  } else if(employee.getEmployeeType().equals("Hr Head")){
            %>
            <a href="Homepage-HrHead.jsp">Click here to return to home page...</a>
            <%}%>
        </div>
        <div class = "pageBottom" style="margin-bottom: 3px"><hr width ="75%"/></br> 
            EQUILIBRIUM INTERTRADE CORP.
        </div>
    </body>
</html>

