<%@page import="java.util.ArrayList"%>
<%@page import="Models.modelEmployee"%>
<%@page import="ClassHelpers.SearchResult"%>


<html>
    <head>
        <link rel="shortcut icon" href="eq logo.ico"/>
        <link rel="stylesheet" type="text/css" media="all" href= "css/SearchStyle.css"/>
        <link rel="stylesheet" type="text/css" media="all" href= "css/navbar.css"/>
        <script src= "js/jquery-1.11.2.js"></script>

        <%
            SearchResult sr = (SearchResult) session.getAttribute("searchresult");
            modelEmployee user = (modelEmployee) session.getAttribute("employee");
            ArrayList<modelEmployee> me = sr.getResult();
        %>

        <script>
            $(document).ready(function() {
                $(".filememo").click(function() {

                    var id = $(this).closest("div").attr("val");
                    $("#numberofid").val(id);
                    $("#kind").val("file");
                    $("#go").submit();
                });
                
                $(".addAward").click(function() {

                    var id = $(this).closest("div").attr("val");
                    $("#numberofid").val(id);
                    $("#kind").val("award");
                    $("#go").submit();
                });
                
                $(".evaluate").click(function() {

                    var id = $(this).closest("div").attr("val");
                    $("#numberofid").val(id);
                    $("#kind").val("evaluate");
                    $("#go").submit();
                });
                
                
            });
        </script>
    </head>
    <body>
        <%
	   modelEmployee m = (modelEmployee)session.getAttribute("employee");
            
           if (m.getEmployeeType().equals("Hr Head")){
       %>
                <DIV class= "nav">
            <form method="GET" action="SearchEmployee">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout">Log Out</a></li>
                <li><a href= "changePassword.jsp">Change Password</a></li>
                <li><a href= "LeaveForm.jsp">File a Leave</a></li> 
                <li><a href= "#">Generate Report</a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search EQuilibrium"/></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
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
                <li><a href= "Logout">Log Out</a></li>
                <li><a href= "changePassword.jsp">Change Password</a></li>
                <li><a href= "LeaveForm.jsp">File a Leave</a></li>
                <li><a href= "#">Generate Report</a></li>
                <li><a href= "EmployeeData.jsp">Add Employee Record</a></li>
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
                <li><a href= "Logout">Log Out</a></li>
                <li><a href="changePassword.jsp">Change Password</a></li>
                <li><a href= "LeaveForm.jsp">File a Leave</a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search EQuilibrium"/></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </DIV>
        <%       
           }
           
           else if(m.getEmployeeType().equals("Manager")){
        %>
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout">Log Out</a></li>
                <li><a href= "changePassword.jsp">Change Password</a></li>
                <li><a href= "LeaveForm.jsp">File a Leave</a></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </DIV>
        <%
           }
           
           else if (m.getEmployeeType().equals("Employee")){
        %>
        <div class= "nav">
            <ul>
                <li><a href= "Logout">Log Out</a></li>
                <li><a href= "changePassword.jsp">Change Password</a></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </div>
        <%
           }
        %>
        <DIV class ="pageTop">
            <div id="box">
                <div id="results">

                    <form id="go" method="POST" action="SelectEmployeeServlet">
                        <input id ="numberofid" name="idnumber" type="hidden" value="">
                        <input id="kind" name="type"type="hidden" value="file">
                    </form>
                    
          
                    
                    

                    <%for (modelEmployee e : me) {

                    %>    
                    <div class="result" val="<%=e.getEmployeeID()%>">
                        <span class="name"><a href = "ViewEmployee?id=<%=e.getEmployeeID()%>"><%=e.getLastName()%>, <%=e.getFirstName()%></a></span><br>
                                              <span class="idnum"><%=e.getEmployeeID()%></span><br>

                        <%if (e.getPassword() == null) {%>
                        <span class="accStatus">No Account</span>


                        <%if (user.getEmployeeType().equals("Hr Head")) {%>             

                        <form method="POST" action="SaveAccount" style="display: inline;">
                            <select required name="type">
                                <option value="Senior Manager"> Senior Manager </option>
                                <option value="Manager"> Manager </option>
                                <option value="Hr Head"> HR Head </option>
                                <option value ="Hr Employee"> HR Employee </option>
                                <option selected value="Employee"> Employee </option>
                            </select>
                            <input type="hidden"  name="entry" value="<%=e.getEntryNum()%>">
                            <input type ="submit"  value="Add Account">
                            
                        </form>
                        <%}%>


                        <%} else {%>
                        <span class="accStatus">Has Account</span>
                        <%}%>
                        <button class="addAward">Add Award</button>
                        <button class="filememo">File Memo</button>
                        <button class="evaluate">Evaluation</button>
                    </div>
                    <%}%>   

                    <!--
                <div class="result">
                        <span class="name">Last Name, First Name</span><br>
                        <span class="idnum">11223300</span><br>
                        <span class="accStatus">Has Account</span>
                        <button class="addAccount">Add Award</button>
                        <button class="addAccount">File Memo</button>
                </div>
                <div class="result">
                        <span class="name">Last Name, First Name</span><br>
                        <span class="idnum">11223300</span><br>
                        <span class="accStatus">No Account</span>
                        <select required name="type">
                                <option> Senior Manager </option>
                                <option> Manager </option>
                                <option> HR Employee </option>
                                <option selected> Employee </option>
                        </select>
                        <button class="addAccount">Add Account</button>
                        <button class="addAccount">Add Award</button>
                        <button class="addAccount">File Memo</button>
                </div>
                <div class="result">
                        <span class="name">Last Name, First Name</span><br>
                        <span class="idnum">11223300</span><br>
                        <span class="accStatus">No Account</span>
                        <select required name="type">
                                <option> Senior Manager </option>
                                <option> Manager </option>
                                <option> HR Employee </option>
                                <option selected> Employee </option>
                        </select>
                        <button class="addAccount">Add Account</button>
                        <button class="addAccount">Add Award</button>
                        <button class="addAccount">File Memo</button>
                </div>
                <div class="result">
                        <span class="name">Last Name, First Name</span><br>
                        <span class="idnum">11223300</span><br>
                        <span class="accStatus">Has Account</span>
                        <button class="addAccount">Add Award</button>
                        <button class="addAccount">File Memo</button>
                </div>
                <div class="result">
                        <span class="name">Last Name, First Name</span><br>
                        <span class="idnum">11223300</span><br>
                        <span class="accStatus">No Account</span>
                        <select required name="type">
                                <option> Senior Manager </option>
                                <option> Manager </option>
                                <option> HR Employee </option>
                                <option selected> Employee </option>
                        </select>
                        <button class="addAccount">Add Account</button>
                        <button class="addAccount">Add Award</button>
                        <button class="addAccount">File Memo</button>
                </div>
                <div class="result">
                        <span class="name">Last Name, First Name</span><br>
                        <span class="idnum">11223300</span><br>
                        <span class="accStatus">No Account</span>
                        <button class="addAccount">Add Account</button>
                        <button class="addAccount">Add Award</button>
                        <button class="addAccount">File Memo</button>
                </div>
                <div class="result">
                        <span class="name">Last Name, First Name</span><br>
                        <span class="idnum">11223300</span><br>
                        <span class="accStatus">Has Account</span>
                        <button class="addAccount">Add Award</button>
                        <button class="addAccount">File Memo</button>
                </div>
                <div class="result">
                        <span class="name">Last Name, First Name</span><br>
                        <span class="idnum">11223300</span><br>
                        <span class="accStatus">No Account</span>
                        <select required name="type">
                                <option> Senior Manager </option>
                                <option> Manager </option>
                                <option> HR Employee </option>
                                <option selected> Employee </option>
                        </select>
                        <button class="addAccount">Add Account</button>
                        <button class="addAccount">Add Award</button>
                        <button class="addAccount">File Memo</button>
                </div>
                </div>
                </div>
                    -->

                </div>
            </div>
        </div>
        <DIV class="footer">
            <br/><hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </DIV>
    </body>
</html>
