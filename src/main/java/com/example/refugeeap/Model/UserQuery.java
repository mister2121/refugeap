package com.example.refugeeap.Model;

import java.sql.*;
import java.util.UUID;

public class UserQuery {


    private String id = UUID.randomUUID().toString();
    private String name;
    private String email;
    private String phoneNumber;
    private String message;


    //Getter & Setters
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    // Connector & Insert
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

    public void insert(String id, String name, String email, String phoneNumber, String message) {
        String userQuerySql = "INSERT INTO userqueries(id,name,email,phoneNumber,message) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(userQuerySql)) {
                pstmt.setString(1, id);
                pstmt.setString(2, name);
                pstmt.setString(3, email);
                pstmt.setString(4, phoneNumber);
                pstmt.setString(5, message);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


}
