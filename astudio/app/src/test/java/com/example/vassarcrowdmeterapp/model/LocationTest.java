package com.example.vassarcrowdmeterapp.model;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class LocationTest extends TestCase {

    public void testTestToString() {
        //make a location
        Location testLoc = new Location("Library", 2.0 );
        //run toString()
        String returnString = "Location name: Library\nCrowd rating: 2.0";
        //check if it is the same
        assertEquals(returnString, testLoc.toString());
    }

    public void testGetRatingAve() {
        //make a location
        Location testLoc = new Location("Library", 0.0);
        //making a rating item without comment
        Rating noComment = new Rating(2);
        //rating item with comment
        Rating withComment = new Rating (3, "super busy");
        //add both ratings to the list of ratings
        testLoc.allRatings.add(noComment);
        testLoc.allRatings.add(withComment);
        assertEquals(2.5, testLoc.getRatingAve());
    }

    public void testAddRating(){
        //run the add rating function on a random number to a test location
        Location testLoc = new Location("Library", 0.0);
        testLoc.addRating(4);
        testLoc.addRating(2);
        //check that the rating was actually added
        assertEquals(testLoc.allRatings.size(), 2);
        //check terminal and make sure what is returned is correct
        //print statements check out
        assertEquals(testLoc.getRatingAve(), 3.0);
    }

    public void testAddCommentRating() {
        //run the add rating function on a random number to a test location
        Location testLoc = new Location("Library", 0.0);
        testLoc.addCommentRating(2, "very busy");
        testLoc.addCommentRating(4, "very busy");
        //check that the rating was actually added
        assertEquals(testLoc.allRatings.size(), 2);
        //check that the overall rating changed correctly
        assertEquals(testLoc.getRatingAve(), 3.0);
    }

    public void testAssignColor() {
        //make a test location
        Location testLoc = new Location("Library", 1.0);
        //make sure returned color makes sense for the average rating
        assertEquals(testLoc.assignColor(), "Dark Green");
        testLoc = new Location("Library", 2.0);
        assertEquals(testLoc.assignColor(), "Light Green");
        testLoc = new Location("Library", 3.0);
        assertEquals(testLoc.assignColor(), "Yellow");
        testLoc = new Location("Library", 4.0);
        assertEquals(testLoc.assignColor(), "Orange");
        testLoc = new Location("Library", 5.0);
        assertEquals(testLoc.assignColor(), "Red");
    }
}