package com.mwaqee.spring.auth.web;

import com.mwaqee.spring.auth.model.User;
import com.mwaqee.spring.auth.repository.UserRepository;
import com.mwaqee.spring.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/rest/user/getAll")
    //Returning is List is supported with JSON response only
    //If you want XML, then add a wrapper class as Root XML element, for example EmployeeList
    public List<User> getAllEmployees() {
        return userService.getAllUsers();
    }
}
