package com.example.crowdmeterproject;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.crowdmeterproject.model.Comment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommentTest {
    /**
     * Test method for compareTO in comment class. Creates three comments and then
     * checks to make sure they are displayed in reverse chronological order. Uses
     * delays to ensure that time distance between comments is large enough.
     */
    @Test
    public void compareToTest() throws InterruptedException {
        Comment comment1 = new Comment("first comment");
        TimeUnit.SECONDS.sleep(1);
        Comment comment2 = new Comment("second comment");
        TimeUnit.SECONDS.sleep(1);
        Comment comment3 = new Comment("third comment");
        TimeUnit.SECONDS.sleep(1);

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);

        Collections.sort(commentList);
        String commentsString = "";

        for (Comment comment : commentList){
            commentsString += comment.getText() + " ";
        }

        assertEquals("third comment second comment first comment ", commentsString);
    }
}
