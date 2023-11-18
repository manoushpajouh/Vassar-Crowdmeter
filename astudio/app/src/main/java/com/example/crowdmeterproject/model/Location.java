package com.example.crowdmeterproject.model;

import com.example.vassarcrowdmeterapp.model.Rating;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that defines a location object with name and crowd rating fields.
 */
public class Location {
    public String name; // name of location
    double crowdRating; // how busy is it, 1-5?
    public List<Rating> allRatings = new ArrayList<>(); // list of ratings for specific location


    public Location(String name, double crowdRating){
        this.name = name;
        this.crowdRating = crowdRating;
    }

    // to print a location, display its name and its crowd rating
    public String toString(){
        return "Location name: " + name + "\nCrowd rating: " + crowdRating;
    }
    public String getName(){
        return this.name;
    }


    /**
     * To get the rating for a location: get the average of all the ratings for that location
     * This method will get the overall, average rating for a location
     * by iterating through the list of ratings, getting the sum of the ratings number
     * adding all rating numbers and dividing it by how many there are
     */
    public double getRatingAve(){
        double sizeOfRatings = allRatings.size(); //size of allRatings list
        double counter = 0;     //counter represents the accumulating number from all the ratings added up

        for (int i = 0; i < sizeOfRatings; i++) { //iterate through the list of allRatings
            counter = counter + allRatings.get(i).number;
        }
        crowdRating = (double) (counter / sizeOfRatings);
        return crowdRating;
    }

    public void addRating(int ratingNumber) {
        Rating rating = new Rating(ratingNumber);
        System.out.println("Adding Your Rating of " + ratingNumber + " to " + name);
        //add rating to the list so that the counter will still work
        allRatings.add(rating);
        System.out.println("New Overall Rating of " + getRatingAve() + " at " + name);

    }

    public void addCommentRating(int rateNum, String newComment){
        Rating rating = new Rating(rateNum, newComment);
        //add rating to the list so that the counter will still work
        allRatings.add(rating);
        System.out.println("Adding Your Rating of " + rating.number + " to " + name);
        System.out.println("New Overall Rating of " + crowdRating + " at " + name);

    }

    /**
     * Function will return the string for whatever color the average rating should be
     */
    //prints out what color each rating will be depending on the number
    public String assignColor(){
        String color;
        //switch case for every color it could be
        switch ((int) crowdRating){
            case 1:
                color = "Dark Green";
                break;
            case 2:
                color = "Light Green";
                break;
            case 3:
                color = "Yellow";
                break;
            case 4:
                color = "Orange";
                break;
            case 5:
                color = "Red";
                break;
            //default is null color
            default:
                color = null;
        }
        return color;
    }


}
