/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

/**
 *
 * @author Arces
 */
public class modelIllness {
    private int illnessID;
    private int empEntryNum;
    private String illnessName;
    private int age;

    /**
     * @return the illnessID
     */
    public int getIllnessID() {
        return illnessID;
    }

    /**
     * @param illnessID the illnessID to set
     */
    public void setIllnessID(int illnessID) {
        this.illnessID = illnessID;
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
     * @return the illnessName
     */
    public String getIllnessName() {
        return illnessName;
    }

    /**
     * @param illnessName the illnessName to set
     */
    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
