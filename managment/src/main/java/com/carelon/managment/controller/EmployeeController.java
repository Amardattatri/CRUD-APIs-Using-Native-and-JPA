package com.carelon.managment.controller;

import com.carelon.managment.dto.EmployeeInfoDto;
import com.carelon.managment.entity.EmployeeInfoEntity;
import com.carelon.managment.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private ModelMapper modelMapper;

    private EmployeeService employeeService;

    //why do we need the construtor?
    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //works
    @PostMapping("/use-jpa/create")
    public ResponseEntity<EmployeeInfoDto> createEmployeeInfo(@RequestBody EmployeeInfoDto employeeInfoDto) {
        EmployeeInfoEntity employeeRequest = modelMapper.map(employeeInfoDto, EmployeeInfoEntity.class);
        EmployeeInfoEntity eIe=employeeService.createEmployee(employeeRequest);
        EmployeeInfoDto employeeResponse=modelMapper.map(eIe, EmployeeInfoDto.class);
        return new ResponseEntity<EmployeeInfoDto>(employeeResponse, HttpStatus.CREATED);
    }

    //works
    @GetMapping("/use-jpa/employee-details/{id}")
    public ResponseEntity<EmployeeInfoDto> getEmployeeInfoUseId(@PathVariable(name = "id") int empId) {
        EmployeeInfoEntity eIe=employeeService.getEmployeeById(empId);
        EmployeeInfoDto employeeResponse=modelMapper.map(eIe,EmployeeInfoDto.class);
        return ResponseEntity.ok().body(employeeResponse);
    }

    //works
    @PutMapping("/use-jpa/update-name/{id}")
    public ResponseEntity<EmployeeInfoDto> updateEmployeeInfoName(@PathVariable(name = "id") int empId, EmployeeInfoDto employeeInfoDto) {
        EmployeeInfoEntity employeeRequest=modelMapper.map(employeeInfoDto, EmployeeInfoEntity.class);
        EmployeeInfoEntity eIe=employeeService.updateEmployeeName(empId, employeeRequest);
        EmployeeInfoDto employeeResponse=modelMapper.map(eIe, EmployeeInfoDto.class);
        return ResponseEntity.ok().body(employeeResponse);

    }

    //works
    @PutMapping("/use-jpa/update-dob/{id}")
    public ResponseEntity<EmployeeInfoDto> updateEmployeeInfoDob(@PathVariable(name = "id") int empId, EmployeeInfoDto employeeInfoDto) {
        EmployeeInfoEntity employeeRequest=modelMapper.map(employeeInfoDto, EmployeeInfoEntity.class);
        EmployeeInfoEntity eIe=employeeService.updateEmployeeDob(empId, employeeRequest);
        EmployeeInfoDto employeeResponse=modelMapper.map(eIe, EmployeeInfoDto.class);
        return ResponseEntity.ok().body(employeeResponse);
    }

    //works1111
    @DeleteMapping("/use-jpa/delete/{id}")
    public ResponseEntity<String> deleteEmployeeInfo(@PathVariable(name = "id") int empId) {
        employeeService.deleteEmployee(empId);
        return ResponseEntity.ok("Delete Success !");
    }

    //works
    @GetMapping("/use-native/employee-details/enter-name")
    public ResponseEntity<EmployeeInfoDto> getEmployeeByName(@RequestParam String fName, @RequestParam String lName) {
        EmployeeInfoEntity eIe=employeeService.getEmployeeByName(fName,lName);
        EmployeeInfoDto employeeResponse=modelMapper.map(eIe,EmployeeInfoDto.class);
        return ResponseEntity.ok().body(employeeResponse);
    }

    //working
    @GetMapping("/use-native/employee-details/{id}")
    public ResponseEntity<EmployeeInfoDto> getEmployeeByNativeId(@PathVariable(name = "id") int empId) {
        EmployeeInfoEntity eIe=employeeService.getEmployeeByNativeId(empId);
        EmployeeInfoDto employeeResponse=modelMapper.map(eIe,EmployeeInfoDto.class);
        return ResponseEntity.ok().body(employeeResponse);
    }

    //mot working ...... worked after @ Transational
    @PutMapping("/use-native/update/name")
    public ResponseEntity<String> updateEmployeeByNativeName(@RequestParam String fName, @RequestParam int empId) {
        employeeService.updateEmployeeNativeName(fName, empId);
        return ResponseEntity.ok("UPDATE Success !");
    }

    //woring after @transational .......works
    @PutMapping("/use-native/update/dOb/{id}")
    public ResponseEntity<String> updateEmployeeNativeDob(String dOb, @PathVariable(name = "id") int empId) {
        employeeService.updateEmployeeNativeDob(dOb, empId);
        return ResponseEntity.ok("UPDATE Success !");
    }

    //only deleting from one table
    @DeleteMapping("/use-native/delete/{id}")
    public ResponseEntity<String> deleteEmployeeNative(@PathVariable(name = "id") int empId) {
        employeeService.deleteEmployeeNative(empId);
        return ResponseEntity.ok("UPDATE Success !");
    }

    @GetMapping("/use-native/employee-details/doj/{id}")
    public ResponseEntity<String> getEmployeeDoj(@PathVariable(name = "id") int empId) {
        return ResponseEntity.ok().body(employeeService.getEmployeeDoj(empId));
    }
}
