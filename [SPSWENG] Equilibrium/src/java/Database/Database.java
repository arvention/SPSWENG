package Database;

import Models.modelEmployee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void addLeaveForm(String leaveType, int empEntryNum, Date startDate, float duration) {
        int leaveID = 1;
        try {
            //get highest leaveNum
            sql = "SELECT MAX(leaveID) FROM leave_form";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                leaveID = rs.getInt("MAX(leaveID)") + 1;
            }

            //insert the leave form entry
            sql = "INSERT INTO leave_form(leaveID, leaveType, empEntryNum, startDate, duration)"
                    + " VALUES(" + leaveID + ", '" + leaveType + "', " + empEntryNum + ", '" + startDate + "', " + duration + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public modelEmployee getEmployeeAccount(String username, String userpassword) {

        sql = "SELECT * FROM employee"
                + " WHERE employeeID = " + username;

        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                if (rs.getString("password").equals(userpassword)) {
                    int entryNum = rs.getInt("entryNum");
                    int employeeID = rs.getInt("employeeID");
                    String password = rs.getString("password");
                    String lastName = rs.getString("lastName");
                    String firstName = rs.getString("firstName");
                    String middleName = rs.getString("middleName");
                    String address = rs.getString("address");
                    Date birthday = rs.getDate("birthday");
                    String birthplace = rs.getString("birthplace");
                    long mobileNumber = rs.getLong("mobileNumber");
                    String SSSNumber = rs.getString("SSSNumber");
                    String TINNumber = rs.getString("TINNumber");
                    String PHSCNumber = rs.getString("PHSCNumber");
                    String PAGIBIGNumber = rs.getString("PAGIBIGNumber");
                    String civilStatus = rs.getString("civilStatus");
                    String citizenship = rs.getString("citizenship");
                    String religion = rs.getString("religion");
                    Date hireDate = rs.getDate("hireDate");
                    String band = rs.getString("band");
                    int salary = rs.getInt("salary");
                    int departmentID = rs.getInt("departmentID");
                    int positionID = rs.getInt("positionID");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    String emailAddress = rs.getString("emailAddress");
                    String employeeType = rs.getString("EmployeeType");
                    int managerEntryNum = rs.getInt("managerEntryNum");

                    modelEmployee modelEmployee = new modelEmployee(entryNum, employeeID, lastName,
                                                                    firstName, middleName, address,
                                                                    birthday, birthplace, mobileNumber,
                                                                    SSSNumber, TINNumber, PHSCNumber,
                                                                    PAGIBIGNumber, civilStatus, citizenship,
                                                                    religion, hireDate, band, salary,
                                                                    departmentID, positionID, isDeleted,
                                                                    emailAddress, employeeType, managerEntryNum);
                    return modelEmployee;
                }else{
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
    public void addInfo(String lastName, String firstName, String middleName, String address, Date birthDay,
                            String birthplace, long mobileNumber, String SSSNumber, String TINNumber, String PHICNumber, 
                            String PAGIBIGNumber, String civilStatus, String citizenship, String religion, 
                            int salary, String emailAddress, int homePhone){
        int maxEntry = 1;
        
        sql = "SELECT MAX(entryNum) FROM employee";
        
        try{
            rs = stmt.executeQuery(sql);
            if(rs.next())
            {
                maxEntry = rs.getInt("MAX(entryNum)") + 1;
            }
            
            sql = "INSERT INTO employee(entryNum, lastName, firstName, middleName, address, birthDay, birthplace, mobileNumber, SSSNumber, TINNumber"
                    + ", PHICNumber, PAGIBIGNumber, civilStatus, citizenship, religion, salary, isDeleted, emailAddress, homePhone)"
                    + " VALUES("+ maxEntry + ", '" + lastName + "', '" + firstName + "', '" + middleName + "', '" + address + "', '" + birthDay + "', '" + birthplace + 
                    "', " + mobileNumber + ", '" + SSSNumber + "', '" + TINNumber + "', '" + PHICNumber + "', '" + PAGIBIGNumber + "', '" + civilStatus + "', '" + citizenship
                    + "', '" + religion + "', " + salary + ", '0', '" + emailAddress + "', " + homePhone + ")";
            
            stmt.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //-- EDUCATION -------------------------------------------------------------------
    public void addEducation(int empEntryNum, String level, String schoolName, int schoolFromYear, int schoolToYear, String award)
    {
        int maxEducation = 1;
        
        sql = "SELECT MAX(educationHistoryID) FROM education_history";
        try{
            rs = stmt.executeQuery(sql);
            
            if(rs.next())
            {
                maxEducation = rs.getInt("MAX(educationHistoryID)") + 1;
            }
            
            sql = "INSERT INTO education_history"
                    + " VALUES(" + maxEducation + ", " + empEntryNum + ", '" + level + "', '" + schoolName + "', " + schoolFromYear
                    + ", " + schoolToYear + ", '" + award + "')";
            
            stmt.executeUpdate(sql);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //-- EMPLOYMENT -------------------------------------------------------------------
    public void addEmployment(int empEntryNum, String jobTitle, Date dateOfEmployment, int startingSalary, int endingSalary,
                                String employerName, String employerAddress, long employerContactNum, String supervisorName,
                                long supervisorContactNum, String reasonForLeaving){
        int maxEmployment = 1;
        
        sql = "SELECT MAX(employmentHistoryID) FROM employment_history";
        
        try{
            rs = stmt.executeQuery(sql);
            
            if(rs.next())
            {
                maxEmployment = rs.getInt("MAX(employmentHistoryID)") + 1;
            }
            
            sql = "INSERT INTO employment_history"
                    + " VALUES(" + maxEmployment + ", " + empEntryNum + ", '" + jobTitle + "', '" + dateOfEmployment + "', " + startingSalary
                    + ", " + endingSalary + ", '" + employerName + "', '" + employerAddress + "', " + employerContactNum + ", '" + supervisorName
                    + "', " + supervisorContactNum + ", '" + reasonForLeaving + "')";
            
            stmt.executeUpdate(sql);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
