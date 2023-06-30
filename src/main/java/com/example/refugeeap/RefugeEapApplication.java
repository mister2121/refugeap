package com.example.refugeeap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })public class RefugeEapApplication {

    public static String currentUser = ""; //Name of current user. If user is log off, leave empty string.

    public static void main(String[] args) {
        SpringApplication.run(RefugeEapApplication.class, args);
        createNewTable();

    }

    public static void createNewTable() {
        String url = "jdbc:sqlite:Website.db";

        //TABLE userdetails
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS userdetails ("
                + "	username text,"
                + "	password text,"
                + "admin int"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        //TABLE blog
        String blogSql = "CREATE TABLE IF NOT EXISTS blog (\n"
                + "	id text PRIMARY KEY,\n"
                + "	title text,"
                + " bName text,"
                + " post text"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(blogSql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        //TABLE comment
        String commentSql = "CREATE TABLE IF NOT EXISTS comment (\n"
                + " id text,\n"
                + " commentId text,\n"
                + "	username text,\n"
                + "	content text"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);

             Statement stmt = conn.createStatement()) {
            stmt.execute(commentSql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        //TABLE event
        String eventSql =
                "CREATE TABLE IF NOT EXISTS event (\n"
                + "	id text PRIMARY KEY,\n"
                + "	title text,\n"
                + " author text,\n"
                + " date text,\n"
                + " time text,\n"
                + " description text"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(eventSql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        //TABLE userquery
        String querySql =
                "CREATE TABLE IF NOT EXISTS userqueries (\n"
                        + "	id text PRIMARY KEY,\n"
                        + "	name text,\n"
                        + " email text,\n"
                        + " phoneNumber text,\n"
                        + " message text"
                        + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(querySql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

