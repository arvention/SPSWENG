
package Models;

import java.sql.Timestamp;

public class modelEmployeeAuditTrail {
    private int empAuditTrailID;
    private String tableName;
    private int tableReferenceNum;
    private String fieldChanged;
    private String editFrom;
    private String editTo;
    private int editorEntryNum;
    private int editedEntryNum;
    private Timestamp timestamp;
    private String isApproved;
    private int approverEntryNum;

    public int getEmpAuditTrailID() {
        return empAuditTrailID;
    }

    public void setEmpAuditTrailID(int empAuditTrailID) {
        this.empAuditTrailID = empAuditTrailID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getTableReferenceNum() {
        return tableReferenceNum;
    }

    public void setTableReferenceNum(int tableReferenceNum) {
        this.tableReferenceNum = tableReferenceNum;
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

    public String isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    public int getApproverEntryNum() {
        return approverEntryNum;
    }

    public void setApproverEntryNum(int approverEntryNum) {
        this.approverEntryNum = approverEntryNum;
    }
}
