
package Models;

import java.sql.Timestamp;

public class modelRecordAuditTrail {
    private int recAuditTrailID;
    private int recordID;
    private int editorEntryNum;
    private int editedEntryNum;
    private Timestamp timestamp;
    private boolean isApproved;
    private int approverEntryNum;

    public int getRecAuditTrailID() {
        return recAuditTrailID;
    }

    public void setRecAuditTrailID(int recAuditTrailID) {
        this.recAuditTrailID = recAuditTrailID;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
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
