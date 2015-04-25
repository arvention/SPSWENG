<%@page import="Models.modelEmployeeAuditTrail"%>
<%@page import="Models.modelLeaveForm"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.modelEmployee"%>
<%@page import="Database.Database"%>
<html>
    <head>
        <title>Home - Equilibrium</title>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="shortcut icon" href="img/eq logo.png">
        <link rel="stylesheet" type="text/css" media="all" href="css/Homepage-HrHead.css"/>

        <script src="js/HomepageFunc.js"></script>
        <script type = "text/javascript" src = "js/Homepage-HrHead.js">
        </script>
        <script>
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
    <body>
        <DIV class= "nav">
            <form method="GET" action="SearchEmployee">

            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href= "changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href= "LeaveForm.jsp"><span class ="selectText">File a Leave</span></a></li>
                <li><a href= "GenerateReport.jsp"><span class="selectText">Generate Report</span></a></li>
                 <li><a href= "EmployeeData.jsp"><span class="selectText">Add Employee Record</span></a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search EQuilibrium"/></li>
                <li><a href="Homepage-HrHead.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>

            </form>
        </DIV>	
        <div id="box">
            <div id="results">
                <%  Database db = Database.getInstance();
                    modelEmployee employee = (modelEmployee) request.getSession().getAttribute("employee");
                    ArrayList<modelLeaveForm> leaveFormsToApprove = db.getLeaveFormToApprove(employee.getEntryNum());

                    if (leaveFormsToApprove.size() != 0) {
                %>
                <span class = "titleText">Leaves for Approval </span>
                <%
                    for (modelLeaveForm leaveForm : leaveFormsToApprove) {
                %>
                <div class="result">
                    <span class="name"><%=db.getLastName(leaveForm.getEmpEntryNum())%>, <%=db.getFirstName(leaveForm.getEmpEntryNum())%></span><br/>
                    <span class="typeLeave">Type of Leave: <%=leaveForm.getLeaveType()%></span><br/>
                    <span class="typeLeave">Start Date: <%=leaveForm.getStartDate()%></span><br/></br>

                    <form action="ApproveLeave" method="POST" class="inline-form" onclick="return acceptLeave('<%=db.getFirstName(leaveForm.getEmpEntryNum())%>', '<%=db.getLastName(leaveForm.getEmpEntryNum())%>')">
                        <input type ="hidden" name="leaveID" value="<%=leaveForm.getLeaveID()%>"/>
                        <input type="hidden" name="approveValue" value="Approved" />
                        <input type="hidden" name="curpage" value="homepage-hrhead" />
                        <input type="submit" class ="approveLeave" value="Approve" id="approve-button"/>
                    </form>

                    <form action="ApproveLeave" method="POST" class="inline-form" onclick="return rejectLeave('<%=db.getFirstName(leaveForm.getEmpEntryNum())%>', '<%=db.getLastName(leaveForm.getEmpEntryNum())%>')">
                        <input type ="hidden" name="leaveID" value="<%=leaveForm.getLeaveID()%>"/>
                        <input type="hidden" name="approveValue" value="Rejected" />
                        <input type="hidden" name="curpage" value="homepage-hrhead" />
                        <input type="submit" class ="declineLeave" value="Reject" id="reject-button"/>
                    </form>
                </div>
                <%}%>
            </div>
            <%  } else {
            %>
            <div id="results">
                <p>No pending leave request</p>
            </div>
            <%}%>
        </div></div>

        <div id="box2">
            <div id="results">
                <%  ArrayList<modelEmployeeAuditTrail> auditToApprove = db.getAuditToApprove();

                    if (auditToApprove.size() != 0) {
                %>
                <span class = "titleText2">Edits for Approval </span>
                <%
                    for (modelEmployeeAuditTrail audit : auditToApprove) {
                %>
                <div class="result">
                    <span class="name"><%=db.getLastName(audit.getEditedEntryNum())%>, <%=db.getFirstName(audit.getEditedEntryNum())%></span><br>
                    <span class="editor">Name of Editor: <%=db.getLastName(audit.getEditorEntryNum())%>, <%=db.getFirstName(audit.getEditorEntryNum())%></span><br>
                    <span class="edited">Edited data: <%=audit.getFieldChanged()%> | Old Value: <%=audit.getEditFrom()%> | New Value: <%=audit.getEditTo()%>  </span><br>
                    <span class="timestamp"><%=audit.getTimestamp()%></span></br></br>

                    <form action="ApproveAudit" method="POST" class="inline-form" onclick="return acceptRevision('<%=db.getFirstName(audit.getEditedEntryNum())%>', '<%=db.getLastName(audit.getEditedEntryNum())%>', '<%=audit.getFieldChanged()%>')">
                        <input type ="hidden" name="empAuditTrailID" value="<%=audit.getEmpAuditTrailID()%>" />
                        <input type="hidden" name="tableName" value="<%=audit.getTableName()%>">
                        <input type="hidden" name="tableReferenceNum" value="<%=audit.getTableReferenceNum()%>">
                        <input type="hidden" name="field" value="<%=audit.getFieldChanged()%>">
                        <input type="hidden" name="value" value="<%=audit.getEditTo()%>">
                        <input type="hidden" name="approveValue" value="Approved" />
                        <input type="submit" class ="approveLeave" value="Approve" id="approve-button"/>
                    </form>

                    <form action="ApproveAudit" method="POST" class="inline-form" onclick="return rejectRevision('<%=db.getFirstName(audit.getEditedEntryNum())%>', '<%=db.getLastName(audit.getEditedEntryNum())%>', '<%=audit.getFieldChanged()%>')">
                        <input type ="hidden" name="empAuditTrailID" value="<%=audit.getEmpAuditTrailID()%>" />
                        <input type="hidden" name="tableName" value="<%=audit.getTableName()%>">
                        <input type="hidden" name="tableReferenceNum" value="<%=audit.getTableReferenceNum()%>">
                        <input type="hidden" name="field" value="<%=audit.getFieldChanged()%>">
                        <input type="hidden" name="value" value="<%=audit.getEditTo()%>">
                        <input type="hidden" name="approveValue" value="Rejected" />
                        <input type="submit" class ="declineLeave" value="Reject" id="reject-button"/>
                    </form>
                </div>
                <%}%>
            </div>
            <%} else {%>
            <div id="results">
                <p>No pending audit trail</p>
            </div>
            <%}%>
        </div>


        <DIV class="footer">
            <br/><hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </DIV>

    </body>
</html>
