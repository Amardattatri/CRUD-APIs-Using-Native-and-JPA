package com.carelon.managment.service;

import com.carelon.managment.entity.EmployeeInfoEntity;
import com.carelon.managment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpliment implements EmployeeService{

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpliment(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeInfoEntity createEmployee(EmployeeInfoEntity employeeInfoEntity) {
        return employeeRepository.save(employeeInfoEntity);
    }

    @Override
    public EmployeeInfoEntity getEmployeeById(int empId) {
        return employeeRepository.findById(empId).orElse(new EmployeeInfoEntity());
    }


    @Override
    public EmployeeInfoEntity updateEmployeeName(int empId, EmployeeInfoEntity employeeInfoEntity) {
        EmployeeInfoEntity eIe=employeeRepository.findById(empId).orElse(new EmployeeInfoEntity());

        eIe.setFirstName(employeeInfoEntity.getFirstName());
        return employeeRepository.save(eIe);
    }

    @Override
    public EmployeeInfoEntity updateEmployeeDob(int empId, EmployeeInfoEntity employeeInfoEntity) {
        EmployeeInfoEntity eIe=employeeRepository.findById(empId).orElse(new EmployeeInfoEntity());

        eIe.setdOb(employeeInfoEntity.getdOb());
        return employeeRepository.save(eIe);
    }

    @Override
    public void deleteEmployee(int empId) {
        EmployeeInfoEntity eIe=employeeRepository.findById(empId).orElse(new EmployeeInfoEntity());
        employeeRepository.delete(eIe);
    }
    @Override
    public EmployeeInfoEntity getEmployeeByName(String fName, String lName){
        EmployeeInfoEntity eIe=employeeRepository.getEmployeeByName(fName,lName);
        return eIe;
    }
    @Override
    public EmployeeInfoEntity getEmployeeByNativeId(int empId){
        return employeeRepository.getEmployeeByNativeId(empId);
    }
    @Override
    public void updateEmployeeNativeName(String name, int id){
        employeeRepository.updateEmployeeNativeName(name,id);
    }

    @Override
    public void updateEmployeeNativeDob(String dOb, int empId){
        employeeRepository.updateEmployeeNativeDob(dOb,empId);
    }

    @Override
    public void deleteEmployeeNative(int id){
        employeeRepository.deleteEmployeeNative(id);
    }

    @Override
    public String getEmployeeDoj(int id){
        return employeeRepository.getEmployeeDoj(id);
    }
}
