package com.example.crowdmeterproject;

<<<<<<< HEAD
import com.example.crowdmeterproject.model.Rating;

=======
>>>>>>> 24d90037f361432adff84e8a89194e67ccbd1415
import junit.framework.TestCase;
import com.example.crowdmeterproject.model.Rating;

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