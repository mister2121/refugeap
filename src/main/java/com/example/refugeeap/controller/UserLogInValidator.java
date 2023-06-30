package com.example.refugeeap.controller;

import com.example.refugeeap.Model.UserLogIn;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserLogInValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserLogIn.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserLogIn userLogIn = (UserLogIn) target;

        // Validate login details
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginusername", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginpassword", "NotEmpty");
    }
}

