package com.example.crowdmeterproject.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.crowdmeterproject.R;
import com.example.crowdmeterproject.databinding.FragmentSearchBinding;
import com.example.crowdmeterproject.model.Location;

import java.util.List;

public class SearchFragment extends Fragment implements ISearchView {
    FragmentSearchBinding binding;
    Listener listener;

    public SearchFragment(@NonNull Listener listener){
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentSearchBinding.inflate(inflater);
        // Inflate the layout for this fragment
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.binding.searchLocsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Editable searchBarEditable = binding.searchBar.getText();
                String searchInput = searchBarEditable.toString();

                // notify the listener
                SearchFragment.this.listener.onSearched(searchInput, SearchFragment.this);

            }
        }
        );

        displaySearchResults(this.listener.getAllLocations());
    }

    @Override
    public void displaySearchResults(List<Location> searchResults) {

        // clear out the existing results display to make way for new locations
        while(this.binding.resultsDisplay.getChildCount() > 0){
            View nextChild = (this.binding.resultsDisplay).getChildAt(0);
            this.binding.resultsDisplay.removeView(nextChild);
        }

        for (Location location : searchResults){
            LinearLayout locationLayout = new LinearLayout(this.binding.getRoot().getContext());
            locationLayout.setOrientation(LinearLayout.HORIZONTAL);
            this.binding.resultsDisplay.addView(locationLayout);

            TextView locationNameText = new TextView(this.binding.getRoot().getContext());
            locationNameText.setText(location.toString());
            locationLayout.addView(locationNameText);

            Button addRatingButton = new Button(this.binding.getRoot().getContext());
            addRatingButton.setText(R.string.add_rating_button_label);
            locationLayout.addView(addRatingButton);

            addRatingButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    // notify the listener
                    SearchFragment.this.listener.onAddRatingPress(SearchFragment.this, location);
                }
            }
            );
        }
    }

    @Override
    public void displaySearchFailure() {
        TextView failureText = new TextView(this.binding.getRoot().getContext());
        failureText.setText("Your search did not match any locations");
        this.binding.resultsDisplay.addView(failureText);
    }
}