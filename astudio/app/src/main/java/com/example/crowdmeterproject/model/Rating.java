package com.example.crowdmeterproject.model;



import com.google.firebase.Timestamp;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Class representing a crowd rating added by the user. Stores the rating number and the
 * time it was created, and can also store a comment made with the rating.
 */
public class Rating {
    public int number;
    //String color = null;
    String comment = null;
    Date time; // when was the rating made
    private static final String NUMBER = "number";
    private static final String TIME = "time";

    /**
     * Constructor to create a rating without a comment
     */
    public Rating(int number) {
        //make sure the parameter is equal to the field
        this.number = number;
        this.time = Calendar.getInstance().getTime();
    }

    /**
     * Constructor to create a rating with a comment
     */
    public Rating(int number, String comment) {
        this.number = number;
        this.comment = comment;
    }

    /**
     * Displays rating as a string.
     * @return
     */
    public String toString() {
        String retString = "Rating of " + this.number;
        if (comment != null) {
            retString += ", Comment of '" + comment + "'";
        }
        return retString;
    }

    public Date getTime(){
        return this.time;
    }
    public void setTime(Date time){
        this.time = time;
    }

    public Map<String, Object> toMap(){
        Map<String,Object> map = new HashMap();

        map.put(NUMBER, this.number);
        map.put(TIME, this.time);

        return map;
    }
    public static Rating fromMap(Map<String,Object> map){
        int number = (int) (long) map.get(NUMBER);
        Timestamp ts = (Timestamp) map.get(TIME);
        Date time = ts.toDate();

        Rating rating = new Rating(number);
        rating.setTime(time);

        return rating;
    }
}