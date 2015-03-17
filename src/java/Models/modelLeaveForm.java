
package models;

import java.sql.Timestamp;

public class modelLeaveForm {
    private int leaveID;
    private String leaveType;
    private int empEntryNum;
    private Timestamp startTime;
    private Timestamp endTime;
    private boolean isApproved;
    private int approverEntryNum;

    public modelLeaveForm(int leaveID, String leaveType, int empEntryNum, Timestamp startTime, Timestamp endTime){
        this.leaveID = leaveID;
        this.leaveType = leaveType;
        this.empEntryNum = empEntryNum;
        this.startTime = startTime;
        this.endTime = endTime;
        isApproved = false;
        approverEntryNum = 0;
    }
    
    
    public modelLeaveForm(int leaveID, String leaveType, int empEntryNum, Timestamp startTime, Timestamp endTime, boolean isApproved, int approverEntryNum){
        this.leaveID = leaveID;
        this.leaveType = leaveType;
        this.empEntryNum = empEntryNum;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
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

