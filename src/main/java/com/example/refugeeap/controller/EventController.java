package com.example.refugeeap.controller;


import com.example.refugeeap.Model.Blog;
import com.example.refugeeap.Model.Event;
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
public class EventController {

    //validator reference
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new EventValidator());
    }

    //Mapping for EventsPage{LoggedIn|NotLoggedIn}.jsp
    @GetMapping("/Events")
    public String getEvent(Model model) {
        model.addAttribute("currentUser", currentUser);
        List<Event> allEvents = getEvent();
        model.addAttribute("events", allEvents);
        if (checkAdmin(currentUser) == 1){
            return "EventsPageLoggedIn";
        }else{
            return "EventsPageNotLoggedIn";
        }
    }

    //Mapping for EventsCreate.jsp
    @RequestMapping("/newEvent")
    public String newEvent(Model model){
        model.addAttribute("event", new Event());
        return "EventsCreate";
    }

    //Create new event
    @PostMapping("/addEvent")
    public String addEvent(@Valid @ModelAttribute Event event, BindingResult result){
        if (result.hasErrors()){
            return "EventsCreate";
        }
        //add to database
        String id1 = event.getId();
        String title1 = event.getTitle();
        String author1 = currentUser;
        String date1 = event.getDate();
        String time1 = event.getTime();
        String description1 = event.getDescription();
        Event event1 = new Event();
        event1.insert(id1,title1,author1,date1,time1,description1);

        return "redirect:/Events";
    }

    //Mapping for EventsDescription.jsp
    @RequestMapping("/EventsDescription")
    public String getEventsDescription(@RequestParam String event, Model model){
        Event target = new Event();
        List<Event> allEvents = getEvent();
        for (Event eve : allEvents){
            if (eve.getId().equals(event)){
                target = eve;
            }
        }
        model.addAttribute("event", target);
        if (currentUser == ""){
            return "EventsDescriptionNotLoggedIn";
        }else{
            return "EventsDescriptionLoggedIn";
        }
    }

    //Delete an Event
    @GetMapping("/deleteEvent")
    public String deleteEventRequest(@RequestParam String id) {
        if (id != null) {
            deleteEvent(id);
        }
        return "redirect:/Events";
    }

    //Get a list of all created events
    public List<Event> getEvent(){
        String sql = "SELECT id, title, author, date, time, description FROM event";
        List<Event> allEvents = new ArrayList<>();
        Event newEvent = new Event();
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                newEvent.setId(rs.getString("id"));
                newEvent.setTitle(rs.getString("title"));
                newEvent.setAuthor(rs.getString("author"));
                newEvent.setDate(rs.getString("date"));
                newEvent.setTime(rs.getString("time"));
                newEvent.setDescription(rs.getString("description"));
                allEvents.add(newEvent);
                newEvent = new Event();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return allEvents;
    }

    public void deleteEvent(String terminate) {
        String blogSql = "DELETE FROM event WHERE id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(blogSql)) {
            pstmt.setString(1, terminate);
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


    //To connect with database
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
