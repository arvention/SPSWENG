
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

    public modelEmploymentHistory(int employmentHistoryID, int empEntryNum, String jobTitle, Date dateOfEmployment,
                                int startingSalary, int endingSalary, String employerName, String employerAddress,
                                long employerContactNum, String supervisorName, long supervisorContactNum, 
                                String reasonForLeaving){
        this.employmentHistoryID = employmentHistoryID;
        this.empEntryNum = empEntryNum;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
        this.startingSalary = startingSalary;
        this.endingSalary = endingSalary;
        this.employerName = employerName;
        this.employerAddress = employerAddress;
        this.employerContactNum = employerContactNum;
        this.supervisorName = supervisorName;
        this.supervisorContactNum = supervisorContactNum;
        this.reasonForLeaving = reasonForLeaving;
    }
    
    public int getEmploymentHistoryID() {
        return employmentHistoryID;
    }

    public void setEmploymentHistoryID(int employmentHistoryID) {
        this.employmentHistoryID = employmentHistoryID;
    }

    public int getEmpEntryNum() {
        return empEntryNum;
    }

    public void setEmpEntryNum(int empEntryNum) {
        this.empEntryNum = empEntryNum;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public int getStartingSalary() {
        return startingSalary;
    }

    public void setStartingSalary(int startingSalary) {
        this.startingSalary = startingSalary;
    }

    public int getEndingSalary() {
        return endingSalary;
    }

    public void setEndingSalary(int endingSalary) {
        this.endingSalary = endingSalary;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public long getEmployerContactNum() {
        return employerContactNum;
    }

    public void setEmployerContactNum(long employerContactNum) {
        this.employerContactNum = employerContactNum;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public long getSupervisorContactNum() {
        return supervisorContactNum;
    }

    public void setSupervisorContactNum(long supervisorContactNum) {
        this.supervisorContactNum = supervisorContactNum;
    }

    public String getReasonForLeaving() {
        return reasonForLeaving;
    }

    public void setReasonForLeaving(String reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }
    
}
