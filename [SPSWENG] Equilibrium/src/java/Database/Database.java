package Database;

import Models.modelBranch;
import Models.modelDepartment;
import Models.modelEmployee;
import Models.modelEmployeeAuditTrail;
import Models.modelLeaveForm;
import Models.modelRelative;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig(maxFileSize = 16177215)
public class Database {

    private Connection con;
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private static Database databaseInstance = new Database();

    private Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String host = "jdbc:mysql://127.0.0.1:3306/equilibrium_spsweng?user=root";
            String uUser = "root";
            String uPass = "admin";

            con = DriverManager.getConnection(host, uUser, uPass);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FAILED TO GET CONNECTION WHYY");
        }
    }

    public static Database getInstance() {
        return databaseInstance;
    }

    public Connection getConnection() {
        return this.con;
    }

// - FUNCTIONS -------------------------------------------------------------------------------
    public int getManager(int entryNum) {
        int manEntryNum = -1;

        try {
            sql = "SELECT E2.entryNum FROM employee E1, employee E2"
                    + " WHERE E1.entryNum = " + entryNum + " AND E1.managerEntryNum = E2.entryNum";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                manEntryNum = rs.getInt("entryNum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // -- if returned is -1, manager is not found
        return manEntryNum;
    }

    public String getFirstName(int entryNum) {
        String firstName = "";

        try {
            sql = "SELECT firstName FROM employee"
                    + " WHERE entryNum = " + entryNum;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                firstName = rs.getString("firstName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return firstName;
    }

    public boolean isValidID(int id) {
        String firstName = "";
        boolean valid = true;
        try {
            //sql = "SELECT firstName FROM employee"
            //       + " WHERE entryNum = " + entryNum;

            sql = "select employeeID from employee where employeeID = " + id;

            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                valid = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }

    public String getLastName(int entryNum) {
        String lastName = "";

        try {
            sql = "SELECT lastName FROM employee"
                    + " WHERE entryNum = " + entryNum;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                lastName = rs.getString("lastName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastName;
    }

    public int getIDNumber(int entryNum) {
        int empID = 0;

        try {
            sql = "SELECT employeeID FROM employee"
                    + " WHERE entryNum = " + entryNum;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                empID = rs.getInt("employeeID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empID;
    }

    public String getEmailAddress(int entryNum) {
        String emailAddress = "";

        try {
            sql = "SELECT emailAddress FROM employee"
                    + " WHERE entryNum = " + entryNum;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                emailAddress = rs.getString("emailAddress");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emailAddress;
    }

    public void addLeaveForm(String leaveType, int empEntryNum, Date startDate, float duration, int manEntryNum) {
        int leaveID = 1;
        try {
            //get highest leaveNum
            sql = "SELECT MAX(leaveID) FROM leave_form";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                leaveID = rs.getInt("MAX(leaveID)") + 1;
            }

            //insert the leave form entry
            sql = "INSERT INTO leave_form(leaveID, leaveType, empEntryNum, startDate, duration, approverEntryNum)"
                    + " VALUES(" + leaveID + ", '" + leaveType + "', " + empEntryNum + ", '" + startDate + "', " + duration + ", " + manEntryNum + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //-- LEAVE COUNT --------------------------------------------
    public float getApprovedLeaveCount(int empID) {
        float approveCount = 0;

        sql = "SELECT SUM(duration) FROM leave_form"
                + " WHERE empEntryNum = " + getEntryNum(empID) + " AND isApproved = true";

        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                approveCount = rs.getFloat("SUM(duration)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return approveCount;
    }

    public boolean checkEmpID(int empID) {
        boolean isFound = false;

        sql = "SELECT employeeID FROM employee"
                + " WHERE employeeID = " + empID;

        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                isFound = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isFound;
    }

    public int getEntryNum(int empID) {
        int entryNum = 0;
        sql = "SELECT entryNum FROM employee"
                + " WHERE employeeID = " + empID;

        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                entryNum = rs.getInt("entryNum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entryNum;
    }

    public modelEmployee getEmployee(String id) {

        sql = "SELECT * FROM employee"
                + " WHERE employeeID = " + id;

        modelEmployee modelEmployee = null;
        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                modelEmployee = new modelEmployee();
                int entryNum = rs.getInt("entryNum");
                modelEmployee.setEntryNum(entryNum);
                int employeeID = rs.getInt("employeeID");
                modelEmployee.setEmployeeID(employeeID);
                String password = rs.getString("password");
                modelEmployee.setPassword(password);
                String lastName = rs.getString("lastName");
                modelEmployee.setLastName(lastName);
                String firstName = rs.getString("firstName");
                modelEmployee.setFirstName(firstName);
                String middleName = rs.getString("middleName");
                modelEmployee.setMiddleName(middleName);
                String address = rs.getString("address");
                modelEmployee.setAddress(address);
                Date birthday = rs.getDate("birthday");
                modelEmployee.setBirthday(birthday);
                String birthplace = rs.getString("birthplace");
                modelEmployee.setBirthplace(birthplace);
                int homePhone = rs.getInt("homePhone");
                modelEmployee.setHomePhone(homePhone);
                long mobileNumber = rs.getLong("mobileNumber");
                modelEmployee.setMobileNumber(mobileNumber);
                String SSSNumber = rs.getString("SSSNumber");
                modelEmployee.setSSSNumber(SSSNumber);
                String TINNumber = rs.getString("TINNumber");
                modelEmployee.setTINNumber(TINNumber);
                String PHICNumber = rs.getString("PHICNumber");
                modelEmployee.setPHICNumber(PHICNumber);
                String PAGIBIGNumber = rs.getString("PAGIBIGNumber");
                modelEmployee.setPAGIBIGNumber(PAGIBIGNumber);
                String civilStatus = rs.getString("civilStatus");
                modelEmployee.setCivilStatus(civilStatus);
                String citizenship = rs.getString("citizenship");
                modelEmployee.setCitizenship(citizenship);
                String religion = rs.getString("religion");
                modelEmployee.setReligion(religion);
                Date hireDate = rs.getDate("hireDate");
                modelEmployee.setHireDate(hireDate);
                String band = rs.getString("band");
                modelEmployee.setBand(band);
                int salary = rs.getInt("salary");
                modelEmployee.setSalary(salary);
                int departmentID = rs.getInt("departmentID");
                modelEmployee.setDepartmentID(departmentID);
                String positionName = rs.getString("positionName");
                modelEmployee.setPositionName(positionName);
                boolean isDeleted = rs.getBoolean("isDeleted");
                modelEmployee.setIsDeleted(isDeleted);
                String emailAddress = rs.getString("emailAddress");
                modelEmployee.setEmailAddress(emailAddress);
                String employeeType = rs.getString("employeeType");
                modelEmployee.setEmployeeType(employeeType);
                int managerEntryNum = rs.getInt("managerEntryNum");
                modelEmployee.setManagerEntryNum(managerEntryNum);
                return modelEmployee;

            }

        } catch (Exception e) {
            System.out.println("error getting employee");
        }

        return modelEmployee;
    }

    public modelEmployee getEmployeeAccount(String username, String userpassword) {

        modelEmployee modelEmployee = new modelEmployee();
        
        sql = "SELECT * FROM employee"
                + " WHERE employeeID = " + username;

        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String getPassword = rs.getString("password");
                
                if (getPassword != null && getPassword.equals(userpassword)) {
                    int entryNum = rs.getInt("entryNum");
                    modelEmployee.setEntryNum(entryNum);
                    int employeeID = rs.getInt("employeeID");
                    modelEmployee.setEmployeeID(employeeID);
                    String password = rs.getString("password");
                    modelEmployee.setPassword(password);
                    String lastName = rs.getString("lastName");
                    modelEmployee.setLastName(lastName);
                    String firstName = rs.getString("firstName");
                    modelEmployee.setFirstName(firstName);
                    String middleName = rs.getString("middleName");
                    modelEmployee.setMiddleName(middleName);
                    String address = rs.getString("address");
                    modelEmployee.setAddress(address);
                    Date birthday = rs.getDate("birthday");
                    modelEmployee.setBirthday(birthday);
                    String birthplace = rs.getString("birthplace");
                    modelEmployee.setBirthplace(birthplace);
                    int homePhone = rs.getInt("homePhone");
                    modelEmployee.setHomePhone(homePhone);
                    long mobileNumber = rs.getLong("mobileNumber");
                    modelEmployee.setMobileNumber(mobileNumber);
                    String SSSNumber = rs.getString("SSSNumber");
                    modelEmployee.setSSSNumber(SSSNumber);
                    String TINNumber = rs.getString("TINNumber");
                    modelEmployee.setTINNumber(TINNumber);
                    String PHICNumber = rs.getString("PHICNumber");
                    modelEmployee.setPHICNumber(PHICNumber);
                    String PAGIBIGNumber = rs.getString("PAGIBIGNumber");
                    modelEmployee.setPAGIBIGNumber(PAGIBIGNumber);
                    String civilStatus = rs.getString("civilStatus");
                    modelEmployee.setCivilStatus(civilStatus);
                    String citizenship = rs.getString("citizenship");
                    modelEmployee.setCitizenship(citizenship);
                    String religion = rs.getString("religion");
                    modelEmployee.setReligion(religion);
                    Date hireDate = rs.getDate("hireDate");
                    modelEmployee.setHireDate(hireDate);
                    String band = rs.getString("band");
                    modelEmployee.setBand(band);
                    int salary = rs.getInt("salary");
                    modelEmployee.setSalary(salary);
                    int departmentID = rs.getInt("departmentID");
                    modelEmployee.setDepartmentID(departmentID);
                    String positionName = rs.getString("positionName");
                    modelEmployee.setPositionName(positionName);
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    modelEmployee.setIsDeleted(isDeleted);
                    String emailAddress = rs.getString("emailAddress");
                    modelEmployee.setEmailAddress(emailAddress);
                    String employeeType = rs.getString("employeeType");
                    modelEmployee.setEmployeeType(employeeType);
                    int managerEntryNum = rs.getInt("managerEntryNum");
                    modelEmployee.setManagerEntryNum(managerEntryNum);

                    return modelEmployee;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // -- RELATIVE -------------------------------------------------------------
    // -- parent ---------
    public void addRelative(String name, String relation, int empEntryNum, int age, String occupation) {
        int maxRelative = 1;

        sql = "SELECT MAX(relativeID) FROM relative";

        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                maxRelative = rs.getInt("MAX(relativeID)") + 1;
            }

            sql = "INSERT INTO relative(relativeID, name, relation, empEntryNum, age, occupation)"
                    + " VALUES(" + maxRelative + ", '" + name + "', '" + relation + "', " + empEntryNum
                    + ", " + age + ", '" + occupation + "')";

            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -- spouse / emergency --------
    public void addRelative(String name, String relation, int empEntryNum, String occloc, long contactNum) {
        int maxRelative = 1;

        sql = "SELECT MAX(relativeID) FROM relative";

        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                maxRelative = rs.getInt("MAX(relativeID)") + 1;
            }

            if (relation.equals("Spouse")) {
                sql = "INSERT INTO relative(relativeID, name, relation, empEntryNum, occupation, contactNum)"
                        + " VALUES(" + maxRelative + ", '" + name + "', '" + relation + "', " + empEntryNum
                        + ", '" + occloc + "', " + contactNum + ")";
            } else {
                sql = "INSERT INTO relative(relativeID, name, relation, empEntryNum, occupationLocation, contactNum)"
                        + " VALUES(" + maxRelative + ", '" + name + "', '" + relation + "', " + empEntryNum
                        + ", '" + occloc + "', " + contactNum + ")";
            }
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -- sibling / children ------------
    public void addRelative(String name, String relation, int empEntryNum, int age, String occupation, String location) {
        int maxRelative = 1;

        sql = "SELECT MAX(relativeID) FROM relative";

        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                maxRelative = rs.getInt("MAX(relativeID)") + 1;
            }

            sql = "INSERT INTO relative(relativeID, name, relation, empEntryNum, age, occupation, occupationLocation)"
                    + " VALUES(" + maxRelative + ", '" + name + "', '" + relation + "', " + empEntryNum
                    + ", " + age + ", '" + occupation + "', '" + location + "')";

            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -- CRIMINAL OFFENSE ------------------------------------
    public void addOffense(int empEntryNum, String criminalOffense, Date dateOfOffense, String placeOfOffense) {
        int maxOffense = 1;
        sql = "SELECT MAX(criminalOffenseHistoryID) FROM criminal_offense_history";

        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                maxOffense = rs.getInt("MAX(criminalOffenseHistoryID)") + 1;
            }

            sql = "INSERT INTO criminal_offense_history"
                    + " VALUES(" + maxOffense + ", " + empEntryNum + ", '" + criminalOffense + "', '" + dateOfOffense + "', '" + placeOfOffense + "')";

            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //-- BIO DATA ---------------------------------------------------------------------------------------
    public int addInfo(int employeeID, String lastName, String firstName, String middleName, String address, Date birthDay,
            String birthplace, long mobileNumber, String SSSNumber, String TINNumber, String PHICNumber,
            String PAGIBIGNumber, String civilStatus, String citizenship, String religion,
            int salary, String emailAddress, int homePhone, String band, int departmentID, String position,
            Date hireDate, int managerID) {
        int maxEntry = 1;
        int managerEntryNum = getEntryNum(managerID);
        sql = "SELECT MAX(entryNum) FROM employee";

        try {
            Statement stmt;
            ResultSet rs;
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                maxEntry = rs.getInt("MAX(entryNum)") + 1;
            }

            sql = "INSERT INTO employee(entryNum, employeeID, lastName, firstName, middleName, address, birthDay, birthplace, mobileNumber, SSSNumber, TINNumber"
                    + ", PHICNumber, PAGIBIGNumber, civilStatus, citizenship, religion, hireDate, band, salary, departmentID, positionName, isDeleted, emailAddress, homePhone, managerEntryNum)"
                    + " VALUES(" + maxEntry + ", " + employeeID + ", '" + lastName + "', '" + firstName + "', '" + middleName + "', '" + address + "', '" + birthDay + "', '" + birthplace
                    + "', " + mobileNumber + ", '" + SSSNumber + "', '" + TINNumber + "', '" + PHICNumber + "', '" + PAGIBIGNumber + "', '" + civilStatus + "', '" + citizenship
                    + "', '" + religion + "', '" + hireDate + "', '" + band + "', " + salary + ", " + departmentID + ", '" + position + "', '0', '" + emailAddress + "', " + homePhone + ", " + managerEntryNum + ")";

            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxEntry;
    }

    //-- EDUCATION -------------------------------------------------------------------
    public void addEducation(int empEntryNum, String level, String schoolName, int schoolFromYear, int schoolToYear, String award) {
        int maxEducation = 1;

        sql = "SELECT MAX(educationHistoryID) FROM education_history";
        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                maxEducation = rs.getInt("MAX(educationHistoryID)") + 1;
            }

            sql = "INSERT INTO education_history"
                    + " VALUES(" + maxEducation + ", " + empEntryNum + ", '" + level + "', '" + schoolName + "', " + schoolFromYear
                    + ", " + schoolToYear + ", '" + award + "')";

            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //-- EMPLOYMENT -------------------------------------------------------------------
    public void addEmployment(int empEntryNum, String jobTitle, Date dateOfEmployment, int startingSalary, int endingSalary,
            String employerName, String employerAddress, long employerContactNum, String supervisorName,
            long supervisorContactNum, String reasonForLeaving) {
        int maxEmployment = 1;

        sql = "SELECT MAX(employmentHistoryID) FROM employment_history";

        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                maxEmployment = rs.getInt("MAX(employmentHistoryID)") + 1;
            }

            sql = "INSERT INTO employment_history"
                    + " VALUES(" + maxEmployment + ", " + empEntryNum + ", '" + jobTitle + "', '" + dateOfEmployment + "', " + startingSalary
                    + ", " + endingSalary + ", '" + employerName + "', '" + employerAddress + "', " + employerContactNum + ", '" + supervisorName
                    + "', " + supervisorContactNum + ", '" + reasonForLeaving + "')";

            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //-- LICENSE ----------------------------------------------------------------------
    public void addLicense(String licenseName, int empEntryNum, int percentage) {
        int maxLicense = 1;

        sql = "SELECT MAX(licenseID) FROM license";
        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                maxLicense = rs.getInt("MAX(licenseID)") + 1;
            }

            sql = "INSERT INTO license"
                    + " VALUES(" + maxLicense + ", '" + licenseName + "', " + empEntryNum + ", " + percentage + ")";

            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(int entryNum, String password) {

        sql = "UPDATE employee"
                + " SET password = '" + password + "'"
                + " WHERE entryNum = '" + entryNum + "'";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeEmployeeType(int entryNum, String type) {

        sql = "UPDATE employee"
                + " SET employeeType = '" + type + "'"
                + " WHERE entryNum = '" + entryNum + "'";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getMaxRecordID() {

        String sql = "select max(recordID) from record";
        int max = 0;
        try {
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                max = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return max;
    }
/*
    public void saveDisciplinaryFile(int id, String filename, InputStream is) {

        String sql = "INSERT INTO disciplinarymemo (memoID , file, filename) values (?, ?, ?)";

        try {

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setBlob(2, is);
            statement.setString(3, filename);
            statement.executeUpdate();
            //stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
*/
     public int saveDisciplinary(int empEntryNum, String memo, String type, InputStream is ,String filename) {

        String sql="";
        if(is == null){
            System.out.println("I am over here");
            sql = "INSERT record (recordID, recordType, empEntryNum, disciplinaryRecordType, disciplinaryComment) VALUES (?, ?, ?, ?, ?)";
        }
        

        else{
            System.out.println("I am over here333");
            sql=  "INSERT record (recordID, recordType, empEntryNum, disciplinaryRecordType, disciplinaryComment, file, filename) VALUES (?, ?, ?, ?, ?, ?, ?)";
        } 
        
        
        int max = getMaxRecordID();
        max++;

        try {

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, max);
            statement.setString(2, "memo");
            statement.setInt(3, empEntryNum);
            statement.setString(4, type);
            statement.setString(5, memo);
            
            if(is != null){
                System.out.println("ima here now hehehe");
                statement.setBlob(6, is);
                statement.setString(7, filename);
            }
            
            statement.executeUpdate();
            //stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return max;
    }

    public ArrayList<modelEmployee> getSearchResult(String search) {
        ArrayList<modelEmployee> modelEmployees = new ArrayList<>();

        String sql = "select * from employee "
                + "WHERE CONCAT(lastName,' ',firstName) LIKE '%" + search + "%'"
                + "or CONCAT(firstName,' ',lastName) LIKE '%" + search + "%'";

        try {
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                modelEmployee modelEmployee = new modelEmployee();

                int entryNum = rs.getInt("entryNum");
                modelEmployee.setEntryNum(entryNum);
                int employeeID = rs.getInt("employeeID");
                modelEmployee.setEmployeeID(employeeID);
                String password = rs.getString("password");
                modelEmployee.setPassword(password);
                String lastName = rs.getString("lastName");
                modelEmployee.setLastName(lastName);
                String firstName = rs.getString("firstName");
                modelEmployee.setFirstName(firstName);
                String middleName = rs.getString("middleName");
                modelEmployee.setMiddleName(middleName);
                String address = rs.getString("address");
                modelEmployee.setAddress(address);
                Date birthday = rs.getDate("birthday");
                modelEmployee.setBirthday(birthday);
                String birthplace = rs.getString("birthplace");
                modelEmployee.setBirthplace(birthplace);
                int homePhone = rs.getInt("homePhone");
                modelEmployee.setHomePhone(homePhone);
                long mobileNumber = rs.getLong("mobileNumber");
                modelEmployee.setMobileNumber(mobileNumber);
                String SSSNumber = rs.getString("SSSNumber");
                modelEmployee.setSSSNumber(SSSNumber);
                String TINNumber = rs.getString("TINNumber");
                modelEmployee.setTINNumber(TINNumber);
                String PHICNumber = rs.getString("PHICNumber");
                modelEmployee.setPHICNumber(PHICNumber);
                String PAGIBIGNumber = rs.getString("PAGIBIGNumber");
                modelEmployee.setPAGIBIGNumber(PAGIBIGNumber);
                String civilStatus = rs.getString("civilStatus");
                modelEmployee.setCivilStatus(civilStatus);
                String citizenship = rs.getString("citizenship");
                modelEmployee.setCitizenship(citizenship);
                String religion = rs.getString("religion");
                modelEmployee.setReligion(religion);
                Date hireDate = rs.getDate("hireDate");
                modelEmployee.setHireDate(hireDate);
                String band = rs.getString("band");
                modelEmployee.setBand(band);
                int salary = rs.getInt("salary");
                modelEmployee.setSalary(salary);
                int departmentID = rs.getInt("departmentID");
                modelEmployee.setDepartmentID(departmentID);
                String positionName = rs.getString("positionName");
                modelEmployee.setPositionName(positionName);
                boolean isDeleted = rs.getBoolean("isDeleted");
                modelEmployee.setIsDeleted(isDeleted);
                String emailAddress = rs.getString("emailAddress");
                modelEmployee.setEmailAddress(emailAddress);
                String employeeType = rs.getString("employeeType");
                modelEmployee.setEmployeeType(employeeType);
                int managerEntryNum = rs.getInt("managerEntryNum");
                modelEmployee.setManagerEntryNum(managerEntryNum);

                modelEmployees.add(modelEmployee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelEmployees;
    }

    public ArrayList<modelEmployee> getEmployeeOfManager(int managerEntryNum) {
        ArrayList<modelEmployee> modelEmployees = new ArrayList<>();

        sql = "select * from employee where managerEntryNum = " + managerEntryNum;

        try {
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                modelEmployee modelEmployee = new modelEmployee();

                int entryNum = rs.getInt("entryNum");
                modelEmployee.setEntryNum(entryNum);
                int employeeID = rs.getInt("employeeID");
                modelEmployee.setEmployeeID(employeeID);
                String password = rs.getString("password");
                modelEmployee.setPassword(password);
                String lastName = rs.getString("lastName");
                modelEmployee.setLastName(lastName);
                String firstName = rs.getString("firstName");
                modelEmployee.setFirstName(firstName);
                String middleName = rs.getString("middleName");
                modelEmployee.setMiddleName(middleName);
                String address = rs.getString("address");
                modelEmployee.setAddress(address);
                Date birthday = rs.getDate("birthday");
                modelEmployee.setBirthday(birthday);
                String birthplace = rs.getString("birthplace");
                modelEmployee.setBirthplace(birthplace);
                int homePhone = rs.getInt("homePhone");
                modelEmployee.setHomePhone(homePhone);
                long mobileNumber = rs.getLong("mobileNumber");
                modelEmployee.setMobileNumber(mobileNumber);
                String SSSNumber = rs.getString("SSSNumber");
                modelEmployee.setSSSNumber(SSSNumber);
                String TINNumber = rs.getString("TINNumber");
                modelEmployee.setTINNumber(TINNumber);
                String PHICNumber = rs.getString("PHICNumber");
                modelEmployee.setPHICNumber(PHICNumber);
                String PAGIBIGNumber = rs.getString("PAGIBIGNumber");
                modelEmployee.setPAGIBIGNumber(PAGIBIGNumber);
                String civilStatus = rs.getString("civilStatus");
                modelEmployee.setCivilStatus(civilStatus);
                String citizenship = rs.getString("citizenship");
                modelEmployee.setCitizenship(citizenship);
                String religion = rs.getString("religion");
                modelEmployee.setReligion(religion);
                Date hireDate = rs.getDate("hireDate");
                modelEmployee.setHireDate(hireDate);
                String band = rs.getString("band");
                modelEmployee.setBand(band);
                int salary = rs.getInt("salary");
                modelEmployee.setSalary(salary);
                int departmentID = rs.getInt("departmentID");
                modelEmployee.setDepartmentID(departmentID);
                String positionName = rs.getString("positionName");
                modelEmployee.setPositionName(positionName);
                boolean isDeleted = rs.getBoolean("isDeleted");
                modelEmployee.setIsDeleted(isDeleted);
                String emailAddress = rs.getString("emailAddress");
                modelEmployee.setEmailAddress(emailAddress);
                String employeeType = rs.getString("employeeType");
                modelEmployee.setEmployeeType(employeeType);
                modelEmployee.setManagerEntryNum(managerEntryNum);

                modelEmployees.add(modelEmployee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelEmployees;
    }

    // Search Suggestions
    public String getSuggestions(String word) {

        sql = "select firstName, lastName,middleName, employeeID "
                + "from employee "
                + "where firstName like '%" + word + "%' or  lastName like '%A%' or employeeID like '%" + word + "%'";

        int counter = 0;
        String people = null;
        try {

            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                people = rs.getString("firstName") + " " + rs.getString("lastName");
            }

            while (rs.next() && counter < 5) {
                people = people + "\n" + rs.getString("firstName") + " " + rs.getString("lastName");
                counter++;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return people;
    }

    //Verify Password
    public boolean isUserPassword(int id, String password) {

        String sql = "select employeeID, password  from employee where employeeID = " + id;
        boolean isPassword = false;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                if (rs.getString(2).equals(password)) {
                    isPassword = true;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return isPassword;

    }

    public ArrayList<modelDepartment> getDepartments() {
        Statement stmt;
        ResultSet rs;
        ArrayList<modelDepartment> departmentList = new ArrayList<>();
        int departmentID, branchID;
        String name; 
        
        sql = "SELECT * FROM department"
                + " GROUP BY(name);";

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                departmentID = rs.getInt("departmentID");
                name = rs.getString("name");
                branchID = rs.getInt("branchID");
                modelDepartment dept = new modelDepartment(departmentID, name, branchID);
                
                departmentList.add(dept);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return departmentList;
    }
    
    public ArrayList<modelBranch> getBranches(){
        Statement stmt;
        ResultSet rs;
        ArrayList<modelBranch> branchList = new ArrayList<>();
        int branchID;
        String name, address; 
        
        sql = "SELECT * FROM branch";

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                branchID = rs.getInt("branchID");
                name = rs.getString("name");
                address = rs.getString("address");
                modelBranch branch = new modelBranch(branchID, name, address);
                
                branchList.add(branch);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return branchList;
    }
    
    public int getDeptID(String name, int branchID){
        Statement stmt;
        ResultSet rs;
        int departmentID = 0; 
        
        sql = "SELECT departmentID FROM department"
                + " WHERE name = '" + name + "' AND branchID = " + branchID;
        
        try{
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(sql);
            
            if(rs.next())
            {
                departmentID = rs.getInt("departmentID");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return departmentID;
    }
    
    public int getBranchID(String name){
        Statement stmt;
        ResultSet rs;
        int branchID = 0; 
        
        sql = "SELECT branchID FROM branch"
                + " WHERE name = '" + name + "'";
        
        try{
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(sql);
            
            if(rs.next())
            {
                branchID = rs.getInt("branchID");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return branchID;
    }
    
    // get leave forms to be approved by a manager
    public ArrayList<modelLeaveForm> getLeaveFormToApprove(int managerEntryNum){
        ArrayList<modelLeaveForm> leaveFormsToApprove = new ArrayList<>();
        
        sql = "SELECT * from leave_form " +
              "WHERE isApproved = 'Pending' AND " + 
              "approverEntryNum = " + managerEntryNum;
        
        try{
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                modelLeaveForm leaveForm = new modelLeaveForm();
                leaveForm.setLeaveID(rs.getInt("leaveID"));
                leaveForm.setLeaveType(rs.getString("leaveType"));
                leaveForm.setEmpEntryNum(rs.getInt("empEntryNum"));
                leaveForm.setStartDate(rs.getDate("startDate"));
                leaveForm.setDuration(rs.getFloat("duration"));
                leaveForm.setIsApproved("Pending");
                leaveForm.setApproverEntryNum(managerEntryNum);
                
                leaveFormsToApprove.add(leaveForm);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return leaveFormsToApprove;
    }
    
    // get audit trails to be approved by manager
    public ArrayList<modelEmployeeAuditTrail> getAuditToApprove(){
        ArrayList<modelEmployeeAuditTrail> auditToApprove = new ArrayList<>();
        
        sql = "SELECT * from employee_audit_trail " +
              "WHERE isApproved = 'Pending'";
        
        try{
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                modelEmployeeAuditTrail audit = new modelEmployeeAuditTrail();
                
                audit.setEmpAuditTrailID(rs.getInt("empAuditTrailID"));
                audit.setFieldChanged(rs.getString("fieldChanged"));
                audit.setEditFrom(rs.getString("editFrom"));
                audit.setEditTo(rs.getString("editTo"));
                audit.setEditorEntryNum(rs.getInt("editorEntryNum"));
                audit.setEditedEntryNum(rs.getInt("editedEntryNum"));
                audit.setTimestamp(rs.getTimestamp("timestamp"));
                audit.setIsApproved("Pending");
                audit.setApproverEntryNum(0);
                
                auditToApprove.add(audit);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return auditToApprove;
    }
    
    public void changeLeaveStatus(int leaveID, String isApproved){
        sql = "UPDATE leave_form"
                + " SET isApproved = '" + isApproved + "'"
                + " WHERE leaveID = " + leaveID;

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void changeAuditStatus(int empAuditTrailID, String isApproved){
        sql = "UPDATE employee_audit_trail"
                + " SET isApproved = '" + isApproved + "'"
                + " WHERE empAuditTrailID = " + empAuditTrailID;

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public modelRelative getParent(String relation, int empEntryNum){
        Statement stmt;
        ResultSet rs;
        modelRelative parent = new modelRelative();
        sql = "SELECT * FROM relative"
                + " WHERE relation = '" + relation + "' AND empEntryNum = " + empEntryNum;
        
        try{
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(sql);
            
            if(rs.next())
            {
                parent.setRelativeID(rs.getInt("relativeID"));
                parent.setName(rs.getString("name"));
                parent.setAge(rs.getInt("age"));
                parent.setOccupation(rs.getString("occupation"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return parent;
    }
    
    public modelRelative getSpouse(int empEntryNum){
        Statement stmt;
        ResultSet rs;
        modelRelative spouse = new modelRelative();
        sql = "SELECT * FROM relative"
                + " WHERE relation = 'spouse' AND empEntryNum = " + empEntryNum;
        
        try{
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(sql);
            
            if(rs.next())
            {
                spouse.setRelativeID(rs.getInt("relativeID"));
                spouse.setName(rs.getString("name"));
                spouse.setContactNum(rs.getInt("contactNum"));
                spouse.setOccupation(rs.getString("occupation"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return spouse;
    }
    
    public ArrayList<modelRelative> getRelatives(String relation, int empEntryNum){
        Statement stmt;
        ResultSet rs;
        ArrayList<modelRelative> relativeList = new ArrayList<>();
        sql = "SELECT * FROM relative"
                + " WHERE relation = '" + relation + "' AND empEntryNum = " + empEntryNum;
        
        try{
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                modelRelative relative = new modelRelative();
                relative.setRelativeID(rs.getInt("relativeID"));
                relative.setName(rs.getString("name"));
                relative.setAge(rs.getInt("age"));
                relative.setOccupation(rs.getString("occupation"));
                relative.setOccupationLocation(rs.getString("occupationLocation"));
                relativeList.add(relative);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return relativeList;
    }
}
