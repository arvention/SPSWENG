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

        <script type = "text/javascript" src = "js/Homepage-Manager.js">
        </script>
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
            <div id="results">
                <%  Database db = Database.getInstance();
                    modelEmployee employee = (modelEmployee) request.getSession().getAttribute("employee");
                    ArrayList<modelLeaveForm> leaveFormsToApprove = db.getLeaveFormToApprove(employee.getEntryNum());

                    if (leaveFormsToApprove.size() != 0) {
                %>
                <span class= "titleText"> Leaves for Approval </span>
                <hr width="75%"/>
                <%
                    for (modelLeaveForm leaveForm : leaveFormsToApprove) {
                %>
                <div class="result">
                    <span class="name"><%=db.getLastName(leaveForm.getEmpEntryNum())%>, <%=db.getFirstName(leaveForm.getEmpEntryNum())%></span><br/>
                    <span class="typeLeave">Type of Leave: <%=leaveForm.getLeaveType()%></span><br/>
                    <span class="typeLeave">Start Date: <%=leaveForm.getStartDate()%></span><br/><br/>

                    <form action="ApproveLeave" method="POST" class="inline-form" onclick="return accept('<%=db.getFirstName(leaveForm.getEmpEntryNum())%>', '<%=db.getLastName(leaveForm.getEmpEntryNum())%>')">
                        <input type ="hidden" name="leaveID" value="<%=leaveForm.getLeaveID()%>"/>
                        <input type="hidden" name="approveValue" value="Approved" />
                        <input type="hidden" name="curpage" value="homepage-manager" />
                        <input type="submit" class ="approveLeave" value="Approve" id="approve-button"/>
                    </form>

                    <form action="ApproveLeave" method="POST" class="inline-form" onclick="return reject('<%=db.getFirstName(leaveForm.getEmpEntryNum())%>', '<%=db.getLastName(leaveForm.getEmpEntryNum())%>')">
                        <input type ="hidden" name="leaveID" value="<%=leaveForm.getLeaveID()%>"/>
                        <input type="hidden" name="approveValue" value="Rejected" />
                        <input type="hidden" name="curpage" value="homepage-manager" />
                        <input type="submit" class ="declineLeave" value="Reject" id="reject-button"/>
                    </form>
                </div>
                <%}%>
            </div>
            <%  } else {
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
