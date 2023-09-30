package com.mwaqee.spring.auth.repository;

import com.mwaqee.spring.auth.model.Employee;
import com.mwaqee.spring.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeId(String username);
    Employee findByEmployeeNo(String employeeNo);
    List<Employee> findBySalaryGreaterThan(Double salary);
}
