/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

/**
 *
 * @author Thursday
 */
 public class employeeSearchResult{
        
      private  int entrynum;
      private  String firstname;
      private  String lastname;
      private  String middlename;
      private int empid;
        
        
        public employeeSearchResult(int id, String fname,String lname, String mname,int empid ){
            this.entrynum= id;
            this.firstname= fname;
            this.middlename= mname;
            this.lastname= lname;
            this.empid= empid;
        }
        
        public String getlastname(){
            return this.lastname;
        }
        
        public String getfirstname(){
            return this.firstname;
        }
        
        public String getmiddlename(){
         return this.middlename;
        }
        
        public int getempid(){
            return this.empid;
        }
        
        public int getentrynum(){
            return this.entrynum;
        }
        
        
    }
