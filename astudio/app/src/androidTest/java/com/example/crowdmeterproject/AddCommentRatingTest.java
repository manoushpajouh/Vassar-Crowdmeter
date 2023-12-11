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
 * A class designed to test the application's add locations screen.
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
        ViewInteraction addLocation = Espresso.onView(ViewMatchers.withId(R.id.addLocationNameField));
        addLocation.perform(ViewActions.typeText("Library"));

        Espresso.closeSoftKeyboard();

        //add the overall crowd rating of a 1
        ViewInteraction enterOverallRating = Espresso.onView(ViewMatchers.withId(R.id.ratingButton1AddScreen));
        enterOverallRating.perform(ViewActions.click());

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
        ViewInteraction viewLocation = Espresso.onView(ViewMatchers.withText(R.string.view_location_button_label));
        viewLocation.perform(ViewActions.click());

        // click on the add rating button
        ViewInteraction addRating = Espresso.onView(ViewMatchers.withId(R.id.addRatingButton));
        addRating.perform(ViewActions.click());

        SystemClock.sleep(2000); // wait for add rating screen to display

        // push the button for adding a rating of 5
        ViewInteraction viItemName = Espresso.onView(
                ViewMatchers.withId(R.id.ratingButton5));
        viItemName.perform(ViewActions.click());

        // find comment button and type in 'busy'
        ViewInteraction openComment = Espresso.onView(ViewMatchers.withId(R.id.commentField));
        openComment.perform(ViewActions.typeText("very busy"));

        Espresso.closeSoftKeyboard();

        // find add rating button and click it
        Espresso.onView(ViewMatchers.withId(R.id.addRatingToLocButton))
                .perform(ViewActions.click());

        // go back to the search screen
        Espresso.onView(ViewMatchers.withId(R.id.searchButton)).perform(ViewActions.click());

        //search the location that was just rated
        typeInSearch = Espresso.onView(ViewMatchers.withId(R.id.searchBar));
        typeInSearch.perform(ViewActions.typeText("Library"));
        //hit the search button
        searchGo.perform(ViewActions.click());

        //see if the overall rating for that has changed

        // hit the view location button
        viewLocation.perform(ViewActions.click());

        //rating should be three
        //go to the overall crowd ratings generated text
        ViewInteraction overallCrowdRating = Espresso.onView(
                ViewMatchers.withId(R.id.crowdRatingDisplay));
        SystemClock.sleep(2000);
        //split it so its just the substring after :
        //check that it contains the number three in the rating portion
        overallCrowdRating.check(
                ViewAssertions.matches(
                        ViewMatchers.withSubstring("3.0")));

        // now we can check if the comment is visible

        // hit view comments button
        ViewInteraction viewComments = Espresso.onView(ViewMatchers.withId(R.id.viewCommentsButton));
        viewComments.perform(ViewActions.click());
        // does the comment show up?
        ViewInteraction commentText = Espresso.onView(ViewMatchers.withText("very busy"));
        commentText.check(ViewAssertions.matches(ViewMatchers.withSubstring("very busy")));

    }
    //no test of moving onto next screen because no screen after adding rating unless you click the button to go back to search
}