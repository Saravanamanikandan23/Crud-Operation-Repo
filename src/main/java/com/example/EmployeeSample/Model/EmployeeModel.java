package com.example.EmployeeSample.Model;


import jakarta.persistence.*;


@Entity
@Table(name = "ProductDetails")
public class EmployeeModel {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer employeeId;

    public String employeeFirstName;

    public String employeeLastName;

    public String employeeEmail;

    public String employeeContact;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" + "employeeId=" + employeeId + ", employeeFirstName='" + employeeFirstName + '\'' + ", employeeLastName='" + employeeLastName + '\'' + ", employeeEmail='" + employeeEmail + '\'' + ", employeeContact='" + employeeContact + '\'' + '}';
    }
}
