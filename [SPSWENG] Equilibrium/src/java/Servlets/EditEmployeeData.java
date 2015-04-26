
/*  Class Name:     EditEmployeeData
*   Developer:      Arces Talavera
*   Description:    servlet used by the hr manager to submit the edited employee data
*/ 

package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
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
        
        String emailadd = request.getParameter("email");
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
                    db.changeFieldValue("employee", emp.getEntryNum(), "PAGIBIG", pagibig);
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
}
