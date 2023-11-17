package com.example.vassarcrowdmeterapp;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.vassarcrowdmeterapp.controller.Controller;

/**
 * A class designed to test the application's add ratings screen.
 */
@RunWith(AndroidJUnit4.class)
public class AddRatingTest {

    // specify what activity to launch for test (it will be launched afresh everytime a test is run
    @org.junit.Rule
    public ActivityScenarioRule<Controller> activityRule =
            new ActivityScenarioRule<>(Controller.class);

    /**
     * This test tries to add a rating of 4 to a location and checks to see that it was
     * actually added by checking the contents of the rating entered text
     */
    @Test
    public void testAddRatings() {
        // get a ViewInteraction for the ratings text
        ViewInteraction viItemsText = Espresso.onView(
                ViewMatchers.withId(R.id.ratingNumberLabel));
        // check the text matches the default one from strings.xml
        viItemsText.check(
                ViewAssertions.matches(
                        ViewMatchers.withText(R.string.rating_number_label)));

        // click on rating text box and type in number 2
        ViewInteraction viItemName = Espresso.onView(ViewMatchers.withId(R.id.ratingNumberEntered));
        viItemName.perform(ViewActions.typeText("2"));

        Espresso.closeSoftKeyboard();

        //click on comment text box and type in 'very busy'
        Espresso.onView(ViewMatchers.withId(R.id.commentText))
                .perform(ViewActions.typeText("very busy"));

        Espresso.closeSoftKeyboard();

        // find add button and click it
        Espresso.onView(ViewMatchers.withId(R.id.addRatingButton))
                .perform(ViewActions.click());

        // check that line items text contains 2 x avocado
        // viItemsText.check(
        //       ViewAssertions.matches(
        //             ViewMatchers.withSubstring("2 x avocado")));
    }

    /**
     * Tests that we're able to move on from the search screen to the add ratings screen
     */
    /*
    @Test
    public void testMovingToAddRating(){
        testAddItems(); // call other test as a helper method

        // find and click the done button
        Espresso.onView(ViewMatchers.withText(R.string.done_button_label))
                .perform(ViewActions.click());

        // confirm we're in the payment screen by checking that a pay button exists
        Espresso.onView(ViewMatchers.withId(R.id.payButton));
    }
}
*/
/**
 * Tests that we're able to move on from add ratings screen to other screen
 */
}
