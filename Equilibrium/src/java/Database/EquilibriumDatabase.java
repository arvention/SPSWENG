package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arces
 */
public class EquilibriumDatabase {
  
     
    public static EquilibriumDatabase DB = new EquilibriumDatabase();
    public static Connection conn;
    private static final String table = new String("jdbc:mysql://localhost:3306/equilibrium_spsweng");
    private static final String user = new String("root");
    private static final String password = new String("jetisjet");
    
    
    public EquilibriumDatabase(){
        try {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
        }catch (Exception ex) {
            System.out.println("Error");
        }
        
        try {
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/equilibrium_spsweng" ,"root" ,  "jetisjet");
        } catch (SQLException e) {
            System.out.println(" HERE!!! You have an error  "+ e);
        }
    }
   
    public static Connection getConnection(){
        return conn;
    }
    
    public static EquilibriumDatabase getDB(){
        return DB;
    }
    
    
    public static void closeConnection(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("You have an error  "+ ex);
        }
        
    }
    
        public static void openConnection(){
        try {
           
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(table,user, password);
            
        } catch (SQLException ex) {
            System.out.println("You have an error  "+ ex);
        }
        
    }
     
}
