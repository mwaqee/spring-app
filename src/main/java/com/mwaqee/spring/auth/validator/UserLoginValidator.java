package com.mwaqee.spring.auth.validator;

import com.mwaqee.spring.auth.model.User;
import com.mwaqee.spring.auth.service.UserService;
import com.mwaqee.spring.auth.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserLoginValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User userForm = (User) o;
    	User userObjectFromDb = null;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "NotEmpty");
        
        userObjectFromDb = userService.findByUsername(userForm.getUserId());
        
        if (null == userObjectFromDb) {
            errors.rejectValue("userId", "userForm.username.invalid");
        }else if(!userService.validRoleId(userObjectFromDb.getUserRole().getRoleId())) {
        	 errors.rejectValue("userId", "userForm.username.role.invalid");
        }else if(!userForm.getPassword().equals(userObjectFromDb.getPassword())) {
        	errors.rejectValue("password", "userForm.password.invalid");
        }else if(Constants.YES.equals(userObjectFromDb.getIsLocked())) {
        	errors.rejectValue("userId", "userForm.username.locked");
        }else if(Constants.YES.equals(userObjectFromDb.getIsExpired())) {
        	errors.rejectValue("userId", "userForm.username.expired");
        }else if(Constants.NO.equals(userObjectFromDb.getIsActive())) {
        	errors.rejectValue("userId", "userForm.username.inactive");
        }
    }
}
