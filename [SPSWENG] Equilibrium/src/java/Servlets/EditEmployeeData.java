
/*  Class Name:     EditEmployeeData
 *   Developer:      Arces Talavera
 *   Description:    servlet used by the hr manager to submit the edited employee data
 */
package Servlets;

import Database.Database;
import Models.modelEmployee;
import Models.modelRelative;
import java.io.IOException;
import java.util.ArrayList;
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
        editPersonalInformation(logged, emp, request);
        editRelatives(logged, emp, request);
        editEducationHistory(logged, emp, request);
    }

    public void editPersonalInformation(modelEmployee logged, modelEmployee emp, HttpServletRequest request) {
        Database db = Database.getInstance();
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
        //elementary
    }
}
