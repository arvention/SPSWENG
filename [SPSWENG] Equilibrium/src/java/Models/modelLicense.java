
package Models;

public class modelLicense {
    private int licenseID;
    private String licenseName;
    private int empEntryNum;
    private int percantage;

    public int getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(int licenseID) {
        this.licenseID = licenseID;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    public int getEmpEntryNum() {
        return empEntryNum;
    }

    public void setEmpEntryNum(int empEntryNum) {
        this.empEntryNum = empEntryNum;
    }

    public int getPercantage() {
        return percantage;
    }

    public void setPercantage(int percantage) {
        this.percantage = percantage;
    }
}
