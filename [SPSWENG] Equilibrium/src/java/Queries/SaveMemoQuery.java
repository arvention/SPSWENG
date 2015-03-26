/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Queries;

import Bean.searchEmployeeBean;
import Database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thursday
 */
public class SaveMemoQuery {
    
    private   ResultSet rs;
    private   Statement stmt;
    
    public searchEmployeeBean GetAllEmployeeManager(int manid){
        
       String sql=  "select entrynum, employeeID, lastName, firstName,middleName"
               + " from employee where managerEntryNum = "+ manid;
       
       searchEmployeeBean bean = new searchEmployeeBean();
      
        try{
            //stmt = EquilibriumDatabase.getConnection().createStatement();
            stmt = Database.getInstance().getConnection().createStatement();
            rs = stmt.executeQuery(sql);  
            while(rs.next()){
                System.out.println("RESULT IS FOUND!!!");
                bean.addResult( rs.getInt(1) , rs.getString(4) ,rs.getString(5) , rs.getString(3),rs.getInt(2));
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return bean;
    }
    
    
    public void SaveDisciplinary(int id, String memo){
        
       String sql = "INSERT INTO record(recordType,empEntryNum, disciplinaryComment) "
               + "VALUES ( 'memo', '"+ id+" ', '"+memo +"')";
       
        try{
            //stmt = EquilibriumDatabase.getConnection().createStatement();
              stmt = Database.getInstance().getConnection().createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
       
       
        
    }
    
    public String getEmail(int id){
        String result=null;
        String sql ="select employeeID, emailAddress  from employee where employeeID="+ id;
         try{
          //  stmt = EquilibriumDatabase.getConnection().createStatement();
               stmt = Database.getInstance().getConnection().createStatement();
            rs = stmt.executeQuery(sql);  
            rs.next();
            result = rs.getString(2);
            
            
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    
    
}
