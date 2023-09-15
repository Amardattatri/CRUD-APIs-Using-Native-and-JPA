package com.carelon.managment.repository;

import com.carelon.managment.entity.EmployeeInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfoEntity, Integer> {

    @Query(value = "SELECT * FROM Employee_T   WHERE first_Name=?1 AND last_Name=?2", nativeQuery = true)
    EmployeeInfoEntity getEmployeeByName(String first_name, String last_name);

    @Query(nativeQuery = true, value = "SELECT * from Employee_T WHERE emp_id=?1")
    EmployeeInfoEntity getEmployeeByNativeId(int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Employee_T SET first_name=?1 WHERE emp_id=?2")
    void updateEmployeeNativeName(String name, int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Employee_T SET d_ob=?1 WHERE emp_id=?2")
    void updateEmployeeNativeDob(String dOb, int empId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE Employee_T, Salary_T, Address_T " +
                                        "FROM Employee_T  JOIN Salary_T  ON Salary_T.sal_id = Employee_T.fk_sal_add_id  " +
                                        "JOIN Address_T  ON Address_T.address_id =Employee_T.fk_addr_add_id WHERE Employee_T.emp_id=?1")
    void deleteEmployeeNative(int id);

    //api to fecth date of joining of a employee using empid
    @Query(nativeQuery = true, value = "SELECT Salary_T.d_oj FROM Employee_T JOIN Salary_T ON Salary_T.sal_id = Employee_T.fk_sal_add_id WHERE Employee_T.emp_id=?1" )
    String getEmployeeDoj(int id);

}
