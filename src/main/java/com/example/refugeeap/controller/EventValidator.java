package com.example.refugeeap.controller;

import com.example.refugeeap.Model.Event;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import static com.example.refugeeap.RefugeEapApplication.currentUser;

public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {return Event.class.equals(clazz);}

    @Override
    public void validate(Object target, Errors errors) {
        Event eve = (Event) target;

        //if empty/too short reject
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "", "[Input title]");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "", "[Input date]");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"time", "", "[Input time]");

        if (eve.getDescription().length() < 20) {
            errors.rejectValue("description", "", "[Can't be less than 20 letters]");
        }
        //if user is not logged, reject
        if (checkAdmin(currentUser) == 0){
            errors.rejectValue("time", "", "[Only Admin can add Events]");
        }

    }

    public int checkAdmin(String currentUser){
        String sql = "SELECT EXISTS(SELECT 1 FROM userdetails WHERE username = ? and admin = 0) AS user_details";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, currentUser);
            ResultSet rs = pstmt.executeQuery();
            return rs.getInt("user_details");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());

        }
        return 0;
    }
    private Connection connect() {
        String url = "jdbc:sqlite:Website.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
