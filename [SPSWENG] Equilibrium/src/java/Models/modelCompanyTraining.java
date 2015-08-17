
/*  Class Name:     modelCompanyTraining
*   Developer:      Hannah Sibayan
*   Description:    model for the companyTraining table in the database
*/ 

package Models;

import java.sql.Date;

public class modelCompanyTraining {
    
    private int companyTrainingID;
    private int empEntryNum;
    private Date date;
    private String trainingName;
    private String trainingVenue;
    
    /*
    *   getter function for companyTrainingID
    */
    public int getCompanyTrainingID() {
        return companyTrainingID;
    }
    
    /*
    *   setter function for companyTrainingID
    */
    public void setCompanyTrainingID(int companyTrainingID) {
        this.companyTrainingID = companyTrainingID;
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
    *   getter function for date
    */
    public Date getDate() {
        return date;
    }
    
    /*
    *   setter function for date
    */
    public void setDate(Date date) {
        this.date = date;
    }

    /*
    *   getter function for trainingName
    */
    public String getTrainingName() {
        return trainingName;
    }

    /*
    *   setter function for trainingName
    */
    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    /*
    *   getter function for trainingVenue
    */
    public String getTrainingVenue() {
        return trainingVenue;
    }

    /*
    *   setter function for trainingVenue
    */
    public void setTrainingVenue(String trainingVenue) {
        this.trainingVenue = trainingVenue;
    }
    
}
