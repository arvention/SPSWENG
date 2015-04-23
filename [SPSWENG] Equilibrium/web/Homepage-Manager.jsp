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
                <li><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></li>
            </ul>
        </DIV>	
        
        
        <div id="box">
            <ul id="results">
                <%  Database db = Database.getInstance();
                    modelEmployee employee = (modelEmployee)request.getSession().getAttribute("employee");
                    ArrayList<modelLeaveForm> leaveFormsToApprove = db.getLeaveFormToApprove(employee.getEntryNum());
                    
                    if(leaveFormsToApprove.size() != 0){
                %>
                <span class= "titleText"> Leaves for Approval </span>
                    <%
                        for(modelLeaveForm leaveForm : leaveFormsToApprove){        
                    %>
                   <li class="result">
			            <span class="name"><%=db.getLastName(leaveForm.getEmpEntryNum())%>, <%=db.getFirstName(leaveForm.getEmpEntryNum())%></span><br>
		            	<span class="typeLeave">Type of Leave: <%=leaveForm.getLeaveType()%></p></span><br>
		            	<span class="typeLeave">Start Date: <%=leaveForm.getStartDate()%></p></span><br>
			
                        <form action="ApproveLeave" method="POST">
                            <input type ="hidden" name="leaveID" value="<%=leaveForm.getLeaveID()%>"/>
                            <input type="hidden" name="approveValue" value="Approved" />
                            <input type="submit" class ="approveLeave" value="Approve" />
                        </form>
                        <form action="ApproveLeave" method="POST">
                            <input type ="hidden" name="leaveID" value="<%=leaveForm.getLeaveID()%>"/>
                            <input type="hidden" name="approveValue" value="Rejected" />
                            <input type="submit" class ="declineLeave" value="Reject" />
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
