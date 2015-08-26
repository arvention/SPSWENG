<%-- 
    Document   : ViewEmployeeRecords
    Created on : 04 21, 15, 5:29:38 PM
    Author     : Arces
--%>

<%@page import="Models.modelPhysicalExam"%>
<%@page import="Models.modelIllness"%>
<%@page import="Models.modelCompanyTraining"%>
<%@page import="Models.modelRecord"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Models.modelEmploymentHistory"%>
<%@page import="Models.modelCriminalOffenseHistory"%>
<%@page import="Models.modelLicense"%>
<%@page import="Models.modelEducationHistory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.modelRelative"%>
<%@page import="Database.Database"%>
<%@page import="Models.modelEmployee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>View Employees - EQuilibrium</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel ="shortcut icon" href="img/eq logo.ico"/>
        <link rel="stylesheet" type="text/css" media="all" href="css/ViewEmployeeRecords.css"/>
        <link rel="stylesheet" type="text/css" media="all" href= "css/navigationBar.css"/>
        <script src="js/jquery.min.js"></script>
        <script src="js/ViewEmployeeRecords.js"></script>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css"/>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/jquery-ui.js"></script>

        <%
            modelEmployee emp = (modelEmployee) request.getSession().getAttribute("viewEmp");
            Database db = Database.getInstance();
            modelEmployee user = (modelEmployee) request.getSession().getAttribute("employee");
        %>
        <script>
            $(document).ready(function() {

            <%
                int[] count = db.checkEmployeeData(emp.getEntryNum());
                if (count[0] == 0) {
            %>  // check relative count
                $("select").find("option[value=\"relations\"]").attr("disabled", "true");
            <% }
                if (count[1] == 0) {
            %>  // check employment history count
                $("select").find("option[value=\"history\"]").attr("disabled", "true");
            <% }
                if (count[2] == 0) {
            %>  // check criminal offense count
                $("select").find("option[value=\"others\"]").attr("disabled", "true");
            <% }
                if (count[3] == 0) {
            %>  // check documents count
                $("select").find("option[value=\"docs\"]").attr("disabled", "true");
            <% }%>

                var sugg = [];
                var search;
                $("#search").keyup(function() {
                    search = $("#search").val();
                    search = search.trim();
                    console.log("HEREE");
                    $.get('AutoCompleteServlet', {keyword: search}, function(responseText) {
                        console.log(responseText);
                        sugg = responseText.split("\n");
                        console.log(sugg);
                        $("#search").autocomplete({
                            source: sugg
                        });
                    });
                });

                function readURL(input) {
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();
                        if (input.files && input.files[0]) {
                            var reader = new FileReader();
                            reader.onload = function(e) {
                                $('#frameforpic').attr('src', e.target.result);
                            };
                            reader.readAsDataURL(input.files[0]);
                        }
                    }
                }

                $("#imgInp").change(function() {
                    readURL(this);
                });
                $(".downloadButton").click(function() {
                    $("#listoffiles").submit(function(e) {
                        e.preventDefault(); // this will prevent from submitting the form.
                    });
                    window.location.href = "GetImage?id=" + this.id;
                });

                $('#savepicform').on('submit', (function(e) {
                    e.preventDefault();
                    var formData = new FormData(this);

                    $.ajax({
                        type: 'POST',
                        url: $(this).attr('action'),
                        data: formData,
                        cache: false,
                        contentType: false,
                        processData: false,
                        success: function(data) {
                            $('#imgInp').val("");

                            if (data === "0")
                                alert("Success!");

                            else if (data === "1") {
                                alert("Picture too Large");
                                $("#frameforpic").attr("src", "DisplayImage?id=<%=emp.getEmployeeID()%>");
                            }

                            if (data === "2")
                                alert("Upload a picture first");

                            console.log(data);
                        },
                        error: function() {
                            alert("The size of the picture exceeds the limit");
                        }
                    });
                }));

            <%
                if (emp.getEmployeeType() != null) {
            %>
                $("#empType").find("option[value=\"<%=emp.getEmployeeType()%>\"]").attr('selected', 'selected');
            <%   }
            %>
            });
        </script>  
    </head>

    <body bgcolor ="#E8E8E8">
        <%
            modelEmployee m = (modelEmployee) session.getAttribute("employee");

            if (m.getEmployeeType().equals("Hr Head")) {
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
        } else if (m.getEmployeeType().equals("Hr Employee")) {

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
        <%        } else if (m.getEmployeeType().equals("Senior Manager")) {

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
        <%        } else if (m.getEmployeeType().equals("Manager")) {
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
        } else if (m.getEmployeeType().equals("Employee")) {
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
        <div id="alert">
            Are you sure you want to delete this content?<br/>
            <input type="button" value="Yes" class="alertButton">
            <input type="button" value="No" class="alertButton">
        </div>

        <div id="overlay"></div>

        <div id="all">
            <div class= "pageLeft">
                <form id="savepicform" action="SaveProfilePic" method="POST" enctype="multipart/form-data" >
                    <img id="frameforpic" class = "empPicture" src="DisplayImage?id=<%=emp.getEmployeeID()%>"/><br/>
                    <%
                        if (user.getEmployeeType().equals("Hr Employee") || user.getEmployeeType().equals("Hr Head")) {
                    %>
                    <input type='file' id="imgInp" name="filename" accept="image/*"/>
                    <!--  <input id="changetheimage" class="botan" type="button" value="Change Image"/> -->    <br/>
                    <input id="savepicchange" class="button" type="submit" value="Save Changes"/> 
                    <%}%>
                    <input type="hidden" name="id" value="<%=emp.getEntryNum()%>" />
                </form>  
            </div>
            <div id="main">
                <div class="pageTop">
                    <div id="box">
                        <div id="header">
                            <span id="name"><b><%=emp.getFirstName()%> <%=emp.getLastName()%></b></span>
                        </div>
                        <select id="options" size="6">
                            <option selected value="personal">General Information</option> <!--complete name, position applied for or expected salary, home address, birthday, 
                                                                                                                                    birthplace, home phone number, mobile number, email address, civil status, citizenship and religion-->
                            <option value="relations">Relations</option> <!--name, age, occupation and company of occupation of the employee’s siblings and parents. Information 
                                                                                                                    regarding the spouse’s name, contact number and occupation or employer is added, as well as the names of their children, age, grade or year and the school of the children-->	
                            <option value="edu">Education</option> <!--elementary, high school, college, vocational, masters and others. In the history, the name of 
                                                                                                                    school, years the employee has studied in that school and the awards given by the school to the employee are mentioned. The bio-data also includes the licensure exams taken and the score of the employee in the exams-->
                            <option value="history">Employment History</option> <!--job names, date of employment, beginning & ending salary, employer’s name, employer’s address, 
                                                                                                                            employer’s telephone number, supervisor’s name, supervisor’s contact number and reason for leaving-->
                            <!--The form also cites whether the employee has been convicted of a criminal offense and writes the details 
                                                                                                       of that offense. -->
                            <option value="training">Trainings</option> <!--Company Involvement-->
                            <option value="med">Medical History</option> <!--Medical History-->
                            <option value="docs">Documents</option> <!--other important documents connected to the employee such as: employment contract, memorandums of 
                                                                                                                disciplinary actions, records of filed leaves, recognitions, and awards-->

                        </select>
                        <%if (user.getEmployeeType().equals("Hr Employee") || user.getEmployeeType().equals("Hr Head")) {%>
                        <form onsubmit = "return editData('<%=user.getEmployeeType()%>', <%=emp.getEmployeeID()%>)" id = "info-form">
                            <%}%>

                            <%
                                if (user.getEmployeeType().equals("Hr Employee") || user.getEmployeeType().equals("Hr Head")) {
                            %>
                            <div class = "editSpan"><span class = "editMessage">Click on an entry to change its content</span><input type="button" onclick = "return false;" value="Edit" id="editButton"><input type = "submit" value = "Save" id = "saveButton"/></div>
                                <%}%>

                            <div id="personal" class="pages">
                                <br><br>
                                <div class="content">
                                    <b>Personal:</b><br><br>
                                    <div class="line"><span class="label">First Name</span>
                                        <input name = "firstname" type = "text" class="data" value = "<%=emp.getFirstName()%>" readonly/></div>
                                    <div class="line"><span class="label">Middle Name</span>
                                        <input name = "middlename" type = "text" class="data" value = "<%=emp.getMiddleName()%>" readonly/></div>
                                    <div class="line"><span class="label">Last Name</span>
                                        <input name = "lastname" type = "text" class="data" value = "<%=emp.getLastName()%>" readonly/></div>
                                    <div class="line"><span class="label">ID Number</span>
                                        <%=emp.getEmployeeID()%></div>
                                    <div class="line"><span class="label">Date of Birth</span>
                                        <input name = "birthday" type = "date" class="data" value = "<%=new SimpleDateFormat("yyyy-MM-dd").format(emp.getBirthday())%>" readonly/></div>
                                    <div class="line"><span class="label">Place of Birth</span>
                                        <input name = "birthplace" type = "text" class="data" value = "<%=emp.getBirthplace()%>" readonly/></div>
                                    <div class="line"><span class="label">Home Address</span>
                                        <input name = "address" type = "text" class="data" value = "<%=emp.getAddress()%>" readonly/></div>
                                    <div class="line"><span class="label">Home Phone Number</span>
                                        <input name = "homephone" type = "number" class="data" value ="<%=emp.getHomePhone()%>" readonly/></div>
                                    <div class="line"><span class="label">Mobile Number</span>
                                        <input name = "mobile" type = "number" class="data" value = "<%=emp.getMobileNumber()%>" readonly/></div>
                                    <div class="line"><span class="label">Email Address</span>
                                        <input name = "emailadd" type = "text" class="data" value = "<%=emp.getEmailAddress()%>" readonly/></div>
                                    <div class="line"><span class="label">Civil Status</span>
                                        <input name = "civilstatus" type = "text" class="data" value = "<%=emp.getCivilStatus()%>" readonly/><span class = "editNote"><br>*Input civil status (Single, Married, Divorced, Widowed)</span></div>
                                    <div class="line"><span class="label">Citizenship</span>
                                        <input name = "citizenship" type = "text" class="data" value = "<%=emp.getCitizenship()%>" readonly/></div>
                                    <div class="line"><span class="label">Religion</span>
                                        <input name = "religion" type = "text" class="data" value = "<%=emp.getReligion()%>" readonly/></div>

                                    <br><b>Others:</b><br><br>
                                    <div class="line"><span class="label">Hire Date</span>
                                        <%=emp.getHireDate()%></div>
                                    <div class="line"><span class="label">Position</span>
                                        <input name = "position" type = "text" class="data" value = "<%=emp.getPositionName()%>" readonly/></div>
                                    <div class="line"><span class="label">Expected Salary</span>
                                        <input name = "salary" type = "number" class="data" value = "<%=emp.getSalary()%>" readonly/></div>
                                    <div class="line"><span class="label">SSS #</span>
                                        <input name = "sssnum" type = "text" class="data" value = "<%=emp.getSSSNumber()%>" readonly/></div>
                                    <div class="line"><span class="label">TIN #</span>
                                        <input name = "tinnum" type = "text" class="data" value = "<%=emp.getTINNumber()%>" readonly/></div>
                                    <div class="line"><span class="label">PHIC #</span>
                                        <input name = "phicnum" type = "text" class="data" value = "<%=emp.getPHICNumber()%>" readonly/></div>
                                    <div class="line"><span class="label">PAGIBIG #</span>
                                        <input name = "pagibignum" type = "text" class="data" value = "<%=emp.getPAGIBIGNumber()%>" readonly/></div>
                                    <div class="line"><span class="label">Band</span>
                                        <input name = "band" type = "text" class="data" value = "<%=emp.getBand()%>" readonly/></div>
                                    <div class="line"><span class="label">Manager </span>
                                        <input type = "hidden" name = "manageridnum" value = "<%=db.getEmployeeID(emp.getManagerEntryNum())%>"/>
                                        <input type = "hidden" name = "managername" value = "<%=db.getFirstName(emp.getManagerEntryNum())%> <%=db.getLastName(emp.getManagerEntryNum())%>"/>
                                        <input name = "managerid" type = "text" class="data" value = "<%=db.getFirstName(emp.getManagerEntryNum())%> <%=db.getLastName(emp.getManagerEntryNum())%>" readonly/><span class = "editNote"><br>*Input the manager's ID number</span>
                                        <br><span id = "managerError" class = "editNote"><b>*Employee ID not found</b></span> 
                                    </div>
                                    <%
                                        if (emp.getEmployeeType() != null) {
                                    %>
                                    <div class="line"><span class="label">Account Type </span><input type ="text" class = "data" id = "select-temp" readonly value = "<%=emp.getEmployeeType()%>"/>
                                        <select name = "empType" id = "empType" class = "select-input">
                                            <option value = "Employee">Employee</option>
                                            <option value = "Hr Employee">HR Employee</option>
                                            <option value = "Hr Head">HR Head</option>
                                            <option value = "Manager">Manager</option>
                                            <option value = "Senior Manager">Senior Manager</option>
                                        </select>
                                        <%}%>
                                    </div>
                                </div>
                            </div>
                            <div id="relations" class="pages">
                                <br><br>
                                <div class="content">
                                    <%
                                        if (!emp.getCivilStatus().equals("Single")) {
                                            modelRelative spouse = db.getSpouse(emp.getEntryNum());
                                            ArrayList<modelRelative> children = db.getRelatives("child", emp.getEntryNum());
                                    %>
                                    <div>
                                        <%
                                            if (spouse != null) {
                                        %>
                                        <div class="label-rel">
                                            Spouse
                                        </div>
                                        <div class="subContent">
                                            <div class="line"><span class="label"><b>Name</b></span>
                                                <input type = "text" class="data" name = "spousename" value = "<%=spouse.getName()%>" readonly/></div>
                                            <div class="line"><span class="label">Contact Number</span>
                                                <input type = "number" min ="0" max = "99999999999" class="data" name = "spousecontact" value = "<%=spouse.getContactNum()%>" readonly/></div>
                                            <div class="line"><span class="label">Occupation/Employer</span>
                                                <input type = "text" class="data" name = "spouseoccupation" value = "<%=spouse.getOccupation()%>" readonly/></div>
                                            <input type = "hidden" name = "spouseid" value = "<%=spouse.getRelativeID()%>"/>
                                        </div>
                                        <br>
                                        <%}%>
                                    </div>

                                    <div>
                                        <%
                                            if (children.size() != 0) {
                                        %>
                                        <div class="label-rel">
                                            Children
                                        </div>
                                        <%
                                            for (modelRelative child : children) {
                                        %>
                                        <div class="subContent">
                                            <div class="line"><span class="label"><b>Name</b></span>
                                                <input type = "text" class="data" name = "childname" value = "<%=child.getName()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Age</span>
                                                <input type = "number" min ="0" class="data" name = "childage" value = "<%=child.getAge()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Occupation</span>
                                                <input type = "text" class="data" name = "childoccupation" value = "<%=child.getOccupation()%>" readonly/></div>
                                            <div class="line"><span class="label">School/Location</span>
                                                <input type = "text" class="data" name = "childlocation" value = "<%=child.getOccupationLocation()%>" readonly/></div><br/>
                                            <input type = "hidden" name = "childid" value = "<%=child.getRelativeID()%>"/>
                                        </div>
                                        <br>
                                        <%
                                                }
                                            }
                                        %>
                                    </div>

                                    <%
                                        }
                                        modelRelative father = db.getParent("father", emp.getEntryNum());
                                        modelRelative mother = db.getParent("mother", emp.getEntryNum());
                                        ArrayList<modelRelative> siblings = db.getRelatives("sibling", emp.getEntryNum());
                                    %>
                                    <div>
                                        <!--div class="label-rel">
                                            <b>Parents</b>
                                        </div-->
                                        <%
                                            if (father != null) {
                                        %>
                                        <div class="subContent">
                                            <div class="label-rel">Father</div>
                                            <div class="line"><span class="label"><b>Name</b></span>
                                                <input type = "text" class="data" name = "fathername" value = "<%=father.getName()%>" readonly/></div>
                                            <div class="line"><span class="label">Age</span>
                                                <input type = "number" min ="0" class="data" name = "fatherage" value = "<%=father.getAge()%>" readonly/></div>
                                            <div class="line"><span class="label">Occupation</span>
                                                <input type = "text" class="data" name = "fatheroccupation" value = "<%=father.getOccupation()%>" readonly/></div>
                                            <input type = "hidden" name = "fatherid" value = "<%=father.getRelativeID()%>"/>
                                        </div>
                                        <br>
                                        <%}
                                            if (mother != null) {
                                        %>
                                        <div class="subContent">
                                            <div class="label-rel">Mother</div>
                                            <div class="line"><span class="label"><b>Name</b></span>
                                                <input type = "text" class="data" name = "mothername" value = "<%=mother.getName()%>" readonly/></div>
                                            <div class="line"><span class="label">Age</span>
                                                <input type = "number" min ="0" class="data" name = "motherage" value = "<%=mother.getAge()%>" readonly/></div>
                                            <div class="line"><span class="label">Occupation</span>
                                                <input type = "text" class="data" name = "motheroccupation" value = "<%=mother.getOccupation()%>" readonly/></div>
                                            <input type = "hidden" name = "motherid" value = "<%=mother.getRelativeID()%>"/>
                                        </div>
                                        <br>
                                        <%}%>
                                    </div>

                                    <div>   
                                        <%
                                            if (siblings.size() != 0) {
                                        %>
                                        <div class="label-rel">
                                            Siblings
                                        </div>
                                        <%
                                            for (modelRelative sibling : siblings) {
                                        %>
                                        <div class="subContent">
                                            <div class="line"><span class="label"><b>Name</b></span>
                                                <input type = "text" class="data" name = "siblingname" value = "<%=sibling.getName()%>" readonly/></div>
                                            <div class="line"><span class="label">Age</span>
                                                <input type = "number" min ="0" class="data" name = "siblingage" value = "<%=sibling.getAge()%>" readonly/></div>
                                            <div class="line"><span class="label">Occupation</span>
                                                <input type = "text" class="data" name = "siblingoccupation" value = "<%=sibling.getOccupation()%>" readonly/></div>
                                            <div class="line"><span class="label">Company/Location</span>
                                                <input type = "text" class="data" name = "siblinglocation" value = "<%=sibling.getOccupationLocation()%>" readonly/></div>
                                            <input type = "hidden" name = "siblingid" value = "<%=sibling.getRelativeID()%>"/>
                                        </div>
                                        <br>
                                        <%
                                                }
                                            }
                                        %>
                                    </div>
                                </div>
                            </div>

                            <div id="edu" class="pages">
                                <br><br>
                                <%
                                    ArrayList<modelEducationHistory> schoolList;
                                %>
                                <div class="content">
                                    <div name = "elem">
                                        <%
                                            schoolList = db.getEducation("Elementary", emp.getEntryNum());
                                        %>
                                        <div class="label-rel">
                                            Elementary
                                        </div>
                                        <%
                                            for (modelEducationHistory school : schoolList) {
                                        %>
                                        <div class="subContent">
                                            <div class="line"><span class="label"><b>Name of School</b></span>
                                                <input type = "text" class="data" name = "elemname" value = "<%=school.getSchoolName()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Years</span>
                                                <input type = "number" class="data" name = "elemfrom" value = "<%=school.getYearFrom()%>" readonly/> to <input type = "number" class="data" name = "elemto" value = "<%=school.getYearTo()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Awards</span>
                                                <input type = "text" class="data" name = "elemaward" value = "<%=school.getAward()%>" readonly/>
                                            </div>
                                            <input type = "hidden" name = "elemid" value = "<%=school.getEducationHistoryID()%>">
                                            <br/>
                                        </div>
                                        <%}%>
                                    </div>

                                    <div name = "high">
                                        <div class="label-rel">
                                            High School
                                        </div>
                                        <%
                                            schoolList = db.getEducation("High School", emp.getEntryNum());
                                            for (modelEducationHistory school : schoolList) {
                                        %>
                                        <div class="subContent">
                                            <div class="line"><span class="label"><b>Name of School</b></span>
                                                <input type = "text" class="data" name = "highschoolname" value = "<%=school.getSchoolName()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Years</span>
                                                <input type = "number" class="data" name = "highschoolfrom" value = "<%=school.getYearFrom()%>" readonly/> to <input type = "number" class="data" name = "hishschoolto" value = "<%=school.getYearTo()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Awards</span>
                                                <input type = "text" class="data" name = "highschoolaward" value = "<%=school.getAward()%>" readonly/>
                                            </div>
                                            <input type = "hidden" name = "highschool" value = "<%=school.getEducationHistoryID()%>">
                                            <br/>
                                        </div>
                                        <%}%>
                                    </div>

                                    <div name = "college">
                                        <div class="label-rel">
                                            College
                                        </div>
                                        <%
                                            schoolList = db.getEducation("College", emp.getEntryNum());
                                            for (modelEducationHistory school : schoolList) {
                                        %>
                                        <div class="subContent">
                                            <div class="line"><span class="label"><b>Name of School</b></span>
                                                <input type = "text" class="data" name = "collegename" value = "<%=school.getSchoolName()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Years</span>
                                                <input type = "number" class="data" name = "collegefrom" value = "<%=school.getYearFrom()%>" readonly/> to <input type = "number" class="data" name = "collegeto" value = "<%=school.getYearTo()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Awards</span>
                                                <input type = "text" class="data" name = "collegeaward" value = "<%=school.getAward()%>" readonly/>
                                            </div>
                                            <input type = "hidden" name = "collegeid" value = "<%=school.getEducationHistoryID()%>">
                                            <br/>
                                        </div>
                                        <%}%>
                                    </div>

                                    <%
                                        schoolList = db.getEducation("Vocational", emp.getEntryNum());
                                        if (schoolList.size() != 0) {
                                    %>
                                    <div>
                                        <div class="label-rel">
                                            Vocational
                                        </div>
                                        <%
                                            for (modelEducationHistory school : schoolList) {
                                        %>
                                        <div class="subContent">
                                            <div class="line"><span class="label"><b>Name of School</b></span>
                                                <input type = "text" class="data" name = "vocationalname" value = "<%=school.getSchoolName()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Years</span>
                                                <input type = "number" class="data" name = "vocationalfrom" value = "<%=school.getYearFrom()%>" readonly/> to <input type = "number" class="data" name = "vocationalto" value = "<%=school.getYearTo()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Awards</span>
                                                <input type = "text" class="data" name = "vocationalaward" value = "<%=school.getAward()%>" readonly/>
                                            </div>
                                            <input type = "hidden" name = "vocationalid" value = "<%=school.getEducationHistoryID()%>">
                                            <br/>
                                        </div>
                                    </div>
                                    <%
                                            }
                                        }
                                    %>
                                    <%
                                        schoolList = db.getEducation("Masteral", emp.getEntryNum());
                                        if (schoolList.size() != 0) {
                                    %>
                                    <div>
                                        <div class="label-rel">
                                            Masters
                                        </div>
                                        <%
                                            for (modelEducationHistory school : schoolList) {
                                        %>
                                        <div class="subContent">
                                            <div class="line"><span class="label"><b>Name of School</b></span>
                                                <input type = "text" class="data" name = "mastername" value = "<%=school.getSchoolName()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Years</span>
                                                <input type = "number" class="data" name = "masterfrom" value = "<%=school.getYearFrom()%>" readonly/> to <input type = "number" class="data" name = "masterto" value = "<%=school.getYearTo()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Awards</span>
                                                <input type = "text" class="data" name = "masteraward" value = "<%=school.getAward()%>" readonly/>
                                            </div>
                                            <input type = "hidden" name = "masterid" value = "<%=school.getEducationHistoryID()%>">
                                            <br/>
                                        </div>
                                    </div>

                                    <%
                                            }
                                        }
                                    %>

                                    <%
                                        schoolList = db.getEducation("Others", emp.getEntryNum());
                                        if (schoolList.size() != 0) {
                                    %>
                                    <div>
                                        <div class="label-rel">
                                            Others
                                        </div>
                                        <%
                                            for (modelEducationHistory school : schoolList) {
                                        %>
                                        <div class="subContent">
                                            <div class="line"><span class="label"><b>Name of School</b></span>
                                                <input type = "text" class="data" name = "othername" value = "<%=school.getSchoolName()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Years</span>
                                                <input type = "number" class="data" name = "otherfrom" value = "<%=school.getYearFrom()%>" readonly/> to <input type = "number" class="data" name = "otherto" value = "<%=school.getYearTo()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Awards</span>
                                                <input type = "text" class="data" name = "otheraward" value = "<%=school.getAward()%>" readonly/>
                                            </div>
                                            <input type = "hidden" name = "otherid" value = "<%=school.getEducationHistoryID()%>">
                                            <br/>
                                        </div>
                                    </div>

                                    <%
                                            }
                                        }
                                    %>

                                    <%
                                        ArrayList<modelLicense> licenseList = db.getLicenses(emp.getEntryNum());
                                        if (licenseList.size() != 0) {
                                    %>
                                    <div>
                                        <div class="label-rel">
                                            Licensure Exams
                                        </div>
                                        <%
                                            for (modelLicense license : licenseList) {
                                        %>
                                        <div class="subContent">
                                            <div class="line"><span class="label"><b>Name</b></span>
                                                <input type = "text" class="data" name = "licensename" value = "<%=license.getLicenseName()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Score</span>
                                                <input type = "number" min = "0" class="data" name = "licensescore" value = "<%=license.getPercentage()%>" readonly/>
                                            </div>
                                            <br>
                                            <input type ="hidden" value = "<%=license.getLicenseID()%>" name = "licenseid" />
                                        </div>
                                    </div>
                                    <%
                                            }
                                        }
                                    %>
                                </div>
                            </div>
                            <div id="history" class="pages">
                                <br><br>
                                <div class="content"> 
                                    <div>
                                        <div class="label-rel">
                                            Employment History
                                        </div>
                                        <%
                                            ArrayList<modelEmploymentHistory> empHistory = db.getEmploymentHistory(emp.getEntryNum());
                                            for (modelEmploymentHistory empHisto : empHistory) {
                                        %>
                                        <div class="subContent">
                                            <div class="line"><span class="label"><b>Occupation</b></span>
                                                <input type = "text" class="data" name = "histooccupation" value = "<%=empHisto.getJobTitle()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Date of Employment</span>
                                                <input type = "date" class="data" name = "histodate" value = "<%=new SimpleDateFormat("yyyy-MM-dd").format(empHisto.getDateOfEmployment())%>" readonly/></div>
                                            <div class="line"><span class="label">Beginning Salary</span>
                                                <input type = "number" min = "0" class="data" name = "histostartsalary" value = "<%=empHisto.getStartingSalary()%>" readonly/></div>
                                            <div class="line"><span class="label">Ending Salary</span>
                                                <input type = "number" min = "0" class="data" name = "histoendsalary" value = "<%=empHisto.getEndingSalary()%>" readonly/>
                                            </div>
                                            <div class="line"><span class="label">Name of Employer</span>
                                                <input type = "text" class="data" name = "histoemployername" value = "<%=empHisto.getEmployerName()%>" readonly/></div>
                                            <div class="line"><span class="label">Address of Employer</span>
                                                <input type = "text" class="data" name = "histoemployeraddress" value = "<%=empHisto.getEmployerAddress()%>" readonly/></div>
                                            <div class="line"><span class="label">Contact Number of Employer</span>
                                                <input type = "number" min = "0" class="data" name = "histoemployercontact" value = "<%=empHisto.getEmployerContactNum()%>" readonly/></div>
                                            <div class="line"><span class="label">Name of Supervisor</span>
                                                <input type = "text" class="data" name = "histosupervisorname" value = "<%=empHisto.getSupervisorName()%>" readonly/></div>
                                            <div class="line"><span class="label">Contact Number of Supervisor</span>
                                                <input type = "number" min = "0" class="data" name = "histosupervisorcontact" value = "<%=empHisto.getSupervisorContactNum()%>" readonly/></div>
                                            <div class="line"><span class="label">Reason for leaving</span>
                                                <input type = "text" class="data" name = "historeason" value = "<%=empHisto.getReasonForLeaving()%>" readonly/></div>
                                        </div>
                                        <input type = "hidden" name = "histoid" value = "<%=empHisto.getEmploymentHistoryID()%>"/>
                                        <br>
                                        <%}%>
                                    </div>
                                </div>
                            </div>

                            <!------------------>

                            <div id="training" class="pages">
                                <div class="content">
                                    <br><br>
                                    <%
                                        ArrayList<modelCompanyTraining> trainingList = db.getCompanyTrainings(emp.getEntryNum());

                                        for (modelCompanyTraining training : trainingList) {
                                    %>
                                    <div class = "line"><span class ="label"><b>Date</b></span>
                                        <input name = "trainingdate" type = "date" class="data" value = "<%=new SimpleDateFormat("yyyy-MM-dd").format(training.getDate())%>" readonly/></div>
                                    <div class = "line"><span class ="label"><b>Name of Activity</b></span>
                                        <input name = "trainingname" type = "text" class="data" value = "<%=training.getTrainingName()%>" readonly/></div>
                                    <div class = "line"><span class ="label"><b>Venue of Activity</b></span>
                                        <input name = "trainingvenue" type = "text" class="data" value = "<%=training.getTrainingVenue()%>" readonly/></div>
                                    <input type = "hidden" name = "trainingid" value ="<%=training.getCompanyTrainingID()%>"/>
                                    <br>
                                    <%}%>
                                    <!-- guys pls make this similar to the the one in the documents tab. 
                                    i made it really similar i just need this to display details and be dynamic
                                    exactly like how you display the list of memos in documents tab. except it
                                    displays company involvement-->
                                </div>
                            </div>

                            <div id="med" class="pages">
                                <div class="content">
                                    <br><br>
                                    <%
                                        String bloodType = emp.getBloodType();
                                    %>
                                    <div>
                                        <div class = "line"><span class ="label"><b>Blood Type</b></span>
                                            <input name = "bloodType" type = "text" class="data" value = "<%=bloodType%>" readonly/>
                                        </div>
                                    </div>
                                    <br>
                                    <%
                                        ArrayList<modelIllness> illnessList = db.getIllness(emp.getEntryNum());
                                        if (illnessList.size() != 0) {
                                    %>
                                    <div>
                                        <div class="label-rel">
                                            Illness
                                        </div>
                                        <%
                                            for (modelIllness illness : illnessList) {
                                        %>
                                        <div class="subContent">
                                            <div class = "line"><span class ="label"><b>Illness</b></span>
                                                <input name = "illnessName" type = "text" class="data" value = "<%=illness.getIllnessName()%>" readonly/></div>
                                            <div class = "line"><span class ="label"><b>Age</b></span>
                                                <input name = "illnessAge" type = "number" class="data" value = "<%=illness.getAge()%>" readonly/></div>
                                            <input type = "hidden" name = "illnessID" value ="<%=illness.getIllnessID()%>"/>
                                        </div>
                                        <br>
                                        <%
                                            }%>

                                    </div>
                                    <%
                                        }
                                        ArrayList<modelPhysicalExam> examList = db.getPhysicalExam(emp.getEntryNum());
                                        if (examList.size() != 0) {
                                    %>
                                    <div>
                                        <div class="label-rel">
                                            Annual Physical Examination
                                        </div>
                                        <%
                                            for (modelPhysicalExam exam : examList) {
                                        %>
                                        <div class="subContent">
                                            <div class = "line"><span class ="label"><b>Findings</b></span>
                                                <input name = "findings" type = "text" class="data" value = "<%=exam.getFindings()%>" readonly/></div>
                                            <div class = "line"><span class ="label"><b>Date Taken</b></span>
                                                <input name = "dateTaken" type = "date" class="data" value = "<%=new SimpleDateFormat("yyyy-MM-dd").format(exam.getDate())%>" readonly/></div>
                                            <div class = "line"><span class ="label"><b>Remarks</b></span>
                                                <input name = "remarks" type = "text" class="data" value = "<%=exam.getRemarks()%>" readonly/></div>
                                            <input type = "hidden" name = "examID" value ="<%=exam.getPhysicalExamID()%>"/>
                                        </div>
                                        <br>
                                        <%
                                            }
                                        %>
                                    </div>
                                    <%
                                        }
                                    %>
                                </div>
                            </div>

                            <%if (user.getEmployeeType().equals("Hr Employee") || user.getEmployeeType().equals("Hr Head")) {%>
                        </form>
                        <%}%>

                        <div id= "docs" class="pages">
                            <div class="content"> 
                                <select id="docs-select">
                                    <option selected value = "memo">Memorandums of Disciplinary Actions</option>
                                    <option value = "awards">Recognitions and Awards</option>
                                    <option value = "evaluation">Evaluation</option>
                                </select>
                                <span id="chooseDoc">Choose a document type</span>
                                <br>
                                <br>
                                <br>
                                <%
                                    ArrayList<modelRecord> recordList = db.getRecords("memo", emp.getEntryNum());
                                %>
                                <%if (user.getEmployeeType().equals("Hr Employee") || user.getEmployeeType().equals("Hr Head")) {%>
                                <form id="listoffiles">
                                    <%}%>
                                    <div class ="subContent">
                                        <div id = "memo">
                                            <%
                                                for (modelRecord record : recordList) {
                                            %>
                                            <div class = "line"><span class ="label"><b>Date</b></span>
                                                <%=new SimpleDateFormat("MMM dd, yyyy h:mm a").format(record.getDate())%>
                                                <%if (db.isFile(record.getRecordID())) {%>
                                                <button class = "downloadButton" id="<%=record.getRecordID()%>">Download File</button>
                                                <% }%>
                                            </div>
                                            <div class = "line"><span class ="label"><b>Disciplinary Record Type</b></span>
                                                <%=record.getDisciplinaryRecordType()%></div>
                                            <div class = "line"><span class ="label"><b>Disciplinary Comment</b></span>
                                                <%=record.getDisciplinaryComment()%></div>
                                            <br>
                                            <%}%>
                                        </div>
                                        <div id = "awards">
                                            <%
                                                recordList = db.getRecords("award", emp.getEntryNum());

                                                for (modelRecord record : recordList) {
                                            %>
                                            <div class = "line"><span class ="label"><b>Award Name</b></span>
                                                <%=record.getAwardName()%>
                                                <button class = "downloadButton" value="<%=record.getRecordID()%>">Download File</button>
                                                <%if (db.isFile(record.getRecordID())) {%>
                                                <button class = "downloadButton" id="<%=record.getRecordID()%>">Download File</button>
                                                <% }%>
                                            </div>
                                            <div class = "line"><span class ="label"><b>Date</b></span>
                                                <%=new SimpleDateFormat("MMM dd, yyyy h:mm a").format(record.getDate())%>
                                            </div>
                                            <br>
                                            <%}%>
                                        </div>

                                        <div id = "evaluation">
                                            <%
                                                recordList = db.getRecords("evaluation", emp.getEntryNum());

                                                for (modelRecord record : recordList) {
                                            %>
                                            <div class = "line"><span class ="label"><b>Evaluation Name</b></span>
                                                <%=record.getEvaluationName()%>
                                                <%if (db.isFile(record.getRecordID())) {%>
                                                <button class = "downloadButton" id="<%=record.getRecordID()%>">Download File</button>
                                                <% }%>
                                            </div>
                                            <div class = "line"><span class ="label"><b>Score</b></span>
                                                <%=record.getEvaluationScore()%>
                                            </div>
                                            <br>
                                            <%}%>
                                        </div>
                                    </div> 
                                    <%if (user.getEmployeeType().equals("Hr Employee") || user.getEmployeeType().equals("Hr Head")) {%>
                                </form>
                                <%}%>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- end of box -->
        </div> <!-- end of all -->

        <div class = "footer">
            <hr width = "75%">
            EQUILIBRIUM INTERTRADE CORP.
        </div>
    </body>
</html>
