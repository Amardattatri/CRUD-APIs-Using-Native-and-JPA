package com.carelon.managment.dto;


import com.carelon.managment.entity.AddressInfoEntity;
import com.carelon.managment.entity.SalaryInfoEntity;

public class EmployeeInfoDto {

    private String firstName;
    private String lastName;
    private int age;
    private String dOb;
    private SalaryInfoEntity salaryInfoEntity;
    private AddressInfoEntity addressInfoEntity;

    public SalaryInfoEntity getSalaryInfoEntity() {
        return salaryInfoEntity;
    }

    public void setSalaryInfoEntity(SalaryInfoEntity salaryInfoEntity) {
        this.salaryInfoEntity = salaryInfoEntity;
    }
    public AddressInfoEntity getAddressInfoEntity() {
        return addressInfoEntity;
    }

    public void setAddressInfoEntity(AddressInfoEntity addressInfoEntity) {
        this.addressInfoEntity = addressInfoEntity;
    }

    @Override
    public String toString() {
        return "EmployeeInfoDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dOb='" + dOb + '\'' +
                ", salaryInfoEntity=" + salaryInfoEntity +
                ", addressInfoEntity=" + addressInfoEntity +
                '}';
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getdOb() {
        return dOb;
    }

    public void setdOb(String dOb) {
        this.dOb = dOb;
    }
}
