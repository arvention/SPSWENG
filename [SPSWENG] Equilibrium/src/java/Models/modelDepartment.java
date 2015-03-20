
package Models;

public class modelDepartment {
    private int departmentID;
    private String name;
    private int branchID;

    public modelDepartment(int departmentID, String name, int branchID){
        this.departmentID = departmentID;
        this.name = name;
        this.branchID = branchID;
    }
    
    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }
}
