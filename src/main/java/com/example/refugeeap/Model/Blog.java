package com.example.refugeeap.Model;

import java.sql.*;
import java.util.List;
import java.util.UUID;

public class Blog {


    private String id = UUID.randomUUID().toString();
    private String title;
    private String bName;
    private String post;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getbName() {
        return bName;
    }
    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }

    //Connector & Insert
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

    public void insert(String id, String title, String bName, String post) {
        String blogSql = "INSERT INTO blog(id,title,bName,post) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(blogSql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, bName);
            pstmt.setString(4, post);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




}

