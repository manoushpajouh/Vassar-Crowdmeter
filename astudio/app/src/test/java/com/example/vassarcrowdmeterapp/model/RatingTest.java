package com.example.vassarcrowdmeterapp.model;
import com.example.crowdmeterproject.model.Rating;

import junit.framework.TestCase;

public class RatingTest extends TestCase {

    public void testTestToString() {
        //making a rating item without comment
        Rating noComment = new Rating(3);
        //rating item with comment
        Rating withComment = new Rating (3, "super busy");
        //assert equals statements
        String expectedString = "Rating of 3";
        String expectedStringComment = "Rating of 3, Comment of 'super busy'";

        assertEquals(expectedString, noComment.toString());
        assertEquals(expectedStringComment, withComment.toString());
    }
}