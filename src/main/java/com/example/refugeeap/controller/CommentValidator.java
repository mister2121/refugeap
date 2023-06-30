package com.example.refugeeap.controller;

import com.example.refugeeap.Model.Comment;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.example.refugeeap.RefugeEapApplication.currentUser;

public class CommentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Comment.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //If empty or too long, reject
        Comment x = (Comment) target;
        if (x.getContent().length() < 1 || x.getContent().length() > 750) {
            errors.rejectValue("content", "", "[Can't be blank|More than 750 symbols]");
        }
        //If log off, reject
        if (currentUser.isEmpty()){
            errors.rejectValue("content", "", "[Log in to post Blogs]");
        }
    }
}
