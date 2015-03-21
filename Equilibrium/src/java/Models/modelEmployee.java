
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
    private Long mobileNumber;
    private String SSSNumber;
    private String TINNumber;
    private String PHSCNumber;
    private String PAGIBIGNumber;
    private String civilStatus;
    private String citizenship;
    private String religion;
    private Date hireDate;
    private String band;
    private int salary;
    private int departmentID;
    private int positionID;
    private boolean isDeleted;
    private String emailAddress;
    private String employeeType;
    private int managerEntryNum;

    public modelEmployee(int entryNum, int employeeID, String lastName, String firstName, String middleName,
                        String address, Date birthday, String birthplace, Long mobileNumber, String SSSNumber,
                        String TINNumber, String PHSCNumber, String PAGIBIGNumber, String civilStatus, 
                        String citizenship, String religion, Date hireDate, String band, int salary,
                        int departmentID, int positionID, boolean isDeleted, String emailAddress,
                        String employeeType, int managerEntryNum){
        this.entryNum = entryNum;
        this.employeeID = employeeID;
        this.password = "";
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.mobileNumber = mobileNumber;
        this.SSSNumber = SSSNumber;
        this.TINNumber = TINNumber;
        this.PHSCNumber = PHSCNumber;
        this.PAGIBIGNumber = PAGIBIGNumber;
        this.civilStatus = civilStatus;
        this.citizenship = citizenship;
        this.religion = religion;
        this.hireDate = hireDate;
        this.band = band;
        this.salary = salary;
        this.departmentID = departmentID;
        this.positionID = positionID;
        this.isDeleted = isDeleted;
        this.emailAddress = emailAddress;
        this.employeeType = employeeType;
        this.managerEntryNum = managerEntryNum;
    }
    
    public modelEmployee(int entryNum, int employeeID, String password, String lastName, String firstName, String middleName,
                        String address, Date birthday, String birthplace, Long mobileNumber, String SSSNumber,
                        String TINNumber, String PHSCNumber, String PAGIBIGNumber, String civilStatus, 
                        String citizenship, String religion, Date hireDate, String band, int salary,
                        int departmentID, int positionID, boolean isDeleted, String emailAddress,
                        String employeeType, int managerEntryNum){
        this.entryNum = entryNum;
        this.employeeID = employeeID;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.mobileNumber = mobileNumber;
        this.SSSNumber = SSSNumber;
        this.TINNumber = TINNumber;
        this.PHSCNumber = PHSCNumber;
        this.PAGIBIGNumber = PAGIBIGNumber;
        this.civilStatus = civilStatus;
        this.citizenship = citizenship;
        this.religion = religion;
        this.hireDate = hireDate;
        this.band = band;
        this.salary = salary;
        this.departmentID = departmentID;
        this.positionID = positionID;
        this.isDeleted = isDeleted;
        this.emailAddress = emailAddress;
        this.employeeType = employeeType;
        this.managerEntryNum = managerEntryNum;
    }
    
    public int getEntryNum() {
        return entryNum;
    }

    public void setEntryNum(int entryNum) {
        this.entryNum = entryNum;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSSSNumber() {
        return SSSNumber;
    }

    public void setSSSNumber(String SSSNumber) {
        this.SSSNumber = SSSNumber;
    }

    public String getTINNumber() {
        return TINNumber;
    }

    public void setTINNumber(String TINNumber) {
        this.TINNumber = TINNumber;
    }

    public String getPHSCNumber() {
        return PHSCNumber;
    }

    public void setPHSCNumber(String PHSCNumber) {
        this.PHSCNumber = PHSCNumber;
    }
    
    public String getPAGIBIGNumber() {
        return PAGIBIGNumber;
    }

    public void setPAGIBIGNumber(String PAGIBIGNumber) {
        this.PAGIBIGNumber = PAGIBIGNumber;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public int getManagerEntryNum() {
        return managerEntryNum;
    }

    public void setManagerEntryNum(int managerEntryNum) {
        this.managerEntryNum = managerEntryNum;
    }
}
