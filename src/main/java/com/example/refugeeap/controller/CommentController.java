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
import java.util.Collections;
import java.util.List;

import static com.example.refugeeap.RefugeEapApplication.currentUser;

@Controller
public class CommentController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new CommentValidator());
    }

    //Controller for CommentCreate.jsp
    @RequestMapping("/newComment")
    public String newComment(@RequestParam String blogID, Model model){
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("comment", new Comment());
        model.addAttribute("blogID", blogID);
        return "CommentCreate";
    }


    //Add Comment
    @PostMapping("/addComment")
    public String addComment(@RequestParam String blogID, @Valid @ModelAttribute Comment comment, BindingResult result, Model model) {
        //If errors, repeat
        if (result.hasErrors()) {
            return "CommentCreate";
        }
        //Add to database
        String id1 = blogID;
        String commentId1 = comment.getCommentId();
        String content1 = comment.getContent();
        Comment comment1 = new Comment();
        comment1.insert(id1, commentId1, currentUser, content1);
        return "redirect:/BlogContent?blogID="+blogID;
    }


    //Delete a Comment [Only Admin Use]
    @GetMapping("/deleteComment")
    public String deleteCommentRequest(@RequestParam String commentId) {
        System.out.println(commentId);
        String blogId = "";
        if (commentId != null) {
            blogId = deleteComment(commentId);
        }
        return "redirect:/BlogContent?blogID="+blogId;
    }


    //Delete a Comment [Function]
    public String deleteComment(String terminate){
        String blogId = "";
        String commentSelectSql = "SELECT id FROM comment WHERE commentId = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(commentSelectSql)){
            pstmt.setString(1, terminate);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                blogId = rs.getString("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String commentSql = "DELETE FROM comment WHERE commentId = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(commentSql)){
            pstmt.setString(1, terminate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return blogId;
    }


    //Connect to database
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
