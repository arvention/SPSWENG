
/*  Class Name:     modelCriminalOffenseHistory
*   Developer:      Arren Antioquia
*   Description:    model for the criminalOffenseHistory table in the database
*/ 

package Models;

import java.sql.Date;

public class modelCriminalOffenseHistory {
    
    private int criminalOffenseHistoryID;
    private int empEntryNum;
    private String criminalOffense;
    private Date dateOfOffense;
    private String placeOfOffense;
    
    /*
    *   getter function for criminalOffenseHistoryID
    */
    public int getCriminalOffenseHistoryID() {
        return criminalOffenseHistoryID;
    }
    
    /*
    *   setter function for criminalOffenseHistoryID
    */
    public void setCriminalOffenseHistoryID(int criminalOffenseHistoryID) {
        this.criminalOffenseHistoryID = criminalOffenseHistoryID;
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
    *   getter function for criminalOffense
    */
    public String getCriminalOffense() {
        return criminalOffense;
    }

    /*
    *   setter function for criminalOffense
    */
    public void setCriminalOffense(String criminalOffense) {
        this.criminalOffense = criminalOffense;
    }

    /*
    *   getter function for dateOfOffense
    */
    public Date getDateOfOffense() {
        return dateOfOffense;
    }

    /*
    *   setter function for dateOfOffense
    */
    public void setDateOfOffense(Date dateOfOffense) {
        this.dateOfOffense = dateOfOffense;
    }

    /*
    *   getter function for placeOfOffense
    */
    public String getPlaceOfOffense() {
        return placeOfOffense;
    }

    /*
    *   setter function for placeOfOffense
    */
    public void setPlaceOfOffense(String placeOfOffense) {
        this.placeOfOffense = placeOfOffense;
    }
}
