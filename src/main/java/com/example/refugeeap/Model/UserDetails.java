package com.example.refugeeap.Model;

import java.sql.*;

import static com.example.refugeeap.RefugeEapApplication.currentUser;

public class UserDetails {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void insert(String username, String password, int AdminNumber) {
        String sql = "INSERT INTO userdetails(username,password,admin) VALUES(?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setInt(3, AdminNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public int checkAdmin(String currentUser){
        String sql = "SELECT EXISTS(SELECT 1 FROM userdetails WHERE username = ? and admin = 0 AS adminlogin";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            return rs.getInt("adminlogin");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());

        }
        return 0;
    }

}
