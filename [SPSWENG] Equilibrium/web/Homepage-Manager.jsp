<%@page import="Models.modelLeaveForm"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.modelEmployee"%>
<%@page import="Database.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>	Home - EQuilibrium </title>
        <link rel="shortcut icon" href="eq logo.ico"/>
        <link rel="stylesheet" type="text/css" href="css/Homepage-Manager.css"/>
        <link rel="stylesheet" type="text/css" media="all" href="css/HomepageStyles.css"/>
    </head>
    <body>
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout">Log Out</a></li>
                <li><a href= "#">Change Password</a></li>
                <li><a href= "#">File a Leave</a></li>
                <li><img class= "logo" src= "img/eqboyz.png" height="55px"/></li>
            </ul>
        </DIV>	
        
        
        <div id="approve-leave-div">
            <div id="leave-div">
                <%  Database db = Database.getInstance();
                    modelEmployee employee = (modelEmployee)request.getSession().getAttribute("employee");
                    ArrayList<modelLeaveForm> leaveFormsToApprove = db.getLeaveFormToApprove(employee.getEntryNum());
                    System.out.println("EMPLOYEE ENTRY NUM: " + employee.getEntryNum());
                    if(leaveFormsToApprove.size() != 0){
                %>
                <div>
                    <p id="heading-tag">Pending Leave Requests</p>
                </div>
                <ul id="leave-list">
                    <%
                        for(modelLeaveForm leaveForm : leaveFormsToApprove){        
                    %>
                    <li class="leave-item">
                        <p>Employee Name: <%=db.getFirstName(leaveForm.getEmpEntryNum())%> <%=db.getLastName(leaveForm.getEmpEntryNum())%></p>
                        <p>Leave Type: <%=leaveForm.getLeaveType()%></p>
                        <p>Start Date: <%=leaveForm.getStartDate()%></p>
                        <p>Duration: <%=leaveForm.getDuration()%></p>
                        <form action="ApproveLeave" method="POST">
                            <input type ="hidden" name="leaveID" value="<%=leaveForm.getLeaveID()%>"/>
                            <input type="hidden" name="approveValue" value="Approved" />
                            <input type="submit" class ="approve-button" value="Approve" />
                        </form>
                        <form action="ApproveLeave" method="POST">
                            <input type ="hidden" name="leaveID" value="<%=leaveForm.getLeaveID()%>"/>
                            <input type="hidden" name="approveValue" value="Rejected" />
                            <input type="submit" class ="reject-button" value="Reject" />
                        </form>
                    </li>
                    <%}%>
                </ul>
                <%  }
                    else{
                %>
                    <div id="no-pending-div">
                        <p id="no-pending-tag">No pending leave request</p>
                    </div>
                <%}%>
            </div>
        </div>
        
        <div class = "footer">
            <hr width="75%"/>EQUILIBRIUM INTERTRADE CORPORATION
        </div>
    </body>
</html>
