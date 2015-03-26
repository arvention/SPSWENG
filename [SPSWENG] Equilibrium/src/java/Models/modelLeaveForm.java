
package Models;

import java.sql.Date;

public class modelLeaveForm {
    private int leaveID;
    private String leaveType;
    private int empEntryNum;
    private Date startDate;
    private float duration;
    private boolean isApproved;
    private int approverEntryNum;

    public int getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(int leaveID) {
        this.leaveID = leaveID;
    }

    public String getLeaveType() {
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

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
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
