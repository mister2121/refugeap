package com.example.refugeeap.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

import static com.example.refugeeap.RefugeEapApplication.currentUser;

@Controller
public class MainController {


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("currentUser", currentUser);
        return "Homepage";
    }

    @RequestMapping("FAQ")
    public String FAQ(Model model) {
        model.addAttribute("currentUser", currentUser);
        if (currentUser == ""){
            return "FAQPageNotLoggedIn";
        }else{
            return "FAQPageLoggedIn";
        }
    }


    @RequestMapping("AboutUs")
    public String AboutUs(Model model) {
        model.addAttribute("currentUser", currentUser);
        if (currentUser == ""){
            return "AboutUsNotLoggedIn";
        }
        else{
            return "AboutUsLoggedIn";

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
