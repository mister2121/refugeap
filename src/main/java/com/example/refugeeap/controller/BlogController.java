package com.example.refugeeap.controller;

import com.example.refugeeap.Model.Blog;
import com.example.refugeeap.Model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.refugeeap.RefugeEapApplication.currentUser;

@Controller
public class BlogController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new BlogValidator());
    }


    //Controller for BlogsListLoggedIn.jsp
    @GetMapping("/Blog")
    public String blog(Model model) {
        List<Blog> blog = getBlogs();
        Collections.reverse(blog);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("blog", blog);
        if (currentUser == ""){
            return "BlogListNotLoggedIn";
        }else {
            if (checkAdmin(currentUser) == 0) {
                return "BlogListLoggedInU";
            } else {
                return "BlogListLoggedIn";
            }
        }
    }


    //Controller for BlogNotLoggedIn.jsp
    @GetMapping("/BlogContent")
    public String blogContent(@RequestParam String blogID, Model model) {
        //Find correct blog in database
        List<Blog> allBlogs = getBlogs();
        Blog blog = new Blog();
        for (Blog b : allBlogs) {
            if (b.getId().equals(blogID)) {
                blog = b;
            }
        }

        List<Comment> allComments = getComments(blogID);

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("blog", blog);
        model.addAttribute("comments", allComments);
        if (currentUser == ""){
            return "BlogNotLoggedIn";
        }else{
            if (checkAdmin(currentUser) == 0){
                return "BlogLoggedInU";
            }
            else{
                return "BlogLoggedIn";
            }
        }

    }


    //Controller for BlogCreate.jsp
    @RequestMapping("/newBlog")
    public String newBlog(Model model) {
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("blog", new Blog());
        return "BlogCreate";
    }


    //Controller to create a new blog
    @PostMapping("/addBlog")
    public String addBlog(@Valid @ModelAttribute Blog blog, BindingResult result) {
        if (result.hasErrors()) {
            return "BlogCreate";
        }
        //Add to database
        String id1 = blog.getId();
        String title1 = blog.getTitle();
        String bName1 = currentUser;
        String post1 = blog.getPost();
        Blog blog1 = new Blog();
        blog1.insert(id1, title1, bName1, post1);
        return "redirect:/Blog";
    }


    //Delete a Blog [Only Admin Use]
    @GetMapping("/deleteBlog")
    public String deleteBlogRequest(@RequestParam String blogID) {
        Blog toTerminate = null;
        List<Blog> blogList = getBlogs();
        for (Blog a : blogList) {
            if (a.getId().equals(blogID)) {
                toTerminate = a;

            }
        }
        if (toTerminate != null) {
            deleteBlog(toTerminate);
        }
        return "redirect:/Blog";
    }


    //Get a list of all created blogs
    public List<Blog> getBlogs() {
        String sql = "SELECT id, title, bName, post FROM blog";
        List<Blog> allBlogs = new ArrayList<>();
        Blog newBlog = new Blog();
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                newBlog.setId(rs.getString("id"));
                newBlog.setTitle(rs.getString("title"));
                newBlog.setbName(rs.getString("bName"));
                newBlog.setPost(rs.getString("post"));
                allBlogs.add(newBlog);
                newBlog = new Blog();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return allBlogs;
    }

    public List<Comment> getComments(String commentId) {
        String sql = "SELECT * FROM comment WHERE id = ?";

        List<Comment> allComments = new ArrayList<>();
        Comment newComment = new Comment();
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, commentId);
            ResultSet rs  = pstmt.executeQuery();
            // loop through the result set
            while (rs.next()) {
                newComment.setId(rs.getString("id"));
                newComment.setCommentId(rs.getString("commentId"));
                newComment.setUsername(rs.getString("username"));
                newComment.setContent(rs.getString("content"));
                allComments.add(newComment);
                newComment = new Comment();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return allComments;
    }


    public void deleteBlog(Blog terminate){
        String blogSql = "DELETE FROM blog WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(blogSql)){
            pstmt.setString(1, terminate.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String commentSql = "DELETE FROM comment WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(commentSql)){
            pstmt.setString(1, terminate.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

