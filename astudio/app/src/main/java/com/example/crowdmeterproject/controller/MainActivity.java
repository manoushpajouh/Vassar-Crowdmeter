package com.example.crowdmeterproject.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.crowdmeterproject.view.AddFragment;
import com.example.crowdmeterproject.model.Location;
import com.example.crowdmeterproject.model.LocationsLibrary;
import com.example.crowdmeterproject.view.AddRatingFragment;
import com.example.crowdmeterproject.view.IAddRatingsView;
import com.example.crowdmeterproject.view.IAddView;
import com.example.crowdmeterproject.view.IMainView;
import com.example.crowdmeterproject.view.ISearchView;
import com.example.crowdmeterproject.view.MainView;
import com.example.crowdmeterproject.view.SearchFragment;

public class MainActivity extends AppCompatActivity implements
        ISearchView.Listener, IMainView.Listener, IAddView.Listener, IAddRatingsView.Listener {
    LocationsLibrary locationsLibrary = new LocationsLibrary();
    IMainView mainView;

    Location searchResult; // a location that has been successfully searched for by the user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainView = new MainView(this, this);

        mainView.displayFragment(new SearchFragment(this), false, "search_fragment");

        setContentView(mainView.getRootView());
    }

    @Override
    public void onSearched(String searchInput, ISearchView view) {
        searchResult = locationsLibrary.searchByName(searchInput);

        if (searchResult == null){
            view.displaySearchFailure();
        }
        else {
            view.displaySearchResult(searchResult);
        }
    }

    @Override
    public void onAddRatingPress(ISearchView view) {
        mainView.displayFragment(new AddRatingFragment(this), false, "addRatingFragment");

        setContentView(mainView.getRootView());
    }

    @Override
    public void onAddPress(){
        mainView.displayFragment(new AddFragment(this), false, "add_fragment");

        setContentView(mainView.getRootView());
    }

    @Override
    public void onSearchPress(){
        mainView.displayFragment(new SearchFragment(this), false, "search_fragment");

        setContentView(mainView.getRootView());
    }

    @Override
    public void onAdded(int crowdRating, String locationName, IAddView view){
        locationsLibrary.addLocation(locationName, crowdRating)
                .addRating(crowdRating);
    }

    @Override
    public void addCommentRatingToLoc(String comment, int number, IAddRatingsView view) {
        searchResult.addCommentRating(number, comment);
        searchResult.updateRatingAve();
    }

    @Override
    public void addRatingToLoc(int number, IAddRatingsView view) {
        searchResult.addRating(number);
        searchResult.updateRatingAve();
    }

    @Override
    public void completedRatings() {
    }
}

