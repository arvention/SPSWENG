
/*  Class Name:     modelEmployeeAuditTrail
*   Developer:      Arren Antioquia
*   Description:    model for the employee_audit_trail table in the database
*/  

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

    /*
    *   getter function for empAuditTrailID
    */
    public int getEmpAuditTrailID() {
        return empAuditTrailID;
    }

    /*
    *   setter function for empAuditTrailID
    */
    public void setEmpAuditTrailID(int empAuditTrailID) {
        this.empAuditTrailID = empAuditTrailID;
    }

    /*
    *   getter function for tableName
    */
    public String getTableName() {
        return tableName;
    }

    /*
    *   setter function for tableName
    */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /*
    *   getter function for tableReferenceNum
    */
    public int getTableReferenceNum() {
        return tableReferenceNum;
    }

    /*
    *   setter function for tableReferenceNum
    */
    public void setTableReferenceNum(int tableReferenceNum) {
        this.tableReferenceNum = tableReferenceNum;
    }
    
    /*
    *   getter function for fieldChanged
    */
    public String getFieldChanged() {
        return fieldChanged;
    }

    /*
    *   setter function for fieldChanged
    */
    public void setFieldChanged(String fieldChanged) {
        this.fieldChanged = fieldChanged;
    }

    /*
    *   getter function for editFrom
    */
    public String getEditFrom() {
        return editFrom;
    }

    /*
    *   setter function for editFrom
    */
    public void setEditFrom(String editFrom) {
        this.editFrom = editFrom;
    }

    /*
    *   getter function for editTo
    */
    public String getEditTo() {
        return editTo;
    }

    /*
    *   setter function for editTo
    */
    public void setEditTo(String editTo) {
        this.editTo = editTo;
    }

    /*
    *   getter function for editorEntryNum
    */
    public int getEditorEntryNum() {
        return editorEntryNum;
    }

    /*
    *   setter function for editorEntryNum
    */
    public void setEditorEntryNum(int editorEntryNum) {
        this.editorEntryNum = editorEntryNum;
    }

    /*
    *   getter function for editedEntryNum
    */
    public int getEditedEntryNum() {
        return editedEntryNum;
    }

    /*
    *   setter function for editedEntryNum
    */
    public void setEditedEntryNum(int editedEntryNum) {
        this.editedEntryNum = editedEntryNum;
    }

    /*
    *   getter function for timestamp
    */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /*
    *   setter function for timestamp
    */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
