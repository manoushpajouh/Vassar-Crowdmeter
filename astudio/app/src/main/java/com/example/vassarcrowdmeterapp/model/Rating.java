package com.example.vassarcrowdmeterapp.model;

import androidx.annotation.NonNull;

public class Rating {
    public int number;
    //String color = null;
    String comment = null;

    /**
     * Constructor to create a rating without a comment
     */
    public Rating(int number) {
        //make sure the parameter is equal to the field
        this.number = number;

    }

    /**
     * Constructor to create a rating with a comment
     */
    public Rating(int number, String comment) {
        this.number = number;
        this.comment = comment;
    }
    @NonNull
    public String toString(){
        String retString = "Rating of " + this.number;
        if (comment != null){
            retString += ", Comment of '" + comment + "'";
        }
        return retString;
    }


}
