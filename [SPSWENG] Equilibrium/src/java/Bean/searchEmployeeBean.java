/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;


import java.util.ArrayList;

/**
 *
 * @author Thursday
 */
public class searchEmployeeBean {
    

    private EmployeeBean selected = null;
    private ArrayList<EmployeeBean> searchresult = new ArrayList<EmployeeBean>();
    
    
    public void addResult(int id, String fname, String mname, String lname, int empid){
        searchresult.add(new EmployeeBean(id,fname,lname,mname,empid));
    }
    
    public ArrayList<EmployeeBean> getSearchResult(){
        return this.searchresult;
    }
    
   
}
