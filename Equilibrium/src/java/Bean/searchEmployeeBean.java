/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AddAccountBeans;

import Bean.employeeSearchResult;
import java.util.ArrayList;

/**
 *
 * @author Thursday
 */
public class searchEmployeeBean {
    

    private employeeSearchResult selected = null;
  
    private ArrayList<employeeSearchResult> searchresult = new ArrayList<employeeSearchResult>();
    
    
    
    
    public void addResult(int id, String fname, String mname, String lname, int empid){
        searchresult.add(new employeeSearchResult(id,fname,lname,mname,empid));
    }
    
    public ArrayList<employeeSearchResult> getSearchResult(){
        return this.searchresult;
    }
    
    
    
    
}
