package com.example.crowdmeterproject;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.crowdmeterproject.controller.MainActivity;


/**
 * A class designed to test the application's add items screen.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AddRatingsTest {

    // specify what activity to launch for test (it will be launched afresh everytime a test is run
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /**
     * This test tries to add 4 to a rating and checks to see that it is actually
     * added by checking the contents of the ratingsEntered text.
     */
    @Test
    public void testAddRatings() {

        // get a ViewInteraction for the rating number entered text
        ViewInteraction viItemsText = Espresso.onView(
                ViewMatchers.withId(R.id.ratingNumberEntered));
        // check the text matches the default one
        viItemsText.check(
                ViewAssertions.matches(
                        ViewMatchers.withText("")));

        // go to the text box for rating number and type in 4
        ViewInteraction viItemName = Espresso.onView(ViewMatchers.withId(R.id.ratingNumberEntered));
        viItemName.perform(ViewActions.typeText("4"));

        Espresso.closeSoftKeyboard();

        // find comment button and type in 'busy'
        Espresso.onView(ViewMatchers.withId(R.id.commentText))
                .perform(ViewActions.typeText("busy"));

        Espresso.closeSoftKeyboard();

        // find add button and click it
        Espresso.onView(ViewMatchers.withId(R.id.addRatingButton))
                .perform(ViewActions.click());

        /// check that line items text contains 2 x avocado
        viItemsText.check(
                ViewAssertions.matches(
                        ViewMatchers.withSubstring("Rating of 3, Comment of 'super busy")));
    }
    //no test of moving onto next screen because no screen after adding rating
}