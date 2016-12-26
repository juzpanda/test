package domain;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable{
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerGender;
    private String customerTelephoneNo;
    private int customerPoint;
    private String employeeId;
    
    public Customer(){
    }

    public Customer(String customerId, String customerName, String customerAddress, String customerGender, String customerTelephoneNo, int customerPoint, String employeeId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerGender = customerGender;
        this.customerTelephoneNo = customerTelephoneNo;
        this.customerPoint = customerPoint;
        this.employeeId = employeeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerTelephoneNo() {
        return customerTelephoneNo;
    }

    public void setCustomerTelephoneNo(String customerTelephoneNo) {
        this.customerTelephoneNo = customerTelephoneNo;
    }

    public int getCustomerPoint() {
        return customerPoint;
    }

    public void setCustomerPoint(int customerPoint) {
        this.customerPoint = customerPoint;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    
}