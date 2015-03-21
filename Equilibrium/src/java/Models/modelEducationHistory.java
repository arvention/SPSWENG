
package Models;

public class modelEducationHistory {
    private int educationHistoryID;
    private int empEntryNum;
    private String level;
    private String schoolName;
    private int yearFrom;
    private int yearTo;
    private String award;

    public modelEducationHistory(int educationHistoryID, int empEntryNum, String level, 
                                String schoolName, int yearFrom, int yearTo, String award){
        this.educationHistoryID = educationHistoryID;
        this.empEntryNum = empEntryNum;
        this.level = level;
        this.schoolName = schoolName;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
        this.award = award;
    }
    
    public int getEducationHistoryID() {
        return educationHistoryID;
    }

    public void setEducationHistoryID(int educationHistoryID) {
        this.educationHistoryID = educationHistoryID;
    }

    public int getEmpEntryNum() {
        return empEntryNum;
    }

    public void setEmpEntryNum(int empEntryNum) {
        this.empEntryNum = empEntryNum;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(int yearFrom) {
        this.yearFrom = yearFrom;
    }

    public int getYearTo() {
        return yearTo;
    }

    public void setYearTo(int yearTo) {
        this.yearTo = yearTo;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
    
}
