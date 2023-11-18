package com.example.crowdmeterproject;

import android.os.SystemClock;

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
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AddSearchTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testAddSearch() {
        ViewInteraction viAddScreenButton = Espresso.onView(ViewMatchers.withId(R.id.addButton));
        viAddScreenButton.perform(ViewActions.click()); // move to add screen

        ViewInteraction viLocationName = Espresso.onView(ViewMatchers.withId(R.id.locationName));
        viLocationName.perform(ViewActions.typeText("test location"));
        Espresso.closeSoftKeyboard();
        ViewInteraction viAddButton = Espresso.onView(ViewMatchers.withId(R.id.addLocButton));
        viAddButton.perform(ViewActions.click()); // add a test location

        SystemClock.sleep(6000); // wait for snackbar to go away

        ViewInteraction viSearchScreenButton = Espresso.onView(ViewMatchers.withId(R.id.searchButton));
        viSearchScreenButton.perform(ViewActions.click()); // move to search screen

        SystemClock.sleep(1000);

        ViewInteraction viSearchBar = Espresso.onView(ViewMatchers.withId(R.id.searchBar));
        viSearchBar.perform(ViewActions.typeText("test location"));
        Espresso.closeSoftKeyboard();
        ViewInteraction viSearchLocsButton = Espresso.onView(ViewMatchers.withId(R.id.searchLocsButton));
        viSearchLocsButton.perform(ViewActions.click()); // search for the location that was just added

        SystemClock.sleep(1000);

        ViewInteraction viResultText = Espresso.onView(ViewMatchers.withId(R.id.resultText));
        viResultText.check(ViewAssertions.matches(ViewMatchers.withSubstring("test location"))); // search screen should display test location
    }
}