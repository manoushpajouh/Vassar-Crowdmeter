package com.example.crowdmeterproject.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.crowdmeterproject.model.Comment;
import com.example.crowdmeterproject.view.AddFragment;
import com.example.crowdmeterproject.model.Location;
import com.example.crowdmeterproject.model.LocationsLibrary;
import com.example.crowdmeterproject.view.AddRatingFragment;
import com.example.crowdmeterproject.view.DeleteFragment;
import com.example.crowdmeterproject.view.IAddRatingsView;
import com.example.crowdmeterproject.view.IAddView;
import com.example.crowdmeterproject.view.IDeleteView;
import com.example.crowdmeterproject.view.ILocationView;
import com.example.crowdmeterproject.view.IMainView;
import com.example.crowdmeterproject.view.ISearchView;
import com.example.crowdmeterproject.view.IShowCommentsView;
import com.example.crowdmeterproject.view.LocationFragment;
import com.example.crowdmeterproject.view.MainView;
import com.example.crowdmeterproject.view.SearchFragment;
import com.example.crowdmeterproject.view.ShowCommentsFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements
        ISearchView.Listener, IMainView.Listener, IAddView.Listener, IAddRatingsView.Listener, ILocationView.Listener, IShowCommentsView.Listener, IDeleteView.Listener {
    LocationsLibrary locationsLibrary = new LocationsLibrary();
    IMainView mainView;
    Location currentLocation; // the location that the user is currently looking at (on the add rating screen for)

    List<Location> searchResults; // a location that has been successfully searched for by the user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainView = new MainView(this, this);

        mainView.displayFragment(new SearchFragment(this), false, "search_fragment");

        setContentView(mainView.getRootView());
    }
    /**
     * Called when user clicks search button. Prompts search fragment to
     * display search results.
     */
    @Override
    public void onSearched(String searchInput, ISearchView view) {
        searchResults = locationsLibrary.searchByName(searchInput);

        if (searchResults == null){
            view.displaySearchFailure();
        }
        else {
            view.displaySearchResults(searchResults);
        }
    }
    /**
     * Called when user clicks button to add a rating from location screen. Switches display to
     * add rating fragment.
     */
    @Override
    public void onAddRatingPress(ILocationView view) {
        mainView.displayFragment(new AddRatingFragment(this), false, "addRatingFragment");
<<<<<<< HEAD
    }

    @Override
    public void onViewLocationPress(ISearchView view, Location currentLocation){
        this.currentLocation = currentLocation;

        mainView.displayFragment(new LocationFragment(this, currentLocation), false, "location_fragment");
    }
    @Override
    public void onViewCommentsPress(ILocationView view){
        mainView.displayFragment(new ShowCommentsFragment(this, currentLocation), false, "comment_fragment");
    }
    @Override
    public void onDeletePress(ILocationView view){
        mainView.displayFragment(new DeleteFragment(this), false, "delete_fragment");
    }
    @Override
    public void onDeleteLocPress(IDeleteView view){
       locationsLibrary.deleteLocation(currentLocation);
=======
>>>>>>> fbe0c9d930ac9fa3ca6ecfecd884ea5d47f41981
    }

    /**
     * Called when user clicks button to view a location from the search screen. Displays
     * fragment for that location, and also updates currentLocation so that any ratings or
     * comments added by the user are applied to the correct location.
     * @param currentLocation
     */
    @Override
    public void onViewLocationPress(ISearchView view, Location currentLocation){
        this.currentLocation = currentLocation;

        mainView.displayFragment(new LocationFragment(this, currentLocation), false, "location_fragment");
    }

    /**
     * Displays comments fragment for a location (called when user presses view comments button)
     * from location screen.
     * @param view
     */
    @Override
    public void onViewCommentsPress(ILocationView view){
        mainView.displayFragment(new ShowCommentsFragment(this, currentLocation), false, "comment_fragment");
    }

    /**
     * Displays delete location fragment.
     * @param view
     */
    @Override
    public void onDeletePress(ILocationView view){
        mainView.displayFragment(new DeleteFragment(this), false, "delete_fragment");
    }

    /**
     * Called when user presses the button to delete a location (after providing the
     * correct password). Deletes currentLocation.
     * @param view
     */
    @Override
    public void onDeleteLocPress(IDeleteView view){
       locationsLibrary.deleteLocation(currentLocation);
    }

    /**
     * Displays add location fragment (called when user presses add button at bottom
     * of main view).
     */
    @Override
    public void onAddPress(){
        mainView.displayFragment(new AddFragment(this), false, "add_fragment");
    }

    /**
     * Displays search fragment.
     */
    @Override
    public void onSearchPress(){
        mainView.displayFragment(new SearchFragment(this), false, "search_fragment");
    }

    /**
     * Called when user adds a location. Either adds the location with no
     * crowd rating if no rating was provided, or adds the location and then
     * adds a rating to it.
     * @param crowdRating Rating provided by user
     * @param locationName Name of location to be added
     */
    @Override
    public void onAdded(int crowdRating, String locationName, IAddView view){
        if (crowdRating == 0) {
            locationsLibrary.addLocation(locationName);
        }
        else {
            locationsLibrary.addLocation(locationName)
                    .addRating(crowdRating);
        }
    }

    /**
     * Adds a rating to a location with a comment (called when user adds a rating).
     * Updates the crowd rating average for that location.
     * @param comment the comment attached to the rating
     * @param number rating number going to be added
     * @param view the view where the event originated
     */
    @Override
    public void addCommentRatingToLoc(Comment comment, int number, IAddRatingsView view) {
        currentLocation.addCommentRating(number, comment);
        currentLocation.updateRatingAve();
    }

    /**
     * Adds a rating with no comment and updates the average for the location.
     * @param number rating number going to be added
     * @param view the view where the event originated
     */
    @Override
    public void addRatingToLoc(int number, IAddRatingsView view) {
        currentLocation.addRating(number);
        currentLocation.updateRatingAve();
    }

    @Override
    public void completedRatings() {
    }

    public List<Location> getAllLocations(){
        return locationsLibrary.getLocations();
    }
}

