package com.example.crowdmeterproject;

import android.os.SystemClock;
import android.view.View;

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
import com.example.crowdmeterproject.view.SearchFragment;


/**
 * A class designed to test the application's add items screen.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AddCommentRatingTest {

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
        //add the location of library to app
        //click the add button for adding a location
        ViewInteraction addLocButton = Espresso.onView(ViewMatchers.withId(R.id.addButton));
        addLocButton.perform(ViewActions.click());

        // find the location name typing box and enter the word library
        ViewInteraction addLocation = Espresso.onView(ViewMatchers.withId(R.id.locationName));
        addLocation.perform(ViewActions.typeText("Library"));

        Espresso.closeSoftKeyboard();

        //add the overall crowd rating of a 1
        ViewInteraction enterOverallRating = Espresso.onView(ViewMatchers.withId(R.id.crowdRating));
        enterOverallRating.perform(ViewActions.typeText("1"));

        Espresso.closeSoftKeyboard();

        //hit add location button
        ViewInteraction addLocationButton = Espresso.onView(ViewMatchers.withId(R.id.addLocButton));
        addLocationButton.perform(ViewActions.click());

        //click on the search button to go back
        ViewInteraction searchButton = Espresso.onView(ViewMatchers.withId(R.id.searchButton));
        searchButton.perform(ViewActions.click());

        //search for the library in the search bar
        ViewInteraction typeInSearch = Espresso.onView(ViewMatchers.withId(R.id.searchBar));
        typeInSearch.perform(ViewActions.typeText("Library"));

        //hit the search button
        ViewInteraction searchGo = Espresso.onView(ViewMatchers.withId(R.id.searchLocsButton));
        searchGo.perform(ViewActions.click());

        //click on the view rating button
        ViewInteraction addRating = Espresso.onView(ViewMatchers.withText(R.string.add_rating_button_label));
        addRating.perform(ViewActions.click());

        // go to screen with adding a rating
        ViewInteraction viRatingsText = Espresso.onView(
                ViewMatchers.withId(R.id.ratingNumberEntered));
        // check the text matches the default one
        viRatingsText.check(
                ViewAssertions.matches(
                        ViewMatchers.withText("")));

        // go to the text box for rating number and type in 4
        ViewInteraction viItemName = Espresso.onView(
                ViewMatchers.withId(R.id.ratingNumberEntered));
        viItemName.perform(ViewActions.typeText("5"));
        //close the keyboard so it can add the button
        Espresso.closeSoftKeyboard();

        // find comment button and type in 'busy'
        ViewInteraction openComment = Espresso.onView(ViewMatchers.withId(R.id.commentText));
        openComment.perform(ViewActions.typeText("busy"));

        Espresso.closeSoftKeyboard();

        // find add button and click it
        Espresso.onView(ViewMatchers.withId(R.id.addRatingToLocButton))
                .perform(ViewActions.click());

        // go back to the search button
        Espresso.onView(ViewMatchers.withId(R.id.searchButton)).perform(ViewActions.click());

        //search the location that was just rated
        typeInSearch = Espresso.onView(ViewMatchers.withId(R.id.searchBar));
        typeInSearch.perform(ViewActions.typeText("Library"));
        //hit the search button
        searchGo.perform(ViewActions.click());

        //see if the overall rating for that has changed

        //rating should be three
        //go to the overall crowd ratings generated text
        ViewInteraction overallCrowdRating = Espresso.onView(
                ViewMatchers.withId(R.id.resultText));
        SystemClock.sleep(2000);
        //split it so its just the substring after :
        //check that it contains the number three in the rating portion
        overallCrowdRating.check(
                ViewAssertions.matches(
                        ViewMatchers.withSubstring("Crowd rating: 3.0")));

    }
    //no test of moving onto next screen because no screen after adding rating unless you click the button to go back to search
}