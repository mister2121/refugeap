package com.example.refugeeap.controller;

import com.example.refugeeap.Model.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserDetailsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDetails.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDetails userDetails = (UserDetails) target;

        // Validate username
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (userDetails.getUsername().length() < 4 || userDetails.getUsername().length() > 32) {
            errors.rejectValue("username", "Username needs to be between 4 and 32 characters");
        }

        // Validate password
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (userDetails.getPassword().length() < 6 || userDetails.getPassword().length() > 32) {
            errors.rejectValue("password", "Password needs to be between 6 and 32 characters");
        }
    }
}


