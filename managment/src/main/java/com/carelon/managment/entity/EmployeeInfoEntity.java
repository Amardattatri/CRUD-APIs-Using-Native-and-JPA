package com.carelon.managment.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
@Table(name = "Employee_T")
public class EmployeeInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="empId")
    private int empId;

    @Column(name="firstName" ,nullable = false)
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="age",nullable = false)
    private int age;

    @Column(name="dOb",nullable = false)
    private String dOb;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_sal_add_id")
    private SalaryInfoEntity salaryInfoEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_addr_add_id")
    private AddressInfoEntity addressInfoEntity;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
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

    @JsonManagedReference
    public SalaryInfoEntity getSalaryInfoEntity() {
        return salaryInfoEntity;
    }

    public void setSalaryInfoEntity(SalaryInfoEntity salaryInfoEntity) {
        this.salaryInfoEntity = salaryInfoEntity;
    }

    @JsonManagedReference
    public AddressInfoEntity getAddressInfoEntity() {
        return addressInfoEntity;
    }

    public void setAddressInfoEntity(AddressInfoEntity addressInfoEntity) {
        this.addressInfoEntity = addressInfoEntity;
    }

    @Override
    public String toString() {
        return "EmployeeInfoEntity{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dOb='" + dOb + '\'' +
                ", salaryInfoEntity=" + salaryInfoEntity +
                ", addressInfoEntity=" + addressInfoEntity +
                '}';
    }
}
