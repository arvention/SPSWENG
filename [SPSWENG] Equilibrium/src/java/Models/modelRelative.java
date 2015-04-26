
/*  Class Name:     modelRelative
*   Developer:      Arren Antioquia
*   Description:    model for the relative table in the database
*/ 

package Models;

public class modelRelative {
    
    private int relativeID;
    private String name;
    private String relation;
    private int empEntryNum;
    private int age;
    private String occupation;
    private String occupationLocation;
    private long contactNum;
    
    /*
    *   constructor
    */
    public modelRelative(){
        this.name = "";
        this.relation = "";
        this.age = 0;
        this.occupation = "";
        this.occupationLocation = "";
    }
    
    /*
    *   getter function for relativeID
    */
    public int getRelativeID() {
        return relativeID;
    }

    /*
    *   setter function for relativeID
    */
    public void setRelativeID(int relativeID) {
        this.relativeID = relativeID;
    }

    /*
    *   getter function for name
    */
    public String getName() {
        return name;
    }

    /*
    *   setter function for name
    */
    public void setName(String name) {
        this.name = name;
    }

    /*
    *   getter function for relation
    */
    public String getRelation() {
        return relation;
    }

    /*
    *   setter function for relation
    */
    public void setRelation(String relation) {
        this.relation = relation;
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
    *   getter function for age
    */
    public int getAge() {
        return age;
    }

    /*
    *   setter function for age
    */
    public void setAge(int age) {
        this.age = age;
    }

    /*
    *   getter function for occupation
    */
    public String getOccupation() {
        return occupation;
    }

    /*
    *   setter function for occupation
    */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /*
    *   getter function for occupationLocation
    */
    public String getOccupationLocation() {
        return occupationLocation;
    }

    /*
    *   setter function for occupationLocation
    */
    public void setOccupationLocation(String occupationLocation) {
        this.occupationLocation = occupationLocation;
    }

    /*
    *   getter function for contactNum
    */
    public long getContactNum() {
        return contactNum;
    }

    /*
    *   setter function for contactNum
    */
    public void setContactNum(long contactNum) {
        this.contactNum = contactNum;
    }
}
