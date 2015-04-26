
/*  Class Name:     modelEducationHistory
*   Developer:      Arren Antioquia
*   Description:    model for the educationHistory table in the database
*/  

package Models;

public class modelEducationHistory {
    
    private int educationHistoryID;
    private int empEntryNum;
    private String level;
    private String schoolName;
    private int yearFrom;
    private int yearTo;
    private String award;
    
    /*
    *   getter function for educationHistoryID
    */
    public int getEducationHistoryID() {
        return educationHistoryID;
    }

    /*
    *   setter function for educationHistoryID
    */
    public void setEducationHistoryID(int educationHistoryID) {
        this.educationHistoryID = educationHistoryID;
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
    *   getter function for level
    */
    public String getLevel() {
        return level;
    }

    /*
    *   setter function for level
    */
    public void setLevel(String level) {
        this.level = level;
    }

    /*
    *   getter function for schoolName
    */
    public String getSchoolName() {
        return schoolName;
    }

    /*
    *   setter function for schoolName
    */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /*
    *   getter function for yearFrom
    */
    public int getYearFrom() {
        return yearFrom;
    }

    /*
    *   setter function for yearFrom
    */
    public void setYearFrom(int yearFrom) {
        this.yearFrom = yearFrom;
    }

    /*
    *   getter function for yearTo
    */
    public int getYearTo() {
        return yearTo;
    }

    /*
    *   setter function for yearTo
    */
    public void setYearTo(int yearTo) {
        this.yearTo = yearTo;
    }

    /*
    *   getter function for award
    */
    public String getAward() {
        return award;
    }

    /*
    *   setter function for award
    */
    public void setAward(String award) {
        this.award = award;
    }
}
