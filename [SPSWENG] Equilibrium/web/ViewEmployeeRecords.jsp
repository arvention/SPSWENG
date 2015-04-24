<%-- 
    Document   : ViewEmployeeRecords
    Created on : 04 21, 15, 5:29:38 PM
    Author     : Arces
--%>

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
                        <span id="name"><%=emp.getFirstName()%> <%=emp.getLastName()%></span>
                        <%
                            if (user.getEmployeeType().equals("Hr Employee") || user.getEmployeeType().equals("Hr Head")) {
                        %>
                        <form>
                            <div class = "editSpan"><span class = "editMessage">Click on an entry to change it's content</span><input type="button" onclick = "return false;" value="Edit" id="editButton"><input type = "submit" value = "Save Edit" id = "saveButton"/></div>
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
                                <input type = "text" class="data" value = "<%=emp.getFirstName()%> <%=emp.getMiddleName()%> <%=emp.getLastName()%>" readonly/></div>
                            <div class="line"><span class="label">ID Number</span>
                                <input type = "text" class="data" value = "<%=emp.getEmployeeID()%>" readonly/></div>
                            <div class="line"><span class="label">Hire Date</span>
                                <input type = "text" class="data" value = "<%=emp.getHireDate()%>" readonly/></div>
                            <div class="line"><span class="label">Position</span>
                                <input type = "text" class="data" value = "<%=emp.getPositionName()%>" readonly/></div>
                            <div class="line"><span class="label">Expected Salary</span>
                                <input type = "text" class="data" value = "<%=emp.getSalary()%>" readonly/></div>
                            <div class="line"><span class="label">Date of Birth</span>
                                <input type = "date" class="data" value = "<%=new SimpleDateFormat("yyyy-MM-dd").format(emp.getBirthday())%>" readonly/></div>
                            <div class="line"><span class="label">Place of Birth</span>
                                <input type = "text" class="data" value = "<%=emp.getBirthplace()%>" readonly/></div>
                            <div class="line"><span class="label">Home Address</span>
                                <input type = "text" class="data" value = "<%=emp.getAddress()%>" readonly/></div>
                            <div class="line"><span class="label">Home Phone Number</span>
                                <input type = "number" class="data" value ="<%=emp.getHomePhone()%>" readonly/></div>
                            <div class="line"><span class="label">Mobile Number</span>
                                <input type = "number" class="data" value = "<%=emp.getMobileNumber()%>" readonly/></div>
                            <div class="line"><span class="label">Email Address</span>
                                <input type = "text" class="data" value = "<%=emp.getEmailAddress()%>" readonly/></div>
                            <div class="line"><span class="label">Civil Status</span>
                                <input type = "text" class="data" value = "<%=emp.getCivilStatus()%>" readonly/><span class = "editNote"><br>*Input civil status (Single, Married, Divorced, Widowed)</span></div>
                            <div class="line"><span class="label">Citizenship</span>
                                <input type = "text" class="data" value = "<%=emp.getCitizenship()%>" readonly/></div>
                            <div class="line"><span class="label">Religion</span>
                                <input type = "text" class="data" value = "<%=emp.getReligion()%>" readonly/></div>
                            <div class="line"><span class="label">SSS #</span>
                                <input type = "text" class="data" value = "<%=emp.getSSSNumber()%>" readonly/></div>
                            <div class="line"><span class="label">TIN #</span>
                                <input type = "text" class="data" value = "<%=emp.getTINNumber()%>" readonly/></div>
                            <div class="line"><span class="label">PHIC #</span>
                                <input type = "text" class="data" value = "<%=emp.getPHICNumber()%>" readonly/></div>
                            <div class="line"><span class="label">PAGIBIG #</span>
                                <input type = "text" class="data" value = "<%=emp.getPAGIBIGNumber()%>" readonly/></div>
                            <div class="line"><span class="label">Band</span>
                                <input type = "text" class="data" value = "<%=emp.getBand()%>" readonly/></div>
                            <div class="line"><span class="label">Manager: </span>
                                <input type = "text" class="data" value = "<%=db.getFirstName(emp.getManagerEntryNum())%> <%=db.getLastName(emp.getManagerEntryNum())%>" readonly/><span class = "editNote"><br>*Input the manager's ID number</span></div>

                        </div>
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
                                <div class="subContent" id="waddup">
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <input type = "text" class="data" value = "<%=spouse.getName()%>" readonly/></div>
                                    <div class="line"><span class="label">Contact Number</span>
                                        <input type = "number" class="data" value = "<%=spouse.getContactNum()%>" readonly/></div>
                                    <div class="line"><span class="label">Occupation/Employer</span>
                                        <input type = "number" class="data" value = "<%=spouse.getOccupation()%>" readonly/></div>
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
                                        <input type = "text" class="data" value = "<%=child.getName()%>" readonly/>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Age</span>
                                        <input type = "number" class="data" value = "<%=child.getAge()%>" readonly/></div>
                                    <div class="line"><span class="label">Occupation</span>
                                        <input type = "text" class="data" value = "<%=child.getOccupation()%>" readonly/></div>
                                    <div class="line"><span class="label">School/Location</span>
                                        <input type = "text" class="data" value = "<%=child.getOccupationLocation()%>" readonly/></div><br/>
                                </div>
                                <br>
                                <%
                                    }
                                %>
                            </div>

                            <%
                                }
                                System.out.println("hehe");
                                modelRelative father = db.getParent("father", emp.getEntryNum());
                                System.out.println("haha");
                                modelRelative mother = db.getParent("mother", emp.getEntryNum());
                                ArrayList<modelRelative> siblings = db.getRelatives("sibling", emp.getEntryNum());
                            %>
                            <div>
                                <div class="label-rel">
                                    <b>Parents</b>
                                </div>
                                <div class="subContent">
                                    <div class="label-rel">Father</div>
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <input type = "text" class="data" value = "<%=father.getName()%>" readonly/></div>
                                    <div class="line"><span class="label">Age</span>
                                        <input type = "number" class="data" value = "<%=father.getAge()%>" readonly/></div>
                                    <div class="line"><span class="label">Occupation</span>
                                        <input type = "text" class="data" value = "<%=father.getOccupation()%>" readonly/></div>
                                </div>
                                <br>
                                <div class="subContent">
                                    <div class="label-rel">Mother</div>
                                    <div class="line"><span class="label"><b>Name</b></span>
                                        <input type = "text" class="data" value = "<%=mother.getName()%>" readonly/></div>
                                    <div class="line"><span class="label">Age</span>
                                        <input type = "number" class="data" value = "<%=mother.getAge()%>" readonly/></div>
                                    <div class="line"><span class="label">Occupation</span>
                                        <input type = "text" class="data" value = "<%=mother.getOccupation()%>" readonly/></div>
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
                                        <input type = "text" class="data" value = "<%=sibling.getName()%>" readonly/>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Age</span>
                                        <input type = "number" class="data" value = "<%=sibling.getAge()%>" readonly/></div>
                                    <div class="line"><span class="label">Occupation</span>
                                        <input type = "text" class="data" value = "<%=sibling.getOccupation()%>" readonly/></div>
                                    <div class="line"><span class="label">Company/Location</span>
                                        <input type = "text" class="data" value = "<%=sibling.getOccupationLocation()%>" readonly/></div>
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
                                <div class="label-rel">
                                    Elementary
                                </div>
                                <%
                                    schoolList = db.getEducation("Elementary", emp.getEntryNum());
                                    for (modelEducationHistory school : schoolList) {
                                %>
                                <div class="subContent">
                                    <div class="line"><span class="label"><b>Name of School</b></span>
                                        <input type = "text" class="data" value = "<%=school.getSchoolName()%>" readonly/>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Years</span>
                                        <input type = "date" class="data" value = "<%=new SimpleDateFormat("yyyy-MM-dd").format(school.getYearFrom())%>" readonly/> to <input type = "date" class="data" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(school.getYearTo())%>" readonly/></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <span class="data"><%=school.getAward()%></span></div><br/>
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
                                        <input type = "text" class="data" value = "<%=school.getSchoolName()%>" readonly/>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Years</span>
                                        <input type = "date" class="data" value = "<%=new SimpleDateFormat("yyyy-MM-dd").format(school.getYearFrom())%>" readonly/> to <input type = "date" class="data" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(school.getYearTo())%>" readonly/></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <span class="data"><%=school.getAward()%></span></div><br/>
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
                                        <input type = "text" class="data" value = "<%=school.getSchoolName()%>" readonly/>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Years</span>
                                        <input type = "date" class="data" value = "<%=new SimpleDateFormat("yyyy-MM-dd").format(school.getYearFrom())%>" readonly/> to <input type = "date" class="data" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(school.getYearTo())%>" readonly/></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <span class="data"><%=school.getAward()%></span></div><br/>
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
                                        <input type = "text" class="data" value = "<%=school.getSchoolName()%>" readonly/>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Years</span>
                                        <input type = "date" class="data" value = "<%=new SimpleDateFormat("yyyy-MM-dd").format(school.getYearFrom())%>" readonly/> to <input type = "date" class="data" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(school.getYearTo())%>" readonly/></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <span class="data"><%=school.getAward()%></span></div><br/>
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
                                        <input type = "text" class="data" value = "<%=school.getSchoolName()%>" readonly/>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Years</span>
                                        <input type = "date" class="data" value = "<%=new SimpleDateFormat("yyyy-MM-dd").format(school.getYearFrom())%>" readonly/> to <input type = "date" class="data" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(school.getYearTo())%>" readonly/></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <span class="data"><%=school.getAward()%></span></div><br/>
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
                                        <input type = "text" class="data" value = "<%=school.getSchoolName()%>" readonly/>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Years</span>
                                        <input type = "date" class="data" value = "<%=new SimpleDateFormat("yyyy-MM-dd").format(school.getYearFrom())%>" readonly/> to <input type = "date" class="data" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(school.getYearTo())%>" readonly/></div>
                                    <div class="line"><span class="label">Awards</span>
                                        <span class="data"><%=school.getAward()%></span></div><br/>
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
                                        <span class="data"><%=license.getLicenseName()%></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Score</span>
                                        <span class="data"><%=license.getPercentage()%></span></div>
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
                                        <span class="data"><%=empHisto.getJobTitle()%></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label">Date of Employment</span>
                                        <span class="data"><%=empHisto.getDateOfEmployment()%></span></div>
                                    <div class="line"><span class="label">Beginning Salary</span>
                                        <span class="data"><%=empHisto.getStartingSalary()%></span></div>
                                    <div class="line"><span class="label">Ending Salary</span>
                                        <span class="data"><%=empHisto.getEndingSalary()%></span></div>
                                    <div class="line"><span class="label">Name of Employer</span>
                                        <span class="data"><%=empHisto.getEmployerName()%></span></div>
                                    <div class="line"><span class="label">Address of Employer</span>
                                        <span class="data"><%=empHisto.getEmployerAddress()%></span></div>
                                    <div class="line"><span class="label">Contact Number of Employer</span>
                                        <span class="data"><%=empHisto.getEmployerContactNum()%></span></div>
                                    <div class="line"><span class="label">Name of Supervisor</span>
                                        <span class="data"><%=empHisto.getSupervisorName()%></span></div>
                                    <div class="line"><span class="label">Contact Number of Supervisor</span>
                                        <span class="data"><%=empHisto.getSupervisorContactNum()%></span></div>
                                    <div class="line"><span class="label">Reason for leaving</span>
                                        <span class="data"><%=empHisto.getReasonForLeaving()%></span></div>
                                </div>
                                <br>
                                <%}%>
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
                                        <span class="data"><%=offense.getCriminalOffense()%></span>
                                        <input type="button" value="+" class="add-delete-button">
                                        <input type="button" value="-" class="add-delete-button"></div>
                                    <div class="line"><span class="label"><b>Date of Offense</b></span>
                                        <span class="data"><%=offense.getDateOfOffense()%></span></div>
                                    <div class="line"><span class="label">Place of Offense</span>
                                        <span class="data"><%=offense.getPlaceOfOffense()%></span></div>
                                </div>
                                <br>
                                <%}%>
                            </div>
                        </div>
                    </div>
                    <%if (user.getEmployeeType().equals("Hr Employee") || user.getEmployeeType().equals("Hr Head")){%>
                    </form>
                    <%}%>
                </div>
            </div> <!-- end of box -->
        </div>
        <br>  
        <br>
        <br>
        <br>     
        <div class = "pageBot">
            <hr width = "75%">
            EQUILIBRIUM INTERTRADE CORP.
        </div>
    </div>
</body>
</html>
