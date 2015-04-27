<%-- 
    Document   : EmployeeData
    Created on : 03 26, 15, 12:27:50 AM
    Author     : Arces
--%>

<%@page import="Models.modelEmployee"%>
<%@page import="Models.modelBranch"%>
<%@page import="Models.modelDepartment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Database.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Employee BioData - Personal Information</title>
        <link rel ="shortcut icon" href="img/eq logo.ico">
        <link rel="stylesheet" type="text/css" media="all" href="css/SampleScreensStyle.css"/>
        <link rel="stylesheet" type="text/css" media="all" href="css/navigationBar.css"/>
        <script src="js/jquery-1.11.2.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script src="js/SampleScreensFunc.js"></script>
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
        <%
            Database db = Database.getInstance();
         
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
                <li><a href= "GenerateReport.jsp"><span class="selectText">Generate Report</span></a></li>
                <li><a href= "EmployeeData.jsp"><span class="selectText">Add Employee Record</span></a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search Employee Records"/></li>
                <li><a href="Homepage-HrHead.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
            </form>
        </DIV>
        <%
           }
           else if (m.getEmployeeType().equals("Hr Employee")){
               
        %>
        <DIV class= "nav">
         <form method="GET" action="SearchEmployee">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href= "changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li> 
                <li><a href= "GenerateReport.jsp"><span class="selectText">Generate Report</span></a></li>
                <li><a href= "EmployeeData.jsp"><span class="selectText">Add Employee Record</span></a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search Employee Records"/></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
            </form>
        </DIV>
        <% 
           }
           
           else if (m.getEmployeeType().equals("Senior Manager")){
               
        %>
        <DIV class= "nav">
         <form method="GET" action="SearchEmployee">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href="changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search Employee Records"/></li>
                <li><a href="Homepage-SManager.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
            </form>
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
        <span class="titleText">Add Employee Record</span>
        <DIV class="content">
            <ul class="tabs">
                <li><a href="#personalinfo">Personal Information</a></li>
                <li><a href="#family">Family Relations</a></li>
                <li><a href="#emergencycontact">Emergency Contact</a></li>
                <li><a href="#edhistory">Education History</a></li>
                <li><a href="#emphistory">Employment History</a></li>
                <li><a href="#crimes">Past Criminal Offenses</a></li>
            </ul>
            <form onsubmit = "return submitData()" class = "data_form">
                
                    <DIV id="personalinfo" class="tab-section">

                        <%
                            Boolean isSameID = (Boolean) request.getSession().getAttribute("isSameID");
                            if (isSameID != null) {
                                if (isSameID) {
                        %>
                        <span class="headers"><font color = "red" size = "2px">* Error Employee ID already exists</font></span><br/><br/>
                            <%
                                    }
                                }
                            %>
                        <table>
                            <tr>
                                <td>Employee ID #</td>
                                <td><input type="number" class = "infoinput" min = "0" max = "99999999999" name="employeeID" placeholder="Employee ID"  /></td>
                            </tr>
                        </table>
                        <table name="one">
                            <tr>
                                <td>Name </td>
                                <td><input type="text" class = "infoinput" maxlength = 20 name="lastname" placeholder="Last Name"  /></td>
                                <td><input type="text" class = "infoinput" maxlength = 20 name="firstname" placeholder="First Name"  /></td>
                                <td><input type="text" class = "infoinput" maxlength = 20 name="middlename" placeholder="Middle Name"  /></td>
                            </tr>
                        </table>
                        <table name="two">
                            <tr>
                                <td>Address </td>
                                <td><input type="text" class = "infoinput" maxlength = 20 name="block" placeholder="Block/Street" /></td>
                                <td><input type="text" class = "infoinput" maxlength = 20 name="subdivision" placeholder="Subdivision"  /></td>
                                <td><input type="text" maxlength = 20 name="barangay" placeholder="Barangay" /></td>
                                <td><input type="text" class = "infoinput" maxlength = 20 name="city" placeholder="City"  /></td>
                                <td><input type="text" class = "infoinput" maxlength = 20 name="province" placeholder="Province"  /></td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td>Birthday </td>
                                <td><input type="date" name="birthday" class = "infoinput" placeholder="Birthday" /></td>
                                <td>Birthplace</td>
                                <td><input type="text" maxlength = 20 class = "infoinput" name="birthplace" placeholder="Birth Place" /></td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td>Home Phone</td>
                                <td><input type="number" step = "1" min = "0" max = "999999999" name="homephone" placeholder="Home Phone" /></td>
                                <td>Mobile #</td>
                                <td><input type="number" class = "infoinput" step = "1" min = "0" max = "99999999999" name="mobileno" placeholder="Mobile Number"/></td>
                                <td>Email Address</td>
                                <td><input type="text" class = "infoinput" maxlength = 45 name="emailadd" placeholder="Email Address"/></td>
                        </table>
                        <table>
                            <tr>
                                <td>SSS</td>
                                <td><input type="text" class = "infoinput" maxlength = 12 name="sssno" placeholder="Ex. 01-2345678-9" /></td>
                                <td>TIN</td>
                                <td><input type="text" class = "infoinput" maxlength = 16 name="tinno" placeholder="Ex. 999-999-999-999X" /></td>
                                <td>PHIC</td>
                                <td><input type="text" class = "infoinput" maxlength = 14 name="phicno" placeholder="Ex. 01-234567890-1" /></td>
                                <td>PAGIBIG</td>
                                <td><input type="text" class = "infoinput" maxlength = 14 name="pagibigno" placeholder="Ex. 1234-5678-9101" /></td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td>Citizenship</td>
                                <td><input type="text" class = "infoinput" maxlength = 20 name="citizenship" placeholder="Citizenship" /></td>
                                <td>Religion</td>
                                <td><input type="text" class = "infoinput" maxlength = 20 name="religion" placeholder="Religion" /></td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td>Band</td>
                                <td><input type="number" class = "infoinput" step = "1" min = "1" max = "9" name="employeeband" placeholder="1"/></td>
                                <td>Department</td>
                                <td>
                                    <%
                                        ArrayList<modelDepartment> departmentList = db.getDepartments();
                                    %>
                                    <select name = "empdep">
                                        <%
                                            for (modelDepartment dept : departmentList) {
                                        %>
                                        <option type="text" class = "infoinput" value = "<%=dept.getName()%>"><%=dept.getName()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </td>
                                <td>Branch</td>
                                <td>
                                    <%
                                        ArrayList<modelBranch> branchList = db.getBranches();
                                    %>
                                    <select name = "empbranch">
                                        <%
                                            for (modelBranch branch : branchList) {
                                        %>
                                        <option type="text" class = "infoinput" value = "<%=branch.getBranchID()%>"><%=branch.getName()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </td>
                                <td>Current Position</td>
                                <td><input type="text" class = "infoinput" maxlength = 45 name="empposition" placeholder="Current Position" /></td>
                                
                            </tr>
                            <tr>
                                <td>Expected Salary</td>
                                <td><input type="number" class = "infoinput" step = "1" min = "0" max = "9999999" name="salary" placeholder="Expected Salary" /><br/></td>
                                <td>Hire Date</td>
                                <td><input type="date" class = "infoinput" name="hiredate" placeholder="Hire Date"  /></td>
                                <td>Manager</td>
                                <td><input type="number" class = "infoinput" min = "0" max = "99999999999" name="emphead" placeholder="Employee's Manager ID" /></td>
                            </tr>
                        </table>
                    </DIV>
                    <DIV id="family" class="tab-section">
                        <table>
                            <tr>
                                <td></td>
                                <td>Name</td>
                                <td>Age</td>
                                <td>Occupation</td>
                            </tr>
                            <tr>
                                <td><span class="headers">Father</span></td>
                                <td><input type="text" maxlength = 45 name="fathername" placeholder="Father's Name" /></td>
                                <td><input type="number" step = "1" min = "0" max = "999" name="fatherage" placeholder="Age" /></td>
                                <td><input type="text" maxlength = 20 name="fatheroccupation" placeholder="Occupation" /><br/></td>
                            </tr>
                            <tr>
                                <td><span class="headers">Mother</span></td>
                                <td><input type="text" maxlength = 45 name="mothername" placeholder="Mother's Maiden Name" /></td>
                                <td><input type="number" step = "1" min = "0" max = "999" name="motherage" placeholder="Age" /></td>
                                <td><input type="text" maxlength = 20 name="motheroccupation" placeholder="Occupation" /></td>
                            </tr>
                        </table><br/><br/>

                        <br/>                
                        <table name="siblings">
                            <tr>
                                <td><span class="headers">Siblings</span></td>
                            </tr>
                            <tr>

                                <td>Name of Sibling</td>
                                <td>Age</td>
                                <td>Occupation</td>
                                <td>Company/Location</td>
                                <td></td>
                            </tr>
                            <tr>

                                <td><input type="text" maxlength = 45 name="siblingname" placeholder="ex. Virma Lopez" /></td>
                                <td><input type="number" step = "1" min = "0" max = "999" name="siblingage" placeholder="ex. 14" /></td>
                                <td><input type="text" maxlength = 45 name="siblingoccupation" placeholder="ex. Student" /></td>
                                <td><input type="text" maxlength = 100 name="siblinglocation" placeholder="ex. Binan, Laguna" /></td>
                                <td><button class="addsibling">+</button></td>
                            </tr>
                        </table><br/><br/>
                        <table>
                            <tr>
                                <td>Civil Status</td>
                                <td>
                                     <select name="civilstatus">
                                        <option value="Single">Single</option>
                                        <option value="Married">Married</option>
                                        <option value="Divorced">Divorced</option>
                                        <option value="Widowed">Widowed</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                        <DIV class="tohide">
                            <table>
                                <tr>
                                    <td>Spouse's Name</td>
                                    <td><input type="text" name="spousename" maxlength = 45 placeholder="Name of Spouse" /></td>
                                </tr>
                                <tr>
                                    <td>Spouse's Contact Number</td>
                                    <td><input type="number" min = "0" max = "999999999999" step = "1" name="spousecontact" placeholder="Contact Number" /></td>
                                </tr>
                                <tr>
                                    <td>Spouse's Occupation/Employer</td>
                                    <td><input type="text" maxlength = 20 name="spouseoccupation" placeholder="Occupation/Employer" /></td>
                                </tr>
                            </table><br/><br/>

                            <br/>
                            <table name="children">
                                <tr>
                                    <td><span class="headers">Children</span></td>
                                </tr>
                                <tr>

                                    <td>Name of Child</td>
                                    <td>Age</td>
                                    <td>Occupation</td>
                                    <td>School/Location</td>
                                    <td></td>
                                </tr>
                                <tr>

                                    <td><input type="text" maxlength = 45 name="childrenname" placeholder="ex. Virma Lopez" /></td>
                                    <td><input type="number" min = "0" max = "999" step = "1" name="childrenage" placeholder="ex. 14" /></td>
                                    <td><input type="text" maxlength = 20 name="childrenoccupation" placeholder="ex. Student" /></td>
                                    <td><input type="text" maxlength = 100 name="childrenlocation" placeholder="ex. Binan, Laguna" /></td>
                                    <td><button class="addchild">+</button></td>
                                </tr>
                            </table><br/><br/>
                        </DIV>
                    </DIV>
                    <DIV id="emergencycontact" class="tab-section">
                        <table>
                            <tr>
                                <td>Emergency Contact's Name</td>
                                <td><input type="text" maxlength = 45 name="emergencyname" placeholder="Person to notify in case of emergency" /></td>
                            </tr>
                            <tr>
                                <td>Relationship with Emergency Contact</td>
                                <td><input type="text" maxlength = 20 name="emergencyrel" placeholder="Relationship" /></td>
                            </tr>
                            <tr>
                                <td>Emergency Contact's Address</td>
                                <td><input type="text" maxlength = 100 name="emergencyaddress" placeholder="Address" /></td>
                            </tr>
                            <tr>
                                <td>Emergency Contact's Number</td>
                                <td><input type="number" min = "0" max = "999999999999" step = "1" name="emergencynumber" placeholder="Contact Number" /></td>
                            </tr>
                        </table>
                    </DIV>
                    <DIV id="edhistory" class="tab-section">
                        <%                            Boolean isEarlier = (Boolean) request.getSession().getAttribute("isEarlier");
                            if (isEarlier != null) {
                                if (isEarlier) {
                        %>
                        <span class="headers"><font color = "red" size = "2px">* Error: an end of a school year is earlier than the starting year</font></span><br/><br/>
                            <%
                                    }
                                }
                            %>
                        
                        <table name="elementary">
                            <tr>
                                <td><span class="headers">Elementary</span></td>
                            </tr>
                            <tr>

                                <td>Name of School</td>
                                <td>From</td>
                                <td>To</td>
                                <td>Awards</td>
                            </tr>
                            <tr>
                                <td><input type="text" class = "educationinput" maxlength = 45 name="elemschool" placeholder="ex. Don Bosco School" /></td>
                                <td><input type="number" class = "educationinput" min = "1000" max = "9999" step = "1" name="elemfrom" placeholder="ex. 2000" /></td>
                                <td><input type="number" class = "educationinput" min = "1000" max = "9999" step = "1" name="elemto" placeholder="ex. 2012" /></td>
                                <td><input type="text" maxlength = 45 name="elemawards" placeholder="ex. Perfect Attendance Award" /></td>
                                <td><button class="addelem">+</button></td>
                            </tr>
                        </table><br/><br/>

                        <br/>
                        <table name="highschool">
                            <tr>
                                <td><span class="headers">High School</span></td>
                            </tr>
                            <tr>

                                <td>Name of School</td>
                                <td>From</td>
                                <td>To</td>
                                <td>Awards</td>
                            </tr>
                            <tr>

                                <td><input type="text" class = "educationinput" maxlength = 45 name="highschool" placeholder="Name of School" /></td>
                                <td><input type="number" class = "educationinput" min = "1000" max = "9999" step = "1" name="highschoolfrom" placeholder="Year Start" /></td>
                                <td><input type="number" class = "educationinput" min = "1000" max = "9999" step = "1" name="highschoolto" placeholder="Year End" /></td>
                                <td><input type="text" maxlength = 45 name="highschoolawards" placeholder="Degree Taken/Highest Attainment/Awards" /></td>
                                <td><button class="addhighschool">+</button></td>
                            </tr>
                        </table><br/><br/>

                        <br/>
                        <table name="college">
                            <tr>
                                <td><span class="headers">College</span></td>
                            </tr>
                            <tr>

                                <td>Name of School</td>
                                <td>From</td>
                                <td>To</td>
                                <td>Awards</td>
                            </tr>
                            <tr>

                                <td><input type="text" class = "educationinput" maxlength = 45 name="college" placeholder="Name of School" /></td>
                                <td><input type="number" class = "educationinput" min = "1000" max = "9999" step = "1" name="collegefrom" placeholder="Year Start" /></td>
                                <td><input type="number" class = "educationinput" min = "1000" max = "9999" step = "1" name="collegeto" placeholder="Year End" /></td>
                                <td><input type="text" maxlength = 45 name="collegeawards" placeholder="Degree Taken/Highest Attainment/Awards" /></td>
                                <td><button class="addcollege">+</button></td>
                            </tr>
                        </table><br /><br/>

                        <br/>
                        <table name="vocational">
                            <tr>
                                <td><span class="headers">Vocational</span></td>
                            </tr>
                            <tr>

                                <td>Name of School</td>
                                <td>From</td>
                                <td>To</td>
                                <td>Awards</td>
                            </tr>
                            <tr>

                                <td><input type="text" maxlength = 45 name="vocationalschool" placeholder="Name of School" /></td>
                                <td><input type="number" min = "1000" max = "9999" step = "1" name="vocationalschoolfrom" placeholder="Year Start" /></td>
                                <td><input type="number" min = "1000" max = "9999" step = "1" name="vocationalschoolto" placeholder="Year End" /></td>
                                <td><input type="text" maxlength = 45 name="vocationalschoolawards" placeholder="Degree Taken/Highest Attainment/Awards" /></td>
                                <td><button class="addvocational">+</button></td>
                            </tr>
                        </table><br/><br/>

                        <br/>
                        <table name="masteral">
                            <tr>
                                <td><span class="headers">Masteral</span></td>
                            </tr>
                            <tr>

                                <td>Name of School</td>
                                <td>From</td>
                                <td>To</td>
                                <td>Awards</td>
                            </tr>
                            <tr>

                                <td><input type="text" maxlength = 45 name="masteralschool" placeholder="Name of School" /></td>
                                <td><input type="number" min = "1000" max = "9999" step = "1" name="masteralschoolfrom" placeholder="Year Start" /></td>
                                <td><input type="number" min = "1000" max = "9999" step = "1" name="masteralschoolto" placeholder="Year End" /></td>
                                <td><input type="text" maxlength = 45 name="masteralschoolawards" placeholder="Degree Taken/Highest Attainment/Awards" /></td>
                                <td><button class="addmasteral">+</button></td>
                            </tr>
                        </table><br/><br/>

                        <br/>
                        <table name="others">
                            <tr>
                                <td><span class="headers">Others</span></td>
                            </tr>
                            <tr>

                                <td>Name of School</td>
                                <td>From</td>
                                <td>To</td>
                                <td>Awards</td>
                            </tr>
                            <tr>

                                <td><input type="text" maxlength = 45 name="otherschool" placeholder="Name of School" /></td>
                                <td><input type="number" min = "1000" max = "9999" step = "1" name="otherfrom" placeholder="Year Start" /></td>
                                <td><input type="number" min = "1000" max = "9999" step = "1" name="otherto" placeholder="Year End" /></td>
                                <td><input type="text" maxlength = 45 name="otherawards" placeholder="Degree Taken/Highest Attainment/Awards" /></td>
                                <td><button class="addother">+</button></td>
                            </tr>
                        </table><br/><br/>

                        <br/>
                        <table name="license">
                            <tr>
                                <td><span class="headers">Licenses/Exams</span></td>
                            </tr>
                            <tr>

                                <td>License/Exam Taken</td>
                                <td>Percentage</td>
                            </tr>
                            <tr>

                                <td><input type="text" name="license" placeholder="License/Exam Taken" /></td>
                                <td><input type="number" min = "0" max = "100" name="licensepercentage" placeholder="Percentage" /></td>
                                <td><button class="addlicense">+</button></td>
                            </tr>
                        </table><br/><br/>
                    </DIV>

                    <DIV id="emphistory" class="tab-section">
                        <table name="employment">
                            <tr>

                                <td>Job Title</td>
                                <td>Date of Employment</td>
                                <td>Starting Salary</td>
                                <td>Ending Salary</td>
                            </tr>
                            <tr>

                                <td><input type="text" maxlength = 20 name="jobtitle" placeholder="Job Title" /></td>
                                <td><input type="date" name="jobemploydate" placeholder="Date of Employment" /></td>
                                <td><input type="number" min = "0" max = "9999999" step = "1" name="jobbegsal" placeholder="Starting Salary" /></td>
                                <td><input type="number" name="jobendsal" placeholder="Ending Salary" /></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>Employer's Name</td>
                                <td>Employer's Address</td>
                                <td>Employer's Contact Number</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="text" maxlength = 45 name="jobemployer" placeholder="Employer" /></td>
                                <td><input type="text" maxlength = 100 name="jobaddress" placeholder="Employer Address" /></td>
                                <td><input type="number" min = "0" max = "99999999999" step = "1" name="jobtelno" placeholder="Employer Telephone Number" /></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>Supervisor's Name</td>
                                <td>Supervisor's Contact Number</td>
                                <td>Reason for Leaving</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="text" maxlength = 45 name="jobsupname" placeholder="Supervisor Name" /></td>
                                <td><input type="number" min = "0" max = "99999999999" step = "1" name="jobsupno" placeholder="Supervisor Number" /></td>
                                <td><input type="text" maxlength = 256 name="jobreason" placeholder="Reason for Leaving" /></td>
                                <td><button class="addemployment">+</button></td>
                            </tr>
                        </table><br/>
                    </DIV>

                    <DIV id="crimes" class="tab-section">
                        <table>
                            <tr>
                                <td>Has the employee ever been convicted of a criminal offense?</td>
                                <td><select name="convicted">
                                        <option value = "No">No</option>
                                        <option value = "Yes">Yes</option>
                                    </select></td>
                            </tr>
                        </table>
                        <br/><br/>
                        <DIV class="tohide">
                            <span class="headers">Past criminal offenses</span><br/>
                            <table name="criminaloffense">
                                <tr>
                                    <td>Criminal Offense</td>
                                    <td>Date of Offense</td>
                                    <td>Place of Offense</td>
                                </tr>
                                <tr>
                                    <td><input type="text" maxlength = 45 name="offensename" placeholder="Criminal Offense" /></td>
                                    <td><input type="date" name="offensedate"/></td>
                                    <td><input type="text" maxlength = 100 name="offenseplace" placeholder="Place of Offense" /></td>
                                    <td><button class="addcriminaloffense">+</button></td>
                                </tr>
                            </table>
                        </DIV>
                    </DIV>
                <input type="submit" value="Submit" />
            </form>
          <div id = "bioMessage">
            </div>
          <DIV class= "footer">
            <br/><hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </DIV>
        </DIV> 
            
                        
        

    </body>
</html>
