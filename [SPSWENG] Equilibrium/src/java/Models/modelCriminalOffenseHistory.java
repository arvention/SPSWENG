
package Models;

import java.sql.Date;

public class modelCriminalOffenseHistory {
    private int criminalOffenseHistoryID;
    private int empEntryNum;
    private String criminalOffense;
    private Date dateOfOffense;
    private String placeOfOffense;
    
    public int getCriminalOffenseHistoryID() {
        return criminalOffenseHistoryID;
    }

    public void setCriminalOffenseHistoryID(int criminalOffenseHistoryID) {
        this.criminalOffenseHistoryID = criminalOffenseHistoryID;
    }

    public int getEmpEntryNum() {
        return empEntryNum;
    }

    public void setEmpEntryNum(int empEntryNum) {
        this.empEntryNum = empEntryNum;
    }

    public String getCriminalOffense() {
        return criminalOffense;
    }

    public void setCriminalOffense(String criminalOffense) {
        this.criminalOffense = criminalOffense;
    }

    public Date getDateOfOffense() {
        return dateOfOffense;
    }

    public void setDateOfOffense(Date dateOfOffense) {
        this.dateOfOffense = dateOfOffense;
    }

    public String getPlaceOfOffense() {
        return placeOfOffense;
    }

    public void setPlaceOfOffense(String placeOfOffense) {
        this.placeOfOffense = placeOfOffense;
    }
}
