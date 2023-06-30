package com.example.refugeeap.controller;

import com.example.refugeeap.Model.Blog;
import com.example.refugeeap.Model.Event;
import com.example.refugeeap.Model.UserQuery;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContactPageValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserQuery.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserQuery u = (UserQuery) target;

        // Reject empty fields
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "[Input Email]");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "", "[Input Message]");

        if (u.getPhoneNumber().length() < 8) {
            errors.rejectValue("phoneNumber", "", "[Input valid phone number]");
        }
        if (u.getPhoneNumber().length() > 15) {
            errors.rejectValue("phoneNumber", "", "[Input valid phone number]");
        }
    }
}
