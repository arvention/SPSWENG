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
        }
    }

    public static Database getInstance() {
        return databaseInstance;
    }

// - FUNCTIONS -------------------------------------------------------------------------------
    public int getManager(int entryNum) {
        int manEntryNum = -1;
        
        try {
            sql = "SELECT E2.entryNum FROM employee E1, employee E2"
                    + " WHERE E1.entryNum = " + entryNum + " AND E1.managerEntryNum = E2.entryNum";
            rs = stmt.executeQuery(sql);

            if(rs.next())
                manEntryNum = rs.getInt("entryNum");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // -- if returned is -1, manager is not found
        return manEntryNum;
    }
    
    public String getFirstName(int entryNum){
        String firstName = "";

        try {
            sql = "SELECT firstName FROM employee"
                    + " WHERE entryNum = " + entryNum;
            rs = stmt.executeQuery(sql);
            
            if(rs.next())
                firstName = rs.getString("firstName");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return firstName;
    }
    
    public String getLastName(int entryNum){
        String lastName = "";

        try {
            sql = "SELECT lastName FROM employee"
                    + " WHERE entryNum = " + entryNum;
            rs = stmt.executeQuery(sql);
            
            if(rs.next())
                lastName = rs.getString("lastName");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastName;
    }
    
    public int getIDNumber(int entryNum){
        int empID = 0;

        try {
            sql = "SELECT employeeID FROM employee"
                    + " WHERE entryNum = " + entryNum;
            rs = stmt.executeQuery(sql);
            
            if(rs.next())
                empID = rs.getInt("employeeID");
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
            
            if(rs.next())
            {
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
    
    public int getEntryNum(int empID){
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
    
    public modelEmployee getEmployeeAccount(String username, String userpassword){
        
        sql = "SELECT * FROM employee" 
            + " WHERE employeeID = " + username + " AND password = " + userpassword + ";";

        try {
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
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
                                                                firstName, middleName,address, 
                                                                birthday, birthplace, mobileNumber, 
                                                                SSSNumber, TINNumber, PHSCNumber, 
                                                                PAGIBIGNumber, civilStatus, citizenship, 
                                                                religion, hireDate, band, salary,
                                                                departmentID, positionID, isDeleted, 
                                                                emailAddress, employeeType, managerEntryNum);
                return modelEmployee;                                             
            }
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
