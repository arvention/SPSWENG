
/*  Class Name:     modelLeaveForm
*   Developer:      Arren Antioquia
*   Description:    model for the leave_form table in the database
*/ 

package Models;

import java.sql.Date;

public class modelLeaveForm {
    
    private int leaveID;
    private String leaveType;
    private int empEntryNum;
    private Date startDate;
    private float duration;
    private String isApproved;
    private int approverEntryNum;

    /*
    *   getter function for leaveID
    */
    public int getLeaveID() {
        return leaveID;
    }

    /*
    *   setter function for leaveID
    */
    public void setLeaveID(int leaveID) {
        this.leaveID = leaveID;
    }

    /*
    *   getter function for leaveType
    */
    public String getLeaveType() {
        return leaveType;
    }

    /*
    *   setter function for leaveType
    */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
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
    *   getter function for startDate
    */
    public Date getStartDate() {
        return startDate;
    }

    /*
    *   setter function for startDate
    */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /*
    *   getter function for duration
    */
    public float getDuration() {
        return duration;
    }

    /*
    *   setter function for duration
    */
    public void setDuration(float duration) {
        this.duration = duration;
    }

    /*
    *   getter function for isApproved
    */
    public String isIsApproved() {
        return isApproved;
    }

    /*
    *   setter function for isApproved
    */
    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    /*
    *   getter function for approverEntryNum
    */
    public int getApproverEntryNum() {
        return approverEntryNum;
    }

    /*
    *   setter function for approverEntryNum
    */
    public void setApproverEntryNum(int approverEntryNum) {
        this.approverEntryNum = approverEntryNum;
    }
}
