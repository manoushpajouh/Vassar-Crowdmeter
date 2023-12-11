package com.example.crowdmeterproject.model;


import android.util.Log;

import androidx.annotation.NonNull;

import com.example.crowdmeterproject.persistence.FirestoreFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Class that defines a location object with name and crowd rating fields. Also stores
 * a list of all ratings for that location and list of all comments.
 */
public class Location implements Serializable {
    public String name; // name of location
    double crowdRating; // how busy is it, 1-5?
    public List<Rating> allRatings = new ArrayList<>(); // list of ratings for specific location
    public List<Comment> allComments = new ArrayList<>(); // list of all comments for a specific location
    private static final String NAME = "name";
    private static final String CROWDRATING = "crowdrating";
    private static final String RATINGS = "ratings";
    private static final String COMMENTS = "comments";


    public Location(String name, double crowdRating){
        this.name = name;
        this.crowdRating = crowdRating;
    }

    public Location(String name){
        this.name = name;
    }

    // to print a location, display its name and its crowd rating
    public String toString(){
        return "Location name: " + name + "\nCrowd rating: " + crowdRating;
    }
    public String getName(){
        return this.name;
    }
    public List<Comment> getComments(){
        return this.allComments;
    }
    public void setCrowdRating(double crowdRating){
        this.crowdRating = crowdRating;
    }
    public void setRatings(List<Rating> ratings){
        this.allRatings = ratings;
    }
    public void setComments(List<Comment> comments){
        this.allComments = comments;
    }


    /**
     * To get the rating for a location: get the average of all the ratings for that location
     * This method will get the overall, average rating for a location
     * by iterating through the list of ratings, getting the sum of the ratings number
     * adding all rating numbers and dividing it by how many there are
     */
    public double getRatingAve(){
        double sizeOfRatings = allRatings.size(); //size of allRatings list

        if (sizeOfRatings == 0){
            return 0;
        }

        double counter = 0; //counter represents the accumulating number from all the ratings added up

        for (int i = 0; i < sizeOfRatings; i++) { //iterate through the list of allRatings
                counter = counter + allRatings.get(i).number;
        }
        crowdRating = (double) (counter / sizeOfRatings);
        return crowdRating;
    }

    /**
     * Returns the average rating within a specified time range.
     * @param hours number of hours since start of time range
     * @return the average rating since the specified number of hours
     */
    public double getRatingAveTime(int hours){
        List<Rating> ratingsInRange = new ArrayList<>();


        Date now = Calendar.getInstance().getTime(); // get the current time

        for (Rating rating : allRatings){ // checks if each rating is within time range
            if ((now.getTime() - rating.getTime().getTime()) / 3600000 <= hours){ // convert from milliseconds to hours
                ratingsInRange.add(rating);
            }
        }

        int sizeOfRatings = ratingsInRange.size();

        double counter = 0; //counter represents the accumulating number from all the ratings added up

        for (int i = 0; i < sizeOfRatings; i++) { //iterate through the list of allRatings
            counter = counter + allRatings.get(i).number;
        }
        crowdRating = (double) (counter / sizeOfRatings);
        return crowdRating;
    }

    public void updateRatingAve() {
        double newRating = this.getRatingAve();
        FirestoreFacade f = new FirestoreFacade();

        this.crowdRating = newRating;
        f.updateRatingAverage(newRating, this);
    }

    /**
     * Adds a rating with no comment.
     * @param ratingNumber
     */
    public void addRating(int ratingNumber) {
        Rating rating = new Rating(ratingNumber);
        allRatings.add(rating);
        this.updateRatingAve();
    }

    /**
     * Adds a rating with a comment.
     * @param rateNum
     */
    public void addCommentRating(int rateNum, Comment newComment){
        Rating rating = new Rating(rateNum);
        allRatings.add(rating);
        allComments.add(newComment);
    }

    /**
     * Converts object of this class to a hashmap for database storage
     * @return
     */
    @NonNull
    public Map<String,Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(NAME, name);
        map.put(CROWDRATING, crowdRating);

        List<Map<String,Object>> ratings = new ArrayList<>();
        for(Rating rating : this.allRatings){
            ratings.add(rating.toMap());
        }

        map.put(RATINGS, ratings);

        List<Map<String,Object>> comments = new ArrayList<>();
        for(Comment comment : this.allComments){
            comments.add(comment.toMap());
        }

        map.put(COMMENTS, comments);
        return map;
    }
    /**
     * Converts map object back to location
     */
    @NonNull
    public static Location fromMap(Map<String,Object> map){
        String locName = (String) map.get(NAME);
        double crowdRating = (double) map.get(CROWDRATING);
        List<Map<String,Object>> ratingMaps = (List<Map<String,Object>>) map.get(RATINGS);
        List<Map<String,Object>> commentMaps = (List<Map<String,Object>>) map.get(COMMENTS);

        List<Rating> ratings = new ArrayList<>();

        for (Map<String,Object> rating : ratingMaps){
            ratings.add(Rating.fromMap(rating));
        }

        List<Comment> comments = new ArrayList<>();

        for (Map<String,Object> comment : commentMaps){
            comments.add(Comment.fromMap(comment));
        }

        Location returnLoc = new Location(locName);
        returnLoc.setCrowdRating(crowdRating);
        returnLoc.setRatings(ratings);
        returnLoc.setComments(comments);

        return returnLoc;
    }
}
