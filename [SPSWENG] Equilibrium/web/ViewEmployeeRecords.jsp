<%-- 
    Document   : ViewEmployeeRecords
    Created on : 04 21, 15, 5:29:38 PM
    Author     : Arces
--%>

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
        <script src="js/jquery.min.js"></script>
        <script src="js/ViewEmployeeRecords.js"></script>
    </head>
    <%
        modelEmployee emp = (modelEmployee) request.getSession().getAttribute("viewEmp");
        Database db = Database.getInstance();
        modelEmployee user = (modelEmployee) request.getSession().getAttribute("employee");
    %>
    <body bgcolor ="#E8E8E8">

        <div id="alert">
            Are you sure you want to delete this content?<br/>
            <input type="button" value="Yes" class="alertButton">
            <input type="button" value="No" class="alertButton">
        </div>

        <div id="overlay"></div>

        <div id="main">
            <div class="pageTop">
                <div id="box">
                    <div id="header">
                        <span id="name">Employee Name</span>
                        <%
                            if (user.getEmployeeType().equals("Hr Employee") || user.getEmployeeType().equals("Hr Head")) {
                        %>
                        <input type="button" value="Edit" id="editButton">
                        <%}%>
                    </div>
                    <select id="options" size="6">
                        <option selected value="personal">Personal</option> <!--complete name, position applied for or expected salary, home address, birthday, 
                                                                                                                                birthplace, home phone number, mobile number, email address, civil status, citizenship and religion-->
                        <option value="relations">Relations</option> <!--name, age, occupation and company of occupation of the employeeâ€™s siblings and parents. Information 
                                                                                                                regarding the spouseâ€™s name, contact number and occupation or employer is added, as well as the names of their children, age, grade or year and the school of the children-->	
                        <option value="edu">Education</option> <!--elementary, high school, college, vocational, masters and others. In the history, the name of 
                                                                                                                school, years the employee has studied in that school and the awards given by the school to the employee are mentioned. The bio-data also includes the licensure exams taken and the score of the employee in the exams-->
                        <option value="history">Employment History</option> <!--job names, date of employment, beginning & ending salary, employerâ€™s name, employerâ€™s address, 
                                                                                                                        employerâ€™s telephone number, supervisorâ€™s name, supervisorâ€™s contact number and reason for leaving-->
                        <option value="docs">Documents</option> <!--other important documents connected to the employee such as: employment contract, memorandums of 
                                                                                                        disciplinary actions, records of filed leaves, recognitions, and awards-->
                        <option value="others">Others</option> <!--The form also cites whether the employee has been convicted of a criminal offense and writes the details 
                                                                                                        of that offense. -->
                    </select>

                    <div id="personal" class="pages">
                        <div class="content">
                            <div class="line"><span class="label">Name</span>
                                <span class="data"><%=emp.getFirstName()%> <%=emp.getMiddleName()%> <%=emp.getLastName()%></span></div>
                            <div class="line"><span class="label">ID Number</span>
                                <span class="data"><%=emp.getEmployeeID()%></span></div>
                            <div class="line"><span class="label">Hire Date</span>
                                <span class="data"><%=emp.getHireDate()%></span></div>
                            <div class="line"><span class="label">Position</span>
                                <span class="data"><%=emp.getPositionName()%></span></div>
                            <div class="line"><span class="label">Expected Salary</span>
                                <span class="data"><%=emp.getSalary()%></span></div>
                            <div class="line"><span class="label">Date of Birth</span>
                                <span class="data"><%=emp.getBirthday()%></span></div>
                            <div class="line"><span class="label">Place of Birth</span>
                                <span class="data"><%=emp.getBirthplace()%></span></div>
                            <div class="line"><span class="label">Home Address</span>
                                <span class="data"><%=emp.getAddress()%></span></div>
                            <div class="line"><span class="label">Home Phone Number</span>
                                <span class="data"><%=emp.getHomePhone()%></span></div>
                            <div class="line"><span class="label">Mobile Number</span>
                                <span class="data"><%=emp.getMobileNumber()%></span></div>
                            <div class="line"><span class="label">Email Address</span>
                                <span class="data"><%=emp.getEmailAddress()%></span></div>
                            <div class="line"><span class="label">Civil Status</span>
                                <span class="data"><%=emp.getCivilStatus()%></span></div>
                            <div class="line"><span class="label">Citizenship</span>
                                <span class="data"><%=emp.getCitizenship()%></span></div>
                            <div class="line"><span class="label">Religion</span>
                                <span class="data"><%=emp.getReligion()%></span></div>
                            <div class="line"><span class="label">SSS #</span>
                                <span class="data"><%=emp.getSSSNumber()%></span></div>
                            <div class="line"><span class="label">TIN #</span>
                                <span class="data"><%=emp.getTINNumber()%></span></div>
                            <div class="line"><span class="label">PHIC #</span>
                                <span class="data"><%=emp.getPHICNumber()%></span></div>
                            <div class="line"><span class="label">PAGIBIG #</span>
                                <span class="data"><%=emp.getPAGIBIGNumber()%></span></div>
                            <div class="line"><span class="label">Band</span>
                                <span class="data"><%=emp.getBand()%></span></div>
                            <div class="line"><span class="label">Manager: </span>
                                <span class="data"><%=db.getFirstName(emp.getManagerEntryNum())%> <%=db.getLastName(emp.getManagerEntryNum())%></span></div>

                        </div>
                    </div>

                    <div id="relations" class="pages">
                        <div class="content">

                            <%
                                if (!emp.getCivilStatus().equals("Single")) {
                            %>
                            <div>
                                <div class="label-rel">
                                    Spouse
                                </div>
                                <div class="subContent" id="waddup">
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Contact Number</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Occupation/Employer</span>
                                        <span class="data"></span></div>
                                </div>
                            </div>

                            <div>
                                <div class="label-rel">
                                    Children
                                </div>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <span class="data"></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Age</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Grade/Year</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">School</span>
                                        <span class="data"></span></div><br/>
                                </div>
                            </div>

                            <%
                                }
                            %>
                            <div>
                                <div class="label-rel">
                                    <b>Parents</b>
                                </div>
                                <div class="subContent">
                                    <div class="label-rel">Father</div>
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Age</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Occupation</span>
                                        <span class="data"></span></div>
                                </div>
                                <div class="subContent">
                                    <div class="label-rel">Mother</div>
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Age</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Occupation</span>
                                        <span class="data"></span></div>
                                </div>
                                <br>
                            </div>

                            <div>    
                                <div class="label-rel">
                                    Siblings
                                </div>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <span class="data"></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Age</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Occupation</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Company</span>
                                        <span class="data"></span></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="edu" class="pages">
                        <div class="content"> 

                            <div>
                                <div class="label-rel">
                                    Elementary
                                </div>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <span class="data"></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Years</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <span class="data"></span></div><br/>
                                </div>
                            </div>

                            <div>
                                <div class="label-rel">
                                    High School
                                </div>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <span class="data"></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Years</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <span class="data"></span></div><br/>
                                </div>
                            </div>

                            <div>
                                <div class="label-rel">
                                    College
                                </div>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <span class="data"></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Years</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <span class="data"></span></div><br/>
                                </div>
                            </div>

                            <div>
                                <div class="label-rel">
                                    Vocational
                                </div>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <span class="data"></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Years</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <span class="data"></span></div><br/>
                                </div>
                            </div>

                            <div>
                                <div class="label-rel">
                                    Masters
                                </div>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <span class="data"></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Years</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <span class="data"></span></div><br/>
                                </div>
                            </div>

                            <div>
                                <div class="label-rel">
                                    Others
                                </div>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <span class="data"></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Years</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <span class="data"></span></div><br/>
                                </div>
                            </div>

                            <div>
                                <div class="label-rel">
                                    Licensure Exams
                                </div>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <span class="data"></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Score</span>
                                        <span class="data"></span></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="history" class="pages">
                        <div class="content"> 

                            <div>
                                <div class="label-rel">
                                </div>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Year</b></span>
                                        <span class="data"></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label"><b>Occupation</b></span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Date of Employment</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Beginning Salary</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Ending Salary</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Name of Employer</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Address of Employer</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Contact Number of Employer</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Name of Supervisor</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Contact Number of Supervisor</span>
                                        <span class="data"></span></div>
                                    <div class="line"><span class="label">Reason for leaving</span>
                                        <span class="data"></span></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="docs" class="pages">
                        <div class="content"> 
                            <select id="docs-select">
                                <option>Employment Contract</option>
                                <option>Memorandums of Disciplinary Actions</option>
                                <option>Filed Leaves</option>
                                <option>Recognitions and Awards</option>
                            </select>
                        </div>
                    </div>

                    <div id="others" class="pages">
                        <div class="content"> 
                        </div>
                    </div>
                </div> <!-- end of box -->
            </div>

            <div class = "pageBot">
                <hr width = "75%">
                EQUILIBRIUM INTERTRADE CORP.
            </div>
        </div>
    </body>
</html>
