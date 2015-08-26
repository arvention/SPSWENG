
/*  Class Name:     modelEmployee
*   Developer:      Arren Antioquia
*   Description:    model for the employee table in the database
*/  

package Models;

import java.sql.Date;

public class modelEmployee {
    
    private int entryNum;
    private int employeeID;
    private String password;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private Date birthday;
    private String birthplace;
    private int homePhone;
    private Long mobileNumber;
    private String SSSNumber;
    private String TINNumber;
    private String PHICNumber;
    private String PAGIBIGNumber;
    private String civilStatus;
    private String citizenship;
    private String religion;
    private Date hireDate;
    private String band;
    private int salary;
    private int departmentID;
    private String positionName;
    private boolean isDeleted;
    private String emailAddress;
    private String employeeType;
    private int managerEntryNum;
    private String bloodType;
    
    /*
    *   getter function for entryNum
    */
    public int getEntryNum() {
        return entryNum;
    }

    /*
    *   setter function for entryNum
    */
    public void setEntryNum(int entryNum) {
        this.entryNum = entryNum;
    }

    /*
    *   getter function for employeeID
    */
    public int getEmployeeID() {
        return employeeID;
    }

    /*
    *   setter function for employeeID
    */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /*
    *   getter function for password
    */
    public String getPassword() {
        return password;
    }

    /*
    *   setter function for password
    */
    public void setPassword(String password) {
        this.password = password;
    }

    /*
    *   getter function for lastName
    */
    public String getLastName() {
        return lastName;
    }

    /*
    *   setter function for lastName
    */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
    *   getter function for firstName
    */
    public String getFirstName() {
        return firstName;
    }

    /*
    *   setter function for firstName
    */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /*
    *   getter function for middleName
    */
    public String getMiddleName() {
        return middleName;
    }

    /*
    *   setter function for middleName
    */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /*
    *   getter function for address
    */
    public String getAddress() {
        return address;
    }

    /*
    *   setter function for address
    */
    public void setAddress(String address) {
        this.address = address;
    }

    /*
    *   getter function for birthday
    */
    public Date getBirthday() {
        return birthday;
    }

    /*
    *   setter function for birthday
    */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /*
    *   getter function for birthplace
    */
    public String getBirthplace() {
        return birthplace;
    }

    /*
    *   setter function for birthplace
    */
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    /*
    *   getter function for homePhone
    */
    public int getHomePhone() {
        return homePhone;
    }

    /*
    *   setter function for homePhone
    */
    public void setHomePhone(int homePhone) {
        this.homePhone = homePhone;
    }

    /*
    *   getter function for mobileNumber
    */
    public Long getMobileNumber() {
        return mobileNumber;
    }

    /*
    *   setter function for mobileNumber
    */
    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /*
    *   getter function for SSSNumber
    */
    public String getSSSNumber() {
        return SSSNumber;
    }

    /*
    *   setter function for SSSNumber
    */
    public void setSSSNumber(String SSSNumber) {
        this.SSSNumber = SSSNumber;
    }

    /*
    *   getter function for TINNumber
    */
    public String getTINNumber() {
        return TINNumber;
    }

    /*
    *   setter function for TINNumber
    */
    public void setTINNumber(String TINNumber) {
        this.TINNumber = TINNumber;
    }

    /*
    *   getter function for PHICNumber
    */
    public String getPHICNumber() {
        return PHICNumber;
    }

    /*
    *   setter function for PHICNumber
    */
    public void setPHICNumber(String PHICNumber) {
        this.PHICNumber = PHICNumber;
    }

    /*
    *   getter function for PAGIBIGNumber
    */
    public String getPAGIBIGNumber() {
        return PAGIBIGNumber;
    }

    /*
    *   setter function for PAGIBIGNumber
    */
    public void setPAGIBIGNumber(String PAGIBIGNumber) {
        this.PAGIBIGNumber = PAGIBIGNumber;
    }

    /*
    *   getter function for civilStatus
    */
    public String getCivilStatus() {
        return civilStatus;
    }

    /*
    *   setter function for civilStatus
    */
    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    /*
    *   getter function for citizenship
    */
    public String getCitizenship() {
        return citizenship;
    }

    /*
    *   setter function for citizenship
    */
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    /*
    *   getter function for religion
    */
    public String getReligion() {
        return religion;
    }

    /*
    *   setter function for religion
    */
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /*
    *   getter function for hireDate
    */
    public Date getHireDate() {
        return hireDate;
    }

    /*
    *   setter function for hireDate
    */
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    /*
    *   getter function for band
    */
    public String getBand() {
        return band;
    }

    /*
    *   setter function for band
    */
    public void setBand(String band) {
        this.band = band;
    }

    /*
    *   getter function for salary
    */
    public int getSalary() {
        return salary;
    }

    /*
    *   setter function for salary
    */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /*
    *   getter function for departmentID
    */
    public int getDepartmentID() {
        return departmentID;
    }

    /*
    *   setter function for departmentID
    */
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    /*
    *   getter function for positionName
    */
    public String getPositionName() {
        return positionName;
    }

    /*
    *   setter function for positionName
    */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /*
    *   getter function for isDeleted
    */
    public boolean isIsDeleted() {
        return isDeleted;
    }

    /*
    *   setter function for isDeleted
    */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /*
    *   getter function for emailAddress
    */
    public String getEmailAddress() {
        return emailAddress;
    }

    /*
    *   setter function for emailAddress
    */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /*
    *   getter function for employeeType
    */
    public String getEmployeeType() {
        return employeeType;
    }

    /*
    *   setter function for employeeType
    */
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    /*
    *   getter function for managerEntryNum
    */
    public int getManagerEntryNum() {
        return managerEntryNum;
    }

    /*
    *   setter function for managerEntryNum
    */
    public void setManagerEntryNum(int managerEntryNum) {
        this.managerEntryNum = managerEntryNum;
    }

    /**
     * @return the bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * @param bloodType the bloodType to set
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
