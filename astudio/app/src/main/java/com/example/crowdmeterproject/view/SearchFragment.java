package com.example.crowdmeterproject.view;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.crowdmeterproject.R;
import com.example.crowdmeterproject.databinding.FragmentSearchBinding;
import com.example.crowdmeterproject.model.Location;
import com.google.android.material.button.MaterialButton;

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
            String color; // the color that corresponds to the average crowd rating

            if (location.getRatingAve() == 0){
                color = "#30999999";
            }
            else if (location.getRatingAve() < 1.5){
                color = "#304CAF50";
            }
            else if (location.getRatingAve() < 2.5){
                color = "#308BC34A";
            }
            else if (location.getRatingAve() < 3.5){
                color = "#30FFC73B";
            }
            else if (location.getRatingAve() < 4.5) {
                color = "#30FF9800";
            }
            else {
                color = "#30FF5722";
            }

            TableRow locationRow = new TableRow(this.binding.getRoot().getContext());
            locationRow.setBackgroundColor(Color.parseColor(color));
            this.binding.resultsDisplay.addView(locationRow);

            TextView locationNameText = new TextView(this.binding.getRoot().getContext());
            locationNameText.setText("   " + location.getName() + "         ");
            locationNameText.setTextSize(18);
            locationNameText.setTextColor(Color.parseColor("#000000"));
            locationRow.addView(locationNameText);

            MaterialButton viewLocationButton = new MaterialButton(this.binding.getRoot().getContext());
            viewLocationButton.setText(R.string.view_location_button_label);
            locationRow.addView(viewLocationButton);

            viewLocationButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    // notify the listener
                    SearchFragment.this.listener.onViewLocationPress(SearchFragment.this, location);
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