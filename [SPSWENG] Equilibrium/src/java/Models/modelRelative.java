
package Models;

public class modelRelative {
    private int relativeID;
    private String name;
    private String relation;
    private int empEntryNum;
    private int age;
    private String occupation;

    public modelRelative(int relativeID, String name, String relation,
                        int empEntryNum, int age, String occupation){
        this.relativeID = relativeID;
        this.name = name;
        this.relation = relation;
        this.empEntryNum = empEntryNum;
        this.age = age;
        this.occupation = occupation;
    }
    
    public int getRelativeID() {
        return relativeID;
    }

    public void setRelativeID(int relativeID) {
        this.relativeID = relativeID;
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

    public int getEmpEntryNum() {
        return empEntryNum;
    }

    public void setEmpEntryNum(int empEntryNum) {
        this.empEntryNum = empEntryNum;
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
}
