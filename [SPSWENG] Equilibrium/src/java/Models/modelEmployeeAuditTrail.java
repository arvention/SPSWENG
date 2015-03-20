
package Models;

import java.sql.Timestamp;

public class modelEmployeeAuditTrail {
    private int empAuditTrailID;
    private String fieldChanged;
    private String editFrom;
    private String editTo;
    private int editorEntryNum;
    private int editedEntryNum;
    private Timestamp timestamp;
    private boolean isApproved;
    private int approverEntryNum;

    public modelEmployeeAuditTrail(int empAuditTrailID, String fieldChanged, String editFrom, String editTo,
                                    int editorEntryNum, int editedEntryNum, Timestamp timestamp){
        this.empAuditTrailID = empAuditTrailID;
        this.fieldChanged = fieldChanged;
        this.editFrom = editFrom;
        this.editTo = editTo;
        this.editorEntryNum = editorEntryNum;
        this.editedEntryNum = editedEntryNum;
        this.timestamp = timestamp;
        isApproved = false;
        approverEntryNum = 0;
    }
    
    public int getEmpAuditTrailID() {
        return empAuditTrailID;
    }

    public void setEmpAuditTrailID(int empAuditTrailID) {
        this.empAuditTrailID = empAuditTrailID;
    }

    public String getFieldChanged() {
        return fieldChanged;
    }

    public void setFieldChanged(String fieldChanged) {
        this.fieldChanged = fieldChanged;
    }

    public String getEditFrom() {
        return editFrom;
    }

    public void setEditFrom(String editFrom) {
        this.editFrom = editFrom;
    }

    public String getEditTo() {
        return editTo;
    }

    public void setEditTo(String editTo) {
        this.editTo = editTo;
    }

    public int getEditorEntryNum() {
        return editorEntryNum;
    }

    public void setEditorEntryNum(int editorEntryNum) {
        this.editorEntryNum = editorEntryNum;
    }

    public int getEditedEntryNum() {
        return editedEntryNum;
    }

    public void setEditedEntryNum(int editedEntryNum) {
        this.editedEntryNum = editedEntryNum;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
