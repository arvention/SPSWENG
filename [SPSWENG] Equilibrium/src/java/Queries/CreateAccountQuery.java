/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Queries;

import AddAccountBeans.searchEmployeeBean;
import Database.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Thursday
 */
public class CreateAccountQuery {
    
     ResultSet rs;
     Statement stmt;
    
     
    public void savePassword(int id, String password, String type){
        
       
        
        String sql = "UPDATE employee"
                + " SET password = '" + password + "'"
                + " WHERE entryNum = '" + id + "'";
        
        
        try{
          //  stmt = EquilibriumDatabase.getConnection().createStatement();
              stmt = Database.getInstance().getConnection().createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
     
       public void saveType(int id, String type){
        
       
        String sql = "UPDATE employee"
                + " SET employeeType = '" + type + "'"
                + " WHERE entryNum = '" + id + "'";
        try{
           // stmt = EquilibriumDatabase.getConnection().createStatement();
              stmt = Database.getInstance().getConnection().createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
    
    
    
    
    public searchEmployeeBean getSearchResults(String search){
        
 
        String sql = "select entryNum , employeeID , lastName,firstName,middleName  from employee "
                + "where lastName = '"+
                search+ "'" 
                + "and password is null";
        
        searchEmployeeBean bean = new searchEmployeeBean();
        
        
        
        try{
         //   stmt = EquilibriumDatabase.getConnection().createStatement();
              stmt = Database.getInstance().getConnection().createStatement();
            rs = stmt.executeQuery(sql);
          
            while(rs.next()){
               //fname mname
                System.out.println(rs.getInt(1)+" HOHOHO");
                bean.addResult( rs.getInt(1) , rs.getString(4) ,rs.getString(5) , rs.getString(3),rs.getInt(2));
                
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        
        
        return bean;
    }
    
    
    
    
    
    
    
    
}
