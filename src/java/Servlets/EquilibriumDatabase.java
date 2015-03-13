package Servlets;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
    private Connection con;
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private static EquilibriumDatabase databaseInstance = new EquilibriumDatabase();
    
    private EquilibriumDatabase(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String host = "jdbc:mysql://127.0.0.1:3306/equilibrium_spsweng?user=root";
            String uUser = "root";
            String uPass = "admin";
            
            con = DriverManager.getConnection(host, uUser, uPass);
            stmt = con.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    //get the database instance
    public static EquilibriumDatabase getInstance(){
        return databaseInstance;
    }
    
// - FUNCTIONS -------------------------------------------------------------------------------
    
    public void createAccount(){
        
    }
    
}
