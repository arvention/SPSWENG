
package Models;

import java.sql.Blob;
import java.sql.Date;

public class modelRecord {
    private int recordID;
    private String recordType;
    private int empEntryNum;
    private Date date;
    private String awardName;
    private String evaluationScore;
    private int evaluatorEntryNum;
    private String disciplinaryRecordType;
    private String disciplinaryComment;
    private int disciplinaryDuration;
    private Blob file;
    private String fileName;
    private String evaluationName;
 
    public void setEvaluationName(String s){
        this.evaluationName= s;
    }
    
    public String getEvaluationName(){
        return this.evaluationName;
    }
    
    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public int getEmpEntryNum() {
        return empEntryNum;
    }

    public void setEmpEntryNum(int empEntryNum) {
        this.empEntryNum = empEntryNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(String evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public int getEvaluatorEntryNum() {
        return evaluatorEntryNum;
    }

    public void setEvaluatorEntryNum(int evaluatorEntryNum) {
        this.evaluatorEntryNum = evaluatorEntryNum;
    }

    public String getDisciplinaryRecordType() {
        return disciplinaryRecordType;
    }

    public void setDisciplinaryRecordType(String disciplinaryRecordType) {
        this.disciplinaryRecordType = disciplinaryRecordType;
    }

    public String getDisciplinaryComment() {
        return disciplinaryComment;
    }

    public void setDisciplinaryComment(String disciplinaryComment) {
        this.disciplinaryComment = disciplinaryComment;
    }

    public int getDisciplinaryDuration() {
        return disciplinaryDuration;
    }

    public void setDisciplinaryDuration(int disciplinaryDuration) {
        this.disciplinaryDuration = disciplinaryDuration;
    }

    /**
     * @return the file
     */
    public Blob getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(Blob file) {
        this.file = file;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
