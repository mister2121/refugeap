package com.example.refugeeap.controller;

import com.example.refugeeap.Model.Blog;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.example.refugeeap.RefugeEapApplication.currentUser;

public class BlogValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Blog.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        //If empty or too long, reject
        Blog x = (Blog) target;
        if (x.getTitle().length() < 1 || x.getTitle().length() > 100) {
            errors.rejectValue("title", "", "[Can't be blank|More than 100 symbols]");
        }
        if (x.getPost().length() > 10000) {
            errors.rejectValue("post", "", "[More than 1000 symbols]");
        }
        if (x.getPost().length() < 20) {
            errors.rejectValue("post", "", "[Can't be less than 20 letters]");
        }
        //If log off, reject
        if (currentUser.isEmpty()){
            errors.rejectValue("post", "", "[Log in to post Blogs]");
        }

    }
}
