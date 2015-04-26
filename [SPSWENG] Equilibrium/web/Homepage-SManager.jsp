<%@page import="Models.modelLeaveForm"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.modelEmployee"%>
<%@page import="Database.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home - Equilibrium</title>
        <link rel="shortcut icon" href="img/eq logo.ico">
        <link rel="stylesheet" type="text/css" media="all" href="css/Homepage-Manager_1.css"/>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css"/>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/jquery-ui.js"></script>

        <script src="js/HomepageFunc.js"></script>
        <script type = "text/javascript" src = "js/Homepage-Manager.js"></script>
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
     <form method="GET" action="SearchEmployee">
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href= "changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href= "FileLeave.jsp"><span class="selectText">File a Leave</span></a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search Employee Records"/></li>
                <li><a href="Homepage-SManager.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
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
                        <input type="hidden" name="curpage" value="homepage-smanager" />
                        <input type="submit" class ="approveLeave" value="Approve" id="approve-button"/>
                    </form>

                    <form action="ApproveLeave" method="POST" class="inline-form" onclick="return reject('<%=db.getFirstName(leaveForm.getEmpEntryNum())%>', '<%=db.getLastName(leaveForm.getEmpEntryNum())%>')">
                        <input type ="hidden" name="leaveID" value="<%=leaveForm.getLeaveID()%>"/>
                        <input type="hidden" name="approveValue" value="Rejected" />
                        <input type="hidden" name="curpage" value="homepage-smanager" />
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
        
        <DIV class="footer">
            <br/><hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </DIV>

    </body>
</html>
