package com.example.crowdmeterproject.model;

import java.util.Date;
import java.util.Calendar;

public class Comment implements Comparable {
    String text; // text of the comment
    Date time; // when was the comment posted?

    public Comment(String text){
        this.text = text;
        this.time = Calendar.getInstance().getTime();
    }

    public String getText(){
        return this.text;
    }
    public Date getTime(){
        return this.time;
    }

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
