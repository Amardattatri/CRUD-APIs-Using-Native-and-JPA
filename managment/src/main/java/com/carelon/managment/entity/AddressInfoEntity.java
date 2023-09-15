package com.carelon.managment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "Address_T")
public class AddressInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="addressId")
    private int addressId;

    @Column(name="state")
    private String state;

    @Column(name="city")
    private String city;

    @Column(name="village")
    private String village;

    @OneToOne(mappedBy = "addressInfoEntity")
    private EmployeeInfoEntity employeeInfoEntity;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
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
        return "AddressInfoEntity{" +
                "addressId=" + addressId +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", village='" + village + '\'' +
                ", employeeInfoEntity=" + employeeInfoEntity +
                '}';
    }
}
