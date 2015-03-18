
package models;

import java.sql.Date;

public class modelLeaveForm {
    private int leaveID;
    private String leaveType;
    private int empEntryNum;
    private Date startDate;
    private int duration;
    private boolean isApproved;
    private int approverEntryNum;

    public modelLeaveForm(int leaveID, String leaveType, int empEntryNum, Date startDate, int duration){
        this.leaveID = leaveID;
        this.leaveType = leaveType;
        this.empEntryNum = empEntryNum;
        this.startDate = startDate;
        this.duration = duration;
        isApproved = false;
        approverEntryNum = 0;
    }
    
    
    public modelLeaveForm(int leaveID, String leaveType, int empEntryNum, Date startDate, int duration, boolean isApproved, int approverEntryNum){
        this.leaveID = leaveID;
        this.leaveType = leaveType;
        this.empEntryNum = empEntryNum;
        this.startDate = startDate;
        this.duration = duration;
        this.isApproved = isApproved;
        this.approverEntryNum = approverEntryNum;
    }
    
    public int getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(int leaveID) {
        this.leaveID = leaveID;
    }

    String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public int getEmpEntryNum() {
        return empEntryNum;
    }

    public void setEmpEntryNum(int empEntryNum) {
        this.empEntryNum = empEntryNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public int getApproverEntryNum() {
        return approverEntryNum;
    }

    public void setApproverEntryNum(int approverEntryNum) {
        this.approverEntryNum = approverEntryNum;
    }
}

