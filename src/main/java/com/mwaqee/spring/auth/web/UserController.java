package com.mwaqee.spring.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mwaqee.spring.auth.model.User;
import com.mwaqee.spring.auth.service.UserService;
import com.mwaqee.spring.auth.validator.UserLoginValidator;
import com.mwaqee.spring.auth.validator.UserRegistrationValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRegistrationValidator userRegistrationValidator;
    
    @Autowired
    private UserLoginValidator userLoginValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	userRegistrationValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        User userFromDB = userService.findByUsername(userForm.getUserId());
    	if(null != userFromDB) {
    		model.addAttribute("userId", userFromDB.getUserId());
    	}
        return "welcome";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("userForm") User userForm, Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        try {
            model.addAttribute("userForm", userForm);
        }catch (Exception e) {
			System.out.println("Some error occured: " + e);
		}
        
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	userLoginValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "login";
        }else {
        	User userFromDB = userService.findByUsername(userForm.getUserId());
        	if(null != userFromDB) {
        		model.addAttribute("userName", userFromDB.getUserId());
        	}
        	return "welcome";
        }
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
    
    @PostMapping("/logout")
    public String logout(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
        return "login";
    }
}
