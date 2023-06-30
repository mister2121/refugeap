package com.example.refugeeap.controller;

import com.example.refugeeap.Model.UserDetails;
import com.example.refugeeap.Model.UserLogIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.sql.*;

import static com.example.refugeeap.RefugeEapApplication.currentUser;

@Controller
public class LoginController {

    @Autowired
    private UserDetailsValidator userDetailsValidator;

    @Autowired
    private UserLogInValidator userLogInValidator;

    @RequestMapping("/LogIn")
    public String LogIn(Model model) {
        model.addAttribute("userLogin", new UserLogIn());
        model.addAttribute("currentUser", currentUser);
        return "LogInpage";
    }

    @RequestMapping("/SignOut")
        public String SignOut(){
            currentUser = "";
            return "Homepage";
        }


    /*@RequestMapping(value="/LoggedIn", method = RequestMethod.GET)
    public String LoggedIn() {
        return "Homepage";
    }*/
    @RequestMapping(value="/NotLogged", method = RequestMethod.GET)
    public String NotLogged() {
        return "NotLogged";
    }


    @RequestMapping("/SignUp")
    public String SignUp(Model model) {
        model.addAttribute("user", new UserDetails());
        return "SignUppage";
    }

    @RequestMapping(value="/CheckLogIn", method = {RequestMethod.GET, RequestMethod.POST})
    public String CheckLogIn(@Valid @ModelAttribute("userLogin") UserLogIn userLogin, BindingResult bindingResult, Model model) {
        userLogInValidator.validate(userLogin, bindingResult);
        if (bindingResult.hasErrors()) {
            return "NotLogged";
        }
        String loginusername1 = userLogin.getLoginusername();
        String loginpassword1 = userLogin.getLoginpassword();
        String admin1 = String.valueOf(userLogin.getAdmin());
        int Result = Check(loginusername1, loginpassword1);
        if (Result == 1){
            currentUser = loginusername1;
            return "/Homepage";
            } else {
            return "redirect:/NotLogged";
        }
    }


    @PostMapping("/CheckSignUp")
    public String CheckSignUp(@Valid @ModelAttribute("user") UserDetails userDetails, BindingResult bindingResult) {
        userDetailsValidator.validate(userDetails, bindingResult);
        if (bindingResult.hasErrors()) {
            return "SignUppageErr";
        }
        String username1 = userDetails.getUsername();
        String password1 = userDetails.getPassword();
        UserDetails user = new UserDetails();
        user.insert(username1, password1, 1);
        return "redirect:/";
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

    public int Check(String loginusername, String loginpassword){
        String sql = "SELECT EXISTS(SELECT 1 FROM userdetails WHERE username = ? AND password = ?) AS user_exists";
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, loginusername);
            pstmt.setString(2, loginpassword);
            ResultSet rs  = pstmt.executeQuery();
            return rs.getInt("user_exists");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }


}
