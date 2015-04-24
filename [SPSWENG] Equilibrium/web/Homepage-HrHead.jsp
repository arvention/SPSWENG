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
                    <li><a href= "Logout">Log Out</a></li>
                    <li><a href= "changePassword.jsp">Change Password</a></li>
                    <li><a href= "#">File a Leave</a></li>
                    <li><a href= "#">Generate Report</a></li>
                    <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search EQuilibrium"/></li>
                    <li><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></li>
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

                    <form action="ApproveLeave" method="POST" class="inline-form" onclick="return accept('<%=db.getFirstName(leaveForm.getEmpEntryNum())%>', '<%=db.getLastName(leaveForm.getEmpEntryNum())%>')">
                        <input type ="hidden" name="leaveID" value="<%=leaveForm.getLeaveID()%>"/>
                        <input type="hidden" name="approveValue" value="Approved" />
                        <input type="hidden" name="curpage" value="homepage-hrhead" />
                        <input type="submit" class ="approveLeave" value="Approve" id="approve-button"/>
                    </form>

                    <form action="ApproveLeave" method="POST" class="inline-form" onclick="return reject('<%=db.getFirstName(leaveForm.getEmpEntryNum())%>', '<%=db.getLastName(leaveForm.getEmpEntryNum())%>')">
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
            <span class = "titleText2">Edits for Approval </span>
            <div id="results">
                <div class="result">
                    <span class="name">Last Name, First Name of record edited</span><br>
                    <span class="editor">Name of Editor</span><br>
                    <span class="edited">Edited data</span><br>
                    <span class="timestamp">Timestamp</span></br></br>
                    <button class="approveLeave">Approve</button>
                    <button class="declineLeave">Decline</button>
                </div>	
                <div class="result">
                    <span class="name">Last Name, First Name of record edited</span><br>
                    <span class="editor">Name of Editor</span><br>
                    <span class="edited">Edited data</span><br>
                    <span class="timestamp">Timestamp</span></br></br>
                    <button class="approveLeave">Approve</button>
                    <button class="declineLeave">Decline</button>
                </div>
                <div class="result">
                    <span class="name">Last Name, First Name of record edited</span><br>
                    <span class="editor">Name of Editor</span><br>
                    <span class="edited">Edited data</span><br>
                    <span class="timestamp">Timestamp</span></br></br>
                    <button class="approveLeave">Approve</button>
                    <button class="declineLeave">Decline</button>
                </div>	
                <div class="result">
                    <span class="name">Last Name, First Name of record edited</span><br>
                    <span class="editor">Name of Editor</span><br>
                    <span class="edited">Edited data</span><br>
                    <span class="timestamp">Timestamp</span></br></br>
                    <button class="approveLeave">Approve</button>
                    <button class="declineLeave">Decline</button>
                </div>	
            </div>
        </div>


        <DIV class="footer">
            <br/><hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </DIV>

    </body>
</html>
