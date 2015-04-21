package Models;


public class modelBranch {
    private int branchID;
    private String name;
    private String address;
    
    public modelBranch(int branchID, String name, String address){
        this.branchID = branchID;
        this.name = name;
        this.address = address;
    }
    
    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
