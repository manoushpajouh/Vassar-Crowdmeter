package com.example.crowdmeterproject.view;

import android.view.View;

import com.example.crowdmeterproject.model.Location;

public interface ISearchView {

    public interface Listener {
        void onSearched(String searchInput, ISearchView view);
    }

    public void displaySearchResult(Location searchResult);
    public void displaySearchFailure();
}
