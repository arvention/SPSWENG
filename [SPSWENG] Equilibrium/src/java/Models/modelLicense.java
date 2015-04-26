
/*  Class Name:     modelLicense
*   Developer:      Arren Antioquia
*   Description:    model for the license table in the database
*/ 

package Models;

public class modelLicense {
    
    private int licenseID;
    private String licenseName;
    private int empEntryNum;
    private int percentage;

    /*
    *   getter function for licenseID
    */
    public int getLicenseID() {
        return licenseID;
    }

    /*
    *   setter function for licenseID
    */
    public void setLicenseID(int licenseID) {
        this.licenseID = licenseID;
    }

    /*
    *   getter function for licenseName
    */
    public String getLicenseName() {
        return licenseName;
    }

    /*
    *   setter function for licenseName
    */
    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    /*
    *   getter function for empEntryNum
    */
    public int getEmpEntryNum() {
        return empEntryNum;
    }

    /*
    *   setter function for empEntryNum
    */
    public void setEmpEntryNum(int empEntryNum) {
        this.empEntryNum = empEntryNum;
    }

    /*
    *   getter function for percentage
    */
    public int getPercentage() {
        return percentage;
    }

    /*
    *   setter function for percentage
    */
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
