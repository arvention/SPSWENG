
/*  Class Name:     modelBranch
*   Developer:      Arren Antioquia
*   Description:    Objects that can be downloaded through the system.
*/  

package Models;

public class modelBranch {
    
    private int branchID;
    private String name;
    private String address;
    
    /*
    *   constructor with no parameter
    */
    public modelBranch(int branchID, String name, String address){
        this.branchID = branchID;
        this.name = name;
        this.address = address;
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
    *   getter function for address
    */
    public String getAddress() {
        return address;
    }

    /*
    *   setter function for address
    */
    public void setAddress(String address) {
        this.address = address;
    }
    
}
