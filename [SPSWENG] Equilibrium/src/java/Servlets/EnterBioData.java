
/*  Class Name:     EnterBioData
*   Developer:      Arces Talavera
*   Description:    servlet used by the hr head and hr employee to enter new bio data
*/

package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnterBioData extends HttpServlet {

    /*
    *   The doGet function of the servlet.
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /*
    *   The doPost function of the servlet.
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //--- variables ----------------------
        Database db = Database.getInstance();
        int empEntryNum = 0;
        String empid = request.getParameter("employeeID");
        int managerid = Integer.parseInt(request.getParameter("emphead"));
        int intid = Integer.parseInt(empid.trim());
        boolean isError = false;

        //--- functions ----------------------
        if (!(db.isValidID(intid))) {
            isError = true;
            response.getWriter().write("- An employee with the EmployeeID, " + intid + ", already has a record.<br>");
        }
        if (checkSchoolYears(request)) {
            isError = true;
            response.getWriter().write("- Please check the input school years: An end of a school year is earlier than the start.<br>");
        }
        if (coincideSchoolYears(request)) {
            isError = true;
            response.getWriter().write("- Please check the input school years: There seems to be a school year that coincides with another school year.<br>Please input the schools attended in order from the oldest to the latest.<br>");
        }
        if (db.isValidID(managerid)) {
            isError = true;
            response.getWriter().write("- No Manager has an ID number, " + managerid + ".<br>");
        }
        else if (checkEmployee(managerid)){
            isError = true;
            response.getWriter().write("- The Employee with the ID number " + managerid + " is not a manager.<br>");
        }

        if (!isError) {
            empEntryNum = addInfo(empEntryNum, db, request);
            addEducationHistory(empEntryNum, db, request);
            addLicenseExam(empEntryNum, db, request);
            addRelatives(empEntryNum, db, request);
            addEmploymentHistory(empEntryNum, db, request);
            addCriminalOffenses(empEntryNum, db, request);
        }
    }

    public int addInfo(int empEntryNum, Database db, HttpServletRequest request) {
        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        String lastName = request.getParameter("lastname");
        String firstName = request.getParameter("firstname");
        String middleName = request.getParameter("middlename");
        String address;
        if (!request.getParameter("barangay").equals("")) {
            address = request.getParameter("block") + ", " + request.getParameter("subdivision") + ", " + request.getParameter("barangay") + ", " + request.getParameter("city") + ", " + request.getParameter("province");
        } else {
            address = request.getParameter("block") + ", " + request.getParameter("subdivision") + ", " + request.getParameter("city") + ", " + request.getParameter("province");
        }
        String birthplace = request.getParameter("birthplace");
        int homePhone = 0;
        if (!request.getParameter("homephone").equals("")) {
            homePhone = Integer.parseInt(request.getParameter("homephone"));
        }
        String SSSNumber = request.getParameter("sssno");
        String TINNumber = request.getParameter("tinno");
        String PHICNumber = request.getParameter("phicno");
        String PAGIBIGNumber = request.getParameter("pagibigno");
        String civilStatus = request.getParameter("civilstatus");
        String citizenship = request.getParameter("citizenship");
        String religion = request.getParameter("religion");
        int salary = Integer.parseInt(request.getParameter("salary"));
        String emailAddress = request.getParameter("emailadd");
        long mobileNumber = Long.parseLong(request.getParameter("mobileno"));
        int band = Integer.parseInt(request.getParameter("employeeband"));
        String department = request.getParameter("empdep");
        int branchID = Integer.parseInt(request.getParameter("empbranch"));
        String position = request.getParameter("empposition");
        Date hireDate = new Date();
        int managerID = Integer.parseInt(request.getParameter("emphead"));
        Date birthDay = new Date();

        try {
            birthDay = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
            hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int departmentID = db.getDeptID(department, branchID);

        return db.addInfo(employeeID, lastName, firstName, middleName, address, new java.sql.Date(birthDay.getTime()), birthplace, mobileNumber, SSSNumber, TINNumber, PHICNumber, PAGIBIGNumber, civilStatus, citizenship, religion, salary, emailAddress, homePhone, Integer.toString(band), departmentID, position, new java.sql.Date(hireDate.getTime()), managerID);
    }

    public void addRelatives(int empEntryNum, Database db, HttpServletRequest request) {
        String relativeName, relativeOcc, relativeRelation, relativeLocation;
        int relativeAge;
        long relativeContact;
        String[] relativesName, relativesOcc, relativesAge, relativesLocation;

        //--- get relatives -----------------------------------------------------------
        //-- get father ------------------------
        if (!request.getParameter("fathername").equals("") && !request.getParameter("fatherage").equals("") && !request.getParameter("fatheroccupation").equals("")) {
            relativeName = request.getParameter("fathername");
            relativeAge = Integer.parseInt(request.getParameter("fatherage"));
            relativeOcc = request.getParameter("fatheroccupation");
            relativeRelation = "father";
            db.addRelative(relativeName, relativeRelation, empEntryNum, relativeAge, relativeOcc);
        }
        //-- get mother ------------------------
        if (!request.getParameter("mothername").equals("") && !request.getParameter("motherage").equals("") && !request.getParameter("motheroccupation").equals("")) {
            relativeName = request.getParameter("mothername");
            relativeAge = Integer.parseInt(request.getParameter("motherage"));
            relativeOcc = request.getParameter("motheroccupation");
            relativeRelation = "mother";
            db.addRelative(relativeName, relativeRelation, empEntryNum, relativeAge, relativeOcc);
        }
        //-- get siblings ----------------------
        if (request.getParameterValues("siblingname") != null && request.getParameterValues("siblingage") != null && request.getParameterValues("siblingoccupation") != null && request.getParameterValues("siblinglocation") != null) {
            relativeRelation = "sibling";
            relativesName = request.getParameterValues("siblingname");
            relativesOcc = request.getParameterValues("siblingoccupation");
            relativesAge = request.getParameterValues("siblingage");
            relativesLocation = request.getParameterValues("siblinglocation");

            for (int i = 0; i < relativesName.length; i++) {
                if (!relativesName[i].equals("") && !relativesAge[i].equals("") && !relativesOcc[i].equals("") && !relativesLocation[i].equals("")) {
                    db.addRelative(relativesName[i], relativeRelation, empEntryNum, Integer.parseInt(relativesAge[i]), relativesOcc[i], relativesLocation[i]);
                }
            }
        }

        String status = request.getParameter("civilstatus");
        if (!status.equals("Single")) {
            //-- get spouse ------------------------------
            if (!request.getParameter("spousename").equals("") && !request.getParameter("spousecontact").equals("") && !request.getParameter("spouseoccupation").equals("")) {
                relativeRelation = "spouse";
                relativeName = request.getParameter("spousename");
                relativeContact = Long.parseLong(request.getParameter("spousecontact"));
                relativeOcc = request.getParameter("spouseoccupation");

                db.addRelative(relativeName, relativeRelation, empEntryNum, relativeOcc, relativeContact);
            }

            //-- get children ------------------------------
            if (request.getParameterValues("childrenname") != null && request.getParameterValues("childrenage") != null && request.getParameterValues("childrenoccupation") != null && request.getParameterValues("childrenlocation") != null) {
                relativeRelation = "child";
                relativesName = request.getParameterValues("childrenname");
                relativesAge = request.getParameterValues("childrenage");
                relativesOcc = request.getParameterValues("childrenoccupation");
                relativesLocation = request.getParameterValues("childrenlocation");

                for (int i = 0; i < relativesName.length; i++) {
                    if (!relativesName[i].equals("") && !relativesAge[i].equals("") && !relativesOcc[i].equals("") && !relativesLocation[i].equals("")) {
                        db.addRelative(relativesName[i], relativeRelation, empEntryNum, Integer.parseInt(relativesAge[i]), relativesOcc[i], relativesLocation[i]);
                    }
                }
            }
        }

        //-- get emergency contact -----------------
        if (!request.getParameter("emergencyname").equals("") && !request.getParameter("emergencyrel").equals("") && !request.getParameter("emergencyaddress").equals("") && !request.getParameter("emergencynumber").equals("")) {
            relativeName = request.getParameter("emergencyname");
            relativeRelation = request.getParameter("emergencyrel");
            relativeLocation = request.getParameter("emergencyaddress");
            relativeContact = Long.parseLong(request.getParameter("emergencynumber"));

            db.addRelative(relativeName, relativeRelation, empEntryNum, relativeLocation, relativeContact);
        }
    }

    public void addCriminalOffenses(int empEntryNum, Database db, HttpServletRequest request) {
        String isConvicted = request.getParameter("convicted");
        if (isConvicted.equals("Yes")) {
            String[] offenseNames = request.getParameterValues("offensename");
            String[] offenseDates = request.getParameterValues("offensedate");
            String[] offensePlaces = request.getParameterValues("offenseplace");

            if (offenseNames != null && offenseDates != null && offensePlaces != null) {
                for (int i = 0; i < offenseNames.length; i++) {
                    if (!offenseNames[i].equals("") && !offenseDates[i].equals("") && !offensePlaces[i].equals("")) {
                        try {
                            Date tempDate = new SimpleDateFormat("yyyy-MM-dd").parse(offenseDates[i]);
                            db.addOffense(empEntryNum, offenseNames[i], new java.sql.Date(tempDate.getTime()), offensePlaces[i]);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void addEmploymentHistory(int empEntryNum, Database db, HttpServletRequest request) {
        String[] jobTitles = request.getParameterValues("jobtitle");
        String[] jobEmployDates = request.getParameterValues("jobemploydate");
        String[] jobStartSals = request.getParameterValues("jobbegsal");
        String[] jobEndSals = request.getParameterValues("jobendsal");
        String[] jobEmployers = request.getParameterValues("jobemployer");
        String[] jobAddresses = request.getParameterValues("jobaddress");
        String[] jobTelNos = request.getParameterValues("jobtelno");
        String[] jobSups = request.getParameterValues("jobsupname");
        String[] jobSupNos = request.getParameterValues("jobsupno");
        String[] jobReasons = request.getParameterValues("jobreason");

        if (jobTitles != null && jobEmployDates != null && jobStartSals != null && jobEndSals != null && jobEmployers != null
                && jobAddresses != null && jobTelNos != null && jobSups != null && jobSupNos != null && jobReasons != null) {
            for (int i = 0; i < jobTitles.length; i++) {
                if (!jobTitles[i].equals("") && !jobEmployDates[i].equals("") && !jobStartSals[i].equals("") && !jobEndSals[i].equals("")
                        && !jobEmployers[i].equals("") && !jobAddresses[i].equals("") && !jobTelNos[i].equals("") && !jobSups[i].equals("")
                        && !jobSupNos[i].equals("") && !jobReasons[i].equals("")) {

                    try {
                        Date tempDate = new SimpleDateFormat("yyyy-MM-dd").parse(jobEmployDates[i]);
                        db.addEmployment(empEntryNum, jobTitles[i], new java.sql.Date(tempDate.getTime()), Integer.parseInt(jobStartSals[i]),
                                Integer.parseInt(jobEndSals[i]), jobEmployers[i], jobAddresses[i], Long.parseLong(jobTelNos[i]), jobSups[i],
                                Long.parseLong(jobSupNos[i]), jobReasons[i]);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    public void addEducationHistory(int empEntryNum, Database db, HttpServletRequest request) {
        String[] schoolNames, schoolAwards, schoolFromYear, schoolToYear;

        //-- get elementary ------------------------------------------------
        schoolNames = request.getParameterValues("elemschool");
        schoolAwards = request.getParameterValues("elemawards");
        schoolFromYear = request.getParameterValues("elemfrom");
        schoolToYear = request.getParameterValues("elemto");

        if (schoolNames != null && schoolFromYear != null && schoolToYear != null) {
            for (int i = 0; i < schoolNames.length; i++) {
                if (!schoolNames[i].equals("") && !schoolFromYear[i].equals("") && !schoolToYear[i].equals("")) {
                    db.addEducation(empEntryNum, "Elementary", schoolNames[i], Integer.parseInt(schoolFromYear[i]), Integer.parseInt(schoolToYear[i]), schoolAwards[i]);
                }
            }
        }

        //-- get high school ------------------------------------------------
        schoolNames = request.getParameterValues("highschool");
        schoolAwards = request.getParameterValues("highschoolawards");
        schoolFromYear = request.getParameterValues("highschoolfrom");
        schoolToYear = request.getParameterValues("highschoolto");

        if (schoolNames != null && schoolFromYear != null && schoolToYear != null) {
            for (int i = 0; i < schoolNames.length; i++) {
                if (!schoolNames[i].equals("") && !schoolFromYear[i].equals("") && !schoolToYear[i].equals("")) {
                    db.addEducation(empEntryNum, "High School", schoolNames[i], Integer.parseInt(schoolFromYear[i]), Integer.parseInt(schoolToYear[i]), schoolAwards[i]);
                }
            }
        }

        //-- get College ------------------------------------------------
        schoolNames = request.getParameterValues("college");
        schoolAwards = request.getParameterValues("collegeawards");
        schoolFromYear = request.getParameterValues("collegefrom");
        schoolToYear = request.getParameterValues("collegeto");

        if (schoolNames != null && schoolFromYear != null && schoolToYear
                != null) {
            for (int i = 0; i < schoolNames.length; i++) {
                if (!schoolNames[i].equals("") && !schoolFromYear[i].equals("") && !schoolToYear[i].equals("")) {
                    db.addEducation(empEntryNum, "College", schoolNames[i], Integer.parseInt(schoolFromYear[i]), Integer.parseInt(schoolToYear[i]), schoolAwards[i]);
                }
            }
        }

        //-- get vocational ------------------------------------------------
        schoolNames = request.getParameterValues("vocationalschool");
        schoolAwards = request.getParameterValues("vocationalschoolawards");
        schoolFromYear = request.getParameterValues("vocationalschoolfrom");
        schoolToYear = request.getParameterValues("vocationalschoolto");

        if (schoolNames != null && schoolFromYear != null && schoolToYear != null) {
            for (int i = 0; i < schoolNames.length; i++) {
                if (!schoolNames[i].equals("") && !schoolFromYear[i].equals("") && !schoolToYear[i].equals("")) {
                    db.addEducation(empEntryNum, "Vocational", schoolNames[i], Integer.parseInt(schoolFromYear[i]), Integer.parseInt(schoolToYear[i]), schoolAwards[i]);
                }
            }
        }

        //-- get masteral ------------------------------------------------
        schoolNames = request.getParameterValues("masteralschool");
        schoolAwards = request.getParameterValues("masteralschoolawards");
        schoolFromYear = request.getParameterValues("masteralschoolfrom");
        schoolToYear = request.getParameterValues("masteralschoolto");

        if (schoolNames != null && schoolFromYear != null && schoolToYear != null) {
            for (int i = 0; i < schoolNames.length; i++) {
                if (!schoolNames[i].equals("") && !schoolFromYear[i].equals("") && !schoolToYear[i].equals("")) {
                    db.addEducation(empEntryNum, "Masteral", schoolNames[i], Integer.parseInt(schoolFromYear[i]), Integer.parseInt(schoolToYear[i]), schoolAwards[i]);
                }
            }
        }
        //-- get others ------------------------------------------------
        schoolNames = request.getParameterValues("otherschool");
        schoolAwards = request.getParameterValues("otherawards");
        schoolFromYear = request.getParameterValues("otherfrom");
        schoolToYear = request.getParameterValues("otherto");

        if (schoolNames != null && schoolFromYear != null && schoolToYear != null) {
            for (int i = 0; i < schoolNames.length; i++) {
                if (!schoolNames[i].equals("") && !schoolFromYear[i].equals("") && !schoolToYear[i].equals("")) {
                    db.addEducation(empEntryNum, "Others", schoolNames[i], Integer.parseInt(schoolFromYear[i]), Integer.parseInt(schoolToYear[i]), schoolAwards[i]);
                }
            }
        }
    }

    public void addLicenseExam(int empEntryNum, Database db, HttpServletRequest request) {
        String[] licenseNames, licensePercentages;

        licenseNames = request.getParameterValues("license");
        licensePercentages = request.getParameterValues("licensepercentage");

        if (licenseNames != null && licensePercentages != null) {
            for (int i = 0; i < licenseNames.length; i++) {
                if (!licenseNames[i].equals("") && !licensePercentages[i].equals("")) {
                    db.addLicense(licenseNames[i], empEntryNum, Integer.parseInt(licensePercentages[i]));
                }
            }
        }
    }

    public boolean checkSchoolYears(HttpServletRequest request) {
        boolean isEarlier = false;

        String[] startDates, endDates;

        //check elementaryDates
        startDates = request.getParameterValues("elemfrom");
        endDates = request.getParameterValues("elemto");

        if (startDates != null && endDates != null) {
            for (int i = 0; i < startDates.length && !isEarlier; i++) {
                if (Integer.parseInt(endDates[i]) < Integer.parseInt(startDates[i])) {
                    isEarlier = true;
                }
            }
        }

        if (!isEarlier) {
            //check highschoolDates
            startDates = request.getParameterValues("highschoolfrom");
            endDates = request.getParameterValues("highschoolto");

            if (startDates != null && endDates != null) {
                for (int i = 0; i < startDates.length && !isEarlier; i++) {
                    if (Integer.parseInt(endDates[i]) < Integer.parseInt(startDates[i])) {
                        isEarlier = true;
                    }
                }
            }
        }

        if (!isEarlier) {
            //check collegeDates
            startDates = request.getParameterValues("collegefrom");
            endDates = request.getParameterValues("collegeto");

            if (startDates != null && endDates != null) {
                for (int i = 0; i < startDates.length && !isEarlier; i++) {
                    if (Integer.parseInt(endDates[i]) < Integer.parseInt(startDates[i])) {
                        isEarlier = true;
                    }
                }
            }
        }

        if (!isEarlier) {
            //check vocationalDates
            startDates = request.getParameterValues("vocationalschoolfrom");
            endDates = request.getParameterValues("vocationalschoolto");

            if (startDates != null && endDates != null) {
                for (int i = 0; i < startDates.length && !isEarlier; i++) {
                    if (!startDates[i].equals("") && !endDates[i].equals("")) {
                        if (Integer.parseInt(endDates[i]) < Integer.parseInt(startDates[i])) {
                            isEarlier = true;
                        }
                    }
                }
            }
        }

        if (!isEarlier) {
            //check masteralDates
            startDates = request.getParameterValues("masteralschoolfrom");
            endDates = request.getParameterValues("masteralschoolto");

            if (startDates != null && endDates != null) {
                for (int i = 0; i < startDates.length && !isEarlier; i++) {
                    if (!startDates[i].equals("") && !endDates[i].equals("")) {
                        if (Integer.parseInt(endDates[i]) < Integer.parseInt(startDates[i])) {
                            isEarlier = true;
                        }
                    }
                }
            }
        }

        if (!isEarlier) {
            //check otherDates
            startDates = request.getParameterValues("otherfrom");
            endDates = request.getParameterValues("otherto");

            if (startDates != null && endDates != null) {
                for (int i = 0; i < startDates.length && !isEarlier; i++) {
                    if (!startDates[i].equals("") && !endDates[i].equals("")) {
                        if (Integer.parseInt(endDates[i]) < Integer.parseInt(startDates[i])) {
                            isEarlier = true;
                        }
                    }
                }
            }
        }
        return isEarlier;
    }

    public boolean coincideSchoolYears(HttpServletRequest request) {
        boolean isCoincide = false;
        String[] elemFrom = request.getParameterValues("elemfrom");
        String[] elemTo = request.getParameterValues("elemto");
        String[] highFrom = request.getParameterValues("highschoolfrom");
        String[] highTo = request.getParameterValues("highschoolto");
        String[] collFrom = request.getParameterValues("collegefrom");
        String[] collTo = request.getParameterValues("collegeto");
        String[] vocFrom = request.getParameterValues("vocationalschoolfrom");
        String[] vocTo = request.getParameterValues("vocationalschoolto");
        String[] masFrom = request.getParameterValues("masteralschoolfrom");
        String[] masTo = request.getParameterValues("masteralschoolto");
        String[] othFrom = request.getParameterValues("otherfrom");
        String[] othTo = request.getParameterValues("otherto");

        //check if elem is greater than other elem years
        for (int i = 0; i < elemFrom.length && !isCoincide; i++) {
            for (int j = 0; j < elemFrom.length && !isCoincide; j++) {
                if (!elemFrom[i].equals("") && !elemTo[j].equals("")) {
                    if (Integer.parseInt(elemFrom[i]) > Integer.parseInt(elemTo[j])) {
                        isCoincide = true;
                    }
                }
            }
        }
        //check if elem is greater than other school years
        for (int i = 0; i < elemTo.length && !isCoincide; i++) {
            //high school
            for (int j = 0; j < highFrom.length && !isCoincide; j++) {
                if (!highFrom[j].equals("") && !elemTo[i].equals("")) {
                    if (Integer.parseInt(elemTo[i]) > Integer.parseInt(highFrom[j])) {
                        isCoincide = true;
                    }
                }
            }

            //college
            for (int j = 0; j < collFrom.length && !isCoincide; j++) {
                if (!collFrom[j].equals("") && !elemTo[i].equals("")) {
                    if (Integer.parseInt(elemTo[i]) > Integer.parseInt(collFrom[j])) {
                        isCoincide = true;
                    }
                }
            }

            //vocational
            for (int j = 0; j < vocFrom.length && !isCoincide; j++) {
                if (!vocFrom[j].equals("") && !elemTo[i].equals("")) {
                    if (Integer.parseInt(elemTo[i]) > Integer.parseInt(vocFrom[j])) {
                        isCoincide = true;
                    }
                }
            }

            //master
            for (int j = 0; j < masFrom.length && !isCoincide; j++) {
                if (!masFrom[j].equals("") && !elemTo[i].equals("")) {
                    if (Integer.parseInt(elemTo[i]) > Integer.parseInt(masFrom[j])) {
                        isCoincide = true;
                    }
                }
            }

            //other
            for (int j = 0; j < othFrom.length && !isCoincide; j++) {
                if (!othFrom[j].equals("") && !elemTo[i].equals("")) {
                    if (Integer.parseInt(elemTo[i]) > Integer.parseInt(othFrom[j])) {
                        isCoincide = true;
                    }
                }
            }
        }

        //check if high school is greater than other high school years
        for (int i = 0; i < highFrom.length && !isCoincide; i++) {
            for (int j = 0; j < highFrom.length && !isCoincide; j++) {
                if (!highFrom[i].equals("") && !highTo[j].equals("")) {
                    if (Integer.parseInt(highFrom[i]) > Integer.parseInt(highTo[j])) {
                        isCoincide = true;
                    }
                }
            }
        }

        //check if high school is greater than other school years
        for (int i = 0; i < highTo.length && !isCoincide; i++) {
            //college
            for (int j = 0; j < collFrom.length && !isCoincide; j++) {
                if (!collFrom[j].equals("") && !highTo[i].equals("")) {
                    if (Integer.parseInt(highTo[i]) > Integer.parseInt(collFrom[j])) {
                        isCoincide = true;
                    }
                }
            }

            //vocational
            for (int j = 0; j < vocFrom.length && !isCoincide; j++) {
                if (!vocFrom[j].equals("") && !highTo[i].equals("")) {
                    if (Integer.parseInt(highTo[i]) > Integer.parseInt(vocFrom[j])) {
                        isCoincide = true;
                    }
                }
            }

            //master
            for (int j = 0; j < masFrom.length && !isCoincide; j++) {
                if (!masFrom[j].equals("") && !highTo[i].equals("")) {
                    if (Integer.parseInt(highTo[i]) > Integer.parseInt(masFrom[j])) {
                        isCoincide = true;
                    }
                }
            }

            //other
            for (int j = 0; j < othFrom.length && !isCoincide; j++) {
                if (!othFrom[j].equals("") && !highTo[i].equals("")) {
                    if (Integer.parseInt(highTo[i]) > Integer.parseInt(othFrom[j])) {
                        isCoincide = true;
                    }
                }
            }
        }

        //check if college is greater than other college years
        for (int i = 0; i < collFrom.length && !isCoincide; i++) {
            for (int j = 0; j < collFrom.length && !isCoincide; j++) {
                if (!collFrom[j].equals("") && !collTo[i].equals("")) {
                    if (Integer.parseInt(collFrom[i]) > Integer.parseInt(collTo[j])) {
                        isCoincide = true;
                    }
                }
            }
        }

        //check if college is greater than other school years
        for (int i = 0; i < collTo.length && !isCoincide; i++) {
            //vocational
            for (int j = 0; j < vocFrom.length && !isCoincide; j++) {
                if (!vocFrom[j].equals("") && !collTo[i].equals("")) {
                    if (Integer.parseInt(collTo[i]) > Integer.parseInt(vocFrom[j])) {
                        isCoincide = true;
                    }
                }
            }

            //master
            for (int j = 0; j < masFrom.length && !isCoincide; j++) {
                if (!masFrom[j].equals("") && !collTo[i].equals("")) {
                    if (Integer.parseInt(collTo[i]) > Integer.parseInt(masFrom[j])) {
                        isCoincide = true;
                    }
                }
            }

            //other
            for (int j = 0; j < othFrom.length && !isCoincide; j++) {
                if (!othFrom[j].equals("") && !collTo[i].equals("")) {
                    if (Integer.parseInt(collTo[i]) > Integer.parseInt(othFrom[j])) {
                        isCoincide = true;
                    }
                }
            }
        }

        //check if masters is greater than other masters years
        for (int i = 0; i < masFrom.length && !isCoincide; i++) {
            for (int j = 0; j < masFrom.length && !isCoincide; j++) {
                if (!masFrom[j].equals("") && !masTo[i].equals("")) {
                    if (Integer.parseInt(masFrom[i]) > Integer.parseInt(masTo[j])) {
                        isCoincide = true;
                    }
                }
            }
        }

        //check if masters is greater than other school years
        for (int i = 0; i < masTo.length && !isCoincide; i++) {
            //vocational
            for (int j = 0; j < vocFrom.length && !isCoincide; j++) {
                if (!vocFrom[j].equals("") && !masTo[i].equals("")) {
                    if (Integer.parseInt(masTo[i]) > Integer.parseInt(vocFrom[j])) {
                        isCoincide = true;
                    }
                }
            }

            //other
            for (int j = 0; j < othFrom.length && !isCoincide; j++) {
                if (!othFrom[j].equals("") && !masTo[i].equals("")) {
                    if (Integer.parseInt(masTo[i]) > Integer.parseInt(othFrom[j])) {
                        isCoincide = true;
                    }
                }
            }
        }

        //check if vocational is greater than other college years
        for (int i = 0; i < vocFrom.length && !isCoincide; i++) {
            for (int j = 0; j < vocFrom.length && !isCoincide; j++) {
                if (!vocFrom[j].equals("") && !vocTo[i].equals("")) {
                    if (Integer.parseInt(vocFrom[i]) > Integer.parseInt(vocTo[j])) {
                        isCoincide = true;
                    }
                }
            }
        }

        //check if vocational is greater than other school years
        for (int i = 0; i < vocTo.length && !isCoincide; i++) {
            //other
            for (int j = 0; j < othFrom.length && !isCoincide; j++) {
                if (!vocTo[i].equals("") && !othFrom[j].equals("")) {
                    if (Integer.parseInt(vocTo[i]) > Integer.parseInt(othFrom[j])) {
                        isCoincide = true;
                    }
                }
            }
        }

        //check if others is greater than other college years
        for (int i = 0; i < othFrom.length && !isCoincide; i++) {
            for (int j = 0; j < othFrom.length && !isCoincide; j++) {
                if (!othFrom[i].equals("") && !othTo[j].equals("")) {
                    if (Integer.parseInt(othFrom[i]) > Integer.parseInt(othTo[j])) {
                        isCoincide = true;
                    }
                }
            }
        }
        return isCoincide;
    }
    
    public boolean checkEmployee(int managerid){
        boolean isEmployee = false;
        Database db = Database.getInstance();
        modelEmployee emp = db.getEmployee(Integer.toString(managerid));
        
        if(emp.getEmployeeType().equals("Employee"))
            isEmployee = true;
        
        return isEmployee;
    }
}
