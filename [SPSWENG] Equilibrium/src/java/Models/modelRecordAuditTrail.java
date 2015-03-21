
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

    public modelRecordAuditTrail(int recAuditTrailID, int recordID, int editorEntryNum,
                                int editedEntryNum, Timestamp timestamp){
        this.recAuditTrailID = recAuditTrailID;
        this.recordID = recordID;
        this.editorEntryNum = editorEntryNum;
        this.editedEntryNum = editedEntryNum;
        this.timestamp = timestamp;
        this.isApproved = false;
        this.approverEntryNum = 0;
    }
    
    public modelRecordAuditTrail(int recAuditTrailID, int recordID, int editorEntryNum,
                                int editedEntryNum, Timestamp timestamp, boolean isApproved,
                                int approverEntryNum){
        this.recAuditTrailID = recAuditTrailID;
        this.recordID = recordID;
        this.editorEntryNum = editorEntryNum;
        this.editedEntryNum = editedEntryNum;
        this.timestamp = timestamp;
        this.isApproved = isApproved;
        this.approverEntryNum = approverEntryNum;
    }
    
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
