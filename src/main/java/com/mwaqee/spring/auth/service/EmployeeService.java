package com.mwaqee.spring.auth.service;

import com.mwaqee.spring.auth.model.Employee;
import com.mwaqee.spring.auth.model.User;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    Employee findByEmployeeId(String employeeId);
    Employee findByEmployeeNo(String employeeNo);
    List<Employee> findBySalaryGreaterThan(Double salary);
    List<Employee> getAllEmployees();
    boolean validRoleId(String role);
}
