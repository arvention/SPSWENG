
/*  Class Name:     modelDepartment
*   Developer:      Arren Antioquia
*   Description:    model for the department table in the database
*/  

package Models;

public class modelDepartment {
    
    private int departmentID;
    private String name;
    private int branchID;
    
    /*
    *   constructor
    */
    public modelDepartment(int departmentID, String name, int branchID)
    {
        this.departmentID = departmentID;
        this.name = name;
        this.branchID = branchID;
    }
    
    /*
    *   getter function for departmentID
    */
    public int getDepartmentID() {
        return departmentID;
    }

    /*
    *   setter function for departmentID
    */
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    /*
    *   getter function for name
    */
    public String getName() {
        return name;
    }

    /*
    *   setter function for name
    */
    public void setName(String name) {
        this.name = name;
    }

    /*
    *   getter function for branchID
    */
    public int getBranchID() {
        return branchID;
    }

    /*
    *   setter function for branchID
    */
    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }
}
