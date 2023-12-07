package com.example.crowdmeterproject.view;

import android.view.View;

import com.example.crowdmeterproject.model.Location;

import java.util.List;

public interface ISearchView {

    public interface Listener {
        void onSearched(String searchInput, ISearchView view);
        void onViewLocationPress(ISearchView view, Location currentLocation);
        List<Location> getAllLocations();
    }

    public void displaySearchResults(List<Location> searchResults);
    public void displaySearchFailure();
}
