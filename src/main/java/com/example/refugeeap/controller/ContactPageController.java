package com.example.refugeeap.controller;

import com.example.refugeeap.Model.Blog;
import com.example.refugeeap.Model.UserQuery;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static com.example.refugeeap.RefugeEapApplication.currentUser;

@Controller
public class ContactPageController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new ContactPageValidator());
    }


    //Controller that handles main Contact Page
    @RequestMapping("ContactPage")
    public String Contact(Model model) {
        model.addAttribute("userQuery", new UserQuery());
        model.addAttribute("currentUser", currentUser);
        if (currentUser == ""){
            return "ContactPageNotLoggedIn";
        }else if (checkAdmin(currentUser) == 0) {
            return "ContactPageLoggedInU";
        } else {
            return "ContactPageLoggedIn";
        }
    }


    //Add Query to database
    @PostMapping("/addQuery")
    public String addQuery(@Valid @ModelAttribute UserQuery query, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userQuery", query);
            return "ContactPageLoggedIn";
        }

        // Adding to database
        String id1 = query.getId();
        String email1 = query.getEmail();
        String phoneNumber1 = query.getPhoneNumber();
        String message1 = query.getMessage();
        UserQuery query1 = new UserQuery();
        query1.insert(id1,currentUser,email1,phoneNumber1,message1);

        return "redirect:/ContactPage";
    }

    @GetMapping("/UserQuery")
    public String allQueries(Model model){
        if (currentUser == "") {
            return "redirect:/ContactPage";
        }

        model.addAttribute("queries", getQueries());
        return "UserQueries";
    }


    @GetMapping("/deleteQuery")
    public String deleteQueryRequest(@RequestParam String id) {
        if (id != null) {
            deleteQuery(id);
        }
        return "redirect:/UserQuery";
    }


    public int checkAdmin(String currentUser) {
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


    public List<UserQuery> getQueries(){
        if (checkAdmin(currentUser) == 1) {
            String sql = "SELECT id, name, email, phoneNumber, message FROM userqueries";
            List<UserQuery> allQueries = new ArrayList<>();
            UserQuery newQuery = new UserQuery();
            try (Connection conn = this.connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                // loop through the result set
                while (rs.next()) {
                    newQuery.setId(rs.getString("id"));
                    newQuery.setName(rs.getString("name"));
                    newQuery.setEmail(rs.getString("email"));
                    newQuery.setPhoneNumber(rs.getString("phoneNumber"));
                    newQuery.setMessage(rs.getString("message"));
                    allQueries.add(newQuery);
                    newQuery = new UserQuery();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return allQueries;
        }

        String sql = "SELECT id, name, email, phoneNumber, message FROM userqueries WHERE name = ?";
        List<UserQuery> allQueries = new ArrayList<>();
        UserQuery newQuery = new UserQuery();
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setString(1, currentUser);
             ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                newQuery.setId(rs.getString("id"));
                newQuery.setName(rs.getString("name"));
                newQuery.setEmail(rs.getString("email"));
                newQuery.setPhoneNumber(rs.getString("phoneNumber"));
                newQuery.setMessage(rs.getString("message"));
                allQueries.add(newQuery);
                newQuery = new UserQuery();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allQueries;
    }

    public void deleteQuery(String terminate) {
        String querySql = "DELETE FROM userqueries WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(querySql)) {
            pstmt.setString(1, terminate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
