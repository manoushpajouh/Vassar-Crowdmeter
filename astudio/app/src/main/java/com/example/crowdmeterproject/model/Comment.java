package com.example.crowdmeterproject.model;

import com.google.firebase.Timestamp;

import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Class representing a comment created by a user for a location. Comments have a
 * time field that indicates when they were created.
 */
public class Comment implements Comparable {
    String text; // text of the comment
    Date time; // when was the comment posted?
    private static final String TEXT = "text";
    private static final String TIME = "time";

    public Comment(String text){
        this.text = text;
        this.time = Calendar.getInstance().getTime(); // get the current time
    }

    public String getText(){
        return this.text;
    }
    public Date getTime(){
        return this.time;
    }
    public void setTime(Date time){
        this.time = time;
    }


    /**
     * Implementation of compareTo method for comments. Designed to sort comments in
     * reverse chronological order (so that most recent comments are displayed first in UI)
     */
    @Override
    public int compareTo(Object o) {
        Comment comment = (Comment) o;

        if (this.time.compareTo(comment.getTime()) < 0){
            return 1;
        }
        else if (this.time.compareTo(comment.getTime()) == 0){
            return 0;
        }
        else {
            return -1;
        }
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap();

        map.put(TEXT, this.text);
        map.put(TIME, this.time);

        return map;
    }
    public static Comment fromMap(Map<String,Object> map){
        String text = (String) map.get(TEXT);
        Timestamp ts = (Timestamp) map.get(TIME);
        Date time = ts.toDate();

        Comment comment = new Comment(text);
        comment.setTime(time);

        return comment;
    }
}
