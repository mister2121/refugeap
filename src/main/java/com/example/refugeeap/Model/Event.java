package com.example.refugeeap.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class Event {
    private String id = UUID.randomUUID().toString();
    private String title;
    private String author;
    private String description;
    private String date;
    private String time;

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getDescription() {
        return description;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTime(String time) {
        this.time = time;
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

    public void insert(String id, String title, String author, String date, String time, String description) {
        String eventSql = "INSERT INTO event(id,title,author,date,time,description) VALUES(?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(eventSql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setString(4, date);
            pstmt.setString(5, time);
            pstmt.setString(6, description);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
