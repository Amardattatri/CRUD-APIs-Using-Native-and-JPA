package com.carelon.managment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "Salary_T")
public class SalaryInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="salId")
    private int salId;

    @Column(name="dOj",nullable = false)
    private String dOj;

    @Column(name="nextPayDate")
    private String nextPayDate;

    @OneToOne(mappedBy = "salaryInfoEntity")
    private EmployeeInfoEntity employeeInfoEntity;

    public int getSalId() {
        return salId;
    }

    public void setSalId(int salId) {
        this.salId = salId;
    }

    public String getdOj() {
        return dOj;
    }

    public void setdOj(String dOj) {
        this.dOj = dOj;
    }

    public String getNextPayDate() {
        return nextPayDate;
    }

    public void setNextPayDate(String nextPayDate) {
        this.nextPayDate = nextPayDate;
    }

    @JsonBackReference
    public EmployeeInfoEntity getEmployeeInfoEntity() {
        return employeeInfoEntity;
    }

    public void setEmployeeInfoEntity(EmployeeInfoEntity employeeInfoEntity) {
        this.employeeInfoEntity = employeeInfoEntity;
    }

    @Override
    public String toString() {
        return "SalaryInfoEntity{" +
                "salId=" + salId +
                ", dOj='" + dOj + '\'' +
                ", nextPayDate='" + nextPayDate + '\'' +
                ", employeeInfoEntity=" + employeeInfoEntity +
                '}';
    }
}
