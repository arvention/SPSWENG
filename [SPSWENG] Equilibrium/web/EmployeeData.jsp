<%-- 
    Document   : EmployeeData
    Created on : 03 26, 15, 12:27:50 AM
    Author     : Arces
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Employee BioData - Personal Information</title>
        <link rel="stylesheet" type="text/css" media="all" href="css/SampleScreensStyle.css"/>
        <script src="js/jquery-1.11.2.min.js"></script>
        <script src="js/SampleScreensFunc.js"></script>
    </head>
    <body>
        <form action = "EnterBioData" method = "post">
            <ul class="tabs">
                <li><a href="#personalinfo">Personal Information</a></li>
                <li><a href="#family">Family Relations</a></li>
                <li><a href="#emergencycontact">Emergency Contact</a></li>
                <li><a href="#edhistory">Education History</a></li>
                <li><a href="#emphistory">Employment History</a></li>
                <li><a href="#crimes">Past Criminal Offenses</a></li>
            </ul>
            <DIV id="personalinfo" class="tab-section">
                <table name="one">
                    <tr>
                        <td>Employee ID</td>
                        <td>Last Name</td>
                        <td>First Name</td>
                        <td>Middle Name</td>
                        <td>Expected Salary :</td>
                    </tr>
                    <tr>
                        <td class="three-hundred"><input type="number" min = "0" name="employeeID" placeholder="Employee ID" required /></td>
                        <td class="three-hundred"><input type="text" maxlength = 20 name="lastname" placeholder="Last Name" required /></td>
                        <td class="three-hundred"><input type="text" maxlength = 20 name="firstname" placeholder="First Name" required /></td>
                        <td class="three-hundred"><input type="text" maxlength = 20 name="middlename" placeholder="Middle Name" required /></td>
                        <td class="three-hundred"><input type="number" step = "1" min = "0" max = "9999999" name="salary" placeholder="Expected Salary" required/></td>
                    </tr>
                </table>
                <table name="two">
                    <tr>
                        <td>Address:</td>
                    </tr>
                    <tr>
                        <td class="three-hundred"><input type="text" maxlength = 20 name="block" placeholder="Block/Street" required /></td>
                        <td class="three-hundred"><input type="text" maxlength = 20 name="subdivision" placeholder="Subdivision" required /></td>
                        <td class="three-hundred"><input type="text" maxlength = 20 name="barangay" placeholder="Barangay" required /></td>
                        <td class="three-hundred"><input type="text" maxlength = 20 name="city" placeholder="City" required /></td>
                        <td class="three-hundred"><input type="text" maxlength = 20 name="province" placeholder="Province" required /></td>
                        <td></td>
                    </tr>
                </table>
                <table name="three">
                    <tr>
                        <td>Birthday :</td>
                        <td>Birthplace</td>
                        <td>Home Phone :</td>
                        <td>Mobile No :</td>
                        <td>Email Add :</td>
                    </tr>
                    <tr>
                        <td><input type="date" name="birthday" placeholder="Birthday" required /></td>
                        <td><input type="text" maxlength = 20 name="birthplace" placeholder="Birth Place" required /></td>
                        <td class="two-fifty"><input type="number" step = "1" min = "0" max = "999999999" name="homephone" placeholder="Home Phone" /></td>
                        <td class="two-fifty"><input type="number" step = "1" min = "0" max = "99999999999" name="mobileno" placeholder="Mobile Number" required/></td>
                        <td class="three-hundred"><input type="text" maxlength = 45 name="emailadd" placeholder="Email Address" required/></td>
                    </tr>
                </table>
                <table name="four">
                    <tr>
                        <td>SSS #:</td>
                        <td>TIN #: </td>
                        <td>PHIC #:</td>
                        <td>PAGIBIG #:</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="three-ten"><input type="text" maxlength = 12 name="sssno" placeholder="Ex. 01-2345678-9" required/></td>
                        <td class="three-ten"><input type="text" maxlength = 16 name="tinno" placeholder="Ex. 999-999-999-999X" required/></td>
                        <td class="three-ten"><input type="text" maxlength = 14 name="phicno" placeholder="Ex. 01-234567890-1" required/></td>
                        <td class="three-ten"><input type="text" maxlength = 14 name="pagibigno" placeholder="Ex. 1234-5678-9101" required/></td>
                    </tr>
                </table>
                <table name="five">
                    <tr>
                        <td>Civil Status: </td>
                        <td>Citizenship:</td>
                        <td>Religion:</td>  
                    </tr>
                    <tr>
                        <td width="150px"><select name="civilstatus">
                                <option value="Single">Single</option>
                                <option value="Married">Married</option>
                                <option value="Divorced">Divorced</option>
                                <option value="Widowed">Widowed</option>
                            </select></td>
                        <td><input type="text" maxlength = 20 name="citizenship" placeholder="Citizenship" required/></td>
                        <td><input type="text" maxlength = 20 name="religion" placeholder="Religion" required/></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </DIV>
            <DIV id="family" class="tab-section">
                <table>
                    <tr>
                        <td></td>
                        <td>Name:</td>
                        <td>Age:</td>
                        <td>Occupation:</td>
                    </tr>
                    <tr>
                        <td>Father</td>
                        <td><input type="text" maxlength = 45 name="fathername" placeholder="Father's Name" /></td>
                        <td><input type="number" step = "1" min = "0" max = "999" name="fatherage" placeholder="Age" /></td>
                        <td><input type="text" maxlength = 20 name="fatheroccupation" placeholder="Occupation" /><br/></td>
                    </tr>
                    <tr>
                        <td>Mother</td>
                        <td><input type="text" maxlength = 45 name="mothername" placeholder="Mother's Maiden Name" /></td>
                        <td><input type="number" step = "1" min = "0" max = "999" name="motherage" placeholder="Age" /></td>
                        <td><input type="text" maxlength = 20 name="motheroccupation" placeholder="Occupation" /></td>
                    </tr>
                </table><br/><br/>

                <span class="headers">Siblings</span><br/>                
                <table name="siblings">
                    <tr>

                        <td class="three-hundred">Name of Sibling</td>
                        <td>Age</td>
                        <td class="three-hundred">Occupation</td>
                        <td class="three-hundred">Company/Location</td>
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

                <DIV class="tohide">
                    <table>
                        <tr>
                            <td>Spouse's Name:</td>
                            <td><input type="text" name="spousename" maxlength = 45 placeholder="Name of Spouse" /></td>
                        </tr>
                        <tr>
                            <td>Spouse's Contact Number:</td>
                            <td><input type="number" min = "0" max = "999999999999" step = "1" name="spousecontact" placeholder="Contact Number" /></td>
                        </tr>
                        <tr>
                            <td>Spouse's Occupation/Employer:</td>
                            <td><input type="text" maxlength = 20 name="spouseoccupation" placeholder="Occupation/Employer" /></td>
                        </tr>
                    </table><br/><br/>

                    <span class="headers">Children</span><br/>
                    <table name="children">
                        <tr>

                            <td class="three-hundred">Name of Child</td>
                            <td>Age</td>
                            <td class="three-hundred">Occupation</td>
                            <td class="three-hundred">School/Location</td>
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
                        <td>Relationship with Emergency Contact:</td>
                        <td><input type="text" maxlength = 20 name="emergencyrel" placeholder="Relationship" /></td>
                    </tr>
                    <tr>
                        <td>Emergency Contact's Address:</td>
                        <td><input type="text" maxlength = 100 name="emergencyaddress" placeholder="Address" /></td>
                    </tr>
                    <tr>
                        <td>Emergency Contact's Number:</td>
                        <td><input type="number" min = "0" max = "999999999999" step = "1" name="emergencynumber" placeholder="Contact Number" /></td>
                    </tr>
                </table>
            </DIV>
            <DIV id="edhistory" class="tab-section">
                <span class="headers">Elementary</span><br/>
                <table name="elementary">
                    <tr>

                        <td class="three-hundred">Name of School</td>
                        <td>From</td>
                        <td>To</td>
                        <td class="five-hundred">Awards</td>
                    </tr>
                    <tr>

                        <td><input type="text" maxlength = 45 name="elemschool" placeholder="ex. Don Bosco School" required /></td>
                        <td><input type="number" min = "1000" max = "9999" step = "1" name="elemfrom" placeholder="ex. 2000" required /></td>
                        <td><input type="number" min = "1000" max = "9999" step = "1" name="elemto" placeholder="ex. 2012" required /></td>
                        <td><input type="text" maxlength = 45 name="elemawards" placeholder="ex. Perfect Attendance Award" /></td>
                        <td><button class="addelem">+</button></td>
                    </tr>
                </table><br/><br/>

                <span class="headers">High School</span><br/>
                <table name="highschool">
                    <tr>

                        <td class="three-hundred">Name of School</td>
                        <td>From</td>
                        <td>To</td>
                        <td class="five-hundred">Awards</td>
                    </tr>
                    <tr>

                        <td><input type="text" maxlength = 45 name="highschool" placeholder="Name of School" required /></td>
                        <td><input type="number" min = "1000" max = "9999" step = "1" name="highschoolfrom" placeholder="Year Start" required /></td>
                        <td><input type="number" min = "1000" max = "9999" step = "1" name="highschoolto" placeholder="Year End" required /></td>
                        <td><input type="text" maxlength = 45 name="highschoolawards" placeholder="Degree Taken/Highest Attainment/Awards" /></td>
                        <td><button class="addhighschool">+</button></td>
                    </tr>
                </table><br/><br/>

                <span class="headers">College</span><br/>
                <table name="college">
                    <tr>

                        <td class="three-hundred">Name of School</td>
                        <td>From</td>
                        <td>To</td>
                        <td class="five-hundred">Awards</td>
                    </tr>
                    <tr>

                        <td><input type="text" maxlength = 45 name="college" placeholder="Name of School" required /></td>
                        <td><input type="number" min = "1000" max = "9999" step = "1" name="collegefrom" placeholder="Year Start" required /></td>
                        <td><input type="number" min = "1000" max = "9999" step = "1" name="collegeto" placeholder="Year End" required /></td>
                        <td><input type="text" maxlength = 45 name="collegeawards" placeholder="Degree Taken/Highest Attainment/Awards" /></td>
                        <td><button class="addcollege">+</button></td>
                    </tr>
                </table><br /><br/>

                <span class="headers">Vocational</span><br/>
                <table name="vocational">
                    <tr>

                        <td class="three-hundred">Name of School</td>
                        <td>From</td>
                        <td>To</td>
                        <td class="five-hundred">Awards</td>
                    </tr>
                    <tr>

                        <td><input type="text" maxlength = 45 name="vocationalschool" placeholder="Name of School" /></td>
                        <td><input type="number" min = "1000" max = "9999" step = "1" name="vocationalschoolfrom" placeholder="Year Start" /></td>
                        <td><input type="number" min = "1000" max = "9999" step = "1" name="vocationalschoolto" placeholder="Year End" /></td>
                        <td><input type="text" maxlength = 45 name="vocationalschoolawards" placeholder="Degree Taken/Highest Attainment/Awards" /></td>
                        <td><button class="addvocational">+</button></td>
                    </tr>
                </table><br/><br/>

                <span class="headers">Masteral</span><br/>
                <table name="masteral">
                    <tr>

                        <td class="three-hundred">Name of School</td>
                        <td>From</td>
                        <td>To</td>
                        <td class="five-hundred">Awards</td>
                    </tr>
                    <tr>

                        <td><input type="text" maxlength = 45 name="masteralschool" placeholder="Name of School" /></td>
                        <td><input type="number" min = "1000" max = "9999" step = "1" name="masteralschoolfrom" placeholder="Year Start" /></td>
                        <td><input type="number" min = "1000" max = "9999" step = "1" name="masteralschoolto" placeholder="Year End" /></td>
                        <td><input type="text" maxlength = 45 name="masteralschoolawards" placeholder="Degree Taken/Highest Attainment/Awards" /></td>
                        <td><button class="addmasteral">+</button></td>
                    </tr>
                </table><br/><br/>

                <span class="headers">Others</span><br/>
                <table name="others">
                    <tr>

                        <td class="three-hundred">Name of School</td>
                        <td>From</td>
                        <td>To</td>
                        <td class="five-hundred">Awards</td>
                    </tr>
                    <tr>

                        <td><input type="text" maxlength = 45 name="otherschool" placeholder="Name of School" /></td>
                        <td><input type="number" min = "1000" max = "9999" step = "1" name="otherfrom" placeholder="Year Start" /></td>
                        <td><input type="number" min = "1000" max = "9999" step = "1" name="otherto" placeholder="Year End" /></td>
                        <td><input type="text" maxlength = 45 name="otherawards" placeholder="Degree Taken/Highest Attainment/Awards" /></td>
                        <td><button class="addother">+</button></td>
                    </tr>
                </table><br/><br/>

                <span class="headers">Licenses/Exams</span><br/>
                <table name="license">
                    <tr>

                        <td width="1000px">License/Exam Taken</td>
                        <td>Percentage</td>
                    </tr>
                    <tr>

                        <td><input type="text" name="license" placeholder="License/Exam Taken" /></td>
                        <td><input type="number" name="licensepercentage" placeholder="Percentage Result" /></td>
                        <td><button class="addlicense">+</button></td>
                    </tr>
                </table><br/><br/>
            </DIV>

            <DIV id="emphistory" class="tab-section">
                <span class="headers">Employment History</span><br/>
                <span>Note: Begin with present or most recent job.</span><br/><br/>
                <table name="employment">
                    <tr>

                        <td class="three-hundred">Job Title</td>
                        <td>Date of Employment</td>
                        <td class="three-hundred">Starting Salary</td>
                        <td class="three-hundred">Ending Salary</td>
                    </tr>
                    <tr>

                        <td><input type="text" maxlength = 20 name="jobtitle" placeholder="Job Title" /></td>
                        <td><input type="date" name="jobemploydate" placeholder="Date of Employment" /></td>
                        <td><input type="number" min = "0" max = "9999999" step = "1" name="jobbegsal" placeholder="Starting Salary" /></td>
                        <td><input type="number" name="jobendsal" placeholder="Ending Salary" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="three-hundred">Employer's Name</td>
                        <td class="three-hundred">Employer's Address</td>
                        <td class="three-hundred">Employer's Contact Number</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="text" maxlength = 45 name="jobemployer" placeholder="Employer" /></td>
                        <td><input type="text" maxlength = 100 name="jobaddress" placeholder="Employer Address" /></td>
                        <td><input type="number" min = "0" max = "99999999999" step = "1" name="jobtelno" placeholder="Employer Telephone Number" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="three-hundred">Supervisor's Name</td>
                        <td class="three-hundred">Supervisor's Contact Number</td>
                        <td class="three-hundred">Reason for Leaving</td>
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
                            <td class="four-hundred">Criminal Offense</td>
                            <td class="four-hundred">Date of Offense</td>
                            <td class="four-hundred">Place of Offense</td>
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
            <br/><input type="submit" value="Submit" />
        </form>
        <br/><br/>
        <DIV class= "footer">
            <br/><hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </DIV>

    </body>
</html>
