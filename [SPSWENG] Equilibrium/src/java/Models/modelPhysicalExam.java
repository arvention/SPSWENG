/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import java.sql.Date;

/**
 *
 * @author Arces
 */
public class modelPhysicalExam {
    private int physicalExamID;
    private int empEntryNum;
    private Date date;
    private String findings;
    private String remarks;

    /**
     * @return the physicalExamID
     */
    public int getPhysicalExamID() {
        return physicalExamID;
    }

    /**
     * @param physicalExamID the physicalExamID to set
     */
    public void setPhysicalExamID(int physicalExamID) {
        this.physicalExamID = physicalExamID;
    }

    /**
     * @return the empEntryNum
     */
    public int getEmpEntryNum() {
        return empEntryNum;
    }

    /**
     * @param empEntryNum the empEntryNum to set
     */
    public void setEmpEntryNum(int empEntryNum) {
        this.empEntryNum = empEntryNum;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the findings
     */
    public String getFindings() {
        return findings;
    }

    /**
     * @param findings the findings to set
     */
    public void setFindings(String findings) {
        this.findings = findings;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
