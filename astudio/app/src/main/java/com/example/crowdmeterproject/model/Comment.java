package com.example.crowdmeterproject.model;

import java.util.Date;
import java.util.Calendar;


/**
 * Class representing a comment created by a user for a location. Comments have a
 * time field that indicates when they were created.
 */
public class Comment implements Comparable {
    String text; // text of the comment
    Date time; // when was the comment posted?

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
}
