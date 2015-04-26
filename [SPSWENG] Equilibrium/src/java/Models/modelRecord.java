
/*  Class Name:     modelBranch
*   Developer:      Arren Antioquia
*   Description:    model for the branch table in the database
*/  

package Models;

import java.sql.Blob;
import java.sql.Date;

public class modelRecord {
    
    private int recordID;
    private String recordType;
    private int empEntryNum;
    private Date date;
    private String awardName;
    private String awardComment;
    private String evaluationScore;
    private String evaluationName;
    private String disciplinaryRecordType;
    private String disciplinaryComment;
    private int disciplinaryDuration;
    private Blob file;
    private String fileName;

    /*
    *   getter function for recordID
    */
    public int getRecordID() {
        return recordID;
    }

    /*
    *   setter function for recordID
    */
    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    /*
    *   getter function for recordType
    */
    public String getRecordType() {
        return recordType;
    }

    /*
    *   setter function for recordType
    */
    public void setRecordType(String recordType) {
        this.recordType = recordType;
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
    *   getter function for Date
    */
    public Date getDate() {
        return date;
    }

    /*
    *   setter function for Date
    */
    public void setDate(Date date) {
        this.date = date;
    }

    /*
    *   getter function for awardName
    */
    public String getAwardName() {
        return awardName;
    }

    /*
    *   setter function for awardName
    */
    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    /*
    *   getter function for awardComment
    */
    public String getAwardComment() {
        return awardComment;
    }

    /*
    *   setter function for awardComment
    */
    public void setAwardComment(String awardComment) {
        this.awardComment = awardComment;
    }

    /*
    *   getter function for evaluationScore
    */
    public String getEvaluationScore() {
        return evaluationScore;
    }

    /*
    *   setter function for evaluationScore
    */
    public void setEvaluationScore(String evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    /*
    *   getter function for evaluationName
    */
    public String getEvaluationName() {
        return evaluationName;
    }

    /*
    *   setter function for evaluationName
    */
    public void setEvaluationName(String evaluationName) {
        this.evaluationName = evaluationName;
    }

    /*
    *   getter function for disciplinaryRecordType
    */
    public String getDisciplinaryRecordType() {
        return disciplinaryRecordType;
    }

    /*
    *   setter function for disciplinaryRecordType
    */
    public void setDisciplinaryRecordType(String disciplinaryRecordType) {
        this.disciplinaryRecordType = disciplinaryRecordType;
    }

    /*
    *   getter function for disciplinaryComment
    */
    public String getDisciplinaryComment() {
        return disciplinaryComment;
    }

    /*
    *   setter function for disciplinaryComment
    */
    public void setDisciplinaryComment(String disciplinaryComment) {
        this.disciplinaryComment = disciplinaryComment;
    }

    /*
    *   getter function for disciplinaryDuration
    */
    public int getDisciplinaryDuration() {
        return disciplinaryDuration;
    }

    /*
    *   setter function for disciplinaryDuration
    */
    public void setDisciplinaryDuration(int disciplinaryDuration) {
        this.disciplinaryDuration = disciplinaryDuration;
    }

    /*
    *   getter function for file
    */
    public Blob getFile() {
        return file;
    }

    /*
    *   getter function for file
    */
    public void setFile(Blob file) {
        this.file = file;
    }

    /*
    *   getter function for fileName
    */
    public String getFileName() {
        return fileName;
    }

    /*
    *   setter function for fileName
    */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
