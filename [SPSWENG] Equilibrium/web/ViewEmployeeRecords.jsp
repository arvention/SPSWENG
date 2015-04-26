<%-- 
    Document   : ViewEmployeeRecords
    Created on : 04 21, 15, 5:29:38 PM
    Author     : Arces
--%>

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
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

        <%
            modelEmployee emp = (modelEmployee) request.getSession().getAttribute("viewEmp");
            Database db = Database.getInstance();
            modelEmployee user = (modelEmployee) request.getSession().getAttribute("employee");
        %>
        <script>
            $(document).ready(function() {
                
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
           /*     
            $('#savepicform').ajaxForm({
                console.log("it's here");
                complete: function(xhr) {
                alert("Upload complete");   
                } 
            });  
            */
           
           
     $('#savepicform').on('submit',(function(e) {
        e.preventDefault();
        var formData = new FormData(this);

        $.ajax({
            type:'POST',
            url: $(this).attr('action'),
            data:formData,
            cache:false,
            contentType: false,
            processData: false,
            success:function(data){
                $('#imgInp').val("");
                
                
                
                if(data === "0")
                alert("Success!");
                
                else if(data==="1"){
                    alert("Picture too Large"); 
                    $("#frameforpic").attr("src","DisplayImage?id=<%=emp.getEmployeeID()%>");
                }
                
                 if(data === "2")
                alert("Upload a picture first");
                
                console.log(data);
            },
            error: function(data){
                alert("Picture too Large");
              //console.log(data);
            }
        });
    }));
           
           
           
        
            });
        </script>  


    </head>

    <body bgcolor ="#E8E8E8">
        <%
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
        <div id="alert">
            Are you sure you want to delete this content?<br/>
            <input type="button" value="Yes" class="alertButton">
            <input type="button" value="No" class="alertButton">
        </div>

        <div id="overlay"></div>
        
        <div id="all">
        <div class= "pageLeft">
            <form action="SaveProfilePic" method="POST" enctype="multipart/form-data" >
            <img id="frameforpic" class = "empPicture" src="DisplayImage?id=<%=emp.getEmployeeID()%>"/><br/>
            <input type='file' id="imgInp" name="filename" id="fileButton" accept="image/*"/>
            <input id="savepicchange" type="submit" value="Save Changes" class="button"/>
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
                        <option selected value="personal">Personal</option> <!--complete name, position applied for or expected salary, home address, birthday, 
                                                                                                                                birthplace, home phone number, mobile number, email address, civil status, citizenship and religion-->
                        <option value="relations">Relations</option> <!--name, age, occupation and company of occupation of the employee’s siblings and parents. Information 
                                                                                                                regarding the spouse’s name, contact number and occupation or employer is added, as well as the names of their children, age, grade or year and the school of the children-->	
                        <option value="edu">Education</option> <!--elementary, high school, college, vocational, masters and others. In the history, the name of 
                                                                                                                school, years the employee has studied in that school and the awards given by the school to the employee are mentioned. The bio-data also includes the licensure exams taken and the score of the employee in the exams-->
                        <option value="history">Employment History</option> <!--job names, date of employment, beginning & ending salary, employer’s name, employer’s address, 
                                                                                                                        employer’s telephone number, supervisor’s name, supervisor’s contact number and reason for leaving-->
                        <option value="docs">Documents</option> <!--other important documents connected to the employee such as: employment contract, memorandums of 
                                                                                                        disciplinary actions, records of filed leaves, recognitions, and awards-->
                        <option value="others">Others</option> <!--The form also cites whether the employee has been convicted of a criminal offense and writes the details 
                                                                                                        of that offense. -->
                    </select>
                    <div id="personal" class="pages">

                        <%if (user.getEmployeeType().equals("Hr Employee") || user.getEmployeeType().equals("Hr Head")) {%>
                        <form action = "EditEmployeeData" method = "POST" id = "info-form">
                            <%}%>
                            <%
                                if (user.getEmployeeType().equals("Hr Employee") || user.getEmployeeType().equals("Hr Head")) {
                            %>
                            <div class = "editSpan"><span class = "editMessage">Click on an entry to change its content</span><input type="button" onclick = "return false;" value="Edit" id="editButton"><input type = "submit" value = "Save" id = "saveButton"/></div>
                            <br>
                            <br>
                            <%}%>
                            <div class="content">
                                <div class="line"><span class="label">First Name</span>
                                    <input name = "firstname" type = "text" class="data" value = "<%=emp.getFirstName()%>" readonly/></div>
                                <div class="line"><span class="label">Middle Name</span>
                                    <input name = "middlename" type = "text" class="data" value = "<%=emp.getMiddleName()%>" readonly/></div>
                                <div class="line"><span class="label">Last Name</span>
                                    <input name = "lastname" type = "text" class="data" value = "<%=emp.getLastName()%>" readonly/></div>
                                <div class="line"><span class="label">ID Number</span>
                                    <%=emp.getEmployeeID()%></div>
                                <div class="line"><span class="label">Hire Date</span>
                                    <%=emp.getHireDate()%></div>
                                <div class="line"><span class="label">Position</span>
                                    <input name = "position" type = "text" class="data" value = "<%=emp.getPositionName()%>" readonly/></div>
                                <div class="line"><span class="label">Expected Salary</span>
                                    <input name = "salary" type = "number" class="data" value = "<%=emp.getSalary()%>" readonly/></div>
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
                                    <input name = "managerid" type = "text" class="data" value = "<%=db.getFirstName(emp.getManagerEntryNum())%> <%=db.getLastName(emp.getManagerEntryNum())%>" readonly/><span class = "editNote"><br>*Input the manager's ID number</span></div>

                            </div>
                            <%if (user.getEmployeeType().equals("Hr Employee") || user.getEmployeeType().equals("Hr Head")) {%>
                        </form>
                        <%}%>
                    </div>
                    <div id="relations" class="pages">
                        <div class="content">
                            <%
                                if (!emp.getCivilStatus().equals("Single")) {
                                    modelRelative spouse = db.getSpouse(emp.getEntryNum());
                                    ArrayList<modelRelative> children = db.getRelatives("child", emp.getEntryNum());
                            %>
                            <div>
                                <div class="label-rel">
                                    Spouse
                                </div>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <%=spouse.getName()%></div>
                                    <div class="line"><span class="label">Contact Number</span>
                                        <%=spouse.getContactNum()%></div>
                                    <div class="line"><span class="label">Occupation/Employer</span>
                                        <%=spouse.getOccupation()%></div>
                                </div>
                                <br>
                            </div>

                            <div>
                                <div class="label-rel">
                                    Children
                                </div>
                                <%
                                    for (modelRelative child : children) {
                                %>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <%=child.getName()%>
                                    </div>
                                    <div class="line"><span class="label">Age</span>
                                        <%=child.getAge()%>"</div>
                                    <div class="line"><span class="label">Occupation</span>
                                        <%=child.getOccupation()%></div>
                                    <div class="line"><span class="label">School/Location</span>
                                        <%=child.getOccupationLocation()%></div><br/>
                                </div>
                                <br>
                                <%
                                    }
                                %>
                            </div>

                            <%
                                }
                                modelRelative father = db.getParent("father", emp.getEntryNum());
                                modelRelative mother = db.getParent("mother", emp.getEntryNum());
                                ArrayList<modelRelative> siblings = db.getRelatives("sibling", emp.getEntryNum());
                                if (father.getName() == null)

                            %>
                            <div>
                                <!--div class="label-rel">
                                    <b>Parents</b>
                                </div-->
                                <div class="subContent">
                                    <div class="label-rel">Father</div>
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <%=father.getName()%></div>
                                    <div class="line"><span class="label">Age</span>
                                        <%=father.getAge()%></div>
                                    <div class="line"><span class="label">Occupation</span>
                                        <%=father.getOccupation()%></div>
                                </div>
                                <br>
                                <div class="subContent">
                                    <div class="label-rel">Mother</div>
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <%=mother.getName()%></div>
                                    <div class="line"><span class="label">Age</span>
                                        <%=mother.getAge()%></div>
                                    <div class="line"><span class="label">Occupation</span>
                                        <%=mother.getOccupation()%></div>
                                </div>
                                <br>
                            </div>

                            <div>    
                                <div class="label-rel">
                                    Siblings
                                </div>
                                <%
                                    for (modelRelative sibling : siblings) {
                                %>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <%=sibling.getName()%></div>
                                    <div class="line"><span class="label">Age</span>
                                        <%=sibling.getAge()%></div>
                                    <div class="line"><span class="label">Occupation</span>
                                        <%=sibling.getOccupation()%></div>
                                    <div class="line"><span class="label">Company/Location</span>
                                        <%=sibling.getOccupationLocation()%></div>
                                </div>
                                <br>
                                <%}%>
                            </div>
                        </div>
                    </div>

                    <div id="edu" class="pages">
                        <%
                            ArrayList<modelEducationHistory> schoolList;
                        %>
                        <div class="content">
                            <div>
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
                                        <%=school.getSchoolName()%></div>
                                    <div class="line"><span class="label">Years</span>
                                        <%=school.getYearFrom()%> to <%=school.getYearTo()%></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <%=school.getAward()%></div><br/>
                                </div>
                                <%}%>
                            </div>

                            <div>
                                <div class="label-rel">
                                    High School
                                </div>
                                <%
                                    schoolList = db.getEducation("High School", emp.getEntryNum());
                                    for (modelEducationHistory school : schoolList) {
                                %>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <%=school.getSchoolName()%></div>
                                    <div class="line"><span class="label">Years</span>
                                        <%=school.getYearFrom()%> to <%=school.getYearTo()%></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <%=school.getAward()%></div><br/>
                                </div>
                                <%}%>
                            </div>

                            <div>
                                <div class="label-rel">
                                    College
                                </div>
                                <%
                                    schoolList = db.getEducation("College", emp.getEntryNum());
                                    for (modelEducationHistory school : schoolList) {
                                %>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <%=school.getSchoolName()%></div>
                                    <div class="line"><span class="label">Years</span>
                                        <%=school.getYearFrom()%> to <%=school.getYearTo()%></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <%=school.getAward()%></div><br/>
                                </div>
                                <%}%>
                            </div>

                            <div>
                                <div class="label-rel">
                                    Vocational
                                </div>
                                <%
                                    schoolList = db.getEducation("Vocational", emp.getEntryNum());
                                    for (modelEducationHistory school : schoolList) {
                                %>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <%=school.getSchoolName()%></div>
                                    <div class="line"><span class="label">Years</span>
                                        <%=school.getYearFrom()%> to <%=school.getYearTo()%></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <%=school.getAward()%></div><br/>
                                </div>
                                <%}%>
                            </div>

                            <div>
                                <div class="label-rel">
                                    Masters
                                </div>
                                <%
                                    schoolList = db.getEducation("Masteral", emp.getEntryNum());
                                    for (modelEducationHistory school : schoolList) {
                                %>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <%=school.getSchoolName()%></div>
                                    <div class="line"><span class="label">Years</span>
                                        <%=school.getYearFrom()%> to <%=school.getYearTo()%></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <%=school.getAward()%></div><br/>
                                </div>
                                <%}%>
                            </div>

                            <div>
                                <div class="label-rel">
                                    Others
                                </div>
                                <%
                                    schoolList = db.getEducation("Others", emp.getEntryNum());
                                    for (modelEducationHistory school : schoolList) {
                                %>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <%=school.getSchoolName()%></div>
                                    <div class="line"><span class="label">Years</span>
                                        <%=school.getYearFrom()%> to <%=school.getYearTo()%></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <%=school.getAward()%></div><br/>
                                </div>
                                <%}%>
                            </div>

                            <div>
                                <div class="label-rel">
                                    Licensure Exams
                                </div>
                                <%
                                    ArrayList<modelLicense> licenseList = db.getLicenses(emp.getEntryNum());
                                    for (modelLicense license : licenseList) {
                                %>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <%=license.getLicenseName()%></div>
                                    <div class="line"><span class="label">Score</span>
                                        <%=license.getPercentage()%></div>
                                </div>
                                <%}%>
                            </div>
                        </div>
                    </div>

                    <div id="history" class="pages">
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
                                        <%=empHisto.getJobTitle()%></div>
                                    <div class="line"><span class="label">Date of Employment</span>
                                        <%=new SimpleDateFormat("yyyy-MM-dd").format(empHisto.getDateOfEmployment())%></div>
                                    <div class="line"><span class="label">Beginning Salary</span>
                                        <%=empHisto.getStartingSalary()%></div>
                                    <div class="line"><span class="label">Ending Salary</span>
                                        <%=empHisto.getEndingSalary()%></div>
                                    <div class="line"><span class="label">Name of Employer</span>
                                        <%=empHisto.getEmployerName()%></div>
                                    <div class="line"><span class="label">Address of Employer</span>
                                        <%=empHisto.getEmployerAddress()%></div>
                                    <div class="line"><span class="label">Contact Number of Employer</span>
                                        <%=empHisto.getEmployerContactNum()%></div>
                                    <div class="line"><span class="label">Name of Supervisor</span>
                                        <%=empHisto.getSupervisorName()%></div>
                                    <div class="line"><span class="label">Contact Number of Supervisor</span>
                                        <%=empHisto.getSupervisorContactNum()%></div>
                                    <div class="line"><span class="label">Reason for leaving</span>
                                        <%=empHisto.getReasonForLeaving()%></div>
                                </div>
                                <br>
                                <%}%>
                            </div>
                        </div>
                    </div>

                    <div id="docs" class="pages">
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

                    <div id="others" class="pages">
                        <div class="content"> 
                            <div>
                                <div class="label-rel">
                                    Criminal Offense History
                                </div>
                                <%
                                    ArrayList<modelCriminalOffenseHistory> offenses = db.getCriminalOffenses(emp.getEntryNum());
                                    for (modelCriminalOffenseHistory offense : offenses) {
                                %>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Criminal Offense</b></span>
                                        <%=offense.getCriminalOffense()%></div>
                                    <div class="line"><span class="label"><b>Date of Offense</b></span>
                                        <%=offense.getDateOfOffense()%></div>
                                    <div class="line"><span class="label">Place of Offense</span>
                                        <%=offense.getPlaceOfOffense()%>"</div>
                                </div>
                                <br>
                                <%}%>
                            </div>
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
