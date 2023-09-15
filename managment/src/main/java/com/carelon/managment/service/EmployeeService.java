package com.carelon.managment.service;

import com.carelon.managment.entity.EmployeeInfoEntity;

public interface EmployeeService {

    EmployeeInfoEntity createEmployee(EmployeeInfoEntity employeeInfoEntity);

    EmployeeInfoEntity getEmployeeById(int empId);

    EmployeeInfoEntity updateEmployeeName(int empId, EmployeeInfoEntity employeeInfoEntity);


    EmployeeInfoEntity updateEmployeeDob(int empId, EmployeeInfoEntity employeeInfoEntity);

    void deleteEmployee(int empId);

    EmployeeInfoEntity getEmployeeByName(String fName, String sName);

    EmployeeInfoEntity getEmployeeByNativeId(int empId);

    void updateEmployeeNativeName(String name, int id);

    void updateEmployeeNativeDob(String dOb, int empId);

    void deleteEmployeeNative(int id);

    String getEmployeeDoj(int id);

}
