package com.mwaqee.spring.auth.web;

import com.mwaqee.spring.auth.model.Employee;
import com.mwaqee.spring.auth.model.User;
import com.mwaqee.spring.auth.service.EmployeeService;
import com.mwaqee.spring.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/rest/employee/getEmployeesWithSalaryGreaterThan")
    //Returning List is supported with JSON response only
    //If you want XML, then add a wrapper class as Root XML element, for example EmployeeList
    // Returns all employees with salary greater than given salary in request
    public List<Employee> getAllEmployees(Double salary) {

        return employeeService.findBySalaryGreaterThan(salary);
    }
}
