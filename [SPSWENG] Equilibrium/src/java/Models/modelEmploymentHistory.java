
/*  Class Name:     modelEmployementHistory
*   Developer:      Arren Antioquia
*   Description:    model for the employment_history table in the database
*/ 

package Models;

import java.sql.Date;

public class modelEmploymentHistory {
    
    private int employmentHistoryID;
    private int empEntryNum;
    private String jobTitle;
    private Date dateOfEmployment;
    private int startingSalary;
    private int endingSalary;
    private String employerName;
    private String employerAddress;
    private long employerContactNum;
    private String supervisorName;
    private long supervisorContactNum;
    private String reasonForLeaving;

    /*
    *   getter function for employmentHistoryID
    */
    public int getEmploymentHistoryID() {
        return employmentHistoryID;
    }

    /*
    *   setter function for employmentHistory
    */
    public void setEmploymentHistoryID(int employmentHistoryID) {
        this.employmentHistoryID = employmentHistoryID;
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
    *   getter function for jobTitle
    */
    public String getJobTitle() {
        return jobTitle;
    }

    /*
    *   setter function for jobTitle
    */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /*
    *   getter function for dateOfEmployment
    */
    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    /*
    *   setter function for dateOfEmployment
    */
    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    /*
    *   getter function for startingSalary
    */
    public int getStartingSalary() {
        return startingSalary;
    }

    /*
    *   setter function for startingSalary
    */
    public void setStartingSalary(int startingSalary) {
        this.startingSalary = startingSalary;
    }

    /*
    *   getter function for endingSalary
    */
    public int getEndingSalary() {
        return endingSalary;
    }

    /*
    *   setter function for endingSalary
    */
    public void setEndingSalary(int endingSalary) {
        this.endingSalary = endingSalary;
    }

    /*
    *   getter function for employerName
    */
    public String getEmployerName() {
        return employerName;
    }

    /*
    *   setter function for employerName
    */
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    /*
    *   getter function for employerAddress
    */
    public String getEmployerAddress() {
        return employerAddress;
    }

    /*
    *   setter function for employerAddress
    */
    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    /*
    *   getter function for employerContactNum
    */
    public long getEmployerContactNum() {
        return employerContactNum;
    }

    /*
    *   setter function for employerContactNum
    */
    public void setEmployerContactNum(long employerContactNum) {
        this.employerContactNum = employerContactNum;
    }

    /*
    *   getter function for supervisorName
    */
    public String getSupervisorName() {
        return supervisorName;
    }

    /*
    *   setter function for supervisorName
    */
    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    /*
    *   getter function for supervisorContactNum
    */
    public long getSupervisorContactNum() {
        return supervisorContactNum;
    }

    /*
    *   setter function for supervisorContactNum
    */
    public void setSupervisorContactNum(long supervisorContactNum) {
        this.supervisorContactNum = supervisorContactNum;
    }

    /*
    *   getter function for reasonForLeaving
    */
    public String getReasonForLeaving() {
        return reasonForLeaving;
    }

    /*
    *   setter function for reasonForLeaving
    */
    public void setReasonForLeaving(String reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }
}
