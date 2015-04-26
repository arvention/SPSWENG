
/*  Class Name:     EditEmployeeData
 *   Developer:      Arces Talavera
 *   Description:    servlet used by the hr manager to submit the edited employee data
 */
package Servlets;

import Database.Database;
import Models.modelCriminalOffenseHistory;
import Models.modelEducationHistory;
import Models.modelEmployee;
import Models.modelEmploymentHistory;
import Models.modelLicense;
import Models.modelRelative;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditEmployeeData extends HttpServlet {

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
        modelEmployee logged = (modelEmployee) request.getSession().getAttribute("employee");
        modelEmployee emp = (modelEmployee) request.getSession().getAttribute("viewEmp");
        try {
            editPersonalInformation(logged, emp, request);
            editRelatives(logged, emp, request);
            editEducationHistory(logged, emp, request);
            editEmploymentHistory(logged, emp, request);
            editCriminalOffenseHistory(logged, emp, request);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void editPersonalInformation(modelEmployee logged, modelEmployee emp, HttpServletRequest request) throws ParseException {
        Database db = Database.getInstance();
        
        String employeeType = request.getParameter("empType");
        if (!emp.getEmployeeType().equals(employeeType)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "employeeType", emp.getEmployeeType(), employeeType, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "employeeType", emp.getEmployeeType(), employeeType, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());
                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "employeeType", employeeType);
                    break;
            }
        }
        
        String firstname = request.getParameter("firstname");
        if (!emp.getFirstName().equals(firstname)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "firstName", emp.getFirstName(), firstname, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "firstName", emp.getFirstName(), firstname, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());
                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "firstName", firstname);
                    break;
            }
        }

        String middlename = request.getParameter("middlename");
        if (!emp.getMiddleName().equals(middlename)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "middleName", emp.getMiddleName(), middlename, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "middleName", emp.getMiddleName(), middlename, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());
                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "middleName", middlename);
                    break;
            }
        }

        String lastname = request.getParameter("lastname");
        if (!emp.getLastName().equals(lastname)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "lastName", emp.getLastName(), lastname, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "middleName", emp.getMiddleName(), middlename, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());
                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "lastName", lastname);
                    break;
            }
        }

        String position = request.getParameter("position");
        if (!emp.getPositionName().equals(position)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "positionName", emp.getPositionName(), position, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "positionName", emp.getPositionName(), position, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "middleName", middlename);
                    break;
            }
        }

        int salary = Integer.parseInt(request.getParameter("salary"));
        if (emp.getSalary() != salary) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "salary", Integer.toString(emp.getSalary()), Integer.toString(salary), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "salary", Integer.toString(emp.getSalary()), Integer.toString(salary), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "salary", Integer.toString(salary));
                    break;
            }
        }
        String birthplace = request.getParameter("birthplace");
        if (!emp.getBirthplace().equals(birthplace)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "birthplace", emp.getBirthplace(), birthplace, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "birthplace", emp.getBirthplace(), birthplace, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "birthplace", birthplace);
                    break;
            }
        }

        String birthday = request.getParameter("birthday");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (!sdf.format(emp.getBirthday()).equals(sdf.format(sdf.parse(birthday)))) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "birthday", sdf.format(emp.getBirthday()), sdf.format(birthday), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "birthday", sdf.format(emp.getBirthday()), sdf.format(birthday), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "birthday", sdf.format(birthday));
                    break;
            }
        }

        String address = request.getParameter("address");
        if (!emp.getAddress().equals(address)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "address", emp.getAddress(), address, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "address", emp.getAddress(), address, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "address", address);
                    break;
            }
        }

        int homephone = Integer.parseInt(request.getParameter("homephone"));
        if (emp.getHomePhone() != homephone) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "homePhone", Integer.toString(emp.getHomePhone()), Integer.toString(homephone), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "homePhone", Integer.toString(emp.getHomePhone()), Integer.toString(homephone), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "homePhone", homephone);
                    break;
            }
        }

        long mobile = Long.parseLong(request.getParameter("mobile"));
        if (emp.getMobileNumber() != mobile) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "mobileNumber", Long.toString(emp.getMobileNumber()), Long.toString(mobile), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "mobileNumber", Long.toString(emp.getMobileNumber()), Long.toString(mobile), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "mobileNumber", Long.toString(mobile));
                    break;
            }
        }

        String emailadd = request.getParameter("emailadd");
        if (!emp.getEmailAddress().equals(emailadd)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "emailAddress", emp.getEmailAddress(), emailadd, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "emailAddress", emp.getEmailAddress(), emailadd, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "emailAddress", emailadd);
                    break;
            }
        }

        String civil = request.getParameter("civilstatus");
        if (!emp.getCivilStatus().equals(civil)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "civilStatus", emp.getCivilStatus(), civil, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "civilStatus", emp.getCivilStatus(), civil, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "civilStatus", civil);
                    break;
            }
        }

        String citizenship = request.getParameter("citizenship");
        if (!emp.getCitizenship().equals(citizenship)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "citizenship", emp.getCitizenship(), citizenship, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "citizenship", emp.getCitizenship(), citizenship, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "citizenship", citizenship);
                    break;
            }
        }

        String religion = request.getParameter("religion");
        if (!emp.getReligion().equals(religion)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "religion", emp.getReligion(), religion, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "religion", emp.getReligion(), religion, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "religion", religion);
                    break;
            }
        }

        String sss = request.getParameter("sssnum");
        if (!emp.getSSSNumber().equals(sss)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "SSSNumber", emp.getSSSNumber(), sss, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "SSSNumber", emp.getSSSNumber(), sss, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "SSSNumber", sss);
                    break;
            }
        }

        String tin = request.getParameter("tinnum");
        if (!emp.getTINNumber().equals(tin)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "TINNumber", emp.getTINNumber(), tin, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "TINNumber", emp.getTINNumber(), tin, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "TINNumber", tin);
                    break;
            }
        }

        String phic = request.getParameter("phicnum");
        if (!emp.getPHICNumber().equals(phic)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "PHICNumber", emp.getPHICNumber(), phic, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "PHICNumber", emp.getPHICNumber(), phic, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "PHICNumber", phic);
                    break;
            }
        }

        String pagibig = request.getParameter("pagibignum");
        if (!emp.getPAGIBIGNumber().equals(pagibig)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "PAGIBIGNumber", emp.getPAGIBIGNumber(), pagibig, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "PAGIBIGNumber", emp.getPAGIBIGNumber(), pagibig, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "PAGIBIGNumber", pagibig);
                    break;
            }
        }

        String band = request.getParameter("band");
        if (!emp.getBand().equals(band)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "band", emp.getBand(), band, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "band", emp.getBand(), band, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "band", band);
                    break;
            }
        }

        String manager = request.getParameter("managerid");
        if ((db.getFirstName(emp.getManagerEntryNum()) + " " + db.getLastName(emp.getManagerEntryNum())).equals(manager)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "managerEntryNum", Integer.toString(db.getEmployeeID(emp.getManagerEntryNum())), Integer.toString(db.getEntryNum(Integer.parseInt(manager))), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "managerEntryNum", Integer.toString(db.getEmployee(manager).getEmployeeID()), Integer.toString(db.getEntryNum(Integer.parseInt(manager))), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "managerEntryNum", Integer.toString(db.getEmployeeID(emp.getManagerEntryNum())));
                    break;
            }
        }
    }

    public void editRelatives(modelEmployee logged, modelEmployee emp, HttpServletRequest request) {
        Database db = Database.getInstance();
        if (!emp.getCivilStatus().equals("Single")) {
            //spouse
            modelRelative spouse = db.getSpouse(emp.getEntryNum());
            if (spouse != null) {
                int spouseID = Integer.parseInt(request.getParameter("spouseid"));
                String spousename = request.getParameter("spousename");
                if (!spouse.getName().equals(spousename)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("relative", spouseID, "name", spouse.getName(), spousename, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("relative", spouseID, "name", spouse.getName(), spousename, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("relative", spouseID, "name", spousename);
                            break;
                    }
                }
                long spousecontact = Long.parseLong(request.getParameter("spousecontact"));
                if (spouse.getContactNum() != spousecontact) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("relative", spouseID, "contactNum", Long.toString(spouse.getContactNum()), Long.toString(spousecontact), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("relative", spouseID, "contactNum", Long.toString(spouse.getContactNum()), Long.toString(spousecontact), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("relative", spouseID, "contactNum", Long.toString(spousecontact));
                            break;
                    }
                }

                String spouseoccupation = request.getParameter("spouseoccupation");
                if (!spouse.getOccupation().equals(spouseoccupation)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("relative", spouseID, "occupation", spouse.getOccupation(), spouseoccupation, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("relative", spouseID, "occupation", spouse.getOccupation(), spouseoccupation, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("relative", spouseID, "occupation", spouseoccupation);
                            break;
                    }
                }
            }

            //children
            String[] childrenID = request.getParameterValues("childid");
            String[] childrenName = request.getParameterValues("childname");
            String[] childrenAge = request.getParameterValues("childage");
            String[] childrenOccupation = request.getParameterValues("childoccupation");
            String[] childrenLocation = request.getParameterValues("childlocation");
            ArrayList<modelRelative> children = db.getRelatives("child", emp.getEntryNum());

            if (childrenID != null) {
                for (int i = 0; i < childrenID.length; i++) {
                    modelRelative child = children.get(i);
                    int childID = Integer.parseInt(childrenID[i]);

                    String childname = childrenName[i];
                    if (!child.getName().equals(childname)) {
                        switch (logged.getEmployeeType()) {
                            case "Hr Employee":
                                db.addEmployeeAuditTrail("relative", childID, "name", child.getName(), childname, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                                break;
                            case "Hr Head":
                                int auditTrailID = db.addEmployeeAuditTrail("relative", childID, "name", child.getName(), childname, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                                db.changeAuditStatus(auditTrailID, "Approved");
                                db.changeFieldValue("relative", childID, "name", childname);
                                break;
                        }
                    }

                    int childage = Integer.parseInt(childrenAge[i]);
                    if (childage != child.getAge()) {
                        switch (logged.getEmployeeType()) {
                            case "Hr Employee":
                                db.addEmployeeAuditTrail("relative", childID, "age", Integer.toString(child.getAge()), Integer.toString(childage), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                                break;
                            case "Hr Head":
                                int auditTrailID = db.addEmployeeAuditTrail("relative", childID, "age", Integer.toString(child.getAge()), Integer.toString(childage), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                                db.changeAuditStatus(auditTrailID, "Approved");
                                db.changeFieldValue("relative", childID, "age", Integer.toString(child.getAge()));
                                break;
                        }
                    }

                    String childoccupation = childrenOccupation[i];
                    if (!child.getOccupation().equals(childoccupation)) {
                        switch (logged.getEmployeeType()) {
                            case "Hr Employee":
                                db.addEmployeeAuditTrail("relative", childID, "occupation", child.getOccupation(), childoccupation, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                                break;
                            case "Hr Head":
                                int auditTrailID = db.addEmployeeAuditTrail("relative", childID, "occupation", child.getOccupation(), childoccupation, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                                db.changeAuditStatus(auditTrailID, "Approved");
                                db.changeFieldValue("relative", childID, "occupation", childoccupation);
                                break;
                        }
                    }

                    String childlocation = childrenLocation[i];
                    if (!child.getOccupationLocation().equals(childlocation)) {
                        switch (logged.getEmployeeType()) {
                            case "Hr Employee":
                                db.addEmployeeAuditTrail("relative", childID, "occupationLocation", child.getOccupationLocation(), childlocation, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                                break;
                            case "Hr Head":
                                int auditTrailID = db.addEmployeeAuditTrail("relative", childID, "occupationLocation", child.getOccupationLocation(), childlocation, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                                db.changeAuditStatus(auditTrailID, "Approved");
                                db.changeFieldValue("relative", childID, "occupationLocation", childlocation);
                                break;
                        }
                    }
                }
            }
        }

        //father
        modelRelative father = db.getParent("father", emp.getEntryNum());

        if (father != null) {
            int fatherID = Integer.parseInt(request.getParameter("fatherid"));

            String fathername = request.getParameter("fathername");
            if (!father.getName().equals(fathername)) {
                switch (logged.getEmployeeType()) {
                    case "Hr Employee":
                        db.addEmployeeAuditTrail("relative", fatherID, "name", father.getName(), fathername, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                        break;
                    case "Hr Head":
                        int auditTrailID = db.addEmployeeAuditTrail("relative", fatherID, "name", father.getName(), fathername, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                        db.changeAuditStatus(auditTrailID, "Approved");
                        db.changeFieldValue("relative", fatherID, "name", fathername);
                        break;
                }
            }

            int fatherage = Integer.parseInt(request.getParameter("fatherage"));
            if (father.getAge() != fatherage) {
                switch (logged.getEmployeeType()) {
                    case "Hr Employee":
                        db.addEmployeeAuditTrail("relative", fatherID, "age", Integer.toString(father.getAge()), Integer.toString(fatherage), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                        break;
                    case "Hr Head":
                        int auditTrailID = db.addEmployeeAuditTrail("relative", fatherID, "age", Integer.toString(father.getAge()), Integer.toString(fatherage), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                        db.changeAuditStatus(auditTrailID, "Approved");
                        db.changeFieldValue("relative", fatherID, "age", Integer.toString(fatherage));
                        break;
                }
            }

            String fatheroccupation = request.getParameter("fatheroccupation");
            if (!father.getOccupation().equals(fatheroccupation)) {
                switch (logged.getEmployeeType()) {
                    case "Hr Employee":
                        db.addEmployeeAuditTrail("relative", fatherID, "occupation", father.getOccupation(), fatheroccupation, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                        break;
                    case "Hr Head":
                        int auditTrailID = db.addEmployeeAuditTrail("relative", fatherID, "occupation", father.getName(), fatheroccupation, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                        db.changeAuditStatus(auditTrailID, "Approved");
                        db.changeFieldValue("relative", fatherID, "occupation", fatheroccupation);
                        break;
                }
            }
        }

        //mother
        modelRelative mother = db.getParent("mother", emp.getEntryNum());

        if (mother != null) {
            int motherID = Integer.parseInt(request.getParameter("motherid"));

            String mothername = request.getParameter("mothername");
            if (!mother.getName().equals(mothername)) {
                switch (logged.getEmployeeType()) {
                    case "Hr Employee":
                        db.addEmployeeAuditTrail("relative", motherID, "name", mother.getName(), mothername, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                        break;
                    case "Hr Head":
                        int auditTrailID = db.addEmployeeAuditTrail("relative", motherID, "name", mother.getName(), mothername, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                        db.changeAuditStatus(auditTrailID, "Approved");
                        db.changeFieldValue("relative", motherID, "name", mothername);
                        break;
                }
            }

            int motherage = Integer.parseInt(request.getParameter("motherage"));
            if (mother.getAge() != motherage) {
                switch (logged.getEmployeeType()) {
                    case "Hr Employee":
                        db.addEmployeeAuditTrail("relative", motherID, "age", Integer.toString(mother.getAge()), Integer.toString(motherage), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                        break;
                    case "Hr Head":
                        int auditTrailID = db.addEmployeeAuditTrail("relative", motherID, "age", Integer.toString(mother.getAge()), Integer.toString(motherage), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                        db.changeAuditStatus(auditTrailID, "Approved");
                        db.changeFieldValue("relative", motherID, "age", Integer.toString(motherage));
                        break;
                }
            }

            String motheroccupation = request.getParameter("motheroccupation");
            if (!mother.getOccupation().equals(motheroccupation)) {
                switch (logged.getEmployeeType()) {
                    case "Hr Employee":
                        db.addEmployeeAuditTrail("relative", motherID, "occupation", mother.getOccupation(), motheroccupation, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                        break;
                    case "Hr Head":
                        int auditTrailID = db.addEmployeeAuditTrail("relative", motherID, "occupation", mother.getName(), motheroccupation, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                        db.changeAuditStatus(auditTrailID, "Approved");
                        db.changeFieldValue("relative", motherID, "occupation", motheroccupation);
                        break;
                }
            }
        }

        //sibling
        String[] siblingsID = request.getParameterValues("siblingid");
        String[] siblingsName = request.getParameterValues("siblingname");
        String[] siblingsAge = request.getParameterValues("siblingage");
        String[] siblingsOccupation = request.getParameterValues("siblingoccupation");
        String[] siblingsLocation = request.getParameterValues("siblinglocation");
        ArrayList<modelRelative> siblings = db.getRelatives("sibling", emp.getEntryNum());
        if (siblingsID != null) {
            for (int i = 0; i < siblingsID.length; i++) {
                modelRelative sibling = siblings.get(i);
                int siblingID = Integer.parseInt(siblingsID[i]);

                String siblingname = siblingsName[i];
                if (!sibling.getName().equals(siblingname)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("relative", siblingID, "name", sibling.getName(), siblingname, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("relative", siblingID, "name", sibling.getName(), siblingname, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("relative", siblingID, "name", siblingname);
                            break;
                    }
                }

                int siblingage = Integer.parseInt(siblingsAge[i]);
                if (siblingage != sibling.getAge()) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("relative", siblingID, "age", Integer.toString(sibling.getAge()), Integer.toString(siblingage), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("relative", siblingID, "age", Integer.toString(sibling.getAge()), Integer.toString(siblingage), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("relative", siblingID, "age", Integer.toString(sibling.getAge()));
                            break;
                    }
                }

                String siblingoccupation = siblingsOccupation[i];
                if (!sibling.getOccupation().equals(siblingoccupation)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("relative", siblingID, "occupation", sibling.getOccupation(), siblingoccupation, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("relative", siblingID, "occupation", sibling.getOccupation(), siblingoccupation, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("relative", siblingID, "occupation", siblingoccupation);
                            break;
                    }
                }

                String siblinglocation = siblingsLocation[i];
                if (!sibling.getOccupationLocation().equals(siblinglocation)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("relative", siblingID, "occupationLocation", sibling.getOccupationLocation(), siblinglocation, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("relative", siblingID, "occupationLocation", sibling.getOccupationLocation(), siblinglocation, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("relative", siblingID, "occupationLocation", siblinglocation);
                            break;
                    }
                }
            }
        }
    }

    public void editEducationHistory(modelEmployee logged, modelEmployee emp, HttpServletRequest request) {
        Database db = Database.getInstance();
        //elementary
        String[] elemsID = request.getParameterValues("elemid");
        String[] elemsName = request.getParameterValues("elemname");
        String[] elemsFrom = request.getParameterValues("elemfrom");
        String[] elemsTo = request.getParameterValues("elemto");
        String[] elemsAward = request.getParameterValues("elemaward");
        ArrayList<modelEducationHistory> educationlist = db.getEducation("Elementary", emp.getEntryNum());

        if (elemsID != null) {
            for (int i = 0; i < elemsID.length; i++) {
                modelEducationHistory education = educationlist.get(i);
                int elemID = Integer.parseInt(elemsID[i]);

                String elemname = elemsName[i];
                if (!education.getSchoolName().equals(elemname)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", elemID, "schoolName", education.getSchoolName(), elemname, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", elemID, "schoolName", education.getSchoolName(), elemname, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", elemID, "schoolName", elemname);
                            break;
                    }
                }

                int elemfrom = Integer.parseInt(elemsFrom[i]);
                if (education.getYearFrom() != elemfrom) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", elemID, "yearFrom", Integer.toString(education.getYearFrom()), Integer.toString(elemfrom), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", elemID, "yearFrom", Integer.toString(education.getYearFrom()), Integer.toString(elemfrom), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", elemID, "yearFrom", Integer.toString(elemfrom));
                            break;
                    }
                }

                int elemto = Integer.parseInt(elemsTo[i]);
                if (education.getYearTo() != elemto) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", elemID, "yearTo", Integer.toString(education.getYearTo()), Integer.toString(elemto), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", elemID, "yearTo", Integer.toString(education.getYearTo()), Integer.toString(elemto), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", elemID, "yearTo", Integer.toString(elemto));
                            break;
                    }
                }

                String elemaward = elemsAward[i];
                if (!education.getAward().equals(elemaward)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", elemID, "award", education.getAward(), elemaward, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", elemID, "award", education.getAward(), elemaward, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", elemID, "award", elemaward);
                            break;
                    }
                }
            }
        }

        //high school
        String[] highschoolsID = request.getParameterValues("highschoolid");
        String[] highschoolsName = request.getParameterValues("highschoolname");
        String[] highschoolsFrom = request.getParameterValues("highschoolfrom");
        String[] highschoolsTo = request.getParameterValues("highschoolto");
        String[] highschoolsAward = request.getParameterValues("highschoolaward");
        educationlist = db.getEducation("High School", emp.getEntryNum());

        if (highschoolsID != null) {
            for (int i = 0; i < highschoolsID.length; i++) {
                modelEducationHistory education = educationlist.get(i);
                int highschoolID = Integer.parseInt(highschoolsID[i]);

                String highschoolname = highschoolsName[i];
                if (!education.getSchoolName().equals(highschoolname)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", highschoolID, "schoolName", education.getSchoolName(), highschoolname, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", highschoolID, "schoolName", education.getSchoolName(), highschoolname, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", highschoolID, "schoolName", highschoolname);
                            break;
                    }
                }

                int highschoolfrom = Integer.parseInt(highschoolsFrom[i]);
                if (education.getYearFrom() != highschoolfrom) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", highschoolID, "yearFrom", Integer.toString(education.getYearFrom()), Integer.toString(highschoolfrom), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", highschoolID, "yearFrom", Integer.toString(education.getYearFrom()), Integer.toString(highschoolfrom), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", highschoolID, "yearFrom", Integer.toString(highschoolfrom));
                            break;
                    }
                }

                int highschoolto = Integer.parseInt(highschoolsTo[i]);
                if (education.getYearTo() != highschoolto) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", highschoolID, "yearTo", Integer.toString(education.getYearTo()), Integer.toString(highschoolto), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", highschoolID, "yearTo", Integer.toString(education.getYearTo()), Integer.toString(highschoolto), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", highschoolID, "yearTo", Integer.toString(highschoolto));
                            break;
                    }
                }

                String highschoolaward = highschoolsAward[i];
                if (!education.getAward().equals(highschoolaward)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", highschoolID, "award", education.getAward(), highschoolaward, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", highschoolID, "award", education.getAward(), highschoolaward, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", highschoolID, "award", highschoolaward);
                            break;
                    }
                }
            }
        }

        //college
        String[] collegesID = request.getParameterValues("collegeid");
        String[] collegesName = request.getParameterValues("collegename");
        String[] collegesFrom = request.getParameterValues("collegefrom");
        String[] collegesTo = request.getParameterValues("collegeto");
        String[] collegesAward = request.getParameterValues("collegeaward");
        educationlist = db.getEducation("College", emp.getEntryNum());

        if (collegesID != null) {
            for (int i = 0; i < collegesID.length; i++) {
                modelEducationHistory education = educationlist.get(i);
                int collegeID = Integer.parseInt(collegesID[i]);

                String collegename = collegesName[i];
                if (!education.getSchoolName().equals(collegename)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", collegeID, "schoolName", education.getSchoolName(), collegename, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", collegeID, "schoolName", education.getSchoolName(), collegename, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", collegeID, "schoolName", collegename);
                            break;
                    }
                }

                int collegefrom = Integer.parseInt(collegesFrom[i]);
                if (education.getYearFrom() != collegefrom) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", collegeID, "yearFrom", Integer.toString(education.getYearFrom()), Integer.toString(collegefrom), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", collegeID, "yearFrom", Integer.toString(education.getYearFrom()), Integer.toString(collegefrom), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", collegeID, "yearFrom", Integer.toString(collegefrom));
                            break;
                    }
                }

                int collegeto = Integer.parseInt(collegesTo[i]);
                if (education.getYearTo() != collegeto) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", collegeID, "yearTo", Integer.toString(education.getYearTo()), Integer.toString(collegeto), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", collegeID, "yearTo", Integer.toString(education.getYearTo()), Integer.toString(collegeto), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", collegeID, "yearTo", Integer.toString(collegeto));
                            break;
                    }
                }

                String collegeaward = collegesAward[i];
                if (!education.getAward().equals(collegeaward)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", collegeID, "award", education.getAward(), collegeaward, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", collegeID, "award", education.getAward(), collegeaward, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", collegeID, "award", collegeaward);
                            break;
                    }
                }
            }
        }

        //vocational
        String[] vocationalsID = request.getParameterValues("vocationalid");
        String[] vocationalsName = request.getParameterValues("vocationalname");
        String[] vocationalsFrom = request.getParameterValues("vocationalfrom");
        String[] vocationalsTo = request.getParameterValues("vocationalto");
        String[] vocationalsAward = request.getParameterValues("vocationalaward");
        educationlist = db.getEducation("College", emp.getEntryNum());

        if (vocationalsID != null) {
            for (int i = 0; i < vocationalsID.length; i++) {
                modelEducationHistory education = educationlist.get(i);
                int vocationalID = Integer.parseInt(vocationalsID[i]);

                String vocationalname = vocationalsName[i];
                if (!education.getSchoolName().equals(vocationalname)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", vocationalID, "schoolName", education.getSchoolName(), vocationalname, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", vocationalID, "schoolName", education.getSchoolName(), vocationalname, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", vocationalID, "schoolName", vocationalname);
                            break;
                    }
                }

                int vocationalfrom = Integer.parseInt(vocationalsFrom[i]);
                if (education.getYearFrom() != vocationalfrom) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", vocationalID, "yearFrom", Integer.toString(education.getYearFrom()), Integer.toString(vocationalfrom), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", vocationalID, "yearFrom", Integer.toString(education.getYearFrom()), Integer.toString(vocationalfrom), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", vocationalID, "yearFrom", Integer.toString(vocationalfrom));
                            break;
                    }
                }

                int vocationalto = Integer.parseInt(vocationalsTo[i]);
                if (education.getYearTo() != vocationalto) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", vocationalID, "yearTo", Integer.toString(education.getYearTo()), Integer.toString(vocationalto), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", vocationalID, "yearTo", Integer.toString(education.getYearTo()), Integer.toString(vocationalto), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", vocationalID, "yearTo", Integer.toString(vocationalto));
                            break;
                    }
                }

                String vocationalaward = vocationalsAward[i];
                if (!education.getAward().equals(vocationalaward)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", vocationalID, "award", education.getAward(), vocationalaward, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", vocationalID, "award", education.getAward(), vocationalaward, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", vocationalID, "award", vocationalaward);
                            break;
                    }
                }
            }
        }

        //master
        String[] mastersID = request.getParameterValues("masterid");
        String[] mastersName = request.getParameterValues("mastername");
        String[] mastersFrom = request.getParameterValues("masterfrom");
        String[] mastersTo = request.getParameterValues("masterto");
        String[] mastersAward = request.getParameterValues("masteraward");
        educationlist = db.getEducation("College", emp.getEntryNum());

        if (mastersID != null) {
            for (int i = 0; i < mastersID.length; i++) {
                modelEducationHistory education = educationlist.get(i);
                int masterID = Integer.parseInt(mastersID[i]);

                String mastername = mastersName[i];
                if (!education.getSchoolName().equals(mastername)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", masterID, "schoolName", education.getSchoolName(), mastername, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", masterID, "schoolName", education.getSchoolName(), mastername, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", masterID, "schoolName", mastername);
                            break;
                    }
                }

                int masterfrom = Integer.parseInt(mastersFrom[i]);
                if (education.getYearFrom() != masterfrom) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", masterID, "yearFrom", Integer.toString(education.getYearFrom()), Integer.toString(masterfrom), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", masterID, "yearFrom", Integer.toString(education.getYearFrom()), Integer.toString(masterfrom), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", masterID, "yearFrom", Integer.toString(masterfrom));
                            break;
                    }
                }

                int masterto = Integer.parseInt(mastersTo[i]);
                if (education.getYearTo() != masterto) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", masterID, "yearTo", Integer.toString(education.getYearTo()), Integer.toString(masterto), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", masterID, "yearTo", Integer.toString(education.getYearTo()), Integer.toString(masterto), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", masterID, "yearTo", Integer.toString(masterto));
                            break;
                    }
                }

                String masteraward = mastersAward[i];
                if (!education.getAward().equals(masteraward)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", masterID, "award", education.getAward(), masteraward, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", masterID, "award", education.getAward(), masteraward, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", masterID, "award", masteraward);
                            break;
                    }
                }
            }
        }

        //other
        String[] othersID = request.getParameterValues("otherid");
        String[] othersName = request.getParameterValues("othername");
        String[] othersFrom = request.getParameterValues("otherfrom");
        String[] othersTo = request.getParameterValues("otherto");
        String[] othersAward = request.getParameterValues("otheraward");
        educationlist = db.getEducation("College", emp.getEntryNum());

        if (othersID != null) {
            for (int i = 0; i < othersID.length; i++) {
                modelEducationHistory education = educationlist.get(i);
                int otherID = Integer.parseInt(othersID[i]);

                String othername = othersName[i];
                if (!education.getSchoolName().equals(othername)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", otherID, "schoolName", education.getSchoolName(), othername, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", otherID, "schoolName", education.getSchoolName(), othername, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", otherID, "schoolName", othername);
                            break;
                    }
                }

                int otherfrom = Integer.parseInt(othersFrom[i]);
                if (education.getYearFrom() != otherfrom) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", otherID, "yearFrom", Integer.toString(education.getYearFrom()), Integer.toString(otherfrom), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", otherID, "yearFrom", Integer.toString(education.getYearFrom()), Integer.toString(otherfrom), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", otherID, "yearFrom", Integer.toString(otherfrom));
                            break;
                    }
                }

                int otherto = Integer.parseInt(othersTo[i]);
                if (education.getYearTo() != otherto) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", otherID, "yearTo", Integer.toString(education.getYearTo()), Integer.toString(otherto), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", otherID, "yearTo", Integer.toString(education.getYearTo()), Integer.toString(otherto), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", otherID, "yearTo", Integer.toString(otherto));
                            break;
                    }
                }

                String otheraward = othersAward[i];
                if (!education.getAward().equals(otheraward)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("education_history", otherID, "award", education.getAward(), otheraward, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("education_history", otherID, "award", education.getAward(), otheraward, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("education_history", otherID, "award", otheraward);
                            break;
                    }
                }
            }
        }
    }

    public void editLicense(modelEmployee logged, modelEmployee emp, HttpServletRequest request) {
        Database db = Database.getInstance();

        String[] licensesID = request.getParameterValues("licenseid");
        String[] licensesName = request.getParameterValues("licensename");
        String[] licensesScore = request.getParameterValues("licensescore");
        ArrayList<modelLicense> licenses = db.getLicenses(emp.getEntryNum());

        if (licensesID != null) {
            for (int i = 0; i < licensesID.length; i++) {
                modelLicense license = licenses.get(i);
                int licenseID = Integer.parseInt(licensesID[i]);

                String licensename = licensesName[i];
                if (!license.getLicenseName().equals(licensename)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("license", licenseID, "licenseName", license.getLicenseName(), licensename, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("license", licenseID, "licenseName", license.getLicenseName(), licensename, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("license", licenseID, "licenseName", licensename);
                            break;
                    }
                }

                int licensescore = Integer.parseInt(licensesScore[i]);
                if (license.getPercentage() != licensescore) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("license", licenseID, "percentage", Integer.toString(license.getPercentage()), Integer.toString(licensescore), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("license", licenseID, "percentage", Integer.toString(license.getPercentage()), Integer.toString(licensescore), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("license", licenseID, "percentage", Integer.toString(licensescore));
                            break;
                    }
                }
            }
        }
    }

    public void editEmploymentHistory(modelEmployee logged, modelEmployee emp, HttpServletRequest request) throws ParseException {
        Database db = Database.getInstance();

        String[] histosID = request.getParameterValues("histoid");
        String[] histosOccupation = request.getParameterValues("histooccupation");
        String[] histosDate = request.getParameterValues("histodate");
        String[] histosStart = request.getParameterValues("histostartsalary");
        String[] histosEnd = request.getParameterValues("histoendsalary");
        String[] histosEmpName = request.getParameterValues("histoemployername");
        String[] histosEmpAddress = request.getParameterValues("histoemployeraddress");
        String[] histosEmpContact = request.getParameterValues("histoemployercontact");
        String[] histosSupName = request.getParameterValues("histosupervisorname");
        String[] histosSupContact = request.getParameterValues("histosupervisorcontact");
        String[] histosReason = request.getParameterValues("historeason");
        ArrayList<modelEmploymentHistory> histos = db.getEmploymentHistory(emp.getEntryNum());

        if (histosID != null) {
            for (int i = 0; i < histosID.length; i++) {
                modelEmploymentHistory histo = histos.get(i);
                int histoID = Integer.parseInt(histosID[i]);

                String histooccupation = histosOccupation[i];
                if (!histo.getJobTitle().equals(histooccupation)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("employment_history", histoID, "jobTitle", histo.getJobTitle(), histooccupation, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("employment_history", histoID, "jobTitle", histo.getJobTitle(), histooccupation, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("employment_history", histoID, "jobTitle", histooccupation);
                            break;
                    }
                }

                String histodate = histosDate[i];
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if (!sdf.format(histo.getDateOfEmployment()).equals(sdf.format(sdf.parse(histodate)))) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("employment_history", histoID, "dateOfEmployment", sdf.format(histo.getDateOfEmployment()), sdf.format(histodate), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("employee", histoID, "dateOfEmployment", sdf.format(histo.getDateOfEmployment()), sdf.format(histodate), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("employment_history", histoID, "dateOfEmployment", sdf.format(histodate));
                            break;
                    }
                }

                int startsalary = Integer.parseInt(histosStart[i]);

                if (histo.getStartingSalary() != startsalary) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("employment_history", histoID, "startingSalary", Integer.toString(histo.getStartingSalary()), Integer.toString(startsalary), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("employment_history", histoID, "startingSalary", Integer.toString(histo.getStartingSalary()), Integer.toString(startsalary), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("employment_history", histoID, "startingSalary", Integer.toString(startsalary));
                            break;
                    }
                }

                int endsalary = Integer.parseInt(histosEnd[i]);

                if (histo.getEndingSalary() != endsalary) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("employment_history", histoID, "endingSalary", Integer.toString(histo.getEndingSalary()), Integer.toString(endsalary), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("employment_history", histoID, "endingSalary", Integer.toString(histo.getEndingSalary()), Integer.toString(endsalary), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("employment_history", histoID, "endingSalary", Integer.toString(endsalary));
                            break;
                    }
                }

                String histoempname = histosEmpName[i];
                if (!histo.getEmployerName().equals(histoempname)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("employment_history", histoID, "employerName", histo.getEmployerName(), histoempname, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("employment_history", histoID, "employerName", histo.getEmployerName(), histoempname, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("employment_history", histoID, "employerName", histoempname);
                            break;
                    }
                }

                String histoempaddress = histosEmpAddress[i];
                if (!histo.getEmployerAddress().equals(histoempaddress)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("employment_history", histoID, "employerAddress", histo.getEmployerAddress(), histoempaddress, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("employment_history", histoID, "employerAddress", histo.getEmployerAddress(), histoempaddress, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("employment_history", histoID, "employerAddress", histoempaddress);
                            break;
                    }
                }
                
                long empcontact = Long.parseLong(histosEmpContact[i]);
                if (histo.getEmployerContactNum() != empcontact) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("employment_history", histoID, "employerContactNumber", Long.toString(histo.getEmployerContactNum()), Long.toString(empcontact), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("employment_history", histoID, "employerContactNumber", Long.toString(histo.getEmployerContactNum()), Long.toString(empcontact), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("employment_history", histoID, "employerContactNumber", Long.toString(empcontact));
                            break;
                    }
                }
                
                String histosupname = histosSupName[i];
                if (!histo.getSupervisorName().equals(histosupname)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("employment_history", histoID, "supervisorName", histo.getSupervisorName(), histosupname, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("employment_history", histoID, "supervisorName", histo.getSupervisorName(), histosupname, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("employment_history", histoID, "supervisorName", histosupname);
                            break;
                    }
                }

                long supcontact = Long.parseLong(histosSupContact[i]);
                if (histo.getSupervisorContactNum() != supcontact) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("employment_history", histoID, "supervisorContactNumber", Long.toString(histo.getSupervisorContactNum()), Long.toString(supcontact), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("employment_history", histoID, "supervisorContactNumber", Long.toString(histo.getSupervisorContactNum()), Long.toString(supcontact), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("employment_history", histoID, "supervisorContactNumber", Long.toString(supcontact));
                            break;
                    }
                }
                
                String historeason = histosReason[i];
                if (!histo.getReasonForLeaving().equals(historeason)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("employment_history", histoID, "reasonForLeaving", histo.getReasonForLeaving(), historeason, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("employment_history", histoID, "reasonForLeaving", histo.getReasonForLeaving(), historeason, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("employment_history", histoID, "reasonForLeaving", historeason);
                            break;
                    }
                }
            }
        }
    }

    public void editCriminalOffenseHistory(modelEmployee logged, modelEmployee emp, HttpServletRequest request) throws ParseException {
        Database db = Database.getInstance();
        String[] offensesID = request.getParameterValues("offenseid");
        String[] offensesName = request.getParameterValues("offensename");
        String[] offensesDate = request.getParameterValues("offensedate");
        String[] offensesPlace = request.getParameterValues("offenseplace");
        ArrayList<modelCriminalOffenseHistory> offenses = db.getCriminalOffenses(emp.getEntryNum());

        if (offensesID != null) {
            for (int i = 0; i < offensesID.length; i++) {
                modelCriminalOffenseHistory offense = offenses.get(i);
                int offenseID = Integer.parseInt(offensesID[i]);

                String offensename = offensesName[i];
                if (!offense.getCriminalOffense().equals(offensename)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("criminal_offense_history", offenseID, "criminalOffense", offense.getCriminalOffense(), offensename, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("criminal_offense_history", offenseID, "criminalOffense", offense.getCriminalOffense(), offensename, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("criminal_offense_history", offenseID, "criminalOffense", offensename);
                            break;
                    }
                }

                String offensedate = offensesDate[i];
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if (!sdf.format(offense.getDateOfOffense()).equals(sdf.format(sdf.parse(offensedate)))) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("employee", offenseID, "birthday", sdf.format(offense.getDateOfOffense()), sdf.format(offensedate), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("employee", offenseID, "birthday", sdf.format(offense.getDateOfOffense()), sdf.format(offensedate), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("employee", offenseID, "birthday", sdf.format(offensedate));
                            break;
                    }
                }

                String offenseplace = offensesPlace[i];
                if (!offense.getPlaceOfOffense().equals(offenseplace)) {
                    switch (logged.getEmployeeType()) {
                        case "Hr Employee":
                            db.addEmployeeAuditTrail("criminal_offense_history", offenseID, "placeOfOffense", offense.getPlaceOfOffense(), offenseplace, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                            break;
                        case "Hr Head":
                            int auditTrailID = db.addEmployeeAuditTrail("criminal_offense_history", offenseID, "placeOfOffense", offense.getPlaceOfOffense(), offenseplace, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());

                            db.changeAuditStatus(auditTrailID, "Approved");
                            db.changeFieldValue("criminal_offense_history", offenseID, "placeOfOffense", offenseplace);
                            break;
                    }
                }
            }
        }
    }
}
