
package Models;

import java.sql.Date;

public class modelRecord {
    private int recordID;
    private String recordType;
    private int empEntryNum;
    private Date date;
    private String awardName;
    private int evaluationScore;
    private int evaluatorEntryNum;
    private String disciplinaryRecordType;
    private String disciplinaryComment;
    private int disciplinaryDuration;

    public modelRecord(int recordID, String recordType, int empEntryNum, Date date){
        this.recordID = recordID;
        this.recordType = recordType;
        this.empEntryNum = empEntryNum;
        this.date = date;
        this.awardName = "";
        this.evaluationScore = 0;
        this.evaluatorEntryNum = 0;
        this.disciplinaryRecordType = "";
        this.disciplinaryComment = "";
        this.disciplinaryDuration = 0;
    }
    
    public modelRecord(int recordID, String recordType, int empEntryNum, Date date,
                    String awardName){
        this.recordID = recordID;
        this.recordType = recordType;
        this.empEntryNum = empEntryNum;
        this.date = date;
        this.awardName = awardName;
        this.evaluationScore = 0;
        this.evaluatorEntryNum = 0;
        this.disciplinaryRecordType = "";
        this.disciplinaryComment = "";
        this.disciplinaryDuration = 0;
    }
    
    public modelRecord(int recordID, String recordType, int empEntryNum, Date date,
                    int evaluationScore, int evaluatorEntryNum){
        this.recordID = recordID;
        this.recordType = recordType;
        this.empEntryNum = empEntryNum;
        this.date = date;
        this.awardName = "";
        this.evaluationScore = evaluationScore;
        this.evaluatorEntryNum = evaluatorEntryNum;
        this.disciplinaryRecordType = "";
        this.disciplinaryComment = "";
        this.disciplinaryDuration = 0;
    }
    
    public modelRecord(int recordID, String recordType, int empEntryNum, Date date,
                        String disciplinaryRecordType, String disciplinaryComment,
                        int disciplinaryDuration){
        this.recordID = recordID;
        this.recordType = recordType;
        this.empEntryNum = empEntryNum;
        this.date = date;
        this.awardName = "";
        this.evaluationScore = 0;
        this.evaluatorEntryNum = 0;
        this.disciplinaryRecordType = disciplinaryRecordType;
        this.disciplinaryComment = disciplinaryComment;
        this.disciplinaryDuration = disciplinaryDuration;
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

    public int getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(int evaluationScore) {
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
}
