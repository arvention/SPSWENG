package database;

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
    
    private Database(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String host = "jdbc:mysql://127.0.0.1:3306/equilibrium_spsweng?user=root";
            String uUser = "root";
            String uPass = "password";
            
            con = DriverManager.getConnection(host, uUser, uPass);
            stmt = con.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static Database getInstance(){
        return databaseInstance;
    }
    
    
// - FUNCTIONS -------------------------------------------------------------------------------
    public int getManager(int idNumber) {
        int managerID = -1;

        try {
            sql = "SELECT managerID FROM employee"
                    + " WHERE idNumber = " + idNumber;
            rs = stmt.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // -- if returned is -1, manager is not found
        return managerID;
    }

    public String getEmailAddress(int idNumber) {
        String emailAddress = "";

        try {
            sql = "SELECT emailAddress FROM employee"
                    + " WHERE idNumber = " + idNumber;
            rs = stmt.executeQuery(sql);
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
            
            if(rs.next())
               leaveID = rs.getInt("MAX(leaveID)") + 1;
                
            //insert the leave form entry
            sql = "INSERT INTO leave_form(leaveID, leaveType, empEntryNum, startDate, duration)"
                    + " VALUES(" + leaveID + ", '" + leaveType + "', " + empEntryNum + ", '" + startDate + "', " + duration + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
