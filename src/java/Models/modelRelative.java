
package models;

public class modelRelative {
    private String name;
    private String relation;
    private int age;
    private String occupation;
    private int empEntryNum;

    public modelRelative(String name, String relation, int age, String occupation, int empEntryNum){
        this.name = name;
        this.relation= relation;
        this.age = age;
        this.occupation = occupation;
        this.empEntryNum = empEntryNum;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getEmpEntryNum() {
        return empEntryNum;
    }

    public void setEmpEntryNum(int empEntryNum) {
        this.empEntryNum = empEntryNum;
    }
   
}
