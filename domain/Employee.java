
package domain;

import java.io.Serializable;
import java.util.Objects;


public class Employee implements Serializable{
    private String employeeId;
    private String employeeName;
    private int employeeAge;
    private String employeeAddress;
    private String employeeGender;
    private String employeeTelephoneNo;
    private String employeePassword;
    private String departmentId;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, int employeeAge, String employeeAddress, String employeeGender, String employeeTelephoneNo, String employeePassword, String departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeAddress = employeeAddress;
        this.employeeGender = employeeGender;
        this.employeeTelephoneNo = employeeTelephoneNo;
        this.employeePassword = employeePassword;
        this.departmentId = departmentId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeTelephoneNo() {
        return employeeTelephoneNo;
    }

    public void setEmployeeTelephoneNo(String employeeTelephoneNo) {
        this.employeeTelephoneNo = employeeTelephoneNo;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

 
}
